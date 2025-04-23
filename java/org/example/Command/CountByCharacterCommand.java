package org.example.Command;

import org.example.Option.DragonCharacter;

public class CountByCharacterCommand implements Command {
    private CollectionManager collectionManager;

    public CountByCharacterCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute() {
        try {
            System.out.print("Доступные характеристики: ");
            for (DragonCharacter character : DragonCharacter.values()) {
                System.out.print(character + " ");
            }
            System.out.print("Введите характеристику: ");

            String input = System.console().readLine().trim().toUpperCase();
            DragonCharacter character = DragonCharacter.valueOf(input);

            int count = collectionManager.countByCharacter(character);
            System.out.println("Найдено элементов с характеристикой " + character + ": " + count);
        } catch (IllegalArgumentException e) {
            System.out.println("Выберите характеристику из предложенных");
        }
    }

    public String descr() {
        return "count_by_character - выводит количество элементов, значение поля character которых равен заданному";
    }
}
