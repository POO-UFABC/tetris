package base;

public class MobileStructure extends Structure {
  public MobileStructure(int posX, int posY, Block[][] blocks){
		super.setBlocks(blocks);
		super.setPosX(posX);
		super.setPosY(posY);
	}

	// Este método está aqui pois:
	// Nem tudo que é movel é uma peça
	// Tudo que é móvel anda, pelo menos, em y
	public boolean moveY(int y, FixedStructure fixedStructure) {
		if (fixedStructure.blockExistsDown(this)){
			fixedStructure.addBlocks(this);
		}
		this.setPosY(this.getPosY() - y);
		return true;
	}
}
