package map;

import graphics.Screen;

public abstract class Map {
    
    private int WIDTH, HEIGHT;
    
    private int[] Tiles;
    
    public Map(int WIDTH, int HEIGHT){
        
        this.WIDTH  = WIDTH;
        this.HEIGHT = HEIGHT;
        
        Tiles = new int[WIDTH * HEIGHT]; 
        
        generateMap();
    }
    
    public Map(String Route){
         
    }
    
    private void generateMap(){
        
    }
    
    public void loadMap(String Route){
        
    }
    
    public void Update(){
        
    }
    
    public void Show(int compensateX, int compensateY, Screen screenLoader){
        
    }
}
