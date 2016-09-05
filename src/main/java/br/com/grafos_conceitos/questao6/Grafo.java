package br.com.grafos_conceitos.questao6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Grafo {

	private List<Vertice> vertices = new ArrayList<>();

	public Grafo(int[][] matriz) {
		processaMatriz(matriz);
	}

	private void processaMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			vertices.add(new Vertice(i));
		}
		for (int i = 0; i < matriz.length; i++) {
			Vertice origem = vertices.get(i);
			for (int j = 0; j < matriz.length; j++) {
				int ligacoes = matriz[i][j];
				if (ligacoes != 0) {
					Vertice destino = vertices.get(j);
					origem.addSaida(destino, ligacoes);
				}
			}
		}
	}

	public int getQuantidadeArestas() {
		int arestas = 0;
		for (Vertice vertice : vertices) {
			arestas += vertice.getGrau();
		}
		if (this.isDirigido()) {
			for (Vertice vertice : vertices) {
				arestas += vertice.getGrauEntrada();
			}
		}
		return arestas;
	}

	public boolean isNulo() {
		for (Vertice vertice : vertices) {
			if (vertice.getGrau() > 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isCompleto() {
		if (this.isDirigido() || this.isMultigrafo()) {
			return false;
		}

		int grauCompleto = this.vertices.size() - 1;

		for (Vertice vertice : vertices) {
			if (vertice.getGrau() != grauCompleto) {
				return false;
			}
		}

		return true;
	}

	public boolean isRegular() {
		int grau = -1;
		for (Vertice vertice : vertices) {
			if (grau == -1) {
				grau = vertice.getGrau();
			} else if (grau != vertice.getGrau()) {
				return false;
			}
		}
		return true;
	}

	public boolean isBipartido() {
		Queue<Vertice> fila = new LinkedList<>();
		for (Vertice vertice : vertices) {
			vertice.setColor(-1);
			fila.add(vertice);
		}

		fila.peek().setColor(0);
		while (!fila.isEmpty()) {
			Vertice vertice = fila.poll();
			for (int i = 0; i < vertice.getQuantidadeVizinhos(); i++) {
				Vertice vizinho = vertice.getVizinho(i);
				if (vizinho.getColor() == -1) {
					vizinho.setColor((vertice.getColor() + 1) % 2);
					fila.add(vizinho);
				} else if (vizinho.getColor() == vertice.getColor()) {
					return false;
				}
			}
		}

		return true;
	}

	public boolean isDirigido() {
		for (int i = 0; i < vertices.size(); i++) {
			Vertice origem = vertices.get(i);
			for (int j = 0; j < vertices.size(); j++) {
				Vertice destino = vertices.get(j);
				if (!origem.equals(destino)) {
					if (origem.temLigacao(destino)) {
						if (!destino.temLigacao(origem)) {
							return true;
						} else if (origem.getQuantidadeLigacoes(destino) != destino.getQuantidadeLigacoes(origem)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public boolean isMultigrafo() {
		for (Vertice vertice : vertices) {
			if (vertice.temLigacao(vertice) || vertice.temArestaParalela()) {
				return true;
			}
		}
		return false;
	}

	public String getArestas() {
		StringBuilder sb = new StringBuilder();
		sb.append("E = { ");
		for (Vertice vertice : vertices) {
			sb.append(vertice.getArestasSaida());
		}
		if (this.isDirigido()) {
			for (Vertice vertice : vertices) {
				sb.append(vertice.getArestasEntrada());
			}
		}
		sb.append("}");
		return sb.toString();
	}
}
