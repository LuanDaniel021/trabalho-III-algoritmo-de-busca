package com.jtg.algorithm;

public class AEstrela {
	
	Vertice objetivo;
	boolean encontrado;

	public AEstrela( Vertice objetivo ) {
		this.objetivo = objetivo;
		this.encontrado = false;
	}
	
	public void buscar(Vertice atual) {
		System.out.println("------------------");
		System.out.println(String.format( "Atual: %s" , atual.rotulo));
	    atual.visitado = true;
	    if ( objetivo.equals(atual) ) encontrado = true;
	    else {
	    	VetorOrdenado vetor_ordenado = new VetorOrdenado(atual.adjacentes.length);

	    	for (Adjacente adjacente : atual.adjacentes) {

	    		if ( adjacente.vertice.visitado == false ) {
	    			vetor_ordenado.insere(adjacente);
	    		}

	    	}

	    	vetor_ordenado.imprime();
	    	
	    	if ( vetor_ordenado.valores[0] != null ) {
    			buscar(vetor_ordenado.valores[0].vertice);
    		}
	    	
	    }
	}
	
	public class VetorOrdenado {

		Adjacente[] valores;
		int ultima_posicao;
		int capacidade;

		public VetorOrdenado(int capacidade) {
			this.valores = new Adjacente[ capacidade ];
			this.capacidade = capacidade;
			this.ultima_posicao = -1;
		}

		public void insere( Adjacente adjacente ) {
			if (ultima_posicao == capacidade - 1) System.out.println("Capacidade m�xima atingida");
			else {
				int posicao = 0;
			    for ( int i = 0; i < ultima_posicao + 1; i++) {
			    	posicao = i;
			    	
			    	if ( valores[i].getDistancia() > adjacente.distancia ) {
			    		break;
			    	}
			      
			    	if (i == ultima_posicao) {
			    		posicao = i + 1;  
			    	}
			    }

			    int x = ultima_posicao;
			    while ( x >= posicao) {
			    	valores[x + 1] = valores[x];
			    	x -= 1;
			    }
			      
			    valores[posicao] = adjacente;
			    ultima_posicao += 1;
			}
		}
		
		public void imprime() {
			if (ultima_posicao == -1) System.out.println( "O vetor est� vazio" );
			else {
				for ( int i = 0; i < ultima_posicao + 1; i++) {
					System.out.print( i );
					System.out.print( " - " );
					System.out.print( valores[i].vertice.rotulo );
					System.out.print( " - " );
					System.out.print( valores[i].custo );
					System.out.print( " - " );
					System.out.print( valores[i].vertice.getDistancia() );
					System.out.print( " - " );
					System.out.println( valores[i].getDistancia() );
			    }
			}
		}

	}
}
