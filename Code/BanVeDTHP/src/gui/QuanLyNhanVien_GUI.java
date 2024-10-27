package gui;

import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;

import dao.NhanVien_DAO;
import entity.Ca;
import entity.NhanVien;

public class QuanLyNhanVien_GUI extends JPanel implements ActionListener,MouseListener{
	private static final long serialVersionUID = 1L;
	private JPanel jp_quayLai;
	private JPanel jp_timKiem;
	private JPanel jp_content;
	private JPanel jp_header;
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
	private JLabel lbl_tieuDeTK;
	private JLabel downIconLabel;
	private JTextField textField_TimMaNV;
	private JTextField textField_MaNV;
	private JTextField textField_HoTen;
	private JTextField textField_NgaySinh;
	private JTextField textField_CCCD;
	private JTextField textField_SDT;
	private JTextField textField_Email;
	private JTextField textField_ChucVu;
	private JTextField textField_Ca;
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
				jpct.setVisible(true);
				QuanLyNhanVien_GUI.this.setVisible(false);
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

		//JPane tìm kiếm
		jp_timKiem = new JPanel();
		jp_timKiem.setBackground(Color.WHITE);
		jp_timKiem.setBounds(300, 39, 1160, 81);
		add(jp_timKiem);
		jp_timKiem.setLayout(null);

		//Icon xổ xuống
		ImageIcon downIcon = new ImageIcon(getClass().getResource("/img/Polygon_20.png"));
		Image scaledDown = downIcon.getImage().getScaledInstance(20 ,20, Image.SCALE_SMOOTH); // Thay đổi kích thước logo

		//JPane chứa content
		jp_content = new JPanel();
		jp_content.setBackground(SystemColor.controlHighlight);
		jp_content.setBounds(0, 32, 1160, 49);
		jp_timKiem.add(jp_content);
		jp_content.setLayout(null);

		btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTim.setBounds(185, 8, 85, 27);
		jp_content.add(btnTim);

		textField_TimMaNV = new JTextField();
		textField_TimMaNV.setForeground(SystemColor.textInactiveText);
		textField_TimMaNV.setHorizontalAlignment(SwingConstants.LEFT);
		textField_TimMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_TimMaNV.setText("Theo mã nhân viên");
		textField_TimMaNV.setBounds(10, 8, 165, 27);
		jp_content.add(textField_TimMaNV);
		textField_TimMaNV.setColumns(10);
		
		//JPane header tiêu đề 
		jp_header = new JPanel();
		jp_header.setBounds(0, 0, 1160, 32);
		jp_timKiem.add(jp_header);
		jp_header.setBackground(new Color(51, 102, 153));
		jp_header.setLayout(null);
		//JLabel tiêu đề 
		lbl_tieuDeTK = new JLabel("Tìm kiếm");
		lbl_tieuDeTK.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tieuDeTK.setForeground(new Color(255, 255, 255));
		lbl_tieuDeTK.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_tieuDeTK.setBounds(0, 0, 95, 35);
		jp_header.add(lbl_tieuDeTK);
		downIconLabel = new JLabel(new ImageIcon(scaledDown));
		downIconLabel.setBounds(250, 0, 30, 35);
		jp_header.add(downIconLabel);
		// Thêm FocusListener để xử lý sự kiện khi người dùng nhấp vào JTextField
		textField_TimMaNV.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				// Khi JTextField được chọn, xóa nội dung mặc định
				if (textField_TimMaNV.getText().equals("Theo mã nhân viên")) {
					textField_TimMaNV.setText("");
					textField_TimMaNV.setForeground(Color.BLACK); // Đặt màu chữ về màu đen
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Khi JTextField không còn được chọn, nếu không có nội dung, đặt lại nội dung mặc định
				if (textField_TimMaNV.getText().isEmpty()) {
					textField_TimMaNV.setForeground(SystemColor.textInactiveText);
					textField_TimMaNV.setText("Theo mã nhân viên");
				}
			}
		});

		//JPane thông tin nhân viên
		jp_thongTinNV = new JPanel();
		jp_thongTinNV.setBounds(10, 39, 280, 526);
		add(jp_thongTinNV);
		jp_thongTinNV.setLayout(null);

		//Icon xổ xuống
		ImageIcon downIcon1 = new ImageIcon(getClass().getResource("/img/Polygon_20.png"));
		Image scaledDown1 = downIcon1.getImage().getScaledInstance(20 ,20, Image.SCALE_SMOOTH); // Thay đổi kích thước logo

		jp_contentThongTin = new JPanel();
		jp_contentThongTin.setBounds(0, 31, 280, 489);
		jp_thongTinNV.add(jp_contentThongTin);
		jp_contentThongTin.setLayout(null);

		textField_MaNV = new JTextField();
		textField_MaNV.setBounds(129, 18, 141, 25);
		textField_MaNV.setEditable(false);
		jp_contentThongTin.add(textField_MaNV);
		textField_MaNV.setColumns(10);

		textField_HoTen = new JTextField();
		textField_HoTen.setColumns(10);
		textField_HoTen.setBounds(129, 63, 141, 25);
		jp_contentThongTin.add(textField_HoTen);

		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(129, 133, 141, 25);
		jp_contentThongTin.add(textField_NgaySinh);

		textField_CCCD = new JTextField();
		textField_CCCD.setColumns(10);
		textField_CCCD.setBounds(129, 178, 141, 25);
		jp_contentThongTin.add(textField_CCCD);

		textField_SDT = new JTextField();
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(129, 228, 141, 25);
		jp_contentThongTin.add(textField_SDT);

		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(129, 274, 141, 25);
		jp_contentThongTin.add(textField_Email);

		textField_ChucVu = new JTextField();
		textField_ChucVu.setColumns(10);
		textField_ChucVu.setBounds(129, 320, 141, 25);
		jp_contentThongTin.add(textField_ChucVu);

		textField_Ca = new JTextField();
		textField_Ca.setColumns(10);
		textField_Ca.setBounds(129, 366, 141, 25);
		jp_contentThongTin.add(textField_Ca);

		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(41, 452, 85, 27);
		jp_contentThongTin.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSua.setBounds(168, 452, 85, 27);
		jp_contentThongTin.add(btnSua);

		lbl_MaNV = new JLabel("Mã nhân viên");
		lbl_MaNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MaNV.setBounds(10, 18, 101, 25);
		jp_contentThongTin.add(lbl_MaNV);

		lbl_HoTen = new JLabel("Họ tên");
		lbl_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_HoTen.setBounds(10, 63, 101, 25);
		jp_contentThongTin.add(lbl_HoTen);

		lbl_GioiTinh = new JLabel("Giới tính");
		lbl_GioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_GioiTinh.setBounds(10, 98, 101, 25);
		jp_contentThongTin.add(lbl_GioiTinh);

		lbl_NgaySinh = new JLabel("Ngày sinh");
		lbl_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_NgaySinh.setBounds(10, 133, 101, 25);
		jp_contentThongTin.add(lbl_NgaySinh);

		lbl_CCCD = new JLabel("CCCD");
		lbl_CCCD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_CCCD.setBounds(10, 178, 101, 25);
		jp_contentThongTin.add(lbl_CCCD);

		lbl_SDT = new JLabel("Số điện thoại");
		lbl_SDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_SDT.setBounds(10, 228, 101, 25);
		jp_contentThongTin.add(lbl_SDT);

		lbl_Email = new JLabel("Email");
		lbl_Email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Email.setBounds(10, 274, 101, 25);
		jp_contentThongTin.add(lbl_Email);

		lbl_ChucVu = new JLabel("Chức vụ");
		lbl_ChucVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_ChucVu.setBounds(10, 320, 101, 25);
		jp_contentThongTin.add(lbl_ChucVu);

		lbl_Ca = new JLabel("Ca");
		lbl_Ca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Ca.setBounds(10, 366, 101, 25);
		jp_contentThongTin.add(lbl_Ca);

		lbl_TrangThai = new JLabel("Trạng thái");
		lbl_TrangThai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_TrangThai.setBounds(14, 401, 101, 25);
		jp_contentThongTin.add(lbl_TrangThai);

		cb_nam = new JRadioButton("Nam");
		cb_nam.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cb_nam.setToolTipText("");
		cb_nam.setBounds(129, 101, 52, 21);
		jp_contentThongTin.add(cb_nam);

		cb_nu = new JRadioButton("Nữ");
		cb_nu.setToolTipText("");
		cb_nu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cb_nu.setBounds(194, 101, 52, 21);
		jp_contentThongTin.add(cb_nu);

		// Tạo ButtonGroup để nhóm hai JRadioButton
		ButtonGroup group = new ButtonGroup();
		group.add(cb_nam);
		group.add(cb_nu);

		cb_dangLam = new JRadioButton("Đang làm");
		cb_dangLam.setToolTipText("");
		cb_dangLam.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cb_dangLam.setBounds(133, 409, 70, 21);
		jp_contentThongTin.add(cb_dangLam);

		cb_nghiLam = new JRadioButton("Nghỉ làm");
		cb_nghiLam.setToolTipText("");
		cb_nghiLam.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cb_nghiLam.setBounds(205, 409, 69, 21);
		jp_contentThongTin.add(cb_nghiLam);

		// Tạo ButtonGroup để nhóm hai JRadioButton
		ButtonGroup group1 = new ButtonGroup();
		group1.add(cb_dangLam);
		group1.add(cb_nghiLam);
		
		//JPane header tiêu đề của thông tin nhân viên
		jp_headerThongTin = new JPanel();
		jp_headerThongTin.setBounds(0, 0, 280, 32);
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
		downIconLabel1.setBounds(250, 0, 30, 35);
		jp_headerThongTin.add(downIconLabel1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 130, 1160, 435);
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


		//Thêm sự kiện cho các nút và bảng
		btnThem.addActionListener(this);
		btnTim.addActionListener(this);
		btnSua.addActionListener(this);
		table_NV.addMouseListener(this);
		cb_nam.addActionListener(this);
		cb_nu.addActionListener(this);
		cb_dangLam.addActionListener(this);
		cb_nghiLam.addActionListener(this);
		datatoTable();
		//		textField_TimMaNV.addKeyListener((KeyListener) new KeyAdapter() {
		//			@Override
		//			public void keyReleased(KeyEvent e) {
		//				String searchTerm = textField_TimMaNV.getText(); // Lấy từ khóa tìm kiếm
		//				ArrayList<NhanVien> filteredEmployees = filter(searchTerm); // Lọc nhân viên
		//				datatoTable(); // Tải dữ liệu vào bảng
		//			}
		//		});
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
		if(o.equals(btnTim)) {
			if (!isSearching) {
				// Lần nhấp chuột đầu tiên - thực hiện tìm kiếm
				search();
				isSearching = true; // Đặt trạng thái thành true
			} else {
				// Lần nhấp chuột thứ hai - tải lại dữ liệu
				datatoTable();
				isSearching = false; // Đặt lại trạng thái thành false
			}
		}
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
			textField_MaNV.setText(nv.getMaNV());
			textField_HoTen.setText(nv.getTenNV());
			if (nv.isGioiTinh()) {
				cb_nam.setSelected(false);
				cb_nu.setSelected(true);
			} else {
				cb_nam.setSelected(true);
				cb_nu.setSelected(false);
			}
			// Định dạng chuỗi ngày tháng từ giao diện (dd/MM/yyyy)
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			textField_NgaySinh.setText(inputFormatter.format(nv.getNgaySinh()));
			textField_CCCD.setText(nv.getCccd());
			textField_SDT.setText(nv.getSdt());
			textField_Email.setText(nv.getEmail());
			textField_Ca.setText(nv.getCa().getMaCa());
			if (nv.isTrangThai()) {
				cb_dangLam.setSelected(true);
				cb_nghiLam.setSelected(false);
			} else {
				cb_dangLam.setSelected(false);
				cb_nghiLam.setSelected(true);
			}
			textField_ChucVu.setText(String.valueOf(nv.getChucVu())); // Chuyển int thành String
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
		if (textField_TimMaNV.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Họ tên không được để trống");
			return false;
		}
		if (textField_HoTen.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Họ tên không được để trống");
			return false;
		}
		if (textField_NgaySinh.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Ngày sinh không được bỏ trống");
			return false;
		}
		if (!cb_dangLam.isSelected() && !cb_nghiLam.isSelected()) {
			JOptionPane.showMessageDialog(this, "Giới tính không được rỗng");
			return false;
		}
		if (textField_Ca.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Ca không được bỏ trống");
			return false;
		}
		if (textField_CCCD.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "CCCD không được bỏ trống");
			return false;
		}
		if (textField_Email.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "CCCD không được bỏ trống");
			return false;
		}
		if (textField_ChucVu.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "CCCD không được bỏ trống");
			return false;
		}
		if (textField_SDT.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "CCCD không được bỏ trống");
			return false;
		}
		if (textField_SDT.getText().equals("")) {
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
		String hoTen = textField_HoTen.getText();
		boolean gioiTinh = cb_nam.isSelected() ? false : (cb_nu.isSelected() ? true : null); // Sử dụng trực tiếp giá trị của checkbox
		String ca = textField_Ca.getText();
		String cccd = textField_CCCD.getText();

		// Định dạng chuỗi ngày tháng từ giao diện (dd/MM/yyyy)
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Định dạng ngày tháng SQL (yyyy-MM-dd)
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate ngaySinh=null;
		try {
			// Chuyển đổi chuỗi ngày sinh từ giao diện sang LocalDate
			ngaySinh = LocalDate.parse(textField_NgaySinh.getText(), inputFormatter);	        
			// Chuyển đổi LocalDate sang chuỗi định dạng SQL (yyyy-MM-dd)
			String ngaySinhSQL = ngaySinh.format(outputFormatter);	        
			// Chuyển LocalDate thành SQL Date để lưu vào cơ sở dữ liệu
			Date ngaySinhDateSQL = Date.valueOf(ngaySinh); // Sử dụng java.sql.Date
			// In ra kết quả
			System.out.println("Ngày sinh SQL dạng chuỗi: " + ngaySinhSQL);
			System.out.println("Ngày sinh SQL dạng Date: " + ngaySinhDateSQL);

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Lỗi xảy ra khi chuyển đổi ngày sinh. Vui lòng thử lại.", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
		String email = textField_Email.getText();
		String sdt = textField_SDT.getText();
		boolean trangThai = cb_dangLam.isSelected() ? true : (cb_nghiLam.isSelected() ? false : false);
		int chucVu =  Integer.parseInt(textField_ChucVu.getText());

		NhanVien nv = new NhanVien(maNV, hoTen, ngaySinh, gioiTinh, new Ca(ca), cccd, email, sdt, trangThai, chucVu);
		return nv;
	}

	//Hàm sửa thông tin nhân viên
	public void update() {
		int index = table_NV.getSelectedRow();
		if (index != -1) {
			String maNV= textField_MaNV.getText();
			String hoTen = textField_HoTen.getText();
			boolean gioiTinh = cb_nam.isSelected() ? false : (cb_nu.isSelected() ? true : null); // Sử dụng trực tiếp giá trị của checkbox
			String ca = textField_Ca.getText();
			String cccd = textField_CCCD.getText();

			// Định dạng chuỗi ngày tháng từ giao diện (dd/MM/yyyy)
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate ngaySinh=null;
			// Chuyển đổi chuỗi ngày sinh từ giao diện sang LocalDate
			ngaySinh = LocalDate.parse(textField_NgaySinh.getText(), inputFormatter);	        
			String email = textField_Email.getText();
			String sdt = textField_SDT.getText();
			boolean trangThai = cb_dangLam.isSelected() ? true : (cb_nghiLam.isSelected() ? false : false);
			int chucVu =  Integer.parseInt(textField_ChucVu.getText());
			NhanVien nv = new NhanVien(maNV, hoTen, ngaySinh, gioiTinh, new Ca(ca), cccd, email, sdt, trangThai, chucVu);
			try {
				dsnv.update(nv);
				model.setRowCount(0);
				// Load lại dữ liệu từ cơ sở dữ liệu vào bảng
				datatoTable();
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
	//	    dsnv = new NhanVien_DAO();
	//	    ArrayList<NhanVien> list = dsnv.docTuBang(); // Lấy tất cả nhân viên
	//	    ArrayList<NhanVien> filteredList = new ArrayList<NhanVien>(); // Danh sách lưu nhân viên phù hợp
	//
	//	    for (NhanVien nv : list) {
	//	        if (nv.getTenNV().toLowerCase().contains(searchTerm.toLowerCase())) {
	//	            filteredList.add(nv); // Thêm nhân viên vào danh sách lọc
	//	        }
	//	    }
	//
	//	    return filteredList; // Trả về danh sách lọc
	//	}

	//Hàm tìm kiếm nhân viên
	public void search() {
		if (validData()) {
			String maNV= textField_TimMaNV.getText();
			NhanVien nv = dsnv.getNhanVienTheoMaNV(maNV);
			int stt = 1;
			if (nv != null) { // Kiểm tra xem đối tượng SanPham có null không trước khi thêm vào bảng
				model.setRowCount(0);
				model.addRow(new Object[] { stt++, nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh(),nv.isGioiTinh()==true ?"Nữ" : "Nam",
						nv.getCa().getMaCa(), nv.getCccd(), nv.getEmail(), nv.getSdt(), nv.isTrangThai()==true?"Đang làm":"Nghỉ việc",nv.getChucVu() 
				});
			}
		}else {
			JOptionPane.showMessageDialog(this, "Nhập mã nhân viên cần tìm.");
		}
	}

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
		textField_MaNV.setText("");
		textField_HoTen.setText("");
		textField_NgaySinh.setText("");
		cb_nam.setSelected(false);
		cb_nu.setSelected(false);
		textField_CCCD.setText("");
		textField_Email.setText("");
		textField_SDT.setText("");
		textField_ChucVu.setText("");
		textField_Ca.setText("");
		cb_dangLam.setSelected(false);
		cb_nghiLam.setSelected(false);
	}

	//Hàm lấy thời gian thực
	public void updateTime() {
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		lbl_ThoiGian.setText(formattedTime);
	}
}
