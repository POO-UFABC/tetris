package base;

import java.awt.Color;

public class PlayableStructureInvL extends PlayableStructure {	
	private static final Color COLOR = Color.blue;
	public PlayableStructureInvL(int x, int y){
		super(x, y);
		Block[][] blocks = new Block[SIZE][SIZE];
		blocks[2][2] = new Block(COLOR);
		blocks[2][3] = new Block(COLOR);
		blocks[1][3] = new Block(COLOR);
		blocks[2][1] = new Block(COLOR);
		this.setBlocks(blocks);
	}
}
