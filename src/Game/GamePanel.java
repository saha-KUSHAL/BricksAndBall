package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import Input.MouseInput;
import Levels.LevelManager;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static int intialTileSize = 16;
	private static int scaleRation = 3;
	public static int TILE_SIZE = intialTileSize * scaleRation;
	public static int column = 28;
	public static int row = 20;
	public int width = TILE_SIZE * column ;
	public int hight = TILE_SIZE * row;
	private LevelManager levelManager;
	
	private Paddle paddle;
	private Ball ball;

	MouseInput mouseInput;

	GamePanel() {	
		setPreferredSize(new Dimension(width, hight));
		setDoubleBuffered(true); // Improves performance
		setBackground(Color.BLACK);
		mouseInput = new MouseInput(this);
		paddle = new Paddle(this, mouseInput);
		ball = new Ball(this);
		levelManager = new LevelManager(this);
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseInput);
		
	}

	// Updates the fields
	public void updateGame() {
		paddle.update();
		ball.update();
		levelManager.update();
	}

	// Renders the game
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		levelManager.draw(g);
		paddle.draw((Graphics2D) g);
		ball.draw((Graphics2D) g);
		g.dispose();
	}
}
