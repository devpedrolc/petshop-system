package repository;

import model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalRepositoryImpl {

    private List<Animal> animais = new ArrayList<>();

    public void salvar(Animal animal) {
        animais.add(animal);
    }

    public List<Animal> listar() {
        return animais;
    }

    public Animal buscarPorNome(String nome) {
        for (Animal a : animais) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        return null;
    }

    public void deletar(String nome) {
        animais.removeIf(a -> a.getNome().equalsIgnoreCase(nome));
    }
}