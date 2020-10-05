package graphics;

public final class Sprite {
    
    private final int Side;
    private int x, y;
    
    public int[] pixelSprite;
    private final SpriteSheet Sheet;
    
    // Sprite
    
    public static Sprite Ship = new Sprite(32, 0, 0, SpriteSheet.Space);
    
    public Sprite(final int Side, final int Height, final int Queue, 
                  final SpriteSheet Sheet){
        
        this.Side = Side;
        
        pixelSprite = new int[Side * Side];
        
        this.x = Height * Side;
        this.y = Queue  * Side;
        this.Sheet = Sheet;
        
        for(int i = 0; i < Side; i++){
            
            for(int o = 0; o < Side; o++){
                
                pixelSprite[o + i * Side] = Sheet.pixelSheet[(x + this.x) + 
                    (y + this.y) * Sheet.getSide()];
            }
        }
    }
    
    
}

