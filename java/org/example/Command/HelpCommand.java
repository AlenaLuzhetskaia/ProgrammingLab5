package org.example.Command;

import java.util.Map;

public class HelpCommand implements Command {
    CollectionManager collectionManager;
    Map<String, Command> commands;

    public HelpCommand(CollectionManager collectionManager, Map<String, Command> commands) {
        this.collectionManager = collectionManager;
        this.commands = commands;
    }

    public void execute() {
        for (Command command : commands.values()) {
            System.out.println(command.descr());
        }
    }

    public String descr() {
        return "help - помощь";
    }
}
