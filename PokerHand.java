import java.util.*;
/**
 * This class creates the hand and checks it for ranked hands.
 * 
 * @Zachary Propert
 * @11/25/2015
 */

public class PokerHand
{
    private ArrayList<Card> hand;
    private int pairVal;

    /**
     * Constructor for class PokerHand initializing the current hand
     */
    public PokerHand(Card card1, Card card2, Card card3)
    {

        hand = new ArrayList<Card> ();

        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
    }

    /** 
     * @return Returns a value for each rank of card 
     *  The value is then used in class Poker to be added to a list to be used as a frequency summary
     */
    public int eval2()
    {
        int val = 1;
        if(isPair()){ //2 = Pair
            val = 2;
        }
        if(isThreeKind()){ //3 = Three of a Kind
            val = 3;
        }
        if(isFlush()){ //35 = Flush
            val = 35;
        }
        if(isStraight()){ //17 = Straight
            val = 17;
        }
        if( isFlush() && isStraight()){ //23 = Straight Flush
            val = 23;
        }
        return val;
    }

    /**
     * Tests for the highest rank of the hand and returns a description like 
     * "Straight from 9 of Diamonds to Jack of Diamonds","Flush in the suit Diamonds", 
     * or "High Card is the 10 of Diamonds"
     *          
     * @return Returns the ranking of each hand
     */
    public String evaluate()
    {
        String temp = "High Card is the " + getHighCard();
        if(isFlush()){
            temp = "Flush in the suit " + hand.get(0).getSuit();
        }
        if(isStraight()){
            temp = "Straight from " + getLowCard() + " to " + getHighCard();
        }
        if( isFlush() && isStraight()){
            temp = "Straight Flush from " + getLowCard() + " to " + getHighCard();
        }
        if(isPair()){
            temp = "Pair of " + pairVal + "s";
        }
        if(isThreeKind()){
            temp = "Three of a Kind in " + hand.get(0).getValue() + "s";
        }
        return temp;
    }

    /**
     * Checks if the current hand is a flush
     * @return returns true if all cards are the same suit
     */
    public boolean isFlush()
    {
        boolean sameSuit=true;
        String testSuit = hand.get(0).getSuit();
        for(Card c: hand){
            if(hand.get(1).getSuit().equals(testSuit) && hand.get(2).getSuit().equals(testSuit)){
                sameSuit=true;
            }else{            
                sameSuit=false;
            }

        }
        return sameSuit;
    }

    /**
     * Checks if the current hand is Three of a Kind
     * @return returns true if and only if the cards are three of a kind
     */
    public boolean isThreeKind()
    {
        boolean sameNum=false;
        int testValue = hand.get(0).getValue();
        for(Card c: hand){
            if(hand.get(1).getValue() == testValue && hand.get(2).getValue() == testValue){
                sameNum=true;
            }else{            
                sameNum=false;
            }
        }
        return sameNum;
    }

    /**
     * Checks if the current hand is a Straight
     * @return returns true if cards are all in sequence
     */
    public boolean isStraight()
    {
        boolean inOrder=false;
        int high = 0;
        int low = 14;

        for(Card c: hand){
            if(hand.get(0).getValue() + 1 == hand.get(1).getValue() && hand.get(1).getValue() + 1 == hand.get(2).getValue()){
                inOrder=true;
            }
            if(hand.get(0).getValue() + 2 == hand.get(1).getValue() && hand.get(1).getValue() - 1 == hand.get(2).getValue()){
                inOrder=true;
            }
            if(hand.get(0).getValue() + 2 == hand.get(1).getValue() && hand.get(1).getValue() - 2 == hand.get(2).getValue()){
                inOrder=true;
            }
            if(hand.get(0).getValue() - 1 == hand.get(1).getValue() && hand.get(1).getValue() + 2 == hand.get(2).getValue()){
                inOrder=true;
            }
            if(hand.get(0).getValue() - 2 == hand.get(1).getValue() && hand.get(1).getValue() + 1 == hand.get(2).getValue()){
                inOrder=true;
            }
            if(hand.get(0).getValue() - 1 == hand.get(1).getValue() && hand.get(1).getValue() - 1 == hand.get(2).getValue()){
                inOrder=true;
            }
        }
        return inOrder;
    }

    /**
     * Checks if the current hand is a Pair
     * @return returns true is there is a numeric pair within the hand 
     */
    public boolean isPair()
    {
        boolean pair = false;
        for(Card c:hand){
            if( hand.get(0).getValue() == hand.get(1).getValue() || hand.get(0).getValue() == hand.get(2).getValue()){
                pairVal = hand.get(0).getValue();
                pair = true;
            }else if( hand.get(1).getValue() == hand.get(2).getValue()){
                pairVal = hand.get(1).getValue();
                pair = true;
            }else{
                pair = false;
            }
        }
        return pair;
    }

    /**
     * Gets the high card of the hand
     * @return returns the high card of the hand
     */
    public String getHighCard()
    {
        String highCard = " ";
        for(Card c:hand){
            if( hand.get(0).getValue() >= hand.get(1).getValue() && hand.get(0).getValue() > hand.get(2).getValue()){
                highCard = hand.get(0).toString();
            }else if( hand.get(1).getValue() >= hand.get(2).getValue()){
                highCard = hand.get(1).toString();
            }else{
                highCard = hand.get(2).toString();
            }
        }
        return highCard;
    }

    /**
     * Gets the low card of the hand
     * Used for evaluate method for a Straight and Straight Flush
     * @return returns the low card of the hand
     * 
     */
    public int getLowCard()
    {
        int lowCard = 14;
        for(Card c:hand){
            if( hand.get(0).getValue() <= hand.get(1).getValue() && hand.get(0).getValue() < hand.get(2).getValue()){
                lowCard = hand.get(0).getValue();

            }else if( hand.get(1).getValue() <= hand.get(2).getValue()){
                lowCard = hand.get(1).getValue();
            }else{
                lowCard = hand.get(2).getValue();
            }
        }
        return lowCard;
    }

    /**
     * Puts the current hand into a string to then be referenced to be outputed to the screen
     * @return turns the current hand into a string
     */
    public String toString()
    {
        return hand.get(0).toString() + ", " + hand.get(1).toString() + ", " + hand.get(2).toString();
    }

}
