package service;

import model.Consulta;
import repository.ConsultaRepository;

import java.util.List;

public class ConsultaService {

    private ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    // 📌 Agendar consulta com validações
    public boolean agendar(Consulta consulta) {

        if (consulta == null) {
            System.out.println("Consulta inválida!");
            return false;
        }

        if (consulta.getCliente() == null) {
            System.out.println("Cliente inválido!");
            return false;
        }

        if (consulta.getAnimal() == null) {
            System.out.println("Animal inválido!");
            return false;
        }

        if (consulta.getVeterinario() == null || consulta.getVeterinario().isBlank()) {
            System.out.println("Veterinário inválido!");
            return false;
        }

        repository.salvar(consulta);
        return true;
    }

    // 📋 Listar consultas
    public List<Consulta> listar() {
        return repository.listar();
    }
}