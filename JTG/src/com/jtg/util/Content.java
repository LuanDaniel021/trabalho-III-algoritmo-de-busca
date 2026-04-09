package com.jtg.util;

import java.util.HashMap;
import java.util.Map;

public class Content {
	
	private final int ofsetX, ofsetY;
	
	private final Cidade[] cidades;
	
	private final Linker linker;

	public Content(int ofsetX, int ofsetY, Cidade[] cidades, Linker linker) {
		this.cidades = cidades;
		this.linker = linker;
		this.ofsetX = ofsetX;
		this.ofsetY = ofsetY;
	}

	public Content pack() {
		Map<String, Cidade> map = new HashMap<>();
		
		for (Cidade cidade : cidades) {
		    map.put(cidade.name, cidade);
		}

		linker.link(map);
		
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

	@FunctionalInterface
	interface Linker {
		void link( Map<String, Cidade> map );
	}

}

