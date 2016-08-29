package br.com.grafos_conceitos.questao7.retornos;

public class RetornoItemA {
	byte saem = 0;
	byte chegam = 0;
	
	@Override
	public String toString() {
		return String.format("Entradas SAEM: %d, Entradas CHEGAM: %d", saem, chegam);
	}
}
