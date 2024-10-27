package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import entity.Ca;
import entity.NhanVien;
import entity.TaiKhoan;

public class QuanLyTaiKhoan_GUI extends JPanel  implements ActionListener,MouseListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_TimMaTK;
	private JTextField textField_MaDN;
	private JTextField textField_MatKhau;
	private JTextField textField_PhanQuyen;
	private JTextField textField_MaNV;
	private JLabel lbl_MatKhau;
	private JLabel lbl_MaDN;
	private JLabel lbl_PhanQuyen;
	private JLabel lbl_MaNV;
	private JScrollPane scrollPane;
	private JTable table_TK;
	private JPanel content;
	private JPanel jp_quayLai;
	private JLabel goBackIconLabel;
	private JLabel lbl_quayLai;
	private JPanel jp_timKiem;
	private JPanel jp_content;
	private JButton btnTim;
	private JPanel jp_header;
	private JLabel lbl_tieuDeTK;
	private JLabel downIconLabel;
	private JPanel jp_thongTinNV;
	private JPanel jp_contentThongTin;
	private JButton btnThem;
	private JButton btnSua;
	private JPanel jp_headerThongTin;
	private JLabel lbl_tieuDeTT;
	private JLabel downIconLabel1;
	private Color hoverLabelColor = new Color(0, 153, 255);
	private TaiKhoan_DAO dstk;
	private DefaultTableModel model;
	private boolean isSearching = false; // Trạng thái nhấp chuột
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QuanLyTaiKhoan_GUI frame = new QuanLyTaiKhoan_GUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public QuanLyTaiKhoan_GUI(TrangChu_GUI trangChu) {
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
	  				trangChu.setVisible(true);
	  				QuanLyTaiKhoan_GUI.this.setVisible(false);
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
		jp_timKiem.setBounds(300, 40, 1160, 78);
		add(jp_timKiem);
		jp_timKiem.setLayout(null);

		//Icon xổ xuống
		ImageIcon downIcon = new ImageIcon(getClass().getResource("/img/Polygon_20.png"));
		Image scaledDown = downIcon.getImage().getScaledInstance(20 ,20, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
				
		//JPane chứa content
		jp_content = new JPanel();
		jp_content.setBackground(SystemColor.controlHighlight);
		jp_content.setBounds(0, 32, 1160, 48);
		jp_timKiem.add(jp_content);
		jp_content.setLayout(null);
		
		btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTim.setBounds(185, 8, 85, 27);
		jp_content.add(btnTim);
		
		textField_TimMaTK = new JTextField();
		textField_TimMaTK.setForeground(SystemColor.textInactiveText);
		textField_TimMaTK.setHorizontalAlignment(SwingConstants.LEFT);
		textField_TimMaTK.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_TimMaTK.setText("Theo mã tài khoản");
		textField_TimMaTK.setBounds(10, 8, 165, 27);
		jp_content.add(textField_TimMaTK);
		textField_TimMaTK.setColumns(10);
		
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
		
		//JPane thông tin tài khoản
		jp_thongTinNV = new JPanel();
		jp_thongTinNV.setBounds(10, 40, 280, 525);
		add(jp_thongTinNV);
		jp_thongTinNV.setLayout(null);

		//Icon xổ xuống
		ImageIcon downIcon1 = new ImageIcon(getClass().getResource("/img/Polygon_20.png"));
		Image scaledDown1 = downIcon1.getImage().getScaledInstance(20 ,20, Image.SCALE_SMOOTH); // Thay đổi kích thước logo

		jp_contentThongTin = new JPanel();
		jp_contentThongTin.setBounds(0, 31, 280, 494);
		jp_thongTinNV.add(jp_contentThongTin);
		jp_contentThongTin.setLayout(null);

		textField_MaDN = new JTextField();
		textField_MaDN.setEditable(false);
		textField_MaDN.setBounds(129, 22, 141, 25);
		jp_contentThongTin.add(textField_MaDN);
		textField_MaDN.setColumns(10);

		textField_MatKhau = new JTextField();
		textField_MatKhau.setColumns(10);
		textField_MatKhau.setBounds(129, 70, 141, 25);
		jp_contentThongTin.add(textField_MatKhau);

		textField_PhanQuyen = new JTextField();
		textField_PhanQuyen.setColumns(10);
		textField_PhanQuyen.setBounds(129, 127, 141, 25);
		jp_contentThongTin.add(textField_PhanQuyen);

		textField_MaNV = new JTextField();
		textField_MaNV.setColumns(10);
		textField_MaNV.setBounds(129, 183, 141, 25);
		jp_contentThongTin.add(textField_MaNV);

		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(34, 249, 85, 27);
		jp_contentThongTin.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSua.setBounds(159, 249, 85, 27);
		jp_contentThongTin.add(btnSua);

		lbl_MaDN = new JLabel("Mã đăng nhập:");
		lbl_MaDN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MaDN.setBounds(10, 22, 109, 25);
		jp_contentThongTin.add(lbl_MaDN);

		lbl_MatKhau = new JLabel("Mật khẩu:");
		lbl_MatKhau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MatKhau.setBounds(10, 70, 101, 25);
		jp_contentThongTin.add(lbl_MatKhau);

		lbl_PhanQuyen = new JLabel("Phân quyền:");
		lbl_PhanQuyen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_PhanQuyen.setBounds(10, 127, 101, 25);
		jp_contentThongTin.add(lbl_PhanQuyen);

		lbl_MaNV = new JLabel("Mã tài khoản:");
		lbl_MaNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MaNV.setBounds(10, 183, 101, 25);
		jp_contentThongTin.add(lbl_MaNV);
		
		//JPane header tiêu đề của thông tin tài khoản
		jp_headerThongTin = new JPanel();
		jp_headerThongTin.setBounds(0, 0, 280, 32);
		jp_thongTinNV.add(jp_headerThongTin);
		jp_headerThongTin.setBackground(new Color(51, 102, 153));
		jp_headerThongTin.setLayout(null);
		//JLabel tiêu đề 
		lbl_tieuDeTT = new JLabel("Thông tin tài khoản");
		lbl_tieuDeTT.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tieuDeTT.setForeground(new Color(255, 255, 255));
		lbl_tieuDeTT.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_tieuDeTT.setBounds(10, 0, 153, 35);
		jp_headerThongTin.add(lbl_tieuDeTT);
		downIconLabel1 = new JLabel(new ImageIcon(scaledDown1));
		downIconLabel1.setBounds(250, 0, 30, 35);
		jp_headerThongTin.add(downIconLabel1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 124, 1160, 441);
		add(scrollPane);

		table_TK = new JTable();
		scrollPane.setViewportView(table_TK);
		table_TK.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Mã đăng nhập", "Mật khẩu", "Phân quyền", "Mã tài khoản"
				}
				));
		//Thêm sự kiện cho các nút và bảng
		btnThem.addActionListener(this);
		btnTim.addActionListener(this);
		btnSua.addActionListener(this);
		table_TK.addMouseListener(this);
		datatoTable();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table_TK.getSelectedRow();
		if (row != -1) {
			TaiKhoan tk = dstk.getTaiKhoanTheoMaTK(table_TK.getModel().getValueAt(row, 0).toString());
			textField_MaNV.setText(tk.getNhanVien().getMaNV());
			textField_MaDN.setText(tk.getMaTaiKhoan());
			textField_MatKhau.setText(tk.getMatKhau());
			textField_PhanQuyen.setText(String.valueOf(tk.getPhanQuyen()));
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
		dstk= new TaiKhoan_DAO();
		if(o.equals(btnThem)) {
			if (validData()) {
				TaiKhoan tk= revertTK();
				if (tk != null) {
					// Kiểm tra xem nhân viên đã tồn tại hay chưa
					TaiKhoan existingTK = dstk.getTaiKhoanTheoMaTK(tk.getMaTaiKhoan());
					if (existingTK != null) {
						JOptionPane.showMessageDialog(this, "Tài Khoản đã tồn tại trong cơ sở dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							dstk.create(tk);	
							model.setRowCount(0);
							datatoTable();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(this, "Lỗi khi thêm tài khoản vào cơ sở dữ liệu: " + e1.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
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
	
	//Hàm kiểm tra regex
		public boolean validData() {
			if (textField_TimMaTK.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Mã tài khoản không được để trống");
				return false;
			}
			if (textField_MatKhau.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Mật khẩu không được bỏ trống");
				return false;
			}
			if (textField_PhanQuyen.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Phân quyền không được bỏ trống");
				return false;
			}
			if (textField_MaNV.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Mã nhân viên không được bỏ trống");
				return false;
			}

			return true;
		}
		//Hàm tạo mã tài khoản tự động
		public String generateMaDN(int cv) {
			ArrayList<TaiKhoan> listNV = dstk.getLisNV();
			ArrayList<TaiKhoan> listQL = dstk.getListQL();
			String maDN ="";
			int sl = 0;
			if(cv == 1) {
				for (int i = 0; i < listQL.size(); i++) {
					sl++;
				}sl++;
				maDN = String.format("TKQL%03d", sl);// Tạo mã với định dạng "TKQL" + 3 chữ số, ví dụ "TKQL001"
			}
			if(cv == 2) {
				for (int i = 0; i < listNV.size(); i++) {
					sl++;
				}sl++;
				maDN = String.format("TKNV%03d", sl);// Tạo mã với định dạng "TKNV" + 3 chữ số, ví dụ "TKNV001"
			}
			return maDN;
		}
		
		//Hàm lấy dữ liệu từ JPane thông tin tài khoản
		public TaiKhoan revertTK() {
			String matKhau = textField_MatKhau.getText();
			int chucVu =  Integer.parseInt(textField_PhanQuyen.getText());
			String maDN = generateMaDN(chucVu);
			String maNV = textField_MaNV.getText();
			TaiKhoan tk = new TaiKhoan(maDN, matKhau, chucVu, new NhanVien(maNV));
			return tk;
		}
		//Hàm sửa thông tin tài khoản
		public void update() {
			int index = table_TK.getSelectedRow();
			if (index != -1) {
				String matKhau = textField_MatKhau.getText();
				int chucVu =  Integer.parseInt(textField_PhanQuyen.getText());
				String maDN = generateMaDN(chucVu);
				String maNV = textField_MaNV.getText();
				TaiKhoan tk = new TaiKhoan(maDN, matKhau, chucVu, new NhanVien(maNV));
				try {
					dstk.update(tk);
					model.setRowCount(0);
					// Load lại dữ liệu từ cơ sở dữ liệu vào bảng
					datatoTable();
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, "Không tìm thấy.");
				}
			}else {
				JOptionPane.showMessageDialog(this, "Chọn tài khoản cần sửa.");
			}
			deleteField();
		}
	//Hàm tìm kiếm tài khoản
		public void search() {
			if (validData()) {
				String maDN= textField_TimMaTK.getText();
				TaiKhoan tk = dstk.getTaiKhoanTheoMaTK(maDN);
				if (tk != null) { // Kiểm tra xem đối tượng SanPham có null không trước khi thêm vào bảng
					model.setRowCount(0);
					model.addRow(new Object[] {tk.getMaTaiKhoan(),tk.getMatKhau(),tk.getPhanQuyen(),tk.getNhanVien().getMaNV() 
					});
				}
			}else {
				JOptionPane.showMessageDialog(this, "Nhập mã tài khoản cần tìm.");
			}
		}

		//Hàm tải dữ liệu vào bảng
		public void datatoTable() {
			dstk = new TaiKhoan_DAO();
			ArrayList<TaiKhoan> list = dstk.docTuBang();
			model = (DefaultTableModel) table_TK.getModel();
			model.setRowCount(0); // Xóa tất cả hàng trong bảng
			for (TaiKhoan tk : list) {
				model.addRow(new Object[] { tk.getMaTaiKhoan(),tk.getMatKhau(),tk.getPhanQuyen(),tk.getNhanVien().getMaNV()
				});
			}
		}
		
		//Hàm xóa thông tin 
		public void deleteField() {
			textField_MaNV.setText("");
			textField_TimMaTK.setText("");
			textField_MatKhau.setText("");
			textField_MaDN.setText("");
			textField_PhanQuyen.setText("");
			
			;
		}
}
