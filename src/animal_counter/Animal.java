package animal_counter;

import java.util.ArrayList;
import java.util.List;

class Animal {
    private String name;
    private int age;
    private List<String> commands;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.commands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        this.commands.add(command);
    }
}

