package com.jtg.util;

import java.util.Map;

public class Mapas {

	private static final int ofSetX_Bucareste = -55;
	
	private static final int ofSetY_Bucareste = 90;
	
	private static final int ofSetX_Curitiba = -30;
	
	private static final int ofSetY_Curitiba = -15;

	public static final Cidade[] cidades_Bucareste = {// y = (500 - x);
	    new Cidade("Arad",            91,   8), // x = 492
	    new Cidade("Zerind",         108, -31), // x = 531
	    new Cidade("Oradea",         131, -71), // x = 571
	    new Cidade("Sibiu",          207,  43), // x = 457
	    new Cidade("Timisoara",       94,  90), // x = 410
	    new Cidade("Lugoj",          165, 121), // x = 379
	    new Cidade("Mehadia",        168, 161), // x = 339
	    new Cidade("Drobeta",        165, 201), // x = 299
	    new Cidade("Craiova",        253, 212), // x = 288
	    new Cidade("Rimnicu Vilcea", 233,  90), // x = 410
	    new Cidade("Fagaras",        305,  51), // x = 449
	    new Cidade("Pitesti",        320, 132), // x = 368
	    new Cidade("Bucareste",      400, 173), // x = 327
	    new Cidade("Giurgiu",        375, 230), // x = 270
	    new Cidade("Urziceni",       456, 150), // x = 350
	    new Cidade("Hirsova",        534, 150), // x = 350
	    new Cidade("Eforie",         562, 207), // x = 239
	    new Cidade("Vaslui",         509,  56), // x = 444
	    new Cidade("Iasi",           473,  -6), // x = 506
	    new Cidade("Neamt",          406, -37)  // x = 537
	};
	
	public static final Cidade[] cidades_Curitiba = {
		new Cidade("Porto União",           50, 150),
		new Cidade("Paulo Frontin",        100,  80),
		new Cidade("Irati",                180,  40),
		new Cidade("Palmeira",             300,  60),
		new Cidade("Campo Largo",          420,  80),
		new Cidade("Balsa Nova",           360, 140),
		new Cidade("Curitiba",             450, 200),
		new Cidade("São José dos Pinhais", 480, 260),
		new Cidade("Araucária",            380, 220),
		new Cidade("Contenda",             300, 180),
		new Cidade("Lapa",                 260, 220),
		new Cidade("Mafra",                250, 300),
		new Cidade("Tijucas do Sul",       350, 320),
		new Cidade("Canoinhas",            120, 280),
		new Cidade("Três Barras",          180, 230),
		new Cidade("São Mateus",           200, 160),
	};

	public static void adjacentes_Bucareste( Map<String, Cidade> map ) {
		map.get("Arad").adddAdjacentes(
			map.get("Zerind"),
			map.get("Sibiu"),
			map.get("Timisoara")
		);

		map.get("Zerind").adddAdjacentes(
			map.get("Arad"),
			map.get("Oradea")
		);

		map.get("Oradea").adddAdjacentes(
			map.get("Zerind"),
			map.get("Sibiu")
		);

		map.get("Sibiu").adddAdjacentes(
			map.get("Arad"),
			map.get("Oradea"),
			map.get("Fagaras"),
			map.get("Rimnicu Vilcea")
		);

		map.get("Timisoara").adddAdjacentes(
				map.get("Arad"),
				map.get("Lugoj")
		);

		map.get("Lugoj").adddAdjacentes(
			map.get("Timisoara"),
			map.get("Mehadia")
		);

		map.get("Mehadia").adddAdjacentes(
			map.get("Lugoj"),
			map.get("Drobeta")
		);

		map.get("Drobeta").adddAdjacentes(
			map.get("Mehadia"),
			map.get("Craiova")
		);

		map.get("Craiova").adddAdjacentes(
			map.get("Drobeta"),
			map.get("Rimnicu Vilcea"),
			map.get("Pitesti")
		);

		map.get("Rimnicu Vilcea").adddAdjacentes(
			map.get("Sibiu"),
			map.get("Craiova"),
			map.get("Pitesti")
		);

		map.get("Fagaras").adddAdjacentes(
			map.get("Sibiu"),
			map.get("Bucareste")
		);

		map.get("Pitesti").adddAdjacentes(
			map.get("Rimnicu Vilcea"),
			map.get("Craiova"),
			map.get("Bucareste")
		);

		map.get("Bucareste").adddAdjacentes(
			map.get("Fagaras"),
			map.get("Pitesti"),
			map.get("Giurgiu"),
			map.get("Urziceni")
		);

		map.get("Giurgiu").adddAdjacentes( map.get("Bucareste") );

		map.get("Urziceni").adddAdjacentes(
			map.get("Bucareste"),
			map.get("Hirsova"),
			map.get("Vaslui")
		);

		map.get("Hirsova").adddAdjacentes(
			map.get("Urziceni"),
			map.get("Eforie")
		);

		map.get("Eforie").adddAdjacentes( map.get("Hirsova") );

		map.get("Vaslui").adddAdjacentes(
			map.get("Urziceni"),
			map.get("Iasi")
		);

		map.get("Iasi").adddAdjacentes(
			map.get("Vaslui"),
			map.get("Neamt")
		);

		map.get("Neamt").adddAdjacentes( map.get("Iasi") );
	}
	
	public static void adjacentes_Curitiba(Map<String, Cidade> map) {
		map.get("Porto União").adddAdjacentes(
			map.get("Paulo Frontin"),
			map.get("São Mateus"),
			map.get("Canoinhas")
		);

		map.get("Paulo Frontin").adddAdjacentes(
			map.get("Porto União"),
			map.get("Irati")
		);
		
		map.get("Irati").adddAdjacentes(
			map.get("Paulo Frontin"),
			map.get("Palmeira"),
			map.get("São Mateus")
		);
		
		map.get("Palmeira").adddAdjacentes(
			map.get("Irati"),
			map.get("Campo Largo"),
			map.get("São Mateus")
		);

		map.get("Campo Largo").adddAdjacentes(
			map.get("Palmeira"),
			map.get("Balsa Nova"),
			map.get("Curitiba")
		);

		map.get("Balsa Nova").adddAdjacentes(
			map.get("Campo Largo"),
			map.get("Contenda"),
			map.get("Curitiba")
		);
		
		map.get("Curitiba").adddAdjacentes(
			map.get("Campo Largo"),
			map.get("Balsa Nova"),
			map.get("Araucária"),
			map.get("São José dos Pinhais")
		);

		map.get("São José dos Pinhais").adddAdjacentes(
			map.get("Curitiba"),
			map.get("Tijucas do Sul")
		);
		
		map.get("Araucária").adddAdjacentes(
			map.get("Curitiba"),
			map.get("Contenda")
		);
		
		map.get("Contenda").adddAdjacentes(
			map.get("Balsa Nova"),
			map.get("Araucária"),
			map.get("Lapa")
		);
		
		map.get("Lapa").adddAdjacentes(
			map.get("Contenda"),
			map.get("São Mateus"),
			map.get("Mafra")
		);
		
		map.get("Mafra").adddAdjacentes(
			map.get("Lapa"),
			map.get("Canoinhas"),
			map.get("Tijucas do Sul")
		);

		map.get("Tijucas do Sul").adddAdjacentes(
			map.get("Mafra"),
			map.get("São José dos Pinhais")
		);
		
		 map.get("Canoinhas").adddAdjacentes(
			 map.get("Porto União"),
			 map.get("Mafra"),
			 map.get("Três Barras")
		);
		
		map.get("Três Barras").adddAdjacentes(
			map.get("Canoinhas"),
			map.get("São Mateus")
		);
		
		 map.get("São Mateus").adddAdjacentes(
			 map.get("Porto União"),
			 map.get("Irati"),
			 map.get("Palmeira"),
			 map.get("Lapa"),
			 map.get("Três Barras")
		);
	}

	public static Content get(String to) {
		switch ( to ) {
			case "Bucareste": {
				return new Content(
					ofSetX_Bucareste,
					ofSetY_Bucareste,
					cidades_Bucareste,
					Mapas::adjacentes_Bucareste 
				);
			}
			case "Curitiba" : {
				return new Content(
					ofSetX_Curitiba,
					ofSetY_Curitiba,
					cidades_Curitiba,
					Mapas::adjacentes_Curitiba );
			}
			default: return null;
		}
	}

}
