package br.icmob.clashroyalerandomcards.enuns;

/**
 * Created by Bruno on 23/09/2016.
 */

public enum CardRarityEnum {
    COMMON("Comum"),RARA("Rara"),EPIC("Épica"),LEGENDARY("Lendária");

    public String rarityCard;
    CardRarityEnum(String value) {
        rarityCard = value;
    }
}
