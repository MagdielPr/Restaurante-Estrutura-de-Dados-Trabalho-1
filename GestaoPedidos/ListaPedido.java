package GestaoPedidos;

public class ListaPedido<T> implements Iterable<T> {
    private NodoPedido<T> inicio;

    public ListaPedido() {
        this.inicio = null;
    }

    // Inserir um novo elemento na lista
    public void inserir(T elemento) {
        NodoPedido<T> novoNo = new NodoPedido<>(elemento);
        if (inicio == null) {
            inicio = novoNo;
        } else {
        	NodoPedido<T> ultimo = inicio;
            while (ultimo.proximo != null) {
                ultimo = ultimo.proximo;
            }
            ultimo.proximo = novoNo;
        }
    }

    // Remover um elemento da lista
    public T remover() {
        if (inicio == null) {
            return null;
        }

        T removido = inicio.dados;
        inicio = inicio.proximo;
        return removido;
    }
    
 // Método para remover o próximo cliente da fila de pedidos
    public T removerProximoCliente() {
        return remover();
    }

    // Buscar um elemento na lista
    public T buscar(int index) {
    	NodoPedido<T> atual = inicio;
        int i = 0;
        while (atual != null) {
            if (i == index) {
                return atual.dados;
            }
            atual = atual.proximo;
            i++;
        }
        return null;
    }

    // Exibir todos os elementos da lista
    public void exibir() {
    	NodoPedido<T> atual = inicio;
        if (estaVazia()) {
            System.out.println("A lista de pedidos está vazia.");
        } else {
            while (atual != null) {
                System.out.println(atual.dados);
                atual = atual.proximo;
            }
        }
    }

    // Verificar se a lista está vazia
    public boolean estaVazia() {
        return inicio == null;
    }

    // Método para obter o próximo pedido da lista
    public T obterProximoPedido() {
        return inicio != null ? inicio.dados : null;
    }

    // Implementar o Iterable para permitir o uso do for-each
    public java.util.Iterator<T> iterator() {
        return new ListaIterator();
    }

    private class ListaIterator implements java.util.Iterator<T> {
        private NodoPedido<T> atual = inicio;

        public boolean hasNext() {
            return atual != null;
        }

        public T next() {
            T dado = atual.dados;
            atual = atual.proximo;
            return dado;
        }
    }
}
