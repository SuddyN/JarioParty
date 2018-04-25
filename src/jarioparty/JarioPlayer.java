package jarioparty;

import static java.lang.Boolean.FALSE;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class JarioPlayer {
    private int spaceNumber;
    private String color;
    private boolean twiceCandy;
    private boolean thriceCandy;
    private int multiplier;
    private int roll;
    private int coinNumber;
    private int starNumber;
    private int redSpaceNumber;
    private int wins;
    private int totalRoll;
    
    public JarioPlayer() {
        //this.color = color;
        this.multiplier = 1;
        this.twiceCandy = FALSE;
        this.thriceCandy = FALSE;
        this.spaceNumber = 0;
        this.coinNumber = 10;
        this.starNumber = 0;
        this.redSpaceNumber = 0;
        this.wins = 0;
        this.totalRoll = 0;

    }

    public void testMethod() {
        System.out.println("it worked " + coinNumber);
    }
    
    
    //GetSet
    
    public int getSpaceNumber() {
        return spaceNumber;
    }

    public void setSpaceNumber(int spaceNumber) {
        this.spaceNumber = spaceNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isTwiceCandy() {
        return twiceCandy;
    }

    public void setTwiceCandy(boolean twiceCandy) {
        this.twiceCandy = twiceCandy;
    }

    public boolean isThriceCandy() {
        return thriceCandy;
    }

    public void setThriceCandy(boolean thriceCandy) {
        this.thriceCandy = thriceCandy;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getCoinNumber() {
        return coinNumber;
    }

    public void setCoinNumber(int coinNumber) {
        this.coinNumber = coinNumber;
    }

    public int getStarNumber() {
        return starNumber;
    }

    public void setStarNumber(int starNumber) {
        this.starNumber = starNumber;
    }

    public int getRedSpaceNumber() {
        return redSpaceNumber;
    }

    public void setRedSpaceNumber(int redSpaceNumber) {
        this.redSpaceNumber = redSpaceNumber;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getTotalRoll() {
        return totalRoll;
    }

    public void setTotalRoll(int totalRoll) {
        this.totalRoll = totalRoll;
    }
    
    
}
