package service;

import model.Animal;
import repository.AnimalRepositoryImpl;

import java.util.List;

public class AnimalService {

    private AnimalRepositoryImpl repository;

    public AnimalService(AnimalRepositoryImpl repository) {
        this.repository = repository;
    }

    // ✅ CADASTRAR
    public void cadastrar(Animal animal) {

        if (animal.getNome() == null || animal.getNome().isBlank()) {
            System.out.println("Nome inválido!");
            return;
        }

        if (animal.getIdade() < 0) {
            System.out.println("Idade inválida!");
            return;
        }

        if (animal.getTipo() == null || animal.getTipo().isBlank()) {
            System.out.println("Tipo inválido!");
            return;
        }

        repository.salvar(animal);
    }

    // ✅ LISTAR
    public List<Animal> listar() {
        return repository.listar();
    }

    // ✅ BUSCAR POR NOME
    public Animal buscar(String nome) {

        if (nome == null || nome.isBlank()) {
            System.out.println("Nome inválido para busca!");
            return null;
        }

        return repository.buscarPorNome(nome);
    }

    // ✅ REMOVER
    public boolean remover(String nome) {

        if (nome == null || nome.isBlank()) {
            System.out.println("Nome inválido para remoção!");
            return false;
        }

        return repository.deletar(nome);
    }

    // ✅ ATUALIZAR (extra - nível profissional)
    public boolean atualizar(Animal animal) {

        if (animal.getNome() == null || animal.getNome().isBlank()) {
            System.out.println("Nome inválido!");
            return false;
        }

        if (animal.getIdade() < 0) {
            System.out.println("Idade inválida!");
            return false;
        }

        if (animal.getTipo() == null || animal.getTipo().isBlank()) {
            System.out.println("Tipo inválido!");
            return false;
        }

        // 👉 você pode implementar no repository depois
        // repository.atualizar(animal);

        return true;
    }
}