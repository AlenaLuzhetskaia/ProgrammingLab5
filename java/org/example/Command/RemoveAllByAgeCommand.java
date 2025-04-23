package org.example.Command;

import static org.example.Other.ClassReader.consoleReadLine;

public class RemoveAllByAgeCommand implements Command {
    private final CollectionManager collectionManager;

    public RemoveAllByAgeCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute() {
        System.out.print("Введите возраст дракона: ");
        int age = Integer.parseInt(consoleReadLine());
        try {
            collectionManager.removeAllByAge(age);
            System.out.println("Удалены все элементы с возрастом: " + age);
        } catch (NumberFormatException e) {
            System.out.print(("Введите числовое значение: "));
        }
    }

    public String descr() {
        return "remove_all_by_age - удаляет все элементы, где значение поля age эквивалентно заданному";
    }
}
