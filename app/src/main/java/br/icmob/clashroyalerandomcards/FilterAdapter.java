package br.icmob.clashroyalerandomcards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by iago on 23/09/16.
 */

public class FilterAdapter extends BaseAdapter {
    private List<Filter> mFilters;
    private Context context;
    private int mLayoutId;

    public FilterAdapter(Context context, List<Filter> filtersValues, int layoutId) {
        this.context = context;
        this.mFilters = filtersValues;
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
            imageView.setImageResource(mFilters.get(position).getResourceId());


            ImageView enabledView = (ImageView) gridView
                    .findViewById(R.id.iv_filter);

            if(mFilters.get(position).isEnable()){
                enabledView.setImageResource(R.drawable.ic_enable);
            }else{
                enabledView.setImageResource(R.drawable.ic_disable);
            }

            TextView textView = (TextView) gridView
                    .findViewById(R.id.filter_description);
            textView.setText(mFilters.get(position).getDescription());

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
        return mFilters.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public List<Filter> getmFilters() {
        return mFilters;
    }

    public void setmFilters(List<Filter> mFilters) {
        this.mFilters = mFilters;
    }
}
