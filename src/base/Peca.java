package base;

public class Peca extends EstruturaMovel {
	
	//toda peca deve ser [5][5], tendo um bloco em [2][2], sendo este o pivot.
	public Peca(Bloco[][] bloco){
		super(30/2 - 2, 10 - 3, bloco);
	}

	@Override
	public Bloco[][] getBlocos(){
		return super.getBlocos();
	}
	
	//Qualquer rotação (ao tomarmos um pivot posicionado em (2,2)) é facilmente apontada como (y, 4-x)
	public void rotacionar(){
		Bloco[][] tempBloco = new Bloco[5][5];
		Bloco[][] thisBlocos = super.getBlocos();
		for(int x = 0; x < 5; x++)
			for(int y = 0; y < 5; y++)
				tempBloco[y][4-x] = thisBlocos[x][y];
		super.setBlocos(tempBloco);
	}
}
