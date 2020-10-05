package square.map;
import graphics.Screen;
import graphics.Sprite;

public class Square {

	public int x;
	public int y;
	
	public Sprite sprite;
	
	public static final int SIDE = 32;
	
	//Collection of squares
	public static final Square EMPTY = new EmptySquare(Sprite.EMPTY);
	public static final Square SPACE = new SpaceSquare(Sprite.SPACE);
	
	//End of colecction
	
	public Square(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void Show(int x, int y, Screen screen) {
		screen.ShowSquare(x << 5, y << 5, this);
	}
	
	public boolean Solid() {
		return false;
	}
	
}
