package org.example.Command;

public class ClearCommand implements Command {
    private final CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute() {
        collectionManager.clear();
        System.out.println("Коллекция успешно очищена!");
    }

    public String descr() {
        return "clear - очистить коллекцию";
    }
}
