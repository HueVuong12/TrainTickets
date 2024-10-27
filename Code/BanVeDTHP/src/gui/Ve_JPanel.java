package gui;

import javax.swing.JPanel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ve_JPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel deleteIconLabel;

	/**
	 * Create the panel.
	 */
	public Ve_JPanel() {
		setBounds(0,0, 244, 73);
		setLayout(null);
		
		JPanel jp_ThongTinVe = new JPanel();
		jp_ThongTinVe.setBounds(0, 0, 201, 73);
		add(jp_ThongTinVe);
		jp_ThongTinVe.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SE Tam Kỳ - Núi Thành");
		lblNewLabel.setBounds(10, 10, 181, 13);
		jp_ThongTinVe.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("08/10/2024");
		lblNewLabel_1.setBounds(10, 27, 71, 13);
		jp_ThongTinVe.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NML toa số 1 số 49");
		lblNewLabel_1_1.setBounds(10, 44, 181, 13);
		jp_ThongTinVe.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("10:34");
		lblNewLabel_1_1_1.setBounds(84, 27, 53, 13);
		jp_ThongTinVe.add(lblNewLabel_1_1_1);
		
		JPanel jp_Icon = new JPanel();
		jp_Icon.setBounds(199, 0, 45, 73);
		add(jp_Icon);
		
		ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/img/trash-regular-48-removebg-preview.png"));
	    Image scaledDelete = deleteIcon.getImage().getScaledInstance(20 ,20, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
	    jp_Icon.setLayout(null);
	    deleteIconLabel = new JLabel(new ImageIcon(scaledDelete));
	    deleteIconLabel.setBounds(0 ,0 , 45 ,73); // Cập nhật kích thước trên JLabel
	    jp_Icon.add(deleteIconLabel);
	}

}
