package base;

public class Bloco {
	private String cor = " ";
	public Bloco() {
		//Por enquanto, está chamando, de padrão, a cor branca
		//Está é a minha ideia para as bordas, poderá ser mudado à frente
		//Em geral, o bloco serve mais para ser diferente de um ponteiro para null que por ser um holder de atributos
		this("#FFFFFF");
	}

	public Bloco(String cor) {	
		setCor(cor);
	}

	public void setCor(String cor){
		this.cor = cor;
	}

	@Override
	public String toString(){
		String str = this.getCor();
		return str;
	}

	public String getCor(){
		return (this.cor == null ? " " : this.cor);
	}
}
