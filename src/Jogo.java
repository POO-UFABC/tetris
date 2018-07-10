import base.*;

public class Jogo {

	public static void main(String[] args) {
		EstruturaFixa fixa = new EstruturaFixa();
		
		Bloco[][] pecinha = new Bloco[5][5];
		pecinha[2][2] = new Bloco("x");
		pecinha[3][2] = new Bloco("x");
		pecinha[4][2] = new Bloco("x");
		pecinha[1][2] = new Bloco("x");

		//  xx 
		// xx

		Peca peca = new Peca(pecinha);
		peca.andaX(-13, fixa);
		while(peca.getBlocos() != null){
			printarCena(fixa, peca);
			peca.andaY(1, fixa);
		}
		printarCena(fixa);

		peca = new Peca(pecinha);	
		peca.andaX(-9, fixa);
		while(peca.getBlocos() != null){
			printarCena(fixa, peca);
			peca.andaY(1, fixa);
		}
		printarCena(fixa);

		peca = new Peca(pecinha);	
		peca.andaX(-5, fixa);
		while(peca.getBlocos() != null){
			printarCena(fixa, peca);
			peca.andaY(1, fixa);
		}
		printarCena(fixa);

		peca = new Peca(pecinha);	
		peca.andaX(-1, fixa);
		while(peca.getBlocos() != null){
			printarCena(fixa, peca);
			peca.andaY(1, fixa);
		}
		printarCena(fixa);

		peca = new Peca(pecinha);	
		peca.andaX(3, fixa);
		while(peca.getBlocos() != null){
			printarCena(fixa, peca);
			peca.andaY(1, fixa);
		}
		printarCena(fixa);

		peca = new Peca(pecinha);	
		peca.andaX(7, fixa);
		while(peca.getBlocos() != null){
			printarCena(fixa, peca);
			peca.andaY(1, fixa);
		}
		printarCena(fixa);

		peca = new Peca(pecinha);
		peca.andaX(-13, fixa);
		while(peca.getBlocos() != null){
			printarCena(fixa, peca);
			peca.andaY(1, fixa);
		}
		printarCena(fixa);

		peca = new Peca(pecinha);	
		peca.andaX(-9, fixa);
		while(peca.getBlocos() != null){
			printarCena(fixa, peca);
			peca.andaY(1, fixa);
		}
		printarCena(fixa);

		peca = new Peca(pecinha);	
		peca.andaX(-5, fixa);
		while(peca.getBlocos() != null){
			printarCena(fixa, peca);
			peca.andaY(1, fixa);
		}
		printarCena(fixa);

		peca = new Peca(pecinha);	
		peca.andaX(-1, fixa);
		while(peca.getBlocos() != null){
			printarCena(fixa, peca);
			peca.andaY(1, fixa);
		}
		printarCena(fixa);

		peca = new Peca(pecinha);	
		peca.andaX(3, fixa);
		while(peca.getBlocos() != null){
			printarCena(fixa, peca);
			peca.andaY(1, fixa);
		}
		printarCena(fixa);

		peca = new Peca(pecinha);	
		peca.andaX(7, fixa);
		while(peca.getBlocos() != null){
			printarCena(fixa, peca);
			peca.andaY(1, fixa);
		}
		printarCena(fixa);

		pecinha[2][3] = new Bloco("x");
		pecinha[3][3] = new Bloco("x");
		pecinha[4][3] = new Bloco("x");
		pecinha[1][3] = new Bloco("x");

		peca = new Peca(pecinha);	
		peca.andaX(11, fixa);
		while(peca.getBlocos() != null){
			printarCena(fixa, peca);
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
				str = str + (blocos[x][y] == null ? " " : blocos[x][y]);
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
				if (x >= peca.getPosX() && x < peca.getPosX() + 5 && y >= peca.getPosY() && y < peca.getPosY() + 5){
					str = str + (blocosMovel[x - peca.getPosX()][y - peca.getPosY()] == null ? " " : blocosMovel[x - peca.getPosX()][y - peca.getPosY()]);
				}
				else{
					str = str + (blocosFixa[x][y] == null ? " " : "0");
				}				
			}				
			System.out.println(str);
			str = "";
		}
		System.out.println(str);		
	}
}
