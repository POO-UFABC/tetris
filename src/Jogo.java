import base.*;

public class Jogo {

	public static void main(String[] args) {
		Estrutura movel = new Estrutura(0,1);
		Estrutura fixa = new Estrutura();

		Bloco[][] blocos = new Bloco[5][5];
		for(int i = 0; i<5; i++)
			for(int j = 0; j<5;j++)
				blocos[i][j] = new Bloco("#000000");
		movel.setBlocos(blocos);
		
		blocos = null;

		blocos = new Bloco[30][100];
		blocos[0][0] = new Bloco("#FF");
		fixa.setBlocos(blocos);

		System.out.println(movel.existeBlocoAbaixo(fixa));
	}
}
