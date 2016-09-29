package br.icmob.clashroyalerandomcards.enuns;

/**
 * Created by Bruno on 23/09/2016.
 */

public enum CardTypeEnum {
    CONSTRUCTION("Construção"),TROOP("Tropa"),SPELL("Feitiço");

    public String typeCard;
    CardTypeEnum(String value) {
        typeCard = value;
    }
}
