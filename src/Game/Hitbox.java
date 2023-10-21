package Game;

import java.awt.Color;
import java.awt.Graphics2D;

class Hitbox {
	private int x, y, width, hight;
	public static int CIRCLE = 0;
	public static int RECTANGLE = 1;
	private int shape;

	public Hitbox(int x, int y, int width, int hight, int shape) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.hight = hight;
		this.shape = shape;
	}   

	protected void updateHitbox(int x, int y) {
		this.x = x;
		this.y = y;
	}

	protected void displayHitbox(Graphics2D g) {
		if (Game.debug) {
			g.setColor(Color.pink);
			switch (shape) {
			case 0:
				g.drawOval(x, y, width, hight);
				break;
			case 1:g.drawRect(x, y, width, hight);
			default:
				g.drawRect(x, y, width, hight);
			}
		}
	}
}
