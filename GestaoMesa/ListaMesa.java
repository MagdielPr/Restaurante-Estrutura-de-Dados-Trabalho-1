package GestaoMesa;

public class ListaMesa<T> {
    private NodoMesa primeiro;
    private int tamanho;

    public ListaMesa() {
        this.primeiro = null;
        this.tamanho = 0;
    }

    public void inserir(Mesa mesa) {
        NodoMesa novoNodo = new NodoMesa(mesa);
        if (primeiro == null) {
            primeiro = novoNodo;
        } else {
            NodoMesa  atual = primeiro;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNodo;
        }
        tamanho++;
    }

    public int getTamanho() {
        return tamanho;
    }

    public Mesa obterMesa(int indice) {
        if (indice >= tamanho || indice < 0) {
            return null;
        }
        NodoMesa  atual = primeiro;
        for (int i = 0; i < indice; i++) {
            atual = atual.proximo;
        }
        return atual.mesa;
    }
}
