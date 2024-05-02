package GestaoCliente;

import GestaoPedidos.Pedido;
import GestaoConta.Caixa;

public class Cliente {
    private String nome;
    private String telefone;
    private String email;
    private Pedido pedidoAtual;

    public Cliente(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Pedido getPedidoAtual() {
        return pedidoAtual;
    }

    public void setPedidoAtual(Pedido pedidoAtual) {
        this.pedidoAtual = pedidoAtual;
    }

    public void receberPedido(Pedido pedido) {
        // Aqui você pode atualizar o estado do pedido do cliente
        // Por exemplo, marcar o pedido como entregue
        pedido.setStatus(Pedido.Status.ENTREGUE);
        System.out.println("Pedido recebido pelo cliente " + nome);
    }

    public double getTotalConta() {
        double contaTotal = 0.0;
        if (pedidoAtual != null) {
            contaTotal = pedidoAtual.getValorTotal();
        }
        return contaTotal;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone + ", Email: " + email;
    }
}
