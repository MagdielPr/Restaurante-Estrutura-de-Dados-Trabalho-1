package GestaoCliente;

import GestaoCliente.Cliente;
import GestaoCliente.GestaoCliente;
import GestaoMesa.GestaoMesa;

public class TesteGestaoCliente {
    public static void main(String[] args) {
        GestaoCliente gestaoCliente = new GestaoCliente();

        // Cadastrar clientes
        gestaoCliente.cadastrarCliente("João Silva", "11999999999", "joao@email.com");
        gestaoCliente.cadastrarCliente("Maria Santos", "22888888888", "maria@email.com");
        gestaoCliente.cadastrarCliente("Pedro Souza", "33777777777", "pedro@email.com");

        // Consultar clientes
        System.out.println("Clientes cadastrados:");
        gestaoCliente.consultarClientes();

        // Atualizar cliente
        gestaoCliente.atualizarCliente("João Silva", "João Batista", "11999999990", "joao.batista@email.com");

        // Remover cliente
        gestaoCliente.removerCliente("Maria Santos");

        // Consultar clientes novamente
        System.out.println("\nClientes cadastrados após atualização e remoção:");
        gestaoCliente.consultarClientes();
        String nome = "maria";
        gestaoCliente.buscarCliente(nome);
        
    }
}
