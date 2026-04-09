package com.jtg.algorithm;

public class BuscaGulosa {
	
	Vertice objetivo;
	boolean encontrado;
	
	public BuscaGulosa( Vertice objetivo ) {
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
	    			vetor_ordenado.insere(adjacente.vertice);
	    		}

	    	}

	    	vetor_ordenado.imprime();
	    	
	    	if ( vetor_ordenado.valores[0] != null ) {
    			buscar(vetor_ordenado.valores[0]);
    		}
	    	
	    }
	}

	public class VetorOrdenado {

		Vertice[] valores;
		int ultima_posicao;
		int capacidade;

		public VetorOrdenado(int capacidade) {
			this.valores = new Vertice[ capacidade ];
			this.capacidade = capacidade;
			this.ultima_posicao = -1;
		}

		public void insere( Vertice adjacente ) {
			if (ultima_posicao == capacidade - 1) System.out.println("Capacidade máxima atingida");
			else {
				int posicao = 0;
			    for ( int i = 0; i < ultima_posicao + 1; i++) {
			    	posicao = i;
			    	
			    	if ( valores[i].distancia > adjacente.distancia ) {
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
			if (ultima_posicao == -1) System.out.println( "O vetor está vazio" );
			else {
				for ( int i = 0; i < ultima_posicao + 1; i++) {
					System.out.print( i );
					System.out.print( " - " );
					System.out.print( valores[i].rotulo );
					System.out.print( " - " );
					System.out.println( valores[i].distancia );
			    }
			}
		}

	}
}
