/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * @author Brydon Parsons
 * @author Vlad Crihan 
 * @author Adit Tandon
 */
public abstract class User {
    
    private ArrayList<Card> hand = new ArrayList<>();
    
    public void addCard(Card card) {
        hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
    
    public int cardTotal() {
        int total = 0;
        for (int i = 0; i < hand.size(); i++) {
            total += hand.get(i).getValue().getValue();
        }
        
        return total;
    }
    
    public double stand() {
        return cardTotal();
    }
    
    public String printHand(String name){
        name += "'s hand\n";
        for (int i = 0; i < hand.size(); i++) {
            name += hand.get(i)+"\n";
        }
        name += "Total: " + cardTotal()+"\n";
        return name;
    }
}