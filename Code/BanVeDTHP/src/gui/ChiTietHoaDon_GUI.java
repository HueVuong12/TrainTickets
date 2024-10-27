package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class ChiTietHoaDon_GUI extends JPanel {
	private JTextField txtMaChiTiet;
	private JTextField txtMaHoaDon;
	private JTextField txtTu;
	private JTextField txtDen;
	private JTable table;
	private JTable table_1;
	public ChiTietHoaDon_GUI() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(30, 10, 146, 35);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblMuiTen = new JLabel("New label");
		lblMuiTen.setIcon(new ImageIcon(getClass().getResource("/img/9054423_bx_arrow_back_icon.png")));
		lblMuiTen.setBounds(10, 10, 43, 26);
		panel.add(lblMuiTen);
		
		JLabel lblNewLabel_1 = new JLabel("Quay lại");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(63, -6, 86, 55);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(30, 60, 274, 167);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 102, 153));
		panel_2.setBounds(0, 0, 274, 32);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setForeground(new Color(255, 255, 255));
		lblTimKiem.setBounds(10, 0, 98, 32);
		panel_2.add(lblTimKiem);
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\PTUD_BTLON\\TrainTicket-Project\\Code\\BanVeDTHP\\img\\Polygon_20.png"));
		lblNewLabel.setBounds(230, 0, 34, 30);
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 34, 274, 133);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblMaChiTiet = new JLabel("Mã chi tiết:");
		lblMaChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaChiTiet.setBounds(10, 0, 93, 30);
		panel_3.add(lblMaChiTiet);
		
		txtMaChiTiet = new JTextField();
		txtMaChiTiet.setBounds(7, 26, 257, 30);
		panel_3.add(txtMaChiTiet);
		txtMaChiTiet.setColumns(10);
		
		JLabel lblMaHoaDon = new JLabel("Mã hóa đơn");
		lblMaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaHoaDon.setBounds(10, 64, 110, 30);
		panel_3.add(lblMaHoaDon);
		
		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setColumns(10);
		txtMaHoaDon.setBounds(7, 92, 257, 30);
		panel_3.add(txtMaHoaDon);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(30, 237, 274, 157);
		add(panel_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(51, 102, 153));
		panel_2_1.setBounds(0, 0, 274, 32);
		panel_1_1.add(panel_2_1);
		
		JLabel lblGia = new JLabel("Giá");
		lblGia.setForeground(Color.WHITE);
		lblGia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGia.setBounds(10, 0, 98, 32);
		panel_2_1.add(lblGia);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\PTUD_BTLON\\TrainTicket-Project\\Code\\BanVeDTHP\\img\\Polygon_20.png"));
		lblNewLabel_2.setBounds(230, 0, 34, 30);
		panel_2_1.add(lblNewLabel_2);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(0, 34, 274, 123);
		panel_1_1.add(panel_3_1);
		
		JLabel lblTu = new JLabel("Từ:");
		lblTu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTu.setBounds(10, 0, 93, 30);
		panel_3_1.add(lblTu);
		
		txtTu = new JTextField();
		txtTu.setColumns(10);
		txtTu.setBounds(7, 26, 257, 30);
		panel_3_1.add(txtTu);
		
		JLabel lblDen = new JLabel("Đến:");
		lblDen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDen.setBounds(10, 52, 110, 30);
		panel_3_1.add(lblDen);
		
		txtDen = new JTextField();
		txtDen.setColumns(10);
		txtDen.setBounds(7, 80, 257, 30);
		panel_3_1.add(txtDen);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBounds(30, 404, 274, 95);
		add(panel_1_1_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(new Color(51, 102, 153));
		panel_2_1_1.setBounds(0, 0, 274, 32);
		panel_1_1_1.add(panel_2_1_1);
		
		JLabel lblGia_1 = new JLabel("Số lượng");
		lblGia_1.setForeground(Color.WHITE);
		lblGia_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGia_1.setBounds(10, 0, 98, 32);
		panel_2_1_1.add(lblGia_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\PTUD_BTLON\\TrainTicket-Project\\Code\\BanVeDTHP\\img\\Polygon_20.png"));
		lblNewLabel_3.setBounds(230, 0, 34, 30);
		panel_2_1_1.add(lblNewLabel_3);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBounds(0, 34, 274, 61);
		panel_1_1_1.add(panel_3_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox.setBounds(10, 10, 254, 31);

		panel_3_1_1.add(comboBox);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(314, 10, 1147, 365);
		add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1146, 365);
		panel_4.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 chi ti\u1EBFt", "M\u00E3 h\u00F3a \u0111\u01A1n", "S\u1ED1 l\u01B0\u1EE3ng", "Th\u00E0nh ti\u1EC1n (ch\u01B0a thu\u1EBF)", "Thu\u1EBF GTGT", "T\u1ED5ng ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(51, 102, 153));
		panel_5.setBounds(314, 385, 136, 29);
		add(panel_5);
		
		JLabel lblDSVe = new JLabel("Danh sách vé");
		panel_5.add(lblDSVe);
		lblDSVe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDSVe.setForeground(new Color(255, 255, 255));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(314, 419, 1147, 132);
		add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 1147, 132);
		panel_6.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 v\u00E9", "M\u00E3 chi ti\u1EBFt", "H\u1EA1ng", "Lo\u1EA1i", "Gi\u00E1"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("Xuất hóa đơn");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(100, 516, 151, 35);
		add(btnNewButton);
		
	}
}
