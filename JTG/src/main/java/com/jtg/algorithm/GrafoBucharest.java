package com.jtg.algorithm;

public class GrafoBucharest {

	public Vertice arad      = new Vertice("Arad",           366);
	public Vertice zerind    = new Vertice("Zerind",         374);
	public Vertice oradea    = new Vertice("Oradea",         380);
	public Vertice sibiu     = new Vertice("Sibiu",          253);
	public Vertice timisoara = new Vertice("Timisoara",      329);
	public Vertice lugoj     = new Vertice("Lugoj",          244);
	public Vertice mehadia   = new Vertice("Mehadia",        241);
	public Vertice dobreta   = new Vertice("Dobreta",        242);
	public Vertice craiova   = new Vertice("Craiova",        160);
	public Vertice rimnicu   = new Vertice("Rimnicu Vilcea", 193);
	public Vertice fagaras   = new Vertice("Fagaras",        178);
	public Vertice pitesti   = new Vertice("Pitesti",         98);
	public Vertice bucharest = new Vertice("Bucharest",        0);
	public Vertice giurgiu   = new Vertice("Giurgiu",         77);
	public Vertice urziceni  = new Vertice("Urziceni",        80);
	public Vertice hirsova   = new Vertice("Hirsova",        151);
	public Vertice eforie    = new Vertice("Eforie",         161);
	public Vertice vaslui    = new Vertice("Vaslui",         199);
	public Vertice iasi      = new Vertice("Iasi",           226);
	public Vertice neamt     = new Vertice("Neamt",          234);

	
	Heuristica pedagio = adj -> +100.0;
	Heuristica turismo = adj -> -100.0;

	{
		/**
		 * Arad
		 */
		arad.adiciona_adjacentes(
			new Adjacente(zerind, 75),
			new Adjacente(sibiu, 140),
			new Adjacente(timisoara, 118)
		);

		/**
		 * Zerind
		 */
		zerind.adiciona_adjacentes(
			new Adjacente(arad, 75),
			new Adjacente(oradea, 71)
		);

		/**
		 * Oradea
		 */
		oradea.adiciona_adjacentes(
			new Adjacente(zerind, 71),
			new Adjacente(sibiu, 151)
		);

		/**
		 * Sibiu
		 */

		Adjacente sibiu_rimnicu = new Adjacente(rimnicu, 80);

		sibiu_rimnicu.pedagio = pedagio;

		sibiu.adiciona_adjacentes(
			new Adjacente(oradea, 151),
			new Adjacente(arad,   140),
			new Adjacente(fagaras, 99),
			sibiu_rimnicu
		);

		/**
		 * Timisoara
		 */
		timisoara.adiciona_adjacentes(
			new Adjacente(arad, 118),
			new Adjacente(lugoj, 111)
		);

		/**
		 * Lugoj
		 */
		lugoj.adiciona_adjacentes(
			new Adjacente(timisoara, 111),
			new Adjacente(mehadia, 70)
		);

		/**
		 * Mehadia
		 */
		mehadia.adiciona_adjacentes(
			new Adjacente(lugoj, 70),
			new Adjacente(dobreta, 75)
		);

		/**
		 * Dobreta
		 */
		dobreta.adiciona_adjacentes(
			new Adjacente(mehadia, 75),
			new Adjacente(craiova, 120)
		);

		/**
		 * Craiova
		 */
		craiova.adiciona_adjacentes(
			new Adjacente(dobreta, 120),
			new Adjacente(pitesti, 138),
			new Adjacente(rimnicu, 146)
		);

		/**
		 * Rimnicu
		 */
		rimnicu.adiciona_adjacentes(
			new Adjacente(craiova, 146),
			new Adjacente(sibiu, 80),
			new Adjacente(pitesti, 97)
		);

		/**
		 * Fagaras
		 */
		fagaras.adiciona_adjacentes(
			new Adjacente(sibiu, 99),
			new Adjacente(bucharest, 211)
		);

		/**
		 * Pitesti
		 */
		pitesti.adiciona_adjacentes(
			new Adjacente(rimnicu, 97),
			new Adjacente(craiova, 138),
			new Adjacente(bucharest, 101)
		);

		/**
		 * Bucharest
		 */
		bucharest.adiciona_adjacentes(
			new Adjacente(fagaras, 211),
			new Adjacente(pitesti, 101),
			new Adjacente(urziceni, 85),
			new Adjacente(giurgiu,  90)
		);
		
		/**
		 * Giurgiu
		 */
		giurgiu.adiciona_adjacentes(
			new Adjacente(bucharest, 90)
		);
		
		/**
		 * Urziceni
		 */
		urziceni.adiciona_adjacentes(
			new Adjacente(bucharest, 85),
			new Adjacente(hirsova,   98),
			new Adjacente(vaslui,    85)
		);
		
		/**
		 * hirsova
		 */
		hirsova.adiciona_adjacentes(
			new Adjacente(urziceni, 98),
			new Adjacente(eforie,   86)
		);

		/**
		 * eforie
		 */
		eforie.adiciona_adjacentes(
			new Adjacente(hirsova, 86)
		);
		
		/**
		 * vaslui
		 */
		vaslui.adiciona_adjacentes(
			new Adjacente(urziceni, 142),
			new Adjacente(iasi,      92)
		);
		
		/**
		 * iasi
		 */
		iasi.adiciona_adjacentes(
			new Adjacente(neamt,  87),
			new Adjacente(vaslui,  92)
		);
		
		/**
		 * neamt
		 */
		neamt.adiciona_adjacentes(
			new Adjacente(iasi,  87)
		);
	}
}
