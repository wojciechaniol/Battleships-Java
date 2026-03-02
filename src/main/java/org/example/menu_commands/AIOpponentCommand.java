package org.example.menu_commands;

public class AIOpponentCommand implements MenuCommand {
    private final Runnable onSuccess;

    public AIOpponentCommand(Runnable onSuccess) {
        this.onSuccess = onSuccess;
    }

    @Override
    public String getLabel() {
        return "AI";
    }

    @Override
    public void execute() {
        onSuccess.run();
    }
}
