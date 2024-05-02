package GestaoMesa;

import GestaoCliente.Cliente;

public class GestaoMesa {
    private ListaMesa listaMesas;
    private int numeroClientesAtendidos; // Contador para o número de clientes atendidos

    
    public GestaoMesa() {
        this.listaMesas = new ListaMesa<>();
        this.numeroClientesAtendidos = 0;
    }
    
    // Método para obter o número total de clientes atendidos
    public int getNumeroClientesAtendidos() {
        return numeroClientesAtendidos;
    }
    
 // Método para incrementar o número de clientes atendidos
    public void incrementarNumeroClientesAtendidos() {
        numeroClientesAtendidos++;
    }
    public int getNumeroMesasLivres() {
        int mesasLivres = 0;
        for (int i = 0; i < listaMesas.getTamanho(); i++) {
            Mesa mesa = listaMesas.obterMesa(i);
            if (mesa.estaLivre(true)) {
                mesasLivres++;
            }
        }
        return mesasLivres;
    }

    public int getNumeroClientesAlmocando() {
        int clientesAlmocando = 0;
        for (int i = 0; i < listaMesas.getTamanho(); i++) {
            Mesa mesa = listaMesas.obterMesa(i);
            if (!mesa.estaLivre(false)) {
                clientesAlmocando++;
            }
        }
        return clientesAlmocando;
    }

    public void adicionarMesa(int id, int capacidade) {
        Mesa novaMesa = new Mesa(id, capacidade);
        listaMesas.inserir(novaMesa);
        System.out.println("Nova mesa adicionada: " + id + " - Capacidade: " + capacidade);
    }

    public void alocarMesa(Cliente cliente, int idMesa) {
        Mesa mesa = buscarMesa(idMesa);
        if (mesa != null && !mesa.isOcupada()) {
            mesa.alocarCliente(cliente);
            System.out.println("Cliente " + cliente.getNome() + " alocado na mesa " + mesa.getId());
        } else {
            System.out.println("Não foi possível alocar o cliente " + cliente.getNome() + " na mesa " + idMesa);
        }
    }

    public void liberarMesa(int idMesa) {
        Mesa mesa = buscarMesa(idMesa);
        if (mesa != null && mesa.isOcupada()) {
            Cliente cliente = mesa.getCliente();
            mesa.liberarMesa();
            System.out.println("Mesa " + mesa.getId() + " liberada. Cliente " + cliente.getNome() + " saiu.");
        } else {
            System.out.println("Mesa " + idMesa + " não encontrada ou já estava livre.");
        }
    }

    public void consultarMesas() {
        System.out.println("Mesas ocupadas:");
        for (int i = 0; i < listaMesas.getTamanho(); i++) {
            Mesa mesa = listaMesas.obterMesa(i);
            if (mesa.isOcupada()) {
                System.out.println("Mesa " + mesa.getId() + " - Cliente: " + mesa.getCliente().getNome());
            }
        }

        System.out.println("Mesas disponíveis:");
        for (int i = 0; i < listaMesas.getTamanho(); i++) {
            Mesa mesa = listaMesas.obterMesa(i);
            if (!mesa.isOcupada()) {
                System.out.println("Mesa " + mesa.getId() + " - Capacidade: " + mesa.getCapacidade());
            }
        }
    }

    private Mesa buscarMesa(int idMesa) {
        for (int i = 0; i < listaMesas.getTamanho(); i++) {
            Mesa mesa = listaMesas.obterMesa(i);
            if (mesa.getId() == idMesa) {
                return mesa;
            }
        }
        return null;
    }

    public Mesa buscarMesaLivre(int capacidade) {
        for (int i = 0; i < listaMesas.getTamanho(); i++) {
            Mesa mesa = listaMesas.obterMesa(i);
            if (!mesa.isOcupada() && mesa.getCapacidade() >= capacidade) {
                return mesa;
            }
        }
        return null;
    }
    
    public Mesa obterMesaDoCliente(Cliente cliente) {
        for (int i = 0; i < listaMesas.getTamanho(); i++) {
            Mesa mesa = listaMesas.obterMesa(i);
            if (!mesa.estaLivre(false) && mesa.getCliente() != null && mesa.getCliente().equals(cliente)) {
                return mesa;
            }
        }
        return null;
    }


}
