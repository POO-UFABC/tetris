package base;

import java.awt.Color;

public class PlayableStructureLine extends PlayableStructure {	
	private static final Color COLOR = new Color(255,20,147);
	public PlayableStructureLine(int x, int y){
		super(x, y);
		Block[][] blocks = new Block[SIZE][SIZE];
		blocks[2][2] = new Block(COLOR);
		blocks[1][2] = new Block(COLOR);
		blocks[3][2] = new Block(COLOR);
		blocks[4][2] = new Block(COLOR);
		this.setBlocks(blocks);
	}
}
