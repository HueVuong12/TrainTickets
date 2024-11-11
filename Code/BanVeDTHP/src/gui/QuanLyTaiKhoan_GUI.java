package gui;

import java.awt.Color;
import java.awt.Cursor;
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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import components.ConTent_JPanel;
import components.RoundedButton;
import components.RoundedTextField;
import dao.TaiKhoan_DAO;
import entity.NhanVien;
import entity.TaiKhoan;
import javax.swing.JPasswordField;

public class QuanLyTaiKhoan_GUI extends JPanel  implements ActionListener,MouseListener{

	private static final long serialVersionUID = 1L;
	private JTextField textField_MaDN;
	private JTextField textField_PhanQuyen;
	private JTextField textField_MaNV;
	private JLabel lbl_MatKhau;
	private JLabel lbl_MaDN;
	private JLabel lbl_PhanQuyen;
	private JLabel lbl_MaNV;
	private JScrollPane scrollPane;
	private JTable table_TK;
	private JPanel jp_quayLai;
	private JLabel goBackIconLabel;
	private JLabel lbl_quayLai;
	private JPanel jp_thongTinNV;
	private JPanel jp_contentThongTin;
//	private JButton btnThem;
//	private JButton btnSua;
	private JPanel jp_headerThongTin;
	private JLabel lbl_tieuDeTT;
	private JComboBox<String> comboBox_TimTheoMaTK;
	private Color hoverLabelColor = new Color(0, 153, 255);
	private TaiKhoan_DAO dstk = new TaiKhoan_DAO();;
	private DefaultTableModel model;
	private TableRowSorter<TableModel> sorter;
//<<<<<<< HEAD
	private RoundedButton btnSua;
	private RoundedButton btnThem;
	private RoundedButton btn_Tim;
//=======
//	private JButton btnSua;
//	private JButton btnThem;
//	private JButton btn_Tim;
	private JPasswordField passwordField;
	private int nextNumber;

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
		downIcon.getImage().getScaledInstance(20 ,20, Image.SCALE_SMOOTH);
		
		//JPane thông tin tài khoản
		jp_thongTinNV = new JPanel();
		jp_thongTinNV.setBounds(10, 40, 338, 525);
		add(jp_thongTinNV);
		jp_thongTinNV.setLayout(null);

		//Icon xổ xuống
		ImageIcon downIcon1 = new ImageIcon(getClass().getResource("/img/Polygon_20.png"));
		downIcon1.getImage().getScaledInstance(20 ,20, Image.SCALE_SMOOTH);

		jp_contentThongTin = new JPanel();
		jp_contentThongTin.setBounds(0, 31, 337, 494);
		jp_thongTinNV.add(jp_contentThongTin);
		jp_contentThongTin.setLayout(null);

		
		textField_MaDN = new RoundedTextField(10);
		textField_MaDN.setText("Mã tài khoản");
//		textField_MaDN = new JTextField();
		textField_MaDN.setEditable(false);
		textField_MaDN.setBounds(20, 57, 291, 30);
		jp_contentThongTin.add(textField_MaDN);
		textField_MaDN.setColumns(10);
		focusTxtField(textField_MaDN, "Mã tài khoản");


		textField_PhanQuyen = new RoundedTextField(10);
		textField_PhanQuyen.setText("Phân quyền");
		textField_PhanQuyen.setColumns(10);
		textField_PhanQuyen.setBounds(20, 219, 291, 30);
		jp_contentThongTin.add(textField_PhanQuyen);
		focusTxtField(textField_PhanQuyen, "Phân quyền");

		textField_MaNV = new RoundedTextField(10);
		textField_MaNV.setText("Mã nhân viên");
		textField_MaNV.setColumns(10);
		textField_MaNV.setBounds(20, 299, 291, 30);
		jp_contentThongTin.add(textField_MaNV);
		focusTxtField(textField_MaNV, "Mã nhân viên");

//		btnThem.setForeground(new Color(255, 255, 255));
//		btnThem.setBackground(new Color(51, 102, 153));
//		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		btnThem.setBounds(31, 249, 85, 27);
//		jp_contentThongTin.add(btnThem);
//
////		RoundedButton btnSua = new RoundedButton("Sửa", 10);
//		btnSua.setForeground(new Color(255, 255, 255));
//		btnSua.setBackground(new Color(51, 102, 153));
//		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		btnSua.setBounds(148, 249, 85, 27);
//		jp_contentThongTin.add(btnSua);

		lbl_MaDN = new JLabel("Mã tài khoản:");
		lbl_MaDN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_MaDN.setBounds(20, 22, 109, 25);
		jp_contentThongTin.add(lbl_MaDN);

		lbl_MatKhau = new JLabel("Mật khẩu:");
		lbl_MatKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_MatKhau.setBounds(20, 101, 101, 25);
		jp_contentThongTin.add(lbl_MatKhau);

		lbl_PhanQuyen = new JLabel("Phân quyền:");
		lbl_PhanQuyen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_PhanQuyen.setBounds(20, 184, 101, 25);
		jp_contentThongTin.add(lbl_PhanQuyen);

		lbl_MaNV = new JLabel("Mã nhân viên:");
		lbl_MaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_MaNV.setBounds(20, 264, 101, 25);
		jp_contentThongTin.add(lbl_MaNV);
		btnThem = new RoundedButton("Thêm", 15);
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBackground(new Color(51, 102, 153));
		btnThem.setBounds(20, 353, 85, 40);
		jp_contentThongTin.add(btnThem);
		btnSua = new RoundedButton("Sửa", 15);
		btnSua.setForeground(new Color(255, 255, 255));
		btnSua.setBounds(125, 353, 85, 40);
		jp_contentThongTin.add(btnSua);
		btnSua.setBackground(new Color(51, 102, 153));
		btn_Tim = new RoundedButton("Tìm", 15);
		btn_Tim.setForeground(new Color(255, 255, 255));
		btn_Tim.setBounds(226, 353, 85, 40);
		btn_Tim.setBackground(new Color(51, 102, 153));

		jp_contentThongTin.add(btn_Tim);
		passwordField = new JPasswordField();
		passwordField.setBounds(20, 136, 291, 30);
		jp_contentThongTin.add(passwordField);

		//JPane header tiêu đề của thông tin tài khoản
		jp_headerThongTin = new JPanel();
		jp_headerThongTin.setBounds(0, 0, 337, 32);
		jp_thongTinNV.add(jp_headerThongTin);
		jp_headerThongTin.setBackground(new Color(51, 102, 153));
		jp_headerThongTin.setLayout(null);
		//JLabel tiêu đề 
		lbl_tieuDeTT = new JLabel("Thông tin tài khoản");
		lbl_tieuDeTT.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_tieuDeTT.setForeground(new Color(255, 255, 255));
		lbl_tieuDeTT.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_tieuDeTT.setBounds(20, 0, 318, 32);
		jp_headerThongTin.add(lbl_tieuDeTT);

		// Tạo JComboBox Hiển thị mã nhân viên 
		comboBox_TimTheoMaTK = new JComboBox<String>();
		comboBox_TimTheoMaTK.setBounds(372, 40, 170, 28);
		add(comboBox_TimTheoMaTK);
		// Tạo JComboBox Hiển thị mã nhân viên 
		comboBox_TimTheoMaTK.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JComboBox<String> cb = (JComboBox<String>) e.getSource();
		        String selectedObj = cb.getSelectedItem() != null ? cb.getSelectedItem().toString() : null;
		        
		        System.out.println("Selected Object: " + selectedObj); // Log giá trị của selectedObj
		        
		        if (selectedObj != null) {
		            TaiKhoan tk = dstk.getTaiKhoanTheoMaTK(selectedObj);
		            if (tk != null) {
		                int rowIndex = -1;
		                for (int i = 0; i < table_TK.getRowCount(); i++) {
		                    // Kiểm tra cột Mã nhân viên tại chỉ mục 1
		                    if (table_TK.getValueAt(i, 1).equals(tk.getMaTaiKhoan())) {
		                        rowIndex = i;
		                        break;
		                    }
		                }
		                if (rowIndex != -1) {
		                    table_TK.setRowSelectionInterval(rowIndex, rowIndex);
		                    textField_MaDN.setText(tk.getMaTaiKhoan());
		                    passwordField.setText(tk.getMatKhau());
		                    textField_MaNV.setText(tk.getNhanVien().getMaNV());
		                    textField_PhanQuyen.setText(String.valueOf(tk.getPhanQuyen()));
		                }
		            } else {
		                System.out.println("TaiKhoan không tìm thấy cho mã: " + selectedObj);
		            }
		        } else {
		            System.out.println("Không có mục nào được chọn.");
		        }
		    }
		});

		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(372, 78, 1088, 487);
		add(scrollPane);

		table_TK = new JTable();
		scrollPane.setViewportView(table_TK);
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"STT","Mã tài khoản", "Mật khẩu", "Phân quyền", "Mã nhân viên"
				}
				);
		sorter = new TableRowSorter<>(model);
		table_TK.setRowSorter(sorter);
		table_TK.setModel(model);
		
		//Thêm sự kiện cho các nút và bảng
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btn_Tim.addActionListener(this);
		table_TK.addMouseListener(this);
		
		 datatoTable();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table_TK.getSelectedRow();
		if (row != -1) {
			TaiKhoan tk = dstk.getTaiKhoanTheoMaTK(table_TK.getModel().getValueAt(row, 1).toString());
			textField_MaNV.setText(tk.getNhanVien().getMaNV());
			textField_MaDN.setText(tk.getMaTaiKhoan());
			passwordField.setText(tk.getMatKhau());
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
	    Object o = e.getSource();

	    if (o.equals(btnThem)) {
	        if (validData()) {
	            TaiKhoan tk = revertTK();
	            if (tk != null) {
	                // Kiểm tra xem tài khoản đã tồn tại chưa
	                TaiKhoan existingTK = dstk.getTaiKhoanTheoMaTK(tk.getMaTaiKhoan());
	                if (existingTK != null) {
	                    JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại trong cơ sở dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
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

	    if (o.equals(btn_Tim)) {
	        // Chỉ cần gọi filterRows() một lần, vì hàm này đã kiểm tra tất cả các điều kiện lọc
	        filterRows();
	        updateComboBox();
	        deleteField();
	    }

	    if (o.equals(btnSua)) {
	        update();
	    }
	}

	
	//Hàm kiểm tra regex
		public boolean validData() {
			if (passwordField.getText().equals("")) {
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
		    String maDN = "";

		    nextNumber = 1;

		    if (cv == 1) {
		        // Tìm số tiếp theo chưa dùng cho mã TKQL
		        while (listQL.stream().anyMatch(tk -> tk.getMaTaiKhoan().equals(String.format("TKQL%03d", nextNumber)))) {
		            nextNumber++;
		        }
		        maDN = String.format("TKQL%03d", nextNumber);
		    } else if (cv == 2) {
		        // Tìm số tiếp theo chưa dùng cho mã TKNV
		        while (listNV.stream().anyMatch(tk -> tk.getMaTaiKhoan().equals(String.format("TKNV%03d", nextNumber)))) {
		            nextNumber++;
		        }
		        maDN = String.format("TKNV%03d", nextNumber);
		    }

		    return maDN;
		}

		
		//Hàm lấy dữ liệu từ JPane thông tin tài khoản
		public TaiKhoan revertTK() {
			String matKhau = passwordField.getText();
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
				String matKhau = passwordField.getText();
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

		private void filterRows() {
			ArrayList<RowFilter<Object, Object>> filters = new ArrayList<>();
			String tk = textField_MaDN.getText().trim();
			String mk = passwordField.getText().trim();
			String nv = textField_MaNV.getText().trim();
			String pq = textField_PhanQuyen.getText().trim();
			// Lọc theo các điều kiện
			if (!tk.isEmpty()) {
				filters.add(RowFilter.regexFilter("(?i)" + tk, 1));
			}
			if (!mk.isEmpty()) {
				 // Chuyển mk thành chuỗi `*` tương ứng độ dài
		        String hiddenPasswordFilter = "\\*{" + mk.length() + "}";
		        filters.add(RowFilter.regexFilter(hiddenPasswordFilter, 2));
			}
			if (!pq.isEmpty()) {
				filters.add(RowFilter.regexFilter("(?i)" + pq, 3));
			}
			if (!nv.isEmpty()) {
				filters.add(RowFilter.regexFilter("(?i)" +nv, 4));
			}
			// Cập nhật bộ lọc
			if (filters.isEmpty()) {
				sorter.setRowFilter(null); // Nếu không có bộ lọc nào, xóa bộ lọc
			} else {
				sorter.setRowFilter(RowFilter.andFilter(filters));
			}
		}
		//Hàm tải dữ liệu vào bảng
		public void datatoTable() {
			dstk.reset();
		    ArrayList<TaiKhoan> list = dstk.docTuBang();
		    model = (DefaultTableModel) table_TK.getModel();
		    model.setRowCount(0); // Xóa tất cả hàng trong bảng

		    // Xóa tất cả các mục trong comboBox trước khi thêm mới
		    comboBox_TimTheoMaTK.removeAllItems();

		    int stt = 1;
		    for (TaiKhoan tk : list) {
		        comboBox_TimTheoMaTK.addItem(tk.getMaTaiKhoan());
		        // Ẩn mật khẩu bằng cách thay thế bằng dấu *
		        String hiddenPassword = "*".repeat(tk.getMatKhau().length());
		        model.addRow(new Object[] { 
		            stt++, 
		            tk.getMaTaiKhoan(),
		            hiddenPassword,
		            tk.getPhanQuyen(),
		            tk.getNhanVien().getMaNV()
		        });
		    }
		    deleteField();
		}

		
		//Hàm xóa thông tin 
		public void deleteField() {
			textField_MaNV.setText("");
			textField_MaDN.setText("");
			textField_PhanQuyen.setText("");
			passwordField.setText("");
		}
		private void updateComboBox() {
		    comboBox_TimTheoMaTK.removeAllItems(); // Xóa tất cả các mục hiện có trong comboBox
		    for (int i = 0; i <table_TK.getRowCount(); i++) {
		        String maTaiKhoan = table_TK.getValueAt(i, 1).toString(); // Giả sử cột 1 là Mã tài khoản
		        comboBox_TimTheoMaTK.addItem(maTaiKhoan); // Thêm mã tài khoản vào comboBox
		    }
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
