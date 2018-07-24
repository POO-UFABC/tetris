package base;

import java.awt.Color;

public class PlayableStructureInvZ extends PlayableStructure {	
	private static final Color COLOR = Color.yellow;
	public PlayableStructureInvZ(int x, int y){
		super(x, y);
		Block[][] Blocks = new Block[SIZE][SIZE];
		Blocks[2][2] = new Block(COLOR);
		Blocks[2][1] = new Block(COLOR);
		Blocks[3][1] = new Block(COLOR);
		Blocks[1][2] = new Block(COLOR);
		this.setBlocks(Blocks);
	}
}
