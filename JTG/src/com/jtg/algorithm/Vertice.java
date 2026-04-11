package com.jtg.algorithm;

public class Vertice implements Distancia {

	public static boolean PEDAGIO, TURISMO;

	public String rotulo;
	public boolean visitado;
	public double distancia;
	public Adjacente[] adjacentes;

	public Heuristica pedagio;
	public Heuristica turismo;

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
	
	@Override
	public double distancia() {
		double value = 0;

		if ( PEDAGIO && pedagio != null ) {
			value += pedagio.value( this );
		}

		if ( TURISMO && turismo != null ) {
			value += turismo.value( this );
		}

		return distancia + value;
	}

}
