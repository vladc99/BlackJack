/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vlad
 */
public class TestBlackJack {

    //start of checking for Balance class
    @Test
    public void testLoseBalance() {
        double money = 10;
        Balance instance = new Balance();
        instance.setTotalBalance(100);
        double expResult = 90;
        double result = instance.loseBalance(money);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testAddBalance() {
        double money = 10;
        Balance instance = new Balance();
        instance.setTotalBalance(100);
        double expResult = 110;
        double result = instance.addBalance(money);
        assertEquals(expResult, result, 0.0);
    }//end of balance class testing

    //start of the card class testing
    @Test
    public void testToString() {
        Card instance = new Card(1, 1);
        String expResult = "ACE of HEART";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSuit() {
        Card instance = new Card(1, 1);
        Suit expResult = Suit.HEART;
        Suit result = instance.getSuit(1);
        assertEquals(expResult, result);
    }//end of card class

    //start of checking for Dealer class
    @Test
    public void testCheck() {
        Dealer instance = new Dealer();
        instance.getHand().add(new Card(1, 1));
        boolean expResult = true;
        boolean result = instance.check();
        assertEquals(expResult, result);
    }//end of the dealer class

    //start of checking Deck class
    @Test
    public void testGetDeckSize() {
        Deck instance = new Deck();
        int expResult = 52;
        int result = instance.getDeckSize();
        assertEquals(expResult, result);
    }//end of the Deck class

    //start of checking Game class
    @Test
    public void getWIN_RATIO() {
        Game instance = new Game(new Player("name"), new Dealer(), new Deck());
        double expResult = 1.5;
        double result = instance.getWIN_RATIO();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void getP() {
        Game instance = new Game(new Player("name"), new Dealer(), new Deck());
        String expResult = "name";
        String result = instance.getP().getPlayerID();
        assertEquals(expResult, result);
    }//end of the Game class
}
