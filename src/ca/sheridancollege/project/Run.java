package ca.sheridancollege.project;

import java.util.*;

/**
 * @author Brydon Parsons
 * @author Vlad Crihan
 * @author Adit Tandon
 * @author Saharsh Raina
 * 
 * This class runs the game and consists of all the conditionals responsible 
 * to make sure the game runs smoothly.
 */
public class Run{

    public static void main(String[] args){

        boolean gameOver = false;//Boolean that controls main loop of the game
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your name: ");
        String name = input.nextLine();
        double balance = 0;

        System.out.println("Enter your intial balance: ");
        while(balance <= 0){
            try{
                balance = input.nextDouble();
            }catch(InputMismatchException ex){
                System.out.println("Please only enter numbers: ");
                input.next();
            }
        }

        //Create the Deck and the Game objects
        Deck deck = new Deck();
        Game game = new Game(new Player(name), new Dealer(), deck);

        while(balance < 10){
            if(balance < 10){
                System.out.println("Intial balance should be greater than"
                        + "$10");
                try{
                    balance = input.nextDouble();
                }catch(InputMismatchException ex){
                    System.out.println("Please only enter numbers: ");
                    input.next();
                }
            }
        }
        game.getP().getBalance().setTotalBalance(balance);

        System.out.println("Welcome to BlackJack!");
        while(gameOver == false){// This is the main loop of the game
            double bet = 0;
            if(deck.getDeckSize() < 20){
                deck = new Deck();//Resets deck when it gets low
            }
            System.out.println("Please enter your bet(Minimum $10): ");
            try{
                bet = input.nextDouble();
            }catch(InputMismatchException ex){
                System.out.println("Please only enter numbers: ");
                input.next();
            }
            //Check Bet > Balance
            while(bet > game.getP().getBalance().getTotalBalance()){
                System.out.println("Your bet is more than your balance. "
                        + "Enter a new bet");
                try{
                    bet = input.nextDouble();
                }catch(InputMismatchException ex){
                    System.out.println("Please only enter numbers: ");
                    input.next();
                }
            }
            //Make sure bet is an Integer > 10
            while(bet < 10){
                try{
                    System.out.println("Minimum bet should be $10! \nEnter again");
                    bet = input.nextDouble();
                }catch(InputMismatchException ex){
                    System.out.println("Please only enter numbers: ");
                    input.next();
                }
            }
            //Player get's 2 cards
            for(int i = 0; i < 2; i++){
                game.getP().addCard(game.getDeck().getTopCard());
            }
            //Dealer get's a card
            game.getD().addCard(game.getDeck().getTopCard());

            //Print dealer hand
            System.out.println("\n" + game.getD().printHand("Dealer"));

            //Print user hand
            System.out.println(game.getP().printHand(
                    game.getP().getPlayerID()));

            //start of the player's turn
            System.out.println(game.getP().getPlayerID() + "'s turn: ");
            System.out.println("Would you like to HIT or STAND?");
            String action = "";

            //Check for Hit or Stand
            action = input.next().toUpperCase();
            while(!action.equals("HIT") && !action.equals("STAND")){
                System.out.println("Please choose Hit or Stand");
                action = input.next().toUpperCase();
            }

            //Player Hit
            boolean playerBusted = false;
            while(action.equals("HIT")){
                game.getP().addCard(game.getDeck().getTopCard());
                if(game.getP().cardTotal() > 21){
                    System.out.println("\n" + game.getP().printHand(name));
                    System.out.println("Dealer won! Player busted");
                    playerLose(game, bet);
                    playerBusted = true;
                    break;
                }
                //Promt player for next action Hit or Stand
                System.out.println("\n" + game.getP().printHand(name));
                System.out.println("Would you like to HIT or STAND?");
                action = input.next().toUpperCase();

            }

            //Dealer's turn
            boolean dealerBusted = false;
            if(!playerBusted){
                game.getD().addCard(game.getDeck().getTopCard());
                System.out.println("\n" + game.getD().printHand("Dealer"));
                while(game.getD().cardTotal() < 16){
                    System.out.println("*** Dealer Draws ***");
                    game.getD().addCard(game.getDeck().getTopCard());
                    System.out.println(game.getD().printHand("Dealer"));
                    if(game.getD().cardTotal() > 21){
                        System.out.println(game.getD().printHand("Dealer"));
                        playerWin(game, bet);
                        dealerBusted = true;
                        break;
                    }
                }
            }

            //Check for win
            if(!dealerBusted && !playerBusted){
                if(game.getP().cardTotal() > game.getD().cardTotal()){
                    playerWin(game, bet);
                }else{
                    playerLose(game, bet);
                }
            }

            //Print Balance of Player
            System.out.println(game.getP().printBalance());

            //Ask player if you want to play again
            if(game.getP().getBalance().getTotalBalance() > 10){
                System.out.println("Do you want to play again? (Yes/No)");
                if(input.next().toUpperCase().equals("NO")){
                    gameOver = true;
                }else{
                    System.out.println("\n");
                    for(int i = 0; i < 100; i++){
                        System.out.print("-");
                    }
                    System.out.println("\n\n");
                }
            }else{
                System.out.println("Not enough money to play again. "
                        + "Time to visit the bank!");
                gameOver = true;
            }

            //Reset Player & Dealer's Hand objects
            game.getP().getHand().clear();
            game.getD().getHand().clear();
        }
    }

    /**
     * @param game Game object being passed in
     * @param bet Variable representing the bet 
     * 
     * Calculates the amount the player wins and prints out a winning statement
    */
    private static void playerWin(Game game, double bet){
        game.getP().getBalance().addBalance(
                bet * game.getWIN_RATIO());
        System.out.println(game.getP().getPlayerID() + " won $"
                + bet * game.getWIN_RATIO());
    }

    /**
     * @param Game Game object being passed in
     * @param bet Variable representing the bet 
     * 
     * Calculates the amount the player loses and prints out a losing statement
    */
    private static void playerLose(Game game, double bet){
        game.getP().getBalance().loseBalance(bet);
        System.out.println("Dealer wins\n" + game.getP().getPlayerID()
                + " lost $" + bet);
    }
}
