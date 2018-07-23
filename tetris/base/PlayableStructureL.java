package base;

import java.awt.Color;

public class PlayableStructureL extends PlayableStructure {
	private static final Color color = Color.red;
	public PlayableStructureL(int x, int y){
		super(x, y);
		Block[][] Blocks = new Block[size][size];
		Blocks[2][2] = new Block(color);
		Blocks[2][3] = new Block(color);
		Blocks[3][3] = new Block(color);
		Blocks[2][1] = new Block(color);
		this.setBlocks(Blocks);
	}
}
