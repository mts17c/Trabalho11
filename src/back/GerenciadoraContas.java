package back;

import java.util.List;

public class GerenciadoraContas {

    private List<ContaCorrente> contasDoBanco;

    public GerenciadoraContas(List<ContaCorrente> contasDoBanco) {
        this.contasDoBanco = contasDoBanco;
    }

    public List<ContaCorrente> getContasDoBanco() {
        return contasDoBanco;
    }

    public ContaCorrente pesquisaConta(int idConta) {
        for (ContaCorrente contaCorrente : contasDoBanco) {
            if (contaCorrente.getId() == idConta)
                return contaCorrente;
        }
        return null;
    }

    public void adicionaConta(ContaCorrente novaConta) {
        this.contasDoBanco.add(novaConta);
    }

    public boolean removeConta(int idConta) {
        for (int i = 0; i < contasDoBanco.size(); i++) {
            ContaCorrente conta = contasDoBanco.get(i);
            if (conta.getId() == idConta) {
                contasDoBanco.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean contaAtiva(int idConta) {
        for (ContaCorrente conta : contasDoBanco) {
            if (conta.getId() == idConta && conta.isAtiva()) {
                return true;
            }
        }
        return false;
    }

    public boolean transfereValor(int idContaOrigem, double valor, int idContaDestino) {
        ContaCorrente contaOrigem = pesquisaConta(idContaOrigem);
        ContaCorrente contaDestino = pesquisaConta(idContaDestino);

        if (contaOrigem != null && contaDestino != null && contaOrigem.getSaldo() >= valor) {
            contaDestino.setSaldo(contaDestino.getSaldo() + valor);
            contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
            return true;
        }

        return false;
    }
}
