package br.icmob.clashroyalerandomcards;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.icmob.clashroyalerandomcards.business.CardBusiness;
import br.icmob.clashroyalerandomcards.model.Card;

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

    /**
     * Doa a average cost of a card list;
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

}
