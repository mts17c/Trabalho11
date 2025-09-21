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
