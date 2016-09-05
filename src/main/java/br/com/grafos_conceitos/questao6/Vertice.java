package br.com.grafos_conceitos.questao6;

import java.util.ArrayList;
import java.util.List;

public class Vertice {

	private List<Aresta> saida = new ArrayList<>();
	private List<Aresta> entrada = new ArrayList<>();
	private int id;
	private int cor;

	public Vertice(int id) {
		this.id = id;
	}

	public void addSaida(Vertice vertice, int ligacoes) {
		this.saida.add(new Aresta(vertice, ligacoes));
		vertice.addEntrada(this, ligacoes);
	}

	public void addEntrada(Vertice vertice, int ligacoes) {
		this.entrada.add(new Aresta(vertice, ligacoes));
	}

	public boolean temLigacao(Vertice vertice) {
		for (Aresta aresta : saida) {
			if (aresta.getDestino().equals(vertice)) {
				return true;
			}
		}
		return false;
	}

	public int getGrau() {
		int grau = 0;
		for (Aresta aresta : saida) {
			grau += aresta.getQuantidade();
		}
		return grau;
	}

	public int getQuantidadeVizinhos() {
		return saida.size();
	}

	public Vertice getVizinho(int index) {
		return saida.get(index).getDestino();
	}

	public int getQuantidadeLigacoes(Vertice destino) {
		for (Aresta aresta : saida) {
			if (aresta.getDestino().equals(destino)) {
				return aresta.getQuantidade();
			}
		}
		return 0;
	}

	public boolean temArestaParalela() {
		for (Aresta aresta : saida) {
			if (aresta.getQuantidade() > 1) {
				return true;
			}
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public String getArestasSaida() {
		StringBuilder sb = new StringBuilder();
		for (Aresta aresta : saida) {
			for (int i = 0; i < aresta.getQuantidade(); i++) {
				sb.append(String.format("(%d, %d),", this.id, aresta.getDestino().getId()));
			}
		}
		return sb.toString();
	}
	
	public String getArestasEntrada() {
		StringBuilder sb = new StringBuilder();
		for (Aresta aresta : entrada) {
			for (int i = 0; i < aresta.getQuantidade(); i++) {
				sb.append(String.format("(%d, %d),", aresta.getDestino().getId(), this.id));
			}
		}
		return sb.toString();
	}

	public int getColor() {
		return cor;
	}

	public void setColor(int color) {
		this.cor = color;
	}

	public int getGrauEntrada() {
		int grau = 0;
		for (Aresta aresta : entrada) {
			grau += aresta.getQuantidade();
		}
		return grau;
	}
}
