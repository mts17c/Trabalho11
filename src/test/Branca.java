package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import back.ContaCorrente;
import back.GerenciadoraContas;

public class Branca {

    // Teste de fluxo de controle
    @Test
    public void testTransfereValorComSucesso() {
    	// 1) Cria duas novas contas
    	// 2) Adiciona em um vetor
    	// 3) Passa o vetor para o Gerenciador de Contas
    	// 4) Tenta transferir 200 da conta 1 para 2
    	// 5) se conseguir, verifica os saldos se os saldos correspondem
        ContaCorrente origem = new ContaCorrente(1, 500, true);
        ContaCorrente destino = new ContaCorrente(2, 100, true);
        List<ContaCorrente> contas = Arrays.asList(origem, destino);
        GerenciadoraContas ger = new GerenciadoraContas(contas);

        boolean resultado = ger.transfereValor(1, 200, 2);

        assertTrue(resultado);
        assertEquals(300, origem.getSaldo(), 0.01);
        assertEquals(300, destino.getSaldo(), 0.01);
    }

    @Test
    public void testTransfereValorSaldoInsuficiente() {
    	// 1) Cria duas novas contas
    	// 2) Adiciona em um vetor
    	// 3) Passa o vetor para o Gerenciador de Contas
    	// 4) Tenta transferir 200 da conta 1 para 2
    	// 5) se conseguir(nao vai), verifica os saldos se os saldos correspondem
        ContaCorrente origem = new ContaCorrente(1, 100, true);
        ContaCorrente destino = new ContaCorrente(2, 100, true);
        List<ContaCorrente> contas = Arrays.asList(origem, destino);
        GerenciadoraContas ger = new GerenciadoraContas(contas);

        boolean resultado = ger.transfereValor(1, 200, 2);

        assertFalse(resultado);
        assertEquals(100, origem.getSaldo(), 0.01);
        assertEquals(100, destino.getSaldo(), 0.01);
    }

    // Teste de loop
    @Test
    public void testPesquisaContaLoop() {
    	// 1) Cria 3 contas em um vetor
    	// 2) Passa o vetor para o Gerenciador de Contas
    	// 3) Pesquisa pelo ID da conta na funcao pesquisaConta:
        /*public ContaCorrente pesquisaConta(int idConta) {
            for (ContaCorrente contaCorrente : contasDoBanco) {
                if (contaCorrente.getId() == idConta)
                    return contaCorrente;
            }
            return null;
        }
        */
    	// 4) Se nao for nulo, verifica se os saldos correspondem
        List<ContaCorrente> contas = Arrays.asList(
            new ContaCorrente(1, 100, true),
            new ContaCorrente(2, 200, true),
            new ContaCorrente(3, 300, true)
        );
        GerenciadoraContas ger = new GerenciadoraContas(contas);

        ContaCorrente conta = ger.pesquisaConta(3);

        assertNotNull(conta);
        assertEquals(300, conta.getSaldo(), 0.01);
    }
}
