package view;

import model.Animal;
import model.Cliente;
import model.Consulta;
import service.AnimalService;
import service.ClienteService;
import service.ConsultaService;

import javax.swing.*;
import java.awt.*;

public class MenuUI extends JFrame {

    private AnimalService animalService;
    private ClienteService clienteService;
    private ConsultaService consultaService;

    public MenuUI(AnimalService animalService,
                  ClienteService clienteService,
                  ConsultaService consultaService) {

        this.animalService = animalService;
        this.clienteService = clienteService;
        this.consultaService = consultaService;

        setTitle("Pet Shop - Sistema");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(5, 1));

        // 🧱 BOTÕES
        JButton btnAnimal = new JButton("Cadastrar Animal");
        JButton btnListarAnimais = new JButton("Listar Animais");
        JButton btnCliente = new JButton("Cadastrar Cliente");
        JButton btnConsulta = new JButton("Agendar Consulta");
        JButton btnSair = new JButton("Sair");

        // ➕ ADD NA TELA
        add(btnAnimal);
        add(btnListarAnimais);
        add(btnCliente);
        add(btnConsulta);
        add(btnSair);

        // 🔥 ACTIONS
        btnAnimal.addActionListener(e -> cadastrarAnimal());
        btnListarAnimais.addActionListener(e -> listarAnimais());
        btnCliente.addActionListener(e -> cadastrarCliente());
        btnConsulta.addActionListener(e -> agendarConsulta());
        btnSair.addActionListener(e -> System.exit(0));
    }

    // 🐶 CADASTRAR ANIMAL
    private void cadastrarAnimal() {

        String nome = JOptionPane.showInputDialog("Nome do animal:");
        String idadeStr = JOptionPane.showInputDialog("Idade:");
        String tipo = JOptionPane.showInputDialog("Tipo:");

        if (nome == null || idadeStr == null || tipo == null) return;

        try {
            int idade = Integer.parseInt(idadeStr);

            Animal animal = new Animal(0, nome, idade, tipo);
            animalService.cadastrar(animal);

            JOptionPane.showMessageDialog(this, "Animal cadastrado com sucesso!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Idade inválida!");
        }
    }

    // 📋 LISTAR ANIMAIS
    private void listarAnimais() {

        if (animalService.listar().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum animal cadastrado.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("🐾 LISTA DE ANIMAIS\n\n");

        for (Animal a : animalService.listar()) {
            sb.append("Nome: ").append(a.getNome()).append("\n");
            sb.append("Idade: ").append(a.getIdade()).append("\n");
            sb.append("Tipo: ").append(a.getTipo()).append("\n");
            sb.append("----------------------\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString());
    }

    // 👤 CADASTRAR CLIENTE
    private void cadastrarCliente() {

        String nome = JOptionPane.showInputDialog("Nome do cliente:");
        String telefone = JOptionPane.showInputDialog("Telefone:");

        if (nome == null || telefone == null) return;

        if (nome.isBlank() || telefone.isBlank()) {
            JOptionPane.showMessageDialog(this, "Nome ou telefone inválido!");
            return;
        }

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setTelefone(telefone);

        clienteService.cadastrar(cliente);

        JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
    }

    // 🐾 AGENDAR CONSULTA
    private void agendarConsulta() {

        String clienteNome = JOptionPane.showInputDialog("Nome do cliente:");
        String animalNome = JOptionPane.showInputDialog("Nome do animal:");
        String veterinario = JOptionPane.showInputDialog("Veterinário:");
        String descricao = JOptionPane.showInputDialog("Descrição:");

        if (clienteNome == null || animalNome == null || veterinario == null || descricao == null) {
            return;
        }

        Cliente cliente = clienteService.buscar(clienteNome);
        Animal animal = animalService.buscar(animalNome);

        if (cliente == null || animal == null) {
            JOptionPane.showMessageDialog(this, "Cliente ou Animal não encontrado!");
            return;
        }

        Consulta consulta = new Consulta(
                0,
                cliente,
                animal,
                veterinario,
                java.time.LocalDateTime.now(),
                descricao
        );

        consultaService.agendar(consulta);

        JOptionPane.showMessageDialog(this, "Consulta agendada com sucesso!");
    }
}