import java.util.ArrayList;
/**
 * class Card creates the basic elements needed for a card like the suit and value.
 * 
 * @Zachary Propert
 * @10/26/2015
 */
public class Card
{
    // instance variables - replace the example below with your own
    private String suit;
    private int value; 

    /**
     * Constructor for the class Card
     * Creates a card with a value, and a suit
     */
    public Card(int value, String suit)
    {
        this.suit = suit;
        this.value = value;
    }

    /**
     * @return returns the suit
     */
    public String getSuit()
    {
        return suit;
    }

    /**
     * @return returns the value
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Sets the card value of the face cards to strings. ex. 1 is now "Ace",11 is now "Jack"
     */
    public String toString()
    {
        String Ace = "Ace";
        String Jack = "Jack";
        String Queen = "Queen";
        String King = "King";

        if(value == 1){
            return Ace + " of " + suit;            
        }
        else if(value == 11){
            return Jack + " of " + suit;
        }
        else if(value == 12){
            return Queen + " of " + suit;
        }
        else if(value == 13){
            return King + " of " + suit;
        }
        else {
            return value + " of " + suit;
        }
    }
}
