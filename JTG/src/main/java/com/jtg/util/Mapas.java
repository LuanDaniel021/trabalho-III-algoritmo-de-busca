package com.jtg.util;

import com.jtg.algorithm.GrafoBucharest;
import com.jtg.algorithm.GrafoCuritiba;

public class Mapas {

	private static final int ofSetX_Bucareste = -55;

	private static final int ofSetY_Bucareste = 90;

	private static final int ofSetX_Curitiba = -30;

	private static final int ofSetY_Curitiba = -15;

	public static final Cidade[] cidades_Bucareste() {

		GrafoBucharest grafo = new GrafoBucharest();

		return new Cidade[] {// y = (500 - x);
			new Cidade(grafo.arad,       91,   8), // x = 492
		    new Cidade(grafo.zerind,    108, -31), // x = 531
		    new Cidade(grafo.oradea,    131, -71), // x = 571
		    new Cidade(grafo.sibiu,     207,  43), // x = 457
		    new Cidade(grafo.timisoara,  94,  90), // x = 410
		    new Cidade(grafo.lugoj,     165, 121), // x = 379
		    new Cidade(grafo.mehadia,   168, 161), // x = 339
		    new Cidade(grafo.dobreta,   165, 201), // x = 299
		    new Cidade(grafo.craiova,   253, 212), // x = 288
		    new Cidade(grafo.rimnicu,   233,  90), // x = 410
		    new Cidade(grafo.fagaras,   305,  51), // x = 449
		    new Cidade(grafo.pitesti,   320, 132), // x = 368
		    new Cidade(grafo.bucharest, 400, 173), // x = 327
		    new Cidade(grafo.giurgiu,   375, 230), // x = 270
		    new Cidade(grafo.urziceni,  456, 150), // x = 350
		    new Cidade(grafo.hirsova,   534, 150), // x = 350
		    new Cidade(grafo.eforie,    562, 207), // x = 239
		    new Cidade(grafo.vaslui,    509,  56), // x = 444
		    new Cidade(grafo.iasi,      473,  -6), // x = 506
		    new Cidade(grafo.neamt,     406, -37)  // x = 537
		};

	}
	
	public static final Cidade[] cidades_Curitiba() {

		GrafoCuritiba grafo = new GrafoCuritiba();

		return new Cidade[] {
			new Cidade(grafo.porto_uniao,     50, 150),
			new Cidade(grafo.paulo_frontin,  100,  80),
			new Cidade(grafo.irati,          180,  40),
			new Cidade(grafo.palmeira,       300,  60),
			new Cidade(grafo.campo_largo,    420,  80),
			new Cidade(grafo.balsa_nova,     360, 140),
			new Cidade(grafo.curitiba,       450, 200),
			new Cidade(grafo.sao_jose,       480, 260),
			new Cidade(grafo.araucaria,      380, 220),
			new Cidade(grafo.contenda,       300, 180),
			new Cidade(grafo.lapa,           260, 220),
			new Cidade(grafo.mafra,          250, 300),
			new Cidade(grafo.tijucas_do_sul, 350, 320),
			new Cidade(grafo.canoinhas,      120, 280),
			new Cidade(grafo.tres_barras,    180, 230),
			new Cidade(grafo.sao_mateus,     200, 160),
		};

	}

	public static Content get(String to) {
		switch ( to ) {
			case "Bucharest": {
				return new Content(
					ofSetX_Bucareste,
					ofSetY_Bucareste,
					cidades_Bucareste()
				);
			}
			case "Curitiba" : {
				return new Content(
					ofSetX_Curitiba,
					ofSetY_Curitiba,
					cidades_Curitiba()
				);
			}
			default: return null;
		}
	}

}
