package base;

public class Estrutura {
	private int largura;
	private int altura;
	private int posX;
	private int posY;
	private Bloco[][] blocos;
	
	//Como construtor, utilizar a largura e altura como limites da matriz. Qualquer alteração nos bloco deverá ser passada para a largura e altura;

	public Estrutura(){
		this(0, 0, new Bloco[0][0]);
	}
	public Estrutura(int posX, int posY) {
		this(posX, posY, new Bloco[0][0]);
	}	
	public Estrutura(int posX, int posY, Bloco[][] blocos){
		setBlocos(blocos);
		this.setPosX(posX);
		this.setPosY(posY);
	}

	//Getter e Setter da posição em X do bloco no canto inferior esquerdo
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}

	//Getter e Setter da posição em Y do bloco no canto inferior esquerdo
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}

	//Altura e largura são conceitos que podem ser abandonados com o passar do tempo. Mas manterei aqui até ter alguma decisão
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	public int getLargura() {
		return largura;
	}
	public void setLargura(int largura) {
		this.largura = largura;
	}

	//Talvez fazer um método para mesclar os bloco aqui mesmo? addBlocos()
	public void setBlocos(Bloco[][] blocos) {
		this.blocos = blocos;
		try{
			setAltura(blocos[0].length);
		}
		catch (Exception e){	
			setAltura(1);
		}
		try{
			setLargura(blocos.length);
		}
		catch (Exception e){
			setLargura(1);
		}		
	}
	public Bloco[][] getBlocos() {
		return blocos;
	}

	//Este método será sempre visto da perspectiva da Estrutura Fixa. Portanto, futuramente será um método da sub classe Estrutura Fixa 
	public void addBlocos(Estrutura movel){
		Bloco[][] blocos = movel.getBlocos();
		for(int i = 0; i < movel.getLargura(); i++)
			for(int j = 0; j < movel.getLargura(); j++)
				this.addBloco(i + movel.getLargura(), j + movel.getAltura(), blocos[i][j]);
	}
	public void addBloco(int x, int y, Bloco bloco){
		this.blocos[x][y] = bloco;
	}

	//Métodos temporários, serão implementados numa interface para cumprir os requerimentos (ou simplesmente serão métodos da Sub Classe Estrutura Móvel)
	//Provavelmente serão transformadas em boolean para poder executar o existeBlocoAbaixo(). Se existir, não anda e sim mescla os blocos.
	public void andaX(int x, Bloco fixa) {
		//Se x for positivo, escanear a coluna da direita para achar os blocos
		//Sempre que existir um bloco na coluna da direita (ou esquerda), verificar, naquela posição (x + posX +-1, y + posY), se existe bloco
		//Se existir, em algum ponto, retorna falso;
		setPosX(getPosX() + x);
	}
	public void andaY(int y, Bloco fixa) {		
		setPosX(getPosY() + y);
	}

	//Função para aumentar a coesão
	public boolean existeBloco(int x, int y){
		return this.blocos[x][y] != null;
	}

	public boolean existeBlocoAbaixo(Estrutura fixa){
		int posX = this.getPosX();
		int posY = this.getPosY();
		int largura = this.getLargura();
		int altura = this.getAltura();
		//Por enquanto está iterando todos os blocos de móvel (que provavelmente serão, no máximo, 25 blocos). Talvez haja solução melhor
		for (int i = 0; i<largura; i++)
			for(int j = 0; j<altura; j++)
				if (this.existeBloco(i, j) && fixa.existeBloco(posX + i, posY+j-1)) return true;		
		return false;
	}
}
