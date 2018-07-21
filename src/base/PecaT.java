package base;

public class PecaT extends Peca {	
	//toda peça deve ser [5][5], tendo um bloco em [2][2], sendo este o pivot.
	public PecaT(String cor){
		super();
		Bloco[][] blocos = new Bloco[5][5];
		blocos[2][2] = new Bloco(cor);
		blocos[2][3] = new Bloco(cor);
		blocos[1][3] = new Bloco(cor);
		blocos[3][3] = new Bloco(cor);
		this.setBlocos(blocos);
	}
}