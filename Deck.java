package blackJack;

import java.util.ArrayList;
import java.util.Random;



public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
    }
    // Creating full deck
    public void createFullDeck(){
        for(Suit cardSuit : Suit.values()){
            for(Value cardValue : Value.values()){
            this.cards.add(new Card(cardSuit,cardValue));
            }
        }
    }
    //shuffle the cards
        public void shuffle(){
            ArrayList<Card> tmpDeck = new ArrayList<Card>();
            Random random = new Random();
            int randomCardIndex = 0;
            int originalSize = this.cards.size();
            int i;
            for(i=0; i<originalSize; ++i){
                randomCardIndex = random.nextInt((this.cards.size()-1 -0) + 1)+ 0;
                tmpDeck.add(this.cards.get(randomCardIndex));
            this.cards.remove(randomCardIndex);
            
            }
            this.cards = tmpDeck;
        }
        
     
     
    @Override
    public String toString(){
        String cardListOutput = " ";
       
        for(Card CardsCard : this.cards){
            cardListOutput += " \n " + CardsCard.toString();
        
        }
            return cardListOutput;
    }
public void removeCard(int i){
         this.cards.remove(i);
     }
     public Card getCard(int i){
         return this.cards.get(i);
     }
     public void addCard(Card addCard){
         this.cards.add(addCard);
     }
     public void draw (Deck comingFrom){
         this.cards.add(comingFrom.getCard(0));
         comingFrom.removeCard(0);
         
     }
     public int deckSize(){
         return this.cards.size();
     }
     
        public void mooveAllTheDeck(Deck moveTo){
            int thisDeckSize = this.cards.size();
            int i ;
            for(    i = 0; i<thisDeckSize; i++){
                moveTo.addCard(this.getCard(i));
                
            }
             for(    i = 0; i< thisDeckSize; i++){
                this.removeCard(0);
                
            }
        }
     
     // Cards Value
     public int cardsValue(){
         int totalValue = 0;
         int i;
         
         for(Card CardsCard : this.cards){
         switch(CardsCard.getValue()){
             case TWO : totalValue += 2;
             break;
             case THREE : totalValue += 3;
             break;
             case FOUR : totalValue += 4;
             break;
             case FIVE : totalValue += 5;
             break;
             case SIX : totalValue += 6;
             break;
             case SEVEN : totalValue += 7;
             break;
             case EIGHT : totalValue += 8;
             break;
             case NINE : totalValue += 9;
             break;
             case TEN : totalValue += 10;
             break;
             case JACK : totalValue += 10;
             break;
             case QUEEN : totalValue += 10;
             break;
             case KING : totalValue += 10;
             break;
             case ACE : 
                 if(totalValue > 10){
                        totalValue += 1;
                 }else{
                 totalValue += 11;
                 }
             break;
         }
        }
         
         return totalValue;
     }
}
