import java.util.*;

/**
 * This class is the main class for the Poker application. 
 * The Poker application is a simple program that deals out
 * 3 cards per poker hand and tests for the ranking and 
 * outputs the results.
 * 
 * @Zachary Propert 
 * @11/25/2015
 */
public class Poker
{
    private Deck deck;
    private ArrayList<PokerHand> results;

    /**
     * Creates a deck and initializes the ArrayList "results"
     */
    public Poker()
    {
        deck = new Deck();
        results = new ArrayList<PokerHand> (); //ArrayList for the hands dealt
    }

    /**
     * Simulates a hand of poker in a loop based off the value of loopAmount.
     *          ex. if loopAmount = 10 it will deal out 10 hands of 3 cards
     *          
     * The method starts of initializing a HashSet "newSet" which is used to keep track of the rankings 
     *      without allowing duplicates.
     *      
     * Then it intializes an ArrayList "newEvaluate" which is used to
     *      track of the frequency of the rankings that were also added to the HashSet of "newSet". 
     *      ie. how many times "High card is the Jack of Spades" occurs
     *      
     * Then the ArrayList "newEvalTwo" is intialized and recieves the values from the method eval2() in 
     *      class Deck. "newEval" is used for the last set of ranks to keep track of the frequency of
     *      Straight Flush, Straight, Flush, Three of a Kind, Pair, and High Card.
     *      
     * Then a for loop adds the hands to the ArrayList "results" thats initialized in the constructor
     * 
     * In the next for loop the hands in the ArrayList "results" are outputted to the screen and they are
     *      added to the HashSet "newSet", ArrayList "newEvaluate", ArrayList "newEvalTwo"
     *      
     * The next for loop outputs the ranking of hands from the HashSet, and the frequency and percent   
     *      using the Collections.frequency() method, and is outputted to the screen using 
     *      the printf() method.  
     *      
     * The the final frequency is outputted using printf() method and the ArrayList "newEvalTwo", also
     *      also using the Collections.frequency() method for the total times occured and the percentage
     */

    public void simulate(int loopAmount)
    {
        HashSet<String> newSet = new HashSet<String> (); //keep track of rankings, no duplicates
        List<String> newEvaluate = new ArrayList<String> (); //keeps track of frequency for rankings
        List<Integer> newEvalTwo = new ArrayList<Integer> (); // keeps track of rank occurences
        for(int i=0; i < loopAmount; i++)
        {
            results.add(deck.dealHand());
        }
        System.out.println("**************************************************************");
        System.out.println("                    Poker Statistics Report");
        System.out.println("                   Generated from " + loopAmount + " tests");  
        System.out.println("**************************************************************");
        for(PokerHand d: results){
            System.out.println("-----.:  " + d); //prints out the hands
            newEvaluate.add(d.evaluate());
            newSet.add(d.evaluate());
            newEvalTwo.add(d.eval2());
        }
        System.out.println("--------------------------------------------------------------"); 
        System.out.println("RANK                                      # HANDS...   PERCENT"); 
        System.out.println("--------------------------------------------------------------");
        for(String e: newSet) 
            System.out.printf("%-43s %-10d %.1f%s%n", e, Collections.frequency(newEvaluate, e), ((float) Collections.frequency(newEvaluate, e)/loopAmount)*100, "%");
        //prints out evaluate() for each hand and the frequency and percentage

        System.out.println("--------------------------------------------------------------"); 
        System.out.println("RANK                                      # HANDS...   PERCENT"); 
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-43s %-10d %.1f%s%n", "Straight Flush", Collections.frequency(newEvalTwo, 23), ((float) Collections.frequency(newEvalTwo, 23)/loopAmount)*100, "%");
        System.out.printf("%-43s %-10d %.1f%s%n", "Flush", Collections.frequency(newEvalTwo, 35), ((float) Collections.frequency(newEvalTwo, 35)/loopAmount)*100, "%");
        System.out.printf("%-43s %-10d %.1f%s%n", "Straight", Collections.frequency(newEvalTwo, 17), ((float) Collections.frequency(newEvalTwo, 17)/loopAmount)*100, "%");
        System.out.printf("%-43s %-10d %.1f%s%n", "Three of a Kind", Collections.frequency(newEvalTwo, 3), ((float) Collections.frequency(newEvalTwo, 3)/loopAmount)*100, "%");
        System.out.printf("%-43s %-10d %.1f%S%n", "Pair", Collections.frequency(newEvalTwo, 2), ((float) Collections.frequency(newEvalTwo, 2)/loopAmount)*100, "%");
        System.out.printf("%-43s %-10d %.1f%s%n", "High Card", Collections.frequency(newEvalTwo, 1), ((float) Collections.frequency(newEvalTwo, 1)/loopAmount)*100, "%");
    }

    /**
     * Tests if dealHand() is working correctly by outputting 10 hands to the screen
     */
    public void test()
    {        
        for(int i=0; i < 10; i++){
            System.out.println(deck.dealHand());
        }
    }
}
