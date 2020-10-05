package players;
import map.Map;

public class Players {

	protected int x;
	
	private boolean eliminated = false;
	
	protected Map map;
	
	public void Update() {
		
	}
	
	public void Show() {
		
	}
	
	public void eliminate() {
		eliminated = true;
	}
	
	public int getpositionX() {
		return x;
	}
	
	public void modifyPositionX(int dispX) {
		x += dispX;
	}
	
	/*public int getpositionY() {
		return y;
	}
	
	public void modifyPositionY(int dispY) {
		y += dispY;
	}*/
	
	public boolean isEliminated() {
		return eliminated;
	}
	
	
	
}
