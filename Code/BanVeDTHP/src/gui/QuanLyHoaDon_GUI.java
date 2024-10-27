package gui;

import java.awt.Checkbox;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooserBeanInfo;

import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import entity.HoaDon;
import entity.KhachHang;

import javax.swing.JCheckBox;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.BorderLayout;

public class QuanLyHoaDon_GUI extends JPanel implements ActionListener {
	private JTextField txtMaHD;
	private JTextField txtNhanVien;
	private JTextField txtKH;
	private JTable table;
	private JDateChooser dateChooserTu;
	private JDateChooser dateChooserDen;
	private DefaultTableModel model;
	private JCheckBox chckbxDaHoanTien;
	private JCheckBox chckbxDaHoanVe;
	private JCheckBox chckbxTatCa;
	private JButton btnXemChiTiet;
	private JButton btnXuatHoaDon;
	private HoaDon_DAO dsHD;
	private TableRowSorter<TableModel> sorter;
	private JTextField txtTu;
	private JTextField txtDen;

	@SuppressWarnings("serial")
	public QuanLyHoaDon_GUI() {
		setBackground(Color.white);
		setBounds(0, 170, 1460, 610);
		setLayout(null);

		JPanel panelTimKiem_Tong = new JPanel();
		panelTimKiem_Tong.setBounds(10, 10, 286, 229);
		add(panelTimKiem_Tong);
		panelTimKiem_Tong.setLayout(null);

		JPanel panel_TimKiem = new JPanel();
		panel_TimKiem.setBackground(new Color(51, 102, 153));
		panel_TimKiem.setBounds(0, 0, 286, 34);
		panelTimKiem_Tong.add(panel_TimKiem);
		panel_TimKiem.setLayout(null);

		JLabel lblTimKiem = new JLabel("Tìm kiếm");
		lblTimKiem.setForeground(new Color(255, 255, 255));
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimKiem.setBounds(10, 0, 95, 34);
		panel_TimKiem.add(lblTimKiem);

		JLabel lblMaHoaDon = new JLabel("Mã hóa đơn:");
		lblMaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaHoaDon.setBounds(10, 38, 104, 34);
		panelTimKiem_Tong.add(lblMaHoaDon);

		JLabel lblNhanVien = new JLabel("Mã nhân viên:");
		lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNhanVien.setBounds(10, 104, 136, 27);
		panelTimKiem_Tong.add(lblNhanVien);

		JLabel lblKhachHang = new JLabel("Tên khách hàng:");
		lblKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhachHang.setBounds(10, 166, 136, 27);
		panelTimKiem_Tong.add(lblKhachHang);

		txtMaHD = new JTextField();
		txtMaHD.setBounds(10, 70, 266, 27);
		panelTimKiem_Tong.add(txtMaHD);
		txtMaHD.setColumns(10);

		txtNhanVien = new JTextField();
		txtNhanVien.setColumns(10);
		txtNhanVien.setBounds(10, 129, 266, 27);
		panelTimKiem_Tong.add(txtNhanVien);

		txtKH = new JTextField();
		txtKH.setBounds(10, 190, 266, 27);
		panelTimKiem_Tong.add(txtKH);
		txtKH.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 249, 286, 121);
		add(panel_2);

		JPanel panelThoiGian = new JPanel();
		panelThoiGian.setLayout(null);
		panelThoiGian.setBackground(new Color(51, 102, 153));
		panelThoiGian.setBounds(0, 0, 286, 34);
		panel_2.add(panelThoiGian);

		JLabel lblThiGian = new JLabel("Thời gian");
		lblThiGian.setForeground(Color.WHITE);
		lblThiGian.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThiGian.setBounds(10, 0, 95, 34);
		panelThoiGian.add(lblThiGian);

		dateChooserTu = new JDateChooser();
		dateChooserTu.getCalendarButton().setBounds(245, 0, 21, 27);
		dateChooserTu.setDateFormatString("dd/MM/yyyy");
		dateChooserTu.setBounds(10, 44, 266, 27);
		panel_2.add(dateChooserTu);
		dateChooserTu.setLayout(null);
		
		txtTu = new JTextField();
		txtTu.setBounds(0, 0, 245, 27);
		dateChooserTu.add(txtTu);
		txtTu.setColumns(10);
		
		// Thêm sự kiện PropertyChangeListener cho dateChooserTu
        dateChooserTu.getDateEditor().addPropertyChangeListener("date", evt -> {
            Date selectedDate = dateChooserTu.getDate();
            if (selectedDate != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                txtTu.setText(dateFormat.format(selectedDate)); // Gán ngày vào JTextField
            } else {
                txtTu.setText(""); // Nếu không có ngày nào được chọn, làm rỗng JTextField
            }
        });

		dateChooserDen = new JDateChooser();
		dateChooserDen.getCalendarButton().setBounds(245, 0, 21, 27);
		dateChooserDen.setDateFormatString("dd/MM/yyyy");
		dateChooserDen.setBounds(10, 81, 266, 27);
		panel_2.add(dateChooserDen);
		dateChooserDen.setLayout(null);
		
		txtDen = new JTextField();
		txtDen.setBounds(0, 0, 245, 27);
		dateChooserDen.add(txtDen);
		txtDen.setColumns(10);
		
		// Thêm sự kiện PropertyChangeListener cho dateChooserDen
        dateChooserDen.getDateEditor().addPropertyChangeListener("date", evt -> {
            Date selectedDate = dateChooserDen.getDate();
            if (selectedDate != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                txtDen.setText(dateFormat.format(selectedDate)); // Gán ngày vào JTextField
            } else {
                txtDen.setText(""); // Nếu không có ngày nào được chọn, làm rỗng JTextField
            }
        });

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(10, 380, 286, 137);
		add(panel_2_1);

		JPanel panelTrangThai = new JPanel();
		panelTrangThai.setLayout(null);
		panelTrangThai.setBackground(new Color(51, 102, 153));
		panelTrangThai.setBounds(0, 0, 286, 34);
		panel_2_1.add(panelTrangThai);

		JLabel lblTrngThi = new JLabel("Trạng thái");
		lblTrngThi.setBounds(10, 0, 95, 34);
		panelTrangThai.add(lblTrngThi);
		lblTrngThi.setForeground(Color.WHITE);
		lblTrngThi.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblTatCa = new JLabel("Tất cả");
		lblTatCa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTatCa.setBounds(79, 44, 78, 19);
		panel_2_1.add(lblTatCa);

		JLabel lblDaHoanVe = new JLabel("Đã hoàn vé");
		lblDaHoanVe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDaHoanVe.setBounds(79, 62, 96, 34);
		panel_2_1.add(lblDaHoanVe);

		JLabel lblDaHoanTien = new JLabel("Đã hoàn tiền");
		lblDaHoanTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDaHoanTien.setBounds(79, 93, 118, 34);
		panel_2_1.add(lblDaHoanTien);

		chckbxTatCa = new JCheckBox("");
		chckbxTatCa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxTatCa.setBounds(23, 34, 21, 34);
		panel_2_1.add(chckbxTatCa);
		chckbxTatCa.setSelected(true);

		chckbxDaHoanVe = new JCheckBox("");
		chckbxDaHoanVe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxDaHoanVe.setBounds(23, 62, 40, 28);
		panel_2_1.add(chckbxDaHoanVe);

		chckbxDaHoanTien = new JCheckBox("");
		chckbxDaHoanTien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxDaHoanTien.setBounds(23, 93, 27, 28);
		panel_2_1.add(chckbxDaHoanTien);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(320, 10, 1119, 547);
		add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1119, 547);
		panel_1.add(scrollPane);

		table = new JTable();
		model = new DefaultTableModel(new Object[] { "STT", "Mã hóa đơn", "Ngày lập hóa đơn", "Nhân viên lập",
				"Khách hàng", "Đã hoàn vé", "Đã hoàn tiền" }, 0) {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// Xác định kiểu dữ liệu cho từng cột
				switch (columnIndex) {
				case 5:
				case 6:
					return Boolean.class; // Các cột 5 và 6 là checkbox
				default:
					return String.class;
				}
			}

			@Override
			public boolean isCellEditable(int row, int column) {
				return column != 5 && column != 6; // Không cho chỉnh sửa các cột checkbox
			}
		};
		// Tạo một TableRowSorter để sử dụng cho việc lọc dữ liệu
		sorter = new TableRowSorter<>(model);
		table.setRowSorter(sorter);
		table.setModel(model);
		scrollPane.setViewportView(table);

		btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXemChiTiet.setBounds(10, 527, 125, 30);
		add(btnXemChiTiet);

		btnXuatHoaDon = new JButton("Xuất hóa đơn");
		btnXuatHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXuatHoaDon.setBounds(163, 527, 133, 30);
		add(btnXuatHoaDon);

		btnXemChiTiet.addActionListener(this);
		btnXuatHoaDon.addActionListener(this);

		// Lắng nghe sự kiện nhập liệu cho các ô tìm kiếm
		txtMaHD.getDocument().addDocumentListener(new FilterListener());
		txtNhanVien.getDocument().addDocumentListener(new FilterListener());
		txtKH.getDocument().addDocumentListener(new FilterListener());
		txtTu.getDocument().addDocumentListener(new FilterListener());
		txtDen.getDocument().addDocumentListener(new FilterListener());
		chckbxDaHoanVe.addActionListener(this);
		chckbxDaHoanTien.addActionListener(this);
		chckbxTatCa.addActionListener(this);

		datatoTable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXemChiTiet)) {

		}
		if (o.equals(btnXuatHoaDon)) {
		}
		if (o.equals(chckbxTatCa)) {
			chckbxDaHoanTien.setSelected(false);
			chckbxDaHoanVe.setSelected(false);
			filterRows();
		}
		if (o.equals(chckbxDaHoanVe)) {
			chckbxTatCa.setSelected(false);
			filterRows();
		}
		if (o.equals(chckbxDaHoanTien)) {
			chckbxTatCa.setSelected(false);
			filterRows();
		}
	}

	// Hàm tải dữ liệu vào bảng
	public void datatoTable() {
		dsHD = new HoaDon_DAO();
		KhachHang_DAO dsKH = new KhachHang_DAO();
		ArrayList<HoaDon> list = dsHD.docTuBang();
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Xóa tất cả hàng trong bảng
		int count = 1;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm - dd/MM/yyyy");
		for (HoaDon hd : list) {
			model.addRow(new Object[] { count++, hd.getMaHoaDon(), hd.getNgayLapHoaDon().format(formatter),
					hd.getNhanVien().getMaNV(), dsKH.getKhachHangTheoMaKH(hd.getKhachHang().getMaKH()).getTenKH(),
					hd.getDaHoanVe(), hd.getDaHoanTien() });
		}
	}

	// Lớp FilterListener để lắng nghe các thay đổi trong các ô tìm kiếm
	private class FilterListener implements DocumentListener {
		@Override
		public void insertUpdate(DocumentEvent e) {
			filterRows();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			filterRows();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			filterRows();
		}
	}
	
	// Hàm để thực hiện lọc
			private void filterRows() {
				String textMaHD = txtMaHD.getText().trim();
				String textNhanVien = txtNhanVien.getText().trim();
				String textKH = txtKH.getText().trim();
				String textTu = txtTu.getText().trim();
				String textDen = txtDen.getText().trim();

				ArrayList<RowFilter<Object, Object>> filters = new ArrayList<>();

				// Thêm bộ lọc nếu các ô không trống
				if (!textMaHD.isEmpty()) {
					filters.add(RowFilter.regexFilter("(?i)" + textMaHD, 1)); // Lọc theo cột "Mã HD"
				}
				if (!textNhanVien.isEmpty()) {
					filters.add(RowFilter.regexFilter("(?i)" + textNhanVien, 3)); // Lọc theo cột "Mã NV"
				}
				if (!textKH.isEmpty()) {
					filters.add(RowFilter.regexFilter("(?i)" + textKH, 4)); // Lọc theo cột "Tên KH"
				}
				// Lọc theo ngày từ
			    if (!textTu.isEmpty()) {
			        Date dateTu = parseDate(textTu);
			        if (dateTu != null) {
			            filters.add(new RowFilter<Object, Object>() {
			                @Override
			                public boolean include(Entry<? extends Object, ? extends Object> entry) {
			                    Date entryDate = parseDate(entry.getStringValue(2).substring(8)); // Giả sử cột 2 là cột ngày
			                    return entryDate != null && !entryDate.before(dateTu);
			                }
			            });
			        }
			    }

			    // Lọc theo ngày đến
			    if (!textDen.isEmpty()) {
			        Date dateDen = parseDate(textDen);
			        if (dateDen != null) {
			            filters.add(new RowFilter<Object, Object>() {
			                @Override
			                public boolean include(Entry<? extends Object, ? extends Object> entry) {
			                    Date entryDate = parseDate(entry.getStringValue(2).substring(8)); // Giả sử cột 2 là cột ngày
			                    return entryDate != null && !entryDate.after(dateDen);
			                }
			            });
			        }
			    }
			    
			 // Lọc theo checkbox "Đã hoàn vé" và "Đã hoàn tiền"
			    if (chckbxDaHoanVe.isSelected() && chckbxDaHoanTien.isSelected()) {
			        // Khi cả hai checkbox đều được chọn
			        filters.add(new RowFilter<Object, Object>() {
			            @Override
			            public boolean include(Entry<? extends Object, ? extends Object> entry) {
			                boolean daHoanVe = Boolean.parseBoolean(entry.getStringValue(5)); // Cột 5 là checkbox "Đã hoàn vé"
			                boolean daHoanTien = Boolean.parseBoolean(entry.getStringValue(6)); // Cột 6 là checkbox "Đã hoàn tiền"
			                return daHoanVe && daHoanTien; // Hiển thị khi cả hai đều true
			            }
			        });
			    } else if (chckbxDaHoanVe.isSelected()) {
			        // Khi chỉ checkbox "Đã hoàn vé" được chọn
			        filters.add(new RowFilter<Object, Object>() {
			            @Override
			            public boolean include(Entry<? extends Object, ? extends Object> entry) {
			                return Boolean.parseBoolean(entry.getStringValue(5)); // Cột 5 là checkbox "Đã hoàn vé"
			            }
			        });
			    } else if (chckbxDaHoanTien.isSelected()) {
			        // Khi chỉ checkbox "Đã hoàn tiền" được chọn
			        filters.add(new RowFilter<Object, Object>() {
			            @Override
			            public boolean include(Entry<? extends Object, ? extends Object> entry) {
			                return Boolean.parseBoolean(entry.getStringValue(6)); // Cột 6 là checkbox "Đã hoàn tiền"
			            }
			        });
			    }
			    
			 // Nếu không có checkbox nào được chọn
			    if (!chckbxDaHoanVe.isSelected() && !chckbxDaHoanTien.isSelected() && !chckbxTatCa.isSelected()) {
			        filters.add(new RowFilter<Object, Object>() {
			            @Override
			            public boolean include(Entry<? extends Object, ? extends Object> entry) {
			                boolean daHoanVe = Boolean.parseBoolean(entry.getStringValue(5)); // Cột 5 là checkbox "Đã hoàn vé"
			                boolean daHoanTien = Boolean.parseBoolean(entry.getStringValue(6)); // Cột 6 là checkbox "Đã hoàn tiền"
			                return !daHoanVe && !daHoanTien; // Hiển thị khi cả hai đều false
			            }
			        });
			    }

			    // Nếu checkbox "Tất cả" được chọn
			    if (chckbxTatCa.isSelected()) {
			    	sorter.setRowFilter(null);
			    }

				if (filters.isEmpty()) {
					sorter.setRowFilter(null); // Loại bỏ bộ lọc nếu không có điều kiện nào
				} else {
					sorter.setRowFilter(RowFilter.andFilter(filters)); // Kết hợp các bộ lọc
				}
			}
	
	private Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // Chuyển đổi chuỗi thành đối tượng Date
            Date date = dateFormat.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
