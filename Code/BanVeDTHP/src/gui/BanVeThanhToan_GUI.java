package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.ConTent_JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

public class BanVeThanhToan_GUI extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField_TKD;
	private JTextField textField_TTL;
	private JTable table_2;
	private JTable table_1;
	private JButton btn500;
	private JButton btn200;
	private JButton btn100;
	private JButton btn50;
	private JButton btn20;
	private JButton btn10;
	private JButton btn5;
	private JButton btn2;
	private JButton btn1;
	private JButton btn33;
	private JButton btn35;
	private JButton btn44;
	private JButton btn_XacNhan;
	private JButton btnXoa;
	float tienKhachDua= 0;
	float tienTraLai=0;
	private float tongTienCoThue=0;
	
	public BanVeThanhToan_GUI(BanVeNhapThongTin_Gui banVeNhapThongTin_GUI, TrangChu_GUI trangChu) {
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
		scrollPane.setBounds(10, 146, 906, 293);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"a", "b", "c", "d", "e", "e -> f", "g = d - f"},
				{"1", "VE2209240001", "Từ Ga Sài Gòn đến Ga Hà Nội Ngày 12/11/2024  Lúc: 08:00 Giường nằm Toa 02 Ghế số 2", "601,920", "Trẻ em từ 6 tuổi đến 10 tuổi", "150,480", "451,440"},
				{"2"},
				{"3"},
				{"4"},
			},
			new String[] {
				"STT", "Mã vé", "Thông tin vé", "Giá gốc (VND)", "Đối tượng", "Khuyến mãi (VND)", "Thành tiền chưa thuế (VND)"
			}
		));
		table.setRowHeight(1,45);
		table.setRowHeight(2,45);
		table.setRowHeight(3,45);
		table.setRowHeight(4,45);
		
		//Điều chính kích thước ô
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(170);
		table.getColumnModel().getColumn(2).setPreferredWidth(206);
		table.getColumnModel().getColumn(3).setPreferredWidth(98);
		table.getColumnModel().getColumn(4).setPreferredWidth(206);
		table.getColumnModel().getColumn(5).setPreferredWidth(98);
		table.getColumnModel().getColumn(6).setPreferredWidth(98);
		
		// Tạo DefaultTableCellRenderer và căn giữa
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		// Áp dụng renderer cho tất cả các cột
		for (int i = 0; i < table.getColumnCount(); i++) {
		    table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		
		scrollPane.setViewportView(table);
		
		table_2 = new JTable();
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{"Thuế giá trị gia tăng (10%):", "140,448 VND"},
				{"Tổng tiền bằng số:", "140,448 VND"},
				{"Tổng tiền bằng chữ:", "MỘT TRIỆU NĂM TRĂM BỐN MƯƠI BỐN NGHÌN CHÍN TRĂM HAI MƯƠI TÁM ĐỒNG"},
			},
			new String[] {
				"New column", "New column"
			}
		));
		
		table_2.getColumnModel().getColumn(0).setPreferredWidth(200); // Cột đầu tiên rộng 200px
		table_2.getColumnModel().getColumn(1).setPreferredWidth(706); // Cột thứ hai rộng 300px
		
		// Áp dụng căn giữa cho cột thứ hai
		table_2.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		
		// Tạo DefaultTableCellRenderer và thiết lập font in đậm cho cột thứ nhất
		DefaultTableCellRenderer boldRenderer = new DefaultTableCellRenderer() {
		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		        c.setFont(c.getFont().deriveFont(Font.BOLD)); // Thiết lập font in đậm
		        return c;
		    }
		};

		// Áp dụng boldRenderer cho cột thứ nhất
		table_2.getColumnModel().getColumn(0).setCellRenderer(boldRenderer);
		
		table_2.setBounds(10, 454, 906, 48);
		panel.add(table_2);
		
		table_1 = new JTable();
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Tổng cộng (VND):", null, "2,207,040", null, "802,560", "1,404,480"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		
		//Điều chính kích thước ô
		table_1.getColumnModel().getColumn(0).setPreferredWidth(200);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(206);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(98);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(206);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(98);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(98);
		
		// Áp dụng căn giữa cho cột thứ hai
		table_1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table_1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table_1.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		
		// Áp dụng boldRenderer cho cột thứ nhất
		table_1.getColumnModel().getColumn(0).setCellRenderer(boldRenderer);
		
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table_1.setBounds(10, 439, 906, 15);
		panel.add(table_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(986, 48, 444, 512);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tiền khách đưa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(53, 10, 327, 30);
		panel_1.add(lblNewLabel_1);
		
		textField_TKD = new JTextField("0 đ");
		textField_TKD.setBackground(Color.CYAN);
		textField_TKD.setBounds(53, 44, 327, 30);
		panel_1.add(textField_TKD);
		textField_TKD.setColumns(10);
		textField_TKD.setEditable(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhập số tiền theo mệnh giá");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(53, 97, 327, 30);
		panel_1.add(lblNewLabel_1_1);
		
		btn500 = new JButton("500.000");
		btn500.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn500.setBounds(53, 137, 100, 30);
		panel_1.add(btn500);
		
		btn200 = new JButton("200.000");
		btn200.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn200.setBounds(163, 137, 100, 30);
		panel_1.add(btn200);
		
		btn100 = new JButton("100.000");
		btn100.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn100.setBounds(273, 137, 100, 30);
		panel_1.add(btn100);
		
		btn50 = new JButton("50.000");
		btn50.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn50.setBounds(53, 184, 100, 30);
		panel_1.add(btn50);
		
		btn20 = new JButton("20.000");
		btn20.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn20.setBounds(163, 184, 100, 30);
		panel_1.add(btn20);
		
		btn10 = new JButton("10.000");
		btn10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn10.setBounds(273, 184, 100, 30);
		panel_1.add(btn10);
		
		btn5 = new JButton("5.000");
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn5.setBounds(53, 231, 100, 30);
		panel_1.add(btn5);
		
		btn2 = new JButton("2.000");
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn2.setBounds(163, 231, 100, 30);
		panel_1.add(btn2);
		
		btn1 = new JButton("1.000");
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn1.setBounds(273, 231, 100, 30);
		panel_1.add(btn1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Gợi ý tiền mặt");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(53, 282, 327, 30);
		panel_1.add(lblNewLabel_1_1_1);
		
		btn33 = new JButton("5.000");
		btn33.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn33.setBounds(53, 325, 100, 30);
		panel_1.add(btn33);
		
		btn35 = new JButton("5.000");
		btn35.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn35.setBounds(163, 325, 100, 30);
		panel_1.add(btn35);
		
		btn44 = new JButton("5.000");
		btn44.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn44.setBounds(273, 325, 100, 30);
		panel_1.add(btn44);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Tiền trả lại");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(53, 382, 327, 30);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		textField_TTL = new JTextField("0 đ");
		textField_TTL.setColumns(10);
		textField_TTL.setBackground(Color.CYAN);
		textField_TTL.setBounds(53, 419, 327, 30);
		panel_1.add(textField_TTL);
		textField_TTL.setEditable(false);
		btn_XacNhan = new JButton("Xác nhận");
		btn_XacNhan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_XacNhan.setBounds(301, 472, 106, 30);
		panel_1.add(btn_XacNhan);
		
		btnXoa = new JButton("Nhập lại");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(180, 472, 106, 30);
		panel_1.add(btnXoa);
		
		//Sự kiện nút
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn5.addActionListener(this);
		btn10.addActionListener(this);
		btn20.addActionListener(this);
		btn50.addActionListener(this);
		btn100.addActionListener(this);
		btn200.addActionListener(this);
		btn500.addActionListener(this);

		btn33.addActionListener(this);
		btn35.addActionListener(this);
		btn44.addActionListener(this);
		
		btnXoa.addActionListener(this);
	}
	
	// Renderer tùy chỉnh để gộp hai cột đầu tiên (STT & Mã vé)
    static class CombinedColumnRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // Lấy giá trị từ cột 0 và cột 1 (STT & Mã vé)
            String stt = (String) table.getModel().getValueAt(row, 0);
            String maVe = (String) table.getModel().getValueAt(row, 1);

            // Hiển thị gộp dữ liệu của hai cột
            JLabel label = new JLabel("<html><b>" + stt + "</b><br>" + maVe + "</html>");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setOpaque(true);
            if (isSelected) {
                label.setBackground(table.getSelectionBackground());
                label.setForeground(table.getSelectionForeground());
            } else {
                label.setBackground(table.getBackground());
                label.setForeground(table.getForeground());
            }
            return label;
        }
    }

    public String dinhDangTienTe(double soTien) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		return formatter.format(soTien);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();

		if (o.equals(btnXoa)) {
			tienKhachDua = 0;
			// Hiển thị số tiền đã định dạng
			tienTraLai = 0;
			textField_TKD.setText(dinhDangTienTe(tienKhachDua));
			textField_TTL.setText(dinhDangTienTe(tienTraLai));
		} else {
			float soTienThem = 0;

			// Xác định số tiền cần thêm dựa trên nút bấm
			if (o.equals(btn1)) soTienThem = 1000;
			if (o.equals(btn2)) soTienThem = 2000;
			if (o.equals(btn5)) soTienThem = 5000;
			if (o.equals(btn10)) soTienThem = 10000;
			if (o.equals(btn20)) soTienThem = 20000;
			if (o.equals(btn50)) soTienThem = 50000;
			if (o.equals(btn100)) soTienThem = 100000;
			if (o.equals(btn200)) soTienThem = 200000;
			if (o.equals(btn500)) soTienThem = 500000;
			if (o.equals(btn33)) soTienThem = 33000;
			if (o.equals(btn35)) soTienThem = 35000;
			if (o.equals(btn44)) soTienThem = 44000;

			// Kiểm tra nếu text hiện tại là "0 đ" thì đặt `tienKhachDua` thành `soTienThem`
			if (textField_TKD.getText().equalsIgnoreCase("0 đ")) {
				tienKhachDua = soTienThem;
				textField_TKD.setText(dinhDangTienTe(tienKhachDua)); // Cập nhật textField
			} else {
				tienKhachDua += soTienThem;
				textField_TKD.setText(dinhDangTienTe(tienKhachDua));
			}
			tienTraLai = tienKhachDua - tongTienCoThue;
			textField_TTL.setText(dinhDangTienTe(tienTraLai));
		}

	}
}
