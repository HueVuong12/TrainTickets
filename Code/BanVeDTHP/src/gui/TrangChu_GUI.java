package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import components.ConTent_JPanel;
import dao.Ca_DAO;
import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import entity.Ca;
import entity.NhanVien;
import entity.TaiKhoan;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;

public class TrangChu_GUI extends JFrame implements ActionListener,MouseListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel header;
	private JPanel title;
	private JLabel logoLabel;
	private JLabel titleLabel;
	private JPanel jp_menu;
	private JMenuBar menuBar;
	private JMenu khachHang;
	private JMenu ve;
	private JMenuItem qlve;
	private JMenuItem datVe;
	private JMenu hoaDon;
	private JMenuItem qlhd;
	private JMenuItem xemcthd;
	private JMenu traCuuKH;
	private JMenuItem traCuuVCT;
	private JMenuItem traCuuKhachHang;
	private JMenuItem traCuuNV;
	private JMenu thongKe;
	private JMenuItem thongKeDT;
	private JMenuItem thongKeTheoCa;
	private JMenuItem thongKeCT;
	private JMenu nhanVien;
	private JMenu taiKhoan;
	private JPanel jp_nhanVien;
	private JLabel userIconLabel;
	public JLabel lbl_ThongTinNV;
	public JLabel lbl_ThoiGian;
	private JLabel exitIconLabel;
	public JPanel content;
	private Color hoverLabelColor = new Color(0, 153, 255);
	public DangNhap_GUI dangNhap;
	
	private NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
	private TaiKhoan_DAO taiKhoan_DAO = new TaiKhoan_DAO();
	private Ca_DAO ca_DAO= new Ca_DAO();
	private JMenu mnTrGip;
	private TaiKhoan_DAO dsTK;
	private JButton btn_VaoCa;
	private JButton btn_KetCa;
	public LocalDateTime vaoCa;
	public LocalDateTime ketCa;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TrangChu_GUI frame = new TrangChu_GUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TrangChu_GUI(DangNhap_GUI dangNhap) {
		this.dangNhap = dangNhap;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 810);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		header = new JPanel();
		header.setBounds(0, 0, 1470, 200);
		contentPane.add(header);
		header.setLayout(null);
		
		title = new JPanel();
		title.setBounds(0, 0, 1204, 200);
		title.setForeground(new Color(255, 0, 0));
		title.setBackground(new Color(51, 102, 153));
		header.add(title);
		title.setLayout(null);
		
		//Logo chương trình
		ImageIcon originalLogo = new ImageIcon(getClass().getResource("/img/LogoDepHonTrang.png"));
	    Image scaledLogo = originalLogo.getImage().getScaledInstance(300, 120, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
	    logoLabel = new JLabel(new ImageIcon(scaledLogo));
	    logoLabel.setBounds(18, 18, 300, 108); // Cập nhật kích thước trên JLabel
	    title.add(logoLabel);
	    
	    // Tên Chương trình
	    titleLabel = new JLabel("Nhà ga ĐTHP");
	    titleLabel.setForeground(SystemColor.text);
	    titleLabel.setBounds(328, 0, 876, 145);
	    titleLabel.setHorizontalAlignment(JLabel.CENTER);
	    title.add(titleLabel);
	    
	    // Thiết lập font cho titleLabel
        try {
            // Tải font "Italianno"
            Font italiannoFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/Italianno-Regular.tff")).deriveFont(100f); // Kích thước font 48
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(italiannoFont); // Đăng ký font
            
            titleLabel.setFont(italiannoFont); // Áp dụng font
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
	    
		//Menu Chính
		jp_menu = new JPanel();
		jp_menu.setBounds(0, 145, 1204, 55);
		title.add(jp_menu);
		jp_menu.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.menu);
		menuBar.setBounds(0, 0, 1204, 55);
		jp_menu.add(menuBar);
		
		khachHang = new JMenu("Khách hàng");
		khachHang.setFont(new Font("Segoe UI", Font.BOLD, 20));
		khachHang.setPreferredSize(new Dimension(150, 30));
		menuBar.add(khachHang);
		
		ve = new JMenu("Vé tàu");
		ve.setBackground(SystemColor.menu);
		ve.setFont(new Font("Segoe UI", Font.BOLD, 20));
		ve.setPreferredSize(new Dimension(135, 30));
		menuBar.add(ve);
		
		qlve = new JMenuItem("Quản lý vé");
		qlve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyVe_Gui quanLyVe_gui = new QuanLyVe_Gui(TrangChu_GUI.this);
				content.removeAll();
				System.out.println("thành công xóa");
				content.add(quanLyVe_gui); // Sử dụng layout thích hợp
				System.out.println("thành công thêm");
				content.revalidate();
				content.repaint();
				System.out.println("thành công");
			}
		});
		ve.add(qlve);
		
		datVe = new JMenuItem("Đặt vé");
		ve.add(datVe);
		
		hoaDon = new JMenu("Hóa đơn");
		hoaDon.setFont(new Font("Segoe UI", Font.BOLD, 20));
		hoaDon.setHorizontalAlignment(SwingConstants.RIGHT);
		hoaDon.setPreferredSize(new Dimension(146, 30));
		menuBar.add(hoaDon);
		
		qlhd = new JMenuItem("Quản lý hóa đơn");
		qlhd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyHoaDon_GUI QLHoaDon= new QuanLyHoaDon_GUI(TrangChu_GUI.this);
				content.removeAll();
				System.out.println("thành công xóa");
				content.add(QLHoaDon); // Sử dụng layout thích hợp
				System.out.println("thành công thêm");
				content.revalidate();
				content.repaint();
				System.out.println("thành công");
			}
		});
		hoaDon.add(qlhd);
		
		xemcthd = new JMenuItem("Xem chi tiết hóa đơn");
		xemcthd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyHoaDon_GUI QLHoaDon= new QuanLyHoaDon_GUI(TrangChu_GUI.this);
				ChiTietHoaDon_GUI ChiTietHD= new ChiTietHoaDon_GUI(QLHoaDon,TrangChu_GUI.this);
				content.removeAll();
				System.out.println("thành công xóa");
				content.add(ChiTietHD); // Sử dụng layout thích hợp
				System.out.println("thành công thêm");
				content.revalidate();
				content.repaint();
				System.out.println("thành công");
			}
		});
		hoaDon.add(xemcthd);
		
		traCuuKH = new JMenu("Tra cứu");
		traCuuKH.setFont(new Font("Segoe UI", Font.BOLD, 20));
		traCuuKH.setPreferredSize(new Dimension(146, 30));
		menuBar.add(traCuuKH);
		
		traCuuVCT = new JMenuItem("Tra cứu giá vé và chuyến tàu");
		traCuuKH.add(traCuuVCT);
		
		traCuuKhachHang = new JMenuItem("Tra cứu khách hàng");
		traCuuKH.add(traCuuKhachHang);
		
		traCuuNV = new JMenuItem("Tra cứu nhân viên ");
		traCuuKH.add(traCuuNV);
		
		thongKe = new JMenu("Thống kê");
		thongKe.setFont(new Font("Segoe UI", Font.BOLD, 20));
		thongKe.setPreferredSize(new Dimension(146, 30));
		menuBar.add(thongKe);
		
		thongKeTheoCa = new JMenuItem("Thống kê doanh thu theo ca");
		thongKe.add(thongKeTheoCa);
		
		thongKeDT = new JMenuItem("Thống kê doanh thu");
		thongKe.add(thongKeDT);
		
		thongKeCT = new JMenuItem("Thống Kê Chuyến Tàu");
		thongKe.add(thongKeCT);
		
		nhanVien = new JMenu("Nhân Viên");
		nhanVien.setFont(new Font("Segoe UI", Font.BOLD, 20));
		nhanVien.setPreferredSize(new Dimension(146, 30));
		menuBar.add(nhanVien);
		 //Sự kiện chuyển trang giữa content và quản lý nhân viên
	 
		taiKhoan = new JMenu("Tài khoản");
		taiKhoan.setFont(new Font("Segoe UI", Font.BOLD, 20));
		taiKhoan.setPreferredSize(new Dimension(150, 30));
		menuBar.add(taiKhoan);
		
		mnTrGip = new JMenu("Trợ giúp");
		mnTrGip.setPreferredSize(new Dimension(150, 30));
		mnTrGip.setFont(new Font("Segoe UI", Font.BOLD, 20));
		menuBar.add(mnTrGip);
		
		jp_nhanVien = new JPanel();
		jp_nhanVien.setBackground(SystemColor.text);
		jp_nhanVien.setBounds(1203, 0, 267, 200);
		header.add(jp_nhanVien);
		jp_nhanVien.setLayout(null);
		ImageIcon userIcon = new ImageIcon(getClass().getResource("/img/user.png"));
	    Image scaledUser = userIcon.getImage().getScaledInstance(73 ,56, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
	    jp_nhanVien.setLayout(null);
	    userIconLabel = new JLabel(new ImageIcon(scaledUser));
	    userIconLabel.setBounds(40 ,10 , 73 ,56); // Cập nhật kích thước trên JLabel
	    jp_nhanVien.add(userIconLabel);
	    
	    lbl_ThongTinNV = new JLabel();
	    lbl_ThongTinNV.setText(nhanVien_DAO.getNhanVienTheoMaNV((taiKhoan_DAO.getTaiKhoanTheoMaTK(dangNhap.getTaiKhoanLogined().getMaTaiKhoan()))
	    															.getNhanVien().getMaNV()).getTenNV());
	    lbl_ThongTinNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lbl_ThongTinNV.setHorizontalAlignment(SwingConstants.CENTER);
	    lbl_ThongTinNV.setBounds(18, 91, 231, 21);
	    jp_nhanVien.add(lbl_ThongTinNV);
	    
	    lbl_ThoiGian = new JLabel();
	    lbl_ThoiGian.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lbl_ThoiGian.setHorizontalAlignment(SwingConstants.CENTER);
	    lbl_ThoiGian.setBounds(18, 122, 231, 21);
	    jp_nhanVien.add(lbl_ThoiGian);
	    
		ImageIcon exitIcon = new ImageIcon(getClass().getResource("/img/Exit.png"));
	    Image scaledExit = exitIcon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
	    exitIconLabel = new JLabel(new ImageIcon(scaledExit));
	    exitIconLabel.setBounds(111 ,153 , 40 ,37); // Cập nhật kích thước trên JLabel
	    jp_nhanVien.add(exitIconLabel);
	    
	    btn_VaoCa = new JButton("Vào ca");
	    btn_VaoCa.setBounds(145, 10, 85, 25);
	    jp_nhanVien.add(btn_VaoCa);
	    btn_VaoCa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Hiển thị hộp thoại xác nhận sau khi mở file
				LocalDateTime currentTime = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String time= currentTime.format(formatter);
                int confirm = JOptionPane.showConfirmDialog(
                    null, 
                    "Bắt đầu ca làm :" + time, 
                    "Xác nhận", 
                    JOptionPane.YES_NO_OPTION
                );

                // Xóa file nếu người dùng chọn "Yes"
                if (confirm == JOptionPane.YES_OPTION) {
                    if (kiemTraVaoCaLam(lbl_ThongTinNV, currentTime)) {
                        vaoCa= LocalDateTime.now();
                        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        				String thoiGianVaoCa = vaoCa.format(formatter1);
        				System.out.println(thoiGianVaoCa);
        				
                    } else {
                    	JOptionPane.showMessageDialog(null, "Chưa thới thời gian làm viêc", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    }
                }else {
                	return;
                }
			}
		});
	    
	    btn_KetCa = new JButton("Kết ca");
	    btn_KetCa.setBounds(145, 45, 85, 25);
	    btn_KetCa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LocalDateTime currentTime = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String time= currentTime.format(formatter);
                int confirm = JOptionPane.showConfirmDialog(
                    null, 
                    "Kết thúc ca làm :" + time, 
                    "Xác nhận", 
                    JOptionPane.YES_NO_OPTION
                );

                // Xóa file nếu người dùng chọn "Yes"
                if (confirm == JOptionPane.YES_OPTION) {
                    if (kiemTraKetCaLam(lbl_ThongTinNV, currentTime)) {
                    	ketCa= LocalDateTime.now();
                        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        String thoiGianKetCa = ketCa.format(formatter1);
        				System.out.println(thoiGianKetCa);
        				
                    } else {
                    	JOptionPane.showMessageDialog(null, "Chưa thới thời gian kết thúc ca làm", "Thông báo", JOptionPane.WARNING_MESSAGE); 
                    }
                }else {
                	return;
                }
			}
		});
	    jp_nhanVien.add(btn_KetCa);
	    exitIconLabel.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		DangNhap_GUI dn= new DangNhap_GUI();
	    		TrangChu_GUI.this.setVisible(false);
	    		dn.setVisible(true);
	    	}
	    });
	    exitIconLabel.addMouseListener(new java.awt.event.MouseAdapter() {
	    	@Override
	    	public void mouseEntered(java.awt.event.MouseEvent evt) {
	    		exitIconLabel.setForeground(hoverLabelColor); // Thay đổi màu khi đưa chuột vào

	    		// Đổi con trỏ chuột thành kiểu tay chỉ
	    		exitIconLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    	}

	    	@Override
	    	public void mouseExited(java.awt.event.MouseEvent evt) {
	    		exitIconLabel.setForeground(null); // Trở về màu mặc định khi chuột ra
	    		// Trả lại con trỏ chuột về mặc định
	    		exitIconLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	    	}}
	    		);
		content = new JPanel();
		content.setBounds(0, 200, 1470, 575);
		content.setLayout(new GridLayout());
		content.setForeground(new Color(255, 255, 255));
		contentPane.add(content);
		
		ConTent_JPanel jpct= new ConTent_JPanel();
		content.add(jpct);
	    
		traCuuKhachHang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TraCuuKhachHang_GUI tckh= new TraCuuKhachHang_GUI(TrangChu_GUI.this);
				content.removeAll();
				System.out.println("thành công xóa");
				content.add(tckh); // Sử dụng layout thích hợp
				System.out.println("thành công thêm");
				content.revalidate();
				content.repaint();
				System.out.println("thành công");
			}
		});
		traCuuNV.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TraCuuNhanVien_GUI tcnv = new TraCuuNhanVien_GUI(TrangChu_GUI.this);
				content.removeAll();
				System.out.println("thành công xóa");
				content.add(tcnv); // Sử dụng layout thích hợp
				System.out.println("thành công thêm");
				content.revalidate();
				content.repaint();
				System.out.println("thành công");
			}
		});
		traCuuVCT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TraCuuChuyenTauGiaVe_Gui tcvct = new TraCuuChuyenTauGiaVe_Gui(TrangChu_GUI.this);
				content.removeAll();
				System.out.println("thành công xóa");
				content.add(tcvct); // Sử dụng layout thích hợp
				System.out.println("thành công thêm");
				content.revalidate();
				content.repaint();
				System.out.println("thành công");
			}
		});
		datVe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BanVe_GUI banVe= new BanVe_GUI(TrangChu_GUI.this);
				content.removeAll();
				System.out.println("thành công xóa");
				content.add(banVe); // Sử dụng layout thích hợp
				System.out.println("thành công thêm");
				content.revalidate();
				content.repaint();
				System.out.println("thành công");
			}
		});
		thongKeCT.addActionListener(new ActionListener() {

			private TaiKhoan tk;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tk= dangNhap.taiKhoanLogined;
				if(tk.getPhanQuyen() ==1) {
				ThongKe_GUI jptkct= new ThongKe_GUI(TrangChu_GUI.this);
				jptkct.hienThiThongKeChuyenTau();
				content.removeAll();
				System.out.println("thành công xóa");
				content.add(jptkct); // Sử dụng layout thích hợp
				System.out.println("thành công thêm");
				content.revalidate();
				content.repaint();
				System.out.println("thành công");
				}else {
					JOptionPane.showMessageDialog(TrangChu_GUI.this,"Tài khoản của bạn không có quyền truy cập");
				}
			}
		});
		thongKeDT.addActionListener(new ActionListener() {

			private TaiKhoan tk;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
				tk= dangNhap.taiKhoanLogined;
				if(tk.getPhanQuyen() ==1) {
					ThongKe_GUI jptkct= new ThongKe_GUI(TrangChu_GUI.this);
					jptkct.hienThiThongKeDoanhThu();;
					content.removeAll();
					System.out.println("thành công xóa");
					content.add(jptkct); // Sử dụng layout thích hợp
					System.out.println("thành công thêm");
					content.revalidate();
					content.repaint();
					System.out.println("thành công");
				}else {
					JOptionPane.showMessageDialog(TrangChu_GUI.this,"Tài khoản của bạn không có quyền truy cập");
				}
			}
		});
	    thongKeTheoCa.addActionListener(new ActionListener() {

	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		// TODO Auto-generated method stub
	    		ThongKe_GUI jptkct= new ThongKe_GUI(TrangChu_GUI.this);
	    		jptkct.hienThiThongKeDoanhThuTheoCa();
	    		content.removeAll();
	    		System.out.println("thành công xóa");
	    		content.add(jptkct); // Sử dụng layout thích hợp
	    		System.out.println("thành công thêm");
	    		content.revalidate();
	    		content.repaint();
	    		System.out.println("thành công");
	    	}
	    });
	    khachHang.addMenuListener(new MenuListener() {

			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				QuanLyKhachHang_GUI jpkh= new QuanLyKhachHang_GUI(TrangChu_GUI.this);
				content.removeAll();
				System.out.println("thành công xóa");
				content.add(jpkh); // Sử dụng layout thích hợp
				System.out.println("thành công thêm");
				content.revalidate();
				content.repaint();
				System.out.println("thành công");
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub

			}
		});
	    nhanVien.addMenuListener(new MenuListener() {

			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				QuanLyNhanVien_GUI jpnv= new QuanLyNhanVien_GUI(TrangChu_GUI.this);
				content.removeAll();
				System.out.println("thành công xóa");
				content.add(jpnv); // Sử dụng layout thích hợp
				System.out.println("thành công thêm");
				content.revalidate();
				content.repaint();
				System.out.println("thành công");
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub

			}
		});
	    
	    taiKhoan.addMenuListener(new MenuListener() {

			private TaiKhoan tk;

			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				tk= dangNhap.taiKhoanLogined;
				if(tk.getPhanQuyen() ==1) {
					System.out.println(tk.getPhanQuyen());
					QuanLyTaiKhoan_GUI jptk = new QuanLyTaiKhoan_GUI(TrangChu_GUI.this);
					content.removeAll();
					System.out.println("thành công xóa");
					content.add(jptk); // Sử dụng layout thích hợp
					System.out.println("thành công thêm");
					content.revalidate();
					content.repaint();
					System.out.println("thành công");
				}else {
						JOptionPane.showMessageDialog(TrangChu_GUI.this,"Tài khoản của bạn không có quyền truy cập");
				}
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub

			}
		});
	    updateTime(); // hàm lấy thời gian thực
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTime();
			}
		});
		timer.start();
		
//		 // Thông báo sau khi giao diện được hiển thị
//	    SwingUtilities.invokeLater(() -> {
//	        if (vaoCa == null) { // Kiểm tra trạng thái vào ca
//	            JOptionPane.showMessageDialog(
//	                this,
//	                "Vui lòng nhấn 'Vào ca' để bắt đầu làm việc!",
//	                "Thông báo",
//	                JOptionPane.WARNING_MESSAGE
//	            );
//	        }
//	    });
	}
	
	//Hàm lấy thời gian thực
	public void updateTime() {
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = currentTime.format(formatter);
		lbl_ThoiGian.setText(formattedTime);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		
	}
	public boolean kiemTraVaoCaLam(JLabel tenNV, LocalDateTime currentTime) {
	    nhanVien_DAO.reset();
	    ca_DAO.reset();

	    // Lấy phần thời gian (giờ, phút, giây) từ LocalDateTime
	    LocalTime time = currentTime.toLocalTime();
	    String ten = tenNV.getText();

	    // Lấy nhân viên theo tên
	    NhanVien nhanVien = nhanVien_DAO.getNhanVienTheoTenNV(ten);
	    if (nhanVien == null || nhanVien.getCa() == null) {
	        return false; // Nhân viên không tồn tại hoặc không có ca làm
	    }

	    // Lấy thông tin ca làm
	    Ca ca = ca_DAO.getCaTheoMaCa(nhanVien.getCa().getMaCa());
	    if (ca == null) {
	        return false; // Ca làm không tồn tại
	    }

	    // Lấy thời gian bắt đầu và kết thúc của ca
	    LocalTime thoiGianBatDau = ca.getThoiGianBatDau();
	    LocalTime thoiGianKetThuc = ca.getThoiGianKetThuc();

	    // Kiểm tra ca làm qua ngày hay không
	    if (thoiGianKetThuc.isBefore(thoiGianBatDau)) {
	        // Ca làm qua ngày
	        boolean isValid = (time.isAfter(thoiGianBatDau.minusMinutes(5)) && time.isBefore(LocalTime.MAX)) // Trước 23:59:59
	                || (time.isAfter(LocalTime.MIN) && time.isBefore(thoiGianKetThuc.plusMinutes(0))); // Sau 00:00:00
	        return isValid;
	    } else {
	        // Ca làm không qua ngày
	        return time.isAfter(thoiGianBatDau.minusMinutes(5)) && time.isBefore(thoiGianKetThuc.plusMinutes(0));
	    }
	}

	
	public boolean kiemTraKetCaLam(JLabel tenNV, LocalDateTime currentTime) {
	    nhanVien_DAO.reset();
	    ca_DAO.reset();

	    // Lấy phần thời gian (giờ, phút, giây) từ LocalDateTime
	    LocalTime time = currentTime.toLocalTime();
	    String ten = tenNV.getText();

	    // Lấy nhân viên theo tên
	    NhanVien nhanVien = nhanVien_DAO.getNhanVienTheoTenNV(ten);
	    if (nhanVien == null || nhanVien.getCa() == null) {
	        return false; // Nhân viên không tồn tại hoặc không có ca làm
	    }

	    // Lấy thông tin ca làm
	    Ca ca = ca_DAO.getCaTheoMaCa(nhanVien.getCa().getMaCa());
	    if (ca == null) {
	        return false; // Ca làm không tồn tại
	    }

	    // Lấy thời gian bắt đầu và kết thúc của ca
	    LocalTime thoiGianBatDau = ca.getThoiGianBatDau();
	    LocalTime thoiGianKetThuc = ca.getThoiGianKetThuc();

	    // Kiểm tra ca làm qua ngày hay không
	    if (thoiGianKetThuc.isBefore(thoiGianBatDau)) {
	        // Ca làm qua ngày
	        boolean isValid = (time.isAfter(LocalTime.MIN) && time.isBefore(thoiGianKetThuc.plusMinutes(5))) // Sau 00:00
	                || (time.isAfter(thoiGianBatDau.minusMinutes(0)) && time.isBefore(LocalTime.MAX)); // Trước 23:59
	        return isValid;
	    } else {
	        // Ca làm không qua ngày
	        return time.isAfter(thoiGianKetThuc.minusMinutes(5)) && time.isBefore(thoiGianKetThuc.plusMinutes(5));
	    }
	}

	public DangNhap_GUI getDangNhap() {
		return dangNhap;
	}

}