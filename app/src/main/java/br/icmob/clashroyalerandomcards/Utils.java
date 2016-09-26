package br.icmob.clashroyalerandomcards;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iago on 26/09/16.
 */

public final class Utils {


    public static List<Filter> generateTypeFilter(Context context){
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

    public static List<Filter> generateRarityFilter(Context context){
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
}
