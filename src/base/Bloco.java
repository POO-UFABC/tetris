package base;

public class Bloco {
	private String cor = " ";
	public Bloco() {
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
