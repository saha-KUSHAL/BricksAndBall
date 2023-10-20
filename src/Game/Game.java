package Game;

public class Game implements Runnable {
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;
	private Thread gameThread;

	public Game() {
		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		startGameLoop();
	}

	private void update() {
		gamePanel.updateGame();

	}

	public void run() {
		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;

		long previousTime = System.nanoTime();

		int updateCount = 0;
		int frameCount = 0;

		long lastCheck = System.currentTimeMillis();

		double deltaU = 0;
		double deltaF = 0;
		while (gameThread != null) {
			long currentTime = System.nanoTime();

			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;

			previousTime = currentTime;
			if (deltaU >= 1) {
				update();
				updateCount++;
				deltaU--;

			}
			if (deltaF >= 1) {
				gamePanel.repaint();
				frameCount++;
				deltaF--;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frameCount + " | UPS: " + updateCount);
				frameCount = 0;
				updateCount = 0;
			}
		}
	}

	// Game Loop

	protected void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}
}
