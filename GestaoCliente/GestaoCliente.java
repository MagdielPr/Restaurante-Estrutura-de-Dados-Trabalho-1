package GestaoCliente;

import java.util.LinkedList;
import java.util.Queue;

import GestaoMesa.GestaoMesa;

public class GestaoCliente {
    private ListaCliente<Cliente> listaClientes;
    private GestaoMesa gestaoMesa;
    private Queue<Cliente> filaDoCaixa; // Fila de clientes no caixa
    
    public GestaoCliente(GestaoMesa gestaoMesa) {
        this.listaClientes = new ListaCliente<>();
        this.gestaoMesa = gestaoMesa;
        this.filaDoCaixa = new LinkedList<>(); // Inicializa a fila do caixa
    }
    
    public int getNumeroClientesNaFila() {
        return filaDoCaixa.size(); // Retorna o tamanho da fila do caixa
    }

    // Adiciona um cliente à fila do caixa
    public void adicionarClienteNaFilaDoCaixa(Cliente cliente) {
        filaDoCaixa.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " adicionado à fila do caixa.");
    }

    // Remove o próximo cliente da fila do caixa
    public Cliente removerClienteDaFilaDoCaixa() {
        Cliente clienteRemovido = filaDoCaixa.poll();
        if (clienteRemovido != null) {
            System.out.println("Cliente " + clienteRemovido.getNome() + " removido da fila do caixa.");
        } else {
            System.out.println("Não há clientes na fila do caixa.");
        }
        return clienteRemovido;
    }

    public int getNumeroClientesNoCaixa() {
        // Implementar a lógica para obter o número de clientes na fila do caixa
        return 0;
    }

    public int getNumeroClientesAlmocando() {
        return gestaoMesa.getNumeroClientesAlmocando();
    }

    public int getNumeroClientesAtendidos() {
        // Implementar a lógica para obter o número de clientes atendidos
        return 0;
    }
    
    public GestaoCliente() {
        this.listaClientes = new ListaCliente<>();
    }
    
    public Cliente buscarCliente(String nome) {
        return listaClientes.buscar(nome);
    }

    // a. Cadastro de novos clientes
    public void cadastrarCliente(String nome, String telefone, String email) {
        Cliente novoCliente = new Cliente(nome, telefone, email);
        listaClientes.inserir(novoCliente);
        System.out.println("Cliente cadastrado com sucesso: " + nome);
    }
    
    // Método para cadastrar mais de um cliente por vez
    public void cadastrarClientes(Cliente... clientes) {
        for (Cliente cliente : clientes) {
            listaClientes.inserir(cliente);
            System.out.println("Cliente cadastrado com sucesso: " + cliente.getNome());
        }
    }

    // b. Remoção de clientes
    public void removerCliente(String nome) {
        Cliente cliente = listaClientes.buscar(nome);
        if (cliente != null) {
            listaClientes.remover(cliente);
            System.out.println("Cliente removido: " + cliente.getNome());
        } else {
            System.out.println("Cliente não encontrado: " + nome);
        }
    }

    // c. Atualização de informações dos clientes
    public void atualizarCliente(String nome, String novoNome, String novoTelefone, String novoEmail) {
        Cliente cliente = listaClientes.buscar(nome);
        if (cliente != null) {
            cliente.setNome(novoNome);
            cliente.setTelefone(novoTelefone);
            cliente.setEmail(novoEmail);
            System.out.println("Informações do cliente atualizadas: " + novoNome);
        } else {
            System.out.println("Cliente não encontrado: " + nome);
        }
    }

    // d. Consulta de clientes cadastrados
    public void consultarClientes() {
        System.out.println("Clientes cadastrados:");
        listaClientes.exibir();
    }
    
    // Método para alocar o cliente para a mesa
    public void alocarClienteMesa(Cliente cliente, int idMesa) {
        // Implemente a lógica para alocar o cliente para a mesa com o id informado
        System.out.println("Cliente " + cliente.getNome() + " alocado para a mesa " + idMesa);
    }
}
