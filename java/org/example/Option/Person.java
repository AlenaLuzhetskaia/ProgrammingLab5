package org.example.Option;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private double weight; //Значение поля должно быть больше 0
    private String passportID; //Строка не может быть пустой, Длина строки не должна быть больше 43, Поле не может быть null
    private Color eyeColor; //Поле не может быть null

    public void setName(String name) {
        this.name = (name == null) ? "Не существует": name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public void setEyeColor(Color color) {
        this.eyeColor = color;
    }


    public String toString() {
        return "\n\tName: " + name + "\n\tWeight: " + weight + "\n\tPassportID: " + passportID + "\n\tEyeColor: " + eyeColor;
    }

    public String toXML() {
        return "\t\t\t<name>" + name + "</name>\n" + "\t\t\t<weight>" + weight + "</weight>\n" + "\t\t\t<passportID>" + passportID +
                "</passportID>\n" + "\t\t\t<eyeColor>" + eyeColor + "</eyeColor>\n";
    }

}

