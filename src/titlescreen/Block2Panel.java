/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package titlescreen;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author brandonturner
 */
public class Block2Panel extends JPanel{
    
     ImageIcon Image;
    int counter = 0;
    double answer = 0;
    Random gen = new Random();
    int randomImageSelect = gen.nextInt(8)+2;
    
   
    
    public Block2Panel(){
    
    
    try{
    Image = new ImageIcon(getClass().getResource("/resources/"+randomImageSelect+"/0_"+randomImageSelect+".png"));
    
    }
    catch(Exception e){
    e.printStackTrace();
              }
        }
    
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(Image.getImage(), 0, 0, null);
       
    }
    
    public void nextImage(){
        counter++;
        if(counter >= randomImageSelect){
            counter = randomImageSelect;
        }
        
        Image = new ImageIcon(getClass().getResource("/resources/"+randomImageSelect+"/"+counter+"_"+randomImageSelect+".png"));
        this.repaint();
        answer = (double)counter / (double)randomImageSelect;
        
    }
    
    public void previousImage(){
        counter--;
        if(counter >= randomImageSelect){
            counter = randomImageSelect;
        }
        
        Image = new ImageIcon(getClass().getResource("/resources/"+randomImageSelect+"/"+counter+"_"+randomImageSelect+".png"));
        this.repaint();
        answer = (double)counter / (double)randomImageSelect;
        
    }
    
    public void reset(){
    answer = 0;
    counter = 0;
    randomImageSelect = gen.nextInt(8)+2;
        
    try{
    Image = new ImageIcon(getClass().getResource("/resources/"+randomImageSelect+"/0_"+randomImageSelect+".png"));
    
    }
    catch(Exception e){
    e.printStackTrace();
              }
    this.repaint();
        
    }
    
}
