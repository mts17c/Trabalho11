package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import back.Cliente;
import back.ContaCorrente;
import back.GerenciadoraClientes;
import back.GerenciadoraContas;
import back.IdadeNaoPermitidaException;

public class Cinza {
//Teste de padrão

    @Test
    public void testValidaIdadePadrao() throws IdadeNaoPermitidaException {
    	// 1) Cria um novo cliente com 30 anos
    	// 2) Passa um vetor com esse cliente para o Gerenciador de Contas
    	// 3) Verifica se a idade esta entre 18 e 65
        Cliente cliente = new Cliente(1, "João", 30, "joao@email.com", 1, true);
        GerenciadoraClientes ger = new GerenciadoraClientes(Arrays.asList(cliente));

        boolean resultado = ger.validaIdade(cliente.getIdade());

        assertTrue(resultado);
    }
	
//Teste de matriz
    @Test
    public void testMatrizTransferencias() {
    	// 1) Cria uma matriz de valores para simular transferências
    	//    Cada linha da matriz representa um cenário de teste: 
    	//    [saldoOrigem, saldoDestino, valorTransferencia]
    	// 2) Para cada linha da matriz:
    	//    a) Cria uma conta de origem com o saldo informado
    	//    b) Cria uma conta de destino com o saldo informado
    	//    c) Cria um gerenciador de contas contendo as duas contas
    	//    d) Realiza a transferência do valor especificado
    	//    e) Verifica se a transferência ocorreu com sucesso
    	//    f) Valida se os saldos final da origem e destino estão corretos
    	double[][] transferencias = {
    	    {500, 100, 200},
    	    {300, 200, 100},
    	    {1000, 50, 500},
    	};

    	for (double[] t : transferencias) {
    	    ContaCorrente origem = new ContaCorrente(1, t[0], true);
    	    ContaCorrente destino = new ContaCorrente(2, t[1], true);
    	    GerenciadoraContas ger = new GerenciadoraContas(Arrays.asList(origem, destino));

    	    boolean resultado = ger.transfereValor(1, t[2], 2);

    	    assertTrue(resultado);
    	    assertEquals(t[0] - t[2], origem.getSaldo(), 0.001);
    	    assertEquals(t[1] + t[2], destino.getSaldo(), 0.001);
    	}
    }

}
