package br.com.grafos_conceitos.questao6;

import org.junit.Assert;
import org.junit.Test;

public class GrafoTest {

	@Test
	public void testNaoDirigido() throws Exception {
		Assert.assertFalse(new Grafo(new int[][] { { 0, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 } }).isDirigido());
	}

	@Test
	public void testDirigido() throws Exception {
		Assert.assertTrue(new Grafo(new int[][] { { 0, 1, 1 }, { 1, 0, 1 }, { 1, 0, 0 } }).isDirigido());
	}

	@Test
	public void testMultiGrafoLoop() throws Exception {
		Assert.assertTrue(new Grafo(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } }).isMultigrafo());
	}

	@Test
	public void testMultiGrafoParelela() throws Exception {
		Assert.assertTrue(new Grafo(new int[][] { { 0, 1, 2 }, { 1, 0, 1 }, { 2, 1, 0 } }).isMultigrafo());
	}

	@Test
	public void testGrafoSimples() throws Exception {
		Assert.assertFalse(new Grafo(new int[][] { { 0, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 } }).isMultigrafo());
	}

	@Test
	public void testGrafoRegular() throws Exception {
		Assert.assertTrue(new Grafo(new int[][] { { 0, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 } }).isRegular());
	}

	@Test
	public void testGrafoNaoRegular() throws Exception {
		Assert.assertFalse(new Grafo(new int[][] { { 0, 0, 1 }, { 0, 0, 1 }, { 1, 1, 0 } }).isRegular());
	}

	@Test
	public void testGrafoCompleto() throws Exception {
		Assert.assertTrue(new Grafo(new int[][] { { 0, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 } }).isCompleto());
	}

	@Test
	public void testGrafoNaoCompleto() throws Exception {
		Assert.assertFalse(
				new Grafo(new int[][] { { 0, 1, 1, 0 }, { 1, 0, 0, 1 }, { 1, 0, 0, 1 }, { 0, 1, 1, 0 } }).isCompleto());
	}

	@Test
	public void testGrafoNulo() throws Exception {
		Assert.assertTrue(
				new Grafo(new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } }).isNulo());
	}

	@Test
	public void testGrafoNaoNulo() throws Exception {
		Assert.assertFalse(
				new Grafo(new int[][] { { 0, 1, 0, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } }).isNulo());
	}

	@Test
	public void testGrafoNaoBipartido() throws Exception {
		Assert.assertFalse(new Grafo(new int[][] { { 0, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 0 } })
				.isBipartido());
	}

	@Test
	public void testGrafoBipartido() throws Exception {
		Assert.assertTrue(new Grafo(new int[][] { { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 0, 1, 0 } })
				.isBipartido());
	}
}
