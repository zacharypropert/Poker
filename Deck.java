import java.util.Random;
import java.util.*;
/**
 * Models a deck of 52 cards
 * 
 * @Zachary Propert 
 * @11/4/2015
 */
public class Deck
{
    private Card [] theDeck; //Creates an array
    int currentCardIndex; //location of next card to deal
    private ArrayList<Card> theHand;

    /**
     * Constructor for objects of class Deck
     * Creates an array of the class Card consisting of 52 cards
     * Creates an array of the possible suits
     * It then goes through a for loop constructing the deck so it is Ace of Hearts, 
     * 2 of Hearts, 3 of Hearts.. and so on until it has all 52 cards with 4 suits of 13 cards
     */
    public Deck()
    {

        theDeck = new Card[52]; //creates an array capable of holding 52 values

        currentCardIndex = 0;
        String [] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

        for(int index=0; index < theDeck.length; index++){
            theDeck[index] = new Card(1+index %13, suits[index/13]);
        }
        shuffle();
    }

    /**
     * Returns current/next in the deck
     */
    public Card deal()
    {
        if(currentCardIndex >= 49){
            shuffle();
        }
        //System.out.println(theDeck[currentCardIndex]);
        return theDeck[currentCardIndex++]; 
    }

    /**
     * References class Card, creating 3 new cards (c1, c2, c3) setting their value with the
     * deal() method
     * Then initializes the constructor for the PokerHand class and creates a new hand
     */
    public PokerHand dealHand()
    {
        Card c1 = deal();
        Card c2 = deal();
        Card c3 = deal();
        
        PokerHand newHand = new PokerHand(c1,c2,c3);
        
        return newHand;
        
    }  

    /**
     * Used to test and make sure the constructor and the deal() method were working properly
     */
    public void tester()
    {
        for(int i=0; i<52; i++)
            System.out.println(deal());
    }

    /**
     * Shuffles the deck, scrambling the order of the cards and resets the 
     * currentCardIndex back to 0. 
     */
    public void shuffle()
    {
        Random rgen = new Random(); 

        for(int first=0; first < theDeck.length; first++){
            int second = rgen.nextInt(52);
            Card temp = theDeck[first];
            theDeck[first] = theDeck[second];
            theDeck[second] = temp;

            //System.out.println(deal());
        }
        currentCardIndex =0;
    }
}

