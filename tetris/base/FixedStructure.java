package base;

import java.awt.Graphics;

public class FixedStructure extends Structure {
	private static int DEFAULT_WIDTH = 10;
	private static int DEFAULT_HEIGHT = 20;

	private int width;
	private int height;

	//Criar uma estrutura em forma de U (para quando o jogo acaba de começar)
	public FixedStructure(int posX, int posY, int width, int height){
		//Cria a matriz de blocos
		this.width = width;
		this.height = height;
		Block[][] blocks = new Block[width][height];
		
		//Preenche o "chão"
		for(int x = 0; x < width; x++){
			blocks[x][0] = new Block();
		}

		//Preenche as "paredes"
    	for(int y = 0; y < height; y++){
      		blocks[0][y] = new Block();
      		blocks[this.width - 1][y] = new Block();
    	}
		super.setBlocks(blocks);
		super.setPosX(posX);
		super.setPosY(posY);
	}

	public FixedStructure() {
		this(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	//Copia blocos de uma estrutura móvel para a estrutura fixa
	public void addBlocks(MobileStructure mobileStructure){
		Block[][] blocks = mobileStructure.getBlocks();
		for(int x = 0; x < blocks.length; x++){
			for(int y = 1; y < blocks[0].length; y++){
				this.setBlock(x + mobileStructure.getPosX(), y + mobileStructure.getPosY(), blocks[x][y]);
			}
		}
		
		mobileStructure.setBlocks(null);	
		
		lineIsCompleteProcedure();
		//if (topLine > 0)
	}

	// Este método irá mesclar as Structures fixa e móvel (Somente para peças)
	public void addBlocks(PlayableStructure mobileStructure){
		Block[][] blocks = mobileStructure.getBlocks();

		//Copiar os blocos da peça
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++) {
				this.setBlock(i + mobileStructure.getPosX(), j + mobileStructure.getPosY(), blocks[i][j]);
			}
		}
		
		//Apagar os blocos da estrutura móvel
		mobileStructure.setBlocks(null);	

		lineIsCompleteProcedure();

	}

	private void lineIsCompleteProcedure(){
		int topLine = 0;
		int bottomLine = this.getHeight();
	
		//Checando se completou uma linha
		for(int y = 1; y < this.getHeight(); y++){
			if(lineIsComplete(y)) {
				topLine = y;
				if(bottomLine > y) bottomLine = y;
				cleanLine(y);
			}
		}
		//Se alguma linha foi apagada, topLine > 0
		if (topLine > 0) {
			//Todas as partes acima da linha apagada passam a ser móveis
			MobileStructure[] tempMobile = new MobileStructure[20];
			int tMobileIndex = 0;
			for(int y = bottomLine+1;y<this.getHeight();y++){
				for(int x = 1; x< this.getWidth()-1;x++){
									
					//Existe um bloco no ponto, não existe
					if(this.blockExists(x,y)){
						tempMobile[tMobileIndex] = new MobileStructure(0,0,floodFill(x,y));
						tMobileIndex += 1;
					}
				}
			}
			for (int i = 0; i < tMobileIndex; i++){
				while(tempMobile[i].getBlocks() != null){
					tempMobile[i].moveY(1,this);					
				}					
			}
		}
	}

	private Block[][] floodFill(int x, int y) {
		//Cabe qualquer coisa
		int tempWidth = this.getWidth();
		int tempHeight = this.getHeight();
		
		Block[][] tempBlock = new Block[tempWidth][tempHeight];
		tempBlock[x][y] = this.getBlocks()[x][y];
		this.getBlocks()[x][y] = null;
		if (this.blockExists(x+1, y) && x != this.getWidth()-2)
			tempBlock = floodFillNext(tempBlock,x+1,y,x+1,y);
		if (this.blockExists(x, y+1) && y != this.getHeight()-1)	
			tempBlock = floodFillNext(tempBlock,x,y+1,x,y+1);
		return tempBlock;
	}
	private Block[][] floodFillNext(Block[][] tempBlock, int x, int y, int xIndex, int yIndex){
		tempBlock[xIndex][yIndex] = this.getBlocks()[x][y];
		super.getBlocks()[x][y] = null;
		if(this.blockExists(x+1, y) && x != this.getWidth() - 2)
			tempBlock = floodFillNext(tempBlock,x+1,y,xIndex+1,yIndex);
		if(this.blockExists(x-1, y) && x > 1)
			tempBlock = floodFillNext(tempBlock,x-1,y,xIndex-1,yIndex);
		if(this.blockExists(x, y+1) && y != this.getHeight()-1)
			tempBlock = floodFillNext(tempBlock,x,y+1,xIndex,yIndex+1);
		if(this.blockExists(x, y-1) && y > 1)
			tempBlock = floodFillNext(tempBlock,x,y-1,xIndex,yIndex-1);
		return tempBlock;
	}

	

	private void cleanLine(int linha){
		for (int x = 1; x < this.getWidth() - 1; x++){
			this.getBlocks()[x][linha] = null;
		}
	}

	public void setBlock(int x, int y, Block block){
		if (block != null) super.getBlocks()[x][y] = block;
	}

	// Estaremos sempre passando as coisas para a Structure fixa. 
	// Não tem porque termos métodos muito profundos no móvel, se ele sumirá assim que encontrar uma colisão.
	public boolean blockExistsDown(PlayableStructure mobileStructure){
		int posX = mobileStructure.getPosX();
		int posY = mobileStructure.getPosY();
		//Por enquanto está iterando todos os Blocks de móvel (que provavelmente serão, no máximo, 25 Blocks). Talvez haja solução melhor
		for (int i = 0; i<5; i++)
			for(int j = 0; j<5; j++)
				if (mobileStructure.blockExists(i, j) && this.blockExists(posX + i, posY + j - 1))
					return true;
		//Se em nenhum momento havia um Block na móvel, com um Block diretamente abaixo na fixa, ele retornará falso.
		return false;
	}

	public boolean blockExistsDown(MobileStructure mobileStructure){
		int posX = mobileStructure.getPosX();
		int posY = mobileStructure.getPosY();
		//Por enquanto está iterando todos os Blocks de móvel (que provavelmente serão, no máximo, 25 Blocks). Talvez haja solução melhor
		for(int x = 1; x < this.getWidth()-1; x++){
			for(int y = 1; y < this.getWidth()-1; y++){
				if (mobileStructure.blockExists(x, y) && this.blockExists(x, y+posY-1)) {
					return true;
				}
			}
		}
			
		//Se em nenhum momento havia um Block na móvel, com um Block diretamente abaixo na fixa, ele retornará falso.
		return false;
    }

	public boolean lineIsComplete(int linha){
		//Iteremos pela linha
		for(int i = 0; i < this.getWidth(); i++){
			// Se não existir Block em alguma parte da linha, retorna falso (linha incompleta)
			if (!this.blockExists(i, linha)) return false;
			// Se passou por todos os testes, linha completa, retorna true;
		}			
		return true;
	}

	public void render(int displayHeight, Graphics g) {
		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {
				Block b = this.getBlocks()[x][y];
				if (b != null){
					int px = (this.getPosX()*b.side) + (x * b.side);
					int py = displayHeight - b.side - ((this.getPosY()*b.side) + (y * b.side));
					b.render(px, py, g);
				}
			}
		}
	}

	@Override
	public boolean blockExists(int x, int y){
		try{
			return (this.getBlocks()[x][y] != null);
		}
		catch (Exception e){
			if (this.getHeight() > y) return true;
			return false;
		}
	}

	public int getWidth(){
		return this.width;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getHeight(){
		return this.height;
	}

	public void setHeight(int height){
		this.height = height;
	}

}
