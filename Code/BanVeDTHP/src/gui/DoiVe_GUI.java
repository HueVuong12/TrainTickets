package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import components.RoundedButton;
import entity.ChuyenTau;
import entity.Ga;
import entity.Ve;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class DoiVe_GUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel jp_title;
	private JLabel downIconLabel_2;
	private JLabel lbl_Chieu_1;
	private JLabel lbl_NgayDi_1;
	private JLabel lbl_Ga_1;
	private JLabel lblMaToa;
	private JTextField txt_GaDi;
	private JTextField txt_GaDen;
	private JDateChooser chooserNgayDi;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel jp_ThongTinChuyenTau;
	private JPanel jp_TinhTrangToa;
	private JPanel jp_TinhTrangGhe;
	ArrayList<Ve> dsVeDatTam = new ArrayList<Ve>();
	/**
	 * Create the panel.
	 */
	public DoiVe_GUI(QuanLyVe_Gui qlv, TrangChu_GUI trangChu) {
		setBackground(SystemColor.window);
		setForeground(new Color(255, 255, 255));
		setBounds(0, 170, 1460, 570);
		setLayout(null);

		// Icon xổ xuống
		ImageIcon downIcon = new ImageIcon(getClass().getResource("/img/Polygon_20.png"));
		downIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		System.out.println("Them ve thanh cong");

		jp_title = new JPanel();
		jp_title.setLayout(null);
		jp_title.setBackground(new Color(51, 102, 153));
		jp_title.setBounds(264, 10, 686, 36);
		add(jp_title);

		downIconLabel_2 = new JLabel((Icon) null);
		downIconLabel_2.setBounds(0, 0, 30, 35);
		jp_title.add(downIconLabel_2);

		lbl_Chieu_1 = new JLabel("Chiều đi:");
		lbl_Chieu_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Chieu_1.setForeground(Color.WHITE);
		lbl_Chieu_1.setBounds(40, 0, 152, 35);
		jp_title.add(lbl_Chieu_1);

		lbl_NgayDi_1 = new JLabel();
		lbl_NgayDi_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_NgayDi_1.setForeground(Color.WHITE);
		lbl_NgayDi_1.setBounds(192, 0, 152, 35);
		jp_title.add(lbl_NgayDi_1);

		lbl_Ga_1 = new JLabel();
		lbl_Ga_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Ga_1.setForeground(Color.WHITE);
		lbl_Ga_1.setBounds(342, 0, 334, 35);
		jp_title.add(lbl_Ga_1);

		jp_ThongTinChuyenTau = new JPanel();
		jp_ThongTinChuyenTau.setBounds(264, 56, 1186, 118);
		add(jp_ThongTinChuyenTau);
		jp_ThongTinChuyenTau.setLayout(null);

		jp_TinhTrangToa = new JPanel();
		jp_TinhTrangToa.setBounds(264, 184, 1186, 76);
		add(jp_TinhTrangToa);
		jp_TinhTrangToa.setLayout(null);

		jp_TinhTrangGhe = new JPanel();
		jp_TinhTrangGhe.setBounds(264, 300, 1186, 260);
		add(jp_TinhTrangGhe);
		jp_TinhTrangGhe.setLayout(null);

		JPanel jp_timKiem = new JPanel();
		jp_timKiem.setLayout(null);
		jp_timKiem.setBackground(Color.WHITE);
		jp_timKiem.setBounds(10, 10, 244, 242);
		add(jp_timKiem);

		JPanel jp_Content_ThongTin = new JPanel();
		jp_Content_ThongTin.setLayout(null);
		jp_Content_ThongTin.setBackground(SystemColor.controlHighlight);
		jp_Content_ThongTin.setBounds(0, 32, 244, 211);
		jp_timKiem.add(jp_Content_ThongTin);

//		JButton btnTim = new JButton("Tìm");
		RoundedButton btnTim = new RoundedButton("Tìm", 15);
		btnTim.setText("Tìm kiếm");
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTim.setBackground(new Color(51, 102, 153));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTim.setBounds(73, 175, 85, 27);
		jp_Content_ThongTin.add(btnTim);
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
//		btnTim.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				jp_TinhTrangToa.removeAll();
//				jp_TinhTrangToa.revalidate();
//				jp_TinhTrangToa.repaint();
//				
//				jp_TinhTrangGhe.removeAll();
//				jp_TinhTrangGhe.revalidate();
//				jp_TinhTrangGhe.repaint();
//
//				lblMaToa.setText("");
//				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//				lbl_NgayDi_1.setText(sdf.format(chooserNgayDi.getDate()));
//				lbl_Ga_1.setText(txt_GaDi.getText() + " - " + txt_GaDen.getText());
//				jp_ThongTinChuyenTau.removeAll();
//				String gaDi = txt_GaDi.getText();
//				String gaDen = txt_GaDen.getText();
//				boolean isKhuHoi = rdbtn_KhuHoi.isSelected();
//				LocalDate ngayDi = chooserNgayDi.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//				if (isKhuHoi) {
//					chooserNgayVe.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//				}
//
//				ArrayList<ChuyenTau> dsTauHienThi = new ArrayList<ChuyenTau>();
//				for (ChuyenTau chuyenTau : dsChuyenTau) {
//					if ((ga_dao.getGaTheoMaGa(chuyenTau.getGaDi().getMaGa()).getDiaChi().equals(gaDi))
//							&& (chuyenTau.getNgayDi().equals(ngayDi))) {
//						for (Ga gaDung : chuyenTau.getTramDung()) {
//							if (gaDen.equals(gaDung.getDiaChi()))
//								dsTauHienThi.add(chuyenTau);
//						}
//						if (gaDen.equals(ga_dao.getGaTheoMaGa(chuyenTau.getGaDen().getMaGa()).getDiaChi()))
//							dsTauHienThi.add(chuyenTau);
//					}
//				}
//				int x = 0, y = 0;
//				for (ChuyenTau chuyenTau : dsTauHienThi) {
//					// Tạo ChuyenTau_JPanel ban đầu với tham số false
//					ChuyenTau_JPanel pChuyenTau = new ChuyenTau_JPanel(chuyenTau);
//					pChuyenTau.setBounds(x, y, 123, 122);
//					// su kien
//					suKienTrenChuyen(pChuyenTau, chuyenTau);
//					jp_ThongTinChuyenTau.add(pChuyenTau);
//					x += 127; // Điều chỉnh vị trí cho panel tiếp theo
//				}
//
//				jp_ThongTinChuyenTau.revalidate();
//				jp_ThongTinChuyenTau.repaint();
//			}
//		});
		

		txt_GaDi = new JTextField();
		txt_GaDi.setText("Ga đi");
		txt_GaDi.setHorizontalAlignment(SwingConstants.LEFT);
		txt_GaDi.setForeground(SystemColor.textInactiveText);
		txt_GaDi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_GaDi.setColumns(10);
		txt_GaDi.setBounds(21, 26, 202, 27);
		jp_Content_ThongTin.add(txt_GaDi);
		chonGa(txt_GaDi);
		focusTxtField(txt_GaDi, "Ga đi");

		txt_GaDen = new JTextField();
		txt_GaDen.setText("Ga đến");
		txt_GaDen.setHorizontalAlignment(SwingConstants.LEFT);
		txt_GaDen.setForeground(SystemColor.textInactiveText);
		txt_GaDen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_GaDen.setColumns(10);
		txt_GaDen.setBounds(21, 78, 202, 27);
		jp_Content_ThongTin.add(txt_GaDen);
		chonGa(txt_GaDen);
		focusTxtField(txt_GaDen, "Ga đến");

		chooserNgayDi = new JDateChooser();
		chooserNgayDi.setBounds(21, 138, 202, 27);
		chooserNgayDi.setDateFormatString("dd/MM/yyyy");
		jp_Content_ThongTin.add(chooserNgayDi);
		((JTextField) chooserNgayDi.getDateEditor().getUiComponent()).setEditable(false);

		// Thêm listener để kiểm tra ngày chọn đi
		chooserNgayDi.getDateEditor().addPropertyChangeListener("date", new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				// Lấy ngày hôm nay với thời gian thiết lập là 00:00:00
				Calendar todayCal = Calendar.getInstance();
				todayCal.set(Calendar.HOUR_OF_DAY, 0);
				todayCal.set(Calendar.MINUTE, 0);
				todayCal.set(Calendar.SECOND, 0);
				todayCal.set(Calendar.MILLISECOND, 0);
				Date today = todayCal.getTime();

				if (chooserNgayDi.getDate() != null && chooserNgayDi.getDate().before(today)) {
					JOptionPane.showMessageDialog(null,
							"Ngày không hợp lệ! Vui lòng chọn ngày không trước ngày hôm nay.", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
					chooserNgayDi.setDate(null); // Xóa ngày đã chọn
				}
			}
		});

		JLabel lbl_GaDi = new JLabel("Ga Đi");
		lbl_GaDi.setBounds(24, 10, 45, 13);
		jp_Content_ThongTin.add(lbl_GaDi);

		JLabel lbl_GaDen = new JLabel("Ga Đến");
		lbl_GaDen.setBounds(21, 63, 45, 13);
		jp_Content_ThongTin.add(lbl_GaDen);

		JLabel lbl_ChonNgayDi = new JLabel("Ngày đi");
		lbl_ChonNgayDi.setBounds(21, 115, 45, 13);
		jp_Content_ThongTin.add(lbl_ChonNgayDi);

		JPanel jp_Header_ThongTin = new JPanel();
		jp_Header_ThongTin.setLayout(null);
		jp_Header_ThongTin.setBackground(new Color(51, 102, 153));
		jp_Header_ThongTin.setBounds(0, 0, 244, 32);
		jp_timKiem.add(jp_Header_ThongTin);

		JLabel downIconLabel = new JLabel((Icon) null);
		downIconLabel.setBounds(0, 0, 30, 35);
		jp_Header_ThongTin.add(downIconLabel);

		JLabel lbl_tieuDeTK = new JLabel("Thông tin chuyến tàu");
		lbl_tieuDeTK.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tieuDeTK.setForeground(Color.WHITE);
		lbl_tieuDeTK.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_tieuDeTK.setBounds(0, 0, 244, 32);
		jp_Header_ThongTin.add(lbl_tieuDeTK);

		lblMaToa = new JLabel();
		lblMaToa.setBounds(721, 267, 272, 23);
		add(lblMaToa);
		lblMaToa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaToa.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel jp_VeCu = new JPanel();
		jp_VeCu.setLayout(null);
		jp_VeCu.setBackground(Color.WHITE);
		jp_VeCu.setBounds(10, 262, 244, 123);
		add(jp_VeCu);
		
		JPanel jp_Content_VeCu = new JPanel();
		jp_Content_VeCu.setLayout(null);
		jp_Content_VeCu.setBackground(new Color(255, 255, 255));
		jp_Content_VeCu.setBounds(0, 31, 244, 92);
		jp_VeCu.add(jp_Content_VeCu);
		
		JPanel jp_DanhSachVeCu = new JPanel();
		jp_DanhSachVeCu.setBackground(new Color(255, 255, 255));
		jp_DanhSachVeCu.setLayout(null);
		jp_DanhSachVeCu.setBounds(0, 0, 244, 93);
		jp_Content_VeCu.add(jp_DanhSachVeCu);
		
		JScrollPane scrollPane_VeCu = new JScrollPane((Component) null);
		scrollPane_VeCu.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane_VeCu.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_VeCu.setBounds(0, 0, 244, 92);
		jp_DanhSachVeCu.add(scrollPane_VeCu);
		
		JPanel jp_Header_VeCu = new JPanel();
		jp_Header_VeCu.setLayout(null);
		jp_Header_VeCu.setBackground(SystemColor.scrollbar);
		jp_Header_VeCu.setBounds(0, 0, 244, 32);
		jp_VeCu.add(jp_Header_VeCu);
		
		JLabel downIconLabel_VeCu = new JLabel((Icon) null);
		downIconLabel_VeCu.setBounds(0, 0, 30, 35);
		jp_Header_VeCu.add(downIconLabel_VeCu);
		
		JLabel lbl_tieuDeTK_VeCu = new JLabel("Vé cũ");
		lbl_tieuDeTK_VeCu.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_tieuDeTK_VeCu.setForeground(SystemColor.textHighlight);
		lbl_tieuDeTK_VeCu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_tieuDeTK_VeCu.setBounds(40, 0, 204, 32);
		jp_Header_VeCu.add(lbl_tieuDeTK_VeCu);
		
		JPanel jp_VeMoi = new JPanel();
		jp_VeMoi.setBorder(new LineBorder(new Color(0, 0, 0)));
		jp_VeMoi.setLayout(null);
		jp_VeMoi.setBackground(Color.WHITE);
		jp_VeMoi.setBounds(10, 395, 244, 165);
		add(jp_VeMoi);
		
		JPanel jp_Content_VeMoi = new JPanel();
		jp_Content_VeMoi.setLayout(null);
		jp_Content_VeMoi.setBackground(Color.WHITE);
		jp_Content_VeMoi.setBounds(0, 31, 244, 92);
		jp_VeMoi.add(jp_Content_VeMoi);
		
		JPanel jp_DanhSachVeMoi = new JPanel();
		jp_DanhSachVeMoi.setLayout(null);
		jp_DanhSachVeMoi.setBackground(Color.WHITE);
		jp_DanhSachVeMoi.setBounds(0, 0, 244, 93);
		jp_Content_VeMoi.add(jp_DanhSachVeMoi);
		
		JScrollPane scrollPane_VeMoi = new JScrollPane((Component) null);
		scrollPane_VeMoi.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane_VeMoi.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_VeMoi.setBounds(0, 0, 244, 92);
		jp_DanhSachVeMoi.add(scrollPane_VeMoi);
		
		JPanel jp_Header_VeMoi = new JPanel();
		jp_Header_VeMoi.setLayout(null);
		jp_Header_VeMoi.setBackground(SystemColor.scrollbar);
		jp_Header_VeMoi.setBounds(0, 0, 244, 32);
		jp_VeMoi.add(jp_Header_VeMoi);
		
		JLabel downIconLabel_VeMoi = new JLabel((Icon) null);
		downIconLabel_VeMoi.setBounds(0, 0, 30, 35);
		jp_Header_VeMoi.add(downIconLabel_VeMoi);
		
		JLabel lbl_tieuDeTK_VeMoi = new JLabel("Vé mới");
		lbl_tieuDeTK_VeMoi.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_tieuDeTK_VeMoi.setForeground(SystemColor.textHighlight);
		lbl_tieuDeTK_VeMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_tieuDeTK_VeMoi.setBounds(40, 0, 204, 32);
		jp_Header_VeMoi.add(lbl_tieuDeTK_VeMoi);
		
		RoundedButton rndbtnXcNhn = new RoundedButton("Tìm", 15);
		rndbtnXcNhn.setText("Xác nhận");
		rndbtnXcNhn.setForeground(Color.WHITE);
		rndbtnXcNhn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rndbtnXcNhn.setBackground(new Color(51, 102, 153));
		rndbtnXcNhn.setBounds(70, 128, 85, 27);
		jp_VeMoi.add(rndbtnXcNhn);

		// Thêm MouseListener vào contentPane
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// Mất focus của txtUser và txtPassword khi nhấp chuột ra ngoài
				txt_GaDi.transferFocus();
				txt_GaDen.transferFocus();
			}
		});
	}
	private void focusTxtField(JTextField txtField, String str) {
		txtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtField.getText().equals(str)) {
					txtField.setText("");
					txtField.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtField.getText().isEmpty()) {
					txtField.setForeground(SystemColor.textInactiveText);
					txtField.setText(str);
				}
			}
		});
	}
	private void chonGa(JTextField txt_Ga) {
		// Tạo JPopupMenu để hiển thị gợi ý
		JPopupMenu suggestionMenu = new JPopupMenu();

		// Hàm cập nhật gợi ý khi người dùng nhập vào text field
		txt_Ga.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String input = txt_Ga.getText();
				suggestionMenu.removeAll(); // Xóa các gợi ý cũ

//				if (!input.isEmpty()) {
//					int count = 0; // Biến đếm số gợi ý đã thêm
//					// Lọc danh sách ga theo từ khóa người dùng nhập
//					for (Ga ga : dsGa) {
//						if (ga.getDiaChi().toLowerCase().startsWith(input.toLowerCase())) {
//							JMenuItem item = new JMenuItem(ga.getDiaChi());
//							item.addActionListener(new ActionListener() {
//								@Override
//								public void actionPerformed(ActionEvent e) {
//									txt_Ga.setText(item.getText());
//									suggestionMenu.setVisible(false); // Ẩn gợi ý sau khi chọn
//								}
//							});
//							suggestionMenu.add(item);
//							count++; // Tăng biến đếm
//						}
//						if (count >= 5) { // Kiểm tra nếu đã có 5 gợi ý
//							break; // Thoát vòng lặp nếu đã đủ 5 gợi ý
//						}
//					}
//				}

				// Hiển thị danh sách gợi ý nếu có ít nhất một gợi ý
				if (suggestionMenu.getComponentCount() > 0) {
					suggestionMenu.show(txt_Ga, 0, txt_Ga.getHeight());
					txt_Ga.requestFocus(); // Đặt lại focus cho JTextField
				} else {
					suggestionMenu.setVisible(false); // Ẩn nếu không có gợi ý
				}
			}
		});
	}
}
