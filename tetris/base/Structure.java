package base;

public abstract class Structure {
	private Block[][] blocks;
	private int posX;
  	private int posY;
	
	public void setBlocks(Block[][] blocks) {
		this.blocks = blocks;
	}

	public Block[][] getBlocks() {
		return this.blocks;
	}

	public boolean blockExists(int x, int y){
		try{
			return (this.getBlocks()[x][y] != null);
		}
		catch (Exception e){
			return true;
		}
	}

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
}