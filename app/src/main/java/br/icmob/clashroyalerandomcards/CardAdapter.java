package br.icmob.clashroyalerandomcards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by iago on 23/09/16.
 */

public class CardAdapter extends BaseAdapter {
    private Integer[] mCardValues;
    private Context context;
    private int mLayoutId;

    public CardAdapter(Context context, Integer[] cardValues, int layoutId) {
        this.context = context;
        this.mCardValues = cardValues;
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
            imageView.setImageResource(mCardValues[position]);
        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    public Integer[] getmCardValues() {
        return mCardValues;
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
        return mCardValues.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    }
