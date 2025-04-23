package org.example;
import org.example.Command.Invoker;
import org.example.Other.ClassReader;

import java.io.IOException;
import java.text.ParseException;

// 10149 вариант

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println(System.getProperty("user.dir"));
        Invoker.start();

        while (true) {
            String userInput = ClassReader.consoleReadLine().trim(); // Чтение ввода и удаление лишних пробелов
            if (!userInput.isEmpty()) {
                Invoker.executionCommand(userInput); // Передаем команду в Invoker
            }
        }
    }
}