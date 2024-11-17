package gui;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.RowFilter.Entry;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import components.ComboBoxRenderer;
import components.RoundedButton;
import dao.NhanVien_DAO;
import entity.Ca;
import entity.NhanVien;

public class TraCuuNhanVien_GUI extends JPanel implements ActionListener,MouseListener{
	
	private JTextField txt_MaNV;
	private JTextField txt_HoTen;
	private JTextField txt_GioiTinh;
	private JTextField txt_SDT;
	private JTextField txt_Email;
	private JTextField txt_ChucVu;
	private JTextField txt_Ca;
	private JTable table;
	private JRadioButton cb_nam;
	private JRadioButton cb_nu;
	private JComboBox<String> comboBox_Ca;
	private JComboBox<String> comboBox_ChucVu;
	private JComboBox<String> comboBoxGioiTinh;
	private DefaultTableModel model;
	private NhanVien_DAO dsnv = new NhanVien_DAO();
	private TableRowSorter<TableModel> sorter;
	private JDateChooser dateChooser_NgaySinh;
	private JButton btnTim;
	public TraCuuNhanVien_GUI(TrangChu_GUI trangChu) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 284, 557);
		add(panel);
		panel.setLayout(null);
		
		JLabel lb_MaNV = new JLabel("Mã nhân viên");
		lb_MaNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_MaNV.setBounds(22, 82, 111, 27);
		panel.add(lb_MaNV);
		
		txt_MaNV = new JTextField();
		txt_MaNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_MaNV.setText("Mã nhân viên");
		txt_MaNV.setBounds(22, 108, 239, 27);
//		focusTxtField(textField_PhanQuyen, "Phân quyền");
		panel.add(txt_MaNV);
		txt_MaNV.setColumns(10);
		
		JLabel lb_HoTen = new JLabel("Họ tên:");
		lb_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_HoTen.setBounds(22, 146, 111, 27);
		panel.add(lb_HoTen);
		
		txt_HoTen = new JTextField();
		txt_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_HoTen.setText("Họ tên");
		txt_HoTen.setColumns(10);
		txt_HoTen.setBounds(22, 170, 239, 27);
		panel.add(txt_HoTen);
		
		JLabel lb_GioiTinh = new JLabel("Giới tính:");
		lb_GioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_GioiTinh.setBounds(22, 207, 74, 21);
		panel.add(lb_GioiTinh);
		
		cb_nam = new JRadioButton("Nam");
		cb_nam.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cb_nam.setToolTipText("");
		cb_nam.setBounds(22, 232, 52, 21);
		panel.add(cb_nam);

		cb_nu = new JRadioButton("Nữ");
		cb_nu.setToolTipText("");
		cb_nu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cb_nu.setBounds(110, 232, 52, 21);
		panel.add(cb_nu);
		
		// Tạo ButtonGroup để nhóm hai JRadioButton
		ButtonGroup group = new ButtonGroup();
		group.add(cb_nam);
		group.add(cb_nu);
		
		JLabel lb_SDT = new JLabel("Số điện thoại:");
		lb_SDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_SDT.setBounds(22, 269, 111, 27);
		panel.add(lb_SDT);
		
		txt_SDT = new JTextField();
		txt_SDT.setText("Số điện thoại");
		txt_SDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_SDT.setColumns(10);
		txt_SDT.setBounds(22, 293, 237, 27);
		panel.add(txt_SDT);
		
		JLabel lb_Email = new JLabel("Email:");
		lb_Email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_Email.setBounds(22, 330, 88, 27);
		panel.add(lb_Email);
		
		txt_Email = new JTextField();
		txt_Email.setText("Email");
		txt_Email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_Email.setColumns(10);
		txt_Email.setBounds(22, 354, 237, 27);
		panel.add(txt_Email);
		
		JLabel lb_ChucVu = new JLabel("Chức vụ");
		lb_ChucVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_ChucVu.setBounds(22, 391, 88, 27);
		panel.add(lb_ChucVu);
		
		comboBox_ChucVu = new JComboBox<String>();
		comboBox_ChucVu.setBounds(22, 420, 237, 27);
		comboBox_ChucVu.addItem("Quản lý");
		comboBox_ChucVu.addItem("Nhân viên");
		panel.add(comboBox_ChucVu);
		
		JLabel lb_Ca = new JLabel("Ca:");
		lb_Ca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_Ca.setBounds(22, 457, 74, 21);
		panel.add(lb_Ca);
		
		// Tạo JComboBox Ca trong JPanel thông tin nhân viên
		comboBox_Ca = new JComboBox<>();
		comboBox_Ca.setBounds(22, 477, 237, 27);
		comboBox_Ca.addItem("CA01");
		comboBox_Ca.addItem("CA02");
		comboBox_Ca.addItem("CA03");
		panel.add(comboBox_Ca);
		
		dateChooser_NgaySinh = new JDateChooser();
//		dateChooser_NgaySinh.setBounds(129, 149, 188, 25);
//		panel.add(dateChooser_NgaySinh);
		dateChooser_NgaySinh.setDateFormatString("dd/MM/yyyy");
		
//		btnTim = new JButton("Tìm");
		btnTim = new RoundedButton("Tìm", 15);
		btnTim.setForeground(new Color(255, 255, 255));
		btnTim.setBackground(new Color(51, 102, 153));
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setBounds(93, 514, 90, 33);
		panel.add(btnTim);
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_top = new JPanel();
		panel_top.setBounds(0, 0, 283, 54);
		panel.add(panel_top);
		panel_top.setBackground(new Color(51, 102, 153));
		panel_top.setLayout(null);
		JLabel lblThongTinNhanVien = new JLabel("Thông tin nhân viên");
		lblThongTinNhanVien.setBounds(0, 0, 283, 52);
		panel_top.add(lblThongTinNhanVien);
		lblThongTinNhanVien.setBackground(new Color(51, 102, 153));
		lblThongTinNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinNhanVien.setForeground(new Color(255, 255, 255));
		lblThongTinNhanVien.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(304, 10, 1126, 557);
		add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"STT", "Mã nhân viên", "Họ tên", "Ngày sinh","Giới tính", "Ca", "CCCD", "Email", "SĐT", "Trạng thái", "Chức vụ"
				}
				);
		sorter = new TableRowSorter<>(model);
		table.setRowSorter(sorter);
		table.setModel(model);
		scrollPane.setViewportView(table);
		table.setRowHeight(25); // Set chiều cao hàng
		
		// Tạo JComboBox cho cột "Giới tính"
		comboBoxGioiTinh = new JComboBox<>();
		comboBoxGioiTinh.addItem("Nam");
		comboBoxGioiTinh.addItem("Nữ");
		
		// Lấy cột "Giới tính" từ bảng
		TableColumn gioiTinhColumn = table.getColumnModel().getColumn(4); // 4 là chỉ số của cột "Gioi tính"
		// Thiết lập JComboBox làm editor cho cột "Giới tính"
		gioiTinhColumn.setCellEditor(new DefaultCellEditor(comboBoxGioiTinh));
		// Thiết lập renderer cho cột để hiển thị JComboBox
		gioiTinhColumn.setCellRenderer(new ComboBoxRenderer(comboBoxGioiTinh));
		
		// Tạo JComboBox cho cột "Ca"
		JComboBox<String> comboBoxCa = new JComboBox<>();
		comboBoxCa.addItem("CA01");
		comboBoxCa.addItem("CA02");
		comboBoxCa.addItem("CA03");

		// Lấy cột "Ca" từ bảng
		TableColumn caColumn = table.getColumnModel().getColumn(5); // 5 là chỉ số của cột "Ca"
		// Thiết lập JComboBox làm editor cho cột "Giới tính"
		caColumn.setCellEditor(new DefaultCellEditor(comboBoxCa));
		// Thiết lập renderer cho cột để hiển thị JComboBox
		caColumn.setCellRenderer(new ComboBoxRenderer(comboBoxCa));

		// Tạo JComboBox cho cột "Trạng Thái"
		JComboBox<String> comboBoxTrangThai = new JComboBox<>();
		comboBoxTrangThai.addItem("Đang làm");
		comboBoxTrangThai.addItem("Nghỉ làm");
		
		// Lấy cột "Trạng Thái" từ bảng
		TableColumn trangThaiColumn = table.getColumnModel().getColumn(9); // 9 là chỉ số của cột "Trạng Thái"
		// Thiết lập JComboBox làm editor cho cột "Trạng Thái"
		trangThaiColumn.setCellEditor(new DefaultCellEditor(comboBoxTrangThai));
		// Thiết lập renderer cho cột để hiển thị JComboBox
		trangThaiColumn.setCellRenderer(new ComboBoxRenderer(comboBoxTrangThai));
				
		// Tạo JComboBox cho cột "Chức vụ"
		JComboBox<String> comboBoxChucVu = new JComboBox<>();
		comboBoxChucVu.addItem("Quản lý");
		comboBoxChucVu.addItem("Nhân viên");

		// Lấy cột "Chức vụ" từ bảng
		TableColumn chucVuColumn = table.getColumnModel().getColumn(10); // 10 là chỉ số của cột "Chức vụ"
		// Thiết lập JComboBox làm editor cho cột "Trạng Thái"
		chucVuColumn.setCellEditor(new DefaultCellEditor(comboBoxChucVu));
		// Thiết lập renderer cho cột để hiển thị JComboBox
		chucVuColumn.setCellRenderer(new ComboBoxRenderer(comboBoxChucVu));
		
		//Thêm sự kiện table listener
		model.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				int row = e.getFirstRow();
				int column =e.getColumn();
				if(column == 4) {
					String newValue = (String) table.getValueAt(row, column);
					if(newValue.equalsIgnoreCase("Nam")) {
						cb_nam.setSelected(true);
					}else {
						cb_nu.setSelected(true);
					}
				}
				if(column == 5) {
					String newValue = (String) table.getValueAt(row, column);
					if(newValue.equalsIgnoreCase("CA01")) {
						comboBox_Ca.setSelectedIndex(0);
					}
					if(newValue.equalsIgnoreCase("CA02"))
					{
						comboBox_Ca.setSelectedIndex(1);
					}
					if(newValue.equalsIgnoreCase("CA03")) {
						comboBox_Ca.setSelectedIndex(2);
					}
				}
				if(column == 10) {
					String newValue = (String) table.getValueAt(row, column);
					if(newValue.equalsIgnoreCase("Quản lý")) {
						comboBox_ChucVu.setSelectedIndex(0);
					}
					else
					{
						comboBox_ChucVu.setSelectedIndex(1);
					}
				}
			}
		});
		table.addMouseListener(this);
		cb_nam.addActionListener(this);
		cb_nu.addActionListener(this);
		btnTim.addActionListener(this);
		datatoTable();
		
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
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		System.out.println(row);
		if (row != -1) {	
			NhanVien nv = dsnv.getNhanVienTheoMaNV(table.getValueAt(row, 1).toString());
			System.out.println(table.getValueAt(row, 1).toString());
			txt_MaNV.setText(nv.getMaNV());
			txt_HoTen.setText(nv.getTenNV());
			if (nv.isGioiTinh()) {
				cb_nam.setSelected(false);
				cb_nu.setSelected(true);
			} else {
				cb_nam.setSelected(true);
				cb_nu.setSelected(false);
			}
			dateChooser_NgaySinh.setDate(Date.from(nv.getNgaySinh().atStartOfDay(ZoneId.systemDefault()).toInstant()));
			txt_SDT.setText(nv.getSdt());
			txt_Email.setText(nv.getEmail());
			comboBox_Ca.setSelectedItem(nv.getCa().getMaCa());
			if(nv.getChucVu() == 1) {
				comboBox_ChucVu.setSelectedIndex(0);
			}
			else {
				comboBox_ChucVu.setSelectedIndex(1);
			}
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		dsnv.reset();
		if(o.equals(btnTim)) {
			if(validData()) {
				if(txt_MaNV.getText() != null) {
					filterRows();
					
				}
				if(txt_HoTen.getText() != null) {
					filterRows();
					
				}
				
				if(txt_Email.getText() != null) {
					filterRows();
					
				}

				if(cb_nam.isSelected() ) {
					filterRows();
					
				}else if(cb_nu.isSelected()) {
					filterRows();
					
				}
				
				if(txt_SDT.getText() != null) {
					filterRows();
					
				}
				deleteField();
			}
		}
	}
	//Hàm tải dữ liệu vào bảng
	public void datatoTable() {
		dsnv.reset();
		ArrayList<NhanVien> list = dsnv.docTuBang();
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Xóa tất cả hàng trong bảng
		int stt = 1; // Biến đếm bắt đầu từ 1 cho STT
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (NhanVien nv : list) {
//			comboBox_TimTheoMaNV.addItem(nv.getMaNV());
			model.addRow(new Object[] { stt++, nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh().format(formatter),nv.isGioiTinh()==true ?"Nữ" : "Nam",
					nv.getCa().getMaCa(), nv.getCccd(), nv.getEmail(), nv.getSdt(),  nv.isTrangThai() ? "Đang làm" : "Nghỉ làm", nv.getChucVu() == 1 ? "Quản lý" : "Nhân viên"

			});
		}
		//Mặc định các button và combobox trong thông tin nhân viên
		deleteField();	
	}
	//Hàm xóa thông tin 
	public void deleteField() {
		txt_MaNV.setText("");
		txt_HoTen.setText("");
//		dateChooser_NgaySinh.setDate(null);  // Đặt lại giá trị ngày thành null
		cb_nam.setSelected(false);
		cb_nu.setSelected(false);
//		txt_CCCD.setText("");
		txt_Email.setText("");
		txt_SDT.setText("");
		comboBox_ChucVu.setSelectedItem(null);
		comboBox_Ca.setSelectedItem(null);
//		cb_dangLam.setSelected(false);
//		cb_nghiLam.setSelected(false);
	}
	private void filterRows() {
		
		ArrayList<RowFilter<Object, Object>> filters = new ArrayList<>();
		
		String maNV = txt_MaNV.getText().trim();
		String hoTen = txt_HoTen.getText().trim();
		String email = txt_Email.getText().trim();
		String ca = comboBox_Ca.getSelectedItem() != null ? comboBox_Ca.getSelectedItem().toString().trim() : "";
		String chucVu = comboBox_ChucVu.getSelectedItem() != null ? comboBox_ChucVu.getSelectedItem().toString().trim() : "";
		// Để `gioiTinh` không có giá trị null
		boolean gioiTinh = cb_nam.isSelected(); // true nếu chọn nam, false nếu chọn nữ
		
		// Lọc theo các điều kiện
		if (!maNV.isEmpty()) {
			filters.add(RowFilter.regexFilter("(?i)" + maNV, 1));
		}
		if (!hoTen.isEmpty()) {
			filters.add(RowFilter.regexFilter("(?i)" + hoTen, 2));
		}
		if (!email.isEmpty()) {
			filters.add(RowFilter.regexFilter("(?i)" + email, 7));
		}
		if (!ca.isEmpty()) {
			filters.add(RowFilter.regexFilter(ca, 5));
		}
		if (!chucVu.isEmpty()) {
			filters.add(RowFilter.regexFilter(chucVu, 10));
		}

		// Giới tính
		if (cb_nam.isSelected() || cb_nu.isSelected()) {
			String gioiTinhText = gioiTinh ? "Nam" : "Nữ";
			filters.add(RowFilter.regexFilter(gioiTinhText, 4));
		}
		
		// Cập nhật bộ lọc
		if (filters.isEmpty()) {
			sorter.setRowFilter(null); // Nếu không có bộ lọc nào, xóa bộ lọc
		} else {
			sorter.setRowFilter(RowFilter.andFilter(filters));
		}
		
	}

	//Hàm kiểm tra regex
	public boolean validData() {
		if (txt_MaNV.getText().equals("") && txt_HoTen.getText().equals("") && txt_SDT.getText().equals("") && (!cb_nam.isSelected() && !cb_nu.isSelected()) && txt_Email.getText().equals("") && comboBox_Ca.getSelectedIndex() == -1 && comboBox_ChucVu.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập một thông tin muốn tìm kiếm");
			return false;
		}
		return true;
	}
}
