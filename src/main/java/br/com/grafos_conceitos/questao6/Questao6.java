package br.com.grafos_conceitos.questao6;

public class Questao6 {
	
	public static String tipoDoGrafo(final int[][] matrizAdjacencia) {
		String tipoDoGrafo = "";
		Grafo grafo = new Grafo(matrizAdjacencia);
		
		if (grafo.isDirigido()) {
			tipoDoGrafo += "Dirigido";
		} else {
			tipoDoGrafo += "Não Dirigido";
		}
		
		if (grafo.isMultigrafo()) {
			tipoDoGrafo += ", MultiGrafo";
		} else {
			tipoDoGrafo += ", Simples";
		}
		
		if (grafo.isRegular()) {
			tipoDoGrafo += ", Regular";
		}
		
		if (grafo.isCompleto()) {
			tipoDoGrafo += ", Completo";
		}
		
		if (grafo.isNulo()) {
			tipoDoGrafo += ", Nulo";
		}
		
		if (grafo.isBipartido()) {
			tipoDoGrafo += ", Bipartido";
		}
		
		return tipoDoGrafo;
	}
	
	public static String arestasDoGrafo(int[][] matrizAdjacencia) {
		Grafo grafo = new Grafo(matrizAdjacencia);
		return "Quantidade de Arestas: " + grafo.getQuantidadeArestas() + '\n' + grafo.getArestas();
	}
	
	public static String grausDoVertice(int[][] matrizAdjacencia) {
		//TODO
		return null;
	}
}
