package base;

import java.awt.Color;

public class PlayableStructureL extends PlayableStructure {
	private static final Color COLOR = Color.red;
	public PlayableStructureL(int x, int y){
		super(x, y);
		Block[][] blocks = new Block[SIZE][SIZE];
		Blocks[2][2] = new Block(COLOR);
		Blocks[2][3] = new Block(COLOR);
		Blocks[3][3] = new Block(COLOR);
		Blocks[2][1] = new Block(COLOR);
		this.setBlocks(blocks);
	}
}
