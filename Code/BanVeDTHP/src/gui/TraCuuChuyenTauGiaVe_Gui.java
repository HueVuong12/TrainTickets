package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import components.RoundedTextField;
import java.awt.BorderLayout;

public class TraCuuChuyenTauGiaVe_Gui extends JPanel {
	private JTable table;
	private JTextField txtGaDi;
	private JTextField txtGaDi_top;
	private JTextField txtTau;
	private JTable table_1;

	private final JLabel lblChGi = new JLabel("Chú ý: giá vé đã bao gồm tiền bảo hiểm\nGía vé có thể thay đổi theo 1 số điều kiện: thời gian mua vé, đối tượng đi tàu, vị trí chỗ trên toa ...");
	private JLabel muiTenIconLabel;
	private JLabel dauTauIconLabel;
	public TraCuuChuyenTauGiaVe_Gui(TrangChu_GUI trangChu) {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 170, 1460, 570);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 153));
		panel.setBounds(56, 10, 1347, 71);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/img/clock.png")));
		lblNewLabel.setBounds(27, 10, 58, 51);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GIỜ TÀU - GIÁ VÉ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(49, 0, 275, 71);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(152, 342, 597, 357);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Các ga trong hành trình");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(0, 0, 597, 60);
		panel_1.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 59, 597, 171);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Ga đi", "Cự ly(km)", "Ngày đi", "Giờ đến", "Giờ đi"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(152, 103, 451, 38);
		add(panel_2);
		panel_2.setLayout(null);
		
		RoundedTextField lblGaDi_top = new RoundedTextField(15);
//		JLabel lblGaDi_top = new JLabel("Ga đi");
		lblGaDi_top.setText("Ga đi");
		lblGaDi_top.setHorizontalAlignment(SwingConstants.CENTER);
		lblGaDi_top.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGaDi_top.setBounds(0, 0, 85, 38);
		panel_2.add(lblGaDi_top);
		
//		txtGaDi = new JTextField();
		RoundedTextField txtGaDi = new RoundedTextField(15);
		txtGaDi.setBounds(85, 0, 366, 38);
		panel_2.add(txtGaDi);
		txtGaDi.setColumns(10);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(904, 103, 451, 38);
		add(panel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ga đi");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(0, 0, 85, 38);
		panel_2_1.add(lblNewLabel_3_1);
		
//		txtGaDi_top = new JTextField();
		RoundedTextField txtGaDi_top = new RoundedTextField(15);
		txtGaDi_top.setBounds(85, 0, 366, 38);
		panel_2_1.add(txtGaDi_top);
		txtGaDi_top.setColumns(10);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBounds(152, 140, 451, 38);
		add(panel_2_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Ngày");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(0, 0, 85, 38);
		panel_2_2.add(lblNewLabel_3_2);
		
		JDateChooser dateChooser_Ngay = new JDateChooser();
		dateChooser_Ngay.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 10));
		dateChooser_Ngay.getCalendarButton().setBounds(315, 0, 50, 38);
		dateChooser_Ngay.setBounds(86, 0, 365, 38);
		panel_2_2.add(dateChooser_Ngay);
		dateChooser_Ngay.setLayout(null);
		
		RoundedTextField textField_NgayChon = new RoundedTextField(15);
		textField_NgayChon.setBounds(0, 0, 324, 38);
		dateChooser_Ngay.add(textField_NgayChon);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBounds(904, 140, 451, 38);
		add(panel_2_1_1);
		
		JLabel lblTau = new JLabel("Tàu");
		lblTau.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblTau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTau.setBounds(0, 0, 85, 38);
		panel_2_1_1.add(lblTau);
		
		txtTau = new JTextField();
		txtTau.setColumns(10);
		txtTau.setBounds(85, 0, 366, 38);
		panel_2_1_1.add(txtTau);
		
		JPanel panel_ThongTinTau = 	new JPanel();
		panel_ThongTinTau.setBackground(new Color(159, 214, 239));
		panel_ThongTinTau.setBounds(56, 188, 1347, 144);
		add(panel_ThongTinTau);
		panel_ThongTinTau.setLayout(null);
		
		JLabel lblGaDen_CenTer = new JLabel("Ga đến:");
		lblGaDen_CenTer.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGaDen_CenTer.setForeground(new Color(1, 111, 162));

		lblGaDen_CenTer.setBounds(882, 50, 116, 33);
		panel_ThongTinTau.add(lblGaDen_CenTer);
		
		JLabel lblNgayDen = new JLabel("Ngày đến:");
		lblNgayDen.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNgayDen.setForeground(new Color(1, 111, 162));
		lblNgayDen.setBounds(881, 81, 129, 33);
		panel_ThongTinTau.add(lblNgayDen);
		
		JLabel lblGaDi = new JLabel("Ga đi:");
		lblGaDi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGaDi.setForeground(new Color(1, 111, 162));
		lblGaDi.setBounds(271, 55, 72, 23);
		panel_ThongTinTau.add(lblGaDi);
		
		JLabel lblNgayDi = new JLabel("Ngày đi:");
		lblNgayDi.setForeground(new Color(1, 111, 162));
		lblNgayDi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNgayDi.setBounds(271, 87, 94, 21);
		panel_ThongTinTau.add(lblNgayDi);
		
		 // Load hình ảnh gốc
		ImageIcon muiTenIcon = new ImageIcon(getClass().getResource("/img/arrow_back_icon -.png"));
  		Image scaledMuiTenIcon = muiTenIcon.getImage().getScaledInstance(100, 43, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
  		muiTenIconLabel = new JLabel(new ImageIcon(scaledMuiTenIcon));
  		muiTenIconLabel.setBounds(640, 50, 90, 43);
  		panel_ThongTinTau.add(muiTenIconLabel);

		
  		ImageIcon dauTauIcon = new ImageIcon(getClass().getResource("/img/Toa_Dau.png"));
  		Image scaledDauTauIcon =dauTauIcon.getImage().getScaledInstance(100, 43, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
  		dauTauIconLabel = new JLabel(new ImageIcon(scaledDauTauIcon));
  		dauTauIconLabel.setBounds(566, 10, 100, 43);
  		panel_ThongTinTau.add(dauTauIconLabel);
//		JLabel lblNewLabel_9 = new JLabel("");
//		lblNewLabel_9.setIcon(new ImageIcon(getClass().getResource("/img/container_Zoom-removebg-preview - Copy.png")));
//		lblNewLabel_9.setBounds(605, -20, 161, 94);
//		panel_ThongTinTau.add(lblNewLabel_9);
		
		JLabel lblNewLabel_3 = new JLabel("TÀU TA001");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(695, 10, 86, 43);
		panel_ThongTinTau.add(lblNewLabel_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(551, 101, 267, 33);
		panel_3.setBackground(new Color(51, 102, 153));
		panel_ThongTinTau.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Thời gian hành trình:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(5, 8, 150, 17);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("30");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(165, 8, 34, 17);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phút");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(209, 8, 45, 17);
		panel_3.add(lblNewLabel_6);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(811, 342, 544, 357);
		add(panel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Bảng giá vé");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(0, 0, 544, 60);
		panel_1_1.add(lblNewLabel_2_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 59, 544, 169);
		panel_1_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"STT", "Mã toa", "Hạng","Khuyến mãi", "Ga đi"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(708, 100, 102, 78);
		add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(getClass().getResource("/img/right.png")));
		lblNewLabel_8.setBounds(25, 0, 30, 32);
		panel_4.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1.setIcon(new ImageIcon(getClass().getResource("/img/right.png")));
		lblNewLabel_8_1.setBounds(25, 42, 30, 32);
		panel_4.add(lblNewLabel_8_1);
		
	}
}
