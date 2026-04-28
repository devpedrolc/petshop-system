package view;

import model.Animal;
import service.AnimalService;

import javax.swing.*;
import java.awt.*;

public class MenuUI extends JFrame {

    private AnimalService service;

    public MenuUI(AnimalService service) {
        this.service = service;

        setTitle("Pet Shop - Sistema");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        JButton btnCadastrar = new JButton("Cadastrar Animal");
        JButton btnListar = new JButton("Listar Animais");
        JButton btnSair = new JButton("Sair");

        add(btnCadastrar);
        add(btnListar);
        add(btnSair);

        // 🔥 Cadastrar
        btnCadastrar.addActionListener(e -> cadastrarAnimal());

        // 🔥 Listar
        btnListar.addActionListener(e -> listarAnimais());

        // 🔥 Sair
        btnSair.addActionListener(e -> System.exit(0));
    }

    private void cadastrarAnimal() {

        String nome = JOptionPane.showInputDialog("Nome do animal:");
        String idadeStr = JOptionPane.showInputDialog("Idade:");
        String tipo = JOptionPane.showInputDialog("Tipo:");

        try {
            int idade = Integer.parseInt(idadeStr);

            Animal animal = new Animal(0, nome, idade, tipo);
            service.cadastrar(animal);

            JOptionPane.showMessageDialog(this, "Animal cadastrado com sucesso!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Idade inválida!");
        }
    }

    private void listarAnimais() {

        if (service.listar().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum animal cadastrado.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("🐾 LISTA DE ANIMAIS\n\n");

        for (Animal a : service.listar()) {
            sb.append("Nome: ").append(a.getNome()).append("\n");
            sb.append("Idade: ").append(a.getIdade()).append("\n");
            sb.append("Tipo: ").append(a.getTipo()).append("\n");
            sb.append("----------------------\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString());
    }
}