package base;

public class Bloco {
<<<<<<< HEAD
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
=======
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
>>>>>>> 59caabe74c62e3003f3dc109493440105dec47fb
	}
}
