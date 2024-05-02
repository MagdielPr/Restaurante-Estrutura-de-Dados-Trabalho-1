package GestaoMesa;

import GestaoCliente.Cliente;
import GestaoMesa.GestaoMesa;

public class TesteMesa {
    public static void main(String[] args) {
        GestaoMesa gestaoMesa = new GestaoMesa();

        // Adicionar mesas
        gestaoMesa.adicionarMesa(1, 4);
        gestaoMesa.adicionarMesa(2, 2);
        gestaoMesa.adicionarMesa(3, 6);

        // Criar clientes
        Cliente cliente1 = new Cliente("João Silva", "11999999999", "joao@email.com");
        Cliente cliente2 = new Cliente("Maria Santos", "22888888888", "maria@email.com");
        Cliente cliente3 = new Cliente("Pedro Souza", "33777777777", "pedro@email.com");

        // Alocar clientes em mesas
        gestaoMesa.alocarMesa(cliente1, 2);
        gestaoMesa.alocarMesa(cliente2, 4);
        gestaoMesa.alocarMesa(cliente3, 6);

        // Consultar mesas
        System.out.println("\nMesas ocupadas e disponíveis:");
        gestaoMesa.consultarMesas();

        // Liberar mesa
        gestaoMesa.liberarMesa(2);

        // Consultar mesas novamente
        System.out.println("\nMesas ocupadas e disponíveis após liberação:");
        gestaoMesa.consultarMesas();
    }
}