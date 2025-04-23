package org.example.Command;

import org.example.Option.Dragon;

public class AddCommand implements Command {
    private final CollectionManager collectionManager;

    public AddCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute() {
        Filler filler = new Filler();
        Dragon dragon = new Dragon();
        filler.fill(dragon);

        collectionManager.add(dragon);
        System.out.println("Элемент успешно добавлен!");
    }

    public String descr() {
        return "add - добавление нового элемента";
    }
}
