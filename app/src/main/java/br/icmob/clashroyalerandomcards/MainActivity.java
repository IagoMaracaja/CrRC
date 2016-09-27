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
import android.widget.Toast;

import java.util.List;

import br.icmob.clashroyalerandomcards.business.CardBusiness;
import br.icmob.clashroyalerandomcards.model.Card;

/**
 * Created by iago on 23/09/16.
 */
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
    /**
     * ImageView for ok button
     */
    private ImageView mIvOk;
    /**
     * ImageView for block button
     */
    private ImageView mIvBlock;
    /**
     * ImageView for refresh button
     */
    private ImageView mIvRefresh;
    /**
     * TextView for elixir average vost
     */
    private TextView mTvCost;
    /**
     * Adapter for fixed cards
     */
    private CardAdapter mCardAdapterFixed;
    /**
     * Rarity filter adapter
     */
    private FilterAdapter mFilterRarityAdapter;
    /**
     * Type filter adapter
     */
    private FilterAdapter mFilterTypeAdapter;
    /**
     * List of random cards
     */
    private List<Card> mRandomCards;

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
        CardAdapter cardAdapter = new CardAdapter(this, generateRandomCards(), R.layout.cards_item_adapter);
        mGridView.setAdapter(cardAdapter);


        Animation animation = AnimationUtils.loadAnimation(this, R.anim.grid_item_anim);
        GridLayoutAnimationController controller = new GridLayoutAnimationController(animation, .2f, .2f);
        mGridView.setLayoutAnimation(controller);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Card card = mRandomCards.get(position);
                showCardOptions(card);
            }
        });

    }

    /**
     * Start a fixed grid view
     */
    private void startFixedGridView() {
        mGridViewFixed = (GridView) findViewById(R.id.grid_fixed_cads);

        mCardAdapterFixed = new CardAdapter(this, getFixedCards(),
                R.layout.cards_fixed_item_adapter);

        mGridViewFixed.setAdapter(mCardAdapterFixed);
    }

    /**
     * Fill dialog filter
     */
    private void fillDialogFilter() {
        LayoutInflater li = getLayoutInflater();

        final View view = li.inflate(R.layout.filter_layout, null);
        mGridViewFilterRarity = (GridView) view.findViewById(R.id.grid_cards_filter_rarity);
        mGridViewFilterType = (GridView) view.findViewById(R.id.grid_cards_filter_type);


        mFilterRarityAdapter = new FilterAdapter(this, Utils.generateRarityFilter(this),
                R.layout.filter_item_adapter);

        mFilterTypeAdapter = new FilterAdapter(this, Utils.generateTypeFilter(this),
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
     *
     * @param isRarity
     * @return
     */
    public AdapterView.OnItemClickListener changeEnable(final boolean isRarity) {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (isRarity) {
                    boolean oldStatus = mFilterRarityAdapter.getmFilters().get(position)
                            .isEnable();
                    Filter filter = mFilterRarityAdapter.getmFilters().get(position);
                    filter.setEnable(!oldStatus);
                    mGridViewFilterRarity.setAdapter(mFilterRarityAdapter);
                } else {
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
     * generate random cards
     *
     * @return list of random cards
     */
    public List<Card> generateRandomCards() {
        mRandomCards = new CardBusiness().getCardsRandomAndFixed();
        fillAverageCost(Utils.getAverageCost(mRandomCards));
        return mRandomCards;
    }

    /**
     * Set the average cost on TextView
     *
     * @param cost
     */
    private void fillAverageCost(String cost) {
        mTvCost.setText(cost);
    }

    /**
     * get fixed cards
     *
     * @return list of fixed cards
     */
    public List<Card> getFixedCards() {
        return new CardBusiness().getFixedCards();
    }

    /**
     * Open a dialog to show option of card.
     */
    public void showCardOptions(final Card card) {
        LayoutInflater li = getLayoutInflater();

        final View view = li.inflate(R.layout.card_item_view, null);
        TextView cardTitle = (TextView) view.findViewById(R.id.tv_card_title);
        TextView cardRarity = (TextView) view.findViewById(R.id.tv_card_rarity);
        TextView cardType = (TextView) view.findViewById(R.id.tv_card_type);
        TextView cardDescription = (TextView) view.findViewById(R.id.tv_card_description);
        ImageView cardImage = (ImageView) view.findViewById(R.id.iv_card);

        cardTitle.setText(card.getmName());
        cardRarity.setText(card.getmRarity().name());
        cardType.setText(card.getmType().name());
        cardDescription.setText(card.getmDescription());
        cardImage.setImageResource(card.getmId());

        view.findViewById(R.id.btn_fix).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                List<Card> refreshItems = mCardAdapterFixed.getmCards();
                if (refreshItems.size() >= Constants.MAX_FIXED_CARDS) {
                    Toast.makeText(MainActivity.this, getString(R.string.max_fixed_error_message),
                            Toast.LENGTH_SHORT).show();
                } else {
                    refreshItems.add(card);
                    mCardAdapterFixed = new CardAdapter(MainActivity.this, refreshItems,
                            R.layout.cards_fixed_item_adapter);
                    mGridViewFixed.setAdapter(mCardAdapterFixed);

                    mAlertDialog.dismiss();
                }
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

    /**
     * Initialize menu component
     */
    private void initializeMenu() {
        mIvBlock = (ImageView) findViewById(R.id.iv_block);
        mIvOk = (ImageView) findViewById(R.id.iv_ok);
        mIvRefresh = (ImageView) findViewById(R.id.iv_refresh);
        mTvCost = (TextView) findViewById(R.id.tv_average_elixir_cost);


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

    /**
     * Animation of refresh button
     *
     * @param refresh
     * @return
     */
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
