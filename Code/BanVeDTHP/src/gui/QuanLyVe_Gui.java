package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import components.ConTent_JPanel;

public class QuanLyVe_Gui extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table;
	private JTable table_TTV;
	public QuanLyVe_Gui(TrangChu_GUI trangChu) {
		setBackground(SystemColor.window);
		setForeground(new Color(255, 255, 255));
		setBounds(0, 170, 1460, 570);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1460, 570);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 124, 28);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lb_quaylai = new JLabel("Quay lại");
		lb_quaylai.setBounds(45, 0, 69, 27);
		lb_quaylai.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lb_quaylai);
		
		ImageIcon goBackIcon = new ImageIcon(getClass().getResource("/img/9054423_bx_arrow_back_icon.png"));
		Image scaledGoBack = goBackIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		JLabel goBackIconLabel = new JLabel(new ImageIcon(scaledGoBack));
		goBackIconLabel.setBounds(10, 0, 39, 27);
		goBackIconLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ConTent_JPanel jpct = new ConTent_JPanel();
				jpct.setVisible(true);
				QuanLyVe_Gui.this.setVisible(false);
			}
		});
		panel_1.add(goBackIconLabel);
		
		JPanel jp_TTV = new JPanel();
		jp_TTV.setBounds(35, 65, 356, 416);
		panel.add(jp_TTV);
		jp_TTV.setLayout(null);
		
		JPanel jp_HeaderTTV = new JPanel();
		jp_HeaderTTV.setBounds(0, 0, 356, 33);
		jp_HeaderTTV.setBackground(new Color(51, 102, 153));
		jp_TTV.add(jp_HeaderTTV);
		jp_HeaderTTV.setLayout(null);
		
		JLabel lb_TTV = new JLabel("Thông tin vé");
		lb_TTV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_TTV.setBounds(0, 0, 356, 33);
		jp_HeaderTTV.add(lb_TTV);
		
		JLabel lb_TenKH = new JLabel("Tên khách hàng:");
		lb_TenKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_TenKH.setBounds(10, 43, 97, 22);
		jp_TTV.add(lb_TenKH);
		
		JLabel lblGan = new JLabel("Ga đến:");
		lblGan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGan.setBounds(10, 80, 97, 22);
		jp_TTV.add(lblGan);
		
		JLabel lblNgyi = new JLabel("Ngày đi:");
		lblNgyi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNgyi.setBounds(10, 117, 97, 22);
		jp_TTV.add(lblNgyi);
		
		JLabel lblLoiV = new JLabel("Loại vé:");
		lblLoiV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoiV.setBounds(10, 154, 97, 22);
		jp_TTV.add(lblLoiV);
		
		JLabel lblMToa = new JLabel("Mã toa:");
		lblMToa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMToa.setBounds(10, 191, 97, 22);
		jp_TTV.add(lblMToa);
		
		JLabel lblMSGh = new JLabel("Mã số ghế:");
		lblMSGh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMSGh.setBounds(10, 228, 97, 22);
		jp_TTV.add(lblMSGh);
		
		JLabel lblMV = new JLabel("Mã vé:");
		lblMV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMV.setBounds(10, 265, 97, 22);
		jp_TTV.add(lblMV);
		
		JLabel lblMChuynTu = new JLabel("Mã chuyến tàu:");
		lblMChuynTu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMChuynTu.setBounds(10, 302, 97, 22);
		jp_TTV.add(lblMChuynTu);
		
		JLabel lblGii = new JLabel("Giờ đi:");
		lblGii.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGii.setBounds(10, 339, 97, 22);
		jp_TTV.add(lblGii);
		
		JLabel lblGi = new JLabel("Giá:");
		lblGi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGi.setBounds(10, 376, 97, 22);
		jp_TTV.add(lblGi);
		
		textField = new JTextField();
		textField.setBounds(130, 43, 216, 22);
		jp_TTV.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(130, 83, 216, 22);
		jp_TTV.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(130, 120, 216, 22);
		jp_TTV.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(130, 157, 216, 22);
		jp_TTV.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(130, 194, 216, 22);
		jp_TTV.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(130, 231, 216, 22);
		jp_TTV.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(130, 268, 216, 22);
		jp_TTV.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(130, 302, 216, 22);
		jp_TTV.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(130, 339, 216, 22);
		jp_TTV.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(130, 376, 216, 22);
		jp_TTV.add(textField_9);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(401, 65, 1050, 477);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1050, 477);
		panel_3.add(scrollPane);
		
		table_TTV = new JTable();
		scrollPane.setViewportView(table_TTV);
		table_TTV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Tên khách hàng", "Ga đến", "Ngày đi", "Loại vé", "Toa", "Ghế", "Mã vé", "Mã chuyến tàu", "Giờ đi", "Giá"
			}
		));
		
		
		JButton btnNewButton = new JButton("Đổi vé");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(145, 504, 85, 25);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoiVe_GUI doiVe = new DoiVe_GUI(QuanLyVe_Gui.this,trangChu);
				trangChu.content.removeAll();
				trangChu.content.add(doiVe);
				trangChu.content.revalidate();
				trangChu.content.repaint();
			}
		});
	}
}
