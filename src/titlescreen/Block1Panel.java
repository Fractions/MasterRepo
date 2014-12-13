
package titlescreen;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author brandonturner
 */
public class Block1Panel extends JPanel{

    ImageIcon Image;
    int counter = 0;
    double answer = 0;
    Random gen = new Random();
    int randomImageSelect = gen.nextInt(8)+2;
    int randomNumerator = gen.nextInt(randomImageSelect)+1;
    
    public Block1Panel(){
     
    
    try{
    Image = new ImageIcon(getClass().getResource("/resources/"+randomImageSelect+"/"+randomNumerator+"_"+randomImageSelect+".png"));
    
    }
    catch(Exception e){
    e.printStackTrace();
              }
    answer = (double)randomNumerator / (double)randomImageSelect;
        }
    
    @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
            g.drawImage(Image.getImage(), 0, 0, null);

        }
    
    public void newQuestion(){
        randomImageSelect = gen.nextInt(8)+2;
        randomNumerator = gen.nextInt(randomImageSelect)+1;
        
        try{
           Image = new ImageIcon(getClass().getResource("/resources/"+randomImageSelect+"/"+randomNumerator+"_"+randomImageSelect+".png"));
    
           }
             catch(Exception e){
             e.printStackTrace();
           }
               answer = (double)randomNumerator / (double)randomImageSelect;
               this.repaint();
        }

    }


