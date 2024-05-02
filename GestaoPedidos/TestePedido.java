package GestaoPedidos;

import GestaoCliente.Cliente;
import GestaoConta.Caixa;
import GestaoFuncionarios.GestaoFuncionario;
import GestaoMesa.GestaoMesa;

public class TestePedido {
    public static void main(String[] args) {
        GestaoMesa gestaoMesa = new GestaoMesa();
        GestaoFuncionario gestaoFuncionario = new GestaoFuncionario();
        Caixa caixa = new Caixa(); // Instanciando um objeto Caixa

        // Criar uma instância de GestaoPedido com os três parâmetros
        GestaoPedido gestaoPedido = new GestaoPedido(gestaoMesa, gestaoFuncionario, caixa);

        // Criar clientes
        Cliente cliente1 = new Cliente("João Silva", "11999999999", "joao@email.com");
        Cliente cliente2 = new Cliente("Maria Santos", "22888888888", "maria@email.com");
        Cliente cliente3 = new Cliente("Pedro Souza", "33777777777", "pedro@email.com");

        // Adicionar algumas mesas
        gestaoMesa.adicionarMesa(1, 4);
        gestaoMesa.adicionarMesa(2, 2);
        gestaoMesa.adicionarMesa(3, 6);

        // Encaminhar clientes para as mesas
        gestaoPedido.encaminharClienteParaMesa();
        gestaoPedido.encaminharClienteParaMesa();
        gestaoPedido.encaminharClienteParaMesa();

        // Testar atendimento de pedidos
        gestaoPedido.atenderPedido();
        gestaoPedido.atenderPedido();
        gestaoPedido.atenderPedido();

        // Fechar conta de um cliente
        gestaoPedido.fecharConta(cliente1);

        // Consultar pedidos
        gestaoPedido.consultarPedidos();
    }
}
