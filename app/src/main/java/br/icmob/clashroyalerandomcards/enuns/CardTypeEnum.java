package br.icmob.clashroyalerandomcards.enuns;

/**
 * Created by Bruno on 23/09/2016.
 */

public enum CardTypeEnum {
    CONSTRUCTION(1),TROOP(2),SPELL(3);

    public int typeCard;
    CardTypeEnum(int value) {
        typeCard = value;
    }
}
