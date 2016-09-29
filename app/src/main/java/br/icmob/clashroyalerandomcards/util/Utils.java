package br.icmob.clashroyalerandomcards.util;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

import java.util.ArrayList;
import java.util.List;

import br.icmob.clashroyalerandomcards.R;
import br.icmob.clashroyalerandomcards.model.Card;
import br.icmob.clashroyalerandomcards.model.Filter;

/**
 * Created by iago on 26/09/16.
 */

public final class Utils {

    public static List<Filter> generateTypeFilter(Context context) {
        List<Filter> filters = new ArrayList<>();
        Filter building = new Filter();
        building.setEnable(true);
        building.setDescription(context.getString(R.string.building));
        building.setResourceId(R.drawable.cabana_do_goblin);

        Filter troop = new Filter();
        troop.setEnable(true);
        troop.setDescription(context.getString(R.string.troop));
        troop.setResourceId(R.drawable.bomber);

        Filter spell = new Filter();
        spell.setEnable(true);
        spell.setDescription(context.getString(R.string.spell));
        spell.setResourceId(R.drawable.veneno);

        filters.add(building);
        filters.add(troop);
        filters.add(spell);

        return filters;
    }

    public static List<Filter> generateRarityFilter(Context context) {
        List<Filter> filters = new ArrayList<>();
        Filter common = new Filter();
        common.setEnable(true);
        common.setDescription(context.getString(R.string.commom));
        common.setResourceId(R.drawable.arqueiras);

        Filter rare = new Filter();
        rare.setEnable(true);
        rare.setDescription(context.getString(R.string.rare));
        rare.setResourceId(R.drawable.valquiria);

        Filter epic = new Filter();
        epic.setEnable(true);
        epic.setDescription(context.getString(R.string.epic));
        epic.setResourceId(R.drawable.exercito_de_esqueletos);

        Filter legendary = new Filter();
        legendary.setEnable(true);
        legendary.setDescription(context.getString(R.string.legendary));
        legendary.setResourceId(R.drawable.tronco);


        filters.add(common);
        filters.add(rare);
        filters.add(epic);
        filters.add(legendary);

        return filters;
    }


    // TODO: 28/09/16 Refactoring below

    /**
     * Do a average cost of a card list;
     * @param cards list of cards
     * @return average cost
     */
    public static String getAverageCost(List<Card> cards){
        double result = 0.0;
        for (int i = 0; i < cards.size(); i++) {
            result += cards.get(i).getmCost();
        }
        result /= cards.size();
        String value = String.format("%.1f", result);
        return value;
    }

    public static String LogTag = "crrcService";
    public static String EXTRA_MSG = "extra_msg";


    public static boolean canDrawOverlays(Context context){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }else{
            return Settings.canDrawOverlays(context);
        }


    }

}
