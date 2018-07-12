package base;

public class Peca extends EstruturaMovel {
	
	//toda peça deve ser [5][5], tendo um bloco em [2][2], sendo este o pivot.
	public Peca(Bloco[][] bloco){
		super(30/2 - 2, 10 - 3, bloco);
	}

	//Métodos temporários, serão implementados numa interface para cumprir os requerimentos (ou simplesmente serão métodos da Sub Classe Estrutura Móvel)
	public void andaX(int x, EstruturaFixa fixa) {
		// Move
		super.setPosX(getPosX() + x);
		// Se há superposição (peça entrou "dentro" da fixa) 
		if (haSuperposicao(fixa, this)) 
			// Volta para posição original
			super.setPosX(getPosX() - x);
	}
	
	//Qualquer rotação (ao tomarmos um pivot posicionado em (2,2)) é facilmente apontada como (y, 4-x)
	public void rotacionar(EstruturaFixa fixa){
		Bloco[][] tempBloco = new Bloco[5][5];
		Bloco[][] thisBlocos = super.getBlocos();
		for(int x = 0; x < 5; x++)
			for(int y = 0; y < 5; y++)
				tempBloco[y][4-x] = thisBlocos[x][y];
		//Antes de setarmos a peça rotacionada como verdadeira, devemos verificar se há algum choque entre a estrutura fixa e a peca
		//É um método parecido com o método de verificar se há algum bloco abaixo, porém este verificará se há blocos exatamente onde os blocos da nova peça estão.
		if (!haSuperposicao(fixa, tempBloco))
			//Somente se não há superposição da fixa com o bloco girado que o giro será feito
			super.setBlocos(tempBloco);
	}
	
	private boolean haSuperposicao(EstruturaFixa fixa, Peca peca){
		return haSuperposicao(fixa, peca.getBlocos());
	}
	private boolean haSuperposicao(EstruturaFixa fixa, Bloco[][] tempBloco){
		int posX = this.getPosX();
		int posY = this.getPosY();
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++){
				if(fixa.existeBloco(posX + i, posY + j)){
					if(tempBloco[i][j] != null){
						System.out.println(i + " " + j + " " + posX + " " + posY);
						return true;
					}						
				}
			}				
		return false;
	}
}
