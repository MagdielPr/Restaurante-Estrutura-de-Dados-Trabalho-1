package GestaoPedidos;

import GestaoCliente.Cliente;
import java.util.Date;

public class Pedido {
    private int id;
    private Cliente cliente;
    private ListaPedido<Item> itens;
    private Date dataHora;
    private Status status;

    public enum Status {
        NOVO, EM_PREPARACAO, PRONTO, ENTREGUE, CANCELADO
    }

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.itens = new ListaPedido<>();
        this.dataHora = new Date();
        this.status = Status.NOVO;
    }
    public double getValorTotal() {
        double total = 0.0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ListaPedido<Item> getItens() {
        return itens;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
