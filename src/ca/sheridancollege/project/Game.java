/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 *
 */
package ca.sheridancollege.project;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods given.
 *
 * @author dancye, 2018
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
    
//    public User checkWin(){
//        if((p.cardTotal() > d.cardTotal()) && (p.cardTotal() <= 21) )
//            return p;
//        else if(d.cardTotal() > p.cardTotal() && (d.cardTotal() <= 21))
//            return d;
//        else
//            return null;
//    }
//    
//    public boolean checkBust() {
//        if (p.cardTotal() > 21 || d.cardTotal() > 21) {
//            return true;
//        }
//        return false;
//    }
}//end class