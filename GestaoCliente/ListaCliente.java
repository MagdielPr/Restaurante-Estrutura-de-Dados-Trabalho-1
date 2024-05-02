package GestaoCliente;


public class ListaCliente<T> {
    private NodoCliente<T> inicio;

    public ListaCliente() {
        this.inicio = null;
    }

    // a. Inserir um novo elemento na lista
    public void inserir(T elemento) {
        NodoCliente<T> novoNo = new NodoCliente<>(elemento);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            NodoCliente<T> ultimo = inicio;
            while (ultimo.proximo != null) {
                ultimo = ultimo.proximo;
            }
            ultimo.proximo = novoNo;
        }
    }

    // b. Remover um elemento da lista
    public T remover(T elemento) {
        if (inicio == null) {
            return null;
        }

        if (inicio.dados.equals(elemento)) {
            NodoCliente<T> removido = inicio;
            inicio = inicio.proximo;
            return removido.dados;
        }

        NodoCliente<T> anterior = null;
        NodoCliente<T> atual = inicio;
        while (atual != null) {
            if (atual.dados.equals(elemento)) {
                anterior.proximo = atual.proximo;
                return atual.dados;
            }
            anterior = atual;
            atual = atual.proximo;
        }

        return null;
    }

    // c. Buscar um elemento na lista
    public T buscar(String nome) {
        NodoCliente<T> atual = inicio;
        while (atual != null) {
            if (atual.dados instanceof Cliente) {
                Cliente cliente = (Cliente) atual.dados;
                if (cliente.getNome().equals(nome)) {
                    return atual.dados;
                }
            }
            atual = atual.proximo;
        }
        return null;
    }

    // d. Exibir todos os elementos da lista
    public void exibir() {
        NodoCliente<T> atual = inicio;
        while (atual != null) {
            System.out.println(atual.dados);
            atual = atual.proximo;
        }
    }
}