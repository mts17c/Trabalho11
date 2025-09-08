package negocio;

import java.util.List;

public class GerenciadoraClientes {

    private List<Cliente> clientesDoBanco;

    public GerenciadoraClientes(List<Cliente> clientesDoBanco) {
        this.clientesDoBanco = clientesDoBanco;
    }
    
    public List<Cliente> getClientesDoBanco() {
        return clientesDoBanco;
    }
    
    public Cliente pesquisaCliente(int idCliente) {
        for (Cliente cliente : clientesDoBanco) {
            if (cliente.getId() == idCliente) {
                return cliente;
            }
        }
        return null;
    }
    
    public void adicionaCliente(Cliente novoCliente) {
        clientesDoBanco.add(novoCliente);
    }

    public boolean removeCliente(int idCliente) {
        return clientesDoBanco.removeIf(cliente -> cliente.getId() == idCliente);
    }

    public boolean clienteAtivo(int idCliente) {
        for (Cliente cliente : clientesDoBanco) {
            if (cliente.getId() == idCliente) {
                return cliente.isAtivo();
            }
        }
        return false;
    }

    public void limpa() {
        this.clientesDoBanco.clear();
    }
    
    public boolean validaIdade(int idade) throws IdadeNaoPermitidaException {
        if (idade < 18 || idade > 65) {
            throw new IdadeNaoPermitidaException();
        }
        return true;
    }
}
