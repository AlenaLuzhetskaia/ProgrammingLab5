package org.example.Command;

import org.example.Other.XMLConvent;

import java.io.IOException;

public class SaveCommand implements Command {
    private final CollectionManager collectionManager;

    public SaveCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute() {
        if (collectionManager.size() != 0) {
            try {
                XMLConvent.XMLWrite(collectionManager);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Коллекция сохранена в формате xml");
        } else {
            System.out.println("Коллекция пуста");
        }
    }

    public String descr() {
        return "save - сохраняет коллекцию в файл в формате xml";
    }
}
