package GestaoConta;

public class TesteConta {
    public static void main(String[] args) {
        Caixa caixa = new Caixa();

        // Registrar pagamentos
        caixa.registrarPagamento(50.0, 60.0);
        caixa.registrarPagamento(30.0, 40.0);
        caixa.registrarPagamento(25.0, 30.0);

        // Consultar histórico de pagamentos
        caixa.consultarHistoricoPagamentos();

        // Emitir recibo
        System.out.println("\nEmitindo recibo:");
        caixa.emitirRecibo();

        // Consultar total da conta
        double totalConta = caixa.getContaTotal();
        System.out.println("\nTotal da conta: R$ " + totalConta);

        // Consultar detalhes dos pagamentos
        String detalhesPagamentos = caixa.getPagamento();
        System.out.println("\nDetalhes dos pagamentos:\n" + detalhesPagamentos);
    }
}
