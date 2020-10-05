package players.creatures;
import players.Players;
import graphics.Sprite;

public abstract class Creature extends Players {

	protected Sprite sprite;
	protected char direction = 'n';
	protected boolean moving = false;
	
	public void Update() {
		
	}
	
	public void Show() {
		
	}
	
	public void move(int dispX) {
		if(dispX > 0) {
			direction = 'e';
		}
		if(dispX < 0) {
			direction = 'o';
		}
		/*if(dispY > 0) {
			direction = 's';
		}
		if(dispY < 0) {
			direction = 'n';
		}*/
		
		if(!isEliminated()) {
			modifyPositionX(dispX);
		}
	}
	
	private boolean inCollision() {
		return false;
	}
	
	
}
