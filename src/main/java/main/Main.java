package main;

import config.Conexao;
import repository.AnimalRepositoryImpl;
import repository.ClienteRepository;
import repository.ConsultaRepository;

import service.AnimalService;
import service.ClienteService;
import service.ConsultaService;

import view.MenuUI;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        Connection conn = Conexao.conectar();

        if (conn != null) {
            System.out.println("Conectado com sucesso");
        }

        // 🐶 ANIMAL
        AnimalRepositoryImpl animalRepo = new AnimalRepositoryImpl(conn);
        AnimalService animalService = new AnimalService(animalRepo);

        // 👤 CLIENTE
        ClienteRepository clienteRepo = new ClienteRepository(conn);
        ClienteService clienteService = new ClienteService(clienteRepo);

        // 🐾 CONSULTA
        ConsultaRepository consultaRepo = new ConsultaRepository(conn);
        ConsultaService consultaService = new ConsultaService(consultaRepo);

        // 🖥️ UI
        MenuUI ui = new MenuUI(animalService, clienteService, consultaService);
        ui.setVisible(true);
    }
}