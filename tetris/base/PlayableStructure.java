package base;

import java.awt.Graphics;

public class PlayableStructure extends MobileStructure {
	/**
	* toda peça devem ser [5][5], sendo Block [2][2] o pivot.
	*/
	protected static final int SIZE = 5;

	/**
	*Super deverá chamar com Largura/2-2 e Altura-3, sendo Largura e Altura atributos da Structure Fixa.
	*Não é necessário chamar da própria Structure fixa pois esse tamanho será definido ainda no desenvolvimento e não será modificado.
	*/
	public PlayableStructure(Block[][] components){
		super(SIZE, SIZE, components);
	}
	
	/**Método chamado quando a estrutura móvel é gerada aleatóriamente */
	public PlayableStructure(int x, int y){
		super(x, y, null);
	}

	/**Métodos temporários, serão implementados numa interface para cumprir os requerimentos */
	public void moveX(int deltaX, FixedStructure fixedStructure){
		// Move
		super.setPosX(getPosX() + deltaX);
		// Se há superposição (peça entrou "dentro" da fixa) 
		if (existsSuperposition(fixedStructure, this)) 
			// Volta para posição original
			super.setPosX(getPosX() - deltaX);
	}

	
	private boolean gameOver(FixedStructure fixedStructure) {
		Block[][] newBlocks = this.getBlocks();
		for (int i = 0; i < SIZE; i++){
			for (int j = 0; j < SIZE; j++){
				if ((newBlocks[i][j] != null) && (j+this.getPosY() >= fixedStructure.getHeight())){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean moveY(int deltaY, FixedStructure fixedStructure){
		if (fixedStructure.blockExistsDown(this)){
			if (this.gameOver(fixedStructure))
				return true;
			fixedStructure.addBlocks(this);
		}
		this.setPosY(this.getPosY() - deltaY);
		return false;
	}
	
	/**Qualquer rotação (ao tomarmos um pivot posicionado em (2,2)) é facilmente representada como (y, 4-x) */
	public void rotate(FixedStructure fixedStructure){
		Block[][] tempBlock = new Block[5][5];
		Block[][] localBlocks = super.getBlocks();
		for(int x = 0; x < SIZE; x++)
			for(int y = 0; y < SIZE; y++)
				tempBlock[y][4-x] = localBlocks[x][y];
		//Antes de setarmos a peça rotacionada como verdadeira, devemos verificar se há algum choque entre a Structure fixa e a peca
		//É um método parecido com o método de verificar se há algum Block abaixo, porém este verificará se há Blocks exatamente onde os Blocks da nova peça estão.
		if (!existsSuperposition(fixedStructure, tempBlock))
			//Somente se não há superposição da fixa com o Block girado que o giro será feito
			super.setBlocks(tempBlock);
	}
	
	private boolean existsSuperposition(FixedStructure fixedStructure, PlayableStructure PlayableStructure){
		return existsSuperposition(fixedStructure, PlayableStructure.getBlocks());
	}
	
	private boolean existsSuperposition(FixedStructure fixedStructure, Block[][] tempBlock){
		int posX = this.getPosX();
		int posY = this.getPosY();
		for(int i = 0; i < SIZE; i++)
			for(int j = 0; j < SIZE; j++){
				if(fixedStructure.blockExists(posX + i, posY + j)){
					if(tempBlock[i][j] != null){
						return true;
					}						
				}
			}		
		return false;
	}

	public void render(int displayHeight, Graphics g) {
		if (this.getBlocks() == null)
			return;
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				Block b = this.getBlocks()[x][y];
				if (b != null){
					int px = this.getPosX()*Block.getSIDE() + x * Block.getSIDE();
					int py = displayHeight - Block.getSIDE() - ((this.getPosY()*Block.getSIDE()) + (y*Block.getSIDE()));
					b.render(px, py, g);
				}
			}
		}
	}
}
