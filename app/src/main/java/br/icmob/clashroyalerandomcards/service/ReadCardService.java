package br.icmob.clashroyalerandomcards.service;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.icmob.clashroyalerandomcards.R;
import br.icmob.clashroyalerandomcards.enuns.CardCostEnum;
import br.icmob.clashroyalerandomcards.enuns.CardIdEnum;
import br.icmob.clashroyalerandomcards.enuns.CardRarityEnum;
import br.icmob.clashroyalerandomcards.enuns.CardTypeEnum;
import br.icmob.clashroyalerandomcards.model.Card;

/**
 * Created by Bruno on 23/09/2016.
 */

public class ReadCardService {

    private static List<Card> cards;

    public static List<Card> getCards(Context mContext){
        cards = new ArrayList<>();
        cards.add(new Card(CardIdEnum.ARQUEIRA.getValue(),mContext.getString(R.string.archers), CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, mContext.getString(R.string.archers_description)));
        cards.add(new Card(CardIdEnum.BALAO.getValue(), mContext.getString(R.string.ballon), CardCostEnum.FIVE.costCard, CardTypeEnum.TROOP, CardRarityEnum.EPIC, mContext.getString(R.string.ballon_description)));
        cards.add(new Card(CardIdEnum.BARBAROS.getValue(), mContext.getString(R.string.barbarians), CardCostEnum.FIVE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, mContext.getString(R.string.barbarians_description)));
        cards.add(new Card(CardIdEnum.BARRIL_DE_GOBLIN.getValue(), mContext.getString(R.string.goblin_barril), CardCostEnum.THREE.costCard, CardTypeEnum.SPELL, CardRarityEnum.EPIC, mContext.getString(R.string.goblin_barril_description)));
        cards.add(new Card(CardIdEnum.BOLA_DE_FOGO.getValue(), mContext.getString(R.string.fireball), CardCostEnum.FOUR.costCard, CardTypeEnum.SPELL, CardRarityEnum.RARA, mContext.getString(R.string.fireball_description)));
        cards.add(new Card(CardIdEnum.BOMBER.getValue(), mContext.getString(R.string.bomber), CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, mContext.getString(R.string.bomber_description)));
        cards.add(new Card(CardIdEnum.BRUXA.getValue(), mContext.getString(R.string.witch), CardCostEnum.FIVE.costCard, CardTypeEnum.TROOP, CardRarityEnum.EPIC, mContext.getString(R.string.witch_description)));
        cards.add(new Card(CardIdEnum.CABANA_DO_BARBARO.getValue(), mContext.getString(R.string.barbarian_hut), CardCostEnum.SEVEN.costCard, CardTypeEnum.CONSTRUCTION, CardRarityEnum.RARA, mContext.getString(R.string.barbarians_description)));
        cards.add(new Card(CardIdEnum.CABANA_DO_GOBLIN.getValue(), mContext.getString(R.string.goblin_hut), CardCostEnum.FIVE.costCard, CardTypeEnum.CONSTRUCTION, CardRarityEnum.RARA, mContext.getString(R.string.goblin_hut_description)));
        cards.add(new Card(CardIdEnum.CANHAO.getValue(), mContext.getString(R.string.cannon), CardCostEnum.THREE.costCard, CardTypeEnum.CONSTRUCTION, CardRarityEnum.COMMON, mContext.getString(R.string.cannon_description)));
        cards.add(new Card(CardIdEnum.CAVALEIRO.getValue(), mContext.getString(R.string.knight), CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, mContext.getString(R.string.knight_description)));
        cards.add(new Card(CardIdEnum.CAVALEIRO_DAS_TREVAS.getValue(),  mContext.getString(R.string.dark_prince), CardCostEnum.FOUR.costCard, CardTypeEnum.TROOP, CardRarityEnum.EPIC, mContext.getString(R.string.dark_prince_description)));
        cards.add(new Card(CardIdEnum.COLETOR_DEELIXIR.getValue(),  mContext.getString(R.string.elixir_collector), CardCostEnum.FIVE.costCard, CardTypeEnum.CONSTRUCTION, CardRarityEnum.RARA, mContext.getString(R.string.elixir_collector_description)));
        cards.add(new Card(CardIdEnum.CORREDOR.getValue(), mContext.getString(R.string.hog_rider), CardCostEnum.FOUR.costCard, CardTypeEnum.TROOP, CardRarityEnum.RARA, mContext.getString(R.string.hog_rider_description)));
        cards.add(new Card(CardIdEnum.DRAGAO_BEBE.getValue(), mContext.getString(R.string.baby_dragon), CardCostEnum.FOUR.costCard, CardTypeEnum.TROOP, CardRarityEnum.EPIC, mContext.getString(R.string.baby_dragon_description)));
        cards.add(new Card(CardIdEnum.ESPELHO.getValue(), mContext.getString(R.string.mirror), CardCostEnum.TWO.costCard, CardTypeEnum.SPELL, CardRarityEnum.EPIC, mContext.getString(R.string.mirror_description)));
        cards.add(new Card(CardIdEnum.ESPIRITOS_DE_FOGO.getValue(), mContext.getString(R.string.fire_spirits), CardCostEnum.TWO.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, mContext.getString(R.string.fire_spirits_description)));
        cards.add(new Card(CardIdEnum.ESPIRITO_DE_GELO.getValue(), mContext.getString(R.string.ice_spirit), CardCostEnum.ONE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, mContext.getString(R.string.ice_spirit_description)));
        cards.add(new Card(CardIdEnum.ESQUELETO_GIGANTE.getValue(), mContext.getString(R.string.giant_skeleton), CardCostEnum.SIX.costCard, CardTypeEnum.TROOP, CardRarityEnum.EPIC, mContext.getString(R.string.giant_skeleton_description)));
        cards.add(new Card(CardIdEnum.ESQUELETOS.getValue(), mContext.getString(R.string.skeletons), CardCostEnum.ONE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, mContext.getString(R.string.skeletons_description)));
        cards.add(new Card(CardIdEnum.EXERCITO_DE_ESQUELETOS.getValue(), mContext.getString(R.string.skeletons_army), CardCostEnum.FOUR.costCard, CardTypeEnum.TROOP, CardRarityEnum.EPIC, mContext.getString(R.string.skeletons_army_description)));
        cards.add(new Card(CardIdEnum.FEITICO_DE_GELO.getValue(), mContext.getString(R.string.freeze), CardCostEnum.FOUR.costCard, CardTypeEnum.SPELL, CardRarityEnum.EPIC, mContext.getString(R.string.freeze_description)));
        cards.add(new Card(CardIdEnum.FLECHAS.getValue(), mContext.getString(R.string.arrow), CardCostEnum.THREE.costCard, CardTypeEnum.SPELL, CardRarityEnum.RARA, mContext.getString(R.string.arrow_description)));
        cards.add(new Card(CardIdEnum.FOGUETE.getValue(), mContext.getString(R.string.rocket), CardCostEnum.SIX.costCard, CardTypeEnum.SPELL, CardRarityEnum.RARA, mContext.getString(R.string.rocket_description)));

        cards.add(new Card(CardIdEnum.FORNALHA.getValue(),mContext.getString(R.string.furnace), CardCostEnum.FOUR.costCard, CardTypeEnum.CONSTRUCTION, CardRarityEnum.RARA, mContext.getString(R.string.furnace_description)));
        cards.add(new Card(CardIdEnum.FURIA.getValue(), mContext.getString(R.string.rage), CardCostEnum.THREE.costCard, CardTypeEnum.SPELL, CardRarityEnum.EPIC, mContext.getString(R.string.rage_description)));
        cards.add(new Card(CardIdEnum.GIGANTE.getValue(), mContext.getString(R.string.giant), CardCostEnum.FIVE.costCard, CardTypeEnum.TROOP, CardRarityEnum.RARA, mContext.getString(R.string.giant_description)));
        cards.add(new Card(CardIdEnum.GIGANTE_REAL.getValue(), mContext.getString(R.string.royal_giant), CardCostEnum.SIX.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, mContext.getString(R.string.royal_giant_description)));
        cards.add(new Card(CardIdEnum.GOBLINS.getValue(), mContext.getString(R.string.goblins), CardCostEnum.TWO.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, mContext.getString(R.string.goblins_description)));
        cards.add(new Card(CardIdEnum.GOBLINS_COM_LANCAS.getValue(), mContext.getString(R.string.spear_goblin), CardCostEnum.TWO.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, mContext.getString(R.string.spear_goblin_description)));
        cards.add(new Card(CardIdEnum.GOLEM.getValue(), mContext.getString(R.string.golem), CardCostEnum.EIGHT.costCard, CardTypeEnum.TROOP, CardRarityEnum.EPIC, mContext.getString(R.string.golem_description)));
        cards.add(new Card(CardIdEnum.GUARDAS_CLASH.getValue(), mContext.getString(R.string.guards), CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.EPIC, mContext.getString(R.string.guards_description)));
        cards.add(new Card(CardIdEnum.HORDA_DE_SERVOS.getValue(), mContext.getString(R.string.minion_horde), CardCostEnum.FIVE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, mContext.getString(R.string.minion_horde_description)));
        cards.add(new Card(CardIdEnum.LANCADOR.getValue(), mContext.getString(R.string.bowler), CardCostEnum.FIVE.costCard, CardTypeEnum.TROOP, CardRarityEnum.EPIC, mContext.getString(R.string.bowler_description)));
        cards.add(new Card(CardIdEnum.LAPIDE.getValue(), mContext.getString(R.string.tombstone), CardCostEnum.THREE.costCard, CardTypeEnum.CONSTRUCTION, CardRarityEnum.RARA, mContext.getString(R.string.tombstone_description)));
        cards.add(new Card(CardIdEnum.LAVA_HOUND.getValue(),  mContext.getString(R.string.lava_hound), CardCostEnum.SEVEN.costCard, CardTypeEnum.TROOP, CardRarityEnum.LEGENDARY, mContext.getString(R.string.lava_hound_description)));
        cards.add(new Card(CardIdEnum.LENHADOR.getValue(),  mContext.getString(R.string.lumberjack), CardCostEnum.FOUR.costCard, CardTypeEnum.TROOP, CardRarityEnum.LEGENDARY, mContext.getString(R.string.lumberjack_description)));
        cards.add(new Card(CardIdEnum.MAGO.getValue(), mContext.getString(R.string.wizard), CardCostEnum.FIVE.costCard, CardTypeEnum.TROOP, CardRarityEnum.RARA, mContext.getString(R.string.wizard_description)));
        cards.add(new Card(CardIdEnum.MAGO_DE_GELO.getValue(), mContext.getString(R.string.ice_wizard), CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.LEGENDARY, mContext.getString(R.string.ice_wizard_description)));
        cards.add(new Card(CardIdEnum.MEGA_SERVO.getValue(), mContext.getString(R.string.mega_minion), CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.RARA, mContext.getString(R.string.mega_minion)));
        cards.add(new Card(CardIdEnum.MINEIRO.getValue(), mContext.getString(R.string.miner), CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.LEGENDARY, mContext.getString(R.string.miner_description)));
        cards.add(new Card(CardIdEnum.MINI_PEKKA.getValue(), mContext.getString(R.string.mini_pekka), CardCostEnum.FOUR.costCard, CardTypeEnum.TROOP, CardRarityEnum.RARA, mContext.getString(R.string.mini_pekka_description)));
        cards.add(new Card(CardIdEnum.MORTEIRO.getValue(), mContext.getString(R.string.mortar), CardCostEnum.FOUR.costCard, CardTypeEnum.CONSTRUCTION, CardRarityEnum.COMMON, mContext.getString(R.string.mortar_description)));
        cards.add(new Card(CardIdEnum.MOSQUETEIRA.getValue(), mContext.getString(R.string.musketeer), CardCostEnum.FOUR.costCard, CardTypeEnum.TROOP, CardRarityEnum.RARA, mContext.getString(R.string.musketeer_description)));
        cards.add(new Card(CardIdEnum.PEKKA.getValue(), mContext.getString(R.string.pekka), CardCostEnum.SEVEN.costCard, CardTypeEnum.TROOP, CardRarityEnum.EPIC, mContext.getString(R.string.pekka_description)));
        cards.add(new Card(CardIdEnum.PRINCESA.getValue(), mContext.getString(R.string.princess), CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.LEGENDARY, mContext.getString(R.string.princess_description)));
        cards.add(new Card(CardIdEnum.PRINCIPE.getValue(), mContext.getString(R.string.prince), CardCostEnum.FIVE.costCard, CardTypeEnum.TROOP, CardRarityEnum.EPIC, mContext.getString(R.string.prince_description)));
        cards.add(new Card(CardIdEnum.RAIO.getValue(), mContext.getString(R.string.lightning), CardCostEnum.SIX.costCard, CardTypeEnum.SPELL, CardRarityEnum.EPIC, mContext.getString(R.string.lightning_description)));

        cards.add(new Card(CardIdEnum.RELAMPAGO.getValue(),mContext.getString(R.string.zap), CardCostEnum.TWO.costCard, CardTypeEnum.SPELL, CardRarityEnum.COMMON, mContext.getString(R.string.zap_description)));
        cards.add(new Card(CardIdEnum.SERVOS.getValue(), mContext.getString(R.string.minions), CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, mContext.getString(R.string.minions_description)));
        cards.add(new Card(CardIdEnum.SPARKY.getValue(), mContext.getString(R.string.sparky), CardCostEnum.SIX.costCard, CardTypeEnum.TROOP, CardRarityEnum.LEGENDARY, mContext.getString(R.string.sparky_description)));
        cards.add(new Card(CardIdEnum.TESLA.getValue(), mContext.getString(R.string.tesla), CardCostEnum.FOUR.costCard, CardTypeEnum.CONSTRUCTION, CardRarityEnum.COMMON, mContext.getString(R.string.tesla_description)));
        cards.add(new Card(CardIdEnum.TORRE_BOMBA.getValue(), mContext.getString(R.string.bomber_tower), CardCostEnum.FIVE.costCard, CardTypeEnum.CONSTRUCTION, CardRarityEnum.RARA, mContext.getString(R.string.bomber_tower_description)));
        cards.add(new Card(CardIdEnum.TORRE_INFERNO.getValue(), mContext.getString(R.string.inferno_tower), CardCostEnum.FIVE.costCard, CardTypeEnum.CONSTRUCTION, CardRarityEnum.RARA, mContext.getString(R.string.inferno_tower_description)));
        cards.add(new Card(CardIdEnum.TRES_MOSQUETEIRAS.getValue(), mContext.getString(R.string.three_musketeers), CardCostEnum.NINE.costCard, CardTypeEnum.TROOP, CardRarityEnum.RARA, mContext.getString(R.string.three_musketeers_description)));
        cards.add(new Card(CardIdEnum.TRONCO.getValue(), mContext.getString(R.string.the_log), CardCostEnum.TWO.costCard, CardTypeEnum.SPELL, CardRarityEnum.LEGENDARY, mContext.getString(R.string.the_log_description)));
        cards.add(new Card(CardIdEnum.VALQUIRIA.getValue(), mContext.getString(R.string.valkyrie), CardCostEnum.FOUR.costCard, CardTypeEnum.TROOP, CardRarityEnum.RARA, mContext.getString(R.string.valkyrie_description)));
        cards.add(new Card(CardIdEnum.VENENO.getValue(), mContext.getString(R.string.poison_spell), CardCostEnum.FOUR.costCard, CardTypeEnum.SPELL, CardRarityEnum.EPIC, mContext.getString(R.string.poison_spell_description)));
        cards.add(new Card(CardIdEnum.X_BESTA.getValue(), mContext.getString(R.string.x_bow), CardCostEnum.SIX.costCard, CardTypeEnum.CONSTRUCTION, CardRarityEnum.EPIC, mContext.getString(R.string.x_bow_description)));

        return cards;
    }
}
