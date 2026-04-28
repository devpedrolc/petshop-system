package repository;

import model.Animal;
import java.util.List;

public interface AnimalRepository {

    void salvar(Animal animal);

    List<Animal> listar();

    Animal buscarPorNome(String nome);

    void deletar(String nome);
}