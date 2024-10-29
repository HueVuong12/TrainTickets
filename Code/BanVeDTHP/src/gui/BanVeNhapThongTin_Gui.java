package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import components.ButtonEditor;
import components.ButtonRenderer;
import components.ComboBoxRenderer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;

public class BanVeNhapThongTin_Gui extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel goBackIconLabel;
	private JLabel lbl_quayLai;
	private JPanel jp_KHMV;
	private JTabbedPane tabbedPane;
	private JTextField textField_Ten_KHMV;
	private JTextField textField_Email_KHMV;
	private JTextField textField_SDT_KHMV;
	private JTextField textField_CCCD_KHMV;
	private JTable table_KHMV;
	private JPanel jp_KHSDV;
	private JTextField textField_Ten_KHSDV;
	private JTextField textField_Email_KHSDV;
	private JTextField textField_SDT_KHSDV;
	private JTextField textField_CCCD_KHSDV;
	private JTable table_KHSDV;
	
	public BanVeNhapThongTin_Gui(BanVe_GUI banVe_GUI,TrangChu_GUI trangChu) {
		setBackground(SystemColor.window);
		setForeground(new Color(255, 255, 255));
		setBounds(0, 170, 1460, 570);
		setLayout(null);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 124, 47);
		jp_quayLai.add(panel_1);
		panel_1.setLayout(null);
		goBackIconLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				trangChu.content.removeAll();
				trangChu.content.add(banVe_GUI);
				trangChu.content.revalidate();
				trangChu.content.repaint();
			}
		});
		
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
				
		jp_KHMV = new JPanel();
		jp_KHMV.setBackground(SystemColor.textHighlightText);
		tabbedPane.addTab("Khách hàng mua vé", null, jp_KHMV, null);
		jp_KHMV.setLayout(null);
		
		JButton bt_ThanhToan_KHMV = new JButton("Thanh toán");
		bt_ThanhToan_KHMV.setBounds(1216, 411, 120, 30);
		jp_KHMV.add(bt_ThanhToan_KHMV);
		bt_ThanhToan_KHMV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel jp_content_KHMV = new JPanel();
		jp_content_KHMV.setLayout(null);
		jp_content_KHMV.setBounds(20, 10, 1335, 98);
		jp_KHMV.add(jp_content_KHMV);
		
		JLabel lb_Ten_KHMV = new JLabel("Họ và tên");
		lb_Ten_KHMV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_Ten_KHMV.setBounds(75, 15, 96, 25);
		jp_content_KHMV.add(lb_Ten_KHMV);
		
		JLabel lb_Email_KHMV = new JLabel("Email");
		lb_Email_KHMV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_Email_KHMV.setBounds(75, 56, 96, 22);
		jp_content_KHMV.add(lb_Email_KHMV);
		
		textField_Ten_KHMV = new JTextField();
		textField_Ten_KHMV.setColumns(10);
		textField_Ten_KHMV.setBounds(224, 17, 264, 25);
		jp_content_KHMV.add(textField_Ten_KHMV);
		
		textField_Email_KHMV = new JTextField();
		textField_Email_KHMV.setColumns(10);
		textField_Email_KHMV.setBounds(224, 57, 264, 25);
		jp_content_KHMV.add(textField_Email_KHMV);
		
		JLabel lb_SDT_KHMV = new JLabel("Số điện thoại");
		lb_SDT_KHMV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_SDT_KHMV.setBounds(601, 12, 143, 25);
		jp_content_KHMV.add(lb_SDT_KHMV);
		
		JLabel lb_CCCD_KHMV = new JLabel("CCCD/ Hộ chiếu");
		lb_CCCD_KHMV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_CCCD_KHMV.setBounds(601, 53, 143, 25);
		jp_content_KHMV.add(lb_CCCD_KHMV);
		
		textField_SDT_KHMV = new JTextField();
		textField_SDT_KHMV.setColumns(10);
		textField_SDT_KHMV.setBounds(814, 12, 264, 25);
		jp_content_KHMV.add(textField_SDT_KHMV);
		
		textField_CCCD_KHMV = new JTextField();
		textField_CCCD_KHMV.setColumns(10);
		textField_CCCD_KHMV.setBounds(814, 50, 264, 25);
		jp_content_KHMV.add(textField_CCCD_KHMV);
		
		
		JScrollPane scrollPane_KHMV = new JScrollPane();
		scrollPane_KHMV.setBounds(20, 123, 1335, 259);
		jp_KHMV.add(scrollPane_KHMV);
		
		table_KHMV = new JTable();
//		table_KHMV.setFont(new Font("Tahoma", Font, 16));
		scrollPane_KHMV.setViewportView(table_KHMV);
		table_KHMV.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Lê Tấn Phong","Sinh Viên", "Thông tin chỗ", "551,000 VND", "0", "551,000 VND"}
			},
			new String[] {
				"STT", "Khách hàng", "Đối tượng", "Thông tin chỗ", "Giá", "Giảm đối tượng", "Thành tiền", "Xóa"
			}
		));
	    table_KHMV.setRowHeight(40); // Set chiều cao hàng
		// Đặt renderer và editor cho nút xóa
        table_KHMV.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
        table_KHMV.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox()));
		
        // Tạo JComboBox cho cột "trạng thái"
        JComboBox<String> comboBoxKhuyenMai = new JComboBox<>();
        comboBoxKhuyenMai.setPreferredSize(new Dimension(20, 20));
        comboBoxKhuyenMai.addItem("Sinh Viên");
        comboBoxKhuyenMai.addItem("Trẻ Em");
        comboBoxKhuyenMai.addItem("Cao Tuổi");

        // Lấy cột "Trạng Thái" từ bảng
        TableColumn khuyenMaiColumn = table_KHMV.getColumnModel().getColumn(2); // 2 là chỉ số của cột "khuyenMai"
        // Thiết lập JComboBox làm editor cho cột "Trạng Thái"
        khuyenMaiColumn.setCellEditor(new DefaultCellEditor(comboBoxKhuyenMai));
        // Thiết lập renderer cho cột để hiển thị JComboBox
        khuyenMaiColumn.setCellRenderer(new ComboBoxRenderer(comboBoxKhuyenMai));
        
        
        
		jp_KHSDV = new JPanel();
		jp_KHSDV.setBackground(SystemColor.textHighlightText);
		tabbedPane.addTab("Khách hàng sửa dụng vé", null, jp_KHSDV, null);
		jp_KHSDV.setLayout(null);
		
		JButton bt_ThanhToan_KHSDV = new JButton("Thanh toán");
		bt_ThanhToan_KHSDV.setBounds(1216, 411, 120, 30);
		jp_KHSDV.add(bt_ThanhToan_KHSDV);
		bt_ThanhToan_KHSDV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel jp_content_KHSDV = new JPanel();
		jp_content_KHSDV.setLayout(null);
		jp_content_KHSDV.setBounds(20, 10, 1335, 98);
		jp_KHSDV.add(jp_content_KHSDV);
		
		JLabel lb_Ten_KHSDV = new JLabel("Họ và tên");
		lb_Ten_KHSDV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_Ten_KHSDV.setBounds(75, 15, 96, 25);
		jp_content_KHSDV.add(lb_Ten_KHSDV);
		
		JLabel lb_Email_KHSDV = new JLabel("Email");
		lb_Email_KHSDV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_Email_KHSDV.setBounds(75, 56, 96, 22);
		jp_content_KHSDV.add(lb_Email_KHSDV);
		
		textField_Ten_KHSDV = new JTextField();
		textField_Ten_KHSDV.setColumns(10);
		textField_Ten_KHSDV.setBounds(224, 17, 264, 25);
		jp_content_KHSDV.add(textField_Ten_KHSDV);
		
		textField_Email_KHSDV = new JTextField();
		textField_Email_KHSDV.setColumns(10);
		textField_Email_KHSDV.setBounds(224, 57, 264, 25);
		jp_content_KHSDV.add(textField_Email_KHSDV);
		
		JLabel lb_SDT_KHSDV = new JLabel("Số điện thoại");
		lb_SDT_KHSDV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_SDT_KHSDV.setBounds(601, 12, 143, 25);
		jp_content_KHSDV.add(lb_SDT_KHSDV);
		
		JLabel lb_CCCD_KHSDV = new JLabel("CCCD/ Hộ chiếu");
		lb_CCCD_KHSDV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb_CCCD_KHSDV.setBounds(601, 53, 143, 25);
		jp_content_KHSDV.add(lb_CCCD_KHSDV);
		
		textField_SDT_KHSDV = new JTextField();
		textField_SDT_KHSDV.setColumns(10);
		textField_SDT_KHSDV.setBounds(814, 12, 264, 25);
		jp_content_KHSDV.add(textField_SDT_KHSDV);
		
		textField_CCCD_KHSDV = new JTextField();
		textField_CCCD_KHSDV.setColumns(10);
		textField_CCCD_KHSDV.setBounds(814, 50, 264, 25);
		jp_content_KHSDV.add(textField_CCCD_KHSDV);
		
		JButton bt_XacNhan_KHSDV = new JButton("Xác Nhận");
		bt_XacNhan_KHSDV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_XacNhan_KHSDV.setBounds(1188, 52, 120, 30);
		jp_content_KHSDV.add(bt_XacNhan_KHSDV);
		
		JScrollPane scrollPane_KHSDV = new JScrollPane();
		scrollPane_KHSDV.setBounds(20, 123, 1335, 259);
		jp_KHSDV.add(scrollPane_KHSDV);
		
		table_KHSDV = new JTable();
//		table_KHMV.setFont(new Font("Tahoma", Font, 16));
		scrollPane_KHSDV.setViewportView(table_KHSDV);
		table_KHSDV.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Lê Tấn Phong","Sinh Viên", "Thông tin chỗ", "551,000 VND", "0", "551,000 VND"}
			},
			new String[] {
				"STT", "Khách hàng", "Đối tượng", "Thông tin chỗ", "Giá", "Giảm đối tượng", "Thành tiền", "Xóa"
			}
		));
	    table_KHSDV.setRowHeight(40); // Set chiều cao hàng
		// Đặt renderer và editor cho nút xóa
        table_KHSDV.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
        table_KHSDV.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox()));
        table_KHSDV.getColumnModel().getColumn(7).addPropertyChangeListener(new PropertyChangeListener() {
        	@Override
        	public void propertyChange(PropertyChangeEvent evt) {
        		// Kiểm tra từng loại thay đổi thuộc tính
        		if ("width".equals(evt.getPropertyName())) {
        			System.out.println("Độ rộng của cột đã thay đổi: " + evt.getNewValue());
        		} else if ("preferredWidth".equals(evt.getPropertyName())) {
        			System.out.println("Độ rộng mong muốn của cột đã thay đổi: " + evt.getNewValue());
        		} else if ("cellEditor".equals(evt.getPropertyName())) {
        			System.out.println("CellEditor của cột đã thay đổi");
        		} else if ("cellRenderer".equals(evt.getPropertyName())) {
        			System.out.println("CellRenderer của cột đã thay đổi");
        		}
        	}
        });

        
        khuyenMaiColumn = table_KHSDV.getColumnModel().getColumn(2);
        khuyenMaiColumn.setCellEditor(new DefaultCellEditor(comboBoxKhuyenMai));
        // Thiết lập renderer cho cột để hiển thị JComboBox
        khuyenMaiColumn.setCellRenderer(new ComboBoxRenderer(comboBoxKhuyenMai));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}