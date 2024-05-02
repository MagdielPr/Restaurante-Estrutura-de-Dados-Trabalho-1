package GestaoFuncionarios;

public class Funcionario {
    private String nome;
    private String cargo;
    private String horarioTrabalho;

    public Funcionario(String nome, String cargo, String horarioTrabalho) {
        this.nome = nome;
        this.cargo = cargo;
        this.horarioTrabalho = horarioTrabalho;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getHorarioTrabalho() {
        return horarioTrabalho;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.cargo + " - " + this.horarioTrabalho;
    }
}