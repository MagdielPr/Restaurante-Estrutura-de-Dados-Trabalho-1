package GestaoMesa;

public class NodoMesa {
    Mesa mesa;
    NodoMesa proximo;

    public NodoMesa(Mesa mesa) {
        this.mesa = mesa;
        this.proximo = null;
    }
}
