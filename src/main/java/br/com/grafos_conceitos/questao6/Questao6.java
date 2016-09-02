package br.com.grafos_conceitos.questao6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Questao6 {

	
	public static String tipoDoGrafo(final int[][] matrizAdjacencia) {
		String tipoDoGrafo = "";
		
		if (isDirigido(matrizAdjacencia)) {
			tipoDoGrafo += "Dirigido";
		} else {
			tipoDoGrafo += "Não Dirigido";
		}
		
		if (isMultiGrafo(matrizAdjacencia)) {
			tipoDoGrafo += ", MultiGrafo";
		} else {
			tipoDoGrafo += ", Simples";
		}
		
		if (isRegular(matrizAdjacencia)) {
			tipoDoGrafo += ", Regular";
		}
		
		if (isCompleto(matrizAdjacencia)) {
			tipoDoGrafo += ", Completo";
		}
		
		if (isNulo(matrizAdjacencia)) {
			tipoDoGrafo += ", Nulo";
		}
		
		if (isBipartido(matrizAdjacencia)) {
			tipoDoGrafo += ", Bipartido";
		}
		
		return tipoDoGrafo;
	}

	static boolean isBipartido(int[][] matrizAdjacencia) {
		//TODO
		return false;
	}

	static boolean isNulo(int[][] matrizAdjacencia) {
		for (int i = 0; i < matrizAdjacencia.length; i++) {
			for (int j = 0; j < matrizAdjacencia.length; j++) {
				if (matrizAdjacencia[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean isCompleto(int[][] matrizAdjacencia) {
		int grau = -1;
		for (int i = 0; i < matrizAdjacencia.length; i++) {
			int grauAtual = 0;
			
			for (int j = 0; j < matrizAdjacencia.length; j++) {
				grauAtual += matrizAdjacencia[i][j];
			}
			
			if (grau == -1) {
				grau = grauAtual;
			} else if (grauAtual != grau) {
				return false;
			}
		}
		if (grau != matrizAdjacencia.length -1) {
			return false;
		}
		return true;
	}

	static boolean isRegular(int[][] matrizAdjacencia) {
		int grau = -1;
		for (int i = 0; i < matrizAdjacencia.length; i++) {
			int grauAtual = 0;
			
			for (int j = 0; j < matrizAdjacencia.length; j++) {
				grauAtual += matrizAdjacencia[i][j];
			}
			
			if (grau == -1) {
				grau = grauAtual;
			} else if (grauAtual != grau) {
				return false;
			}
		}
		return true;
	}

	static boolean isMultiGrafo(int[][] matrizAdjacencia) {
		for (int i = 0; i < matrizAdjacencia.length; i++) {
			if (matrizAdjacencia[i][i] != 0) {
				return true;
			}
			for (int j = 0; j < matrizAdjacencia.length; j++) {
				if (matrizAdjacencia[i][j] > 1) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean isDirigido(int[][] matrizAdjacencia) {
		for (int i = 0; i < matrizAdjacencia.length; i++) {
			for (int j = 0; j < matrizAdjacencia.length; j++) {
				if (matrizAdjacencia[i][j] != matrizAdjacencia[j][i]) {
					return true;
				}
			}
		}
		return false;
	}
}
