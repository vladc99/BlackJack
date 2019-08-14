package ca.sheridancollege.project;

/**
 * @author Brydon Parsons
 * @author Vlad Crihan
 * @author Adit Tandon
 * @author Saharsh Raina
 * 
 * Class models a player that is derived from the User class
 */
public class Player extends User{

    private String playerID; //the unique ID for this player
    private Balance balance;

    public Player(String name){
        playerID = name;
        balance = new Balance();
    }

    public Balance getBalance(){
        return balance;
    }

    public String getPlayerID(){
        return playerID;
    }
    
    public void setBalance(Balance balance){
        this.balance = balance;
    }
    
    /**
     * Returns a String that has the totalBalance of the Player
     * @return String 
    */
    public String printBalance(){
        return "Balance Total: $" + balance.getTotalBalance();
    }
}
