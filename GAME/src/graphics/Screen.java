package graphics;

public class Screen {
    
    private final int WIDTH, HEIGHT;
    
    public final int[] pixelScreen;
    
    private final static int SPRITE_SIDE = 32, SPRITE_MASK = SPRITE_SIDE - 1; 
    
    public Screen(final int WIDTH, final int HEIGHT){
        
        this.WIDTH  = WIDTH;
        this.HEIGHT = HEIGHT;
        
        pixelScreen = new int[WIDTH * HEIGHT];
    }
    
    public void Clean(){
        
        for(int i = 0; i < pixelScreen.length; i++){
            
            pixelScreen[i] = 0;
        }
    }
    
    public void Show(final int CompensateX, final int CompensateY){
        
        for(int y = 0; y < HEIGHT; y++){
            
            int posY = y + CompensateY;
            
            if(posY < 0 || posY >= HEIGHT){
                
                continue;
            }
            
            for(int x = 0; x < WIDTH; x++){
                
                int posX = x + CompensateX;
                
                if(posX < 0 || posX >= WIDTH){
                    
                    continue;
                }
                
                pixelScreen[posX + posY * WIDTH] = Sprite.Ship.pixelSprite[(x&SPRITE_MASK) + 
                        (y&SPRITE_MASK) * SPRITE_SIDE];
                
                
                
            }
        }
    }
}
