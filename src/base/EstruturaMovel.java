package base;

public class EstruturaMovel extends Estrutura {
    private int posX;
    private int posY;

	public int getPosX(){
		return this.posX;
	}

	public void setPosX(int posX){
		this.posX = posX;
	}

	public int getPosY(){
		return this.posY;
	}

	public void setPosY(int posY){
		this.posY = posY;
	}
	
	public EstruturaMovel(int posX, int posY, Bloco[][] blocos){
		super.setBlocos(blocos);
		this.setPosX(posX);
		this.setPosY(posY);
	}

	//Qualquer rotação (ao tomarmos um pivot posicionado em (2,2)) é facilmente apontada como (y, 4-x)
	public void rotacionar(){
		Bloco[][] tempBloco = new Bloco[5][5];
		Bloco[][] thisBlocos = this.getBlocos();
		for(int x = 0; x < 5; x++)
			for(int y = 0; y < 5; y++)
				tempBloco[y][4-x] = thisBlocos[x][y];
		this.setBlocos(tempBloco);
	}

	//Métodos temporários, serão implementados numa interface para cumprir os requerimentos (ou simplesmente serão métodos da Sub Classe Estrutura Móvel)
	//Provavelmente serão transformadas em boolean para poder executar o existeBlocoAbaixo(). Se existir, não anda e sim mescla os blocos.
	public void andaX(int x, EstruturaFixa fixa) {
		//Se x for positivo, escanear a coluna da direita para achar os blocos
		//Sempre que existir um bloco na coluna da direita (ou esquerda), verificar, naquela posição (x + posX +-1, y + posY), se existe bloco
		//Se existir, em algum ponto, retorna falso;
		setPosX(getPosX() + x);
	}

	// Método móvel
	public void andaY(int y, EstruturaFixa fixa) {
		if (fixa.existeBlocoAbaixo(this)){
			fixa.addBlocos(this);
		} 		
		this.setPosY(this.getPosY() - y);
	}
}
