package controller;

import model.Animal;
import service.AnimalService;

import java.util.Scanner;

public class MenuController {

    private AnimalService service;
    private Scanner sc = new Scanner(System.in);

    public MenuController(AnimalService service) {
        this.service = service;
    }

    public void iniciar() {

        int opcao = -1;

        do {
            System.out.println("\n--- PET SHOP ---");
            System.out.println("1 - Cadastrar Animal");
            System.out.println("2 - Listar Animais");
            System.out.println("3 - Buscar Animal");
            System.out.println("4 - Remover Animal");
            System.out.println("0 - Sair");

            opcao = lerOpcao();

            switch (opcao) {

                case 1 -> cadastrarAnimal();

                case 2 -> listarAnimais();

                case 3 -> buscarAnimal();

                case 4 -> removerAnimal();

                case 0 -> System.out.println("Saindo do sistema...");
            }

        } while (opcao != 0);
    }

    // 🔥 validação de número (SEM QUEBRAR)
    private int lerOpcao() {
        String entrada;
        int opcao = -1;

        while (opcao == -1) {
            System.out.print("Digite a opção: ");
            entrada = sc.nextLine();

            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida! Digite apenas números.");
            }
        }

        return opcao;
    }

    private void cadastrarAnimal() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = Integer.parseInt(sc.nextLine());

        System.out.print("Raça: ");
        String tipo = sc.nextLine();

        service.cadastrar(new Animal(0, nome, idade, tipo));
    }

    private void listarAnimais() {
        if (service.listar().isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
            return;
        }

        System.out.println("\n🐾 LISTA DE ANIMAIS");

        service.listar().forEach(a -> {
            System.out.println("-------------------");
            System.out.println("Nome: " + a.getNome());
            System.out.println("Idade: " + a.getIdade());
            System.out.println("Raça : " + a.getTipo());
        });

        System.out.println("-------------------");
    }

    private void buscarAnimal() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        Animal animal = service.buscar(nome);

        if (animal != null) {
            System.out.println("\n🐾 ANIMAL ENCONTRADO");
            System.out.println("-------------------");
            System.out.println("Nome: " + animal.getNome());
            System.out.println("Idade: " + animal.getIdade());
            System.out.println("Raça: " + animal.getTipo());
            System.out.println("-------------------");
        } else {
            System.out.println("Animal não encontrado.");
        }
    }

    private void removerAnimal() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        service.remover(nome);
        System.out.println("Se existia, foi removido.");
    }
}