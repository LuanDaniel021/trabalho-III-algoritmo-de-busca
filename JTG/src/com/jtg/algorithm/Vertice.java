package com.jtg.algorithm;

public class Vertice {
	
	public String rotulo;
	boolean visitado;
	public double distancia;
	public Adjacente[] adjacentes;

	public Vertice( String rotulo, double distancia ) {
		this.rotulo = rotulo;
		this.visitado = false;
		this.distancia = distancia;
		this.adjacentes = new Adjacente[0];
	}

	public void adiciona_adjacentes( Adjacente... list ) {
		adjacentes = list;
	}
	
	public void mostra_adjacentes() {
		for (Adjacente i : adjacentes) {
			System.out.println( i.vertice.rotulo + " " + i.custo );
		}
	}
	
	public double getDistancia() {
		return distancia;
	}

}
