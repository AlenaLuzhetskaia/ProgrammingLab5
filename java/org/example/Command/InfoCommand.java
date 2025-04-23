package org.example.Command;

public class InfoCommand implements Command {
    CollectionManager collectionManager;

    public InfoCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute() {
        System.out.println("Размер коллекции: " + collectionManager.size() + "\n"
            + "Дата инициализации: " + collectionManager.creationDate().toString());
    }

    public String descr() {
        return "info - информация о коллекции";
    }
}
