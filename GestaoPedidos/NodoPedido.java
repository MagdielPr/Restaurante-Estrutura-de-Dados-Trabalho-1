package GestaoPedidos;

public class NodoPedido<T> {
    T dados;
    NodoPedido<T> proximo;

    NodoPedido(T dados) {
        this.dados = dados;
        this.proximo = null;
    }
}