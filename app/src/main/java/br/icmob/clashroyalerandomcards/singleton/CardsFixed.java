package br.icmob.clashroyalerandomcards.singleton;

import java.util.ArrayList;
import java.util.List;

import br.icmob.clashroyalerandomcards.model.Card;

/**
 * Created by Bruno on 27/09/2016.
 */
public class CardsFixed {
    private static CardsFixed ourInstance = new CardsFixed();
    private static List<Card> fixedCards = new ArrayList<Card>();

    public static CardsFixed getInstance() {
        return ourInstance;
    }

    private CardsFixed() {
    }

    public List<Card> getFixedCards(){
        return this.fixedCards;
    }
    public void fixCard(Card card){
        this.fixedCards.add(card);
    }
    public void removeFixedCard(Card card){
        this.fixedCards.remove(card);
    }
}
