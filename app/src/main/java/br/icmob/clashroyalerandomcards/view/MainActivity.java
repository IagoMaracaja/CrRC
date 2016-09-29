package br.icmob.clashroyalerandomcards.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.icmob.clashroyalerandomcards.R;
import br.icmob.clashroyalerandomcards.adapter.CardAdapter;
import br.icmob.clashroyalerandomcards.adapter.FilterAdapter;
import br.icmob.clashroyalerandomcards.business.CardBusiness;
import br.icmob.clashroyalerandomcards.model.Card;
import br.icmob.clashroyalerandomcards.model.Filter;
import br.icmob.clashroyalerandomcards.service.ChatHeadService;
import br.icmob.clashroyalerandomcards.util.Constants;
import br.icmob.clashroyalerandomcards.util.Utils;

/**
 * Created by iago on 23/09/16.
 */
public class MainActivity extends AppCompatActivity {
    public static List<Card> mRandomCardsChoice;
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
    /**
     * List of fixed cards
     */
    private List<Card> mFixedCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkDrawOverlayPermission();

        initializeMenu();
        startGridView();
        startFixedGridView();

    }

    /**
     * Start deck grid view
     */
    private void startGridView() {
        mGridView = (GridView) findViewById(R.id.grid_cards);
        initAdapter(mGridView, generateRandomCards(), R.layout.cards_item_adapter);


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
     * Init adapter for grid view
     *
     * @param gridView component for adapter
     * @param list     list of cards
     * @param layout   id for layout
     */
    public void initAdapter(GridView gridView, List<Card> list, int layout) {
        CardAdapter cardAdapter = new CardAdapter(this, list, layout);
        gridView.setAdapter(cardAdapter);
    }

    /**
     * Start a fixed grid view
     */
    private void startFixedGridView() {
        mGridViewFixed = (GridView) findViewById(R.id.grid_fixed_cads);

        mCardAdapterFixed = new CardAdapter(this, getFixedCards(),
                R.layout.cards_fixed_item_adapter);
        mGridViewFixed.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Card card = mFixedCards.get(position);
                showCardOptions(card);
            }
        });


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
        mRandomCardsChoice = mRandomCards;
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
        mFixedCards = new CardBusiness().getFixedCards();
        return mFixedCards;
    }

    /**
     * Open a dialog to show option of card.
     */
    public void showCardOptions(final Card card) {
        LayoutInflater li = getLayoutInflater();
        final boolean isFixed = checkIsFixed(card);

        final View view = li.inflate(R.layout.card_item_view, null);
        TextView cardTitle = (TextView) view.findViewById(R.id.tv_card_title);
        TextView cardRarity = (TextView) view.findViewById(R.id.tv_card_rarity);
        TextView cardType = (TextView) view.findViewById(R.id.tv_card_type);
        TextView cardDescription = (TextView) view.findViewById(R.id.tv_card_description);
        ImageView cardImage = (ImageView) view.findViewById(R.id.iv_card);
        Button fixButton = (Button) view.findViewById(R.id.btn_fix);

        cardTitle.setText(card.getmName());
        cardRarity.setText(card.getmRarity().name());
        cardType.setText(card.getmType().name());
        cardDescription.setText(card.getmDescription());
        cardImage.setImageResource(card.getmId());

        if (isFixed) {
            fixButton.setText(getString(R.string.unpin));
        } else {
            fixButton.setText(getString(R.string.pin));
        }

        fixButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                List<Card> refreshItems = mCardAdapterFixed.getmCards();

                if (isFixed) {
                    refreshItems.remove(card);
                    initAdapter(mGridViewFixed, refreshItems, R.layout.cards_fixed_item_adapter);
                    mAlertDialog.dismiss();
                } else {
                    if (refreshItems.size() >= Constants.MAX_FIXED_CARDS) {
                        Toast.makeText(MainActivity.this, getString(R.string.max_fixed_error_message),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        refreshItems.add(card);
                        initAdapter(mGridViewFixed, refreshItems, R.layout.cards_fixed_item_adapter);
                        mAlertDialog.dismiss();
                    }

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

    private boolean checkIsFixed(Card card) {
        for (Card c : mFixedCards) {
            if (card.equals(c)) {
                return true;
            }
        }
        return false;
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
                mRandomCardsChoice = mRandomCards;
                startService(new Intent(MainActivity.this, ChatHeadService.class));

                /*mIvBlock.setClickable(false);
                mIvRefresh.setClickable(false);*/
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

    @Override
    protected void onResume() {
        if (DeckView.active) {
            DeckView.mDeckViewer.finish();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        if (DeckView.active) {
            DeckView.mDeckViewer.finish();
        }
        this.finish();
        super.onPause();
    }
    /** code to post/handler request for permission */
    public final static int REQUEST_CODE = 5463&0xffffff00;

    public void checkDrawOverlayPermission() {
        /** check if we already  have permission to draw over other apps */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                /** if not construct intent to request permission */
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                /** request permission via start activity for result */
                startActivityForResult(intent, REQUEST_CODE);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        /** check if received result code
         is equal our requested code for draw permission  */
        if (requestCode == REQUEST_CODE) {
            /** if so check once again if we have permission */
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (Settings.canDrawOverlays(this)) {

                }
            }
        }
    }

}
