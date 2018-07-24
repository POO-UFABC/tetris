package base;

import java.awt.Graphics;
import java.awt.Color;

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
		Block[][] blocks = new Block[width][height+3];
		
		//Preenche o "chão"
		for(int x = 0; x < width; x++){
			blocks[x][0] = new Block();
		}

		//Preenche as "paredes"
    	for(int y = 0; y < height; y++){
      		blocks[0][y] = new Block();
      		blocks[this.width - 1][y] = new Block();
    	}
		//Parede invisivel, evita que os blocos passem do limite
		for(int y = height; y < height+3; y++){
      		blocks[0][y] = new Block(Color.black);
      		blocks[this.width - 1][y] = new Block(Color.black);
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
		for(int x = 1; x < this.getWidth() - 1; x++)
			this.setBlock(x, mobileStructure.getPosY(), blocks[x-1][0]);
		mobileStructure.setBlocks(null);			
		//if (topLine > 0)
	}

	// Este método irá mesclar as Structures fixa e móvel (Somente para peças)
	public void addBlocks(PlayableStructure mobileStructure){
		Block[][] blocks = mobileStructure.getBlocks();

		//Copiar os blocos da peça
		int topLine = 0;
		int bottomLine = this.getHeight();
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++) {
				this.setBlock(i + mobileStructure.getPosX(), j + mobileStructure.getPosY(), blocks[i][j]);
			}
		}
		
		//Checando se completou uma linha
		for(int y = 1; y < this.getHeight(); y++){
			if(lineIsComplete(y)) {
				topLine = y;
				if(bottomLine > y) bottomLine = y;
				cleanLine(y);
			}
		}

		//Apagar os blocos da estrutura móvel
		mobileStructure.setBlocks(null);	

		//Se alguma linha foi apagada, topLine > 0
		if (topLine > 0) {
			//Todas as partes acima da linha apagada passam a ser móveis
			MobileStructure tempMobile;
			for (int y = bottomLine + 1; y < this.getHeight(); y++){
				//Vamos até bottomLine + 5 pois a peça mais alta tem 4 Blocks
				if(y < this.getHeight()){
					//Temos de verificar se não estamos verificando alto de mais
					tempMobile = new MobileStructure(1, y, swapBlocks(y));
					//swapBlock (ver código abaixo) devolve os Blocks naquela linha, e tira estes Blocks do null
					//basicamente trocamos (dai o swap) os Blocks de Structure
					while(tempMobile.getBlocks() != null){
						//Andamos o quanto dá
						tempMobile.moveY(1, this);
					}
				}
				//Chegado aqui, o trabalho desta linha está completo
			}
		}
	}

	private Block[][] swapBlocks(int linha){
		boolean hadBlock = false;
		Block[][] swappedBlock = new Block[this.getWidth()-2][1];
		for(int x = 1; x < this.getWidth() - 1; x++){
			//Da o Block para o Block trocado
			swappedBlock[x-1][0] = this.getBlocks()[x][linha];
			hadBlock = this.blockExists(x, linha) || hadBlock;
			//Tira o Block do fixo
			this.getBlocks()[x][linha] = null;
		}
		if(hadBlock)
			return swappedBlock;
		//Esse passo acelera o moveY.
		return null;
	}

	private void cleanLine(int linha){
		for (int x = 1; x < this.getWidth() - 1; x++){
			this.getBlocks()[x][linha] = null;
		}
	}

	public void setBlock(int x, int y, Block Block){
		if (Block != null) super.getBlocks()[x][y] = Block;
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
		for(int x = 1; x < this.getWidth()-2; x++)
			if (mobileStructure.blockExists(x, 0) && this.blockExists(x+1, posY-1)) return true;
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
