package model;

public class Animal {

    private int id;
    private String nome;
    private int idade;
    private String tipo;

    public Animal(int id, String nome, int idade, String tipo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
    }

    public Animal() {

    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getTipo() { return tipo; }

    public void setNome(String nome) { this.nome = nome; }

    public void setId(int id) {
    }

    public void setTipo(String tipo) {
    }

    public void setIdade(int idade) {

    }
}