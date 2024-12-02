package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import components.ConTent_JPanel;
import components.RoundedButton;
import dao.Ca_DAO;
import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import entity.Ca;
import entity.NhanVien;
import entity.TaiKhoan;

public class TaiKhoan_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lb_TenNV,lb_MaNV,lb_NgaySinh,lb_CCCD,lb_Email,lb_SDT,lb_ChucVu,userIconLabel;
	private JButton btn_VaoCa,btn_KetCa;
	private NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
	private TaiKhoan_DAO taiKhoan_DAO = new TaiKhoan_DAO();
	
	public TaiKhoan_GUI(DangNhap_GUI dangNhap) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 720, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon userIcon = new ImageIcon(getClass().getResource("/img/user.png"));
	    Image scaledUser = userIcon.getImage().getScaledInstance(73 ,56, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
	    userIconLabel = new JLabel(new ImageIcon(scaledUser));
	    userIconLabel.setBounds(54, 84, 73, 56);
		contentPane.add(userIconLabel);
		
		lb_TenNV = new JLabel("");
		lb_TenNV.setText(nhanVien_DAO.getNhanVienTheoMaNV((taiKhoan_DAO.getTaiKhoanTheoMaTK(dangNhap.getTaiKhoanLogined().getMaTaiKhoan())).getNhanVien().getMaNV()).getTenNV());
		lb_TenNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_TenNV.setBounds(51, 172, 105, 25);
		contentPane.add(lb_TenNV);
		
		JLabel lblNewLabel_2 = new JLabel("Mã nhân viên:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(227, 45, 105, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ngày sinh:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(227, 80, 105, 25);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("CCCD:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(227, 115, 105, 25);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Email:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(227, 150, 105, 25);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Số điện thoại:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_1.setBounds(227, 185, 105, 25);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Chức vụ:");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_1_1.setBounds(227, 220, 105, 25);
		contentPane.add(lblNewLabel_2_1_1_1_1_1);
		
		lb_MaNV = new JLabel();
		lb_MaNV.setText(nhanVien_DAO.getNhanVienTheoMaNV((taiKhoan_DAO.getTaiKhoanTheoMaTK(dangNhap.getTaiKhoanLogined().getMaTaiKhoan()))
				.getNhanVien().getMaNV()).getMaNV());
		lb_MaNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_MaNV.setBounds(362, 45, 200, 25);
		contentPane.add(lb_MaNV);
		
		lb_NgaySinh = new JLabel();
		LocalDate ngaySinh = nhanVien_DAO.getNhanVienTheoMaNV(taiKhoan_DAO.getTaiKhoanTheoMaTK(dangNhap.getTaiKhoanLogined().getMaTaiKhoan())
				.getNhanVien().getMaNV()).getNgaySinh();
		// Định dạng ngày sinh
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String ngaySinhFormatted = ngaySinh.format(formatter); // Chuyển LocalDate sang chuỗi theo định dạng
		
		lb_NgaySinh.setText(ngaySinhFormatted);
		lb_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_NgaySinh.setBounds(362, 80, 200, 25);
		contentPane.add(lb_NgaySinh);
		
		lb_CCCD = new JLabel();
		lb_CCCD.setText(nhanVien_DAO.getNhanVienTheoMaNV((taiKhoan_DAO.getTaiKhoanTheoMaTK(dangNhap.getTaiKhoanLogined().getMaTaiKhoan()))
				.getNhanVien().getMaNV()).getCccd());
		lb_CCCD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_CCCD.setBounds(362, 115, 200, 25);
		contentPane.add(lb_CCCD);
		
		lb_Email = new JLabel();
		lb_Email.setText(nhanVien_DAO.getNhanVienTheoMaNV((taiKhoan_DAO.getTaiKhoanTheoMaTK(dangNhap.getTaiKhoanLogined().getMaTaiKhoan()))
				.getNhanVien().getMaNV()).getEmail());
		lb_Email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_Email.setBounds(362, 150, 200, 25);
		contentPane.add(lb_Email);
		
		lb_SDT = new JLabel();
		lb_SDT.setText(nhanVien_DAO.getNhanVienTheoMaNV((taiKhoan_DAO.getTaiKhoanTheoMaTK(dangNhap.getTaiKhoanLogined().getMaTaiKhoan()))
				.getNhanVien().getMaNV()).getSdt());
		lb_SDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_SDT.setBounds(362, 185, 200, 25);
		contentPane.add(lb_SDT);
		
		lb_ChucVu = new JLabel();
		int chucVu = nhanVien_DAO.getNhanVienTheoMaNV(taiKhoan_DAO.getTaiKhoanTheoMaTK(dangNhap.getTaiKhoanLogined().getMaTaiKhoan())
			        .getNhanVien().getMaNV()).getChucVu();
		String tenChucVu;
		switch (chucVu) {
		    case 1:
		        tenChucVu = "Quản lý";
		        break;
		    case 2:
		        tenChucVu = "Nhân viên";
		        break;
		    default:
		        tenChucVu = "Không xác định";
		}
		lb_ChucVu.setText(tenChucVu);
		lb_ChucVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_ChucVu.setBounds(362, 220, 200, 25);
		contentPane.add(lb_ChucVu);
		
		btn_VaoCa = new RoundedButton("Vào ca", 10);
		btn_VaoCa.setForeground(new Color(255, 255, 255));
		btn_VaoCa.setBackground(new Color(51, 102, 153));
		btn_VaoCa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_VaoCa.setBounds(247, 271, 85, 21);
		contentPane.add(btn_VaoCa);
		
		btn_KetCa = new RoundedButton("Kết ca", 10);
		btn_KetCa.setForeground(new Color(255, 255, 255));
		btn_KetCa.setBackground(new Color(51, 102, 153));
		btn_KetCa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_KetCa.setBounds(382, 271, 85, 21);
		contentPane.add(btn_KetCa);
	}
}
