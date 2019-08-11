/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 *
 */
package ca.sheridancollege.project;

/**
 * @author Brydon Parsons
 * @author Vlad Crihan 
 * @author Adit Tandon
 */
public class Game{
    
    private Player p;
    private Dealer d;
    private Deck deck;
    private final double WIN_RATIO = 1.5;

    public Game(Player p, Dealer d, Deck deck) {
        this.p = p;
        this.d = d;
        this.deck = deck;
    }

    public double getWIN_RATIO() {
        return WIN_RATIO;
    }
    
    public Player getP() {
        return p;
    }

    public Dealer getD() {
        return d;
    }

    public Deck getDeck() {
        return deck;
    }
}