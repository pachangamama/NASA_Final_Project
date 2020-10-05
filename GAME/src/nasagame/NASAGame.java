package nasagame;
import Control.Keyboard;
import graphics.Screen;
import players.creatures.Player1;
import map.Map;
import map.GeneratedMap;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

public class NASAGame extends Canvas implements Runnable {

   // Var/Cons -----------------------------------------------------------------
    
    private static final long serialVersionUID = 1L;
    private static final int  WIDTH = 800, HEIGHT = 600;
    
    private static volatile boolean isRunning = false;
    
    private static final String TITLE = "Can you hear me now?";
    private static int ups = 0;
    private static int fps = 0;
    
    private static int x = 0, y = 0;
    private static Screen screenOn;
    
    private static BufferedImage imageOn = new BufferedImage(WIDTH, HEIGHT,
    BufferedImage.TYPE_INT_RGB);
    
    private static int[] pixelOn = ((DataBufferInt) imageOn.getRaster().getDataBuffer()).getData();
    
    private static JFrame Window;
    private static Thread Thread;
    private static Screen screen;
    private static Keyboard keyInput;
    
    private static Map map;
    private static Player1 player1;
    
    // Window SetScreen --------------------------------------------------------
    
    private NASAGame() {
        
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        screenOn = new Screen(WIDTH, HEIGHT);
        
        //map = new GeneratedMap(128,128);
        map = new LoadedMap("/maps/space.png");
        player1 = new Player1(keyInput);
        
        
        keyInput = new Keyboard();
        addKeyListener(keyInput);
        
        Window = new JFrame(TITLE);
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Window.setResizable(false);
        Window.setLayout(new BorderLayout());
        Window.add(this, BorderLayout.CENTER);
        Window.pack();
        
        Window.setLocationRelativeTo(null);
        Window.setVisible(true);
    }
    
    public static void main(String[] args) {
        
        NASAGame Game = new NASAGame();
        Game.Start();
    }

    // Initialization Methods --------------------------------------------------
    private synchronized void Start(){
        
        isRunning = true;
        
        aThread = new Thread(this, "Graphics");
        aThread.start();
    }
    
    private synchronized void Stop(){
 
    isRunning = false;
                    
    try {
  
        aThread.join();
    } catch (InterruptedException e) {
            
        e.printStackTrace();
    }
    
    }
    
    private void Update(){
        
        keyInput.update();
        
       /* if(keyInput.left){
            
            System.out.println("Left");
        }
        if(keyInput.right){
            
            System.out.println("Right");
        }*/
        
        player1.Update();
        
        if(keyInput.action){
            
            System.out.println("Trigger is on...");
        }
        
        ups++;
    }
    
    private void Show(){
        
        BufferStrategy stratBuffer = getBufferStrategy();
        
        if(stratBuffer == null){
            createBufferStrategy(3);
            return;
        }
        
        screenOn.Clean();
        screenOn.Show(x, y);
        
        System.arraycopy(screenOn.pixelScreen, 0, pixelOn, 0, pixelOn.length);
        
//        for(int i = 0; i < pixelOn.length; i++){
//            
//            pixelOn[i] = screenOn.pixelScreen[i];
//        }
        
        Graphics g = stratBuffer.getDrawGraphics();
        g.drawImage(imageOn, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
        
        stratBuffer.show();
        
        fps++;
    }
    
    // Main Cycle --------------------------------------------------------------
    @Override
    public void run() {
        
        final int NSECONDS  = 1000000000;
        final byte UPDATES  = 60;
        final double NS_UPS = NSECONDS / UPDATES;
        
        long referenceUpdate  = System.nanoTime();
        long referenceCounter = System.nanoTime();
        
        double elapsedTime;
        double deltaTime = 0;
        
        requestFocus();
        
        while(isRunning){
            
            final long CYCLESTART = System.nanoTime();
            
            elapsedTime = CYCLESTART - referenceUpdate;
            referenceUpdate = CYCLESTART;
            
            deltaTime += elapsedTime / NS_UPS;
            
            while(deltaTime >= 1){
                
                Update();
                deltaTime--;
            }
            
            Show();
            
            // Counters --------------------------------------------------------
            
            if(System.nanoTime() - referenceCounter > NSECONDS){
                
                Window.setTitle(TITLE + " || Updates: " + ups +
                " || fps: " + fps);
                
                ups = 0; fps = 0;
                referenceCounter = System.nanoTime();
            }
        } 
    }
}

