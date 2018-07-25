package base;

import java.awt.Color;

public class PlayableStructureZ extends PlayableStructure {	
	private static final Color COLOR = Color.green;
	public PlayableStructureZ(int x, int y){
		super(x, y);
		Block[][] blocks = new Block[SIZE][SIZE];
		blocks[2][2] = new Block(COLOR);
		blocks[3][2] = new Block(COLOR);
		blocks[1][1] = new Block(COLOR);
		blocks[2][1] = new Block(COLOR);
		this.setBlocks(blocks);
	}
}
