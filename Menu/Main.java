package Menu;
import java.util.Scanner;

import GestaoCliente.Cliente;
import GestaoCliente.GestaoCliente;
import GestaoConta.Caixa;
import GestaoFuncionarios.GestaoFuncionario;
import GestaoMesa.GestaoMesa;
import GestaoPedidos.GestaoPedido;
import GestaoPedidos.Pedido;

import java.util.Scanner;

public class Main {
    private Scanner scanner;
    private GestaoCliente gestaoCliente;
    private GestaoPedido gestaoPedido;
    private GestaoMesa gestaoMesa;
    private GestaoFuncionario gestaoFuncionario;
    private Caixa caixa;
    private Pedido pedido;

    public Main() {
        this.scanner = new Scanner(System.in);
        this.gestaoMesa = new GestaoMesa();
        this.gestaoFuncionario = new GestaoFuncionario();
        this.caixa = new Caixa();
        this.gestaoCliente = new GestaoCliente(gestaoMesa);
        this.gestaoPedido = new GestaoPedido(gestaoMesa, gestaoFuncionario, caixa);
    }

    public void exibirMenuClientes() {
        int opcao;
        do {
            System.out.println("\n=== Menu Gestão de Clientes ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Remover Cliente");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Consultar Clientes");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarNovoCliente();
                    break;
                case 2:
                    removerCliente();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    consultarClientes();
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != 5);
    }

    private void cadastrarNovoCliente() {
        scanner.nextLine(); // Limpa o buffer do scanner
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.print("E-mail do cliente: ");
        String email = scanner.nextLine();

        gestaoCliente.cadastrarCliente(nome, telefone, email);
    }

    private void removerCliente() {
        scanner.nextLine(); // Limpa o buffer do scanner
        System.out.print("Nome do cliente a ser removido: ");
        String nome = scanner.nextLine();
        gestaoCliente.removerCliente(nome);
    }

    private void atualizarCliente() {
        scanner.nextLine(); // Limpa o buffer do scanner
        System.out.print("Nome do cliente a ser atualizado: ");
        String nome = scanner.nextLine();
        System.out.print("Novo nome do cliente: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo telefone do cliente: ");
        String novoTelefone = scanner.nextLine();
        System.out.print("Novo e-mail do cliente: ");
        String novoEmail = scanner.nextLine();

        gestaoCliente.atualizarCliente(nome, novoNome, novoTelefone, novoEmail);
    }

    private void consultarClientes() {
        gestaoCliente.consultarClientes();
    }

    private void exibirMenuPedidos() {
        int opcao;
        do {
            System.out.println("\n=== Menu Gestão de Pedidos ===");
            System.out.println("1. Registrar Novo Pedido");
            System.out.println("2. Alterar Pedido");
            System.out.println("3. Cancelar Pedido");
            System.out.println("4. Consultar Pedidos");
            System.out.println("5. Encaminhar Cliente para Mesa");
            System.out.println("6. Atender Pedido");
            System.out.println("7. Fechar Conta");
            System.out.println("8. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    registrarNovoPedido();
                    break;
                case 2:
                    alterarPedido();
                    break;
                case 3:
                    cancelarPedido();
                    break;
                case 4:
                    consultarPedidos();
                    break;
                case 5:
                    encaminharClienteParaMesa();
                    break;
                case 6:
                    atenderPedido();
                    break;
                case 7:
                    fecharConta();
                    break;
                case 8:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != 8);
    }

    private void registrarNovoPedido() {
        scanner.nextLine(); // Limpa o buffer do scanner
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = gestaoCliente.buscarCliente(nomeCliente);
        if (cliente != null) {
            // Lógica para registrar um novo pedido
            System.out.println("Informe os itens do pedido:");
            // Aqui você pode adicionar a lógica para criar um novo pedido
        } else {
            System.out.println("Cliente não encontrado. Não é possível registrar o pedido.");
        }
    }

    private void alterarPedido() {
        scanner.nextLine(); // Limpa o buffer do scanner
        System.out.print("ID do pedido a ser alterado: ");
        int idPedido = scanner.nextInt();
        Pedido pedido = gestaoPedido.buscarPedido(idPedido);
        if (pedido != null) {
            // Lógica para alterar um pedido existente
            System.out.println("Informe os novos itens do pedido:");
            // Aqui você pode adicionar a lógica para alterar os itens do pedido
        } else {
            System.out.println("Pedido não encontrado. Não é possível alterar o pedido.");
        }
    }

    private void cancelarPedido() {
        scanner.nextLine(); // Limpa o buffer do scanner
        System.out.print("ID do pedido a ser cancelado: ");
        int idPedido = scanner.nextInt();
        gestaoPedido.cancelarPedido(idPedido);
    }

    private void fecharConta() {
        scanner.nextLine(); // Limpa o buffer do scanner
        System.out.print("Nome do cliente para fechar a conta: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = gestaoCliente.buscarCliente(nomeCliente);
        if (cliente != null) {
            gestaoPedido.fecharConta(cliente);
        } else {
            System.out.println("Cliente não encontrado. Não é possível fechar a conta.");
        }
    }


    private void consultarPedidos() {
        gestaoPedido.consultarPedidos();
    }

    private void encaminharClienteParaMesa() {
        gestaoPedido.encaminharClienteParaMesa();
    }

    private void atenderPedido() {
        gestaoPedido.atenderPedido();
    }
    private void exibirMenuFuncionarios() {
        int opcao;
        do {
            System.out.println("\n=== Menu Gestão de Funcionários ===");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Remover Funcionário");
            System.out.println("3. Exibir Garçons");
            System.out.println("4. Exibir Cozinheiros");
            System.out.println("5. Exibir Todos os Funcionários");
            System.out.println("6. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarNovoFuncionario();
                    break;
                case 2:
                    removerFuncionario();
                    break;
                case 3:
                    exibirGarcons();
                    break;
                case 4:
                    exibirCozinheiros();
                    break;
                case 5:
                    exibirTodosFuncionarios();
                    break;
                case 6:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != 6);
    }

    private void cadastrarNovoFuncionario() {
        scanner.nextLine(); // Limpa o buffer do scanner
        System.out.print("Nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Cargo do funcionário (garçom ou cozinheiro): ");
        String cargo = scanner.nextLine();
        System.out.print("Horário de trabalho do funcionário: ");
        String horarioTrabalho = scanner.nextLine();

        gestaoFuncionario.cadastrarFuncionario(nome, cargo, horarioTrabalho);
    }

    private void removerFuncionario() {
        scanner.nextLine(); // Limpa o buffer do scanner
        System.out.print("Nome do funcionário a ser removido: ");
        String nome = scanner.nextLine();
        gestaoFuncionario.removerFuncionario(nome);
    }

    private void exibirGarcons() {
        gestaoFuncionario.exibirGarcons();
    }

    private void exibirCozinheiros() {
        gestaoFuncionario.exibirCozinheiros();
    }

    private void exibirTodosFuncionarios() {
        gestaoFuncionario.exibirFuncionarios();
    }
    private void exibirMenuMesas() {
        int opcao;
        do {
            System.out.println("\n=== Menu Gestão de Mesas ===");
            System.out.println("1. Adicionar Mesa");
            System.out.println("2. Alocar Cliente a uma Mesa");
            System.out.println("3. Liberar Mesa");
            System.out.println("4. Consultar Mesas");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarMesa();
                    break;
                case 2:
                    alocarClienteMesa();
                    break;
                case 3:
                    liberarMesa();
                    break;
                case 4:
                    consultarMesas();
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != 5);
    }

    private void adicionarMesa() {
        System.out.print("Informe o ID da mesa: ");
        int id = scanner.nextInt();
        System.out.print("Informe a capacidade da mesa: ");
        int capacidade = scanner.nextInt();
        gestaoMesa.adicionarMesa(id, capacidade);
    }

    private void alocarClienteMesa() {
        scanner.nextLine(); // Limpa o buffer do scanner
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = gestaoCliente.buscarCliente(nomeCliente);
        if (cliente != null) {
            System.out.print("Informe a capacidade necessária: ");
            int capacidade = scanner.nextInt();
            gestaoMesa.alocarMesa(cliente, capacidade);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void liberarMesa() {
        System.out.print("Informe o ID da mesa a ser liberada: ");
        int idMesa = scanner.nextInt();
        gestaoMesa.liberarMesa(idMesa);
    }

    private void consultarMesas() {
        gestaoMesa.consultarMesas();
    }


    public void consultarCaixa() {
        int opcao;
        do {
            System.out.println("\n=== Consultar Caixa ===");
            System.out.println("1. Emitir Recibo");
            System.out.println("2. Consultar Histórico de Pagamentos");
            System.out.println("3. Consultar Total do Caixa");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    caixa.emitirRecibo();
                    break;
                case 2:
                    caixa.consultarHistoricoPagamentos();
                    break;
                case 3:
                    double total = caixa.getContaTotal();
                    System.out.println("Total do Caixa: R$ " + total);
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != 4);
    }    


    private void emitirRecibo() {
        caixa.emitirRecibo();
    }

    private void consultarHistoricoPagamentos() {
        caixa.consultarHistoricoPagamentos();
    }

    private void consultarTotalCaixa() {
        double total = caixa.getContaTotal();
        System.out.println("Total do Caixa: R$ " + total);
    }

    
    public void conecta() {
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
    
    public void conectarEExecutarOperacoesIniciais() {
        conecta();
        clearConsole();
        System.out.println("Operações iniciais executadas com sucesso!");
    }
    
    private void clearConsole() {
        // Limpa o console
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            // Tratamento de exceção
            System.out.println("Erro ao limpar o console: " + e.getMessage());
        }
    }
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Gestão de Clientes");
            System.out.println("2. Gestão de Funcionários");
            System.out.println("3. Gestão de Pedidos");
            System.out.println("4. Gestão de Mesas");
            System.out.println("5. Consultar Caixa");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    exibirMenuClientes();
                    break;
                case 2:
                    exibirMenuFuncionarios();
                    break;
                case 3:
                    exibirMenuPedidos();
                    break;
                case 4:
                    exibirMenuMesas();
                    break;
                case 5:
                    consultarCaixa();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != 6);
    }
    
    public static void main(String[] args) {
        Main restaurante = new Main();
        restaurante.exibirMenu();
    }
}
