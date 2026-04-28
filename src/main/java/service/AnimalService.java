package service;

import model.Animal;
import repository.AnimalRepositoryImpl;

import java.util.List;

public class AnimalService {

    private AnimalRepositoryImpl repository;

    public AnimalService(AnimalRepositoryImpl repository) {
        this.repository = repository;
    }

    public void cadastrar(Animal animal) {
        repository.salvar(animal);
    }

    public List<Animal> listar() {
        return repository.listar();
    }

    public Animal buscar(String nome) {
        return repository.buscarPorNome(nome);
    }

    public void remover(String nome) {
        repository.deletar(nome);
    }
}