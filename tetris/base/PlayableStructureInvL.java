package base;

import java.awt.Color;

public class PlayableStructureInvL extends PlayableStructure {	
	private static final Color color = Color.blue;
	public PlayableStructureInvL(int x, int y){
		super(x, y);
		Block[][] Blocks = new Block[size][size];
		Blocks[2][2] = new Block(color);
		Blocks[2][3] = new Block(color);
		Blocks[1][3] = new Block(color);
		Blocks[2][1] = new Block(color);
		this.setBlocks(Blocks);
	}
}