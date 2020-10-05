package Control;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Keyboard implements KeyListener {

    private static final int keyQuantity = 260;
    private final boolean[] keyIn = new boolean[keyQuantity];
    
    public boolean left, right, action;
    
    public void update(){
        
        // Movimiento Bidimensional
        
        left   = keyIn[KeyEvent.VK_A];
        right  = keyIn[KeyEvent.VK_D];
        
        // Interacciones
        
        action = keyIn[KeyEvent.VK_E];
    }   

    @Override
    public void keyPressed(KeyEvent e) {
     
        keyIn[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        keyIn[e.getKeyCode()] = false;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
}

