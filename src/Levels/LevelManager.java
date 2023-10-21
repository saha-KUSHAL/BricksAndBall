package Levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Game.GamePanel;
import Utills.LoadAndSave;

public class LevelManager {
	private BufferedImage levelAtlas[];
	private GamePanel gamePanel;
	private Level level;
	
	public LevelManager(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		loadTiles();
		level = new Level(LoadAndSave.getLevelData());
	}
	
	private void loadTiles() {
		BufferedImage tileAtlas = LoadAndSave.getAtlas(LoadAndSave.TILE_ATLAS);
		int tileColCount = tileAtlas.getWidth()/gamePanel.TILE_SIZE;
		int	tileRowCount = tileAtlas.getHeight()/gamePanel.TILE_SIZE;
		
		levelAtlas = new BufferedImage[tileRowCount * tileColCount];
		
		for(int i = 0; i < tileRowCount; i++) {
			for(int j = 0; j < tileColCount ; j++) {
				levelAtlas[i*tileColCount + j] = tileAtlas.getSubimage(j * gamePanel.TILE_SIZE,
						i * gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
			}
		}
	}

	public void draw(Graphics g) {
		
		for(int i = 0 ; i < GamePanel.row ; i++) {
			for(int j=0;j< GamePanel.column;j++) {
				int index = level.getSpriteIndex(j, i);
				g.drawImage(levelAtlas[index],gamePanel.TILE_SIZE * j, gamePanel.TILE_SIZE * i,
						gamePanel.TILE_SIZE,gamePanel.TILE_SIZE,null);
			}
		}
	}
	public void update() {
		
	}
}
