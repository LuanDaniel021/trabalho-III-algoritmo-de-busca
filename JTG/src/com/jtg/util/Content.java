package com.jtg.util;

import java.util.HashMap;
import java.util.Map;

public class Content {
	
	private final int ofsetX, ofsetY;
	
	private final Cidade[] cidades;
	
	public Map<String, Cidade> map = new HashMap<>();

	public Content(int ofsetX, int ofsetY, Cidade[] cidades) {
		this.cidades = cidades;
		this.ofsetX = ofsetX;
		this.ofsetY = ofsetY;
	}

	public Content pack() {

		for (Cidade cidade : cidades) {
		    map.put(cidade.name, cidade);
		}

		return this; 
	}

	public Cidade[] getCidades() {
		return cidades;
	}
	
	public int getOfsetX() {
		return ofsetX;
	}

	public int getOfsetY() {
		return ofsetY;
	}

}

