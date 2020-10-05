package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteSheet {
    
    private final int Side, Lenght;
    public final int[] pixelSheet;
    
    // Sprite
    public static SpriteSheet Space = new SpriteSheet("/Resources/personaje1.png",
    320, 320);
    
    
    
    public SpriteSheet(final String imageRoute, final int Side, final int Lenght){
        
        this.Side = Side;
        this.Lenght = Lenght;
        
        pixelSheet = new int[Side * Lenght];
        
        BufferedImage Image;
        try {
            Image = ImageIO.read(SpriteSheet.class.getResource(imageRoute));
            Image.getRGB(0, 0, Side, Lenght, pixelSheet, 0, Lenght);
        } catch (IOException e) {
            
            e.printStackTrace();
        }       
    }
    
    public int getSide(){
        
        return Side;
    }
    
}

