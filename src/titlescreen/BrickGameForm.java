package titlescreen;
import java.awt.Color;
import java.io.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;



public class BrickGameForm extends javax.swing.JFrame {

    
    int score = 0;
    String filePath; 
    Random gen = new Random();
    String currentPath;
    
    public BrickGameForm() {
        initComponents();
        
        
        
        File currentDirectory = new File(new File(".").getAbsolutePath());
          try {
               currentPath = currentDirectory.getCanonicalPath();
          } catch (IOException ex) {
              Logger.getLogger(BrickGameForm.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        scoreNumberLabel.setText(""+score);
        nextButton.setVisible(false);
        newGameButton.setVisible(false);
        thumbsLion.setVisible(false);
        
        numeratorLabel1.setText(""+block1Panel1.randomNumerator);
        denominatorLabel1.setText(""+(int)block1Panel1.randomImageSelect); 
        
        while((block2Panel1.randomImageSelect % block1Panel1.randomImageSelect) != 0){
            block1Panel1.newQuestion();
            block2Panel1.reset();
            
            numeratorLabel1.setText(""+block1Panel1.randomNumerator);
            denominatorLabel1.setText(""+(int)block1Panel1.randomImageSelect);
        }
        
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JLabel();
        thumbsLion = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        scoreNumberLabel = new javax.swing.JLabel();
        block1Panel1 = new titlescreen.Block1Panel();
        block2Panel1 = new titlescreen.Block2Panel();
        userMessage = new javax.swing.JLabel();
        numeratorLabel1 = new javax.swing.JLabel();
        denominatorLabel1 = new javax.swing.JLabel();
        numeratorLabel2 = new javax.swing.JLabel();
        denominatorLabel2 = new javax.swing.JLabel();
        divider1 = new javax.swing.JLabel();
        divider2 = new javax.swing.JLabel();
        equivalentButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        minusButton = new javax.swing.JLabel();
        plusButton = new javax.swing.JLabel();
        newGameButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        splashscreen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Brick Game");
        setMinimumSize(new java.awt.Dimension(609, 400));
        getContentPane().setLayout(null);

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/back.png"))); // NOI18N
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(20, 10, 80, 50);

        thumbsLion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/thumbsUp.png"))); // NOI18N
        getContentPane().add(thumbsLion);
        thumbsLion.setBounds(470, 110, 120, 170);

        scoreLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        scoreLabel.setText("Score :");
        getContentPane().add(scoreLabel);
        scoreLabel.setBounds(460, 10, 80, 30);

        scoreNumberLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 15)); // NOI18N
        scoreNumberLabel.setText("0");
        getContentPane().add(scoreNumberLabel);
        scoreNumberLabel.setBounds(520, 16, 50, 22);

        block1Panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                block1Panel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout block1Panel1Layout = new javax.swing.GroupLayout(block1Panel1);
        block1Panel1.setLayout(block1Panel1Layout);
        block1Panel1Layout.setHorizontalGroup(
            block1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        block1Panel1Layout.setVerticalGroup(
            block1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(block1Panel1);
        block1Panel1.setBounds(150, 80, 250, 50);

        block2Panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                block2Panel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout block2Panel1Layout = new javax.swing.GroupLayout(block2Panel1);
        block2Panel1.setLayout(block2Panel1Layout);
        block2Panel1Layout.setHorizontalGroup(
            block2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        block2Panel1Layout.setVerticalGroup(
            block2Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(block2Panel1);
        block2Panel1.setBounds(150, 200, 250, 50);

        userMessage.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        userMessage.setForeground(new java.awt.Color(0, 0, 204));
        userMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(userMessage);
        userMessage.setBounds(140, 20, 280, 40);

        numeratorLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        numeratorLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(numeratorLabel1);
        numeratorLabel1.setBounds(430, 63, 50, 40);

        denominatorLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        denominatorLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(denominatorLabel1);
        denominatorLabel1.setBounds(430, 110, 50, 50);

        numeratorLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        numeratorLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(numeratorLabel2);
        numeratorLabel2.setBounds(425, 167, 60, 60);

        denominatorLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        denominatorLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(denominatorLabel2);
        denominatorLabel2.setBounds(430, 230, 50, 50);

        divider1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/dividerBrick.png"))); // NOI18N
        getContentPane().add(divider1);
        divider1.setBounds(440, 100, 34, 14);

        divider2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/dividerBrick.png"))); // NOI18N
        getContentPane().add(divider2);
        divider2.setBounds(440, 220, 34, 14);

        equivalentButton.setText("Equivalent!");
        equivalentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equivalentButtonMouseClicked(evt);
            }
        });
        getContentPane().add(equivalentButton);
        equivalentButton.setBounds(400, 310, 120, 29);

        nextButton.setText("Next Question!");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        getContentPane().add(nextButton);
        nextButton.setBounds(400, 310, 120, 29);

        minusButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/minus.png"))); // NOI18N
        minusButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minusButtonMouseClicked(evt);
            }
        });
        getContentPane().add(minusButton);
        minusButton.setBounds(30, 220, 45, 16);

        plusButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/plus.png"))); // NOI18N
        plusButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plusButtonMouseClicked(evt);
            }
        });
        getContentPane().add(plusButton);
        plusButton.setBounds(100, 210, 40, 40);

        newGameButton.setText("New Game");
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });
        getContentPane().add(newGameButton);
        newGameButton.setBounds(410, 310, 110, 29);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/background.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(-6, -6, 620, 410);

        splashscreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/splashBrick.png"))); // NOI18N
        splashscreen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                splashscreenMouseClicked(evt);
            }
        });
        getContentPane().add(splashscreen);
        splashscreen.setBounds(-6, -6, 610, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void block1Panel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_block1Panel1KeyPressed
        
    }//GEN-LAST:event_block1Panel1KeyPressed

    private void block1Panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_block1Panel1MouseClicked

    }//GEN-LAST:event_block1Panel1MouseClicked

    private void block2Panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_block2Panel1MouseClicked
       if(block2Panel1.counter >= block2Panel1.randomImageSelect){
          block2Panel1.counter = block2Panel1.randomImageSelect;
       }
       else{
       block2Panel1.nextImage();
       numeratorLabel2.setText(""+block2Panel1.counter);
       denominatorLabel2.setText(""+(int)block2Panel1.randomImageSelect);
       }
    }//GEN-LAST:event_block2Panel1MouseClicked

    private void equivalentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equivalentButtonMouseClicked
      if(block1Panel1.answer == block2Panel1.answer){
          System.out.println("You got it right!");
          userMessage.setForeground(Color.green);
          userMessage.setText("Good Job!");
          
          
          
          int clip = gen.nextInt(4);
          if(clip == 0){
              filePath = currentPath+"/src/resources/math.mp3";
          }
          if(clip == 1){
              filePath = currentPath+"/src/resources/woohoo.mp3";  
          }
          if(clip == 2){
              filePath = currentPath+"/src/resources/yay.mp3";  
          }
          if(clip == 3){
              filePath = currentPath+"/src/resources/cheer.mp3";  
          }
         // playClip();
          
          score = score + 100;
          scoreNumberLabel.setText(""+score);
          equivalentButton.setVisible(false);
          nextButton.setVisible(true);
          if(score == 500){
              userMessage.setText("YOU WIN!");
              nextButton.setVisible(false);
              newGameButton.setVisible(true);
              thumbsLion.setVisible(true);
          }
          
          
      }
      else{
          System.out.println("Nerd you got it wrong");
          userMessage.setForeground(Color.red);
          userMessage.setText("Try Again");
          scoreNumberLabel.setText(""+score);
      }
    }//GEN-LAST:event_equivalentButtonMouseClicked

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        userMessage.setText("");
        nextButton.setVisible(false);
        equivalentButton.setVisible(true);
        
        block1Panel1.newQuestion();
        
        numeratorLabel1.setText(""+block1Panel1.randomNumerator);
        denominatorLabel1.setText(""+(int)block1Panel1.randomImageSelect);
        
        block2Panel1.reset();
        numeratorLabel2.setText(""+block2Panel1.counter);
        denominatorLabel2.setText(""+(int)block2Panel1.randomImageSelect);
        
        while((block2Panel1.randomImageSelect % block1Panel1.randomImageSelect) != 0){
            block1Panel1.newQuestion();
            block2Panel1.reset();
            
            numeratorLabel1.setText(""+block1Panel1.randomNumerator);
            denominatorLabel1.setText(""+(int)block1Panel1.randomImageSelect);
            
            numeratorLabel2.setText(""+block2Panel1.counter);
            denominatorLabel2.setText(""+(int)block2Panel1.randomImageSelect);
        }
        
        
    }//GEN-LAST:event_nextButtonActionPerformed

    private void plusButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plusButtonMouseClicked
       block2Panel1.nextImage();
       numeratorLabel2.setText(""+block2Panel1.counter);
       denominatorLabel2.setText(""+(int)block2Panel1.randomImageSelect);
       
       filePath = currentPath+"/src/resources/pop.mp3";
     //  playClip();
    }//GEN-LAST:event_plusButtonMouseClicked

    private void minusButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minusButtonMouseClicked
       block2Panel1.previousImage();
       numeratorLabel2.setText(""+block2Panel1.counter);
       denominatorLabel2.setText(""+(int)block2Panel1.randomImageSelect);
       
       filePath = currentPath+"/src/resources/pop.mp3";
     //  playClip();
    }//GEN-LAST:event_minusButtonMouseClicked

    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameButtonActionPerformed
        score = 0;
        userMessage.setText("");
        scoreNumberLabel.setText(""+score);
        nextButton.setVisible(false);
        newGameButton.setVisible(false);
        thumbsLion.setVisible(false);
        equivalentButton.setVisible(true);
        
        block1Panel1.newQuestion();
        
        numeratorLabel1.setText(""+block1Panel1.randomNumerator);
        denominatorLabel1.setText(""+(int)block1Panel1.randomImageSelect);
        
        block2Panel1.reset();
        numeratorLabel2.setText(""+block2Panel1.counter);
        denominatorLabel2.setText(""+(int)block2Panel1.randomImageSelect);
        
        while((block2Panel1.randomImageSelect % block1Panel1.randomImageSelect) != 0){
            block1Panel1.newQuestion();
            block2Panel1.reset();
            
            numeratorLabel1.setText(""+block1Panel1.randomNumerator);
            denominatorLabel1.setText(""+(int)block1Panel1.randomImageSelect);
        }
    }//GEN-LAST:event_newGameButtonActionPerformed

    private void splashscreenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_splashscreenMouseClicked
        splashscreen.setVisible(false);
    }//GEN-LAST:event_splashscreenMouseClicked

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        //Deal with points here
        
        this.setVisible(false);
        titleScreenForm t = new titleScreenForm();
        t.setVisible(true);
        
        System.out.println("Pressed");
    }//GEN-LAST:event_backButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BrickGameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BrickGameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BrickGameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BrickGameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BrickGameForm().setVisible(true);
            }
        });
        
        
    }
    public void playClip(){
  
       
        try{
          File file = new File(filePath);
          FileInputStream fis = new FileInputStream(file);
          BufferedInputStream bis = new BufferedInputStream(fis);
          
          try{
              Player player = new Player(bis);
              player.play();
          }
          catch(JavaLayerException ex){
              
          }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
            
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel background;
    private titlescreen.Block1Panel block1Panel1;
    private titlescreen.Block2Panel block2Panel1;
    private javax.swing.JLabel denominatorLabel1;
    private javax.swing.JLabel denominatorLabel2;
    private javax.swing.JLabel divider1;
    private javax.swing.JLabel divider2;
    private javax.swing.JButton equivalentButton;
    private javax.swing.JLabel minusButton;
    private javax.swing.JButton newGameButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel numeratorLabel1;
    private javax.swing.JLabel numeratorLabel2;
    private javax.swing.JLabel plusButton;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel scoreNumberLabel;
    private javax.swing.JLabel splashscreen;
    private javax.swing.JLabel thumbsLion;
    private javax.swing.JLabel userMessage;
    // End of variables declaration//GEN-END:variables
}
