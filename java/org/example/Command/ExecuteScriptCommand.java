package org.example.Command;

import org.example.Option.Dragon;
import org.example.Other.ClassReader;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Objects;

public class ExecuteScriptCommand implements Command {
    private final CollectionManager collectionManager;
    HashSet<String> fileNames = new HashSet<>();

    public ExecuteScriptCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute() {
        ClassReader reader = new ClassReader();
        try {
            reader.readFile(Invoker.getParameter());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (fileNames.contains(reader.getName())) {
            System.out.println("Выполнение скрипта " + reader.getName() + " отменено");
            return;
        }
        fileNames.add(reader.getName());
        for (var i = 0; i < reader.readLines().size(); i++) {
            String command = reader.readLine();
            if (command == null) {
                break;
            }
            if (Objects.equals(command, "add")) {
                Dragon dragon = new Dragon();
                Filler filler = new Filler();
                filler.fill(dragon, reader);
                collectionManager.add(dragon);
            }
            else if (Objects.equals(command, "update")) {
                Dragon dragon = collectionManager.getById(Long.parseLong(reader.readLine()));
                Filler filler = new Filler();
                filler.fill(dragon, reader);
            } else {
                Invoker.executionCommand(command);
            }
        }
        System.out.println("Скрипт успешно исполнен!");
        fileNames.remove(reader.getName());
    }

    public String descr() {
        return "execute_script - считывает скрипт из указанного файла";
    }
}
