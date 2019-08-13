package ca.sheridancollege.project;

import java.util.*;

/**
 * @author Brydon Parsons
 * @author Vlad Crihan
 * @author Adit Tandon
 */
public class Deck{

    private ArrayList<Card> deck = new ArrayList<>();

    public Deck(){

        //Code to build a deck of 52 cards
        for(int i = 0; i < 4; i++){// 4 suits
            for(int j = 2; j < 14; j++){// Cards 2-10
                deck.add(new Card(j, i));
            }
        }
        Collections.shuffle(deck);//Shuffle the deck
    }

    public int getDeckSize(){
        return deck.size();
    }

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
