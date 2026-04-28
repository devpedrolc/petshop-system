package model;

public class Consulta {
    private int id;
    private Animal animal;
    private Veterinario veterinario;
    private String data;

    public Consulta(int id, Animal animal, Veterinario veterinario, String data) {
        this.id = id;
        this.animal = animal;
        this.veterinario = veterinario;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", animal=" + animal +
                ", veterinario=" + veterinario +
                ", data='" + data + '\'' +
                '}';
    }
}
