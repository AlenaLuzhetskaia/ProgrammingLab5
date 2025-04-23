package org.example.Command;

import org.example.Option.*;
import org.example.Other.ClassReader;

public class Filler {

    public Filler() {
    }

    public void fill(Dragon dragon) {

        while (true) {
            System.out.print("Введите имя дракона: ");
            String name = ClassReader.consoleReadLine();
            if (name.isEmpty()) {
                System.out.println("Имя не должно быть пустым");
            } else {
                dragon.setName(name);
                break;
            }
        }
        while (true) {
            try {
                System.out.print("Введите координаты: ");
                String[] coordinate = ClassReader.consoleReadLine().split(" ");
                if (coordinate.length < 2) {
                    System.out.println("Введите две координаты через пробел");
                    continue;
                }
                Double x = Double.parseDouble(coordinate[0]);
                int y = Integer.parseInt(coordinate[1]);
                dragon.setCoordinates(new Coordinates(x, y));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Введите числовое значение");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Введите возраст дракона: ");
                int age = Integer.parseInt(ClassReader.consoleReadLine());
                if (age <= 0) {
                    System.out.println("Введите значение больше нуля");
                } else {
                    dragon.setAge(age);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите числовое значение");
            }
        }
        while (true) {
            try {
                System.out.print("Введите размах крыльев дракона: ");
                int wingspan = Integer.parseInt(ClassReader.consoleReadLine());
                if (wingspan <= 0) {
                    System.out.println("Введите значение больше нуля");
                } else {
                    dragon.setWingspan(wingspan);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите числовое значение");
            }
        }
        while (true) {
            try {
                System.out.print("Выберите цвет дракона из списка: ");
                for (Color t : Color.values()) {
                    System.out.print(t + " ");
                }
                System.out.print("Выберите цвет: ");
                String input = ClassReader.consoleReadLine().trim().toUpperCase();
                Color color = Color.valueOf(input);
                dragon.setColor(color);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Выберите одно из предложенных значений");
            }
        }
        while (true) {
            try {
                System.out.print("Выберите характер дракона из списка: ");
                for (DragonCharacter t : DragonCharacter.values()) {
                    System.out.print(t + " ");
                }
                System.out.print("Выберите характер: ");
                String input = ClassReader.consoleReadLine().trim().toUpperCase();
                DragonCharacter dragonCharacter = DragonCharacter.valueOf(input);
                dragon.setDragonCharacter(dragonCharacter);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Выберите одно из предложенных значений");
            }
        }


        while (true) {
            try {
                System.out.print("Хотите указать убийцу? (да/нет): ");
                String choice = ClassReader.consoleReadLine().trim().toLowerCase();
                if (choice.equals("да")) {
                    Person killer = new Person();
                    fillKillerData(killer);
                    dragon.setKiller(killer);
                    break;
                } else if (choice.equals("нет")) {
                    dragon.setKiller(null);
                    break;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Выберите одно из предложенных значений");
            }
        }
    }

    private void fillKillerData(Person killer) {
        while (true) {
            System.out.print("Введите имя убийцы: ");
            String name = ClassReader.consoleReadLine().trim();
            if (!name.isEmpty()) {
                killer.setName(name);
                break;
            }
            System.out.println("Имя не должно быть пустым");
        }
        while (true) {
            try {
                System.out.print("Введите вec убийцы: ");
                double weight = Double.parseDouble(ClassReader.consoleReadLine());
                if (weight <= 0) {
                    System.out.println("Введите значение больше нуля");
                } else {
                    killer.setWeight(weight);
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Введите числовое значение");
            }
        }
        while (true) {
            try {
                System.out.print("Введите ID убийцы: ");
                String passportID = ClassReader.consoleReadLine().trim();
                if (passportID.isEmpty()) {
                    System.out.println("ID не может быть пустым");
                } else if (passportID.length() > 43) {
                    System.out.println("Длина ID не должна превышать 43 символа");
                } else {
                    killer.setPassportID(passportID);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите числовое значение");
            }
        }
        while (true) {
            try {
                System.out.print("Выберите цвет глаз убийцы дракона из списка: ");
                for (Color t : Color.values()) {
                    System.out.print(t + " ");
                }
                System.out.print("Выберите цвет: ");
                String input = ClassReader.consoleReadLine().trim().toUpperCase();
                Color eyeColor = Color.valueOf(input);
                killer.setEyeColor(eyeColor);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Выберите одно из предложенных значений");
            }
        }
    }

    public void fill(Dragon dragon, ClassReader reader) {
        String name = reader.readLine();
        if (name.isEmpty()) {
            return;
        } else {
            dragon.setName(name);
        }

        try {
            String[] coordinate = reader.readLine().split(" ");
            if (coordinate.length < 2) {
                return;
            }
            Double x = Double.parseDouble(coordinate[0]);
            int y = Integer.parseInt(coordinate[1]);
            dragon.setCoordinates(new Coordinates(x, y));
        } catch (NumberFormatException e) {
            return;
        } catch (IllegalArgumentException e) {
            return;
        }

        try {
            int age = Integer.parseInt(reader.readLine());
            if (age <= 0) {
                return;
            } else {
                dragon.setAge(age);
            }
        } catch (NumberFormatException e) {
            return;
        }

        try {
            int wingspan = Integer.parseInt(reader.readLine());
            if (wingspan <= 0) {
                return;
            } else {
                dragon.setWingspan(wingspan);
            }
        } catch (NumberFormatException e) {
            return;
        }

        try {
            String input = reader.readLine().trim().toUpperCase();
            Color color = Color.valueOf(input);
            dragon.setColor(color);
        } catch (IllegalArgumentException e) {
            return;
        }

        try {
            String input = reader.readLine().trim().toUpperCase();
            DragonCharacter dragonCharacter = DragonCharacter.valueOf(input);
            dragon.setDragonCharacter(dragonCharacter);
        } catch (IllegalArgumentException e) {
            return;
        }

        String choice = reader.readLine().trim().toLowerCase();
        if (choice.equals("да")) {
            Person killer = new Person();
            fillKillerData(killer, reader);
            dragon.setKiller(killer);
        } else if (choice.equals("нет")) {
            dragon.setKiller(null);
        } else return;
    }

    private void fillKillerData(Person killer, ClassReader reader) {
        String name = reader.readLine().trim();
        if (!name.isEmpty()) {
            killer.setName(name);
        }

        try {
            double weight = Double.parseDouble(reader.readLine());
            if (weight <= 0) {
                return;
            } else {
                killer.setWeight(weight);
            }

        } catch (NumberFormatException e) {
            return;
        }

        try {
            String passportID = reader.readLine().trim();
            if (passportID.isEmpty()) {
            } else if (passportID.length() > 43) {
                return;
            } else {
                killer.setPassportID(passportID);
            }
        } catch (NumberFormatException e) {
            return;
        }

        try {
            String input = reader.readLine().trim().toUpperCase();
            Color eyeColor = Color.valueOf(input);
            killer.setEyeColor(eyeColor);
        } catch (IllegalArgumentException e) {
        }
    }
}
