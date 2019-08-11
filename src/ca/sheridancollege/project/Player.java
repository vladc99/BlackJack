package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 *
 * @author dancye, 2018
 */
public class Player extends User{

    private String playerID; //the unique ID for this player
    private Balance balance;

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    
    public Player(String name) {
        playerID = name;
        balance = new Balance();
    }

    /**
     * @return the playerID
     */
    public Balance getBalance() {
        return balance;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }
    
    public String printBalance(){
        return "Balance Total: $"+balance.getTotalBalance();
    }
}