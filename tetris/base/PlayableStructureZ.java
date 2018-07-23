package base;

import java.awt.Color;

public class PlayableStructureZ extends PlayableStructure {	
	private static final Color color = Color.green;
	public PlayableStructureZ(int x, int y){
		super(x, y);
		Block[][] Blocks = new Block[size][size];
		Blocks[2][2] = new Block(color);
		Blocks[3][2] = new Block(color);
		Blocks[1][1] = new Block(color);
		Blocks[2][1] = new Block(color);
		this.setBlocks(Blocks);
	}
}