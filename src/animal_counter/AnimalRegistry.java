package animal_counter;

import java.util.ArrayList;
import java.util.List;

class AnimalRegistry {
    List<Animal> animals;

    public AnimalRegistry() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println("Новое животное добавлено: " + animal.getName());
    }

    public void listAnimals() {
        if (animals.isEmpty()) {
            System.out.println("Реестр пуст.");
        } else {
            for (int i = 0; i < animals.size(); i++) {
                Animal animal = animals.get(i);
                System.out.println((i + 1) + ". " + animal.getName() + ", Возраст: " + animal.getAge() + ", Команды: " + animal.getCommands());
            }
        }
    }

    public void teachAnimal(int index, String command) {
        if (index >= 0 && index < animals.size()) {
            Animal animal = animals.get(index);
            animal.addCommand(command);
            System.out.println(animal.getName() + " выучил новую команду: " + command);
        } else {
            System.out.println("Животное с таким индексом не найдено.");
        }
    }
}

