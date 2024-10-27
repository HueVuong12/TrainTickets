package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import dao.ChuyenTau_DAO;
import dao.Ga_DAO;
import entity.ChuyenTau;
import entity.Ga;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import java.awt.GridLayout;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.ButtonGroup;

public class BanVe_GUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel jp_title;
	private JLabel downIconLabel_2;
	private JLabel lbl_Chieu_1;
	private JLabel lbl_NgayDi_1;
	private JLabel lbl_Ga_1;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_21;
	private JLabel lblNewLabel_22;
	private JLabel lblNewLabel_23;
	private JLabel lblNewLabel_24;
	private JLabel lblNewLabel_25;
	private JLabel lblNewLabel_26;
	private JLabel lblNewLabel_27;
	private JLabel lblNewLabel_28;
	private JLabel lblNewLabel_29;
	private JLabel lblNewLabel_30;
	private JLabel lblNewLabel_31;
	private JLabel lblNewLabel_32;
	private JLabel lblNewLabel_37;
	private JLabel lblNewLabel_38;
	private JLabel lblNewLabel_39;
	private JLabel lblNewLabel_40;
	private JLabel lblNewLabel_45;
	private JLabel lblNewLabel_46;
	private JLabel lblNewLabel_47;
	private JLabel lblNewLabel_48;
	private JLabel lblNewLabel_53;
	private JLabel lblNewLabel_54;
	private JLabel lblNewLabel_55;
	private JLabel lblNewLabel_56;
	private JLabel lblNewLabel_61;
	private JLabel lblNewLabel_62;
	private JLabel lblNewLabel_63;
	private JLabel lblNewLabel_64;
	private JLabel lblNewLabel_33;
	private JLabel lblNewLabel_34;
	private JLabel lblNewLabel_35;
	private JLabel lblNewLabel_36;
	private JLabel lblNewLabel_41;
	private JLabel lblNewLabel_42;
	private JLabel lblNewLabel_43;
	private JLabel lblNewLabel_44;
	private JLabel lblNewLabel_49;
	private JLabel lblNewLabel_50;
	private JLabel lblNewLabel_51;
	private JLabel lblNewLabel_52;
	private JLabel lblNewLabel_57;
	private JLabel lblNewLabel_58;
	private JLabel lblNewLabel_59;
	private JLabel lblNewLabel_60;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JPanel panel_12;
	private JPanel jp_Ve;
	private JTextField txt_GaDi;
	private JTextField txt_GaDen;
	private JDateChooser chooserNgayDi;
	private JDateChooser chooserNgayVe;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtn_MotChieu;
	private JRadioButton rdbtn_KhuHoi;
	
	//Khai bao DAO
	Ga_DAO ga_dao = new Ga_DAO();
	ArrayList<Ga> dsGa = ga_dao.docTuBang();
	ChuyenTau_DAO chuyenTau_dao = new ChuyenTau_DAO();
	ArrayList<ChuyenTau> dsChuyenTau = chuyenTau_dao.docTuBang();
	/**
	 * Create the panel.
	 */
	public BanVe_GUI(TrangChu_GUI trangChu) {
		setBackground(SystemColor.window);
		setForeground(new Color(255, 255, 255));
		setBounds(0, 170, 1460, 570);
		setLayout(null);
		
		//Icon xổ xuống
		ImageIcon downIcon = new ImageIcon(getClass().getResource("/img/Polygon_20.png"));
		Image scaledDown = downIcon.getImage().getScaledInstance(20 ,20, Image.SCALE_SMOOTH);
		System.out.println("Them ve thanh cong");
		
		jp_title = new JPanel();
		jp_title.setLayout(null);
		jp_title.setBackground(new Color(51, 102, 153));
		jp_title.setBounds(264, 10, 686, 36);
		add(jp_title);
		
		downIconLabel_2 = new JLabel((Icon) null);
		downIconLabel_2.setBounds(0, 0, 30, 35);
		jp_title.add(downIconLabel_2);
		
		lbl_Chieu_1 = new JLabel("Chiều đi(chiều về)");
		lbl_Chieu_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Chieu_1.setBounds(40, 0, 152, 35);
		jp_title.add(lbl_Chieu_1);
		
		lbl_NgayDi_1 = new JLabel("08/10/2024");
		lbl_NgayDi_1.setBounds(192, 0, 152, 35);
		jp_title.add(lbl_NgayDi_1);
		
		lbl_Ga_1 = new JLabel("SE Tam Kỳ - Núi Thành");
		lbl_Ga_1.setBounds(342, 0, 113, 35);
		jp_title.add(lbl_Ga_1);
		
		JPanel jp_ThongTinChuyenTau = new JPanel();
		jp_ThongTinChuyenTau.setBounds(264, 56, 1186, 118);
		add(jp_ThongTinChuyenTau);
		jp_ThongTinChuyenTau.setLayout(null);
		
		ChuyenTau chuyenTau = new ChuyenTau("");
		ChuyenTau_JPanel jptau= new ChuyenTau_JPanel(chuyenTau,true);
		jp_ThongTinChuyenTau.add(jptau);
		
		ChuyenTau_JPanel jptau1= new ChuyenTau_JPanel(chuyenTau,true);
		jp_ThongTinChuyenTau.add(jptau1);
		
		ChuyenTau_JPanel jptau2= new ChuyenTau_JPanel(chuyenTau,true);
		jp_ThongTinChuyenTau.add(jptau2);
		
		ChuyenTau_JPanel jptau3= new ChuyenTau_JPanel(chuyenTau,true);
		jp_ThongTinChuyenTau.add(jptau3);
		
		
		
		JPanel jp_TinhTrangToa = new JPanel();
		jp_TinhTrangToa.setBounds(264, 184, 1186, 65);
		add(jp_TinhTrangToa);
		jp_TinhTrangToa.setLayout(new GridLayout(1, 0, 0, 0));
		
		Toa_JPanel toa1= new Toa_JPanel();
		jp_TinhTrangToa.add(toa1);
		
		Toa_JPanel toa2= new Toa_JPanel();
		jp_TinhTrangToa.add(toa2);
		toa2.setBackground(Color.red);
		
		Toa_JPanel toa3= new Toa_JPanel();
		jp_TinhTrangToa.add(toa3);
		
		Toa_JPanel toa4= new Toa_JPanel();
		jp_TinhTrangToa.add(toa4);
		
		Toa_JPanel toa5= new Toa_JPanel();
		jp_TinhTrangToa.add(toa5);
		
		Toa_JPanel toa6= new Toa_JPanel();
		jp_TinhTrangToa.add(toa6);
		
		Toa_JPanel toa7= new Toa_JPanel();
		jp_TinhTrangToa.add(toa7);
		
		JPanel jp_TinhTrangGhe = new JPanel();
		jp_TinhTrangGhe.setBounds(264, 270, 1186, 290);
		add(jp_TinhTrangGhe);
		jp_TinhTrangGhe.setLayout(null);
		
		lblNewLabel = new JLabel("Toa TA001_01");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(344, 10, 272, 23);
		jp_TinhTrangGhe.add(lblNewLabel);
		
		lblNewLabel_17 = new JLabel("     1");
		lblNewLabel_17.setBounds(250, 170, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_17);
		
		lblNewLabel_18 = new JLabel("     1");
		lblNewLabel_18.setBounds(250, 222, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_18);
		
		lblNewLabel_19 = new JLabel("     1");
		lblNewLabel_19.setBounds(250, 97, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_19);
		
		lblNewLabel_20 = new JLabel("     1");
		lblNewLabel_20.setBounds(250, 48, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_20);
		
		lblNewLabel_21 = new JLabel("     1");
		lblNewLabel_21.setBounds(308, 170, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_21);
		
		lblNewLabel_22 = new JLabel("     1");
		lblNewLabel_22.setBounds(308, 222, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_22);
		
		lblNewLabel_23 = new JLabel("     1");
		lblNewLabel_23.setBounds(308, 97, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_23);
		
		lblNewLabel_24 = new JLabel("     1");
		lblNewLabel_24.setBounds(308, 48, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_24);
		
		lblNewLabel_25 = new JLabel("     1");
		lblNewLabel_25.setBounds(366, 170, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_25);
		
		lblNewLabel_26 = new JLabel("     1");
		lblNewLabel_26.setBounds(366, 222, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_26);
		
		lblNewLabel_27 = new JLabel("     1");
		lblNewLabel_27.setBounds(366, 97, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_27);
		
		lblNewLabel_28 = new JLabel("     1");
		lblNewLabel_28.setBounds(366, 48, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_28);
		
		lblNewLabel_29 = new JLabel("     1");
		lblNewLabel_29.setBounds(421, 170, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_29);
		
		lblNewLabel_30 = new JLabel("     1");
		lblNewLabel_30.setBounds(421, 222, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_30);
		
		lblNewLabel_31 = new JLabel("     1");
		lblNewLabel_31.setBounds(421, 97, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_31);
		
		lblNewLabel_32 = new JLabel("     1");
		lblNewLabel_32.setBounds(421, 48, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_32);
		
		lblNewLabel_37 = new JLabel("     1");
		lblNewLabel_37.setBounds(738, 48, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_37);
		
		lblNewLabel_38 = new JLabel("     1");
		lblNewLabel_38.setBounds(796, 48, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_38);
		
		lblNewLabel_39 = new JLabel("     1");
		lblNewLabel_39.setBounds(854, 48, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_39);
		
		lblNewLabel_40 = new JLabel("     1");
		lblNewLabel_40.setBounds(909, 48, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_40);
		
		lblNewLabel_45 = new JLabel("     1");
		lblNewLabel_45.setBounds(738, 97, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_45);
		
		lblNewLabel_46 = new JLabel("     1");
		lblNewLabel_46.setBounds(796, 97, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_46);
		
		lblNewLabel_47 = new JLabel("     1");
		lblNewLabel_47.setBounds(854, 97, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_47);
		
		lblNewLabel_48 = new JLabel("     1");
		lblNewLabel_48.setBounds(909, 97, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_48);
		
		lblNewLabel_53 = new JLabel("     1");
		lblNewLabel_53.setBounds(738, 170, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_53);
		
		lblNewLabel_54 = new JLabel("     1");
		lblNewLabel_54.setBounds(796, 170, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_54);
		
		lblNewLabel_55 = new JLabel("     1");
		lblNewLabel_55.setBounds(854, 170, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_55);
		
		lblNewLabel_56 = new JLabel("     1");
		lblNewLabel_56.setBounds(909, 170, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_56);
		
		lblNewLabel_61 = new JLabel("     1");
		lblNewLabel_61.setBounds(738, 222, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_61);
		
		lblNewLabel_62 = new JLabel("     1");
		lblNewLabel_62.setBounds(796, 222, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_62);
		
		lblNewLabel_63 = new JLabel("     1");
		lblNewLabel_63.setBounds(854, 222, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_63);
		
		lblNewLabel_64 = new JLabel("     1");
		lblNewLabel_64.setBounds(909, 222, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_64);
		
		lblNewLabel_33 = new JLabel("     1");
		lblNewLabel_33.setBounds(510, 48, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_33);
		
		lblNewLabel_34 = new JLabel("     1");
		lblNewLabel_34.setBounds(568, 48, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_34);
		
		lblNewLabel_35 = new JLabel("     1");
		lblNewLabel_35.setBounds(626, 48, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_35);
		
		lblNewLabel_36 = new JLabel("     1");
		lblNewLabel_36.setBounds(681, 48, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_36);
		
		lblNewLabel_41 = new JLabel("     1");
		lblNewLabel_41.setBounds(510, 97, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_41);
		
		lblNewLabel_42 = new JLabel("     1");
		lblNewLabel_42.setBounds(568, 97, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_42);
		
		lblNewLabel_43 = new JLabel("     1");
		lblNewLabel_43.setBounds(626, 97, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_43);
		
		lblNewLabel_44 = new JLabel("     1");
		lblNewLabel_44.setBounds(681, 97, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_44);
		
		lblNewLabel_49 = new JLabel("     1");
		lblNewLabel_49.setBounds(510, 170, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_49);
		
		lblNewLabel_50 = new JLabel("     1");
		lblNewLabel_50.setBounds(568, 170, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_50);
		
		lblNewLabel_51 = new JLabel("     1");
		lblNewLabel_51.setBounds(626, 170, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_51);
		
		lblNewLabel_52 = new JLabel("     1");
		lblNewLabel_52.setBounds(681, 170, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_52);
		
		lblNewLabel_57 = new JLabel("     1");
		lblNewLabel_57.setBounds(510, 222, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_57);
		
		lblNewLabel_58 = new JLabel("     1");
		lblNewLabel_58.setBounds(568, 222, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_58);
		
		lblNewLabel_59 = new JLabel("     1");
		lblNewLabel_59.setBounds(626, 222, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_59);
		
		lblNewLabel_60 = new JLabel("     1");
		lblNewLabel_60.setBounds(681, 222, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_60);
		
		lblNewLabel_1 = new JLabel("     1");
		lblNewLabel_1.setBounds(25, 48, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("     1");
		lblNewLabel_2.setBounds(83, 48, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("     1");
		lblNewLabel_3.setBounds(141, 48, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("     1");
		lblNewLabel_4.setBounds(196, 48, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("     1");
		lblNewLabel_5.setBounds(196, 97, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("     1");
		lblNewLabel_6.setBounds(141, 97, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("     1");
		lblNewLabel_7.setBounds(83, 97, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("     1");
		lblNewLabel_8.setBounds(25, 97, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("     1");
		lblNewLabel_9.setBounds(25, 170, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("     1");
		lblNewLabel_10.setBounds(83, 170, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("     1");
		lblNewLabel_11.setBounds(141, 170, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("     1");
		lblNewLabel_12.setBounds(196, 170, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("     1");
		lblNewLabel_13.setBounds(196, 222, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("     1");
		lblNewLabel_14.setBounds(141, 222, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("     1");
		lblNewLabel_15.setBounds(83, 222, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_15);
		
		lblNewLabel_16 = new JLabel("     1");
		lblNewLabel_16.setBounds(25, 222, 36, 42);
		jp_TinhTrangGhe.add(lblNewLabel_16);
		
		JPanel jp_timKiem = new JPanel();
		jp_timKiem.setLayout(null);
		jp_timKiem.setBackground(Color.WHITE);
		jp_timKiem.setBounds(10, 10, 244, 351);
		add(jp_timKiem);
		
		JPanel jp_content = new JPanel();
		jp_content.setLayout(null);
		jp_content.setBackground(SystemColor.controlHighlight);
		jp_content.setBounds(0, 32, 244, 319);
		jp_timKiem.add(jp_content);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gaDi = txt_GaDi.getText();
				String gaDen = txt_GaDen.getText();
				boolean isKhuHoi = rdbtn_KhuHoi.isSelected();
				LocalDate ngayDi = chooserNgayDi.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate ngayVe;
				if (isKhuHoi) {
					ngayVe = chooserNgayVe.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				}
				
				ArrayList<ChuyenTau> dsTauHienThi = new ArrayList<ChuyenTau>();
				for (ChuyenTau chuyenTau: dsChuyenTau) {
					if ((ga_dao.getGaTheoMaGa(chuyenTau.getGaDi().getMaGa()).getDiaChi().equals(gaDi)) && (chuyenTau.getNgayDi().equals(ngayDi))) {
						for (Ga gaDung: chuyenTau.getTramDung()) {
							if (gaDen.equals(gaDung.getDiaChi()))
								dsTauHienThi.add(chuyenTau);
						}
						if (gaDen.equals(ga_dao.getGaTheoMaGa(chuyenTau.getGaDen().getMaGa()).getDiaChi()))
							dsTauHienThi.add(chuyenTau);
					}
				}
				for (ChuyenTau chuyenTau: dsTauHienThi) {
					System.out.println(chuyenTau.toString());
				}
				System.out.println("press!");
			}
		});
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTim.setBounds(73, 278, 85, 27);
		jp_content.add(btnTim);
		
		txt_GaDi = new JTextField();
		txt_GaDi.setText("Nhập ga đi");
		txt_GaDi.setHorizontalAlignment(SwingConstants.LEFT);
		txt_GaDi.setForeground(SystemColor.textInactiveText);
		txt_GaDi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_GaDi.setColumns(10);
		txt_GaDi.setBounds(21, 26, 202, 27);
		jp_content.add(txt_GaDi);
		chonGa(txt_GaDi);
		focusTxtField(txt_GaDi, "Nhập ga đi");
		
		txt_GaDen = new JTextField();
		txt_GaDen.setText("Nhập ga đến");
		txt_GaDen.setHorizontalAlignment(SwingConstants.LEFT);
		txt_GaDen.setForeground(SystemColor.textInactiveText);
		txt_GaDen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt_GaDen.setColumns(10);
		txt_GaDen.setBounds(21, 78, 202, 27);
		jp_content.add(txt_GaDen);
		chonGa(txt_GaDen);
		focusTxtField(txt_GaDen, "Nhập ga đến");
		
		rdbtn_MotChieu = new JRadioButton("Một Chiều");
		buttonGroup.add(rdbtn_MotChieu);
		rdbtn_MotChieu.setBounds(21, 130, 85, 21);
		jp_content.add(rdbtn_MotChieu);
		
		rdbtn_KhuHoi = new JRadioButton("Khứ Hồi");
		buttonGroup.add(rdbtn_KhuHoi);
		rdbtn_KhuHoi.setBounds(108, 130, 85, 21);
		jp_content.add(rdbtn_KhuHoi);
		
		rdbtn_MotChieu.setSelected(true);
		
		chooserNgayDi = new JDateChooser();
		chooserNgayDi.setBounds(21, 180, 202, 27);
		chooserNgayDi.setDateFormatString("dd/MM/yyyy");
		jp_content.add(chooserNgayDi);
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
		
		chooserNgayVe = new JDateChooser();
		chooserNgayVe.setBounds(21, 240, 202, 27);
		chooserNgayVe.setDateFormatString("dd/MM/yyyy");
		chooserNgayVe.setEnabled(false);
		jp_content.add(chooserNgayVe);
		((JTextField) chooserNgayVe.getDateEditor().getUiComponent()).setEditable(false);
		
		// Thêm listener để thay đổi trạng thái của chooser ngày về
        rdbtn_KhuHoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooserNgayVe.setEnabled(true); // Kích hoạt chooser ngày về khi chọn Khứ Hồi
            }
        });

        rdbtn_MotChieu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooserNgayVe.setEnabled(false); // Vô hiệu hóa chooser ngày về khi chọn Một Chiều
                chooserNgayVe.setDate(null); // Xóa ngày đã chọn
            }
        });
		
     // Thêm listener để kiểm tra ngày chọn về
        chooserNgayVe.getDateEditor().addPropertyChangeListener("date", new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                Date ngayDi = chooserNgayDi.getDate();

                // Kiểm tra nếu chọn ngày về khi khứ hồi được chọn
                if (chooserNgayVe.getDate() != null) {
                    // Kiểm tra nếu ngày đi đã được chọn
                    if (ngayDi == null) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày đi trước khi chọn ngày về.", 
                                "Thông báo", JOptionPane.WARNING_MESSAGE);
                        chooserNgayVe.setDate(null); // Xóa ngày đã chọn
                        return; // Thoát khỏi phương thức
                    }

                    // Kiểm tra nếu ngày về trước ngày đi
                    if (chooserNgayVe.getDate().before(ngayDi)) {
                        JOptionPane.showMessageDialog(null, "Ngày không hợp lệ! Vui lòng chọn ngày sau ngày đi.", 
                                "Thông báo", JOptionPane.WARNING_MESSAGE);
                        chooserNgayVe.setDate(null); // Xóa ngày đã chọn
                    }
                }
            }
        });

		JLabel lbl_GaDi = new JLabel("Ga Đi");
		lbl_GaDi.setBounds(24, 10, 45, 13);
		jp_content.add(lbl_GaDi);
		
		JLabel lbl_GaDen = new JLabel("Ga Đến");
		lbl_GaDen.setBounds(21, 63, 45, 13);
		jp_content.add(lbl_GaDen);
		
		JLabel lbl_LuaChon = new JLabel("Lựa chọn");
		lbl_LuaChon.setBounds(24, 111, 58, 13);
		jp_content.add(lbl_LuaChon);
		
		JLabel lbl_ChonNgayDi = new JLabel("Ngày đi");
		lbl_ChonNgayDi.setBounds(21, 157, 45, 13);
		jp_content.add(lbl_ChonNgayDi);
		
		JLabel lbl_ChonNgayVe = new JLabel("Ngày về");
		lbl_ChonNgayVe.setBounds(21, 217, 48, 13);
		jp_content.add(lbl_ChonNgayVe);
		
		JPanel jp_header = new JPanel();
		jp_header.setLayout(null);
		jp_header.setBackground(new Color(51, 102, 153));
		jp_header.setBounds(0, 0, 244, 32);
		jp_timKiem.add(jp_header);
		
		JLabel downIconLabel = new JLabel((Icon) null);
		downIconLabel.setBounds(0, 0, 30, 35);
		jp_header.add(downIconLabel);
		
		JLabel lbl_tieuDeTK = new JLabel("Thông tin chuyến tàu");
		lbl_tieuDeTK.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tieuDeTK.setForeground(Color.WHITE);
		lbl_tieuDeTK.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_tieuDeTK.setBounds(0, 0, 222, 35);
		jp_header.add(lbl_tieuDeTK);
		
		JPanel jp_GioVe = new JPanel();
		jp_GioVe.setLayout(null);
		jp_GioVe.setBackground(Color.WHITE);
		jp_GioVe.setBounds(10, 369, 244, 191);
		add(jp_GioVe);
		
		JPanel jp_content_1 = new JPanel();
		jp_content_1.setLayout(null);
		jp_content_1.setBackground(SystemColor.controlHighlight);
		jp_content_1.setBounds(0, 31, 244, 160);
		jp_GioVe.add(jp_content_1);
		
		JButton btnMua = new JButton("Mua");
		btnMua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMua.setBounds(149, 123, 85, 27);
		jp_content_1.add(btnMua);
		
		JPanel jp_DanhSachVe = new JPanel();
		jp_DanhSachVe.setLayout(null);
		jp_DanhSachVe.setBounds(0, 0, 244, 122);
		jp_content_1.add(jp_DanhSachVe);
		
		JLabel lbl_Chieu = new JLabel("Chiều đi");
		lbl_Chieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Chieu.setBounds(93, 2, 51, 23);
		jp_DanhSachVe.add(lbl_Chieu);
		
		JPanel jp_VeMua = new JPanel();
		jp_VeMua.setBounds(0, 30, 244, 92);
		jp_DanhSachVe.add(jp_VeMua);
		jp_VeMua.setLayout(new GridLayout(0, 1, 0, 0));
		
		Ve_JPanel veMua = new Ve_JPanel();
		jp_VeMua.add(veMua);
		
		JPanel jp_header_GioVe = new JPanel();
		jp_header_GioVe.setLayout(null);
		jp_header_GioVe.setBackground(new Color(51, 102, 153));
		jp_header_GioVe.setBounds(0, 0, 244, 32);
		jp_GioVe.add(jp_header_GioVe);
		
		JLabel downIconLabel_1 = new JLabel((Icon) null);
		downIconLabel_1.setBounds(0, 0, 30, 35);
		jp_header_GioVe.add(downIconLabel_1);
		
		JLabel lbl_tieuDeTK_GioVe = new JLabel("Giỏ Vé");
		lbl_tieuDeTK_GioVe.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tieuDeTK_GioVe.setForeground(Color.WHITE);
		lbl_tieuDeTK_GioVe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_tieuDeTK_GioVe.setBounds(61, 0, 121, 32);
		jp_header_GioVe.add(lbl_tieuDeTK_GioVe);

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

				if (!input.isEmpty()) {
					int count = 0; // Biến đếm số gợi ý đã thêm
					// Lọc danh sách ga theo từ khóa người dùng nhập
					for (Ga ga : dsGa) {
						if (ga.getDiaChi().toLowerCase().startsWith(input.toLowerCase())) {
							JMenuItem item = new JMenuItem(ga.getDiaChi());
							item.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									txt_Ga.setText(item.getText());
									suggestionMenu.setVisible(false); // Ẩn gợi ý sau khi chọn
								}
							});
							suggestionMenu.add(item);
							count++; // Tăng biến đếm
						}
						if (count >= 5) { // Kiểm tra nếu đã có 5 gợi ý
							break; // Thoát vòng lặp nếu đã đủ 5 gợi ý
						}
					}
				}

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
