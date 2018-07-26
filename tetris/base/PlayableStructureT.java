package base;

import java.awt.Color;

public class PlayableStructureT extends PlayableStructure {	
	private static final Color COLOR = new Color(255,69,0);
	public PlayableStructureT(int x, int y){
		super(x, y);
		Block[][] blocks = new Block[SIZE][SIZE];
		blocks[2][2] = new Block(COLOR);
		blocks[2][3] = new Block(COLOR);
		blocks[1][3] = new Block(COLOR);
		blocks[3][3] = new Block(COLOR);
		this.setBlocks(blocks);
	}
}
