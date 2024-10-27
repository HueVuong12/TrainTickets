package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	private JLabel lbl_ThongTinNV;
	private JLabel lbl_ThoiGian;
	private JLabel exitIconLabel;
	private JPanel content;
	private JLabel backGroundLabel;
	private boolean isSearching = false; // Trạng thái nhấp chuột
	private Color hoverLabelColor = new Color(0, 153, 255);
	private JMenuItem doiVe;
	private DangNhap_GUI dangNhap;
	
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
	 */
	public TrangChu_GUI(DangNhap_GUI dangNhap) {
		this.dangNhap = dangNhap;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1481, 791);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		header = new JPanel();
		header.setBounds(0, 0, 1470, 182);
		contentPane.add(header);
		header.setLayout(null);
		
		title = new JPanel();
		title.setBounds(0, 0, 1069, 177);
		title.setForeground(new Color(255, 0, 0));
		title.setBackground(new Color(51, 102, 153));
		header.add(title);
		title.setLayout(null);
		
		//Logo chương trình
		ImageIcon originalLogo = new ImageIcon(getClass().getResource("/img/LogoDepHonTrang.png"));
	    Image scaledLogo = originalLogo.getImage().getScaledInstance(300, 120, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
	    logoLabel = new JLabel(new ImageIcon(scaledLogo));
	    logoLabel.setBounds(84, 10, 300, 108); // Cập nhật kích thước trên JLabel
	    title.add(logoLabel);
	    
	    //Tên Chương trình
	    titleLabel = new JLabel("Nhà ga ĐTHP");
	    titleLabel.setForeground(SystemColor.text);
	    titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 40));
	    titleLabel.setBounds(499, 0, 264,125);
	    title.add(titleLabel);
	    
		//Menu Chính
		jp_menu = new JPanel();
		jp_menu.setBounds(0, 124, 1070, 53);
		title.add(jp_menu);
		jp_menu.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.menu);
		menuBar.setBounds(0, 0, 1070, 53);
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
		ve.add(qlve);
		
		datVe = new JMenuItem("Đặt vé");
		ve.add(datVe);
		
		hoaDon = new JMenu("Hóa đơn");
		hoaDon.setFont(new Font("Segoe UI", Font.BOLD, 20));
		hoaDon.setHorizontalAlignment(SwingConstants.RIGHT);
		hoaDon.setPreferredSize(new Dimension(146, 30));
		menuBar.add(hoaDon);
		
		qlhd = new JMenuItem("Quản lý hóa đơn");
		hoaDon.add(qlhd);
		
		xemcthd = new JMenuItem("Xem chi tiết hóa đơn");
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
		
		jp_nhanVien = new JPanel();
		jp_nhanVien.setBackground(SystemColor.text);
		jp_nhanVien.setBounds(1067, 0, 403, 177);
		header.add(jp_nhanVien);
		jp_nhanVien.setLayout(null);
		ImageIcon userIcon = new ImageIcon(getClass().getResource("/img/user.png"));
	    Image scaledUser = userIcon.getImage().getScaledInstance(73 ,56, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
	    jp_nhanVien.setLayout(null);
	    userIconLabel = new JLabel(new ImageIcon(scaledUser));
	    userIconLabel.setBounds(184 ,10 , 73 ,56); // Cập nhật kích thước trên JLabel
	    jp_nhanVien.add(userIconLabel);
	    
	    lbl_ThongTinNV = new JLabel();
	    lbl_ThongTinNV.setText(dangNhap.getTaiKhoanLogined().getNhanVien().getTenNV());
	    lbl_ThongTinNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lbl_ThongTinNV.setHorizontalAlignment(SwingConstants.CENTER);
	    lbl_ThongTinNV.setBounds(96, 74, 247, 21);
	    jp_nhanVien.add(lbl_ThongTinNV);
	    
	    lbl_ThoiGian = new JLabel();
	    lbl_ThoiGian.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lbl_ThoiGian.setHorizontalAlignment(SwingConstants.CENTER);
	    lbl_ThoiGian.setBounds(96, 95, 247, 21);
	    jp_nhanVien.add(lbl_ThoiGian);
	    
		ImageIcon exitIcon = new ImageIcon(getClass().getResource("/img/Exit.png"));
	    Image scaledExit = exitIcon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
	    exitIconLabel = new JLabel(new ImageIcon(scaledExit));
	    exitIconLabel.setBounds(203 ,130 , 40 ,37); // Cập nhật kích thước trên JLabel
	    jp_nhanVien.add(exitIconLabel);
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
		content.setBounds(0, 178, 1470, 575);
		content.setLayout(new GridLayout());
		content.setForeground(new Color(255, 255, 255));
		contentPane.add(content);
		
		ConTent_JPanel jpct= new ConTent_JPanel();
		content.add(jpct);
	    
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
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ThongKe_GUI jptkct= new ThongKe_GUI(TrangChu_GUI.this);
				content.removeAll();
				System.out.println("thành công xóa");
				content.add(jptkct); // Sử dụng layout thích hợp
				System.out.println("thành công thêm");
				content.revalidate();
				content.repaint();
				System.out.println("thành công");
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

			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				QuanLyTaiKhoan_GUI jptk = new QuanLyTaiKhoan_GUI(TrangChu_GUI.this);
				content.removeAll();
				System.out.println("thành công xóa");
				content.add(jptk); // Sử dụng layout thích hợp
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
	    updateTime(); // hàm lấy thời gian thực
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTime();
			}
		});
		timer.start();
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

	public DangNhap_GUI getDangNhap() {
		return dangNhap;
	}

}
