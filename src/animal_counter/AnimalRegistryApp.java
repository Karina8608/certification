package animal_counter;

import java.util.Scanner;

public class AnimalRegistryApp {
    private static AnimalRegistry registry = new AnimalRegistry();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Очистка буфера

            switch (choice) {
                case 1:
                    addNewAnimal();
                    break;
                case 2:
                    showAnimalCommands();
                    break;
                case 3:
                    teachAnimalCommand();
                    break;
                case 4:
                    registry.listAnimals();
                    break;
                case 5:
                    System.out.println("Выход.");
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- Главное меню ---");
        System.out.println("1. Завести новое животное");
        System.out.println("2. Показать команды животного");
        System.out.println("3. Обучить животное новой команде");
        System.out.println("4. Показать всех животных");
        System.out.println("5. Выход");
        System.out.print("Ваш выбор: ");
    }

    private static void addNewAnimal() {
        try (Counter counter = new Counter()) {
            System.out.println("Введите тип животного (Dog, Cat, Hamster): ");
            String type = scanner.nextLine();
            System.out.println("Введите имя животного: ");
            String name = scanner.nextLine();
            System.out.println("Введите возраст животного: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            Animal animal = null;

            switch (type.toLowerCase()) {
                case "dog":
                    animal = new Dog(name, age);
                    break;
                case "cat":
                    animal = new Cat(name, age);
                    break;
                case "hamster":
                    animal = new Hamster(name, age);
                    break;
                default:
                    System.out.println("Неверный тип животного.");
                    return;
            }

            registry.addAnimal(animal);
            counter.add();  // Увеличение счетчика при успешном добавлении
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void showAnimalCommands() {
        registry.listAnimals();
        System.out.println("Введите номер животного для просмотра его команд: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        if (index >= 0 && index < registry.animals.size()) {
            Animal animal = registry.animals.get(index);
            System.out.println("Команды животного " + animal.getName() + ": " + animal.getCommands());
        } else {
            System.out.println("Животное не найдено.");
        }
    }

    private static void teachAnimalCommand() {
        registry.listAnimals();
        System.out.println("Введите номер животного для обучения новой команде: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        if (index >= 0 && index < registry.animals.size()) {
            System.out.println("Введите новую команду: ");
            String command = scanner.nextLine();
            registry.teachAnimal(index, command);
        } else {
            System.out.println("Животное не найдено.");
        }
    }
}

