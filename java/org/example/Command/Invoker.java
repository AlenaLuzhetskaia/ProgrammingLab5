package org.example.Command;

import org.example.Other.XMLConvent;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class Invoker {
    public final static Map<String, Command> commands = new HashMap<>();
    public static String parameter;

    public static void start() throws IOException, ParseException {
        CollectionManager collectionManager = new CollectionManager();

        commands.put("help", new HelpCommand(collectionManager, commands));
        commands.put("info", new InfoCommand(collectionManager));
        commands.put("show", new ShowCommand(collectionManager));
        commands.put("add", new AddCommand(collectionManager));
        commands.put("update", new UpdateCommand(collectionManager));
        commands.put("remove_by_id", new RemoveByIDCommand(collectionManager));
        commands.put("clear", new ClearCommand(collectionManager));
        commands.put("save", new SaveCommand(collectionManager));
        commands.put("execute_script", new ExecuteScriptCommand(collectionManager));
        commands.put("exit", new ExitCommand());
        commands.put("remove_first", new RemoveFirstCommand(collectionManager));
        commands.put("add_if_max", new AddIfMaxCommand(collectionManager));
        commands.put("remove_greater", new RemoveGreaterCommand(collectionManager));
        commands.put("remove_all_by_age", new RemoveAllByAgeCommand(collectionManager));
        commands.put("remove_any_by_color", new RemoveAnyByColorCommand(collectionManager));
        commands.put("count_by_character", new CountByCharacterCommand(collectionManager));

        XMLConvent.XMLRead(collectionManager);

    }

    public static void executionCommand(String text) {
        String[] tokens = text.split(" ");
        if (tokens.length > 1) {
            parameter = tokens[1];
        }
        try {
            Command command = commands.get(tokens[0].trim());
            if (command == null) {
                System.out.println("Неизвестная команда");
                return;
            }
            command.execute();
        } catch (Exception ignore) {
        }
    }

    public static String getParameter() {
        return parameter;
    }
}
