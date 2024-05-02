package GestaoFuncionarios;

import GestaoFuncionarios.Funcionario;
import GestaoFuncionarios.GestaoFuncionario;

public class TesteFuncionario {
    public static void main(String[] args) {
        GestaoFuncionario gestaoFuncionarios = new GestaoFuncionario();

        // Cadastrar funcionários
        gestaoFuncionarios.cadastrarFuncionario("João Silva", "Garçom", "08:00 - 16:00");
        gestaoFuncionarios.cadastrarFuncionario("Maria Santos", "Cozinheira", "10:00 - 18:00");
        gestaoFuncionarios.cadastrarFuncionario("Pedro Souza", "Garçom", "14:00 - 22:00");

        // Consultar funcionários
        System.out.println("Funcionários cadastrados:");
        gestaoFuncionarios.exibirFuncionarios();

        // Exibir escala de trabalho
        System.out.println("\nEscala de trabalho:");
        gestaoFuncionarios.exibirEscalaTrabalho();

        // Remover funcionário
        gestaoFuncionarios.removerFuncionario("Maria Santos");

        // Consultar funcionários novamente
        System.out.println("\nFuncionários cadastrados após remoção:");
        gestaoFuncionarios.exibirFuncionarios();
    }
}

