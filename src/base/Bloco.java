package base;

public class Bloco {
	private String cor;
	public Bloco() {
		this("#FFFFFF");
	}	
	public Bloco(String cor) {	
		setCor(cor);
	}
	private void setCor(String cor){
		this.cor = cor;
	}
	private String getCor(){
		return this.cor;
	}
}
