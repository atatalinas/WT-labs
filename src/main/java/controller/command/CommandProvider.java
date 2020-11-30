package controller.command;

import controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();


    public CommandProvider() {
        commands.put("authorization", new AuthorizationCommand());
        commands.put("goToRegistratioPage", new GoToRegistrationCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("go_to_index", new GoToIndexPageCommand());
        commands.put("change_locale", new ChangeLocale());
    }

    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}