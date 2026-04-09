package com.jtg;

import com.jtg.algorithm.AEstrela;
import com.jtg.algorithm.GrafoBucharest;

public class Main {

	public static void main(String[] args) {

		GrafoBucharest grafo = new GrafoBucharest();
		
		AEstrela busca_aestrela = new AEstrela(grafo.bucharest);

		busca_aestrela.buscar(grafo.arad);
	
	}

}
