package base;

public class Estrutura {
	private Bloco[][] blocos;
	
	public void setBlocos(Bloco[][] blocos) {
		this.blocos = blocos;
	}

	public Bloco[][] getBlocos() {
		return this.blocos;
	}

	//Função para aumentar a coesão
	public boolean existeBloco(int x, int y){
		try{
			return (this.getBlocos()[x][y] != null);
		}
		catch (Exception e){
			return true;
		}
		
	}
}