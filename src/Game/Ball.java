package Game;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Utills.LoadAndSave;

public class Ball {
	private int dx, dy, diameter, x, y, clk;
	private BufferedImage img, ballSprites[];
	private int imgIndex, spriteCount, animationSpeed;
	private GamePanel gamePanel;

	public Ball(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		diameter = gamePanel.tileSize;
		x = ((gamePanel.width - diameter) - diameter) / 2;
		y = ((gamePanel.hight - diameter) - diameter) / 2;
		animationSpeed = 20;
		dx = 3;
		dy = 1;
		importImage();
		loadSprites();
	}

	private void importImage() {
		img = LoadAndSave.getAtlas(LoadAndSave.BALL_ATLAS);
	}

	private void loadSprites() {
		spriteCount = img.getWidth() / gamePanel.tileSize;
		ballSprites = new BufferedImage[spriteCount];
		for (int i = 0; i < spriteCount; i++) {
			ballSprites[i] = img.getSubimage(i * gamePanel.tileSize, 0, gamePanel.tileSize, gamePanel.tileSize);
		}
	}

	private void ballAnimate() {
		clk++;
		if (clk >= animationSpeed) {
			clk = 0;
			imgIndex++;
			if (imgIndex >= spriteCount)
				imgIndex = 0;
		}
	}

	private void setPosition() {
		x += dx;
		y += dy;
		if(x < 0 || x > (gamePanel.width - diameter)) 
			dx = -dx;
		if( y < 0 || y > (gamePanel.hight - diameter))
			dy = -dy;

	}

	void update() {
		setPosition();
		ballAnimate();
	}

	void draw(Graphics2D g) {
		g.drawImage(ballSprites[imgIndex], x, y, gamePanel.tileSize, gamePanel.tileSize, null);
		Toolkit.getDefaultToolkit().sync(); // Flush the Linux graphics buffer
	}
}
