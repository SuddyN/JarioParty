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

public class JarioPlayerGUI extends FlowPane {
    //Attributes

    
    private Button twiceButton;
    private Button thriceButton;
    private Button rollButton;
    private Label theLabel;
    private Label coinLabel;
    private Label starLabel;
    private Label spaceLabel;
    private JarioPlayer player1;
    //private JarioPlayer player2;
    //private JarioPlayer player3;
    //private JarioPlayer player4;
    
    
    //Constructors
    public JarioPlayerGUI() {
        
        player1 = new JarioPlayer();        
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
        starLabel = new Label("Stars: " + player1.getStarNumber() + "   ");
        coinLabel = new Label("Coins: " + player1.getCoinNumber() + "   ");
        spaceLabel = new Label("Space: " + player1.getSpaceNumber() + "   ");

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
            if (player1.isThriceCandy()) {
                player1.setMultiplier(2);
                theLabel.setText("Twice Candy will be used   ");
            } else {
                theLabel.setText("You're out of Twice Candy   ");
            }
        } else if (event.getSource() == thriceButton) {
            if (player1.isThriceCandy()) {
                player1.setMultiplier(3);
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
        player1.setRoll((diceRoll.nextInt(6) + 1) * player1.getMultiplier());
        player1.setMultiplier(1);
        theLabel.setText("The Dice rolled " + player1.getRoll() + "   ");
        player1.setTotalRoll(player1.getTotalRoll() + player1.getRoll());
        playerMove();
    }

    public void playerMove() {
        //cause player movement here
        //include method for keeping spaceNumber a loop on max spaces
        player1.setSpaceNumber(player1.getSpaceNumber() + player1.getRoll());
        if (player1.getSpaceNumber() > 30) {
            passGo();
        } else if (player1.getSpaceNumber() == 30 || player1.getSpaceNumber() == 27 || player1.getSpaceNumber() == 5 || player1.getSpaceNumber() == 11 || player1.getSpaceNumber() == 20) {
            redSpace();
        } else {
            blueSpace();
        }
        finishTurn();
        //show movement on board here
    }

    public void redSpace() {
        player1.setCoinNumber(Math.max(player1.getCoinNumber()-5, 0));
        player1.setRedSpaceNumber(player1.getSpaceNumber()+1);
    }

    public void blueSpace() {
        player1.setCoinNumber(player1.getCoinNumber()+3);
    }

    public void passGo() {
        if (player1.getCoinNumber() >= 20) {
            player1.setCoinNumber(player1.getCoinNumber()-20);
            player1.setStarNumber(player1.getStarNumber() + 1);
            
            theLabel.setText("You Got a Star!   ");
        } else {
            theLabel.setText("You Couldnt Afford a Star   ");
        }
        player1.setSpaceNumber(player1.getSpaceNumber()-30);
    }

    public void finishTurn() {
        starLabel.setText("Stars: " + player1.getStarNumber() + "   ");
        coinLabel.setText("Coins: " + player1.getCoinNumber() + "   ");
        spaceLabel.setText("Space: " + player1.getSpaceNumber() + "   ");
    }
    //GetSet

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
