package GestaoMesa;

import GestaoCliente.Cliente;

public class Mesa {
    private int id;
    private int capacidade;
    private boolean estado;
    private Cliente cliente;
    
    //construtorrrr
    public Mesa() {
        this.id = 0; // ou qualquer outro valor padrão
        this.capacidade = 0; // ou qualquer outro valor padrão
        this.estado = false;
        this.cliente = null;
    }
    
    public Mesa(int id, int capacidade) {
        this.id = id;
        this.capacidade = capacidade;
        this.estado = false;
        this.cliente = null;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean isOcupada() {
        return estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void alocarCliente(Cliente cliente) {
        this.cliente = cliente;
        this.estado = true;
    }

    public void liberarMesa() {
        this.cliente = null;
        this.estado = false;
    }

	public boolean estaLivre(boolean estado) {
		return this.estado = estado;
	}
}