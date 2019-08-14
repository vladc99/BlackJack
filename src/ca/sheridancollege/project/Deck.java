package ca.sheridancollege.project;

import java.util.*;

/**
 * @author Brydon Parsons
 * @author Vlad Crihan
 * @author Adit Tandon
 * 
 * Class models a deck of cards using an ArrayList
 */
public class Deck{

    private ArrayList<Card> deck = new ArrayList<>();
    
    /**
     * Creates 52 Card Objects and added to the ArrayList. The method then 
     * shuffles the ArrayList at the end
    */
    public Deck(){

        //Code to build a deck of 52 cards
        for(int i = 0; i < 4; i++){// 4 suits
            for(int j = 1; j < 14; j++){// Cards 2-10
                deck.add(new Card(j, i));
            }
        }
        Collections.shuffle(deck);//Shuffle the deck
    }

    public int getDeckSize(){
        return deck.size();
    }
    
    /**
     * @return Card
     * 
     * Draws the first card in the ArrayList and returns it and also removes
     * it from the deck
    */
    public Card getTopCard(){
        Card temp = deck.get(0);
        deck.remove(0);
        return temp;
    }
    
    public void printDeck(){
        for(int i = 0; i < deck.size(); i++){
            System.out.println("Suit: " + deck.get(i).getSuit());
            System.out.println("Value: " + deck.get(i).getValue());
            System.out.println();
        }
    }

}
