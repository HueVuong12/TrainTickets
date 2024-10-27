package gui;

import javax.swing.JPanel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

import entity.ChuyenTau;

import java.awt.SystemColor;
import java.awt.Font;

public class ChuyenTau_JPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel trainIconLabel;

	/**
	 * Create the panel.
	 */
	public ChuyenTau_JPanel(ChuyenTau chuyenTau, boolean isSeleted) {
		setLayout(null);
		ImageIcon trainIcon;
		//Logo chương trình
//		if (isSeleted) {
//			
//		} else {
//			trainIcon = new ImageIcon(getClass().getResource("/img/Chuyen_0.png"));
//		}
		
		trainIcon = new ImageIcon(getClass().getResource("/img/Chuyen_1.png"));
		Image scaledTrainIcon = trainIcon.getImage().getScaledInstance(383,441, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		trainIconLabel = new JLabel(new ImageIcon(scaledTrainIcon));
		trainIconLabel.setBackground(Color.WHITE);
		add(trainIconLabel);
		trainIconLabel.setBounds(0, 0, 383, 441);
		
		JLabel lblNewLabel = new JLabel("TAU001");
		lblNewLabel.setBounds(130, 10, 104, 42);
		add(lblNewLabel);
	}
}
