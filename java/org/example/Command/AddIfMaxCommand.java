package org.example.Command;

import org.example.Option.Dragon;

public class AddIfMaxCommand implements Command {
    private final CollectionManager collectionManager;

    public AddIfMaxCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute() {
        Filler filler = new Filler();
        Dragon newDragon = new Dragon();
        filler.fill(newDragon);

        if (collectionManager.isMax(newDragon)) {
            collectionManager.add(newDragon);
            System.out.println("Элемент успешно добавлен!");
        } else {
            System.out.println("Элемент не добавлен, так как значение поля age не является максимальным");
        }
    }

    public String descr() {
        return "add_if_max - добавляет новый элемент в коллекцию, если его значение поля age превышает значение наибольшего элемента этой коллекции";
    }
}
