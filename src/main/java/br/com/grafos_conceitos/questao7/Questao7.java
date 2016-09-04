package br.com.grafos_conceitos.questao7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.grafos_conceitos.questao7.retornos.Cidade;

/**
 * @author André Lunelli<to.lunelli@gmail.com>
 * 
 *         Os calculos pressupõem a matriz do enunciado, uma matriz regular
 *
 */
public class Questao7 {

	public static void main(String[] args) {
		Questao7 questao7 = new Questao7();
		questao7.inicio();
	}

	final byte totalLinha = 6;
	final byte totalColuna = 6;
	final byte[][] matriz = new byte[totalLinha][totalColuna];

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

		//x
//		matriz[5][0] = 0;
//		matriz[5][1] = 0;
//		matriz[5][2] = 0;
//		matriz[5][3] = 0;
//		matriz[5][4] = 0;
//
//		matriz[0][5] = 0;
//		matriz[1][5] = 0;
//		matriz[2][5] = 0;
//		matriz[3][5] = 0;
//		matriz[4][5] = 0;
//		matriz[5][5] = 0;
		
	}

	public void inicio() {
		inicializarValoresMatriz();
		apresentar_A();
		out("\n");
		apresentar_B();
		out("\n");
		apresentar_C();
		out("\n");
		apresentar_D();
		out("\n");
		apresentar_E();
		out("\n");
	}

	public void apresentar_A() {
		Cidade saemChegam = detarminarQuantasEntradasSaemEQuantasChegamACidade((byte) 2);
		if (saemChegam == null) {
			return;
		}
		out("Item A) da questão 7:\n" + saemChegam);
	}

	public void apresentar_B() {
		Cidade cidade = determinarQualCidadesChegaOMaiorNumeroDeEstradas();
		if (cidade == null) {
			return;
		}
		out("Item B) da questão 7:\n" + cidade);
	}

	public void apresentar_C() {
		List retorno = retornarLigacoesDeMaoDupla((byte) 3);
		boolean isTodasMaoDupla = (boolean) retorno.get(0);
		Cidade cidade = (Cidade) retorno.get(1);
		if (isTodasMaoDupla) {
			out("Todas as ligações são de mão dupla.");
		} else {
			out("Não são todas/nenhuma ligação de mão dupla.");
		}
		out(String.format("CIDADE: %d", cidade.getCidade()));
	}

	private void apresentar_D() {
		byte kcidade = 1;
		List<Cidade> cidades = cidadesQuePossuemSaidasDiretasParaCidade(kcidade);
		out("Lista de cidades que tem saída direta para cidade " + kcidade);
		for (Cidade cidade : cidades) {
			out(cidade);
		}
	}

	private void apresentar_E() {
		List<Cidade> e_1 = E_1();
		List<Cidade> e_2 = E_2();
		List<Cidade> e_3 = E_3();
		apresentarSubItensE(e_1, "Item E_1) Cidades isoladas:", "Não existem cidades desconexas!");
		apresentarSubItensE(e_2, "Item E_2) Cidades com entrada e sem saída:", "Não existem cidades sem saida!");
		
	}

	private void apresentarSubItensE(List<Cidade> l, String titulo, String frase) {
		out(titulo);
		if (l.isEmpty()) 
			out(frase);
		else for (Cidade cidade : l) 
				out(cidade);		
	}

	private List<Cidade> E_3() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Cidade> E_2() {
		List<Cidade> listaCidadesSemSaida = new ArrayList<>();
		for (int x = 0; x < matriz.length; x++) {
			boolean isComSaida = false;
			for (int i = 0; i < matriz.length; i++) { // valida se é sem saida
				byte kcidade = matriz[x][i];
				if (kcidade == 1) {
					isComSaida = true;
					break; // ja sei que é com saida;
				}
			}
			if (!isComSaida) { // verifico se tem entrada
				for (int i = 0; i < matriz.length; i++) {
					byte zcidade = matriz[i][x];
					if (zcidade == 0) {
						continue;
					} else {
						listaCidadesSemSaida.add(obterCidade((byte) x));
						break; // já sem que tem pelo menos uma entrada
					}
				}
			}
			
		}
		return listaCidadesSemSaida;
	}

	private List<Cidade> E_1() {
		List<Cidade> listaCidadesDesconexas = new ArrayList<>();
		boolean disconexo = true;
		for (int x = 0; x < matriz.length; x++) {
			for (int i = 0; i < matriz.length; i++) {
				byte kcidade = matriz[x][i];
				if (kcidade == 0) {
					continue;
				} else {
					disconexo = false; // n é desconexo
					break;
				}
			}
			if (disconexo) {
				for (int i = 0; i < matriz.length; i++) {
					byte kcidade = matriz[i][x];
					if (kcidade == 0) {
						continue;
					} else {
						disconexo = false; // n é desconexo
						break;
					}
				}
			}
			if (disconexo) {
				// é um vertice desconexo
				listaCidadesDesconexas.add(obterCidade((byte) x));
			}
		}
		return listaCidadesDesconexas;
	}

	private List<Cidade> cidadesQuePossuemSaidasDiretasParaCidade(byte k) {
		List<Cidade> listaCidades = new ArrayList<Cidade>();
		for (int i = 0; i < matriz.length; i++) {
			byte kcidade = matriz[i][((int) k)];
			if (kcidade == 1) {
				listaCidades.add(detarminarQuantasEntradasSaemEQuantasChegamACidade((byte) i));
			}
		}
		return listaCidades;
	}
	
	/**
	 * Alias para função detarminarQuantasEntradasSaemEQuantasChegamACidade
	 * @param k
	 * @return Cidade
	 */
	private Cidade obterCidade(byte k) {
		return detarminarQuantasEntradasSaemEQuantasChegamACidade(k);
	}

	private Cidade detarminarQuantasEntradasSaemEQuantasChegamACidade(final byte cidade) {
		if (cidade > matriz[0].length) {
			out("Valor informado excede o limite de linhas da matriz: " + cidade);
			return null;
		}
		if (cidade < 0) {
			out("Valor informado " + cidade + ", não pode ser menor que 0: ");
			return null;
		}
		int saem = 0;
		int chegam = 0;
		for (int i = 0; i < matriz.length; i++)
			if (matriz[i][cidade] == 1)
				chegam++;
		for (int i = 0; i < matriz[cidade].length; i++)
			if (matriz[cidade][i] == 1)
				saem++;
		return new Cidade((byte) cidade, (byte) saem, (byte) chegam);
	}

	private Cidade determinarQualCidadesChegaOMaiorNumeroDeEstradas() {
		List<Cidade> itemA = new ArrayList<Cidade>();
		for (int i = 1; i < matriz.length; i++) {
			itemA.add(detarminarQuantasEntradasSaemEQuantasChegamACidade((byte) i));
		}
		itemA.sort(new Comparator<Cidade>() {
			@Override
			public int compare(Cidade o1, Cidade o2) {
				if (o1.getChegam() > o2.getChegam()) {
					return 1;
				} else if (o1.getChegam() < o2.getChegam()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		return itemA.get(itemA.size() - 1); // pega o ultimo elemento da lista
											// ordenada
	}

	private List retornarLigacoesDeMaoDupla(final byte k) {
		for (int i = 0; i < matriz.length; i++) {
			if (i == (int) k) {
				continue;
			}
			byte valor1 = matriz[i][k];
			byte valor2 = matriz[k][i];
			if (valor1 == 1 && valor2 == 1) {
				continue;
			} else {
				return formatarRetornoLigacaoMaoDupla(false, k);
			}
		}
		return formatarRetornoLigacaoMaoDupla(true, k);
	}

	private List formatarRetornoLigacaoMaoDupla(boolean isTodasMaoDupla, byte cidade) {
		List<Object> cidadeMaisBoleano = new ArrayList<>();
		cidadeMaisBoleano.add(isTodasMaoDupla);
		cidadeMaisBoleano.add(detarminarQuantasEntradasSaemEQuantasChegamACidade(cidade));
		return cidadeMaisBoleano;
	}

	private static void out(Object str) {
		System.out.println(str);
	}

}
