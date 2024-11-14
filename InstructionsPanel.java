import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InstructionsPanel extends JPanel implements ActionListener {
	public JPanel panel;
	MainPanel mp;
	JLabel label;
	JButton ButtonR;
	JTextArea instructionsArea;

	InstructionsPanel() {
		panel = new JPanel();
		panel.setSize(750, 750);
		panel.setVisible(false);
		panel.setLayout(null);
		label = new JLabel();
		ImageIcon image = new ImageIcon("starpicture.jpg_L.png");
		label.setIcon(image);
		label.setBounds(0, 0, 750, 750);
		label.setText("Instructions");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.white);
		label.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 50));
		label.setIconTextGap(-150);
		instructionsArea = new JTextArea();
		instructionsArea.setEditable(false);
		instructionsArea.setText(
				"Arrow Master Game Instructions\n\n" +
						"Objective:\n" +
						"Hit targets to score points.\n\n" +
						"Controls:\n" +
						"- Aim with joystick or touch.\n" +
						"- Hold and release to shoot.\n\n" +
						"Scoring:\n" +
						"- Bullseye: 50 points\n" +
						"- Inner ring: 30 points\n" +
						"- Outer ring: 10 points\n\n" +
						"Modes:\n" +
						"- Time Attack\n" +
						"- Challenge Mode\n" +
						"- Multiplayer\n\n" +
						"Happy shooting! 🎯"
				);
		
		// הוספת אזור גלילה לטקסט
		JScrollPane scrollPane = new JScrollPane(instructionsArea);
	
		ButtonR = new JButton();
		ButtonR.setBounds(620, 30, 80, 80);
		ButtonR.addActionListener(this);
		ButtonR.setBorderPainted(false);
		ButtonR.setContentAreaFilled(false);
		ImageIcon arrow = new ImageIcon("arrow.png");
		ButtonR.setIcon(arrow);
		panel.add(ButtonR);
		panel.add(label);
		panel.add(scrollPane, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.ButtonR) {
			panel.setVisible(false);
			mp.panel.setVisible(true);
		}
	}

	public void SetMainPanel(MainPanel mp) {
		this.mp = mp;

	}

}



   

