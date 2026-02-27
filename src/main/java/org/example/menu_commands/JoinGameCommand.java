package org.example.menu_commands;

public class JoinGameCommand implements MenuCommand {
    private final Runnable onSuccess;

    public JoinGameCommand(Runnable onSuccess) {
        this.onSuccess = onSuccess;
    }

    @Override
    public String getLabel() {
        return "Join Existing Game";
    }

    @Override
    public void execute() {
        onSuccess.run();
    }
}
