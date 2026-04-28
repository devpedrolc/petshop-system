package model;

import java.time.LocalDateTime;

public class Consulta {

    private int id;
    private Cliente cliente;
    private Animal animal;
    private String veterinario;
    private LocalDateTime dataHora;
    private String descricao;

    // ✅ Construtor vazio
    public Consulta() {
    }

    // ✅ Construtor completo (resolve seu erro)
    public Consulta(int id, Cliente cliente, Animal animal,
                    String veterinario, LocalDateTime dataHora, String descricao) {

        this.id = id;
        this.cliente = cliente;
        this.animal = animal;
        this.veterinario = veterinario;
        this.dataHora = dataHora;
        this.descricao = descricao;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Animal getAnimal() {
        return animal;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}