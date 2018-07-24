package base;

import java.awt.Color;

public class PlayableStructureZ extends PlayableStructure {	
	private static final Color COLOR = Color.green;
	public PlayableStructureZ(int x, int y){
		super(x, y);
		Block[][] blocks = new Block[SIZE][SIZE];
		Blocks[2][2] = new Block(COLOR);
		Blocks[3][2] = new Block(COLOR);
		Blocks[1][1] = new Block(COLOR);
		Blocks[2][1] = new Block(COLOR);
		this.setBlocks(blocks);
	}
}
