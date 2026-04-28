package model;

public class Veterinario {
    private int id;
    private String nome;
    private String especialidade;

    public Veterinario(int id, String nome, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }
}

