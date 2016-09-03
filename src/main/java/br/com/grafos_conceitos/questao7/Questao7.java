package br.com.grafos_conceitos.questao7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.grafos_conceitos.questao7.retornos.RetornoItemA;

/**
 * @author André Lunelli<to.lunelli@gmail.com>
 * 
 * Os calculos pressupõem a matriz do enunciado, uma matriz regular
 *
 */
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
		apresentar_B();
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
		RetornoItemA saemChegam = detarminarQuantasEntradasSaemEQuantasChegamACidade((byte) 2);
		if (saemChegam == null) {
			return;
		}
		out("Item A) da questão 7:\n"+saemChegam);
	}
	
	public void apresentar_B() {
		out("Item B) da questão 7:\n"+determinarQualCidadesChegaOMaiorNumeroDeEstradas());
	}
	
	private RetornoItemA detarminarQuantasEntradasSaemEQuantasChegamACidade(final byte cidade) {
		if (cidade > matriz[0].length) {
			out("Valor informado excede o limite de linhas da matriz: "+cidade);
			return null;
		}
		if (cidade < 0) {
			out("Valor informado "+cidade+", não pode ser menor que 0: ");
			return null;			
		}
		int saem = 0;
		int chegam = 0;
		for (int i=0; i<matriz.length; i++) 
			if (matriz[i][cidade] == 1) 
				chegam++;
		for (int i=0; i<matriz[cidade].length; i++) 
			if (matriz[cidade][i] == 1) 
				saem++;
		return new RetornoItemA((byte) cidade, (byte) saem, (byte) chegam);
	}
	
	private RetornoItemA determinarQualCidadesChegaOMaiorNumeroDeEstradas() {
		List<RetornoItemA> itemA = new ArrayList<RetornoItemA>();
		for (int i=1; i<matriz.length; i++) {
			itemA.add(detarminarQuantasEntradasSaemEQuantasChegamACidade((byte) i));
		}
		itemA.sort(new Comparator<RetornoItemA>() {
			@Override
			public int compare(RetornoItemA o1, RetornoItemA o2) {
				if (o1.getChegam() > o2.getChegam()) {
					return 1;
				} else if (o1.getChegam() < o2.getChegam()) {
					return -1;
				} else {
					return 0;					
				}
			}
		});
		return itemA.get(itemA.size()-1); // pega o ultimo elemento da lista ordenada
	}
	
	private static void out(Object str) {
		System.out.println(str);
	}
	
}
