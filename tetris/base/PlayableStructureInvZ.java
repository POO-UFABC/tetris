package base;

import java.awt.Color;

public class PlayableStructureInvZ extends PlayableStructure {	
	private static final Color color = Color.yellow;
	public PlayableStructureInvZ(int x, int y){
		super(x, y);
		Block[][] Blocks = new Block[size][size];
		Blocks[2][2] = new Block(color);
		Blocks[2][1] = new Block(color);
		Blocks[3][1] = new Block(color);
		Blocks[1][2] = new Block(color);
		this.setBlocks(Blocks);
	}
}