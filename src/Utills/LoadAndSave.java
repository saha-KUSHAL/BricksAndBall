package Utills;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Game.GamePanel;

public class LoadAndSave {
	public static final String BALL_ATLAS = "BallSprites.png";
	public static final String PADDLE0_ATLAS = "Paddle0.png";
	public static final String TILE_ATLAS = "TilesAtlas.png";
	public static final String LEVEL_1 = "1.png";

	public static BufferedImage getAtlas(String imageName) {
		BufferedImage img = null;
		InputStream link = LoadAndSave.class.getResourceAsStream("/" + imageName);
		try {
			img = ImageIO.read(link);
		} catch (IOException e) {
			System.out.println("Can't load image: " + imageName);
			e.printStackTrace();
		} finally {
			try {
				link.close();
			} catch (IOException e) {
				System.out.println("Can't close image: " + imageName);
				e.printStackTrace();
			}
		}
		return img;
	}

	public static int[][] getLevelData() {
		int[][] levelData = new int[GamePanel.row][GamePanel.column];
		BufferedImage img = LoadAndSave.getAtlas(LEVEL_1);
		
		// No of tiles is equal to no of pixels in the level map
		int noOfXTiles = img.getWidth();
		int noOfYTiles = img.getHeight();
		
		for (int i = 0; i < noOfYTiles ; i++) {
			for (int j = 0; j < noOfXTiles; j++) {
				Color color = new Color(img.getRGB(j, i));
				int redValue = color.getRed();
				if (redValue > 3)
					redValue = 2; // It will change according to the tiles atlas
				levelData[i][j] = redValue;
			}
		}
		return levelData;
	}
}
