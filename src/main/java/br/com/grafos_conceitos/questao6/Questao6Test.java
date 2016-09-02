package br.com.grafos_conceitos.questao6;

import org.junit.Assert;
import org.junit.Test;


public class Questao6Test {

	@Test
	public void testNaoDirigido() throws Exception {
		Assert.assertFalse(Questao6.isDirigido(new int[][] {{0,1,1}, {1,0,1}, {1,1,0}}));
	}
	
	@Test
	public void testDirigido() throws Exception {
		Assert.assertTrue(Questao6.isDirigido(new int[][] {{0,1,1}, {1,0,1}, {1,0,0}}));
	}
	
	@Test
	public void testMultiGrafoLoop() throws Exception {
		Assert.assertTrue(Questao6.isMultiGrafo(new int[][] {{1,1,1}, {1,1,1}, {1,1,1}}));
	}
	
	@Test
	public void testMultiGrafoParelela() throws Exception {
		Assert.assertTrue(Questao6.isMultiGrafo(new int[][] {{0,1,2}, {1,0,1}, {2,1,0}}));
	}
	
	@Test
	public void testGrafoSimples() throws Exception {
		Assert.assertFalse(Questao6.isMultiGrafo(new int[][] {{0,1,1}, {1,0,1}, {1,1,0}}));
	}
	
	@Test
	public void testGrafoRegular() throws Exception {
		Assert.assertTrue(Questao6.isRegular(new int[][] {{0,1,1}, {1,0,1}, {1,1,0}}));
	}
	
	@Test
	public void testGrafoNaoRegular() throws Exception {
		Assert.assertFalse(Questao6.isRegular(new int[][] {{0,0,1}, {0,0,1}, {1,1,0}}));
	}
	
	@Test
	public void testGrafoCompleto() throws Exception {
		Assert.assertTrue(Questao6.isCompleto(new int[][] {{0,1,1}, {1,0,1}, {1,1,0}}));
	}
	
	@Test
	public void testGrafoNaoCompleto() throws Exception {
		Assert.assertFalse(Questao6.isCompleto(new int[][] {{0,1,1,0}, 
															{1,0,0,1}, 
															{1,0,0,1}, 
															{0,1,1,0}}));
	}
}
