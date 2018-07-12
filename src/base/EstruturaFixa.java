package base;

public class EstruturaFixa extends Estrutura {
	private int largura = 30;
	private int altura = 10;

	public EstruturaFixa(){
        Bloco[][] blocos = new Bloco[largura][altura];
        for(int x = 0; x < largura; x++){
            blocos[x][0] = new Bloco("0");
        }      
        for(int y = 0; y < altura; y++){
            blocos[0][y] = new Bloco("0");
            blocos[this.largura - 1][y] = new Bloco("0");
        }

        // Preenche o fixo com blocos formando um U
        // x    x       
        // x    x
        // x    x
		// xxxxxx
		
		super.setBlocos(blocos);
	}

	public int getLargura(){
		return this.largura;
	}

	public void setLargura(int largura){
		this.largura = largura;
	}

	public int getAltura(){
		return this.altura;
	}

	public void setAltura(int altura){
		this.altura = altura;
	}
    
	// Este método irá mesclar as estruturas fixa e móvel (Somente para peças)
	public void addBlocos(Peca movel){
		Bloco[][] blocos = movel.getBlocos();

		// Caso, no momento de mesclar, hajam linhas completas, deverá haver o deslocamento de quaisquer blocos acima da maior linha
		int maiorLinha = 0;
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				this.setBloco(i + movel.getPosX(), j + movel.getPosY(), blocos[i][j]);
		for(int y = 1; y < this.getAltura(); y++){
			if(linhaCompleta(y)) {
				System.out.println("Linha: " + y);
				maiorLinha = y;
				limpaLinha(y);
			}
		}
		movel.setBlocos(null);			
		if (maiorLinha > 0) {
			for (int y = maiorLinha; y > 0; y--){
				if (y == maiorLinha){
					//Código para fazer mover as linhas de cima.
					//Meu cérebro está com pane e não estou conseguindo tirar agora
					//O código vai rastrear linha por linha, fazendo mover as de cima.
				}
			}
		}
	}

	public void addBlocos(EstruturaMovel movel){
		Bloco[][] blocos = movel.getBlocos();
		for(int i = 0; i < 1; i++)
			for(int j = 1; j < this.getLargura(); j++)
				this.setBloco(i + movel.getPosX(), j + movel.getPosY(), blocos[i][j]);
		movel.setBlocos(null);			
		//if (maiorLinha > 0)
	}

	@Override
	public Bloco[][] getBlocos(){
		return super.getBlocos();
	}

	private void limpaLinha(int linha){
		for (int x = 1; x < this.getLargura() - 1; x++){
			super.getBlocos()[x][linha] = null;
		}
	}

	public void setBloco(int x, int y, Bloco bloco){
		//System.out.println(x + " " + y);
		if (bloco != null) super.getBlocos()[x][y] = bloco;
	}

	// Estaremos sempre passando as coisas para a estrutura fixa. Não tem porque termos métodos muito profundos no móvel, se ele sumirá assim que encontrar uma colisão.
	public boolean existeBlocoAbaixo(EstruturaMovel movel){
		int posX = movel.getPosX();
		int posY = movel.getPosY();
		// int largura = this.getLargura();
		// int altura = this.getAltura();
		//Por enquanto está iterando todos os blocos de móvel (que provavelmente serão, no máximo, 25 blocos). Talvez haja solução melhor
		for (int i = 0; i<5; i++)
			for(int j = 0; j<5; j++)
				if (movel.existeBloco(i, j) && this.existeBloco(posX + i, posY + j - 1)) return true;
		//Se em nenhum momento havia um bloco na móvel, com um bloco diretamente abaixo na fixa, ele retornará falso.
		return false;
    }
    
	//Outro método específico da fixa (e portanto, deverá ser interpretado da perspectiva da estrutura fixa.)
	public boolean linhaCompleta(int linha){
		//Iteremos pela linha
		for(int i = 0; i < this.getLargura(); i++){
			// Se não existir bloco em alguma parte da linha, retorna falso (linha incompleta)
			if (!this.existeBloco(i, linha)) return false;
			// Se passou por todos os testes, linha completa, retorna true;
		}			
		return true;
	}

	@Override
	public boolean existeBloco(int x, int y){
		try{
			return (this.getBlocos()[x][y] != null);
		}
		catch (Exception e){
			if (this.getAltura() > y) return true;
			return false;
		}		
	}
}
