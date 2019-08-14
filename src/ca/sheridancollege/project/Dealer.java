package ca.sheridancollege.project;

/**
 * @author Brydon Parsons
 * @author Adit Tandon
 * @author Vlad Crihan
 * @author Saharsh Raina
 * 
 * Class models the dealer AI that is derived from the User class
 */
public class Dealer extends User{

    public Dealer(){
    }

    ;
    
    /**
     * @return boolean Returns true/false when the method executes
     * 
     * This method is used for calculating if the dealer has a total value of 
     * cards less than 16 or not
    */
    public boolean check(){
        boolean temp = false;
        if(super.cardTotal() < 16){
            temp = true;
        }
        return temp;
    }
}
