package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.table.DefaultTableModel;

import components.ConTent_JPanel;
import components.RoundedButton;
import components.RoundedTextField;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.border.TitledBorder;

public class QuanLyKhachHang_GUI extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private int cornerRadius;
	private JTextField textField;
	private JTextField textFieldTenKH;
	private JTextField textFieldEmail;
	private JTextField textFieldSDT;
	private JTextField textFieldCCCD;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private String placeholder;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table_1;
	/**
	 * Create the panel.
	 */
	public QuanLyKhachHang_GUI(TrangChu_GUI trangChu) {
		setBackground(SystemColor.text);
		setForeground(new Color(255, 255, 255));
		setBounds(0, 170, 1440, 570);
		setLayout(null);
		
		JPanel jp_QL = new JPanel();
		jp_QL.setLayout(null);
		jp_QL.setBounds(10, 10, 124, 28);
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
				QuanLyKhachHang_GUI.this.setVisible(false);
				}
		});
		JLabel lb_quaylai = new JLabel("Quay lại");
		lb_quaylai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_quaylai.setBounds(45, 0, 69, 27);
		jp_QL.add(lb_quaylai);
		
		JPanel panelTimKiem = new JPanel();
		panelTimKiem.setLayout(null);
		panelTimKiem.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTimKiem.setBounds(10, 47, 1400, 86);
		add(panelTimKiem);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(51, 102, 153));
		panel_1.setBounds(0, 0, 1400, 36);
		panelTimKiem.add(panel_1);
		
		JLabel lbTimKiem = new JLabel("Tìm kiếm");
		lbTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
		lbTimKiem.setForeground(Color.WHITE);
		lbTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbTimKiem.setBackground(new Color(0, 191, 255));
		lbTimKiem.setBounds(0, 0, 293, 36);
		panel_1.add(lbTimKiem);
		
		RoundedButton btnTim = new RoundedButton("Tìm", 15);
		btnTim.setForeground(SystemColor.desktop);
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTim.setBackground(SystemColor.activeCaptionBorder);
		btnTim.setBounds(1283, 8, 85, 25);
		panel_1.add(btnTim);
		
		RoundedTextField textField_5_1 = new RoundedTextField(15);
		textField_5_1.setColumns(10);
		textField_5_1.setBounds(215, 49, 250, 30);
		panelTimKiem.add(textField_5_1);
		
		JLabel lblNewLabel_5 = new JLabel("Mã khách hàng");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(74, 46, 120, 30);
		panelTimKiem.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tên khách hàng");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_1.setBounds(501, 46, 126, 30);
		panelTimKiem.add(lblNewLabel_5_1);
		
		RoundedTextField textField_6_1 = new RoundedTextField(15);
		textField_6_1.setColumns(10);
		textField_6_1.setBounds(647, 49, 250, 30);
		panelTimKiem.add(textField_6_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Số điện thoại");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_2.setBounds(966, 46, 116, 30);
		panelTimKiem.add(lblNewLabel_5_2);
		
		RoundedTextField textField_7_1 = new RoundedTextField(15);
		textField_7_1.setColumns(10);
		textField_7_1.setBounds(1089, 49, 250, 30);
		panelTimKiem.add(textField_7_1);
		
		JPanel panelThongTinKhachHang = new JPanel();
		panelThongTinKhachHang.setLayout(null);
		panelThongTinKhachHang.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelThongTinKhachHang.setBounds(10, 143, 337, 407);
		add(panelThongTinKhachHang);
		
		JLabel lblNewLabel = new JLabel("Tên Khách hàng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(35, 46, 150, 20);
		panelThongTinKhachHang.add(lblNewLabel);
		
		RoundedTextField textField_1_1 = new RoundedTextField(15);
		textField_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1_1.setColumns(10);
		textField_1_1.setBounds(35, 75, 250, 30);
		panelThongTinKhachHang.add(textField_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(35, 115, 150, 20);
		panelThongTinKhachHang.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Số điện thoại:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(35, 195, 150, 20);
		panelThongTinKhachHang.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Căn cước công dân:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(35, 270, 150, 20);
		panelThongTinKhachHang.add(lblNewLabel_3);
		
		RoundedTextField textField_2_1 = new RoundedTextField(15);
		textField_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2_1.setColumns(10);
		textField_2_1.setBounds(35, 145, 250, 30);
		panelThongTinKhachHang.add(textField_2_1);
		
		RoundedTextField textField_3_1 = new RoundedTextField(15);
		textField_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3_1.setColumns(10);
		textField_3_1.setBounds(35, 225, 250, 30);
		panelThongTinKhachHang.add(textField_3_1);
		
		RoundedTextField textField_4_1 = new RoundedTextField(15);
		textField_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4_1.setColumns(10);
		textField_4_1.setBounds(35, 305, 250, 30);
		panelThongTinKhachHang.add(textField_4_1);
		
		RoundedButton btnThem = new RoundedButton("Thêm", 15);
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThem.setBackground(new Color(51, 102, 153));
		btnThem.setBounds(45, 359, 85, 25);
		panelThongTinKhachHang.add(btnThem);
		
		RoundedButton btnSua = new RoundedButton("Sửa", 15);
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSua.setBackground(new Color(51, 102, 153));
		btnSua.setBounds(190, 359, 85, 25);
		panelThongTinKhachHang.add(btnSua);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(51, 102, 153));
		panel_2.setBounds(0, 0, 337, 36);
		panelThongTinKhachHang.add(panel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Thông tin khách hàng");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(0, 0, 337, 36);
		panel_2.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(357, 143, 1053, 407);
		add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Mã khách hàng", "Tên khách hàng", "Email", "Số điện thoại", "Căn cước công dân"
			}
		));
		table_1.setFont(new Font("Tahoma", Font.BOLD, 16));

	}
	
}
