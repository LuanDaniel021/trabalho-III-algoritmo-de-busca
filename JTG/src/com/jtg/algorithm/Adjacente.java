package com.jtg.algorithm;

public class Adjacente {

	public Vertice vertice; 

	double distancia;
	double custo;

	public Adjacente(Vertice vertice, double custo) {
		this.distancia = vertice.distancia + custo;
		this.vertice = vertice;
		this.custo = custo;
	}
	
	public double getDistancia() {
		return distancia;
	}
	
}
