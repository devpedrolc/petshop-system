package main;

import repository.AnimalRepositoryImpl;
import service.AnimalService;
import view.MenuUI;

public class Main {

    public static void main(String[] args) {

        AnimalRepositoryImpl repository = new AnimalRepositoryImpl();
        AnimalService service = new AnimalService(repository);

        MenuUI ui = new MenuUI(service);
        ui.setVisible(true);
    }
}