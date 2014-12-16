package titlescreen;

import java.util.Random;

public class Bubble {
    Random gen = new Random();
    int xLoc;
    int yLoc;
    int changeX;
    int changeY;
    int bubbleColour = 0;
    boolean changeColour = false;
    
    int labelX;
    int labelY;
    int labelHeight = 100;
    int labelWidth = 100;

    public void move(){
        xLoc = xLoc + changeX;
        yLoc = yLoc + changeY;
        labelX = labelX + changeX;
        labelY = labelY + changeY;
        
        if(xLoc <= 0){
           changeX = changeX * -1;
           bubbleColour = gen.nextInt(5)+1;
           changeColour = true;
        }
        if(xLoc >= 1140){
           changeX = changeX * -1;
           bubbleColour = gen.nextInt(5)+1;
           changeColour = true;
        }
        if(yLoc <= 0){
           changeY = changeY * -1;
           bubbleColour = gen.nextInt(5)+1;
           changeColour = true;
        }
        if(yLoc >= 490){
           changeY = changeY * -1;
           bubbleColour = gen.nextInt(5)+1;
           changeColour = true;
        }
    }
    
    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public int getBubbleColour() {
        return bubbleColour;
    }

    public void setBubbleColour(int bubbleColour) {
        this.bubbleColour = bubbleColour;
    }

    public int getChangeX() {
        return changeX;
    }

    public void setChangeX(int changeX) {
        this.changeX = changeX;
    }

    public int getChangeY() {
        return changeY;
    }

    public void setChangeY(int changeY) {
        this.changeY = changeY;
    }

    public boolean isChangeColour() {
        return changeColour;
    }

    public void setChangeColour(boolean changeColour) {
        this.changeColour = changeColour;
    }

    public int getLabelX() {
        return labelX;
    }

    public void setLabelX(int labelX) {
        this.labelX = labelX;
    }

    public int getLabelY() {
        return labelY;
    }

    public void setLabelY(int labelY) {
        this.labelY = labelY;
    }

    public int getLabelHeight() {
        return labelHeight;
    }

    public int getLabelWidth() {
        return labelWidth;
    }
    
}