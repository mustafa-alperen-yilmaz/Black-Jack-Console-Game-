package blackJack;

import java.util.Scanner;

public class BlakJack {

    public static void main(String[] args) {
        System.out.println("wellcome the BlackJack ");
        
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();
        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();
        
        double  playerMoney = 100.00;
        Scanner userInput = new Scanner(System.in);
        
        while(playerMoney > 0){
            System.out.println("you have $ " + playerMoney + " , how much you bet ? ");
            double playerBet = userInput.nextDouble();
            if(playerBet > playerMoney){
                System.out.println(" you havent got enought money ");
                break;
            }
            
            boolean endRound = false;
            
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);
            
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);
            
            while (true) {                
                System.out.println(" Your Hand ");
                System.out.println(playerDeck.toString());
                System.out.println(" Your deck vauled : " + playerDeck.cardsValue());
                
                System.out.println(" Dealer hand :" + dealerDeck.getCard(0).toString() + " and [Hidden] ");
                System.out.println(" would you like [1] hit or [2] stand ");
                int UserChooice = userInput.nextInt();
                if(UserChooice == 1){
                    playerDeck.draw(playingDeck);
                    System.out.println("you draw " + playerDeck.getCard(playerDeck.deckSize() -1));
                    
                    if(playerDeck.cardsValue() > 21){
                        System.out.println("LOOSER" + playerDeck.cardsValue());
                        playerMoney -= playerBet;
                        endRound = true;
                    }
                }
                if (UserChooice == 2) {
                    break;
                }
            }
            System.out.println("Dealer cards " + dealerDeck.toString());
            
            if (dealerDeck.cardsValue() > playerDeck.cardsValue() && endRound == false) {
                System.out.println("DEALER WIN");
                playerMoney -= playerBet;
                endRound = true;
            }
            while (dealerDeck.cardsValue() < 17 && endRound == false) {
               dealerDeck.draw(playingDeck);
                System.out.println(" Dealer draws " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
            }
            System.out.println(" Dealers hand is vauleted " + dealerDeck.cardsValue());
            if ((dealerDeck.cardsValue() >21) && endRound == false) {
                System.out.println("Dealer busts! . YOU WIN" );
                endRound = true;
            }
            if ((playerDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false) {
                System.out.println(" PUSH ");
                endRound = true;
            }
            if((playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false){
                System.out.println(" YOU WIN ");
                playerMoney += playerBet;
                endRound = true;
            }
            else if(endRound == false){
                System.out.println(" YOU LOSE ");
                playerMoney -= playerBet;
                endRound = true;
        }
           
            playerDeck.mooveAllTheDeck(playingDeck);
            dealerDeck.mooveAllTheDeck(playingDeck);
            System.out.println(" End of the hand ");
        }
        System.out.println("Game Over !!!");
    }
    
}
