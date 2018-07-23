package base;

import java.awt.Color;

public class PlayableStructureT extends PlayableStructure {	
	private static final Color color = Color.orange;
	public PlayableStructureT(int x, int y){
		super(x, y);
		Block[][] Blocks = new Block[size][size];
		Blocks[2][2] = new Block(color);
		Blocks[2][3] = new Block(color);
		Blocks[1][3] = new Block(color);
		Blocks[3][3] = new Block(color);
		this.setBlocks(Blocks);
	}
}