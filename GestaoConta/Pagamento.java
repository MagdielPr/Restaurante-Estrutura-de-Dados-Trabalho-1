package GestaoConta;

public class Pagamento {
    private double valorPago;
    private double troco;
    private String comprovante;

    public Pagamento(double valorPago, double troco, String comprovante) {
        this.valorPago = valorPago;
        this.troco = troco;
        this.comprovante = comprovante;
    }

    public double getValorPago() {
        return valorPago;
    }

    public double getTroco() {
        return troco;
    }

    public String getComprovante() {
        return comprovante;
    }
}