package Game;

import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import Utills.LoadAndSave;

public class Ball {
	private int dx, dy, diameter, x, y, clk;
	private BufferedImage img, ballSprites[];
	private int imgIndex, spriteCount, animationSpeed;
	private GamePanel gamePanel;
	private Hitbox hitbox;

	public Ball(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		diameter = GamePanel.TILE_SIZE;
		x = ((gamePanel.width - diameter) - diameter) / 2;
		y = ((gamePanel.hight - diameter) - diameter) / 2;
		animationSpeed = 20;
		dx = 2;
		dy = 1;
		hitbox = new Hitbox(x, y, diameter, diameter, Hitbox.CIRCLE);
		importImage();
		loadSprites();
	}

	private void importImage() {
		img = LoadAndSave.getAtlas(LoadAndSave.BALL_ATLAS);
	}

	private void loadSprites() {
		spriteCount = img.getWidth() / GamePanel.TILE_SIZE;
		ballSprites = new BufferedImage[spriteCount];
		for (int i = 0; i < spriteCount; i++) {
			ballSprites[i] = img.getSubimage(i * GamePanel.TILE_SIZE, 0, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE);
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
		if (x < 0 || x > (gamePanel.width - diameter))
			dx = -dx;
		if (y < 0 || y > (gamePanel.hight - diameter))
			dy = -dy;

	}

	protected void update() {
		setPosition();
		hitbox.updateHitbox(x, y);
		ballAnimate();
	}

	protected void draw(Graphics2D g) {
		g.drawImage(ballSprites[imgIndex], x, y, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE, null);
		hitbox.displayHitbox(g);
		Toolkit.getDefaultToolkit().sync(); // Flush the Linux graphics buffer
	}
}
