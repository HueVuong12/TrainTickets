package gui;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.Image;
import javax.swing.table.DefaultTableModel;

import components.ConTent_JPanel;
import components.RoundedButton;
import components.RoundedTextField;
import dao.KhachHang_DAO;
import entity.KhachHang;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class QuanLyKhachHang_GUI extends JPanel implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;

	private JTable table;
	private DefaultTableModel tableModel;
	private RoundedTextField txtMaKH;

	private RoundedTextField txtCCCD;

	private RoundedTextField txtSDT;

	private RoundedTextField txtEmail;

	private RoundedTextField txtTenKH;

	private RoundedButton btnTim;

	private RoundedButton btnSua;

	private RoundedButton btnThem;

	// khai báo DAO
	private KhachHang_DAO dskh = new KhachHang_DAO();
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

		// Icon Quay lại
		ImageIcon goBackIcon = new ImageIcon(getClass().getResource("/img/9054423_bx_arrow_back_icon.png"));
		Image scaledGoBack = goBackIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Thay đổi kích thước
																									// logo
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

		btnTim = new RoundedButton("Tìm", 15);
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
		lblNewLabel.setBounds(35, 113, 150, 20);
		panelThongTinKhachHang.add(lblNewLabel);

		txtTenKH = new RoundedTextField(15);
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(35, 134, 250, 30);
		panelThongTinKhachHang.add(txtTenKH);

		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(35, 174, 150, 20);
		panelThongTinKhachHang.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Số điện thoại:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(35, 243, 150, 20);
		panelThongTinKhachHang.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Căn cước công dân:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(35, 302, 150, 20);
		panelThongTinKhachHang.add(lblNewLabel_3);

		txtEmail = new RoundedTextField(15);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(35, 193, 250, 30);
		panelThongTinKhachHang.add(txtEmail);

		txtSDT = new RoundedTextField(15);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBounds(35, 262, 250, 30);
		panelThongTinKhachHang.add(txtSDT);

		txtCCCD = new RoundedTextField(15);
		txtCCCD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(35, 321, 250, 30);
		panelThongTinKhachHang.add(txtCCCD);

		btnThem = new RoundedButton("Thêm", 15);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validData()) {
					KhachHang kh = revertKH();

					if (kh != null) {
						KhachHang existingKH = dskh.getKhachHangTheoMaKH(kh.getMaKH());
						if (existingKH != null) {
							JOptionPane.showMessageDialog(null, "Khách hàng đã tồn tại trong cơ sở dữ liệu.", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
						} else {
							try {
								dskh.create(kh);
								tableModel.setRowCount(0);
								datatoTable();
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null,
										"Lỗi khi thêm khách hàng vào cơ sở dữ liệu: " + e1.getMessage(), "Lỗi",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					deleteField();
				}
			}
		});
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThem.setBackground(new Color(51, 102, 153));
		btnThem.setBounds(47, 372, 85, 25);
		panelThongTinKhachHang.add(btnThem);

		btnSua = new RoundedButton("Sửa", 15);
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSua.setBackground(new Color(51, 102, 153));
		btnSua.setBounds(189, 372, 85, 25);
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

		txtMaKH = new RoundedTextField(15);
		txtMaKH.setEditable(false);
		txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(35, 73, 250, 30);
		panelThongTinKhachHang.add(txtMaKH);

		JLabel lblMaKhachHang = new JLabel("Mã Khách hàng:");
		lblMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaKhachHang.setBounds(35, 46, 150, 20);
		panelThongTinKhachHang.add(lblMaKhachHang);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(357, 143, 1053, 407);
		add(scrollPane);

		table = new JTable();
		tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "STT", "Mã khách hàng", "Tên khách hàng",
				"Email", "Số điện thoại", "Căn cước công dân" });
		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		btnSua.addActionListener(this);
		btnTim.addActionListener(this);
		datatoTable();
		table.addMouseListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnThem)) {
			update();
		}
		if (o.equals(btnSua)) {
			update();
		}
		if (o.equals(btnTim)) {
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		if (row != -1) {
			KhachHang kh = dskh.getKhachHangTheoMaKH(table.getModel().getValueAt(row, 1).toString());
			txtMaKH.setText(kh.getMaKH());
			txtTenKH.setText(kh.getTenKH());
			txtEmail.setText(kh.getEmail());
			txtSDT.setText(kh.getSdt());
			txtCCCD.setText(kh.getCccd());
		}
	}

	public boolean validData() {
		if (txtTenKH.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Tên khách hàng không được để trống");
			return false;
		}
		if (txtEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Email không được bỏ trống");
			return false;
		}
		if (txtSDT.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được bỏ trống");
			return false;
		}
		if (txtCCCD.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "CCCD không được bỏ trống");
			return false;
		}
		return true;
	}

	public KhachHang revertKH() {
		String maNV = generateMaKH();
		String hoTen = txtTenKH.getText();
		String email = txtEmail.getText();
		String sdt = txtSDT.getText();
		String cccd = txtCCCD.getText();

		KhachHang kh = new KhachHang(maNV, hoTen, email, sdt, cccd);

		return kh;
	}

	public void update() {
		int index = table.getSelectedRow();
		if (index != -1) {
			String maKH = txtMaKH.getText();
			String hoTen = txtTenKH.getText();
			String email = txtEmail.getText();
			String sdt = txtSDT.getText();
			String cccd = txtCCCD.getText();

			KhachHang kh = new KhachHang(maKH, hoTen, email, sdt, cccd);
			try {
				dskh.update(kh);
				tableModel.setRowCount(0);
				datatoTable();
				deleteField();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy.");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chọn khách hàng cần sửa.");
		}
		deleteField();
	}

	public void datatoTable() {
		dskh.reset();
		ArrayList<KhachHang> list = dskh.docTuBang();
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		int stt = 1;
		for (KhachHang kh : list) {
			tableModel.addRow(
					new Object[] { stt++, kh.getMaKH(), kh.getTenKH(), kh.getEmail(), kh.getSdt(), kh.getCccd() });
		}
	}

	public String generateMaKH() {
		dskh.reset();
		ArrayList<KhachHang> list = dskh.docTuBang();
		System.err.println(list.size());
		int sl = list.size() + 1;
		String maKH = String.format("KH%04d", sl);
		return maKH;
	}

	public void deleteField() {
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtEmail.setText("");
		txtSDT.setText("");
		txtCCCD.setText("");
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
