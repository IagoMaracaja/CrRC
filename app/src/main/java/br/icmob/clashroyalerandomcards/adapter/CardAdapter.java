package br.icmob.clashroyalerandomcards.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import br.icmob.clashroyalerandomcards.R;
import br.icmob.clashroyalerandomcards.model.Card;

/**
 * Created by iago on 23/09/16.
 */
public class CardAdapter extends BaseAdapter {
    private List<Card> mCards;
    private Context context;
    private int mLayoutId;

    public CardAdapter(Context context, List<Card> cardValues, int layoutId) {
        this.context = context;
        this.mCards = cardValues;
        this.mLayoutId = layoutId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = inflater.inflate(mLayoutId, null);

            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_item_image);
            imageView.setImageResource(mCards.get(position).getmId());
        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getmLayoutId() {
        return mLayoutId;
    }

    public void setmLayoutId(int mLayoutId) {
        this.mLayoutId = mLayoutId;
    }

    @Override
    public int getCount() {
        return mCards.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public List<Card> getmCards() {
        return mCards;
    }

    public void setmCards(List<Card> mCards) {
        this.mCards = mCards;
    }
}
