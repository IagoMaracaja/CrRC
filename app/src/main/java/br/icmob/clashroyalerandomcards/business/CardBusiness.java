package br.icmob.clashroyalerandomcards.business;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.icmob.clashroyalerandomcards.enuns.CardRarityEnum;
import br.icmob.clashroyalerandomcards.enuns.CardTypeEnum;
import br.icmob.clashroyalerandomcards.model.Card;
import br.icmob.clashroyalerandomcards.service.ReadCardService;

/**
 * Created by Bruno on 23/09/2016.
 */

public class CardBusiness {

    private List<Card> cards;

    public CardBusiness(){
        cards = ReadCardService.getCards();
    }

    /**
     * Retorna todas as cartas
     * @return
     */
    public List<Card> getAllCards(){
        return ReadCardService.getCards();
    }

    /**
     *Id da carta, o id da carta pode ser acessado passando algo como R.drawable.arqueiras
     * @param id
     * @return carta associada ao id passado. Retorna nulo se a carta nao existir
     */
    public Card getCard(int id){
        for (Card card : cards) {
            if (card.getmId() == id) {
                return card;
            }
        }
        return null;
    }

    /**
     * Retorna uma lista com 8 cartas aleatoriamente escolhidas
     * @return
     */
    public List<Card> getCardsRandom(){
        return getCardsRandom(8);
    }

    /**
     * Retorna uma lista com cartas aleatoriamente escolhidas
     * @param qttCards Numero de cartas que devem estar contidas na lista
     * @return retorna null se o numero total de cartas for inferior a quantidade solicitada
     */
    public List<Card> getCardsRandom(int qttCards){
        if(qttCards>this.cards.size()){
            return null;
        }
        Random random = new Random();
        List<Card> cardsRandom = new ArrayList<Card>();
        int indice;
        for(int i =0;i<qttCards;i++){
            indice = random.nextInt(cards.size());
            cardsRandom.add(this.cards.get(indice));
            cards.remove(indice);
        }
        cards.addAll(cardsRandom);
        return cardsRandom;
    }

    /**
     * Remove todas as cartas do tipo desejado
     * 1-cartas comuns
     * 2-cartas raras
     * 3-cartas epicas
     * 4-cartas lendarias
     * 5-cartas tropas
     * 6-cartas construcoes
     * 7-cartas feiticos
     * ex: {1,2,5,6}
     * @param preferences
     */
    public void removeCards(int[] preferences){
        for(int i=0;i<preferences.length;i++){
            switch (preferences[i]){
                case 1: removeCards(CardRarityEnum.COMMON);
                case 2: removeCards(CardRarityEnum.RARA);
                case 3: removeCards(CardRarityEnum.EPIC);
                case 4: removeCards(CardRarityEnum.LEGENDARY);
                case 5: removeCards(CardTypeEnum.TROOP);
                case 6: removeCards(CardTypeEnum.CONSTRUCTION);
                case 7: removeCards(CardTypeEnum.SPELL);
            }
        }
    }
    private void removeCards(CardRarityEnum rarity){
        for (Card card : cards) {
            if(card.getmRarity()==rarity){cards.remove(card);}
        }
    }
    private void removeCards(CardTypeEnum type){
        for (Card card : cards) {
            if(card.getmType()==type){cards.remove(card);}
        }
    }
    /**
     * Adiciona todas as cartas do tipo desejado
     * 1-cartas comuns
     * 2-cartas raras
     * 3-cartas epicas
     * 4-cartas lendarias
     * 5-cartas tropas
     * 6-cartas construcoes
     * 7-cartas feiticos
     * ex: {1,2,5,6}
     * @param preferences
     */
    public void allowCards(int[] preferences){
        for(int i=0;i<preferences.length;i++){
            switch (preferences[i]){
                case 1: allowCards(CardRarityEnum.COMMON);
                case 2: allowCards(CardRarityEnum.RARA);
                case 3: allowCards(CardRarityEnum.EPIC);
                case 4: allowCards(CardRarityEnum.LEGENDARY);
                case 5: allowCards(CardTypeEnum.TROOP);
                case 6: allowCards(CardTypeEnum.CONSTRUCTION);
                case 7: allowCards(CardTypeEnum.SPELL);
            }
        }
    }
    private void allowCards(CardRarityEnum rarity){
        for (Card card : getAllCards()) {
            if(card.getmRarity()==rarity && !cards.contains(card)){cards.add(card);}
        }
    }
    private void allowCards(CardTypeEnum type){
        for (Card card : getAllCards()) {
            if(card.getmType()==type && !cards.contains(card)){cards.add(card);}
        }
    }
}
