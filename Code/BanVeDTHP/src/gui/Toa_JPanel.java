package gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Toa_JPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel containerIconLabel;

	/**
	 * Create the panel.
	 */
	public Toa_JPanel() {
		setBounds(0, 0, 145, 65);
		setLayout(null);
		
		setBackground(new Color(30, 144, 255));
		
		ImageIcon containerIcon = new ImageIcon(getClass().getResource("/img/toa1.png"));
		Image scaledContainerIcon = containerIcon.getImage().getScaledInstance(125,60, Image.SCALE_SMOOTH); // Thay đổi kích thước logo
		containerIconLabel = new JLabel(new ImageIcon(scaledContainerIcon));
		containerIconLabel.setBackground(Color.WHITE);
		add(containerIconLabel);
		containerIconLabel.setBounds(10, 0, 125, 65);
	}

}
