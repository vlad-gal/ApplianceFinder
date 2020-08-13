package by.halatsevich.finder.controller;

import by.halatsevich.finder.controller.command.Command;

import java.util.Map;

public class Controller {
    private static Controller instance;
    private final CommandProvider provider = new CommandProvider();

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            return new Controller();
        }
        return instance;
    }

    public Map<String, Object> executeRequest(String command, Map<String, String> applianceParameter) {
        Command defineCommand = provider.defineCommand(command);
        return defineCommand.execute(applianceParameter);
    }
}

