package Game;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import Input.MouseInput;
import Utills.LoadAndSave;

public class Paddle {
	public int x, y, width, hight, speed = 4;
	private MouseInput mouseInput;
	private BufferedImage paddle0;

	public Paddle(GamePanel gamePanel, MouseInput mouseInput) {
		this.mouseInput = mouseInput;
		setImage();
		width = paddle0.getWidth();
		hight = paddle0.getHeight();
		this.x = (gamePanel.width - width) / 2;
		this.y = gamePanel.hight - 100;
	}

	private void setImage() {
		paddle0 = LoadAndSave.getAtlas(LoadAndSave.PADDLE0_ATLAS);

	}

	public void update() {
		if (mouseInput.isMouseMoved) {
			x = mouseInput.getXCord(width);
		}
	}

	public void draw(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(paddle0, x, y, null);
	}
}
