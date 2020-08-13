package by.halatsevich.finder.controller;


import by.halatsevich.finder.controller.command.Command;
import by.halatsevich.finder.controller.command.impl.FindAllCommand;
import by.halatsevich.finder.controller.command.impl.FindApplianceCommand;
import by.halatsevich.finder.controller.command.impl.FindByTagCommand;
import by.halatsevich.finder.controller.command.impl.WrongRequestCommand;

public enum CommandType {
    FIND_APPLIANCE(new FindApplianceCommand()),
    FIND_ALL(new FindAllCommand()),
    FIND_APPLIANCES_BY_TAG(new FindByTagCommand()),
    WRONG_REQUEST(new WrongRequestCommand());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
