package base;

import java.awt.Graphics;
import java.awt.Color;

public class Block {
	public static final int SIDE = 20;
	private Color color;
	
	/**Por enquanto, está chamando, de padrão, a color branca
	*Está é a minha ideia para as bordas, poderá ser mudado à frente
	*Em geral, o Block serve mais para ser diferente de um ponteiro para null que por ser um holder de atributos
	*/
	public Block() {
		this(Color.white);
	}

	public Block(Color color) {	
		setColor(color);
	}

	public void setColor(Color color){
		this.color = color;
	}

	public void render(int x, int y, Graphics g) {
		g.setColor(this.color);
		g.fillRect(x, y, SIDE, SIDE);
	}

	public Color getColor(){
		return this.color;
	}
}
