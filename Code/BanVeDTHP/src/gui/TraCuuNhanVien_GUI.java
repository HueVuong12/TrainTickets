package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TraCuuNhanVien_GUI extends JPanel {
	private JTextField txtMNhnVin;
	private JTextField txtHoTen;
	private JTextField txtGioiw;
	private JTextField txtSinThoi;
	private JTextField txtEmail;
	private JTextField txtChcV;
	private JTextField textField;
	private JTable table;
	public TraCuuNhanVien_GUI(TrangChu_GUI trangChu) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 284, 557);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNMa = new JLabel("Mã nhân viên");
		lblNMa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNMa.setBounds(22, 82, 111, 27);
		panel.add(lblNMa);
		
		txtMNhnVin = new JTextField();
		txtMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMNhnVin.setText("Mã nhân viên");
		txtMNhnVin.setBounds(22, 108, 239, 33);
		panel.add(txtMNhnVin);
		txtMNhnVin.setColumns(10);
		
		JLabel lblHTn = new JLabel("Họ tên:");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHTn.setBounds(22, 146, 111, 27);
		panel.add(lblHTn);
		
		txtHoTen = new JTextField();
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHoTen.setText("Họ tên");
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(22, 170, 239, 27);
		panel.add(txtHoTen);
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGioiTinh.setBounds(22, 207, 74, 21);
		panel.add(lblGioiTinh);
		
		txtGioiw = new JTextField();
		txtGioiw.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtGioiw.setText("Giới tính");
		txtGioiw.setBounds(22, 232, 237, 27);
		panel.add(txtGioiw);
		txtGioiw.setColumns(10);
		
		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSDT.setBounds(22, 269, 111, 27);
		panel.add(lblSDT);
		
		txtSinThoi = new JTextField();
		txtSinThoi.setText("Số điện thoại");
		txtSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSinThoi.setColumns(10);
		txtSinThoi.setBounds(22, 293, 237, 27);
		panel.add(txtSinThoi);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(22, 330, 88, 27);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(22, 354, 237, 27);
		panel.add(txtEmail);
		
		JLabel lblChucVu = new JLabel("Chức vụ");
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChucVu.setBounds(22, 391, 88, 27);
		panel.add(lblChucVu);
		
		txtChcV = new JTextField();
		txtChcV.setText("Chức vụ");
		txtChcV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtChcV.setColumns(10);
		txtChcV.setBounds(22, 420, 237, 27);
		panel.add(txtChcV);
		
		JLabel lblCa = new JLabel("Ca:");
		lblCa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCa.setBounds(22, 457, 74, 21);
		panel.add(lblCa);
		
		textField = new JTextField();
		textField.setText("Chức vụ");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(22, 477, 237, 27);
		panel.add(textField);
		
		JButton btnTìm = new JButton("Tìm");
		btnTìm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTìm.setBounds(138, 514, 118, 27);
		panel.add(btnTìm);
		btnTìm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_top = new JPanel();
		panel_top.setBounds(0, 0, 283, 54);
		panel.add(panel_top);
		panel_top.setBackground(new Color(51, 102, 153));
		panel_top.setLayout(null);
		JLabel lblThongTinNhanVien = new JLabel("Thông tin nhân viên");
		lblThongTinNhanVien.setBounds(0, 0, 283, 52);
		panel_top.add(lblThongTinNhanVien);
		lblThongTinNhanVien.setBackground(new Color(51, 102, 153));
		lblThongTinNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinNhanVien.setForeground(new Color(255, 255, 255));
		lblThongTinNhanVien.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(304, 10, 1126, 557);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 nh\u00E2n vi\u00EAn", "H\u1ECD t\u00EAn", "Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "CCCD", "S\u0110T", "Email", "Ca", "Ch\u1EE9c v\u1EE5", "Tr\u1EA1ng th\u00E1i"
			}
		));
		scrollPane.setViewportView(table);
	}
}
