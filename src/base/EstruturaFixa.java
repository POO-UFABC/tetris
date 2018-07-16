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
		int menorLinha = this.getAltura();
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				this.setBloco(i + movel.getPosX(), j + movel.getPosY(), blocos[i][j]);
		for(int y = 1; y < this.getAltura(); y++){
			if(linhaCompleta(y)) {
				maiorLinha = y;
				if(menorLinha > y) menorLinha = y;
				limpaLinha(y);
			}
		}
		movel.setBlocos(null);			
		if (maiorLinha > 0) {
			//Significa que houve algum "Apagamento"
			EstruturaMovel tempMovel;
			for (int y = menorLinha + 1; y < this.getAltura(); y++){
				//Vamos até menorLinha + 5 pois a peça mais alta tem 4 blocos
				if(y < this.getAltura()){
					//Temos de verificar se não estamos verificando alto de mais
					tempMovel = new EstruturaMovel(1, y, swapBlocos(y));
					//swapBloco (ver código abaixo) devolve os blocos naquela linha, e tira estes blocos do null
					//basicamente trocamos (dai o swap) os blocos de estrutura
					while(tempMovel.getBlocos() != null){
						//Andamos o quanto dá
						//printarCena(this, tempMovel);
						tempMovel.andaY(1, this);
					} 						
				}
				//Chegado aqui, o trabalho desta linha está completo
			}
		}
	}

	private Bloco[][] swapBlocos(int linha){
		boolean houveBloco = false;
		Bloco[][] blocoTrocado = new Bloco[this.getLargura()-2][1];
		for(int x = 1; x < this.getLargura() - 1; x++){
			//Da o bloco para o bloco trocado
			blocoTrocado[x-1][0] = this.getBlocos()[x][linha];
			houveBloco = this.existeBloco(x, linha) || houveBloco;
			//Tira o bloco do fixo
			this.getBlocos()[x][linha] = null;
		}
		if(houveBloco)	
			return blocoTrocado;
		//Esse passo acelera o andaY.
		return null;
	}

	public void addBlocos(EstruturaMovel movel){
		Bloco[][] blocos = movel.getBlocos();
		for(int x = 1; x < this.getLargura() - 1; x++)
			this.setBloco(x, movel.getPosY(), blocos[x-1][0]);
		movel.setBlocos(null);			
		//if (maiorLinha > 0)
	}

	@Override
	public Bloco[][] getBlocos(){
		return super.getBlocos();
	}

	private void limpaLinha(int linha){
		for (int x = 1; x < this.getLargura() - 1; x++){
			this.getBlocos()[x][linha] = null;
		}
	}

	public void setBloco(int x, int y, Bloco bloco){
		if (bloco != null) super.getBlocos()[x][y] = bloco;
	}

	// Estaremos sempre passando as coisas para a estrutura fixa. 
	// Não tem porque termos métodos muito profundos no móvel, se ele sumirá assim que encontrar uma colisão.
	public boolean existeBlocoAbaixo(Peca movel){
		int posX = movel.getPosX();
		int posY = movel.getPosY();
		//Por enquanto está iterando todos os blocos de móvel (que provavelmente serão, no máximo, 25 blocos). Talvez haja solução melhor
		for (int i = 0; i<5; i++)
			for(int j = 0; j<5; j++)
				if (movel.existeBloco(i, j) && this.existeBloco(posX + i, posY + j - 1)) return true;
		//Se em nenhum momento havia um bloco na móvel, com um bloco diretamente abaixo na fixa, ele retornará falso.
		return false;
	}
	public boolean existeBlocoAbaixo(EstruturaMovel movel){
		int posX = movel.getPosX();
		int posY = movel.getPosY();
		//Por enquanto está iterando todos os blocos de móvel (que provavelmente serão, no máximo, 25 blocos). Talvez haja solução melhor
		for(int x = 1; x < this.getAltura()-2; x++)
			if (movel.existeBloco(x, 0) && this.existeBloco(x+1, posY-1)) return true;
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

	//Deixar isso aqui por enquanto para testar caso algo dê errado;
	public static void printarCena(EstruturaFixa fixa, EstruturaMovel peca){
		Bloco[][] blocosFixa = fixa.getBlocos();
		Bloco[][] blocosMovel = peca.getBlocos();
		String str = "";
		for (int y = fixa.getAltura() - 1; y > -1; y--){
			for (int x = 0; x < fixa.getLargura(); x++){
				if (y == peca.getPosY() && x > 0 && x < fixa.getLargura()-1){
					str = str + (blocosMovel[x-1][0] == null ? " " : blocosMovel[x-1][0]);
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
