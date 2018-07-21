package entities;

import java.awt.Color;
import java.awt.Graphics;


public class Blocos extends BaseShape {
    private int x = 0;
        private int y = 0;
        
        public Blocos(int x, int y){
            this.x = x;
            this.y = y;            
        }
        
         @Override
         public void paintComponent( Graphics g ) {
             
          super.paintComponent( g );
          g.setColor(Color.DARK_GRAY);
          g.fillRect(getX(),getY(), 15,15);
          g.drawRect(getX(),getY(),15,15 );
         
         
          
       }
    
   
   public int getX(){
       return this.x;
   }
   public int getY(){
       return this.y;
   }
   
    
}
