import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Blocos extends JPanel{
        private int x = 0;
        private int y = 0;
        private Color c;
        
        public Blocos(int x, int y, Color c){
            this.x = x;
            this.y = y;   
            this.c = c;
        }
        
         @Override
         public void paintComponent( Graphics g ) {
             
          super.paintComponent( g );
          g.setColor(this.c);
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
