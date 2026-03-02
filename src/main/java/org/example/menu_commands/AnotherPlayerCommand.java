package org.example.menu_commands;

public class AnotherPlayerCommand implements MenuCommand {
    private final Runnable onSuccess;

    public AnotherPlayerCommand(Runnable onSuccess) {
        this.onSuccess = onSuccess;
    }

    @Override
    public String getLabel() {
        return "Another Player";
    }

    @Override
    public void execute() {
        onSuccess.run();
    }
}
