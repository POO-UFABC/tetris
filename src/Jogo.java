import base.*;

public class Jogo {

	public static void main(String[] args) {
		EstruturaFixa fixa = new EstruturaFixa();
		
		Peca peca = new PecaL("+");

		while(peca.getBlocos() != null){
			printarCena(fixa, peca);
			//peca.andaX(1, fixa);
			peca.andaY(1, fixa);
		}
		printarCena(fixa);

		peca = new PecaZ("+");

		while(peca.getBlocos() != null){
			printarCena(fixa, peca);
			//peca.andaX(1, fixa);
			peca.andaY(1, fixa);
		}
		printarCena(fixa);

		peca = new PecaZ("+");
		peca.rotacionar(fixa);

		while(peca.getBlocos() != null){
			printarCena(fixa, peca);
			//peca.andaX(1, fixa);
			peca.andaY(1, fixa);
		}
		printarCena(fixa);

		peca = new PecaT("+");
		peca.rotacionar(fixa);

		while(peca.getBlocos() != null){
			printarCena(fixa, peca);
			peca.andaX(1, fixa);
			peca.andaY(1, fixa);
		}
		printarCena(fixa);

		peca = new PecaQuadrado("+");		

		while(peca.getBlocos() != null){
			printarCena(fixa, peca);
			peca.rotacionar(fixa);
			peca.andaX(1, fixa);
			peca.andaY(1, fixa);
		}
		printarCena(fixa);



	}

	public static void printarPecinha(Peca peca){
		Bloco[][] pecinha = peca.getBlocos();
		String str = "";
		for (int y = 4; y > -1; y--){
			for (int x = 0; x < 4; x++)
				str = str + (pecinha[x][y] == null ? " " : pecinha[x][y]);
			System.out.println(str);
			str = "";
		}		
	}

	public static void printarCena(EstruturaFixa fixa){
		Bloco[][] blocos = fixa.getBlocos();
		String str = "";
		for (int y = fixa.getAltura() - 1; y > -1; y--){
			for (int x = 0; x < fixa.getLargura(); x++){
				//System.out.println(x + ", " + y);
				str = str + (blocos[x][y] == null ? " " : ".");
			}				
			System.out.println(str);
			str = "";
		}		
	}

	public static void printarCena(EstruturaFixa fixa, Peca peca){
		Bloco[][] blocosFixa = fixa.getBlocos();
		Bloco[][] blocosMovel = peca.getBlocos();
		String str = "";
		for (int y = fixa.getAltura() - 1; y > -1; y--){
			for (int x = 0; x < fixa.getLargura(); x++){
				//System.out.println(x + ", " + y);
				if (x >= peca.getPosX() && x < peca.getPosX() + 5 && y >= peca.getPosY() && y < peca.getPosY() + 5 && peca.existeBloco(x - peca.getPosX(), y - peca.getPosY())){
					str = str + (blocosMovel[x - peca.getPosX()][y - peca.getPosY()] == null ? " " : blocosMovel[x - peca.getPosX()][y - peca.getPosY()]);
				}
				else{
					str = str + (blocosFixa[x][y] == null ? " " : ".");
				}				
			}				
			System.out.println(str);
			str = "";
		}
		System.out.println(str);		
	}
}
