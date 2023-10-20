package Levels;

public class Level {
	
	int levelData[][];
	
	public Level(int lvlData[][]) {
		this.levelData = lvlData;
	}
	
	public int getSpriteIndex(int x ,int y) {
		return levelData[y][x];
	}
}
