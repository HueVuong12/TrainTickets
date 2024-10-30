package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.ConTent_JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class BanVeThanhToan_GUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField_TKD;
	private JTextField textField_TTL;

	/**
	 * Create the panel.
	 */
	public BanVeThanhToan_GUI() {
		setBackground(SystemColor.text);
		setForeground(new Color(255, 255, 255));
		setBounds(0, 170, 1440, 570);
		setLayout(null);
		
		JPanel jp_QL = new JPanel();
		jp_QL.setBounds(10, 10, 124, 28);
		jp_QL.setBackground(new Color(255, 255, 255));
		jp_QL.setLayout(null);
		add(jp_QL);
		
		//Icon Quay lại
		ImageIcon goBackIcon = new ImageIcon(getClass().getResource("/img/9054423_bx_arrow_back_icon.png"));
		Image scaledGoBack = goBackIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		JLabel goBackIconLabel = new JLabel(new ImageIcon(scaledGoBack));
		jp_QL.add(goBackIconLabel);
		goBackIconLabel.setBounds(10, 0, 39, 27);
		goBackIconLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ConTent_JPanel jpct = new ConTent_JPanel();
				jpct.setVisible(true);
				BanVeThanhToan_GUI.this.setVisible(false);
				}
		});
		JLabel lb_quaylai = new JLabel("Quay lại");
		lb_quaylai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_quaylai.setBounds(45, 0, 69, 27);
		jp_QL.add(lb_quaylai);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 48, 941, 512);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đơn vị bán vé:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 125, 24);
		panel.add(lblNewLabel);
		
		JLabel lblMNhnVin = new JLabel("Mã nhân viên:");
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMNhnVin.setBounds(10, 44, 125, 24);
		panel.add(lblMNhnVin);
		
		JLabel lblMKhchHng = new JLabel("Mã khách hàng:");
		lblMKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMKhchHng.setBounds(10, 78, 125, 24);
		panel.add(lblMKhchHng);
		
		JLabel lblSdtKhchHng = new JLabel("SDT khách hàng:");
		lblSdtKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSdtKhchHng.setBounds(10, 112, 125, 24);
		panel.add(lblSdtKhchHng);
		
		JLabel lb_SDT = new JLabel("0919128639");
		lb_SDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_SDT.setBounds(154, 112, 125, 24);
		panel.add(lb_SDT);
		
		JLabel lb_MKH = new JLabel("KH0001");
		lb_MKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_MKH.setBounds(154, 78, 125, 24);
		panel.add(lb_MKH);
		
		JLabel lb_MNV = new JLabel("NV001");
		lb_MNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_MNV.setBounds(154, 44, 125, 24);
		panel.add(lb_MNV);
		
		JLabel lb_DVBV = new JLabel("Nhà ga ĐTHP");
		lb_DVBV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_DVBV.setBounds(154, 10, 125, 24);
		panel.add(lb_DVBV);
		
		JLabel lblinThoi = new JLabel("Điện thoại:");
		lblinThoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblinThoi.setBounds(410, 10, 125, 24);
		panel.add(lblinThoi);
		
		JLabel lb_DT = new JLabel("0123456789");
		lb_DT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_DT.setBounds(554, 10, 125, 24);
		panel.add(lb_DT);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng:");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnKhchHng.setBounds(410, 78, 125, 24);
		panel.add(lblTnKhchHng);
		
		JLabel lb_TKH = new JLabel("Lê Tấn Phong");
		lb_TKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_TKH.setBounds(554, 78, 125, 24);
		panel.add(lb_TKH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 146, 906, 356);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"a", "b", "c", "d", "e", "f=d*e", "g", "h=f*g", "i=f+h"},
				{"1", "VE001", "Tên sản phẩm 1", "1", "1000", "1000", "10%", "100", "1100"}
			},
			new String[] {
				"STT", "Mã vé", "Tên dịch vụ", "Số lượng", "Đơn giá", "Thành tiền chưa thuế", "Thuế suất", "Thuế GTGT", "Thành tiền có thuế"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(986, 48, 444, 512);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tiền khách đưa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(53, 10, 327, 30);
		panel_1.add(lblNewLabel_1);
		
		textField_TKD = new JTextField();
		textField_TKD.setBackground(Color.CYAN);
		textField_TKD.setBounds(53, 44, 327, 30);
		panel_1.add(textField_TKD);
		textField_TKD.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhập số tiền theo mệnh giá");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(53, 97, 327, 30);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("500.000");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(53, 137, 100, 30);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("200.000");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(163, 137, 100, 30);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("100.000");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(273, 137, 100, 30);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("50.000");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(53, 184, 100, 30);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("20.000");
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3_1.setBounds(163, 184, 100, 30);
		panel_1.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_1_1 = new JButton("10.000");
		btnNewButton_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3_1_1.setBounds(273, 184, 100, 30);
		panel_1.add(btnNewButton_3_1_1);
		
		JButton btnNewButton_3_2 = new JButton("5.000");
		btnNewButton_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3_2.setBounds(53, 231, 100, 30);
		panel_1.add(btnNewButton_3_2);
		
		JButton btnNewButton_3_3 = new JButton("2.000");
		btnNewButton_3_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3_3.setBounds(163, 231, 100, 30);
		panel_1.add(btnNewButton_3_3);
		
		JButton btnNewButton_3_4 = new JButton("1.000");
		btnNewButton_3_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3_4.setBounds(273, 231, 100, 30);
		panel_1.add(btnNewButton_3_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Gợi ý tiền mặt");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(53, 282, 327, 30);
		panel_1.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton_3_2_1 = new JButton("5.000");
		btnNewButton_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3_2_1.setBounds(53, 325, 100, 30);
		panel_1.add(btnNewButton_3_2_1);
		
		JButton btnNewButton_3_2_2 = new JButton("5.000");
		btnNewButton_3_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3_2_2.setBounds(163, 325, 100, 30);
		panel_1.add(btnNewButton_3_2_2);
		
		JButton btnNewButton_3_2_3 = new JButton("5.000");
		btnNewButton_3_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3_2_3.setBounds(273, 325, 100, 30);
		panel_1.add(btnNewButton_3_2_3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Tiền trả lại");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(53, 382, 327, 30);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		textField_TTL = new JTextField();
		textField_TTL.setColumns(10);
		textField_TTL.setBackground(Color.CYAN);
		textField_TTL.setBounds(53, 419, 327, 30);
		panel_1.add(textField_TTL);
		
		JButton btn_XacNhan = new JButton("Xác nhận");
		btn_XacNhan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_XacNhan.setBounds(301, 472, 106, 30);
		panel_1.add(btn_XacNhan);
	}
}
