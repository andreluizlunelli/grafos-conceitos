package br.com.grafos_conceitos.questao7;

import br.com.grafos_conceitos.questao7.retornos.RetornoItemA;

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
		apresentar_A();
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
	
	public void apresentar_A() {
		RetornoItemA saemChegam = detarminarQuantasEntradasSaemEQuantasChegamACidade((byte) 3);
		if (saemChegam == null) {
			return;
		}
		out("Item A) da questão 7:\n"+saemChegam);
	}
	
	private RetornoItemA detarminarQuantasEntradasSaemEQuantasChegamACidade(byte cidade) {
		if (cidade > matriz[0].length) {
			out("Valor informado excede o limite de linhas da matriz: "+cidade);
			return null;
		}
		RetornoItemA retornoItemA = new RetornoItemA();
		return retornoItemA;
	}
	
	private static void out(String str) {
		System.out.println(str);
	}
	
}
