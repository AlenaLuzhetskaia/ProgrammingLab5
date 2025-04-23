package org.example.Command;

import org.example.Option.Dragon;

import static org.example.Other.ClassReader.consoleReadLine;

public class RemoveGreaterCommand implements Command {
    private final CollectionManager collectionManager;

    public RemoveGreaterCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute() {
        System.out.print("Введите возраст дракона: ");
        int age = Integer.parseInt(consoleReadLine());

        int countBefore = collectionManager.size();
        collectionManager.removeGreater(age);
        int countRemoved = countBefore - collectionManager.size();

        System.out.println("Удалены все элементы, превышающих заданный параметр. Количество удалённых элементов: " + countRemoved);
    }

    public String descr() {
        return "remove_greater - удаляет все элементы, превышающие заданный параметр";
    }
}
