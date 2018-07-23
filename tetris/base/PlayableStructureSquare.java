package base;

import java.awt.Color;

public class PlayableStructureSquare extends PlayableStructure {	
	private static final Color color = Color.cyan;
	public PlayableStructureSquare(int x, int y){
		super(x, y);
		Block[][] Blocks = new Block[size][size];
		Blocks[2][2] = new Block(color);
		Blocks[3][2] = new Block(color);
		Blocks[2][1] = new Block(color);
		Blocks[3][1] = new Block(color);
		this.setBlocks(Blocks);
	}

	@Override
	public void rotate(FixedStructure fixedStructure){
		//É importante que o quadrado tenha esse método, já que tudo fora da posição [2][2] irá rotate, e o quadrado não rotaciona
		return;
	}
}