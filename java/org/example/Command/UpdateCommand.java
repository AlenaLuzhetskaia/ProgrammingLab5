package org.example.Command;

import org.example.Option.Dragon;
import org.example.Other.ClassReader;

public class UpdateCommand implements Command {
    private final CollectionManager collectionManager;

    public UpdateCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute() {
        try {
            System.out.print("Введите id элемента для обновления: ");
            long id = Long.parseLong(ClassReader.consoleReadLine());

            Dragon dragonToUpdate = collectionManager.getById(id);
            if (dragonToUpdate == null) {
                System.out.println("Элемент с id " + id + " не найден");
                return;
            }

            System.out.println("Текущие данные элемента:");
            System.out.println(dragonToUpdate);

            System.out.println("\nВведите новые данные:");
            Filler filler = new Filler();
            filler.fill(dragonToUpdate);

            System.out.println("Элемент с id " + id + " успешно обновлён!");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите корректный числовой id");
        }
    }

    public String descr() {
        return "update - обновить информацию об элементе";
    }
}
