package ca.sheridancollege.project;

/**
 * @author Brydon Parsons
 * @author Vlad Crihan
 * @author Adit Tandon
 *
 * This class contains the methods for calculating losses and wins and adding
 * it to the player's overall balance
 */
public class Balance{

    private double totalBalance;
    
    /**
     * @return double A getter for the totalBalance variable
    */
    public double getTotalBalance(){
        return totalBalance;
    }
    
    /**
     * @param totalBalance Money being added to a player's balance
    */
    public void setTotalBalance(double totalBalance){
        this.totalBalance = totalBalance;
    }
    
    /**
     * @param money Bet amount
     * @return double Returns the final calculation
     * 
     * Method returns how much the totalBalance is after bet is subtracted
     * from it
    */
    public double loseBalance(double money){
        totalBalance = totalBalance - money;
        return totalBalance;
    }
    
    /**
     * @param money Bet amount
     * @return double The final amount after calculation
     * 
     * Method returns totalBalance after adding the money to it
    */
    public double addBalance(double money){
        totalBalance = totalBalance + money;
        return totalBalance;
    }
}
