package br.icmob.clashroyalerandomcards.service;


import java.util.ArrayList;
import java.util.List;

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

    public static List<Card> getCards(){
        cards = new ArrayList<>();
        cards.add(new Card(CardIdEnum.ARQUEIRA.getValue(), CardIdEnum.ARQUEIRA+"", CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, ""));
        cards.add(new Card(CardIdEnum.BALAO.getValue(), CardIdEnum.BALAO+"", CardCostEnum.FIVE.costCard, CardTypeEnum.TROOP, CardRarityEnum.EPIC, ""));
        cards.add(new Card(CardIdEnum.BARBAROS.getValue(), CardIdEnum.BARBAROS+"", CardCostEnum.FIVE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, ""));
        cards.add(new Card(CardIdEnum.BARRIL_DE_GOBLIN.getValue(), CardIdEnum.BARRIL_DE_GOBLIN+"", CardCostEnum.THREE.costCard, CardTypeEnum.SPELL, CardRarityEnum.EPIC, ""));
        cards.add(new Card(CardIdEnum.BOLA_DE_FOGO.getValue(), CardIdEnum.BOLA_DE_FOGO+"", CardCostEnum.FOUR.costCard, CardTypeEnum.SPELL, CardRarityEnum.RARA, ""));
        cards.add(new Card(CardIdEnum.BOMBER.getValue(), CardIdEnum.BOMBER+"", CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, ""));
        cards.add(new Card(CardIdEnum.BRUXA.getValue(), CardIdEnum.BRUXA+"", CardCostEnum.FIVE.costCard, CardTypeEnum.TROOP, CardRarityEnum.EPIC, ""));
        cards.add(new Card(CardIdEnum.CABANA_DO_BARBARO.getValue(), CardIdEnum.CABANA_DO_BARBARO+"", CardCostEnum.SEVEN.costCard, CardTypeEnum.CONSTRUCTION, CardRarityEnum.RARA, ""));
        cards.add(new Card(CardIdEnum.CABANA_DO_GOBLIN.getValue(), CardIdEnum.CABANA_DO_GOBLIN+"", CardCostEnum.FIVE.costCard, CardTypeEnum.CONSTRUCTION, CardRarityEnum.RARA, ""));
        cards.add(new Card(CardIdEnum.CANHAO.getValue(), CardIdEnum.CANHAO+"", CardCostEnum.THREE.costCard, CardTypeEnum.CONSTRUCTION, CardRarityEnum.COMMON, ""));
        cards.add(new Card(CardIdEnum.CAVALEIRO.getValue(), CardIdEnum.CAVALEIRO+"", CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, ""));

        cards.add(new Card(CardIdEnum.CAVALEIRO_DAS_TREVAS.getValue(), CardIdEnum.CAVALEIRO_DAS_TREVAS+"", CardCostEnum.FOUR.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, ""));
        cards.add(new Card(CardIdEnum.COLETOR_DEELIXIR.getValue(), CardIdEnum.COLETOR_DEELIXIR+"", CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, ""));
        cards.add(new Card(CardIdEnum.CORREDOR.getValue(), CardIdEnum.CORREDOR+"", CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, ""));
        cards.add(new Card(CardIdEnum.DRAGAO_BEBE.getValue(), CardIdEnum.DRAGAO_BEBE+"", CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, ""));
        cards.add(new Card(CardIdEnum.ESPELHO.getValue(), CardIdEnum.ESPELHO+"", CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, ""));
        cards.add(new Card(CardIdEnum.ESPIRITO_DE_GELO.getValue(), CardIdEnum.ESPIRITO_DE_GELO+"", CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, ""));
        cards.add(new Card(CardIdEnum.ESPIRITOS_DE_FOGO.getValue(), CardIdEnum.ESPIRITOS_DE_FOGO +"", CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, ""));
        cards.add(new Card(CardIdEnum.ESQUELETO_GIGANTE.getValue(), CardIdEnum.ESQUELETO_GIGANTE+"", CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, ""));
        cards.add(new Card(CardIdEnum.ESQUELETOS.getValue(), CardIdEnum.ESQUELETOS+"", CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, ""));
        cards.add(new Card(CardIdEnum.EXERCITO_DE_ESQUELETOS.getValue(), CardIdEnum.EXERCITO_DE_ESQUELETOS+"", CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, ""));
        cards.add(new Card(CardIdEnum.FEITICO_DE_GELO.getValue(), CardIdEnum.FEITICO_DE_GELO+"", CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, ""));
        cards.add(new Card(CardIdEnum.FLECHAS.getValue(), CardIdEnum.FLECHAS+"", CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, ""));
        cards.add(new Card(CardIdEnum.FOGUETE.getValue(), CardIdEnum.FOGUETE+"", CardCostEnum.THREE.costCard, CardTypeEnum.TROOP, CardRarityEnum.COMMON, ""));
        return cards;
    }
}
