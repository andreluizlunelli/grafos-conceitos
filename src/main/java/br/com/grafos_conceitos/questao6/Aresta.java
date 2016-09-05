package br.com.grafos_conceitos.questao6;

public class Aresta {

	private final Vertice destino;
	private final int quantidade;

	public Aresta(Vertice destino, int quantidade) {
		this.destino = destino;
		this.quantidade = quantidade;
	}

	public Vertice getDestino() {
		return destino;
	}

	public int getQuantidade() {
		return quantidade;
	}
}
