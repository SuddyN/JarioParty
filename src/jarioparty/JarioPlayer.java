package jarioparty;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class JarioPlayer extends FlowPane {
    //Attributes
    
    private int spaceNumber;
    //private String color;
    private boolean twiceCandy;
    private boolean thriceCandy;
    private Button twiceButton;
    private Button thriceButton;
    private Button rollButton;
    private int multiplier;
    private int roll;
    private int coinNumber;
    private int starNumber;
    private int redSpaceNumber;
    //private int wins;
    private int totalRoll;
    private Label theLabel;
    private Label coinLabel;
    private Label starLabel;
    private Label spaceLabel;
    
    //Constructors

    public JarioPlayer(String color) {
        this.color = color;
        this.multiplier = 1;
        this.twiceCandy = FALSE;
        this.thriceCandy = FALSE;
        this.spaceNumber = 0;
        this.coinNumber = 10;
        this.starNumber = 0;
        this.redSpaceNumber = 0;
        this.wins = 0;
        this.totalRoll = 0;
        
        twiceButton = new Button("Use a Twice Candy");
        thriceButton = new Button("Use a Thrice Candy");
        rollButton = new Button("Roll the Dice");
        
        getChildren().add(twiceButton);
        getChildren().add(thriceButton);
        getChildren().add(rollButton);
        
        twiceButton.setOnAction(this::processButtonPress);
        thriceButton.setOnAction(this::processButtonPress);
        rollButton.setOnAction(this::processButtonPress);
        
        theLabel = new Label("This is The Label   ");
        starLabel = new Label("Stars: " + starNumber + "   ");
        coinLabel = new Label("Coins: " + coinNumber + "   ");
        spaceLabel = new Label("Space: " + spaceNumber + "   ");
        
        getChildren().add(theLabel);
        getChildren().add(starLabel);
        getChildren().add(coinLabel);
        getChildren().add(spaceLabel);
        
        
        theLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        starLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        coinLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        spaceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
    }
    
    //Methods
    
    public void processButtonPress(ActionEvent event) {
        if (event.getSource() == twiceButton) {
            if (twiceCandy) {
                multiplier = 2;
                theLabel.setText("Twice Candy will be used   ");
            } else {
                theLabel.setText("You're out of Twice Candy   ");
            }
        } else if (event.getSource() == thriceButton) {
            if (thriceCandy) {    
                multiplier = 3;
                theLabel.setText("Thrice Candy will be used   ");
            } else {
                theLabel.setText("You're out of Thrice Candy   ");
            }
        } else if (event.getSource() == rollButton) {
            rollDice();
        }
    }
    
        public void rollDice() {
        Random diceRoll = new Random();
        roll = (diceRoll.nextInt(6) + 1) * multiplier;
        multiplier = 1;
        theLabel.setText("The Dice rolled " + roll + "   ");
        totalRoll = totalRoll + roll;
        playerMove();
    }
    
        public void playerMove() {
            //cause player movement here
            //include method for keeping spaceNumber a loop on max spaces
            spaceNumber = spaceNumber + roll;
            if (spaceNumber > 30) {
                passGo();
            } else if (spaceNumber == 30 || spaceNumber == 27 || spaceNumber == 5 || spaceNumber == 11 || spaceNumber == 20) {
                redSpace();
            } else {
                blueSpace();
            }
            finishTurn();
            //show movement on board here
        }
        
        public void redSpace() {
            coinNumber = Math.max(coinNumber - 5, 0);
            redSpaceNumber = redSpaceNumber + 1;
        }
        
        public void blueSpace() {
            coinNumber = coinNumber + 3;
        }
        
        public void passGo() {
            if (coinNumber >= 20) {
                coinNumber = coinNumber - 20;
                starNumber = starNumber + 1;
                theLabel.setText("You Got a Star!   ");
            } else {
                theLabel.setText("You Couldnt Afford a Star   ");
            }
            spaceNumber = 0 + (spaceNumber - 30);
        }
    
        public void finishTurn() {
            starLabel.setText("Stars: " + starNumber + "   ");
            coinLabel.setText("Coins: " + coinNumber + "   ");
            spaceLabel.setText("Space: " + spaceNumber + "   ");
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

    public boolean getTwiceCandy() {
        return twiceCandy;
    }

    public void setTwiceCandy(boolean twiceCandy) {
        this.twiceCandy = twiceCandy;
    }

    public boolean getThriceCandy() {
        return thriceCandy;
    }

    public void setThriceCandy(boolean thriceCandy) {
        this.thriceCandy = thriceCandy;
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

    public Button getTwiceButton() {
        return twiceButton;
    }

    public void setTwiceButton(Button twiceButton) {
        this.twiceButton = twiceButton;
    }

    public Button getThriceButton() {
        return thriceButton;
    }

    public void setThriceButton(Button thriceButton) {
        this.thriceButton = thriceButton;
    }
    
}
