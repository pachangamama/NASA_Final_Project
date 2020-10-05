package players.creatures;
import Control.Keyboard;

public class Player1 extends Creature {

	private Keyboard keyboard;
	
	public Player1(Keyboard keyboard) {
		this.keyboard = keyboard;
	}
	
	public Player1(Keyboard keyboard, int positionX) {
		this.keyboard = keyboard;
		this.x = positionX;
	}
	
	public void Update() {
		
		int dispX = 0;
		
		if(keyboard.left) {
			dispX--;
		}
		if(keyboard.right) {
			dispX++;
		}
		
		if(dispX != 0) {
			move(dispX);
		}
	}
	
	public void Show() {
		
	}
	
}
