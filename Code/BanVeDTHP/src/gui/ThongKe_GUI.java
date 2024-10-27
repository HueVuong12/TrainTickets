package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ThongKe_GUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lbl_ThoiGian;
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
	private ChartPanel chartPanelTheoCa;
	private JPanel jp_tkdt;
	private JPanel jp_thoiGian;
	private JPanel jp_header;
	private JPanel jp_content;
	private JRadioButton rdbt_batDau;
	private JRadioButton rdbt_ketThuc;
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
	private JRadioButton rdbt_batDau1;
	private JRadioButton rdbt_ketThuc1;
	private JTextField textField1;
	private JTextField textField_2;
	private Color hoverLabelColor = new Color(0, 153, 255);
	public ThongKe_GUI(TrangChu_GUI trangChu) {
	    
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
				jpct.setVisible(true);
				ThongKe_GUI.this.setVisible(false);
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

		lbl_ca = new JLabel("200.000.000đ");
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
		
		//JFreeChat thống kê theo loại vé
		//Khởi tạo dữ liệu
		DefaultCategoryDataset datasetTheoCa = createDataset();
		// Create chart
		JFreeChart chartTheoCa = ChartFactory.createBarChart(
				"Revenue Statistics",
				"Month",
				"Revenue",
				datasetTheoCa
				);

		// Giảm kích cỡ chữ cho tiêu đề
		chartTheoCa.getTitle().setFont(new Font("Arial", Font.PLAIN, 16));
		// Tạo ChartPanel và thiết lập kích thước
		chartPanelTheoCa = new ChartPanel(chartTheoCa);
		jp_thongKeTheoCa.setLayout(null);
		chartPanelTheoCa.setBounds(0, 0, 1312, 308);
		// Thêm ChartPanel vào jp_thongKe
		jp_thongKeTheoCa.add(chartPanelTheoCa);
		
		
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
		
		
		//Icon xổ xuống
		ImageIcon downIcon = new ImageIcon(getClass().getResource("/img/Polygon_20.png"));
		Image scaledDown = downIcon.getImage().getScaledInstance(20 ,20, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		JLabel downIconLabel = new JLabel(new ImageIcon(scaledDown));
		downIconLabel.setBounds(345, 0, 29, 35);
		jp_header.add(downIconLabel);

		//			ImageIcon downIcon = new ImageIcon(getClass().getResource("/img/510869_calendar_date_event_schedule_icon.png"));
		//			System.out.println(downIcon);
		//		    Image scaledDown = downIcon.getImage().getScaledInstance(20 ,20, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		//		    JLabel downIconLabel = new JLabel(new ImageIcon(scaledDown));
		//		    downIconLabel.setBounds(242 ,0 , 29 ,35); // Cập nhật kích thước trên JLabel
		//		    jp_header.add(downIconLabel);
		
		//JPane chứa content
		jp_content = new JPanel();
		jp_content.setBackground(SystemColor.controlHighlight);
		jp_content.setBounds(0, 36, 374, 79);
		jp_thoiGian.add(jp_content);
		jp_content.setLayout(null);

		//Nút radio thời gian bắt đầu
		rdbt_batDau = new JRadioButton("");
		rdbt_batDau.setHorizontalAlignment(SwingConstants.CENTER);
		rdbt_batDau.setFont(new Font("Arial", Font.PLAIN, 31));
		rdbt_batDau.setBackground(SystemColor.controlHighlight);
		rdbt_batDau.setPreferredSize(new Dimension(200, 100)); // Kích thước nút
		rdbt_batDau.setBounds(6, 5, 39, 33);
		jp_content.add(rdbt_batDau);

		//Nút radio thời gian kết thúc
		rdbt_ketThuc = new JRadioButton("");
		rdbt_ketThuc.setHorizontalAlignment(SwingConstants.CENTER);
		rdbt_ketThuc.setFont(new Font("Arial", Font.PLAIN, 31));
		rdbt_ketThuc.setBackground(SystemColor.controlHighlight);
		rdbt_ketThuc.setBounds(6, 41, 39, 33);
		jp_content.add(rdbt_ketThuc);

		//JTextField nhập thời gian bắt đầu
		textField = new JTextField("Từ");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setForeground(SystemColor.activeCaptionBorder);
		textField.setBounds(51, 5, 313, 29);
		jp_content.add(textField);
		textField.setColumns(10);

		//JTextField nhập thời gian kết thúc
		textField_1 = new JTextField("Đến");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setForeground(SystemColor.activeCaptionBorder);
		textField_1.setColumns(10);
		textField_1.setBounds(49, 44, 315, 29);
		jp_content.add(textField_1);

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
		
		lbl_doanhThu = new JLabel("200.000.000đ");
		lbl_doanhThu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_doanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_doanhThu.setBounds(111, 41, 114, 20);
		jp_ketQua.add(lbl_doanhThu);
		
		JLabel lbl_titleDT = new JLabel("Doanh thu");
		lbl_titleDT.setBackground(SystemColor.windowBorder);
		lbl_titleDT.setForeground(new Color(105, 105, 105));
		lbl_titleDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_titleDT.setBounds(134, 65, 71, 13);
		jp_ketQua.add(lbl_titleDT);
		
		//Icon số lượng trả vé
		ImageIcon sltvIcon = new ImageIcon(getClass().getResource("/img/money-back_1.png"));
		Image scaledSLTV = sltvIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		jp_ketQua.setLayout(null);
		JLabel sltvIconLabel = new JLabel(new ImageIcon(scaledSLTV));
		jp_ketQua.add(sltvIconLabel);
		sltvIconLabel.setBounds(292, 41, 40, 40);
		
		lbl_sltv = new JLabel("15");
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
		
		lbl_slvb = new JLabel("100");
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
		JPanel jp_thongKe = new JPanel();
		jp_thongKe.setBounds(28, 133, 1311, 308);
		System.out.println("đúng");
		jp_thongKe.setBackground(Color.DARK_GRAY);
		jp_tkdt.add(jp_thongKe);
		
		//JFreeChat thống kê theo loại vé
		//Khởi tạo dữ liệu
        DefaultCategoryDataset dataset = createDataset();
        // Create chart
        JFreeChart chart = ChartFactory.createBarChart(
                "Revenue Statistics",
                "Month",
                "Revenue",
                dataset
        );
        
        // Giảm kích cỡ chữ cho tiêu đề
        chart.getTitle().setFont(new Font("Arial", Font.PLAIN, 16));
        // Tạo ChartPanel và thiết lập kích thước
        chartPanel = new ChartPanel(chart);
        jp_thongKe.setLayout(null);
        chartPanel.setBounds(0, 0, 1311, 308);

        // Thêm ChartPanel vào jp_thongKe
        jp_thongKe.add(chartPanel);
        jp_thongKe.revalidate(); // Cập nhật lại giao diện
        jp_thongKe.repaint(); // Vẽ lại panel
		
        
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
		downIconLabel.setBounds(345, 0, 29, 35);
		jp_header1.add(downIconLabel1);

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

		//Nút radio thời gian bắt đầu
		rdbt_batDau1 = new JRadioButton("");
		rdbt_batDau1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbt_batDau1.setFont(new Font("Arial", Font.PLAIN, 31));
		rdbt_batDau1.setBackground(SystemColor.controlHighlight);
		rdbt_batDau1.setPreferredSize(new Dimension(200, 100)); // Kích thước nút
		rdbt_batDau1.setBounds(6, 5, 39, 33);
		jp_content1.add(rdbt_batDau1);

		//Nút radio thời gian kết thúc
		rdbt_ketThuc1 = new JRadioButton("");
		rdbt_ketThuc1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbt_ketThuc1.setFont(new Font("Arial", Font.PLAIN, 31));
		rdbt_ketThuc1.setBackground(SystemColor.controlHighlight);
		rdbt_ketThuc1.setBounds(6, 41, 39, 33);
		jp_content1.add(rdbt_ketThuc1);

		//JTextField nhập thời gian bắt đầu
		textField1 = new JTextField("Từ");
		textField1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField1.setForeground(SystemColor.activeCaptionBorder);
		textField1.setBounds(51, 5, 313, 29);
		jp_content1.add(textField1);
		textField1.setColumns(10);

		//JTextField nhập thời gian kết thúc
		textField_2 = new JTextField("Đến");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setForeground(SystemColor.activeCaptionBorder);
		textField_2.setColumns(10);
		textField_2.setBounds(49, 44, 315, 29);
		jp_content1.add(textField_2);
		
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

		lbl_doanhThuCT = new JLabel("200.000.000đ");
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

		lbl_sltvct = new JLabel("15");
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

		lbl_slvbct = new JLabel("100");
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
		JPanel jp_thongKeCT = new JPanel();
		jp_thongKeCT.setBounds(28, 133, 1311, 308);
		jp_tkct.add(jp_thongKeCT);

		//JFreeChat thống kê theo loại vé
		//Khởi tạo dữ liệu
		DefaultCategoryDataset datasetCT = createDataset();  // dsCTHD là danh sách chi tiết hóa đơn
		JFreeChart chartCT = ChartFactory.createBarChart(
		        "Revenue Statistics",
		        "Ticket Type",
		        "Revenue",
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
		
		
		Color[] colors = {Color.BLUE}; // Thêm màu theo nhu cầu
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
		
		
		
		// Thiết lập màu nền cho tab hiện tại
		//        tabbedPane.setBackgroundAt(0, Color.LIGHT_GRAY);
		//        tabbedPane.setBackgroundAt(1, Color.LIGHT_GRAY);
		//        tabbedPane.setBackgroundAt(2, Color.LIGHT_GRAY);
	}
	private DefaultCategoryDataset createDatasetTheoCa() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		return dataset;
		
	}

    
	//Hàm truy vấn dữ liệu theo loại
	private DefaultCategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// Add data to the dataset
		dataset.addValue(0.4, "Revenue", "1");
		dataset.addValue(0.5, "Revenue", "2");
		dataset.addValue(0.9, "Revenue", "3");
		dataset.addValue(0.10, "Revenue", "4");
		dataset.addValue(0.12, "Revenue", "5");
		dataset.addValue(0.1, "Revenue", "6");
		dataset.addValue(0.3, "Revenue", "7");
		dataset.addValue(0.5, "Revenue", "8");
		dataset.addValue(0.8, "Revenue", "9");
		dataset.addValue(0.7, "Revenue", "10");
		dataset.addValue(0.6, "Revenue", "11");
		dataset.addValue(0.10, "Revenue", "12");
		dataset.addValue(0.17, "Revenue", "13");
		dataset.addValue(0.51, "Revenue", "14");
		dataset.addValue(0.22, "Revenue", "15");


		return dataset;
	}
	
	//Hàm lấy thời gian thực
		public void updateTime() {
			LocalDateTime currentTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			String formattedTime = currentTime.format(formatter);
			lbl_ThoiGian.setText(formattedTime);
		}
		
		/// ham thong ke 
}
