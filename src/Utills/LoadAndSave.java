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
		for (int i = 0; i < img.getHeight(); i++) {
			for (int j = 0; j < img.getWidth(); j++) {
				Color color = new Color(img.getRGB(j, i));
				int redValue = color.getRed();
				if (redValue > 1)
					redValue = 1; // It will change according to the tiles atlas
				levelData[i][j] = redValue;
			}
		}
		return levelData;
	}
}
