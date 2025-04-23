package org.example.Option;

public class Coordinates {
    private Double x; //Поле не может быть null
    private int y;

    public Coordinates(Double x, int y) {
        setX(x);
        this.y = y;
    }

    public void setX(Double x) {
        if (x == null) {
            throw new IllegalArgumentException("Координата x не может быть null");
        }
        this.x = x;
    }

    public String toString() {
        return "\n\tx: " + x + "\n\t" + "y: " + y;
    }

    public String toXML() {
        return "\t\t\t<x>" + this.x + "</x>\n\t\t\t<y>" + this.y + "</y>\n";
    }
}
