package base;

public class PecaL extends Peca {	
	//toda peça deve ser [5][5], tendo um bloco em [2][2], sendo este o pivot.
	public PecaL(String cor){
		super();
		Bloco[][] blocos = new Bloco[5][5];
		blocos[2][2] = new Bloco(cor);
		blocos[2][3] = new Bloco(cor);
		blocos[3][3] = new Bloco(cor);
		blocos[2][1] = new Bloco(cor);
		this.setBlocos(blocos);
	}
}