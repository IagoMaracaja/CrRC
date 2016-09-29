package br.icmob.clashroyalerandomcards.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.List;

import br.icmob.clashroyalerandomcards.R;
import br.icmob.clashroyalerandomcards.adapter.CardAdapter;
import br.icmob.clashroyalerandomcards.model.Card;

/**
 * Created by iago on 28/09/16.
 */
public class DeckView extends Activity {
    public static boolean active = false;
    public static Activity mDeckViewer;
    public GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.grid_random_cards_head);

        mDeckViewer = DeckView.this;
        mGridView = (GridView) findViewById(R.id.grid_cards);
        initAdapter(mGridView, MainActivity.mRandomCardsChoice, R.layout.cards_item_adapter);

        ImageView btn = (ImageView) findViewById(R.id.restart_app);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(DeckView.this, MainActivity.class);
                startActivity(it);
            }
        });

    }

    /**
     * Initi random cards adapter
     * @param gridView
     * @param list
     * @param layout
     */
    public void initAdapter(GridView gridView, List<Card> list, int layout) {
        CardAdapter cardAdapter = new CardAdapter(this, list, layout);
        gridView.setAdapter(cardAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        active = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        active = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        active = false;
    }


}
