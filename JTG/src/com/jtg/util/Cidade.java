package com.jtg.util;

public class Cidade {

	public Cidade[] adjacentes;
	public String name;
	public int x, y;

	public Cidade( String name, int x, int y ) {
		this.adjacentes = new Cidade[0];
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public Cidade[] getAdjacentes() {
		return adjacentes;
	}

	public void setAdjacentes(Cidade[] adjacentes) {
		this.adjacentes = adjacentes;
	}

	public void adddAdjacentes(Cidade... adjacentes) {
		this.adjacentes = adjacentes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
