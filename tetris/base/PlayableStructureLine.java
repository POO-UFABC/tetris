package base;

import java.awt.Color;

public class PlayableStructureLine extends PlayableStructure {	
	private static final Color color = Color.pink;
	public PlayableStructureLine(int x, int y){
		super(x, y);
		Block[][] Blocks = new Block[size][size];
		Blocks[2][2] = new Block(color);
		Blocks[1][2] = new Block(color);
		Blocks[3][2] = new Block(color);
		Blocks[4][2] = new Block(color);
		this.setBlocks(Blocks);
	}
}