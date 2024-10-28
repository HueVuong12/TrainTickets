package gui;

import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import components.ComboBoxRenderer;
import components.ConTent_JPanel;
import components.RoundedButton;
import components.RoundedTextField;

import javax.swing.JRadioButton;

import dao.NhanVien_DAO;
import entity.Ca;
import entity.NhanVien;
import com.toedter.calendar.JDateChooser;

public class QuanLyNhanVien_GUI extends JPanel implements ActionListener,MouseListener{
	private static final long serialVersionUID = 1L;
	private JPanel jp_quayLai;
	private JPanel jp_headerThongTin;
	private JPanel jp_thongTinNV;
	private JPanel jp_contentThongTin;
	private JLabel lbl_ThoiGian;
	private JLabel goBackIconLabel;
	private JLabel lbl_quayLai;
	private JLabel lbl_MaNV;
	private JLabel lbl_HoTen;
	private JLabel lbl_GioiTinh;
	private JLabel lbl_NgaySinh;
	private JLabel lbl_CCCD;
	private JLabel lbl_SDT;
	private JLabel lbl_Email;
	private JLabel lbl_ChucVu;
	private JLabel lbl_Ca;
	private JLabel lbl_TrangThai;
	private JLabel lbl_tieuDeTT;
	private JLabel downIconLabel1;
	private RoundedTextField txtMNhnVin;
	private RoundedTextField txtHTn;
	private RoundedTextField txtCccd;
	private RoundedTextField txtSt;
	private RoundedTextField txtEmail;
	private RoundedTextField txtChcV;
	private JButton btnThem;
	private JButton btnTim;
	private JButton btnSua;
	private JTable table_NV;
	private JScrollPane scrollPane;
	private JRadioButton cb_nam;
	private JRadioButton cb_nu;
	private JRadioButton cb_dangLam;
	private JRadioButton cb_nghiLam;
	private NhanVien_DAO dsnv;
	private boolean isSearching = false; // Trạng thái nhấp chuột
	private Color hoverLabelColor = new Color(0, 153, 255);
	private DefaultTableModel model;
	private JComboBox<String> comboBox_Ca;
	private JDateChooser dateChooser_NgaySinh;
	private JComboBox<String> comboBox_TimTheoMaNV;

	public QuanLyNhanVien_GUI(TrangChu_GUI trangChu) {
		setBackground(SystemColor.text);
		setForeground(new Color(255, 255, 255));
		setBounds(0, 170, 1460, 570);
		setLayout(null);

		//JPanel quay lại
		jp_quayLai = new JPanel();
		jp_quayLai.setBackground(SystemColor.text);
		jp_quayLai.setBounds(10, 10, 124, 28);
		add(jp_quayLai);
		jp_quayLai.setLayout(null);

		//Icon Quay lại
		ImageIcon goBackIcon = new ImageIcon(getClass().getResource("/img/9054423_bx_arrow_back_icon.png"));
		Image scaledGoBack = goBackIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		goBackIconLabel = new JLabel(new ImageIcon(scaledGoBack));
		jp_quayLai.add(goBackIconLabel);
		goBackIconLabel.setBounds(10, 0, 39, 27);
		goBackIconLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ConTent_JPanel jpct = new ConTent_JPanel();
				trangChu.content.removeAll();
  				trangChu.content.add(jpct);
  				trangChu.content.revalidate();
  				trangChu.content.repaint();
				
			}
		});
		goBackIconLabel.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				goBackIconLabel.setForeground(hoverLabelColor); // Thay đổi màu khi đưa chuột vào

				// Đổi con trỏ chuột thành kiểu tay chỉ
				goBackIconLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent evt) {
				goBackIconLabel.setForeground(null); // Trở về màu mặc định khi chuột ra
				// Trả lại con trỏ chuột về mặc định
				goBackIconLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}}
				);


		//JLabel Quay lại
		lbl_quayLai = new JLabel("Quay lại");
		lbl_quayLai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_quayLai.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_quayLai.setBounds(45, 0, 69, 27);
		jp_quayLai.add(lbl_quayLai);

		//Icon xổ xuống
		ImageIcon downIcon = new ImageIcon(getClass().getResource("/img/Polygon_20.png"));
		Image scaledDown = downIcon.getImage().getScaledInstance(20 ,20, Image.SCALE_SMOOTH);

		//JPane thông tin nhân viên
		jp_thongTinNV = new JPanel();
		jp_thongTinNV.setBounds(10, 39, 327, 526);
		add(jp_thongTinNV);
		jp_thongTinNV.setLayout(null);

		//Icon xổ xuống
		ImageIcon downIcon1 = new ImageIcon(getClass().getResource("/img/Polygon_20.png"));
		Image scaledDown1 = downIcon1.getImage().getScaledInstance(20 ,20, Image.SCALE_SMOOTH); // Thay đổi kích thước logo

		jp_contentThongTin = new JPanel();
		jp_contentThongTin.setBounds(0, 31, 327, 495);
		jp_thongTinNV.add(jp_contentThongTin);
		jp_contentThongTin.setLayout(null);

		txtMNhnVin = new RoundedTextField(10);
//		txtMNhnVin = new JTextField();
		txtMNhnVin.setText("Mã nhân viên");
		txtMNhnVin.setBounds(129, 18, 188, 25);
		txtMNhnVin.setEditable(false);
		jp_contentThongTin.add(txtMNhnVin);
		txtMNhnVin.setColumns(10);
		focusTxtField(txtMNhnVin, "Mã nhân viên");

		txtHTn = new RoundedTextField(10);
//		txtHTn = new JTextField();
		txtHTn.setText("Họ tên");
		txtHTn.setColumns(10);
		txtHTn.setBounds(129, 66, 188, 25);
		jp_contentThongTin.add(txtHTn);
		focusTxtField(txtHTn, "Họ tên");

		txtCccd = new RoundedTextField(10);
//		txtCccd = new JTextField();
		txtCccd.setText("CCCD");
		txtCccd.setColumns(10);
		txtCccd.setBounds(129, 194, 188, 25);
		jp_contentThongTin.add(txtCccd);
		focusTxtField(txtCccd, "CCCD");

		txtSt = new RoundedTextField(10);
//		txtSt = new JTextField();
		txtSt.setText("SĐT");
		txtSt.setColumns(10);
		txtSt.setBounds(129, 244, 188, 25);
		jp_contentThongTin.add(txtSt);
		focusTxtField(txtSt, "SĐT");

		txtEmail = new RoundedTextField(10);
//		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setColumns(10);
		txtEmail.setBounds(129, 290, 188, 25);
		jp_contentThongTin.add(txtEmail);
		focusTxtField(txtEmail, "Email");
		
//		comboBox = new JComboBox();
//		comboBox.setBounds(347, 39, 185, 29);
//		jp_contentThongTin.add(comboBox);

		txtChcV = new RoundedTextField(10);
//		txtChcV = new JTextField();
		txtChcV.setText("Chức vụ");
		txtChcV.setColumns(10);
		txtChcV.setBounds(129, 336, 188, 25);
		jp_contentThongTin.add(txtChcV);
		focusTxtField(txtChcV, "Chức vụ");

		RoundedButton btnThem = new RoundedButton("Thêm", 10);
		btnThem.setForeground(new Color(255, 255, 255));
//		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(26, 458, 85, 27);
		btnThem.setBackground(new Color(51, 102, 153));
		jp_contentThongTin.add(btnThem);

		RoundedButton btnSua = new RoundedButton("Sửa", 15);
		btnSua.setForeground(new Color(255, 255, 255));
//		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSua.setBounds(126, 458, 85, 27);
		btnSua.setBackground(new Color(51, 102, 153));
		jp_contentThongTin.add(btnSua);

		lbl_MaNV = new JLabel("Mã nhân viên");
		lbl_MaNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MaNV.setBounds(10, 18, 101, 25);
		jp_contentThongTin.add(lbl_MaNV);

		lbl_HoTen = new JLabel("Họ tên");
		lbl_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_HoTen.setBounds(10, 64, 101, 25);
		jp_contentThongTin.add(lbl_HoTen);

		lbl_GioiTinh = new JLabel("Giới tính");
		lbl_GioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_GioiTinh.setBounds(10, 105, 101, 25);
		jp_contentThongTin.add(lbl_GioiTinh);

		lbl_NgaySinh = new JLabel("Ngày sinh");
		lbl_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_NgaySinh.setBounds(10, 149, 101, 25);
		jp_contentThongTin.add(lbl_NgaySinh);

		lbl_CCCD = new JLabel("CCCD");
		lbl_CCCD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_CCCD.setBounds(10, 194, 101, 25);
		jp_contentThongTin.add(lbl_CCCD);

		lbl_SDT = new JLabel("Số điện thoại");
		lbl_SDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_SDT.setBounds(10, 244, 101, 25);
		jp_contentThongTin.add(lbl_SDT);

		lbl_Email = new JLabel("Email");
		lbl_Email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Email.setBounds(10, 290, 101, 25);
		jp_contentThongTin.add(lbl_Email);

		lbl_ChucVu = new JLabel("Chức vụ");
		lbl_ChucVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_ChucVu.setBounds(10, 336, 101, 25);
		jp_contentThongTin.add(lbl_ChucVu);

		lbl_Ca = new JLabel("Ca");
		lbl_Ca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Ca.setBounds(10, 382, 101, 25);
		jp_contentThongTin.add(lbl_Ca);

		lbl_TrangThai = new JLabel("Trạng thái");
		lbl_TrangThai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TrangThai.setBounds(10, 417, 101, 25);
		jp_contentThongTin.add(lbl_TrangThai);

		cb_nam = new JRadioButton("Nam");
		cb_nam.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cb_nam.setToolTipText("");
		cb_nam.setBounds(129, 109, 52, 21);
		jp_contentThongTin.add(cb_nam);

		cb_nu = new JRadioButton("Nữ");
		cb_nu.setToolTipText("");
		cb_nu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cb_nu.setBounds(217, 109, 52, 21);
		jp_contentThongTin.add(cb_nu);

		// Tạo ButtonGroup để nhóm hai JRadioButton
		ButtonGroup group = new ButtonGroup();
		group.add(cb_nam);
		group.add(cb_nu);

		cb_dangLam = new JRadioButton("Đang làm");
		cb_dangLam.setToolTipText("");
		cb_dangLam.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cb_dangLam.setBounds(129, 421, 70, 21);
		jp_contentThongTin.add(cb_dangLam);

		cb_nghiLam = new JRadioButton("Nghỉ làm");
		cb_nghiLam.setToolTipText("");
		cb_nghiLam.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cb_nghiLam.setBounds(217, 421, 69, 21);
		jp_contentThongTin.add(cb_nghiLam);

		// Tạo ButtonGroup để nhóm hai JRadioButton
		ButtonGroup group1 = new ButtonGroup();
		group1.add(cb_dangLam);
		group1.add(cb_nghiLam);
		
		RoundedButton btnTim = new RoundedButton("Tìm", 10);
		btnTim.setForeground(new Color(255, 255, 255));
//		btnTim = new JButton("Tìm");
		btnTim.setBounds(232, 458, 85, 27);
		jp_contentThongTin.add(btnTim);
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTim.setBackground(new Color(51, 102, 153));
		btnTim.addActionListener(this);
		
		//JPane header tiêu đề của thông tin nhân viên
		jp_headerThongTin = new JPanel();
		jp_headerThongTin.setBounds(0, 0, 327, 32);
		jp_thongTinNV.add(jp_headerThongTin);
		jp_headerThongTin.setBackground(new Color(51, 102, 153));
		jp_headerThongTin.setLayout(null);
		//JLabel tiêu đề 
		lbl_tieuDeTT = new JLabel("Thông tin nhân viên");
		lbl_tieuDeTT.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tieuDeTT.setForeground(new Color(255, 255, 255));
		lbl_tieuDeTT.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_tieuDeTT.setBounds(10, 0, 153, 35);
		jp_headerThongTin.add(lbl_tieuDeTT);
		downIconLabel1 = new JLabel(new ImageIcon(scaledDown1));
		downIconLabel1.setBounds(287, 0, 30, 35);
		jp_headerThongTin.add(downIconLabel1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(347, 78, 1113, 487);
		add(scrollPane);

		table_NV = new JTable();
		scrollPane.setViewportView(table_NV);
		table_NV.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"STT", "Mã nhân viên", "Họ tên", "Ngày sinh","Giới tính", "Ca", "CCCD", "Email", "SĐT", "Trạng thái", "Chức vụ"
				}
				));
		table_NV.setRowHeight(25); // Set chiều cao hàng
		
		// Tạo JComboBox Hiển thị mã nhân viên 
		comboBox_TimTheoMaNV = new JComboBox<String>();
		comboBox_TimTheoMaNV.setBounds(347, 39, 155, 29);
		add(comboBox_TimTheoMaNV);
		// Thêm tiêu đề (placeholder) vào JComboBox
		comboBox_TimTheoMaNV.addItem("Tìm theo mã nhân viên"); // Tiêu đề mặc định
		comboBox_TimTheoMaNV.setSelectedIndex(0); // Đặt chỉ số lựa chọn mặc định là 0
		
		// Thêm các mã nhân viên thực tế vào JComboBox
		// Ví dụ:
		comboBox_TimTheoMaNV.addItem("NV001");
		comboBox_TimTheoMaNV.addItem("NV002");
		
		// Tạo JComboBox Ca trong JPanel thông tin nhân viên
		comboBox_Ca = new JComboBox<>();
		comboBox_Ca.setBounds(130, 382, 187, 25);
		comboBox_Ca.addItem("CA01");
		comboBox_Ca.addItem("CA02");
		comboBox_Ca.addItem("CA03");
		jp_contentThongTin.add(comboBox_Ca);
		
		dateChooser_NgaySinh = new JDateChooser();
		dateChooser_NgaySinh.setBounds(129, 149, 188, 25);
		jp_contentThongTin.add(dateChooser_NgaySinh);
		dateChooser_NgaySinh.setDateFormatString("dd/MM/yyyy");
		
		// Tạo JComboBox cho cột "Giới tính"
		JComboBox<String> comboBoxGioiTinh = new JComboBox<>();
		comboBoxGioiTinh.addItem("Nam");
		comboBoxGioiTinh.addItem("Nữ");
		
		// Lấy cột "Giới tính" từ bảng
		TableColumn gioiTinhColumn = table_NV.getColumnModel().getColumn(4); // 4 là chỉ số của cột "Gioi tính"
		// Thiết lập JComboBox làm editor cho cột "Giới tính"
		gioiTinhColumn.setCellEditor(new DefaultCellEditor(comboBoxGioiTinh));
		 // Thiết lập renderer cho cột để hiển thị JComboBox
        gioiTinhColumn.setCellRenderer(new ComboBoxRenderer(comboBoxGioiTinh));
        
        // Tạo JComboBox cho cột "Ca"
        JComboBox<String> comboBoxCa = new JComboBox<>();
        comboBoxCa.addItem("CA001");
        comboBoxCa.addItem("CA002");
        comboBoxCa.addItem("CA003");

        // Lấy cột "Ca" từ bảng
        TableColumn caColumn = table_NV.getColumnModel().getColumn(5); // 5 là chỉ số của cột "Ca"
        // Thiết lập JComboBox làm editor cho cột "Giới tính"
        caColumn.setCellEditor(new DefaultCellEditor(comboBoxCa));
        // Thiết lập renderer cho cột để hiển thị JComboBox
        caColumn.setCellRenderer(new ComboBoxRenderer(comboBoxCa));
		
		// Tạo JComboBox cho cột "Trạng Thái"
		JComboBox<String> comboBoxTrangThai = new JComboBox<>();
		comboBoxTrangThai.addItem("Đang làm");
		comboBoxTrangThai.addItem("Nghỉ việc");

		// Lấy cột "Trạng Thái" từ bảng
		TableColumn trangThaiColumn = table_NV.getColumnModel().getColumn(9); // 9 là chỉ số của cột "Trạng Thái"
		// Thiết lập JComboBox làm editor cho cột "Trạng Thái"
		trangThaiColumn.setCellEditor(new DefaultCellEditor(comboBoxTrangThai));
        // Thiết lập renderer cho cột để hiển thị JComboBox
        trangThaiColumn.setCellRenderer(new ComboBoxRenderer(comboBoxTrangThai));
        

		model = (DefaultTableModel) table_NV.getModel();
		//Thêm sự kiện table listener
		model.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				int row = e.getFirstRow();
				int column =e.getColumn();
				if(column == 4) {
					String newValue = (String) model.getValueAt(row, column);
					if(newValue.equalsIgnoreCase("Nam")) {
						cb_nam.setSelected(true);
					}else {
						cb_nu.setSelected(true);
					}
				}
				if(column == 5) {
					String newValue = (String) model.getValueAt(row, column);
					if(newValue.equalsIgnoreCase("CA001")) {
						comboBox_Ca.setSelectedIndex(0);
					}
					if(newValue.equalsIgnoreCase("CA002"))
					{
						comboBox_Ca.setSelectedIndex(1);
					}
					else {
						comboBox_Ca.setSelectedIndex(2);
					}
				}
				if(column == 9) {
					String newValue1 = (String) model.getValueAt(row, column);
					if(newValue1.equalsIgnoreCase("Đang Làm")) {
						cb_dangLam.setSelected(true);
					}else {
						cb_nghiLam.setSelected(true);
					}
				}
			}
		});
		//Thêm sự kiện cho các nút và bảng
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		table_NV.addMouseListener(this);
		cb_nam.addActionListener(this);
		cb_nu.addActionListener(this);
		cb_dangLam.addActionListener(this);
		cb_nghiLam.addActionListener(this);
		
		datatoTable();
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		dsnv= new NhanVien_DAO();
		if(o.equals(btnThem)) {
			if (validData()) {
				NhanVien nv = revertNV();
				if (nv != null) {
					// Kiểm tra xem nhân viên đã tồn tại hay chưa
					NhanVien existingNV = dsnv.getNhanVienTheoMaNV(nv.getMaNV());
					if (existingNV != null) {
						JOptionPane.showMessageDialog(this, "Nhân viên đã tồn tại trong cơ sở dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							dsnv.create(nv);	
							model.setRowCount(0);
							datatoTable();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(this, "Lỗi khi thêm nhân viên vào cơ sở dữ liệu: " + e1.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				deleteField();
			}
		}
//		if(o.equals(btnTim)) {
//			if (!isSearching) {
//				// Lần nhấp chuột đầu tiên - thực hiện tìm kiếm
//				search();
//				isSearching = true; // Đặt trạng thái thành true
//			} else {
//				// Lần nhấp chuột thứ hai - tải lại dữ liệu
//				model.setRowCount(0);
//				isSearching = false; // Đặt lại trạng thái thành false
//			}
//		}
		if(o.equals(btnSua)) {
			update();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table_NV.getSelectedRow();
		if (row != -1) {
			NhanVien nv = dsnv.getNhanVienTheoMaNV(table_NV.getModel().getValueAt(row, 1).toString());
			txtMNhnVin.setText(nv.getMaNV());
			txtHTn.setText(nv.getTenNV());
			if (nv.isGioiTinh()) {
				cb_nam.setSelected(false);
				cb_nu.setSelected(true);
			} else {
				cb_nam.setSelected(true);
				cb_nu.setSelected(false);
			}
			// Định dạng chuỗi ngày tháng từ giao diện (dd/MM/yyyy)
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dateChooser_NgaySinh.setToolTipText(inputFormatter.format(nv.getNgaySinh()));
			txtCccd.setText(nv.getCccd());
			txtSt.setText(nv.getSdt());
			txtEmail.setText(nv.getEmail());
			comboBox_Ca.setSelectedItem(nv.getCa().getMaCa());
			if (nv.isTrangThai()) {
				cb_dangLam.setSelected(true);
				cb_nghiLam.setSelected(false);
			} else {
				cb_dangLam.setSelected(false);
				cb_nghiLam.setSelected(true);
			}
			txtChcV.setText(String.valueOf(nv.getChucVu())); // Chuyển int thành String
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	//Hàm kiểm tra regex
	public boolean validData() {
		//		LocalDate inputNgaySinh = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		if (textField_TimMaNV.getText().equals("")) {
//			JOptionPane.showMessageDialog(this, "Mã nhân viên chưa nhập");
//			return false;
//		}
		if (txtHTn.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Họ tên không được để trống");
			return false;
		}
//		if (dateChooser_NgaySinh.getToolTipText().equals("")) {
//			JOptionPane.showMessageDialog(this, "Ngày sinh không được bỏ trống");
//			return false;
//		}
		if (!cb_dangLam.isSelected() && !cb_nghiLam.isSelected()) {
			JOptionPane.showMessageDialog(this, "Giới tính không được rỗng");
			return false;
		}
//		if (textField_Ca.getText().equals("")) {
//			JOptionPane.showMessageDialog(this, "Ca không được bỏ trống");
//			return false;
//		}
		if (txtCccd.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "CCCD không được bỏ trống");
			return false;
		}
		if (txtEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "CCCD không được bỏ trống");
			return false;
		}
		if (txtChcV.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "CCCD không được bỏ trống");
			return false;
		}
		if (txtSt.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "CCCD không được bỏ trống");
			return false;
		}
		if (txtSt.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "CCCD không được bỏ trống");
			return false;
		}
		if(!cb_nam.isSelected() && !cb_nu.isSelected()) {
			JOptionPane.showMessageDialog(this, "Chọn giới tính");
			return false;
		}

		return true;
	}

	//Hàm lấy dữ liệu từ JPane thông tin nhân viên
	public NhanVien revertNV() {
		String maNV = generateMaNV();
		String hoTen = txtHTn.getText();
		boolean gioiTinh = cb_nam.isSelected() ? false : (cb_nu.isSelected() ? true : null); // Sử dụng trực tiếp giá trị của checkbox
		String ca = comboBox_Ca.getSelectedItem().toString();
		String cccd = txtCccd.getText();

		// Định dạng chuỗi ngày tháng từ giao diện (dd/MM/yyyy)
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Định dạng chuỗi ngày tháng từ giao diện (dd/MM/yyyy)
	    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate ngaySinh = null;

	    try {
	        // Lấy ngày sinh từ JDateChooser
	        Date date = dateChooser_NgaySinh.getDate(); // Sử dụng getDate() để lấy giá trị ngày
	        if (date != null) {
	            // Chuyển đổi từ Date sang LocalDate
	            ngaySinh = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	        } else {
	            throw new IllegalArgumentException("Ngày sinh không được để trống.");
	        }

	        // Chuyển đổi LocalDate sang chuỗi định dạng SQL (yyyy-MM-dd)
	        String ngaySinhSQL = ngaySinh.format(outputFormatter);
	        // In ra kết quả
	        System.out.println("Ngày sinh SQL dạng chuỗi: " + ngaySinhSQL);
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Lỗi xảy ra khi chuyển đổi ngày sinh. Vui lòng thử lại.", "Lỗi",
	                JOptionPane.ERROR_MESSAGE);
	        return null;
	    }
	    
		String email = txtEmail.getText();
		String sdt = txtSt.getText();
		boolean trangThai = cb_dangLam.isSelected() ? true : (cb_nghiLam.isSelected() ? false : false);
		int chucVu =  Integer.parseInt(txtChcV.getText());

		NhanVien nv = new NhanVien(maNV, hoTen, ngaySinh, gioiTinh, new Ca(ca), cccd, email, sdt, trangThai, chucVu);
		return nv;
	}

	//Hàm sửa thông tin nhân viên
	public void update() {
		int index = table_NV.getSelectedRow();
		if (index != -1) {
			String maNV= txtMNhnVin.getText();
			String hoTen = txtHTn.getText();
			boolean gioiTinh = cb_nam.isSelected() ? false : (cb_nu.isSelected() ? true : null); // Sử dụng trực tiếp giá trị của checkbox
			String ca = comboBox_Ca.getSelectedItem().toString();
			String cccd = txtCccd.getText();

			// Định dạng chuỗi ngày tháng từ giao diện (dd/MM/yyyy)
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate ngaySinh=null;
			// Chuyển đổi chuỗi ngày sinh từ giao diện sang LocalDate
			ngaySinh = LocalDate.parse(dateChooser_NgaySinh.getToolTipText(), inputFormatter);	        
			String email = txtEmail.getText();
			String sdt = txtSt.getText();
			boolean trangThai = cb_dangLam.isSelected() ? true : (cb_nghiLam.isSelected() ? false : false);
			int chucVu =  Integer.parseInt(txtChcV.getText());
			NhanVien nv = new NhanVien(maNV, hoTen, ngaySinh, gioiTinh, new Ca(ca), cccd, email, sdt, trangThai, chucVu);
			try {
				dsnv.update(nv);
				model.setRowCount(0);
				// Load lại dữ liệu từ cơ sở dữ liệu vào bảng
				datatoTable();
				deleteField();
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Không tìm thấy.");
			}
		}else {
			JOptionPane.showMessageDialog(this, "Chọn nhân viên cần sửa.");
		}
		deleteField();
	}

//	// Hàm lọc nhân viên
//	private ArrayList<NhanVien> filter(String searchTerm) {
//		dsnv = new NhanVien_DAO();
//		ArrayList<NhanVien> list = dsnv.docTuBang(); // Lấy tất cả nhân viên
//		ArrayList<NhanVien> filteredList = new ArrayList<NhanVien>(); // Danh sách lưu nhân viên phù hợp
//
//		for (NhanVien nv : list) {
//			if (nv.getTenNV().toLowerCase().contains(searchTerm.toLowerCase())) {
//				filteredList.add(nv); // Thêm nhân viên vào danh sách lọc
//			}
//		}
//		return filteredList; // Trả về danh sách lọc
//	}

	
	
	//Hàm tìm kiếm nhân viên
	

	//Hàm tải dữ liệu vào bảng
	public void datatoTable() {
		dsnv = new NhanVien_DAO();
		ArrayList<NhanVien> list = dsnv.docTuBang();
		model = (DefaultTableModel) table_NV.getModel();
		model.setRowCount(0); // Xóa tất cả hàng trong bảng
		int stt = 1; // Biến đếm bắt đầu từ 1 cho STT
		for (NhanVien nv : list) {
			model.addRow(new Object[] { stt++, nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh(),nv.isGioiTinh()==true ?"Nữ" : "Nam",
					nv.getCa().getMaCa(), nv.getCccd(), nv.getEmail(), nv.getSdt(), nv.isTrangThai()==true?"Đang làm":"Nghỉ việc",nv.getChucVu() 
			});
		}
	}

	//Hàm tạo mã nhân viên tự động
	public String generateMaNV() {
		ArrayList<NhanVien> list = dsnv.docTuBang();
		int sl = 0;
		for (int i = 0; i < list.size(); i++) {
			sl++;
		}sl++;
		String maNV = String.format("NV%03d", sl);// Tạo mã với định dạng "NV" + 3 chữ số, ví dụ "NV001"
		return maNV;
	}

	//Hàm xóa thông tin 
	public void deleteField() {
		txtMNhnVin.setText("");
		txtHTn.setText("");
		dateChooser_NgaySinh.setToolTipText("");
		cb_nam.setSelected(false);
		cb_nu.setSelected(false);
		txtCccd.setText("");
		txtEmail.setText("");
		txtSt.setText("");
		txtChcV.setText("");
		comboBox_Ca.setSelectedIndex(0);
		cb_dangLam.setSelected(false);
		cb_nghiLam.setSelected(false);
	}
	private void focusTxtField(JTextField txtField, String str) {
		txtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtField.getText().equals(str)) {
					txtField.setText("");
					txtField.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtField.getText().isEmpty()) {
					txtField.setForeground(SystemColor.textInactiveText);
					txtField.setText(str);
				}
			}
		});
	}
}
