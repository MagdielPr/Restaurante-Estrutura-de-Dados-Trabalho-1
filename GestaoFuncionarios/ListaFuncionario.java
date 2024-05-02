package GestaoFuncionarios;

import java.util.Iterator;

public class ListaFuncionario<T> implements Iterable<T> {
    private NodoFuncionario<T> primeiro;
    private int tamanho;

    public ListaFuncionario() {
        this.primeiro = null;
        this.tamanho = 0;
    }

    public void inserir(T elemento) {
        NodoFuncionario<T> novoNo = new NodoFuncionario<>(elemento);
        if (primeiro == null) {
            primeiro = novoNo;
        } else {
            NodoFuncionario<T> atual = primeiro;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNo);
        }
        tamanho++;
    }

    public void remover(T elemento) {
        if (primeiro == null) {
            return;
        }
        if (primeiro.getDado().equals(elemento)) {
            primeiro = primeiro.getProximo();
            tamanho--;
            return;
        }
        NodoFuncionario<T> atual = primeiro;
        while (atual.getProximo() != null) {
            if (atual.getProximo().getDado().equals(elemento)) {
                atual.setProximo(atual.getProximo().getProximo());
                tamanho--;
                return;
            }
            atual = atual.getProximo();
        }
    }

    public T getElemento(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista");
        }
        NodoFuncionario<T> atual = primeiro;
        for (int i = 0; i < indice; i++) {
            atual = atual.getProximo();
        }
        return atual.getDado();
    }

    public int getTamanho() {
        return tamanho;
    }

    public void mostrar() {
        NodoFuncionario<T> atual = primeiro;
        while (atual != null) {
            System.out.println(atual.getDado().toString());
            atual = atual.getProximo();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListaFuncionarioIterator<>(primeiro);
    }
    
    private class ListaFuncionarioIterator<T> implements Iterator<T> {
        private NodoFuncionario<T> atual;

        public ListaFuncionarioIterator(NodoFuncionario<T> primeiro) {
            this.atual = primeiro;
        }

        @Override
        public boolean hasNext() {
            return atual != null;
        }

        @Override
        public T next() {
            T dado = atual.getDado();
            atual = atual.getProximo();
            return dado;
        }
    }
}
