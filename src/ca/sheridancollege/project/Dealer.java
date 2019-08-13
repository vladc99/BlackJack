package ca.sheridancollege.project;

/**
 * @author Brydon Parsons
 * @author Adit Tandon
 * @author Vlad Crihan
 */
public class Dealer extends User{

    public Dealer(){
    }

    ;

    public boolean check(){
        boolean temp = false;
        if(super.cardTotal() < 16){
            temp = true;
        }
        return temp;
    }
}
