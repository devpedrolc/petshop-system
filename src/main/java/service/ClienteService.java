package service;

import model.Cliente;
import repository.ClienteRepository;

import java.util.List;

public class ClienteService {

    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Cliente cliente) {

        // ✅ validação correta
        if (cliente.getNome() == null || cliente.getNome().isBlank()) {
            System.out.println("Nome inválido!");
            return;
        }

        if (cliente.getTelefone() == null || cliente.getTelefone().isBlank()) {
            System.out.println("Telefone inválido!");
            return;
        }

        repository.salvar(cliente);
    }

    public List<Cliente> listar() {
        return repository.listar();
    }

    public Cliente buscar(String nome) {
        return repository.buscarPorNome(nome);
    }

    public boolean remover(String nome) {
        return repository.deletar(nome);
    }
}