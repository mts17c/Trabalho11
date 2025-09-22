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
	    // 1) Define a idade no limite inferior abaixo do permitido (17)
	    // 2) Chama o método validaIdade(17)
	    // 3) Verifica que o retorno é falso, confirmando a invalidez
	    assertFalse(GerenciadoraClientes.validaIdade(17));
	}

	@Test
	public void testIdadeLimiteInferiorValida() throws IdadeNaoPermitidaException {
	    // 1) Define a idade no limite inferior válido (18)
	    // 2) Chama o método validaIdade(18)
	    // 3) Verifica que o retorno é verdadeiro, confirmando a validade
	    assertTrue(GerenciadoraClientes.validaIdade(18));
	}

	@Test
	public void testIdadeLimiteSuperiorValida() throws IdadeNaoPermitidaException {
	    // 1) Define a idade no limite superior válido (65)
	    // 2) Chama o método validaIdade(65)
	    // 3) Verifica que o retorno é verdadeiro, confirmando a validade
	    assertTrue(GerenciadoraClientes.validaIdade(65));
	}

	@Test
	public void testIdadeLimiteSuperiorInvalida() throws IdadeNaoPermitidaException {
	    // 1) Define a idade no limite superior acima do permitido (66)
	    // 2) Chama o método validaIdade(66)
	    // 3) Verifica que o retorno é falso, confirmando a invalidez
	    assertFalse(GerenciadoraClientes.validaIdade(66));
	}


//Particionamento de equivalência
	@Test
	public void testIdadeMenorQue18() throws IdadeNaoPermitidaException {
	    // 1) Define a idade em uma partição inválida (menor que 18)
	    // 2) Chama o método validaIdade(10)
	    // 3) Verifica que o retorno é falso, confirmando a invalidez
	    assertFalse(GerenciadoraClientes.validaIdade(10));
	}

	@Test
	public void testIdadeValida() throws IdadeNaoPermitidaException {
	    // 1) Define a idade em uma partição válida (entre 18 e 65)
	    // 2) Chama o método validaIdade(30)
	    // 3) Verifica que o retorno é verdadeiro, confirmando a validade
	    assertTrue(GerenciadoraClientes.validaIdade(30));
	}

	@Test
	public void testIdadeMaiorQue65() throws IdadeNaoPermitidaException {
	    // 1) Define a idade em uma partição inválida (maior que 65)
	    // 2) Chama o método validaIdade(70)
	    // 3) Verifica que o retorno é falso, confirmando a invalidez
	    assertFalse(GerenciadoraClientes.validaIdade(70));
	}

}
