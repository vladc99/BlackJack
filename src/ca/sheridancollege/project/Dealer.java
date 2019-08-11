/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author Vlad Crihan
 */
public class Dealer extends User {

    public Dealer() {
    }

    ;
    
    public boolean check() {
        boolean temp = false;
        if (super.cardTotal() < 16)
            temp = true;
        return temp;
    }
}
