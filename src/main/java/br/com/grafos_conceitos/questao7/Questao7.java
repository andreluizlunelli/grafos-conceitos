package br.com.grafos_conceitos.questao7;

public class Questao7 {

	public static void main(String[] args) {
		Questao7 questao7 = new Questao7();
		questao7.inicio();
	}

	final byte totalLinha = 5;
	final byte totalColuna = 5;
	final byte[][] matriz = new byte[totalLinha][totalColuna];

	public void inicio() {
		inicializarValoresMatriz();
	}

	private void inicializarValoresMatriz() {
		// LINHA 0
		matriz[0][0] = 0;
		matriz[0][1] = 0;
		matriz[0][2] = 0;
		matriz[0][3] = 0;
		matriz[0][4] = 0;

		// LINHA 1
		matriz[1][0] = 1;
		matriz[1][1] = 0;
		matriz[1][2] = 0;
		matriz[1][3] = 0;
		matriz[1][4] = 1;
		
		// LINHA 2
		matriz[2][0] = 0;
		matriz[2][1] = 1;
		matriz[2][2] = 0;
		matriz[2][3] = 0;
		matriz[2][4] = 0;
		
		// LINHA 3
		matriz[3][0] = 0;
		matriz[3][1] = 1;
		matriz[3][2] = 0;
		matriz[3][3] = 0;
		matriz[3][4] = 0;
		
		// LINHA 4
		matriz[4][0] = 0;
		matriz[4][1] = 1;
		matriz[4][2] = 0;
		matriz[4][3] = 1;
		matriz[4][4] = 0;
	}
}
