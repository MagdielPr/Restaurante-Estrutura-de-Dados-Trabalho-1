package GestaoFuncionarios;

public class GestaoFuncionario {
    private ListaFuncionario<Funcionario> funcionarios;
    private ListaFuncionario<Funcionario> garcons;
    private ListaFuncionario<Funcionario> cozinheiros;
    
    public GestaoFuncionario() {
        this.garcons = new ListaFuncionario<>();
        this.cozinheiros = new ListaFuncionario<>();
        this.funcionarios = new ListaFuncionario<>();
    }

    public void cadastrarFuncionario(String nome, String cargo, String horarioTrabalho) {
        Funcionario funcionario = new Funcionario(nome, cargo, horarioTrabalho);
        if (cargo.equalsIgnoreCase("garcom")) {
            garcons.inserir(funcionario);
        } else if (cargo.equalsIgnoreCase("cozinheiro")) {
            cozinheiros.inserir(funcionario);
        }
        funcionarios.inserir(funcionario); // Adicionando à lista geral de funcionários
        System.out.println("Funcionário " + funcionario.getNome() + " cadastrado com sucesso.");
    }

    public void removerFuncionario(String nome) {
        Funcionario funcionario = buscarFuncionario(nome);
        if (funcionario != null) {
            if (funcionario.getCargo().equalsIgnoreCase("garcom")) {
                garcons.remover(funcionario);
                System.out.println("Garçom " + funcionario.getNome() + " removido com sucesso.");
            } else if (funcionario.getCargo().equalsIgnoreCase("cozinheiro")) {
                cozinheiros.remover(funcionario);
                System.out.println("Cozinheiro " + funcionario.getNome() + " removido com sucesso.");
            }
            funcionarios.remover(funcionario); // Removendo da lista geral de funcionários
        } else {
            System.out.println("Funcionário " + nome + " não encontrado.");
        }
    }
    
    public void exibirGarcons() {
        System.out.println("Garçons cadastrados:");
        garcons.mostrar();
    }

    public void exibirCozinheiros() {
        System.out.println("Cozinheiros cadastrados:");
        cozinheiros.mostrar();
    }

    public Funcionario obterGarcomDisponivel() {
        for (Funcionario garcom : garcons) {
            if (garcom.isDisponivel()) {
                return garcom;
            }
        }
        return null;
    }

    public Funcionario obterCozinheiroDisponivel() {
        for (Funcionario cozinheiro : cozinheiros) {
            if (cozinheiro.isDisponivel()) {
                return cozinheiro;
            }
        }
        return null;
    }

    private Funcionario buscarFuncionario(String nome) {
        for (Funcionario garcom : garcons) {
            if (garcom.getNome().equalsIgnoreCase(nome)) {
                return garcom;
            }
        }
        for (Funcionario cozinheiro : cozinheiros) {
            if (cozinheiro.getNome().equalsIgnoreCase(nome)) {
                return cozinheiro;
            }
        }
        return null;
    }

    public void exibirFuncionarios() {
        System.out.println("Funcionários cadastrados:");
        funcionarios.mostrar();
    }

    public void exibirEscalaTrabalho() {
        System.out.println("Escala de trabalho:");
        for (int i = 0; i < funcionarios.getTamanho(); i++) {
            Funcionario funcionario = funcionarios.getElemento(i);
            System.out.println(funcionario.toString());
        }
    }

}
