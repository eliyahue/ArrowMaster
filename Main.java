import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Arrow Master");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750, 750);
		frame.setResizable(false);
		frame.setLayout(null);
		HighScorePanel hp = new HighScorePanel();
		InstructionsPanel ip = new InstructionsPanel();
		MainPanel mp = new MainPanel();
		mp.SetInstructionsPanel(ip);
		mp.SetHighScorePanel(hp);
		ip.SetMainPanel(mp);
		hp.SetMainPanel(mp);
		frame.add(hp.panel);		
		frame.add(ip.panel);
		frame.add(mp.panel);
		//frame.repaint();
		frame.setVisible(true);
	}
	
}
