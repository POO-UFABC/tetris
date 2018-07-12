package base;

public class EstruturaMovel extends Estrutura {
    private int posX;
    private int posY;

	public int getPosX(){
		return this.posX;
	}

	public void setPosX(int posX){
		this.posX = posX;
	}

	public int getPosY(){
		return this.posY;
	}

	public void setPosY(int posY){
		this.posY = posY;
	}
	
	public EstruturaMovel(int posX, int posY, Bloco[][] blocos){
		super.setBlocos(blocos);
		this.setPosX(posX);
		this.setPosY(posY);
	}

	// Este método está aqui pois:
	// Nem tudo que é movel é uma peça
	// Tudo que é móvel anda, pelo menos, em y
	public void andaY(int y, EstruturaFixa fixa) {
		if (fixa.existeBlocoAbaixo(this)){
			fixa.addBlocos(this);
		} 		
		this.setPosY(this.getPosY() - y);
	}
}
