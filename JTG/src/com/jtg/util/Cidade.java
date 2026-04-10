package com.jtg.util;

import com.jtg.algorithm.Vertice;

public class Cidade {

	public Vertice vertice;
	public String name;
	public int x, y;

	public Cidade( Vertice vertice, int x, int y ) {
		this.vertice = vertice;
		this.name = vertice.rotulo;
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
