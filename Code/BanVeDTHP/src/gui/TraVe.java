package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TraVe extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JPanel panel;
	private JLabel lblIconarrow;
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
	private JButton btnNewButton_4;
	private JButton button;
	private JButton btnNewButton_5;
	private JPanel panel_4;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_1_1;
	private JButton btnNewButton_2_1;
	private JButton btnNewButton_3_1;
	private JButton btnNewButton_1_1_1;
	private JButton btnNewButton_2_1_1;
	private JPanel panel_5;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JButton btnXacNhan;
	private JButton btnHuy;

	/**
	 * Create the panel.
	 */
	public TraVe() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 170, 1460, 570);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(25, 10, 142, 44);
		add(panel);
		panel.setLayout(null);
		
		lblIconarrow = new JLabel("");
		lblIconarrow.setIcon(new ImageIcon("/img/9054423_bx_arrow_back_icon.png"));
		lblIconarrow.setBounds(10, 10, 45, 24);
		panel.add(lblIconarrow);
		
		lblQuayLai = new JLabel("Quay lại");
		lblQuayLai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuayLai.setBounds(55, 10, 77, 24);
		panel.add(lblQuayLai);
		
		panel_1 = new JPanel();
		panel_1.setBounds(25, 59, 1425, 141);
		add(panel_1);
		panel_1.setLayout(null);
		
		lblThongTin = new JLabel("Thông tin chi tiết hóa đơn");
		lblThongTin.setBounds(10, 10, 174, 19);
		panel_1.add(lblThongTin);
		lblThongTin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 1405, 80);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã chi tiết", "Mã hóa đơn", "Khách hàng", "Số lượng", "Thành tiền (Chưa thuế)", "Thuế GTGT", "Tổng tiền"
			}
		));
		scrollPane.setViewportView(table);
		
		panel_2 = new JPanel();
		panel_2.setBounds(25, 210, 1425, 221);
		add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel = new JLabel("Danh sách vé");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 160, 25);
		panel_2.add(lblNewLabel);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 45, 1395, 166);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Mã vé", "Hạng", "Đối tượng", "Gía"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		panel_3 = new JPanel();
		panel_3.setBounds(25, 441, 541, 129);
		add(panel_3);
		panel_3.setLayout(null);
		
		lblTienKhachDua = new JLabel("Tiền khách đưa");
		lblTienKhachDua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTienKhachDua.setBounds(26, 10, 123, 19);
		panel_3.add(lblTienKhachDua);
		
		textField = new JTextField();
		textField.setBounds(26, 39, 505, 19);
		panel_3.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Gợi ý tiền mặt");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(26, 68, 123, 24);
		panel_3.add(lblNewLabel_3);
		
		btnNewButton_4 = new JButton("33.000");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4.setBounds(26, 98, 142, 21);
		panel_3.add(btnNewButton_4);
		
		button = new JButton("35.000");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(218, 98, 130, 21);
		panel_3.add(button);
		
		btnNewButton_5 = new JButton("40.000");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_5.setBounds(394, 98, 137, 21);
		panel_3.add(btnNewButton_5);
		
		panel_4 = new JPanel();
		panel_4.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		panel_4.setBounds(576, 441, 432, 129);
		add(panel_4);
		panel_4.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Nhập số tiền theo mệnh giá");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 0, 209, 27);
		panel_4.add(lblNewLabel_1);
		
		btnNewButton = new JButton("500.000");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnNewButton.setBounds(10, 37, 107, 21);
		panel_4.add(btnNewButton);
		
		btnNewButton_1 = new JButton("200.000");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(150, 37, 107, 21);
		panel_4.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("100.000");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(293, 37, 107, 21);
		panel_4.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("50.000");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(10, 67, 107, 21);
		panel_4.add(btnNewButton_3);
		
		btnNewButton_1_1 = new JButton("20.000");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(150, 67, 107, 21);
		panel_4.add(btnNewButton_1_1);
		
		btnNewButton_2_1 = new JButton("10.000");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_1.setBounds(293, 67, 107, 21);
		panel_4.add(btnNewButton_2_1);
		
		btnNewButton_3_1 = new JButton("5.000");
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3_1.setBounds(10, 98, 107, 21);
		panel_4.add(btnNewButton_3_1);
		
		btnNewButton_1_1_1 = new JButton("2.000");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_1.setBounds(150, 98, 107, 21);
		panel_4.add(btnNewButton_1_1_1);
		
		btnNewButton_2_1_1 = new JButton("1.000");
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_1_1.setBounds(293, 98, 107, 21);
		panel_4.add(btnNewButton_2_1_1);
		
		panel_5 = new JPanel();
		panel_5.setBounds(1035, 444, 415, 126);
		add(panel_5);
		panel_5.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Tiền khách trả lại");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 10, 132, 20);
		panel_5.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 36, 395, 30);
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXacNhan.setBounds(10, 76, 97, 30);
		panel_5.add(btnXacNhan);
		
		btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHuy.setBounds(131, 76, 97, 30);
		panel_5.add(btnHuy);

	}
}
