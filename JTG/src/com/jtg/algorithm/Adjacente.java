package com.jtg.algorithm;

public class Adjacente implements Distancia {

	public static boolean PEDAGIO, TURISMO;
	
	public Heuristica pedagio;
	public Heuristica turismo;

	double distancia;
	double custo;

	Vertice vertice;

	public Adjacente(Vertice vertice, double custo ) {
		this.distancia = vertice.distancia + custo;
		this.vertice = vertice;
		this.custo = custo;
	}

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

	public Vertice getVertice() {
		return vertice;
	}

}
