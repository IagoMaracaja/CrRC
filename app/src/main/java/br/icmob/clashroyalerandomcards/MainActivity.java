package br.icmob.clashroyalerandomcards;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Grid View
     */
    private GridView mGridView;
    /**
     * Grid view of fixed cards
     */
    private GridView mGridViewFixed;
    /**
     * Items of card lists
     */
    private Integer[] mNumbersOfCards;
    /**
     * Items of fixed card lists
     */
    private Integer[] mNumbersOfFixed;
    /**
     * Alert Dialog for logout action
     */
    private AlertDialog mAlertDialog;
    /**
     * Grid View Rarity Filter
     */
    private GridView mGridViewFilterRarity;
    /**
     * Grid View Type Filter
     */
    private GridView mGridViewFilterType;

    private ImageView mIvOk;
    private ImageView mIvBlock;
    private ImageView mIvRefresh;
    private CardAdapter mCardAdapterFixed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeMenu();
        startGridView();
        startFixedGridView();


    }

    /**
     * Start deck grid view
     */
    private void startGridView() {
        mGridView = (GridView) findViewById(R.id.grid_cards);
        CardAdapter cardAdapter = new CardAdapter(this, createMock(), R.layout.cards_item_adapter);
        mGridView.setAdapter(cardAdapter);


        Animation animation = AnimationUtils.loadAnimation(this, R.anim.grid_item_anim);
        GridLayoutAnimationController controller = new GridLayoutAnimationController(animation, .2f, .2f);
        mGridView.setLayoutAnimation(controller);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                callCardOptionView();
            }
        });

    }

    /**
     * Start a fixed grid view
     */
    private void startFixedGridView() {
        mGridViewFixed = (GridView) findViewById(R.id.grid_fixed_cads);

        mCardAdapterFixed = new CardAdapter(this, createMockToFixedCards(),
                R.layout.cards_fixed_item_adapter);

        mGridViewFixed.setAdapter(mCardAdapterFixed);
    }

    private FilterAdapter mFilterRarityAdapter;
    private FilterAdapter mFilterTypeAdapter;

    /**
     * Fill dialog filter
     */
    private void fillDialogFilter() {
        LayoutInflater li = getLayoutInflater();

        final View view = li.inflate(R.layout.filter_layout, null);
        mGridViewFilterRarity = (GridView) view.findViewById(R.id.grid_cards_filter_rarity);
        mGridViewFilterType = (GridView) view.findViewById(R.id.grid_cards_filter_type);


        mFilterRarityAdapter = new FilterAdapter(this,Utils.generateRarityFilter(this) ,
                R.layout.filter_item_adapter);

        mFilterTypeAdapter = new FilterAdapter(this,Utils.generateTypeFilter(this) ,
                R.layout.filter_item_adapter);

        mGridViewFilterRarity.setAdapter(mFilterRarityAdapter);
        mGridViewFilterType.setAdapter(mFilterTypeAdapter);

        mGridViewFilterRarity.setOnItemClickListener(changeEnable(true));
        mGridViewFilterType.setOnItemClickListener(changeEnable(false));


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);

        mAlertDialog = builder.create();
        mAlertDialog.show();
    }

    /**
     * Listener for filter
     * @param isRarity
     * @return
     */
    public AdapterView.OnItemClickListener changeEnable(final boolean isRarity){
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if(isRarity){
                    boolean oldStatus = mFilterRarityAdapter.getmFilters().get(position)
                            .isEnable();
                    Filter filter = mFilterRarityAdapter.getmFilters().get(position);
                    filter.setEnable(!oldStatus);
                    mGridViewFilterRarity.setAdapter(mFilterRarityAdapter);
                }else{
                    boolean oldStatus = mFilterTypeAdapter.getmFilters().get(position)
                            .isEnable();
                    Filter filter = mFilterTypeAdapter.getmFilters().get(position);
                    filter.setEnable(!oldStatus);
                    mGridViewFilterType.setAdapter(mFilterTypeAdapter);
                }
            }
        };
    }

    /**
     * Mock for development solutions
     *
     * @return
     */
    public Integer[] createMock() {
        mNumbersOfCards = new Integer[8];

        for (int i = 0; i < 8; i++) {
            mNumbersOfCards[i] = R.drawable.arqueiras;
        }
        return mNumbersOfCards;
    }

    /**
     * Mock for development solutions (Fixed Cards)
     *
     * @return
     */
    public Integer[] createMockToFixedCards() {
        mNumbersOfFixed = new Integer[3];
        for (int i = 0; i < 3; i++) {
            mNumbersOfFixed[i] = R.drawable.fixed_card;
        }
        return mNumbersOfFixed;
    }

    /**
     * Open a dialog to show option of card.
     */
    private void callCardOptionView() {
        LayoutInflater li = getLayoutInflater();

        final View view = li.inflate(R.layout.card_item_view, null);
        view.findViewById(R.id.btn_fix).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String cardName = ((TextView) view.findViewById(R.id.tv_card_title)).getText().toString();

                Integer[] refreshItems = mCardAdapterFixed.getmCardValues();
                refreshItems[0] = R.drawable.bomber;
                mCardAdapterFixed = new CardAdapter(MainActivity.this, refreshItems,
                        R.layout.cards_fixed_item_adapter);
                mGridViewFixed.setAdapter(mCardAdapterFixed);

                mAlertDialog.dismiss();
            }
        });

        view.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                mAlertDialog.dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);

        mAlertDialog = builder.create();
        mAlertDialog.show();
    }

    private void initializeMenu() {
        mIvBlock = (ImageView) findViewById(R.id.iv_block);
        mIvOk = (ImageView) findViewById(R.id.iv_ok);
        mIvRefresh = (ImageView) findViewById(R.id.iv_refresh);


        mIvBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillDialogFilter();
            }
        });
        mIvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvBlock.setClickable(false);
                mIvRefresh.setClickable(false);
            }
        });
        mIvRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation animation = refreshAnim(mIvRefresh);
                mIvRefresh.startAnimation(animation);
                startGridView();
            }
        });
    }

    private Animation refreshAnim(ImageView refresh) {
        Animation animation = new RotateAnimation(0.0f, 360.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        animation.setRepeatCount(0);
        animation.setDuration(400);

        refresh.setAnimation(animation);
        return animation;
    }

}
