package ca.sheridancollege.project;

import java.util.*;

/**
 *
 * @author Brydon Parsons
 * @author Vlad Crihan 
 * @author Adit Tandon
 */
public class Run {

    public static void main(String[] args) {

        boolean gameOver = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your first name: ");
        String name = input.next();

        System.out.println("Enter your intial balance: ");
        double balance = input.nextDouble();

        Deck deck = new Deck();
        Game game = new Game(new Player(name), new Dealer(), deck);

        while (balance < 10) {
            if (balance < 10) {
                System.out.println("Intial balance should be greater than"
                        + "$10");
                balance = input.nextDouble();
            }
        }
        game.getP().getBalance().setTotalBalance(balance);

        System.out.println("Welcome to BlackJack!");
        while (gameOver == false) {// This is the main loop of the game
            if (deck.getDeckSize() < 20) {
                deck = new Deck();
            }
            System.out.println("Please enter your bet(Minimum $10): ");
            double bet = input.nextDouble();
            while (bet > game.getP().getBalance().getTotalBalance()) {
                System.out.println("Your bet is more than your balance. "
                        + "Enter a new bet");
                bet = input.nextDouble();
            }
            while (bet < 10) {
                System.out.println("Minimum bet should be $10! \nEnter again");
                bet = input.nextDouble();
            }
            //player get's 2 cards
            for (int i = 0; i < 2; i++) {
                game.getP().addCard(game.getDeck().getTopCard());
            }
            //Dealer get's a card
            game.getD().addCard(game.getDeck().getTopCard());

            //print dealer hand
            System.out.println("\n" + game.getD().printHand("Dealer"));

            //print user hand
            System.out.println(game.getP().printHand(
                    game.getP().getPlayerID()));

            //start of the player's turn
            System.out.println(game.getP().getPlayerID() + "'s turn: ");
            System.out.println("Would you like to HIT or STAND?");
            String action = input.next().toUpperCase();

            boolean playerBusted = false;
            while (action.equals("HIT")) {
                game.getP().addCard(game.getDeck().getTopCard());
                if (game.getP().cardTotal() > 21) {
                    System.out.println("\n"+game.getP().printHand(name));
                    System.out.println("Dealer won! Player busted");
                    playerLose(game, bet);
                    playerBusted = true;
                    break;
                }
                System.out.println("\n"+game.getP().printHand(name));
                System.out.println("Would you like to HIT or STAND?");
                action = input.next().toUpperCase();

            }

            //dealer's turn
            boolean dealerBusted = false;
            if (!playerBusted) {
                game.getD().addCard(game.getDeck().getTopCard());
                System.out.println("\n"+game.getD().printHand("Dealer"));
                while (game.getD().cardTotal() < 16) {
                    System.out.println("*** Dealer Draws ***");
                    game.getD().addCard(game.getDeck().getTopCard());
                    System.out.println(game.getD().printHand("Dealer"));
                    if (game.getD().cardTotal() > 21) {
                        System.out.println(game.getD().printHand("Dealer"));
                        playerWin(game, bet);
                        dealerBusted = true;
                        break;
                    }
                }
            }

            //check for win
            if (!dealerBusted && !playerBusted) {
                if (game.getP().cardTotal() > game.getD().cardTotal()) {
                    playerWin(game, bet);

                } else {
                    playerLose(game, bet);
                }
            }

            //print balance
            System.out.println(game.getP().printBalance());

            //ask player if you want to play again
            if (game.getP().getBalance().getTotalBalance() > 10) {
                System.out.println("Do you want to play again?");
                if (input.next().toUpperCase().equals("NO")) {
                    gameOver = true;
                } else {
                    System.out.println("\n");
                    for (int i = 0; i < 100; i++) {
                        System.out.print("-");
                    }
                    System.out.println("\n\n");
                }
            }
            
            //reset hands
            game.getP().getHand().clear();
            game.getD().getHand().clear();
        }
    }

    public static void playerWin(Game game, double bet) {
        game.getP().getBalance().addBalance(
                bet * game.getWIN_RATIO());
        System.out.println(game.getP().getPlayerID() + " won $"
                + bet * game.getWIN_RATIO());
    }

    public static void playerLose(Game game, double bet) {
        game.getP().getBalance().loseBalance(bet);
        System.out.println("Dealer wins\n" + game.getP().getPlayerID()
                + " lost $" + bet);
    }

}
