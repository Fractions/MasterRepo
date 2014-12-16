package titlescreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BubblePanel extends JPanel{
    Random gen = new Random();
    Font font1 = new Font("Broadway", Font.BOLD, 30);
    Font font2 = new Font("Broadway", Font.BOLD, 25);
    
    JButton startButton = new JButton();
    
    BufferedImage startScreen;
    boolean onStart = false;
    
    BufferedImage[] bubbleImage = new BufferedImage[5];
    Bubble[] bubble = new Bubble[5];
    JLabel[] answerLabel = new JLabel[5];
    
    Thread elf;
    Clipboard cb;
    
    String[] question;
    String[] answer;
    
    int currentQuestionNum = 0;
    String currentQuestion;
    String[] currentAnswer = new String[5];
    
    boolean firstMade = false;
    
    public BubblePanel(){
        this.setLayout(null);
        try {
            startScreen = ImageIO.read(this.getClass().getResource("/resources/start background.jpg"));
            //this.add(startScreen);
        } catch (IOException ex) {
            Logger.getLogger(BubblePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        onStart = true;
        addButton();
    }
    
    public void addButton(){
        startButton.setVisible(true);
        startButton.setFont(font2);
        startButton.setText("PRESS TO START!");
        startButton.setOpaque(true);
        startButton.setBounds(390, 400, 500, 100);
        startButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        //this.add(startButton);
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt2){
                    startGame();
                }
            });
    }
    
    public void startGame(){
        this.remove(startButton);
        onStart = false;
        startScreen = null;
        readFile();
        newQuestion();
        makeBubbles();
        firstMade = true;
        
        cb = new Clipboard();
        elf = new Thread(cb);
        this.setLayout(null);
        changeBubble();
        startElf();
    }
    
    public void readFile(){
        try{
            File f = new File("questions.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            int length = 0;
            while(br.readLine()!= null){
                length++;
            }
            br.close();
            
            question = new String[length/6];
            answer = new String[length/6*5];
            
            File f2 = new File("questions.txt");
            FileReader fr2 = new FileReader(f2);
            BufferedReader br2 = new BufferedReader(fr2);
            
            for(int q = 0; q < length/6; q++){
                question[q] = br2.readLine();
                System.out.println(question[q]);
                for(int a = q*5; a < q*5+5; a++){
                    answer[a] = br2.readLine();
                    System.out.println(answer[a]);
                }
            }
            br2.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void makeBubbles(){
        for(int i = 0; i < bubble.length; i++){
            bubble[i] = new Bubble();
            bubble[i].setxLoc(gen.nextInt(1000)+70);
            bubble[i].setyLoc(gen.nextInt(400)+50);
            bubble[i].setChangeX(gen.nextInt(9)-4);
            bubble[i].setChangeY(gen.nextInt(9)-4);
            bubble[i].setBubbleColour(gen.nextInt(5)+1);
            bubble[i].setLabelX(bubble[i].getxLoc() + 21);
            bubble[i].setLabelY(bubble[i].getyLoc() + 21);
            
            if(firstMade == true){
                this.remove(answerLabel[i]);
            }
            answerLabel[i] = new JLabel();
            answerLabel[i].setVisible(true);
            answerLabel[i].setFont(font1);
            answerLabel[i].setText(currentAnswer[i]);
            answerLabel[i].setBounds(bubble[i].getLabelX(), bubble[i].getLabelY(), bubble[i].getLabelWidth(), bubble[i].getLabelHeight());
            answerLabel[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            this.add(answerLabel[i]);
            answerLabel[i].addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mousePressed(java.awt.event.MouseEvent evt){
                        bubbleClicked(evt);
                    }
                });
        }
    }
    
    public void newQuestion(){
        currentQuestion = question[currentQuestionNum];
        System.out.println();
        System.out.println(currentQuestion);
        
        for(int a = 0; a < 5; a++){
            currentAnswer[a] = answer[currentQuestionNum*5+a];
            System.out.println(currentAnswer[a]);
        }
        currentQuestionNum++;
    }
    
    public void bubbleClicked(java.awt.event.MouseEvent evt){
        newQuestion();
        makeBubbles();
    }
    
    public void startElf(){
        elf.start();
    }
    
    public void changeBubble(){
        try {
            for(int i = 0; i < bubble.length; i++){
                if(bubble[i].getBubbleColour() == 1){
                    bubbleImage[i] = ImageIO.read(this.getClass().getResource("/resources/Blue_Bubble.png"));
                }
                if(bubble[i].getBubbleColour() == 2){
                    bubbleImage[i] = ImageIO.read(this.getClass().getResource("/resources/Green_Bubble.png"));
                }
                if(bubble[i].getBubbleColour() == 3){
                    bubbleImage[i] = ImageIO.read(this.getClass().getResource("/resources/Purple_Bubble.png"));
                }
                if(bubble[i].getBubbleColour() == 4){
                    bubbleImage[i] = ImageIO.read(this.getClass().getResource("/resources/Red_Bubble.png"));
                }
                if(bubble[i].getBubbleColour() == 5){
                    bubbleImage[i] = ImageIO.read(this.getClass().getResource("/resources/Yellow_Bubble.png"));
                }
            }
        } 
        catch (IOException ex) {
            Logger.getLogger(BubblePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public class Clipboard implements Runnable{
        boolean isRunning = true;
        public void run(){
            while (isRunning = true){
                for(int i = 0; i < bubble.length; i++){
                    bubble[i].move();
                    if(bubble[i].isChangeColour() == true){
                        changeBubble();
                        bubble[i].setChangeColour(false);
                    }
                }
                try {
                    Thread.sleep(65);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BubblePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                repaint();
            }
        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);  // clear panel
        if (onStart = true){
            g.drawImage(startScreen, 0, 0, null);
        }
        if(firstMade == true){
            g.setColor(Color.black);
            g.setFont(font2);
            g.drawString(currentQuestion, 15, 30);
            g.drawRect(0, 0, 200, 40);

            for(int i = 0; i < bubble.length; i++){
                g.drawImage(bubbleImage[i], bubble[i].getxLoc(), bubble[i].getyLoc(), null);

                answerLabel[i].setBounds(bubble[i].getLabelX(), bubble[i].getLabelY(), bubble[i].getLabelWidth(), bubble[i].getLabelHeight());
                this.add(answerLabel[i]);
            }
        }
    }
}