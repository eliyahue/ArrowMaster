import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HighScorePanel extends JPanel implements ActionListener {
	public JPanel panel;
	MainPanel mp;
	JLabel label;
	JButton ButtonR;

	HighScorePanel() {
		panel = new JPanel();
		panel.setSize(750, 750);
		panel.setVisible(false);
		panel.setLayout(null);
		label = new JLabel();
		ImageIcon image = new ImageIcon("starpicture.jpg_L.png");
		label.setIcon(image);
		label.setBounds(0, 0, 750, 750);
		label.setText("High Score");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 50));
		label.setIconTextGap(-150);

		ButtonR = new JButton();
		ButtonR.setBounds(620, 30, 80, 80);
		ButtonR.addActionListener(this);
		ButtonR.setBorderPainted(false);
		ButtonR.setContentAreaFilled(false);
		ImageIcon arrow = new ImageIcon("arrow.png");
		ButtonR.setIcon(arrow);
		panel.add(ButtonR);
		panel.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.ButtonR) {
			panel.setVisible(false);
			mp.panel.setVisible(true);
		}
	}

	public void SetMainPanel(MainPanel mp) {
		this.mp = mp;

	}
}