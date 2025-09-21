package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import back.GerenciadoraClientes;
import back.IdadeNaoPermitidaException;

public class Preta {
//Análise do valor limite
	@Test
	public void testIdadeLimiteInferiorInvalida() throws IdadeNaoPermitidaException {
	    assertFalse(GerenciadoraClientes.validaIdade(17));
	}

	@Test
	public void testIdadeLimiteInferiorValida() throws IdadeNaoPermitidaException {
	    assertTrue(GerenciadoraClientes.validaIdade(18));
	}

	@Test
	public void testIdadeLimiteSuperiorValida() throws IdadeNaoPermitidaException {
	    assertTrue(GerenciadoraClientes.validaIdade(65));
	}

	@Test
	public void testIdadeLimiteSuperiorInvalida() throws IdadeNaoPermitidaException {
	    assertFalse(GerenciadoraClientes.validaIdade(66));
	}

//Particionamento de equivalência
	@Test
	public void testIdadeMenorQue18() throws IdadeNaoPermitidaException {
	    assertFalse(GerenciadoraClientes.validaIdade(10));
	}

	@Test
	public void testIdadeValida() throws IdadeNaoPermitidaException {
	    assertTrue(GerenciadoraClientes.validaIdade(30));
	}

	@Test
	public void testIdadeMaiorQue65() throws IdadeNaoPermitidaException {
	    assertFalse(GerenciadoraClientes.validaIdade(70));
	}
}
