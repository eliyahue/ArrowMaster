import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements ActionListener {
	public JPanel panel;
	HighScorePanel hp;
	InstructionsPanel ip;
	JLabel label;
	JButton Button1;
	JButton Button2;
	JButton Button3;
	private static Clip clip;

	MainPanel() {

		label = new JLabel();
		ImageIcon image = new ImageIcon("starpicture.jpg_L.png");
		label.setIcon(image);
		label.setBounds(0, 0, 750, 750);
		label.setText("Arrow Master");// title
		label.setForeground(Color.white);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 50));
		label.setIconTextGap(-150);

		Button1 = new JButton();
		Button1.setBounds(275, 250, 200, 70);
		Button1.addActionListener(this);
		Button1.setText("New Game");
		Button1.setVisible(true);
		Button1.setBackground(new Color(72, 211, 255));
		Button1.setFont(new Font("MV Boli", Font.CENTER_BASELINE, 23));

		Button2 = new JButton();
		Button2.setBounds(275, 350, 200, 70);
		Button2.addActionListener(this);
		Button2.setText("High Score");
		Button2.setVisible(true);
		Button2.setBackground(new Color(72, 211, 255));
		Button2.setFont(new Font("MV Boli", Font.CENTER_BASELINE, 23));

		Button3 = new JButton();
		Button3.setBounds(275, 450, 200, 70);
		Button3.addActionListener(this);
		Button3.setText("Instructions");
		Button3.setVisible(true);
		Button3.setBackground(new Color(72, 211, 255));
		Button3.setFont(new Font("MV Boli", Font.CENTER_BASELINE, 23));

		panel = new JPanel();
		panel.setSize(750, 750);
		panel.setVisible(true);
		panel.setLayout(null);
		panel.add(Button1);
		panel.add(Button2);
		panel.add(Button3);
		panel.add(label);
		playLoopingSound("sound.wav");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.Button1) {
			panel.setVisible(false);
		}
		if (e.getSource() == this.Button2) {
			panel.setVisible(false);
			hp.panel.setVisible(true);
		}
		if (e.getSource() == this.Button3) {
			panel.setVisible(false);
			ip.panel.setVisible(true);
		}
	}

	public static void playSound(String soundFile) {
		try {
			File soundPath = new File(soundFile);
			if (soundPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundPath);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
			} else {
				System.out.println("Can't find sound file.");
			}
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			ex.printStackTrace();
		}
	}

	public void playLoopingSound(String soundFile) {
		try {
			File soundPath = new File(soundFile);
			if (soundPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundPath);
				clip = AudioSystem.getClip();
				clip.open(audioInput);

				// Loop continuously
				clip.loop(Clip.LOOP_CONTINUOUSLY);

				// Start the clip
				clip.start();

			} else {
				System.out.println("Can't find sound file.");
			}
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			ex.printStackTrace();
		}
	}

	public static void stopSound() {
		if (clip != null && clip.isRunning()) {
			clip.stop();
			clip.close();
		}
	}

	public void SetInstructionsPanel(InstructionsPanel ip) {
		this.ip = ip;

	}

	public void SetHighScorePanel(HighScorePanel hp) {
		this.hp = hp;
	}
}
