package GestaoPedidos;

import java.util.Scanner;

import GestaoCliente.Cliente;
import GestaoFuncionarios.GestaoFuncionario;
import GestaoFuncionarios.Funcionario;
import GestaoMesa.GestaoMesa;
import GestaoMesa.Mesa;
import GestaoConta.Caixa;

public class GestaoPedido {
    private ListaPedido<Pedido> pedidos;
    private int proximoId;
    private GestaoMesa gestaoMesa;
    private GestaoFuncionario gestaoFuncionarios;
    private Caixa caixa; // Adicionando uma instância de Caixa como membro da classe

    public GestaoPedido(GestaoMesa gestaoMesa, GestaoFuncionario gestaoFuncionarios, Caixa caixa) {
        this.pedidos = new ListaPedido<>();
        this.proximoId = 1;
        this.gestaoMesa = gestaoMesa;
        this.gestaoFuncionarios = gestaoFuncionarios;
        this.caixa = caixa; // Inicializando a instância de Caixa no construtor
    }
    
    public void encaminharClienteParaMesa() {
        // Verifica se há pedidos na lista
        if (!pedidos.estaVazia()) {
            // Procura por uma mesa disponível
            Mesa mesa = gestaoMesa.buscarMesaLivre(4); // Assumindo capacidade padrão de 4
            if (mesa != null) {
                // Remover o próximo pedido da lista
                Pedido pedido = pedidos.remover();
                if (pedido != null) {
                    // Obter o cliente associado ao pedido
                    Cliente cliente = pedido.getCliente();
                    // Encaminha o cliente para a mesa
                    mesa.alocarCliente(cliente);
                    System.out.println("Cliente " + cliente.getNome() + " encaminhado para a mesa " + mesa.getId());
                } else {
                    System.out.println("Erro ao obter o próximo pedido.");
                }
            } else {
                // Não há mesas disponíveis, cliente fica na fila
                System.out.println("Não há mesas disponíveis no momento. Cliente ficará na fila.");
            }
        } else {
            // Não há pedidos na lista
            System.out.println("Não há pedidos para encaminhar para mesa.");
        }
    }

    
    public void atenderPedido() {
        // Verifica se há pedidos a serem atendidos
        Pedido pedido = pedidos.obterProximoPedido(); // Usando 'pedidos' em vez de 'listaPedidos'
        if (pedido != null) {
            // Chama o garçom para atender o pedido
            Funcionario garcom = gestaoFuncionarios.obterGarcomDisponivel();
            if (garcom != null) {
                System.out.println("Garçom " + garcom.getNome() + " atendendo pedido do cliente " + pedido.getCliente().getNome());
                // Envia o pedido para a cozinha
                enviarPedidoCozinha(pedido);
            } else {
                System.out.println("Não há garçons disponíveis no momento. Pedido ficará pendente.");
            }
        } else {
            System.out.println("Não há pedidos pendentes no momento.");
        }
    }


    private void enviarPedidoCozinha(Pedido pedido) {
        // Chama o cozinheiro para preparar o pedido
        Funcionario cozinheiro = gestaoFuncionarios.obterCozinheiroDisponivel();
        if (cozinheiro != null) {
            System.out.println("Cozinheiro " + cozinheiro.getNome() + " preparando o pedido do cliente " + pedido.getCliente().getNome());
            // Simula a preparação do pedido
            // ...
            // Entrega o pedido pronto ao garçom
            entregarPedidoCliente(pedido);
        } else {
            System.out.println("Não há cozinheiros disponíveis no momento. Pedido ficará pendente.");
        }
    }

    private void entregarPedidoCliente(Pedido pedido) {
        // Chama o garçom para entregar o pedido ao cliente
        Funcionario garcom = gestaoFuncionarios.obterGarcomDisponivel();
        if (garcom != null) {
            System.out.println("Garçom " + garcom.getNome() + " entregando o pedido ao cliente " + pedido.getCliente().getNome());
            // Entrega o pedido ao cliente
            pedido.getCliente().receberPedido(pedido);
        } else {
            System.out.println("Não há garçons disponíveis no momento. Pedido ficará pendente.");
        }
    }

    public void fecharConta(Cliente cliente) {
        // Verifica se o cliente tem uma conta total e um pagamento
        double contaTotal = cliente.getTotalConta();
        String pagamento = caixa.getPagamento(); // Obtendo os detalhes do pagamento como uma String
        
        // Verificando se o pagamento não é uma mensagem de erro
        if (!pagamento.equals("Não há histórico de pagamentos para este cliente.")) {
            // Convertendo a String de pagamento para double
            double valorPago = caixa.getContaTotal();

            // Registrando o pagamento no caixa
            caixa.registrarPagamento(contaTotal, valorPago);
            caixa.emitirRecibo();
        } else {
            System.out.println("Não foi possível fechar a conta. Não há histórico de pagamentos para este cliente.");
        }
        
        // Obtém a mesa do cliente
        Mesa mesa = gestaoMesa.obterMesaDoCliente(cliente);
        
        // Verifica se a mesa não é nula antes de liberá-la
        if (mesa != null) {
            mesa.liberarMesa();
        } else {
            System.out.println("Não foi possível encontrar a mesa associada ao cliente para liberar.");
        }
    }

    
 // a. Registro de novos pedidos
    public Pedido registrarPedido(Cliente cliente) {
        Scanner scanner = new Scanner(System.in); // Instanciar um objeto Scanner para entrada de dados
        System.out.println("Digite os itens do pedido (digite 'fim' para encerrar):");
        Pedido novoPedido = new Pedido(proximoId++, cliente);
        String nomeItem;
        do {
            System.out.print("Item: ");
            nomeItem = scanner.nextLine();
            if (!nomeItem.equalsIgnoreCase("fim")) {
                System.out.print("Quantidade: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha
                Item item = new Item(nomeItem, quantidade);
                novoPedido.getItens().inserir(item);
            }
        } while (!nomeItem.equalsIgnoreCase("fim"));
        pedidos.inserir(novoPedido);
        System.out.println("Pedido registrado: " + novoPedido.getId());
        return novoPedido;
    }

    // b. Alteração de pedidos
    public void alterarPedido(int idPedido, Item... novoItens) {
        Pedido pedido = buscarPedido(idPedido);
        if (pedido != null) {
            pedido.getItens().remover();
            for (Item item : novoItens) {
                pedido.getItens().inserir(item);
            }
            System.out.println("Pedido alterado: " + pedido.getId());
        } else {
            System.out.println("Pedido não encontrado: " + idPedido);
        }
    }

    // c. Cancelamento de pedidos
    public void cancelarPedido(int idPedido) {
        Pedido pedido = buscarPedido(idPedido);
        if (pedido != null) {
            pedido.setStatus(Pedido.Status.CANCELADO);
            System.out.println("Pedido cancelado: " + pedido.getId());
        } else {
            System.out.println("Pedido não encontrado: " + idPedido);
        }
    }
 // d. Consulta de pedidos realizados
    public void consultarPedidos() {
        System.out.println("Pedidos realizados:");
        if (pedidos.estaVazia()) {
            System.out.println("Não há pedidos realizados.");
        } else {
            pedidos.exibir();
        }
    }
    
 // Método para buscar um pedido pelo seu ID
    public Pedido buscarPedido(int idPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == idPedido) {
                return pedido;
            }
        }
        return null;
    }
    public Pedido removerProximoCliente() {
        return pedidos.remover();
    }
}