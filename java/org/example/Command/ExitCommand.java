package org.example.Command;

public class ExitCommand implements Command {
    public void execute() {
        System.exit(0);
    }

    public String descr() {
        return "exit - завершить программу";
    }
}
