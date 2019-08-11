/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author lpuad
 */
public class Balance {
    
    private double totalBalance;
    
    public double getTotalBalance() {
        return totalBalance;
    }
    
    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }
    
    public double loseBalance(double money) {
        totalBalance = totalBalance - money;
        return totalBalance;
    }
    
    public double addBalance(double money) {
        totalBalance = totalBalance + money;
        return totalBalance;
    }
}