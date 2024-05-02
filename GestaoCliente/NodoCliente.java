package GestaoCliente;

public class NodoCliente<T> {
    T dados;
    NodoCliente<T> proximo;

    NodoCliente(T dados) {
        this.dados = dados;
        this.proximo = null;
    }
}