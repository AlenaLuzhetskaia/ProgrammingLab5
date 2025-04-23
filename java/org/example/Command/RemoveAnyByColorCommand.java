package org.example.Command;

import java.awt.*;
import java.util.Scanner;
import org.example.Option.Color;
import org.example.Other.ClassReader;

public class RemoveAnyByColorCommand implements Command {
    private final CollectionManager collectionManager;

    public RemoveAnyByColorCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute() {
        while (true) {
            try {
                System.out.println("Выберите цвет из предложенных:");
                for (Color c : Color.values()) {
                    System.out.print(c + " ");
                }
                System.out.print("Введите цвет: ");

                String input = ClassReader.consoleReadLine().trim().toUpperCase();
                Color color = Color.valueOf(input);

                boolean isRemoved = collectionManager.removeAnyByColor(color);
                if (isRemoved) {
                    System.out.println("Элемент с цветом " + color + " успешно удалён!");
                } else {
                    System.out.println("Элементов с цветом " + color + " не найдено");
                }
                return;

            } catch (IllegalArgumentException e) {
                System.out.println("Выберите цвет из предложенного списка");
            }
        }
    }

    public String descr() {
        return "remove_any_by_color - удаляет один элемент, значение поля color которого эквивалентно заданному";
    }
}
