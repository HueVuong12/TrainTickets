package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import components.ConTent_JPanel;
import dao.Ca_DAO;
import dao.ChiTietHoaDon_DAO;
import dao.ChuyenTau_DAO;
import dao.HoaDon_DAO;
import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import dao.Ve_DAO;
import entity.Ca;
import entity.ChiTietHoaDon;
import entity.ChuyenTau;
import entity.HoaDon;
import entity.NhanVien;
import entity.TaiKhoan;
import entity.Ve;

import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JButton;

public class ThongKe_GUI extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JLabel lbl_quayLai;
	private JLabel goBackIconLabel;
	private JTabbedPane tabbedPane;
	private JPanel jp_tkdttheoca;
	private JPanel jp_ketQuaTheoCa;
	private JLabel caIconLabel;
	private JLabel lbl_ca;
	private JLabel lbl_titleC;
	private JLabel doanhThuTheoCaIconLabel;
	private JLabel lbl_doanhThuTheoCa;
	private JLabel lbl_titleDTTC;
	private JLabel sltvtcIconLabel;
	private JLabel lbl_sltvtc;
	private JLabel lbl_titleSLTVTC;
	private JLabel slvbtcIconLabel;
	private JLabel lbl_slvbtc;
	private JLabel lbl_titleSLVBTC;
	private ChartPanel chartPanelTheoCa_DTKM;
	private JPanel jp_tkdt;
	private JPanel jp_thoiGian;
	private JPanel jp_header;
	private JPanel jp_content;
	private JLabel lbl_doanhThu;
	private JLabel lbl_sltv;
	private JLabel lbl_slvb;
	private ChartPanel chartPanel;
	private JLabel lbl_doanhThuCT;
	private JLabel lbl_sltvct;
	private JLabel lbl_slvbct;
	private ChartPanel chartPanelCT;
	private JPanel jp_thoiGian1;
	private JPanel jp_header1;
	private JPanel jp_content1;
	private Color hoverLabelColor = new Color(0, 153, 255);
	private HoaDon_DAO dsHD = new HoaDon_DAO();
	private String tkdt_ngayBatDau;
	private String tkdt_ngayKetThuc;
	private JDateChooser dateChooser_TKDT_batDau;
	private JDateChooser dateChooser_TKDT_ketThuc;
	private ChiTietHoaDon_DAO dsCTHD = new ChiTietHoaDon_DAO();
	private Ve_DAO dsVe = new Ve_DAO();
	private DefaultCategoryDataset dataset;
	private JPanel jp_thongKe;
	private ChuyenTau_DAO dsCT = new ChuyenTau_DAO();
	private JDateChooser dateChooser_TKCT_batDau;
	private JDateChooser dateChooser_TKCT_ketThuc;
	private String tkct_ngayBatDau;
	private String tkct_ngayKetThuc;
	private JPanel jp_thongKeCT;
	private NhanVien_DAO dsNV = new NhanVien_DAO();
	private TrangChu_GUI trangChu;
	private DangNhap_GUI dangNhap;
	private TaiKhoan_DAO dsTK = new TaiKhoan_DAO();
	private Ca_DAO dsCa = new Ca_DAO();
	private JButton btnXem_TKDT;
	private JButton btnXem_TKCT;
	private JPanel jp_thongKeTheoKhuyenMai_TheoCa;
	private JPanel jp_thongKeTheoHang_TheoCa;
	private ChartPanel chartPanelTheoCa_Hang_SLKM;
	private ChartPanel chartPanelTheoCa_Hang_TKDTH;
	public ThongKe_GUI(TrangChu_GUI trangChu)  {
		this.trangChu = trangChu;
		setBackground(SystemColor.text);
		setForeground(new Color(255, 255, 255));
		setBounds(0, 170, 1460, 570);
		setLayout(null);

		//JPanel quay lại
		JPanel jp_quayLai = new JPanel();
		jp_quayLai.setBackground(SystemColor.text);
		jp_quayLai.setBounds(10, 0, 124, 47);
		add(jp_quayLai);
		jp_quayLai.setLayout(null);

		//Icon Quay lại
		ImageIcon goBackIcon = new ImageIcon(getClass().getResource("/img/9054423_bx_arrow_back_icon.png"));
		Image scaledGoBack = goBackIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		goBackIconLabel = new JLabel(new ImageIcon(scaledGoBack));
		jp_quayLai.add(goBackIconLabel);
		goBackIconLabel.setBounds(10, 10, 39, 27);
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
		lbl_quayLai.setBounds(45, 10, 69, 27);
		jp_quayLai.add(lbl_quayLai);

		// Khởi tạo tabbedPane
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(46, 61, 1373, 486);
		add(tabbedPane);
		tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 15));

		//TabbPane thống kê doanh thu theo ca
		jp_tkdttheoca = new JPanel();
		jp_tkdttheoca.setBackground(SystemColor.textHighlightText);
		tabbedPane.addTab("Thống kê doanh thu theo ca", null, jp_tkdttheoca, null);
		jp_tkdttheoca.setLayout(null);

		//JPane kết quả theo ca
		jp_ketQuaTheoCa = new JPanel();
		jp_ketQuaTheoCa.setBackground(SystemColor.controlHighlight);
		jp_ketQuaTheoCa.setBounds(29, 10, 1311, 115);
		jp_tkdttheoca.add(jp_ketQuaTheoCa);

		//Icon ca
		ImageIcon caIcon = new ImageIcon(getClass().getResource("/img/work-schedule.png"));
		Image scaledCa = caIcon.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		jp_ketQuaTheoCa.setLayout(null);
		caIconLabel = new JLabel(new ImageIcon(scaledCa));
		jp_ketQuaTheoCa.add(caIconLabel);
		caIconLabel.setBounds(66, 41, 40, 40);

		lbl_ca = new JLabel("");
		lbl_ca.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_ca.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ca.setBounds(111, 41, 114, 20);
		jp_ketQuaTheoCa.add(lbl_ca);

		lbl_titleC = new JLabel("Doanh thu");
		lbl_titleC.setBackground(SystemColor.windowBorder);
		lbl_titleC.setForeground(new Color(105, 105, 105));
		lbl_titleC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_titleC.setBounds(134, 65, 71, 13);
		jp_ketQuaTheoCa.add(lbl_titleC);

		//Icon Doanh Thu theo ca
		ImageIcon doanhThuTheoCaIcon = new ImageIcon(getClass().getResource("/img/coin_1.png"));
		Image scaledDoanhThuTheoCa = doanhThuTheoCaIcon.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		jp_ketQuaTheoCa.setLayout(null);
		doanhThuTheoCaIconLabel = new JLabel(new ImageIcon(scaledDoanhThuTheoCa));
		jp_ketQuaTheoCa.add(doanhThuTheoCaIconLabel);
		doanhThuTheoCaIconLabel.setBounds(334, 41, 40, 40);

		lbl_doanhThuTheoCa = new JLabel("200.000.000đ");
		lbl_doanhThuTheoCa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_doanhThuTheoCa.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_doanhThuTheoCa.setBounds(384, 41, 114, 20);
		jp_ketQuaTheoCa.add(lbl_doanhThuTheoCa);

		lbl_titleDTTC = new JLabel("Doanh thu");
		lbl_titleDTTC.setBackground(SystemColor.windowBorder);
		lbl_titleDTTC.setForeground(new Color(105, 105, 105));
		lbl_titleDTTC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_titleDTTC.setBounds(406, 68, 71, 13);
		jp_ketQuaTheoCa.add(lbl_titleDTTC);

		//Icon số lượng trả vé theo ca
		ImageIcon sltvtcIcon = new ImageIcon(getClass().getResource("/img/money-back_1.png"));
		Image scaledSLTVTC = sltvtcIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		jp_ketQuaTheoCa.setLayout(null);
		sltvtcIconLabel = new JLabel(new ImageIcon(scaledSLTVTC));
		jp_ketQuaTheoCa.add(sltvtcIconLabel);
		sltvtcIconLabel.setBounds(615, 41, 40, 40);

		lbl_sltvtc = new JLabel("15");
		lbl_sltvtc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_sltvtc.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sltvtc.setBounds(665, 41, 114, 20);
		jp_ketQuaTheoCa.add(lbl_sltvtc);

		lbl_titleSLTVTC = new JLabel("Số lượng trả vé");
		lbl_titleSLTVTC.setBackground(SystemColor.windowBorder);
		lbl_titleSLTVTC.setForeground(new Color(105, 105, 105));
		lbl_titleSLTVTC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_titleSLTVTC.setBounds(675, 61, 104, 20);
		jp_ketQuaTheoCa.add(lbl_titleSLTVTC);

		//Icon số lượng vé bán theo ca
		ImageIcon slvbtcIcon = new ImageIcon(getClass().getResource("/img/loan_1.png"));
		Image scaledSLVBTC = slvbtcIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		jp_ketQuaTheoCa.setLayout(null);
		slvbtcIconLabel = new JLabel(new ImageIcon(scaledSLVBTC));
		jp_ketQuaTheoCa.add(slvbtcIconLabel);
		slvbtcIconLabel.setBounds(888, 41, 40, 40);

		lbl_slvbtc = new JLabel("100");
		lbl_slvbtc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_slvbtc.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_slvbtc.setBounds(938, 41, 114, 20);
		jp_ketQuaTheoCa.add(lbl_slvbtc);

		lbl_titleSLVBTC = new JLabel("Số lượng vé bán");
		lbl_titleSLVBTC.setBackground(SystemColor.windowBorder);
		lbl_titleSLVBTC.setForeground(new Color(105, 105, 105));
		lbl_titleSLVBTC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_titleSLVBTC.setBounds(948, 61, 126, 20);
		jp_ketQuaTheoCa.add(lbl_titleSLVBTC);
		System.out.println("đúng");

		//JPane chứa thống kê theo ca
		JPanel jp_thongKeTheoCa = new JPanel();
		jp_thongKeTheoCa.setBounds(28, 133, 1311, 308);
		jp_tkdttheoca.add(jp_thongKeTheoCa);
		
		
		//JFreeChat thống kê theo đối tượng khuyến mãi
		//Khởi tạo dữ liệu
		DefaultCategoryDataset datasetTheoDoiTuongKhuyenMai = createDatasetTKTheoCa(trangChu);
		// Create chart
		JFreeChart chartDoiTuongKhuyenMai = ChartFactory.createBarChart(
				"Thống kê doanh thu theo đối tượng khuyến mãi",
				"Đối tượng bán",
				"Doanh thu",
				datasetTheoDoiTuongKhuyenMai
				);
		// Tạo ChartPanel và thiết lập kích thước
		chartPanelTheoCa_DTKM = new ChartPanel(chartDoiTuongKhuyenMai);
		jp_thongKeTheoCa.setLayout(null);
		// Giảm kích cỡ chữ cho tiêu đề
		chartDoiTuongKhuyenMai.getTitle().setFont(new Font("Arial", Font.PLAIN, 16));
		
		//JFreeChat Hiển thị số lượng khách mua theo PieChart
		//Khởi tạo dữ liệu
		DefaultPieDataset dataset = createDatasetPieChart(trangChu);
		// Create chart
		// Tạo biểu đồ bánh
		JFreeChart chartTheoHang_SLKM = ChartFactory.createPieChart(
		        "Số lượng khách mua", // Tiêu đề biểu đồ
		        dataset,                                     // Dataset
		        true,                                             // Hiển thị legend?
		        true,                                             // Hiển thị tooltips?
		        false);                                           // Hiển thị URLs?
		chartPanelTheoCa_Hang_SLKM = new ChartPanel(chartTheoHang_SLKM);
		// Giảm kích cỡ chữ cho tiêu đề
		chartTheoHang_SLKM.getTitle().setFont(new Font("Arial", Font.PLAIN, 16));
		// Tạo ChartPanel và thiết lập kích thước
		
		DefaultCategoryDataset datasetTKDTTheoHang = createDatasetTKHangTheoCa(trangChu);
		// Create chart
		JFreeChart chartDoanhThuTheoHang = ChartFactory.createBarChart(
				"Thống kê doanh thu theo hạng",
				"Đối tượng bán",
				"Doanh thu",
				datasetTKDTTheoHang,
				PlotOrientation.HORIZONTAL,
				true,                     // Hiển thị legend?
	            true,                     // Hiển thị tooltips?
	            false                     // Hiển thị URLs?// Chỉ định chiều ngang cho biểu đồ
				);
		// Tạo ChartPanel và thiết lập kích thước
		chartPanelTheoCa_Hang_TKDTH= new ChartPanel(chartDoanhThuTheoHang);
		
		chartDoanhThuTheoHang.getTitle().setFont(new Font("Arial", Font.PLAIN, 16));
		JTabbedPane tabbedPane_theoCa = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane_theoCa.setBounds(10, 10, 1290, 288);
		jp_thongKeTheoCa.add(tabbedPane_theoCa);
		
		
		jp_thongKeTheoKhuyenMai_TheoCa = new JPanel();
		tabbedPane_theoCa.addTab("Đối tượng", null, jp_thongKeTheoKhuyenMai_TheoCa, null);
		jp_thongKeTheoKhuyenMai_TheoCa.setLayout(null);
		chartPanelTheoCa_DTKM.setBounds(0, 0,  1205, 280);
		// Thêm ChartPanel vào jp_thongKe
		jp_thongKeTheoKhuyenMai_TheoCa.add(chartPanelTheoCa_DTKM);
		
		jp_thongKeTheoHang_TheoCa = new JPanel();
		tabbedPane_theoCa.addTab("Hạng", null, jp_thongKeTheoHang_TheoCa, null);
		jp_thongKeTheoHang_TheoCa.setLayout(null);
		//add PieChart số lượng khách mua
		chartPanelTheoCa_Hang_SLKM.setBounds(0, 0, 500, 280);
		// Thêm ChartPanel vào jp_thongKe
		jp_thongKeTheoHang_TheoCa.add(chartPanelTheoCa_Hang_SLKM);
		
		//add Barchart thống kê doanh thu theo hạng
		chartPanelTheoCa_Hang_TKDTH.setBounds(510, 0 ,700, 280);
		jp_thongKeTheoHang_TheoCa.add(chartPanelTheoCa_Hang_TKDTH);
		//TabbPane thống kê doanh thu
		jp_tkdt = new JPanel();
		jp_tkdt.setBackground(SystemColor.text);
		tabbedPane.addTab("Thống kê doanh thu", null, jp_tkdt, null);
		jp_tkdt.setLayout(null);

		//JPane thời gian 
		jp_thoiGian = new JPanel();
		jp_thoiGian.setBackground(Color.WHITE);
		jp_thoiGian.setBounds(28, 10, 374, 115);
		jp_tkdt.add(jp_thoiGian);
		jp_thoiGian.setLayout(null);

		//JPane header chưa tiêu đề 
		jp_header = new JPanel();
		jp_header.setBackground(new Color(51, 102, 153));
		jp_header.setBounds(0, 0, 374, 35);
		jp_thoiGian.add(jp_header);
		jp_header.setLayout(null);

		//JLabel tiêu đề 
		JLabel lblNewLabel_2 = new JLabel("Thời gian");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(0, 0, 95, 35);
		jp_header.add(lblNewLabel_2);
		
		btnXem_TKDT = new JButton("Xem");
		btnXem_TKDT.setBounds(279, 10, 85, 21);
		jp_header.add(btnXem_TKDT);


		//Icon xổ xuống
		ImageIcon downIcon = new ImageIcon(getClass().getResource("/img/Polygon_20.png"));
		Image scaledDown = downIcon.getImage().getScaledInstance(20 ,20, Image.SCALE_SMOOTH);

		//JPane chứa content
		jp_content = new JPanel();
		jp_content.setBackground(SystemColor.controlHighlight);
		jp_content.setBounds(0, 36, 374, 79);
		jp_thoiGian.add(jp_content);
		jp_content.setLayout(null);

		// Ngày bắt đầu 
		dateChooser_TKDT_batDau = new JDateChooser();
		dateChooser_TKDT_batDau.setDateFormatString("dd/MM/yyyy");
		dateChooser_TKDT_batDau.setBounds(32, 5, 301, 29);
		jp_content.add(dateChooser_TKDT_batDau);
		// Thêm sự kiện khi người dùng chọn ngày để xóa chữ gợi ý
		dateChooser_TKDT_batDau.getDateEditor().addPropertyChangeListener("date", evt -> {
			Date selectedDate = dateChooser_TKDT_batDau.getDate();
			if (selectedDate != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				tkdt_ngayBatDau= dateFormat.format(selectedDate);
				System.out.println("Ngày bắt đầu"+tkdt_ngayBatDau);
			} else {
				tkdt_ngayBatDau = "";  // Đặt lại chữ gợi ý nếu không có ngày nào được chọn
			}
		});

		//Ngày kết thúc
		dateChooser_TKDT_ketThuc = new JDateChooser();
		dateChooser_TKDT_ketThuc.setDateFormatString("dd/MM/yyyy");
		dateChooser_TKDT_ketThuc.setBounds(32, 40, 301, 29);
		jp_content.add(dateChooser_TKDT_ketThuc);
		// Thêm sự kiện khi người dùng chọn ngày để xóa chữ gợi ý
		dateChooser_TKDT_ketThuc.getDateEditor().addPropertyChangeListener("date", evt -> {
			Date selectedDate = dateChooser_TKDT_ketThuc.getDate();
			if (selectedDate != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				tkdt_ngayKetThuc= dateFormat.format(selectedDate);
				System.out.println("Ngày kết thúc"+ tkdt_ngayKetThuc);
			} else {
				tkdt_ngayBatDau = "";  // Đặt lại chữ gợi ý nếu không có ngày nào được chọn
			}
		});
		//JPane chứa kết quả thống kê
		JPanel jp_ketQua = new JPanel();
		jp_ketQua.setBackground(SystemColor.controlHighlight);
		jp_ketQua.setBounds(412, 10, 928, 115);
		jp_tkdt.add(jp_ketQua);

		//Icon Doanh Thu
		ImageIcon doanhThuIcon = new ImageIcon(getClass().getResource("/img/coin_1.png"));
		Image scaledDoanhThu = doanhThuIcon.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		jp_ketQua.setLayout(null);
		JLabel doanhThuIconLabel = new JLabel(new ImageIcon(scaledDoanhThu));
		jp_ketQua.add(doanhThuIconLabel);
		doanhThuIconLabel.setBounds(66, 41, 40, 40);

		lbl_doanhThu = new JLabel();
		lbl_doanhThu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_doanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_doanhThu.setBounds(111, 41, 114, 20);
		jp_ketQua.add(lbl_doanhThu);

		JLabel lbl_titleDT = new JLabel("Doanh thu");
		lbl_titleDT.setBackground(SystemColor.windowBorder);
		lbl_titleDT.setForeground(new Color(105, 105, 105));
		lbl_titleDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_titleDT.setBounds(134, 65, 114, 13);
		jp_ketQua.add(lbl_titleDT);

		//Icon số lượng trả vé
		ImageIcon sltvIcon = new ImageIcon(getClass().getResource("/img/money-back_1.png"));
		Image scaledSLTV = sltvIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		jp_ketQua.setLayout(null);
		JLabel sltvIconLabel = new JLabel(new ImageIcon(scaledSLTV));
		jp_ketQua.add(sltvIconLabel);
		sltvIconLabel.setBounds(292, 41, 40, 40);

		lbl_sltv = new JLabel();
		lbl_sltv.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_sltv.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sltv.setBounds(342, 41, 114, 20);
		jp_ketQua.add(lbl_sltv);

		JLabel lbl_titleSLTV = new JLabel("Số lượng trả vé");
		lbl_titleSLTV.setBackground(SystemColor.windowBorder);
		lbl_titleSLTV.setForeground(new Color(105, 105, 105));
		lbl_titleSLTV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_titleSLTV.setBounds(352, 61, 104, 20);
		jp_ketQua.add(lbl_titleSLTV);


		//Icon số lượng vé bán
		ImageIcon slvbIcon = new ImageIcon(getClass().getResource("/img/loan_1.png"));
		Image scaledSLVB = slvbIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		jp_ketQua.setLayout(null);
		JLabel slvbIconLabel = new JLabel(new ImageIcon(scaledSLVB));
		jp_ketQua.add(slvbIconLabel);
		slvbIconLabel.setBounds(519, 41, 40, 40);

		lbl_slvb = new JLabel();
		lbl_slvb.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_slvb.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_slvb.setBounds(569, 41, 114, 20);
		jp_ketQua.add(lbl_slvb);

		JLabel lbl_titleSLVB = new JLabel("Số lượng vé bán");
		lbl_titleSLVB.setBackground(SystemColor.windowBorder);
		lbl_titleSLVB.setForeground(new Color(105, 105, 105));
		lbl_titleSLVB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_titleSLVB.setBounds(579, 61, 126, 20);
		jp_ketQua.add(lbl_titleSLVB);
		System.out.println("đúng");

		//JPane chứa JFreeChat
		jp_thongKe = new JPanel();
		jp_thongKe.setBounds(28, 133, 1311, 308);
		System.out.println("đúng");
		jp_thongKe.setBackground(SystemColor.controlHighlight);
		jp_tkdt.add(jp_thongKe);
		jp_thongKe.setLayout(null);


		//TabbPane thống kê chuyến tàu
		JPanel jp_tkct = new JPanel();
		jp_tkct.setBackground(SystemColor.textHighlightText);
		tabbedPane.addTab("Thống kê chuyến tàu", null, jp_tkct, null);
		jp_tkct.setLayout(null);

		//JPane thời gian 
		jp_thoiGian1 = new JPanel();
		jp_thoiGian1.setBackground(Color.WHITE);
		jp_thoiGian1.setBounds(28, 10, 374, 115);
		jp_tkct.add(jp_thoiGian1);
		jp_thoiGian1.setLayout(null);

		//JPane header chưa tiêu đề 
		jp_header1 = new JPanel();
		jp_header1.setBackground(new Color(51, 102, 153));
		jp_header1.setBounds(0, 0, 374, 35);
		jp_thoiGian1.add(jp_header1);
		jp_header1.setLayout(null);
		//JLabel tiêu đề 
		JLabel lblNewLabel_3 = new JLabel("Thời gian");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(0, 0, 95, 35);
		jp_header1.add(lblNewLabel_3);


		//Icon xổ xuống
		ImageIcon downIcon1 = new ImageIcon(getClass().getResource("/img/Polygon_20.png"));
		Image scaledDown1 = downIcon1.getImage().getScaledInstance(20 ,20, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		JLabel downIconLabel1 = new JLabel(new ImageIcon(scaledDown1));
		jp_header1.add(downIconLabel1);
		
		btnXem_TKCT = new JButton("Xem");
		btnXem_TKCT.setBounds(279, 10, 85, 21);
		jp_header1.add(btnXem_TKCT);

		//			ImageIcon downIcon = new ImageIcon(getClass().getResource("/img/510869_calendar_date_event_schedule_icon.png"));
		//			System.out.println(downIcon);
		//		    Image scaledDown = downIcon.getImage().getScaledInstance(20 ,20, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		//		    JLabel downIconLabel = new JLabel(new ImageIcon(scaledDown));
		//		    downIconLabel.setBounds(242 ,0 , 29 ,35); // Cập nhật kích thước trên JLabel
		//		    jp_header.add(downIconLabel);
		
		//JPane chứa content
		jp_content1 = new JPanel();
		jp_content1.setBackground(SystemColor.controlHighlight);
		jp_content1.setBounds(0, 36, 374, 79);
		jp_thoiGian1.add(jp_content1);
		jp_content1.setLayout(null);

		dateChooser_TKCT_batDau = new JDateChooser();
		dateChooser_TKCT_batDau.setDateFormatString("dd/MM/yyyy");
		dateChooser_TKCT_batDau.setBounds(32, 5, 301, 29);
		jp_content1.add(dateChooser_TKCT_batDau);
		dateChooser_TKCT_batDau.getDateEditor().addPropertyChangeListener("date", evt -> {
			Date selectedDate = dateChooser_TKCT_batDau.getDate();
			if (selectedDate != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				tkct_ngayBatDau= dateFormat.format(selectedDate);
				System.out.println("Ngày bắt đầu ct"+tkct_ngayBatDau);
			} else {
				tkct_ngayBatDau = "";  // Đặt lại chữ gợi ý nếu không có ngày nào được chọn
			}
		});

		dateChooser_TKCT_ketThuc = new JDateChooser();
		dateChooser_TKCT_ketThuc.setDateFormatString("dd/MM/yyyy");
		dateChooser_TKCT_ketThuc.setBounds(32, 40, 301, 29);
		jp_content1.add(dateChooser_TKCT_ketThuc);
		dateChooser_TKCT_ketThuc.getDateEditor().addPropertyChangeListener("date", evt -> {
			Date selectedDate = dateChooser_TKCT_ketThuc.getDate();
			if (selectedDate != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				tkct_ngayKetThuc= dateFormat.format(selectedDate);
				System.out.println("Ngày kết thúc ct"+tkct_ngayKetThuc);
			} else {
				tkct_ngayKetThuc = "";  // Đặt lại chữ gợi ý nếu không có ngày nào được chọn
			}
		});

		//JPane kết quả chuyến tàu
		JPanel jp_ketQuaCT = new JPanel();
		jp_ketQuaCT.setBackground(SystemColor.controlHighlight);
		jp_ketQuaCT.setBounds(412, 10, 928, 115);
		jp_tkct.add(jp_ketQuaCT);

		//Icon Doanh Thu chuyến tàu
		ImageIcon doanhThuCTIcon = new ImageIcon(getClass().getResource("/img/coin_1.png"));
		Image scaledDoanhThuCT = doanhThuCTIcon.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		jp_ketQuaTheoCa.setLayout(null);
		jp_ketQuaCT.setLayout(null);
		JLabel doanhThuCTIconLabel = new JLabel(new ImageIcon(scaledDoanhThuCT));
		jp_ketQuaCT.add(doanhThuCTIconLabel);
		doanhThuCTIconLabel.setBounds(66, 41, 40, 40);

		lbl_doanhThuCT = new JLabel("");
		lbl_doanhThuCT.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_doanhThuCT.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_doanhThuCT.setBounds(111, 41, 114, 20);
		jp_ketQuaCT.add(lbl_doanhThuCT);

		JLabel lbl_titleDTCT = new JLabel("Doanh thu");
		lbl_titleDTCT.setBackground(SystemColor.windowBorder);
		lbl_titleDTCT.setForeground(new Color(105, 105, 105));
		lbl_titleDTCT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_titleDTCT.setBounds(134, 65, 71, 13);
		jp_ketQuaCT.add(lbl_titleDTCT);

		//Icon số lượng trả vé chuyến tàu
		ImageIcon sltvctIcon = new ImageIcon(getClass().getResource("/img/money-back_1.png"));
		Image scaledSLTVCT = sltvctIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		jp_ketQuaCT.setLayout(null);
		JLabel sltvctIconLabel = new JLabel(new ImageIcon(scaledSLTVCT));
		jp_ketQuaCT.add(sltvctIconLabel);
		sltvctIconLabel.setBounds(334, 41, 40, 40);

		lbl_sltvct = new JLabel("");
		lbl_sltvct.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_sltvct.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sltvct.setBounds(384, 41, 114, 20);
		jp_ketQuaCT.add(lbl_sltvct);

		JLabel lbl_titleSLTVCT = new JLabel("Số lượng trả vé");
		lbl_titleSLTVCT.setBackground(SystemColor.windowBorder);
		lbl_titleSLTVCT.setForeground(new Color(105, 105, 105));
		lbl_titleSLTVCT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_titleSLTVCT.setBounds(406, 61, 103, 20);
		jp_ketQuaCT.add(lbl_titleSLTVCT);

		//Icon số lượng vé bán chuyến tàu
		ImageIcon slvbctIcon = new ImageIcon(getClass().getResource("/img/loan_1.png"));
		Image scaledSLVBCT = slvbctIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		jp_ketQuaCT.setLayout(null);
		JLabel slvbctIconLabel = new JLabel(new ImageIcon(scaledSLVBCT));
		jp_ketQuaCT.add(slvbctIconLabel);
		slvbctIconLabel.setBounds(615, 41, 40, 40);

		lbl_slvbct = new JLabel("");
		lbl_slvbct.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_slvbct.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_slvbct.setBounds(665, 41, 114, 20);
		jp_ketQuaCT.add(lbl_slvbct);

		JLabel lbl_titleSLVBCT = new JLabel("Số lượng vé bán");
		lbl_titleSLVBCT.setBackground(SystemColor.windowBorder);
		lbl_titleSLVBCT.setForeground(new Color(105, 105, 105));
		lbl_titleSLVBCT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_titleSLVBCT.setBounds(675, 61, 114, 20);
		jp_ketQuaCT.add(lbl_titleSLVBCT);
		System.out.println("đúng");

		//JPane chứa thống kê theo chuyến tàu
		jp_thongKeCT = new JPanel();
		jp_thongKeCT.setBackground(SystemColor.controlHighlight);
		jp_thongKeCT.setBounds(28, 133, 1311, 308);
		jp_tkct.add(jp_thongKeCT);
		
		btnXem_TKDT.addActionListener(this);
		btnXem_TKCT.addActionListener(this);
		// Thiết lập màu nền cho tab hiện tại
		//        tabbedPane.setBackgroundAt(0, Color.LIGHT_GRAY);
		//        tabbedPane.setBackgroundAt(1, Color.LIGHT_GRAY);
		//        tabbedPane.setBackgroundAt(2, Color.LIGHT_GRAY);
		updateKetQuaThongKeTheoCa(trangChu);
		kiemTraQuyen(trangChu);
	}

	//Chọn 1 radio để thực hiện
	@Override
	public void actionPerformed(ActionEvent e) {
		// Kiểm tra nút radio nào được chọn
		Object o = e.getSource();
		if (o.equals(btnXem_TKDT)) {
			updateKetQuaThongKeDoanhThu();
			createJFreeChartThongKeDoanhThu();
		}
		if(o.equals(btnXem_TKCT)) {
			updateKetQuaThongKeChuyenTau();
			createJFreeChartThongKeChuyenTau();
		}
	}
	//Hàm truy vấn thông tin gán vào label của thống kê theo ca
	public void updateKetQuaThongKeTheoCa(TrangChu_GUI trangChu) {
		dsTK.reset();
		dsNV.reset(); 
		dsHD.reset();
		dsVe.reset();
		dsCTHD.reset();
		dsCa.reset();
		float doanhThu = 0;
		int slvb = 0;
		int sltv = 0;
		Map<String, Float> doanhThuTheoKhuyenMai = new HashMap<>();

		// Lấy thông tin nhân viên theo tên
		NhanVien nv = dsNV.getNhanVienTheoTenNV(trangChu.lbl_ThongTinNV.getText());
		if (nv == null) {
			System.out.println("Không tìm thấy nhân viên với tên: " + trangChu.lbl_ThongTinNV.getText());
			return;
		}

		// Lấy thông tin ca làm
		Ca ca = dsCa.getCaTheoMaCa(nv.getCa().getMaCa());
		if (ca == null) {
			System.out.println("Không tìm thấy ca với mã: " + nv.getCa().getMaCa());
			return;
		}
		LocalTime thoiGianBatDauCa = ca.getThoiGianBatDau();
		LocalTime thoiGianKetThucCa = ca.getThoiGianKetThuc();

		// Lấy danh sách hóa đơn của nhân viên
		ArrayList<HoaDon> listHD = dsHD.getHoaDonTheoMaNV(nv.getMaNV());
		if (listHD == null) {
			System.out.println("Không có hóa đơn nào cho nhân viên với mã: " + nv.getMaNV());
			return;
		}

		// Duyệt qua từng hóa đơn và kiểm tra thời gian
		for (HoaDon hd : listHD) {
			LocalTime thoiGianHoaDon = hd.getNgayLapHoaDon().toLocalTime();
			if (thoiGianHoaDon.isBefore(thoiGianBatDauCa) || thoiGianHoaDon.isAfter(thoiGianKetThucCa)) {
				continue; // Bỏ qua hóa đơn ngoài khoảng thời gian ca
			}

			ChiTietHoaDon cthd = dsCTHD.getCTHDTheoMaChiTiet(hd.getChiTiet().getMaChiTiet());
			if (cthd != null) {
				ArrayList<Ve> listVe = dsVe.getDsVeTheoMaChiTiet(cthd.getMaChiTiet());
				doanhThu += cthd.tinhTien();

				for (Ve ve : listVe) {
					slvb++;
					String khuyenMai = ve.getKhuyenMai();
					doanhThuTheoKhuyenMai.put(khuyenMai,
							doanhThuTheoKhuyenMai.getOrDefault(khuyenMai, 0f) + ve.tinhGiaVe());
				}
			} else {
				System.out.println("Chi tiết hóa đơn không tồn tại cho mã chi tiết: " + hd.getChiTiet().getMaChiTiet());
			}
		}

		// Tính số lượng vé tồn tại chưa hoàn vé
		for (HoaDon hd : listHD) {
			LocalTime thoiGianHoaDon = hd.getNgayLapHoaDon().toLocalTime();
			if (!hd.getDaHoanVe() && !thoiGianHoaDon.isBefore(thoiGianBatDauCa) && !thoiGianHoaDon.isAfter(thoiGianKetThucCa)) {
				ChiTietHoaDon cthd = dsCTHD.getCTHDTheoMaChiTiet(hd.getChiTiet().getMaChiTiet());
				if (cthd != null) {
					ArrayList<Ve> listVe = dsVe.getDsVeTheoMaChiTiet(cthd.getMaChiTiet());
					sltv += listVe.size();
				}
			}
		}

		// Hiển thị kết quả doanh thu theo khuyến mãi
		for (Map.Entry<String, Float> entry : doanhThuTheoKhuyenMai.entrySet()) {
			System.out.println("Khuyến mãi: " + entry.getKey() + ", Doanh thu: " + entry.getValue());
		}

		// Gán giá trị cho các label
		lbl_ca.setText(nv.getCa().getMaCa());
		lbl_doanhThuTheoCa.setText(dinhDangTienTe(doanhThu));
		lbl_slvbtc.setText(String.valueOf(slvb));
		lbl_sltvtc.setText(String.valueOf(sltv));
	}

	//Hàm truy vấn thông tin gán vào label 
	public void updateKetQuaThongKeDoanhThu() {
		dsHD.reset();
		dsVe.reset();
		dsCTHD.reset();
		float doanhThu = 0; 
		SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedNgayBatDau = sqlDateFormat.format(dateChooser_TKDT_batDau.getDate());
		String formattedNgayKetThuc = sqlDateFormat.format(dateChooser_TKDT_ketThuc.getDate());
		if (!formattedNgayBatDau.isEmpty() && !formattedNgayKetThuc.isEmpty()) {
			// Lấy danh sách hóa đơn theo khoảng thời gian
			ArrayList<HoaDon> listHD = dsHD.getHoaDonTheoNgayLapHD(formattedNgayBatDau, formattedNgayKetThuc);
			Map<String, Float> doanhThuTheoKhuyenMai = new HashMap<>();
			int slvb=0;
			int sltv=0;
			// Duyệt qua từng hóa đơn
			for (HoaDon hd : listHD) {
				ChiTietHoaDon cthd = dsCTHD.getCTHDTheoMaChiTiet(hd.getChiTiet().getMaChiTiet());
				// Kiểm tra cthd có null hay không
				if (cthd != null) {
					ArrayList<Ve> listVe = dsVe.getDsVeTheoMaChiTiet(cthd.getMaChiTiet());
					doanhThu += cthd.tinhTien();
					System.out.println(doanhThu);
					for (Ve ve : listVe) {
						slvb++;
						String khuyenMai = ve.getKhuyenMai(); // Lấy mã khuyến mãi của vé
						// Cộng doanh thu vào khuyến mãi tương ứng
						doanhThuTheoKhuyenMai.put(khuyenMai, 
								doanhThuTheoKhuyenMai.getOrDefault(khuyenMai, 0f) +ve.tinhGiaVe());
					}
				} else {
					System.out.println("Chi tiết hóa đơn không tồn tại cho mã chi tiết: " + hd.getChiTiet().getMaChiTiet());
				}
			}
			for(HoaDon hd: listHD) {
				if(!hd.getDaHoanVe()) {
					ChiTietHoaDon cthd = dsCTHD.getCTHDTheoMaChiTiet(hd.getChiTiet().getMaChiTiet());
					ArrayList<Ve> listVe = dsVe.getDsVeTheoMaChiTiet(cthd.getMaChiTiet());
					sltv = listVe.size();
				}
			}

			// Hiển thị kết quả doanh thu theo khuyến mãi
			for (Map.Entry<String, Float> entry : doanhThuTheoKhuyenMai.entrySet()) {
				System.out.println("Khuyến mãi: " + entry.getKey() + ", Doanh thu: " + entry.getValue());
				//				doanhThu +=entry.getValue();
			}
			lbl_doanhThu.setText(dinhDangTienTe(doanhThu));
			lbl_slvb.setText(String.valueOf(slvb));
			lbl_sltv.setText(String.valueOf(sltv));
		}else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày bắt đầu và ngày kết thúc.");
		} 
	}

	//Hàm truy vấn thông tin gán vào JLabel của thống kê chuyến tàu
	public void updateKetQuaThongKeChuyenTau() {
		dsHD.reset();
		dsVe.reset();
		dsCTHD.reset();
		float doanhThu = 0; 
		SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedNgayBatDau = sqlDateFormat.format(dateChooser_TKCT_batDau.getDate());
		String formattedNgayKetThuc = sqlDateFormat.format(dateChooser_TKCT_ketThuc.getDate());
		if (!formattedNgayBatDau.isEmpty() && !formattedNgayKetThuc.isEmpty()) {
			// Lấy danh sách hóa đơn theo khoảng thời gian
			ArrayList<HoaDon> listHD = dsHD.getHoaDonTheoNgayLapHD(formattedNgayBatDau, formattedNgayKetThuc);
			Map<String, Float> doanhThuTheoChuyenTau = new HashMap<>();
			int slvb=0;
			int sltv=0;
			// Duyệt qua từng hóa đơn
			for (HoaDon hd : listHD) {
				ChiTietHoaDon cthd = dsCTHD.getCTHDTheoMaChiTiet(hd.getChiTiet().getMaChiTiet());
				// Kiểm tra cthd có null hay không
				if (cthd != null) {
					ArrayList<Ve> listVe = dsVe.getDsVeTheoMaChiTiet(cthd.getMaChiTiet());
					doanhThu += cthd.tinhTien();
					System.out.println(doanhThu);
					// Sử dụng một Set để theo dõi mã chuyến tàu đã được xử lý
					Set<String> processedChuyenTau = new HashSet<>();

					for (Ve ve : listVe) {
						String chuyenTau = ve.getChuyenTau().getMaTau(); // Lấy mã chuyến tàu
						System.out.println("Mã chuyến tàu: " + chuyenTau);

						// Kiểm tra xem mã chuyến tàu đã được xử lý chưa
						if (!processedChuyenTau.contains(chuyenTau)) {
							// Cộng doanh thu vào chuyến tàu tương ứng
							doanhThuTheoChuyenTau.put(chuyenTau, doanhThuTheoChuyenTau.getOrDefault(chuyenTau, 0f) + doanhThu);
							processedChuyenTau.add(chuyenTau); // Đánh dấu là đã xử lý
							System.out.println("Cập nhật doanh thu: " + doanhThuTheoChuyenTau);
						}
					}
				} else {
					System.out.println("Chi tiết hóa đơn không tồn tại cho mã chi tiết: " + hd.getChiTiet().getMaChiTiet());
				}
			}
			for(HoaDon hd: listHD) {
				if(!hd.getDaHoanVe()) {
					ChiTietHoaDon cthd = dsCTHD.getCTHDTheoMaChiTiet(hd.getChiTiet().getMaChiTiet());
					ArrayList<Ve> listVe = dsVe.getDsVeTheoMaChiTiet(cthd.getMaChiTiet());
					sltv = listVe.size();
				}
			}

			lbl_doanhThuCT.setText(dinhDangTienTe(doanhThu));
			lbl_slvbct.setText(String.valueOf(slvb));
			lbl_sltvct.setText(String.valueOf(sltv));
		}else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày bắt đầu và ngày kết thúc.");
		} 
	}
	//Hàm tạo và thêm jfreechart vào jp_thongKe(Thống kê doanh thu)
	public void createJFreeChartThongKeDoanhThu() {
		//JFreeChat thống kê theo khuyến mãi
		//Khởi tạo dữ liệu
		DefaultCategoryDataset dataset = createDatasetDoanhThu();
		// Create chart
		JFreeChart chart = ChartFactory.createBarChart(
				"Thống kê doanh thu",
				"Đối tượng bán",
				"Doanh thu",
				dataset
				);

		// Giảm kích cỡ chữ cho tiêu đề
		chart.getTitle().setFont(new Font("Arial", Font.PLAIN, 16));
		// Tạo ChartPanel và thiết lập kích thước
		chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(0,0, 1311, 308);
		// Thêm ChartPanel vào jp_thongKe
		jp_thongKe.add(chartPanel);
		jp_thongKe.revalidate(); // Cập nhật lại giao diện
		jp_thongKe.repaint(); // Vẽ lại panel
	}


	//Hàm tạo và thêm jfreechart vào jp_thongKe(Thống kê chuyến tàu)
	public void createJFreeChartThongKeChuyenTau() {

		//JFreeChat thống kê theo chuyến tàu
		//Khởi tạo dữ liệu
		DefaultCategoryDataset datasetCT = createDatasetChuyenTau();  // dsCTHD là danh sách chi tiết hóa đơn
		JFreeChart chartCT = ChartFactory.createBarChart(
				"Thống kê chuyến tàu",
				"Chuyến tàu",
				"Doanh thu",
				datasetCT
				);

		// Giảm kích cỡ chữ cho tiêu đề
		chartCT.getTitle().setFont(new Font("Arial", Font.PLAIN, 16));
		// Tạo ChartPanel và thiết lập kích thước
		chartPanelCT = new ChartPanel(chartCT);
		jp_thongKeCT.setLayout(null);
		chartPanelCT.setBounds(0, 0, 1313, 308);
		// Thêm ChartPanel vào jp_thongKe
		jp_thongKeCT.add(chartPanelCT);

		Color[] colors = {Color.ORANGE}; // Thêm màu theo nhu cầu
		// Tùy chỉnh màu cho các cột
		CategoryPlot plot = chartCT.getCategoryPlot(); // Lấy CategoryPlot
		BarRenderer renderer = (BarRenderer) plot.getRenderer(); // Lấy renderer
		// Thiết lập màu cho tất cả các series
		for (int i = 0; i < datasetCT.getRowCount(); i++) {
			if (i < colors.length) { // Đảm bảo không vượt quá kích thước mảng màu
				renderer.setSeriesPaint(i, colors[i]);
			} else {
				renderer.setSeriesPaint(i, Color.GRAY); // Màu mặc định cho các series không được định nghĩa
			}
		}
	}

	//Hàm truy vấn dữ liệu thống kê theo ca hiện tại 
	private DefaultCategoryDataset createDatasetTKTheoCa(TrangChu_GUI trangChu) {
		dataset = new DefaultCategoryDataset();
		dsTK.reset();
		dsNV.reset();
		dsHD.reset();
		dsVe.reset();
		dsCTHD.reset();
		dsCa.reset();

		Map<String, Float> doanhThuTheoKhuyenMai = new HashMap<>();

		// Lấy thông tin nhân viên theo tên
		NhanVien nv = dsNV.getNhanVienTheoTenNV(trangChu.lbl_ThongTinNV.getText());
		if (nv == null) {
			System.out.println("Không tìm thấy nhân viên với tên: " + trangChu.lbl_ThongTinNV.getText());
			return dataset;
		}

		// Lấy thông tin ca làm
		Ca ca = dsCa.getCaTheoMaCa(nv.getCa().getMaCa());
		if (ca == null) {
			System.out.println("Không tìm thấy ca với mã: " + nv.getCa().getMaCa());
			return dataset;
		}
		LocalTime thoiGianBatDauCa = ca.getThoiGianBatDau();
		LocalTime thoiGianKetThucCa = ca.getThoiGianKetThuc();

		// Lấy danh sách hóa đơn của nhân viên
		ArrayList<HoaDon> listHD = dsHD.getHoaDonTheoMaNV(nv.getMaNV());
		if (listHD == null) {
			System.out.println("Không có hóa đơn nào cho nhân viên với mã: " + nv.getMaNV());
			return dataset ;
		}

		// Duyệt qua từng hóa đơn và kiểm tra thời gian
		for (HoaDon hd : listHD) {
			LocalTime thoiGianHoaDon = hd.getNgayLapHoaDon().toLocalTime();
			if (thoiGianHoaDon.isBefore(thoiGianBatDauCa) || thoiGianHoaDon.isAfter(thoiGianKetThucCa)) {
				continue; // Bỏ qua hóa đơn ngoài khoảng thời gian ca
			}

			ChiTietHoaDon cthd = dsCTHD.getCTHDTheoMaChiTiet(hd.getChiTiet().getMaChiTiet());
			if (cthd != null) {
				ArrayList<Ve> listVe = dsVe.getDsVeTheoMaChiTiet(cthd.getMaChiTiet());

				for (Ve ve : listVe) {
					String khuyenMai = ve.getKhuyenMai();
					doanhThuTheoKhuyenMai.put(khuyenMai,
							doanhThuTheoKhuyenMai.getOrDefault(khuyenMai, 0f) + ve.tinhGiaVe());
				}
			} else {
				System.out.println("Chi tiết hóa đơn không tồn tại cho mã chi tiết: " + hd.getChiTiet().getMaChiTiet());
			}
		}
		// Duyệt qua từng mục trong doanh thu theo khuyến mãi
		for (Map.Entry<String, Float> entry : doanhThuTheoKhuyenMai.entrySet()) {
			String khuyenMai = entry.getKey();
			Float doanhThu = entry.getValue();

			// Thêm dữ liệu vào dataset
			dataset.addValue(doanhThu, "Doanh Thu", khuyenMai);
		}
		if (doanhThuTheoKhuyenMai.isEmpty()) {
		    System.out.println("Không có hóa đơn nào trong khoảng thời gian ca: " + ca.getMaCa());
		    dataset.addValue(0, "Doanh Thu", "Không có hóa đơn");
		}
		return dataset;
	}
	
	//Hàm truy vấn dữ liệu thống kê doanh thu theo hạng của thống kê ca
	private DefaultCategoryDataset createDatasetTKHangTheoCa(TrangChu_GUI trangChu) {
		dataset = new DefaultCategoryDataset();
		dsTK.reset();
		dsNV.reset();
		dsHD.reset();
		dsVe.reset();
		dsCTHD.reset();
		dsCa.reset();

		Map<String, Float> doanhThuTheoHang = new HashMap<>();

		// Lấy thông tin nhân viên theo tên
		NhanVien nv = dsNV.getNhanVienTheoTenNV(trangChu.lbl_ThongTinNV.getText());
		if (nv == null) {
			System.out.println("Không tìm thấy nhân viên với tên: " + trangChu.lbl_ThongTinNV.getText());
			return dataset;
		}

		// Lấy thông tin ca làm
		Ca ca = dsCa.getCaTheoMaCa(nv.getCa().getMaCa());
		if (ca == null) {
			System.out.println("Không tìm thấy ca với mã: " + nv.getCa().getMaCa());
			return dataset;
		}
		LocalTime thoiGianBatDauCa = ca.getThoiGianBatDau();
		LocalTime thoiGianKetThucCa = ca.getThoiGianKetThuc();

		// Lấy danh sách hóa đơn của nhân viên
		ArrayList<HoaDon> listHD = dsHD.getHoaDonTheoMaNV(nv.getMaNV());
		if (listHD == null) {
			System.out.println("Không có hóa đơn nào cho nhân viên với mã: " + nv.getMaNV());
			return dataset ;
		}

		// Duyệt qua từng hóa đơn và kiểm tra thời gian
		for (HoaDon hd : listHD) {
			LocalTime thoiGianHoaDon = hd.getNgayLapHoaDon().toLocalTime();
			if (thoiGianHoaDon.isBefore(thoiGianBatDauCa) || thoiGianHoaDon.isAfter(thoiGianKetThucCa)) {
				continue; // Bỏ qua hóa đơn ngoài khoảng thời gian ca
			}

			ChiTietHoaDon cthd = dsCTHD.getCTHDTheoMaChiTiet(hd.getChiTiet().getMaChiTiet());
			if (cthd != null) {
				ArrayList<Ve> listVe = dsVe.getDsVeTheoMaChiTiet(cthd.getMaChiTiet());

				for (Ve ve : listVe) {
					String hang = ve.getHang();
					// Sử dụng một Set để theo dõi mã chuyến tàu đã được xử lý
					Set<String> processedHang = new HashSet<>();
					if (!processedHang.contains(hang)) {
						// Cộng doanh thu vào chuyến tàu tương ứng
						doanhThuTheoHang.put(hang, doanhThuTheoHang.getOrDefault(hang, 0f) + ve.tinhGiaVe());
						processedHang.add(hang); // Đánh dấu là đã xử lý
						System.out.println("Cập nhật doanh thu: " + doanhThuTheoHang);
					}
				}
			} else {
				System.out.println("Chi tiết hóa đơn không tồn tại cho mã chi tiết: " + hd.getChiTiet().getMaChiTiet());
			}
		}
		// Duyệt qua từng mục trong doanh thu theo khuyến mãi
		for (Map.Entry<String, Float> entry : doanhThuTheoHang.entrySet()) {
			String hang = entry.getKey();
			Float doanhThu = entry.getValue();

			// Thêm dữ liệu vào dataset
			dataset.addValue(doanhThu, "Doanh Thu", hang);
		}
		if (doanhThuTheoHang.isEmpty()) {
		    System.out.println("Không có hóa đơn nào trong khoảng thời gian ca: " + ca.getMaCa());
		    dataset.addValue(0, "Doanh Thu", "");
		}
		return dataset;
	}
	
	//Hàm truy vấn dữ liệu thống kê PieChart số lượng bán 
	private DefaultPieDataset createDatasetPieChart(TrangChu_GUI trangChu) {
	    DefaultPieDataset dataset = new DefaultPieDataset();
	    dsTK.reset();
	    dsNV.reset();
	    dsHD.reset();
	    dsVe.reset();
	    dsCTHD.reset();
	    dsCa.reset();

	    Map<String, Float> doanhThuTheoHang = new HashMap<>();

	    // Lấy thông tin nhân viên theo tên
	    NhanVien nv = dsNV.getNhanVienTheoTenNV(trangChu.lbl_ThongTinNV.getText());
	    if (nv == null) {
	        System.out.println("Không tìm thấy nhân viên với tên: " + trangChu.lbl_ThongTinNV.getText());
	        return dataset;
	    }

	    // Lấy thông tin ca làm
	    Ca ca = dsCa.getCaTheoMaCa(nv.getCa().getMaCa());
	    if (ca == null) {
	        System.out.println("Không tìm thấy ca với mã: " + nv.getCa().getMaCa());
	        return dataset;
	    }
	    LocalTime thoiGianBatDauCa = ca.getThoiGianBatDau();
	    LocalTime thoiGianKetThucCa = ca.getThoiGianKetThuc();

	    // Lấy danh sách hóa đơn của nhân viên
	    ArrayList<HoaDon> listHD = dsHD.getHoaDonTheoMaNV(nv.getMaNV());
	    if (listHD == null) {
	        System.out.println("Không có hóa đơn nào cho nhân viên với mã: " + nv.getMaNV());
	        return dataset;
	    }

	    // Duyệt qua từng hóa đơn và kiểm tra thời gian
	    for (HoaDon hd : listHD) {
	        LocalTime thoiGianHoaDon = hd.getNgayLapHoaDon().toLocalTime();
	        if (thoiGianHoaDon.isBefore(thoiGianBatDauCa) || thoiGianHoaDon.isAfter(thoiGianKetThucCa)) {
	            continue; // Bỏ qua hóa đơn ngoài khoảng thời gian ca
	        }

	        ChiTietHoaDon cthd = dsCTHD.getCTHDTheoMaChiTiet(hd.getChiTiet().getMaChiTiet());
	        if (cthd != null) {
	            ArrayList<Ve> listVe = dsVe.getDsVeTheoMaChiTiet(cthd.getMaChiTiet());
	            Set<String> processedHang = new HashSet<>(); // Set để theo dõi mã chuyến tàu đã được xử lý

	            for (Ve ve : listVe) {
	                String hang = ve.getHang();
	                if (!processedHang.contains(hang)) {
	                    // Cộng doanh thu vào chuyến tàu tương ứng
	                    doanhThuTheoHang.put(hang, doanhThuTheoHang.getOrDefault(hang, 0f) + ve.tinhGiaVe());
	                    processedHang.add(hang); // Đánh dấu là đã xử lý
	                    System.out.println("Cập nhật doanh thu: " + doanhThuTheoHang);
	                }
	            }
	        } else {
	            System.out.println("Chi tiết hóa đơn không tồn tại cho mã chi tiết: " + hd.getChiTiet().getMaChiTiet());
	        }
	    }

	    // Duyệt qua từng mục trong doanh thu theo khuyến mãi
	    for (Map.Entry<String, Float> entry : doanhThuTheoHang.entrySet()) {
	        String hang = entry.getKey();
	        Float doanhThu = entry.getValue();
	        // Thêm dữ liệu vào dataset
	        dataset.setValue(hang, doanhThu); // Sử dụng setValue cho PieDataset
	    }

	    if (doanhThuTheoHang.isEmpty()) {
	        System.out.println("Không có hóa đơn nào trong khoảng thời gian ca: " + ca.getMaCa());
	        dataset.setValue("Rỗng", 0); // Thêm giá trị cho trường hợp không có dữ liệu
	    }

	    return dataset;
	}

	//Hàm truy vấn dữ liệu thống kê doanh thu
	private DefaultCategoryDataset createDatasetDoanhThu() {
		dataset = new DefaultCategoryDataset();
		SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedNgayBatDau = sqlDateFormat.format(dateChooser_TKDT_batDau.getDate());
		String formattedNgayKetThuc = sqlDateFormat.format(dateChooser_TKDT_ketThuc.getDate());
		dsHD.reset();
		dsVe.reset();
		dsCTHD.reset();
		Map<String, Float> doanhThuTheoKhuyenMai = new HashMap<>();
		ArrayList<HoaDon> listHD = dsHD.getHoaDonTheoNgayLapHD(formattedNgayBatDau, formattedNgayKetThuc);
		// Duyệt qua từng hóa đơn
		for (HoaDon hd : listHD) {
			ChiTietHoaDon cthd = dsCTHD.getCTHDTheoMaChiTiet(hd.getChiTiet().getMaChiTiet());

			// Kiểm tra cthd có null hay không
			if (cthd != null) {
				ArrayList<Ve> listVe = dsVe.getDsVeTheoMaChiTiet(cthd.getMaChiTiet());
				for (Ve ve : listVe) {
					String khuyenMai = ve.getKhuyenMai(); // Lấy mã khuyến mãi của vé
					// Cộng doanh thu vào khuyến mãi tương ứng
					doanhThuTheoKhuyenMai.put(khuyenMai, 
							doanhThuTheoKhuyenMai.getOrDefault(khuyenMai, 0f) +	ve.tinhGiaVe());
				} // Mảng chứa khuyến mãi và doanh thu của mỗi lại
			}
		}
		// Duyệt qua từng mục trong doanh thu theo khuyến mãi
		for (Map.Entry<String, Float> entry : doanhThuTheoKhuyenMai.entrySet()) {
			String khuyenMai = entry.getKey();
			Float doanhThu = entry.getValue();

			// Thêm dữ liệu vào dataset
			dataset.addValue(doanhThu, "Doanh Thu", khuyenMai);
		}

		return dataset;
	}


	//Hàm truy vấn dữ liệu thống kê chuyến tàu
	private DefaultCategoryDataset createDatasetChuyenTau() {
		dataset = new DefaultCategoryDataset();
		dsHD.reset();
		dsVe.reset();
		dsCTHD.reset();
		dsCT.reset();
		SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedNgayBatDau = sqlDateFormat.format(dateChooser_TKCT_batDau.getDate());
		String formattedNgayKetThuc = sqlDateFormat.format(dateChooser_TKCT_ketThuc.getDate());

		Map<String, Float> doanhThuTheoChuyenTau = new HashMap<>();
		ArrayList<HoaDon> listHD = dsHD.getHoaDonTheoNgayLapHD(formattedNgayBatDau, formattedNgayKetThuc);

		// Duyệt qua từng hóa đơn
		for (HoaDon hd : listHD) {
			ChiTietHoaDon cthd = dsCTHD.getCTHDTheoMaChiTiet(hd.getChiTiet().getMaChiTiet());

			// Kiểm tra cthd có null hay không
			if (cthd != null) {
				float doanhThu = cthd.tinhTien(); // Tính doanh thu từ cthd
				System.out.println("Doanh thu từ cthd: " + doanhThu);

				ArrayList<Ve> listVe = dsVe.getDsVeTheoMaChiTiet(cthd.getMaChiTiet());

				// Sử dụng một Set để theo dõi mã chuyến tàu đã được xử lý
				Set<String> processedChuyenTau = new HashSet<>();

				for (Ve ve : listVe) {
					String chuyenTau = ve.getChuyenTau().getMaTau(); // Lấy mã chuyến tàu
					System.out.println("Mã chuyến tàu: " + chuyenTau);

					// Kiểm tra xem mã chuyến tàu đã được xử lý chưa
					if (!processedChuyenTau.contains(chuyenTau)) {
						// Cộng doanh thu vào chuyến tàu tương ứng
						doanhThuTheoChuyenTau.put(chuyenTau, doanhThuTheoChuyenTau.getOrDefault(chuyenTau, 0f) + doanhThu);
						processedChuyenTau.add(chuyenTau); // Đánh dấu là đã xử lý
						System.out.println("Cập nhật doanh thu: " + doanhThuTheoChuyenTau);
					}
				}
			} else {
				System.out.println("Chi tiết hóa đơn không tìm thấy cho hóa đơn: " + hd.getChiTiet().getMaChiTiet());
			}
		}

		// Duyệt qua từng mục trong doanh thu theo chuyến tàu
		for (Map.Entry<String, Float> entry : doanhThuTheoChuyenTau.entrySet()) {
			String chuyenTau = entry.getKey();
			Float doanhThu = entry.getValue();

			// Thêm dữ liệu vào dataset
			dataset.addValue(doanhThu, "Doanh Thu", chuyenTau);
		}

		return dataset;
	}


	//Hàm truy vấn dữ liệu theo mẫu
	private DefaultPieDataset createDatasetTKTheoCa() {
	    DefaultPieDataset dataset = new DefaultPieDataset();
	    
	    // Thêm dữ liệu vào dataset
	    dataset.setValue("Ghế mềm", 40); // Giá trị cho đối tượng 1
	    dataset.setValue("Giường nằm", 30); // Giá trị cho đối tượng 2
	    dataset.setValue("VIP", 20); // Giá trị cho đối tượng 3

	    return dataset;
	}

	private DefaultCategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// Add data to the dataset
		dataset.addValue(0.4, "Ghế mềm", "1");
		dataset.addValue(0.5, "Giường nằm", "2");
		dataset.addValue(0.9, "VIP", "3");
		return dataset;
	}
	
	//Hàm định dạng tiền việt
	public String dinhDangTienTe(double soTien) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		return formatter.format(soTien);
	}

	//Hàm kiểm tra quyền Nhân viên
	public void kiemTraQuyen(TrangChu_GUI trangChu) {
	    dsTK.reset();
	    dsNV.reset();
	    NhanVien nv = dsNV.getNhanVienTheoTenNV(trangChu.lbl_ThongTinNV.getText());
	    
	    // Kiểm tra nếu nhân viên tồn tại
	    if (nv != null) {
	        TaiKhoan tk = dsTK.getTaiKhoanTheoMaNV(nv.getMaNV());

	        // Kiểm tra nếu tài khoản tồn tại
	        if (tk != null) {
	            // In ra giá trị phân quyền để kiểm tra
	            System.out.println("Phân quyền: " + tk.getPhanQuyen());

	            if (tk.getPhanQuyen() == 2) {
	                tabbedPane.setSelectedIndex(0); // Chọn tab 0 nếu quyền là 2
	                tabbedPane.setEnabledAt(1, false); // Vô hiệu hóa tab 1
	                tabbedPane.setEnabledAt(2, false); // Vô hiệu hóa tab 2
	            } else {
	            	tabbedPane.setSelectedIndex(0);
	            	tabbedPane.setEnabledAt(1, true); // Bật tab 1
	                tabbedPane.setEnabledAt(2, true); // Bật tab 2
	            }
	        } else {
	            System.out.println("Tài khoản không tồn tại.");
	        }
	    } else {
	        System.out.println("Nhân viên không tồn tại.");
	    }
	}

	//Hàm chỉ định tabbedPane
	public void hienThiThongKeChuyenTau() {
		tabbedPane.setSelectedIndex(2);
	}
	public void hienThiThongKeDoanhThu() {
		tabbedPane.setSelectedIndex(1);
	}
	public void hienThiThongKeDoanhThuTheoCa() {
		tabbedPane.setSelectedIndex(0);
	}
}