package br.icmob.clashroyalerandomcards.model;


import br.icmob.clashroyalerandomcards.enuns.CardRarityEnum;
import br.icmob.clashroyalerandomcards.enuns.CardTypeEnum;

/**
 * Created by Bruno on 23/09/2016.
 */

public class Card {
    private int mId;
    private String mName;
    private int mCost;
    private CardTypeEnum mType;
    private CardRarityEnum mRarity;
    private String mDescription;

    public Card(int mId, String mName, int mCost, CardTypeEnum mType, CardRarityEnum mRarity, String mDescription){
        this.mId = mId;
        this.mName = mName;
        this.mCost = mCost;
        this.mType = mType;
        this.mRarity = mRarity;
        this.mDescription = mDescription;
    }
    public Card(){}
    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmCost() {
        return mCost;
    }

    public void setmCost(int mCost) {
        this.mCost = mCost;
    }

    public CardTypeEnum getmType() {
        return mType;
    }

    public void setmType(CardTypeEnum mType) {
        this.mType = mType;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public CardRarityEnum getmRarity() {
        return mRarity;
    }

    public void setmRarity(CardRarityEnum mRarity) {
        this.mRarity = mRarity;
    }
}
