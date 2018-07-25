package base;

import java.awt.Color;

public class PlayableStructureInvZ extends PlayableStructure {	
	private static final Color COLOR = Color.yellow;
	public PlayableStructureInvZ(int x, int y){
		super(x, y);
		Block[][] blocks = new Block[SIZE][SIZE];
		blocks[2][2] = new Block(COLOR);
		blocks[2][1] = new Block(COLOR);
		blocks[3][1] = new Block(COLOR);
		blocks[1][2] = new Block(COLOR);
		this.setBlocks(blocks);
	}
}
