package GestaoFuncionarios;

public class NodoFuncionario<T> {
    private T dado;
    private NodoFuncionario<T> proximo;

    public NodoFuncionario(T dado) {
        this.dado = dado;
        this.proximo = null;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public NodoFuncionario<T> getProximo() {
        return proximo;
    }

    public void setProximo(NodoFuncionario<T> proximo) {
        this.proximo = proximo;
    }
}