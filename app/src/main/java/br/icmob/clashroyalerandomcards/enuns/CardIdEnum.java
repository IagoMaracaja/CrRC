package br.icmob.clashroyalerandomcards.enuns;

import br.icmob.clashroyalerandomcards.R;

/**
 * Created by Bruno on 23/09/2016.
 */

public enum CardIdEnum {
    ARQUEIRA(R.drawable.arqueiras),
    BALAO(R.drawable.balao),
    BARBAROS(R.drawable.barbaros),
    BARRIL_DE_GOBLIN(R.drawable.barril_de_goblin),
    BOLA_DE_FOGO(R.drawable.bola_de_fogo),
    BOMBER(R.drawable.bomber),
    BRUXA(R.drawable.bruxa),
    CABANA_DO_BARBARO(R.drawable.cabana_do_barbaro),
    CABANA_DO_GOBLIN(R.drawable.cabana_do_goblin),
    CANHAO(R.drawable.canhao),
    CAVALEIRO(R.drawable.cavaleiro),
    CAVALEIRO_DAS_TREVAS(R.drawable.cavaleiro_das_trevas),
    COLETOR_DEELIXIR(R.drawable.coletor_de_elixir),
    CORREDOR(R.drawable.corredor),
    DRAGAO_BEBE(R.drawable.dragao_bebe),
    ESPELHO(R.drawable.espelho),
    ESPIRITO_DE_GELO(R.drawable.espirito_de_gelo),
    ESPIRITOS_DE_FOGO(R.drawable.espiritos_de_fogo),
    ESQUELETO_GIGANTE(R.drawable.esqueleto_gigante),
    ESQUELETOS(R.drawable.esqueletos),
    EXERCITO_DE_ESQUELETOS(R.drawable.exercito_de_esqueletos),
    FEITICO_DE_GELO(R.drawable.feitico_de_gelo),
    FLECHAS(R.drawable.flechas),
    FOGUETE(R.drawable.foquete),
    FORNALHA(R.drawable.fornalha),
    FURIA(R.drawable.furia),
    GIGANTE(R.drawable.gigante),
    GIGANTE_REAL(R.drawable.gigante_real),
    GOBLINS(R.drawable.goblins),
    GOBLINS_COM_LANCAS(R.drawable.goblins_com_lancas),
    GOLEM(R.drawable.golem),
    GUARDAS_CLASH(R.drawable.guardas_clash),
    HORDA_DE_SERVOS(R.drawable.horda_de_servos),
    LANCADOR(R.drawable.lancador),
    LAPIDE(R.drawable.lapide),
    LAVA_HOUND(R.drawable.lava_hound),
    LENHADOR(R.drawable.lenhador),
    MAGO(R.drawable.mago),
    MAGO_DE_GELO(R.drawable.mago_de_gelo),
    MEGA_SERVO(R.drawable.mega_servo),
    MINEIRO(R.drawable.mineiro),
    MINI_PEKKA(R.drawable.mini_pekka),
    MORTEIRO(R.drawable.morteiro),
    MOSQUETEIRA(R.drawable.mosqueteira),
    PEKKA(R.drawable.pekka),
    PRINCESA(R.drawable.princesa),
    PRINCIPE(R.drawable.principe),
    RAIO(R.drawable.raio),
    RELAMPAGO(R.drawable.relampago),
    SERVOS(R.drawable.servos),
    SPARKY(R.drawable.sparky),
    TESLA(R.drawable.tesla),
    TORRE_BOMBA(R.drawable.torre_bomba),
    TORRE_INFERNO(R.drawable.torre_inferno),
    TRES_MOSQUETEIRAS(R.drawable.tres_mosqueteiras),
    TRONCO(R.drawable.tronco),
    VALQUIRIA(R.drawable.valquiria),
    VENENO(R.drawable.veneno),
    X_BESTA(R.drawable.x_besta);

    public int idCard;
    CardIdEnum(int idCard) {
        this.idCard = idCard;
    }
    public int getValue() {
        return this.idCard;
    }
}
