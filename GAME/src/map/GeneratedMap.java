package map;
import java.util.Random;

public class GeneratedMap extends Map{

  private final Random aleatorio = new Random();
  public GeneratedMap(int width, int height){
    super(width, height);
  }
  protected void generateMap(){
    for(int y = 0; y < height; y++ ){
      for(int x = 0; x < width; x++){
        square[x + y * square] = aleatorio.nextInt(3);

      }
    }
  }
}