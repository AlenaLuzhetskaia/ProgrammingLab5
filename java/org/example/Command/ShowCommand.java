package org.example.Command;

import org.example.Option.Dragon;

import java.util.PriorityQueue;

public class ShowCommand implements Command {
    CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute() {
        PriorityQueue<Dragon> dragonPriorityQueue = collectionManager.getDragonPriorityQueue();
        if (collectionManager.size() == 0) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Элементы коллекции:");
            for (Dragon dragon : dragonPriorityQueue) {
                System.out.println(dragon.toString());
            }
        }
    }

    public String descr() {
        return "show - показать все элементы коллекции";
    }
}
