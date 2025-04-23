package org.example.Command;

import org.example.Option.Dragon;

public class RemoveFirstCommand implements  Command {
    CollectionManager collectionManager;
    public RemoveFirstCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute() {
        if (collectionManager.getDragonPriorityQueue().isEmpty()) {
            System.out.println("Коллекция пуста, удаление невозможно");
            return;
        }

        Dragon removedDragon = collectionManager.getDragonPriorityQueue().poll();
        System.out.println("Первый элемент коллекции успешно удалён!");
    }

    public String descr() {
        return "remove_first - удаляет первый элемент коллекции";
    }
}
