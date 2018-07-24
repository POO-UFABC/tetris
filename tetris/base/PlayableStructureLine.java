package base;

import java.awt.Color;

public class PlayableStructureLine extends PlayableStructure {	
	private static final Color COLOR = Color.pink;
	public PlayableStructureLine(int x, int y){
		super(x, y);
		Block[][] Blocks = new Block[SIZE][SIZE];
		Blocks[2][2] = new Block(COLOR);
		Blocks[1][2] = new Block(COLOR);
		Blocks[3][2] = new Block(COLOR);
		Blocks[4][2] = new Block(COLOR);
		this.setBlocks(Blocks);
	}
}
