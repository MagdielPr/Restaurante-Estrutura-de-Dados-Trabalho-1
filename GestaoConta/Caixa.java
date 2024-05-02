package GestaoConta;

import java.util.LinkedList;
import java.util.Queue;

public class Caixa {
    private Queue<Pagamento> historicoPagamentos;

    public Caixa() {
        this.historicoPagamentos = new LinkedList<>();
    }

    public void registrarPagamento(double valorPedido, double valorPago) {
        double troco = valorPago - valorPedido;
        String comprovante = gerarComprovante(valorPedido, valorPago, troco);
        Pagamento pagamento = new Pagamento(valorPago, troco, comprovante);
        historicoPagamentos.offer(pagamento);
        System.out.println("Pagamento registrado com sucesso!");
    }

    public void emitirRecibo() {
        Pagamento pagamento = historicoPagamentos.poll();
        if (pagamento != null) {
            System.out.println("Comprovante de Pagamento:");
            System.out.println(pagamento.getComprovante());
        } else {
            System.out.println("Não há pagamentos registrados no caixa.");
        }
    }

    public void consultarHistoricoPagamentos() {
        System.out.println("Histórico de Pagamentos:");
        for (Pagamento pagamento : historicoPagamentos) {
            System.out.println(pagamento.getComprovante());
        }
    }

    public double getContaTotal() {
        double total = 0.0;
        for (Pagamento pagamento : historicoPagamentos) {
            total += pagamento.getValorPago();
        }
        return total;
    }

    public String getPagamento() {
        StringBuilder detalhes = new StringBuilder();
        detalhes.append("Detalhes dos Pagamentos:\n");
        for (Pagamento pagamento : historicoPagamentos) {
            detalhes.append(pagamento.getComprovante()).append("\n");
        }
        return detalhes.toString();
    }

    private String gerarComprovante(double valorPedido, double valorPago, double troco) {
        return "Valor do Pedido: R$ " + valorPedido +
                "\nValor Pago: R$ " + valorPago +
                "\nTroco: R$ " + troco +
                "\n--------------------";
    }
}
