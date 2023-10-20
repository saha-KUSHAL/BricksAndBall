package Game;

import javax.swing.JFrame;

public class GameWindow {
	private JFrame windowFrame;
	public GameWindow(GamePanel gamePanel) {
		windowFrame = new JFrame();
		windowFrame.setDefaultCloseOperation(3);
		windowFrame.add(gamePanel);
		windowFrame.setLocationRelativeTo(null);
		windowFrame.setResizable(false);
		windowFrame.pack();
		windowFrame.setVisible(true);
	}
}
