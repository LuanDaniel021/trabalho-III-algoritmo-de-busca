package com.jtg.algorithm;

public class GrafoCuritiba {

	public Vertice porto_uniao    = new Vertice("Porto União",         203);
	public Vertice paulo_frontin  = new Vertice("Paulo Frontin",       172);
	public Vertice irati          = new Vertice("Irati",               139);
	public Vertice sao_mateus     = new Vertice("São Mateus do Sul",   123);
	public Vertice tres_barras    = new Vertice("Três Barras",         131);
	public Vertice canoinhas      = new Vertice("Canoinhas",           141);
	public Vertice mafra          = new Vertice("Mafra",                94);
	public Vertice lapa           = new Vertice("Lapa",                 74);
	public Vertice contenda       = new Vertice("Contenda",             39);
	public Vertice balsa_nova     = new Vertice("Balsa Nova",           41);
	public Vertice araucaria      = new Vertice("Araucária",            23);
	public Vertice tijucas_do_sul = new Vertice("Tijucas do Sul",       56);
	public Vertice palmeira       = new Vertice("Palmeira",             59);
	public Vertice sao_jose       = new Vertice("São José dos Pinhais", 13);
	public Vertice campo_largo    = new Vertice("Campo Largo",          27);
	public Vertice curitiba       = new Vertice("Curitiba",              0);

	{
		/**
		 * Porto União
		 * */
		porto_uniao.adiciona_adjacentes(
			new Adjacente(paulo_frontin, 46),
			new Adjacente(sao_mateus, 87),
			new Adjacente(canoinhas, 78)
		);
		
		/**
		 * Paulo Frontin
		 * */
		paulo_frontin.adiciona_adjacentes(
			new Adjacente(porto_uniao, 46),
			new Adjacente(irati, 75)
		);
		
		/**
		 * Irati
		 * */
		irati.adiciona_adjacentes(
				new Adjacente(paulo_frontin, 75),
				new Adjacente(sao_mateus, 57),
				new Adjacente(palmeira, 57)
		);
		
		/**
		 * São Mateus do Sul
		 * */
		sao_mateus.adiciona_adjacentes(
			new Adjacente(porto_uniao, 87),
			new Adjacente(tres_barras, 43),
			new Adjacente(irati, 57),
			new Adjacente(palmeira, 77),
			new Adjacente(lapa, 60)
		);
		
		/**
		 * Três Barras
		 * */
		tres_barras.adiciona_adjacentes(
			new Adjacente(canoinhas, 12),
			new Adjacente(sao_mateus, 43)
		);
		
		/**
		 * Canoinhas
		 * */
		canoinhas.adiciona_adjacentes(
			new Adjacente(porto_uniao, 78),
			new Adjacente(tres_barras, 12),
			new Adjacente(mafra, 66)
		);
		
		/**
		 * Mafra
		 */
		mafra.adiciona_adjacentes(
			new Adjacente(canoinhas, 66),
			new Adjacente(lapa, 57),
			new Adjacente(tijucas_do_sul, 99)
		);
		
		/**
		 * Lapa
		 */
		lapa.adiciona_adjacentes(
			new Adjacente(mafra, 57),
			new Adjacente(sao_mateus, 60),
			new Adjacente(contenda, 26)
		);

		/**
		 * Contenda
		 */
		contenda.adiciona_adjacentes(
			new Adjacente(lapa, 26),
			new Adjacente(araucaria, 18),
			new Adjacente(balsa_nova, 19)
		);

		/**
		 * Balsa Nova
		 */
		balsa_nova.adiciona_adjacentes(
			new Adjacente(contenda, 19),
			new Adjacente(curitiba, 51),
			new Adjacente(campo_largo, 22)
		);
		
		/**
		 * Araucária
		 */
		araucaria.adiciona_adjacentes(
			new Adjacente(contenda, 18),
			new Adjacente(curitiba, 37)
		);
		
		/**
		 * Tijucas do SUl
		 */
		tijucas_do_sul.adiciona_adjacentes(
			new Adjacente(mafra, 99),
			new Adjacente(sao_jose, 49)
		);
		
		/**
		 * Palmeira
		 */
		palmeira.adiciona_adjacentes(
			new Adjacente(irati, 75),
			new Adjacente(sao_mateus, 77),
			new Adjacente(campo_largo, 55)
		);
		
		/**
		 * São José dos Pinhais
		 */
		sao_jose.adiciona_adjacentes(
			new Adjacente(tijucas_do_sul, 49),
			new Adjacente(curitiba, 15)
		);
		
		/**
		 * Campo Largo
		 */
		campo_largo.adiciona_adjacentes(
			new Adjacente(curitiba, 29),
			new Adjacente(balsa_nova, 22),
			new Adjacente(palmeira, 55)
		);

		/**
		 * Curitiba
		 */
		curitiba.adiciona_adjacentes(
			new Adjacente(sao_jose, 15),
			new Adjacente(araucaria, 37),
			new Adjacente(balsa_nova, 51),
			new Adjacente(campo_largo, 29)
		);
	}
}
