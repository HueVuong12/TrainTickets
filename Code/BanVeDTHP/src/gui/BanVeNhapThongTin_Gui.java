package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
import components.TextAreaRenderer;
import dao.Ga_DAO;
import entity.KhachHang;
import entity.Ve;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import java.awt.BorderLayout;

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
	private JPanel jp_KHSDV;
	private JTextField textField_Ten_KHSDV;
	private JTextField textField_Email_KHSDV;
	private JTextField textField_SDT_KHSDV;
	private JTextField textField_CCCD_KHSDV;
	public JTable table;
	private JPanel jp_Table;
	public Map<Integer, KhachHang> map = new HashMap<>();
	
	private Ga_DAO ga_DAO = new Ga_DAO();
	private JButton bt_Chuyen;
	
	public BanVeNhapThongTin_Gui(BanVe_GUI banVe_GUI,TrangChu_GUI trangChu) {
		setBackground(SystemColor.window);
		setForeground(new Color(255, 255, 255));
		setBounds(0, 170, 1460, 570);
		setLayout(null);
		
		JPanel jp_quayLai = new JPanel();
	    jp_quayLai.setBackground(SystemColor.text);
		jp_quayLai.setBounds(10, 4, 94, 47);
		add(jp_quayLai);
		
		//Icon Quay lại
		ImageIcon goBackIcon = new ImageIcon(getClass().getResource("/img/9054423_bx_arrow_back_icon.png"));
		Image scaledGoBack = goBackIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		jp_quayLai.setLayout(new BorderLayout(0, 0));
		goBackIconLabel = new JLabel(new ImageIcon(scaledGoBack));
		jp_quayLai.add(goBackIconLabel, BorderLayout.CENTER);
		goBackIconLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				goBackIconLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				goBackIconLabel.setCursor(Cursor.getDefaultCursor());
			}
			
			@Override
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
		jp_quayLai.add(lbl_quayLai, BorderLayout.EAST);
		
		lbl_quayLai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				goBackIconLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				goBackIconLabel.setCursor(Cursor.getDefaultCursor());
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				trangChu.content.removeAll();
				trangChu.content.add(banVe_GUI);
				trangChu.content.revalidate();
				trangChu.content.repaint();
			}
		});
		
		// Khởi tạo tabbedPane
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(46, 61, 1373, 151);
		add(tabbedPane);
		tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 15));
				
		jp_KHMV = new JPanel();
		jp_KHMV.setBackground(SystemColor.textHighlightText);
		tabbedPane.addTab("Khách hàng mua vé", null, jp_KHMV, null);
		jp_KHMV.setLayout(null);
		
		JPanel jp_content_KHMV = new JPanel();
		jp_content_KHMV.setLayout(null);
		jp_content_KHMV.setBounds(10, 10, 1345, 98);
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
		
		bt_Chuyen = new JButton("Chuyển");
		bt_Chuyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
				textField_Ten_KHSDV.setText(textField_Ten_KHMV.getText());
				textField_Email_KHSDV.setText(textField_Email_KHMV.getText());
				textField_SDT_KHSDV.setText(textField_SDT_KHMV.getText());
				textField_CCCD_KHSDV.setText(textField_CCCD_KHMV.getText());
			}
		});
		bt_Chuyen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_Chuyen.setBounds(1160, 24, 120, 40);
		jp_content_KHMV.add(bt_Chuyen);
		
		// Tab khách hàng sử dụng vé
		jp_KHSDV = new JPanel();
		jp_KHSDV.setBackground(SystemColor.textHighlightText);
		tabbedPane.addTab("Khách hàng sửa dụng vé", null, jp_KHSDV, null);
		jp_KHSDV.setLayout(null);
		
		JPanel jp_content_KHSDV = new JPanel();
		jp_content_KHSDV.setLayout(null);
		jp_content_KHSDV.setBounds(10, 10, 1345, 98);
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
		
		JButton bt_XacNhan_KHSDV = new JButton("Nhập");
		bt_XacNhan_KHSDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    KhachHang khachHang = new KhachHang("KH0000", textField_Ten_KHSDV.getText(), textField_Email_KHSDV.getText(), textField_SDT_KHSDV.getText(), textField_CCCD_KHSDV.getText());
                    map.put(selectedRow, khachHang);
                    model.setValueAt(textField_Ten_KHSDV.getText(), selectedRow, 1);
                    textField_Ten_KHSDV.setText("");
					textField_SDT_KHSDV.setText("");
					textField_Email_KHSDV.setText("");
					textField_CCCD_KHSDV.setText("");
                }
			}
		});
		bt_XacNhan_KHSDV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_XacNhan_KHSDV.setBounds(1160, 24, 120, 40);
		jp_content_KHSDV.add(bt_XacNhan_KHSDV);
			
		//JP table
		jp_Table = new JPanel();
		jp_Table.setBounds(46, 222, 1373, 338);
		add(jp_Table);
		jp_Table.setLayout(null);
		
		JButton bt_ThanhToan_KHSDV = new JButton("Thanh toán");
		bt_ThanhToan_KHSDV.setBounds(1245, 303, 118, 25);
		jp_Table.add(bt_ThanhToan_KHSDV);
		bt_ThanhToan_KHSDV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane_KHSDV = new JScrollPane();
		scrollPane_KHSDV.setBounds(10, 5, 1353, 289);
		jp_Table.add(scrollPane_KHSDV);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if (row != -1) {
					KhachHang khachHang = map.get(row);
					if (khachHang != null) {
						textField_Ten_KHSDV.setText(khachHang.getTenKH());
						textField_SDT_KHSDV.setText(khachHang.getSdt());
						textField_Email_KHSDV.setText(khachHang.getEmail());
						textField_CCCD_KHSDV.setText(khachHang.getCccd());
					}
				}
			}
		});
		scrollPane_KHSDV.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Khách hàng", "Đối tượng", "Thông tin chỗ", "Giá", "Giảm đối tượng", "Thành tiền", "Xóa"
			}
		));
		
		// Điều chỉnh bảng
	    table.setRowHeight(50);
	    table.getColumnModel().getColumn(3).setPreferredWidth(150);
	    table.getColumnModel().getColumn(7).setPreferredWidth(30);
	    
		// Đặt renderer và editor cho nút xóa
        table.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox(), banVe_GUI, BanVeNhapThongTin_Gui.this));
//        table.getColumnModel().getColumn(7).addPropertyChangeListener(new PropertyChangeListener() {
//        	@Override
//        	public void propertyChange(PropertyChangeEvent evt) {
//        		// Kiểm tra từng loại thay đổi thuộc tính
//        		if ("width".equals(evt.getPropertyName())) {
//        			System.out.println("Độ rộng của cột đã thay đổi: " + evt.getNewValue());
//        		} else if ("preferredWidth".equals(evt.getPropertyName())) {
//        			System.out.println("Độ rộng mong muốn của cột đã thay đổi: " + evt.getNewValue());
//        		} else if ("cellEditor".equals(evt.getPropertyName())) {
//        			System.out.println("CellEditor của cột đã thay đổi");
//        		} else if ("cellRenderer".equals(evt.getPropertyName())) {
//        			System.out.println("CellRenderer của cột đã thay đổi");
//        		}
//        	}
//        });

        // Tạo JComboBox cho cột "trạng thái"
        JComboBox<String> comboBoxKhuyenMai = new JComboBox<>();
        comboBoxKhuyenMai.setPreferredSize(new Dimension(20, 20));
        comboBoxKhuyenMai.addItem("Người lớn");
        comboBoxKhuyenMai.addItem("Trẻ em dưới 6 tuổi");
        comboBoxKhuyenMai.addItem("Trẻ em từ 6 đến 10 tuổi");
        comboBoxKhuyenMai.addItem("Sinh viên");
        comboBoxKhuyenMai.addItem("Người lớn tuổi");
        
        // Thêm ActionListener cho comboBox để cập nhật giá trị trong cột 5
        comboBoxKhuyenMai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedItemIndex = comboBoxKhuyenMai.getSelectedIndex();
                    float baseValue = (float) model.getValueAt(selectedRow, 4); // Lấy giá trị cột 4

                    double newValue;
                    switch (selectedItemIndex) {
                        case 0: // Người lớn
                            newValue = 0;
                            break;
                        case 1: // Trẻ em dưới 6 tuổi
                            newValue = baseValue * 1;
                            break;
                        case 2: // Trẻ em từ 6 đến 10 tuổi
                            newValue = baseValue * 0.25;
                            break;
                        case 3: // Sinh viên
                            newValue = baseValue * 0.1;
                            break;
                        case 4: // Người lớn tuổi
                            newValue = baseValue * 0.15;
                            break;
                        default:
                            newValue = baseValue; // Trường hợp không hợp lệ
                            break;
                    }

                    model.setValueAt(newValue, selectedRow, 5); // Cập nhật cột 5 với giá trị mới
                    model.setValueAt((float) model.getValueAt(selectedRow, 4) - newValue, selectedRow, 6); // Cập nhật cột 6 với giá trị mới
                }
            }
        });
        
        TableColumn khuyenMaiColumn = table.getColumnModel().getColumn(2);
        khuyenMaiColumn.setCellEditor(new DefaultCellEditor(comboBoxKhuyenMai));
        // Thiết lập renderer cho cột để hiển thị JComboBox
        khuyenMaiColumn.setCellRenderer(new ComboBoxRenderer(comboBoxKhuyenMai));        
        table.getColumnModel().getColumn(3).setCellRenderer(new TextAreaRenderer());
		
        loadThongTin(banVe_GUI.dsVeDatTam);
	}
	
	public void loadThongTin(ArrayList<Ve> dsVeDatTam) {
		
		DefaultTableModel defaultModel = ((DefaultTableModel) table.getModel());
		defaultModel.setRowCount(0);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		int count = 1;
		for (Ve ve: dsVeDatTam) {
			// Thông tin vé + giá gốc
			String thongTinVe = ve.getChuyenTau().getMaTau() + ": Từ " + ga_DAO.getGaTheoMaGa(ve.getGaDi().getMaGa()).getTenGa() + " đến "
					+ ga_DAO.getGaTheoMaGa(ve.getGaDen().getMaGa()).getTenGa() + "\nNgày: "
					+ ve.getNgayDi().format(formatter) + "   Lúc: " + ve.getGioDi().toString();
			if (ve.getHang().equalsIgnoreCase("VIP")) {
				thongTinVe = thongTinVe + "\nHạng VIP Toa "
						+ ve.getToa().getMaToa().substring(ve.getToa().getMaToa().length() - 2) + " Ghế số "
						+ ve.getSoGhe().getSoGhe();
			} else if (ve.getHang().equalsIgnoreCase("Giường nằm")) {
				thongTinVe = thongTinVe + "\nGiường nằm Toa "
						+ ve.getToa().getMaToa().substring(ve.getToa().getMaToa().length() - 2) + " Ghế số "
						+ ve.getSoGhe().getSoGhe();
			} else {
				thongTinVe = thongTinVe + "\nGhế mềm Toa "
						+ ve.getToa().getMaToa().substring(ve.getToa().getMaToa().length() - 2) + " Ghế số "
						+ ve.getSoGhe().getSoGhe();
			}
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[] {count++, null, "Người lớn", thongTinVe, ve.tinhGiaVeGoc(), 0, ve.tinhGiaVeGoc()});
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}