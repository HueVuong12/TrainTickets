package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ChiTietHoaDon_DAO;
import dao.KhachHang_DAO;
import dao.Ve_DAO;
import entity.ChiTietHoaDon;
import entity.KhachHang;
import entity.Ve;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class TraVe_GUI extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTable table_CTHD;
	private JTable table_DSV;
	private JTextField textField_TienKhachDua;
	private JPanel panel;
	private JLabel lblQuayLai;
	private JPanel panel_1;
	private JLabel lblThongTin;
	private JScrollPane scrollPane;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane_1;
	private JPanel panel_3;
	private JLabel lblTienKhachDua;
	private JLabel lblNewLabel_3;
	private JButton btn33;
	private JButton btn35;
	private JButton btn44;
	private JPanel panel_4;
	private JLabel lblNewLabel_1;
	private JButton btn500;
	private JButton btn200;
	private JButton btn100;
	private JButton btn50;
	private JButton btn20;
	private JButton btn10;
	private JButton btn5;
	private JButton btn2;
	private JButton btn1;
	private JPanel panel_5;
	private JLabel lblNewLabel_2;
	private JTextField textField_TienTraLai;
	private JButton btnXacNhan;
	private JButton btnHuy;
	private ChiTietHoaDon_DAO dsCTHD;
	private DefaultTableModel model_CTHD;
	private Ve_DAO dsVe;
	private KhachHang_DAO dsKH;
	private DefaultTableModel model_DSV;
	float tongTien=0;
	float tienKhachDua= 0;
	float tienTraLai=0;
	private JButton btnXoa;
	private float tongTienCoThue=0;

	/**
	 * Create the panel.
	 */
	public TraVe_GUI(QuanLyHoaDon_GUI qlhd,TrangChu_GUI trangChu) {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 170, 1460, 570);
		setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(25, 10, 142, 44);
		add(panel);
		panel.setLayout(null);

		//Icon Quay lại
		ImageIcon goBackIcon = new ImageIcon(getClass().getResource("/img/9054423_bx_arrow_back_icon.png"));
		Image scaledGoBack = goBackIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		JLabel goBackIconLabel = new JLabel(new ImageIcon(scaledGoBack));
		panel.add(goBackIconLabel);
		goBackIconLabel.setBounds(10, 10, 45, 24);
		goBackIconLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				QuanLyHoaDon_GUI qlhd= new QuanLyHoaDon_GUI(trangChu);
				trangChu.content.removeAll();
				trangChu.content.add(qlhd);
				trangChu.content.revalidate();
				trangChu.content.repaint();
			}
		});
		lblQuayLai = new JLabel("Quay lại");
		lblQuayLai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuayLai.setBounds(55, 10, 77, 24);
		panel.add(lblQuayLai);

		panel_1 = new JPanel();
		panel_1.setBounds(25, 59, 1425, 115);
		add(panel_1);
		panel_1.setLayout(null);

		lblThongTin = new JLabel("Thông tin chi tiết hóa đơn");
		lblThongTin.setBounds(10, 10, 174, 19);
		panel_1.add(lblThongTin);
		lblThongTin.setFont(new Font("Tahoma", Font.PLAIN, 15));

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 39, 1395, 63);
		panel_1.add(scrollPane);

		table_CTHD = new JTable();
		table_CTHD.setRowHeight(40);
		table_CTHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_CTHD.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Mã chi tiết", "Mã hóa đơn", "Khách hàng", "Số lượng", "Thành tiền (Chưa thuế)", "Thuế GTGT", "Tổng tiền"
				}
				));
		scrollPane.setViewportView(table_CTHD);

		panel_2 = new JPanel();
		panel_2.setBounds(25, 190, 1425, 200);
		add(panel_2);
		panel_2.setLayout(null);

		lblNewLabel = new JLabel("Danh sách vé");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 160, 25);
		panel_2.add(lblNewLabel);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 40, 1395, 145);
		panel_2.add(scrollPane_1);

		table_DSV = new JTable();
		table_DSV.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"STT", "Mã vé", "Hạng", "Đối tượng", "Giá"
				}
				));
		table_DSV.setRowHeight(20);
		scrollPane_1.setViewportView(table_DSV);

		panel_3 = new JPanel();
		panel_3.setBounds(25, 411, 541, 150);
		add(panel_3);
		panel_3.setLayout(null);

		lblTienKhachDua = new JLabel("Tiền khách đưa");
		lblTienKhachDua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTienKhachDua.setBounds(26, 10, 123, 19);
		panel_3.add(lblTienKhachDua);

		textField_TienKhachDua = new JTextField("0 đ");
		textField_TienKhachDua.setBounds(20, 36, 415, 30);
		panel_3.add(textField_TienKhachDua);
		textField_TienKhachDua.setColumns(10);
		textField_TienKhachDua.setEditable(false);

		lblNewLabel_3 = new JLabel("Gợi ý tiền mặt");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(26, 75, 123, 24);
		panel_3.add(lblNewLabel_3);

		btn33 = new JButton("33.000");
		btn33.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn33.setBounds(26, 105, 142, 35);
		panel_3.add(btn33);

		btn35 = new JButton("35.000");
		btn35.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn35.setBounds(218, 105, 130, 35);
		panel_3.add(btn35);

		btn44 = new JButton("40.000");
		btn44.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn44.setBounds(394, 105, 137, 35);
		panel_3.add(btn44);
		
		btnXoa = new JButton("Nhập lại");
		btnXoa.setBounds(446, 36, 85, 30);
		panel_3.add(btnXoa);

		panel_4 = new JPanel();
		panel_4.setBounds(576, 411, 449, 150);
		add(panel_4);
		panel_4.setLayout(null);

		lblNewLabel_1 = new JLabel("Nhập số tiền theo mệnh giá");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 0, 209, 27);
		panel_4.add(lblNewLabel_1);

		btn500 = new JButton("500.000");
		btn500.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btn500.setBounds(30, 37, 107, 30);
		panel_4.add(btn500);

		btn200 = new JButton("200.000");
		btn200.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn200.setBounds(168, 37, 107, 30);
		panel_4.add(btn200);

		btn100 = new JButton("100.000");
		btn100.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn100.setBounds(310, 37, 107, 30);
		panel_4.add(btn100);

		btn50 = new JButton("50.000");
		btn50.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn50.setBounds(30, 73, 107, 30);
		panel_4.add(btn50);

		btn20 = new JButton("20.000");
		btn20.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn20.setBounds(168, 73, 107, 30);
		panel_4.add(btn20);

		btn10 = new JButton("10.000");
		btn10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn10.setBounds(310, 73, 107, 30);
		panel_4.add(btn10);

		btn5 = new JButton("5.000");
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn5.setBounds(30, 110, 107, 30);
		panel_4.add(btn5);

		btn2 = new JButton("2.000");
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn2.setBounds(168, 110, 107, 30);
		panel_4.add(btn2);

		btn1 = new JButton("1.000");
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn1.setBounds(310, 110, 107, 30);
		panel_4.add(btn1);

		panel_5 = new JPanel();
		panel_5.setBounds(1035, 411, 415, 150);
		add(panel_5);
		panel_5.setLayout(null);

		lblNewLabel_2 = new JLabel("Tiền khách trả lại");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 10, 132, 20);
		panel_5.add(lblNewLabel_2);

		textField_TienTraLai = new JTextField("0 đ");
		textField_TienTraLai.setBounds(10, 36, 395, 30);
		panel_5.add(textField_TienTraLai);
		textField_TienTraLai.setColumns(10);
		textField_TienTraLai.setEditable(false);

		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXacNhan.setBounds(10, 76, 97, 40);
		panel_5.add(btnXacNhan);

		btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHuy.setBounds(131, 76, 97, 40);
		panel_5.add(btnHuy);

		//Sự kiện nút
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn5.addActionListener(this);
		btn10.addActionListener(this);
		btn20.addActionListener(this);
		btn50.addActionListener(this);
		btn100.addActionListener(this);
		btn200.addActionListener(this);
		btn500.addActionListener(this);
		
		btn33.addActionListener(this);
		btn35.addActionListener(this);
		btn44.addActionListener(this);
		
		btnXoa.addActionListener(this);
		
		//Load dữ liệu vào bảng
		datatoTable_CTHD(qlhd);
		datatoTable_Ve(qlhd);
	}

	public void datatoTable_CTHD(QuanLyHoaDon_GUI qlhd) {
		dsCTHD= new ChiTietHoaDon_DAO();
		dsVe = new Ve_DAO();
		dsKH= new KhachHang_DAO();
		
		ChiTietHoaDon cthd = dsCTHD.getCTHDTheoMaChiTiet(qlhd.hoaDonTraVe.getChiTiet().getMaChiTiet());
		if(cthd != null) {
			String thueFormat = String.format("%.0f%%", cthd.getThue() * 100);
			tongTienCoThue= cthd.tinhTien();
			ArrayList<Ve> danhSachVe = dsVe.getDsVeTheoMaChiTiet(cthd.getMaChiTiet());
			KhachHang kh= dsKH.getKhachHangTheoMaKH(qlhd.hoaDonTraVe.getKhachHang().getMaKH());
			System.out.println(danhSachVe);
			for(Ve ve: danhSachVe) {
				tongTien+=ve.tinhGiaVe();
				System.out.println(tongTien);
			}
			model_CTHD = (DefaultTableModel) table_CTHD.getModel();
			model_CTHD.setRowCount(0); // Xóa tất cả hàng trong bảng
			model_CTHD.addRow(new Object[] { 
					cthd.getMaChiTiet(),
					cthd.getHoaDon().getMaHoaDon(),
					kh.getTenKH(),
					cthd.getSoLuong(), 
					dinhDangTienTe(tongTien),
					thueFormat, // Hiển thị thuế dưới dạng %
					dinhDangTienTe(tongTienCoThue) // Định dạng tổng tiền bao gồm thuế
			});
		}else {
			JOptionPane.showMessageDialog(null, "Không tìm thấy chi tiết hóa đơn", "Thông báo", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void datatoTable_Ve(QuanLyHoaDon_GUI qlhd) {
		dsVe = new Ve_DAO();
		dsCTHD = new ChiTietHoaDon_DAO();
		ArrayList<Ve> list= dsVe.getDsVeTheoMaChiTiet(qlhd.hoaDonTraVe.getChiTiet().getMaChiTiet());
		model_DSV = (DefaultTableModel) table_DSV.getModel();
		int stt = 1; // Biến đếm bắt đầu từ 1 cho STT
		for (Ve ve : list) {
			model_DSV.addRow(new Object[] { 
					stt++, 
					ve.getMaVe(),
					ve.getHang(),
					ve.getKhuyenMai(), 
					dinhDangTienTe(ve.tinhGiaVe())
					// Định dạng tổng tiền bao gồm thuế
			});}
	}
	public String dinhDangTienTe(double soTien) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		return formatter.format(soTien);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    Object o = e.getSource();
	    
	    if (o.equals(btnXoa)) {
	        tienKhachDua = 0;
	        // Hiển thị số tiền đã định dạng
	        tienTraLai = 0;
		    textField_TienKhachDua.setText(dinhDangTienTe(tienKhachDua));
		    textField_TienTraLai.setText(dinhDangTienTe(tienTraLai));
	    } else {
	        float soTienThem = 0;
	        
	        // Xác định số tiền cần thêm dựa trên nút bấm
	        if (o.equals(btn1)) soTienThem = 1000;
	        if (o.equals(btn2)) soTienThem = 2000;
	        if (o.equals(btn5)) soTienThem = 5000;
	        if (o.equals(btn10)) soTienThem = 10000;
	        if (o.equals(btn20)) soTienThem = 20000;
	        if (o.equals(btn50)) soTienThem = 50000;
	        if (o.equals(btn100)) soTienThem = 100000;
	        if (o.equals(btn200)) soTienThem = 200000;
	        if (o.equals(btn500)) soTienThem = 500000;
	        if (o.equals(btn33)) soTienThem = 33000;
	        if (o.equals(btn35)) soTienThem = 35000;
	        if (o.equals(btn44)) soTienThem = 44000;
	        
	        // Kiểm tra nếu text hiện tại là "0 đ" thì đặt `tienKhachDua` thành `soTienThem`
	        if (textField_TienKhachDua.getText().equalsIgnoreCase("0 đ")) {
	            tienKhachDua = soTienThem;
	            textField_TienKhachDua.setText(dinhDangTienTe(tienKhachDua)); // Cập nhật textField
	        } else {
	            tienKhachDua += soTienThem;
	            textField_TienKhachDua.setText(dinhDangTienTe(tienKhachDua));
	        }
	        tienTraLai = tienKhachDua - tongTienCoThue;
	        textField_TienTraLai.setText(dinhDangTienTe(tienTraLai));
	    }
	    
	}
}
