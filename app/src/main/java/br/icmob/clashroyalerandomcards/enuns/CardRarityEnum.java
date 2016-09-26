package br.icmob.clashroyalerandomcards.enuns;

/**
 * Created by Bruno on 23/09/2016.
 */

public enum CardRarityEnum {
    COMMON(1),RARA(2),EPIC(3),LEGENDARY(4);

    public int rarityCard;
    CardRarityEnum(int value) {
        rarityCard = value;
    }
}
