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
    public void testTransfereValorPadrao() {
        ContaCorrente origem = new ContaCorrente(1, 500, true);
        ContaCorrente destino = new ContaCorrente(2, 100, true);
        List<ContaCorrente> contas = Arrays.asList(origem, destino);
        GerenciadoraContas ger = new GerenciadoraContas(contas);

        boolean resultado = ger.transfereValor(1, 200, 2);

        assertTrue(resultado);
        assertEquals(300, origem.getSaldo(), 0.001);
        assertEquals(300, destino.getSaldo(), 0.001);
    }

    @Test
    public void testValidaIdadePadrao() throws IdadeNaoPermitidaException {
        Cliente cliente = new Cliente(1, "João", 30, "joao@email.com", 1, true);
        GerenciadoraClientes ger = new GerenciadoraClientes(Arrays.asList(cliente));

        boolean resultado = ger.validaIdade(cliente.getIdade());

        assertTrue(resultado);
    }
	
//Teste de matriz
    @Test
    public void testMatrizIdade() {
        int[] idadesValidas = {18, 25, 40, 65};
        int[] idadesInvalidas = {10, 17, 66, 80};

        GerenciadoraClientes ger = new GerenciadoraClientes(Arrays.asList());
        for (int idade : idadesValidas) {
            try {
                assertTrue(ger.validaIdade(idade));
            } catch (IdadeNaoPermitidaException e) {
                fail("Falhou em idade válida: " + idade);
            }
        }
        for (int idade : idadesInvalidas) {
            try {
                ger.validaIdade(idade);
                fail("Aceitou idade inválida: " + idade);
            } catch (IdadeNaoPermitidaException e) {
                assertEquals(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA, e.getMessage());
            }
        }
    }

    @Test
    public void testMatrizTransferencias() {
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
