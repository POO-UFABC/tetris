package base;

public class PecaQuadrado extends Peca {	
	//toda peça deve ser [5][5], tendo um bloco em [2][2], sendo este o pivot.
	public PecaQuadrado(String cor){
		super();
		Bloco[][] blocos = new Bloco[5][5];
		blocos[2][2] = new Bloco(cor);
		blocos[3][2] = new Bloco(cor);
		blocos[2][1] = new Bloco(cor);
		blocos[3][1] = new Bloco(cor);
		this.setBlocos(blocos);
	}

	@Override
	public void rotacionar(EstruturaFixa fixa){
		//É importante que o quadrado tenha esse método, já que tudo fora da posição [2][2] irá rotacionar, e o quadrado não rotaciona
		return;
	}
}