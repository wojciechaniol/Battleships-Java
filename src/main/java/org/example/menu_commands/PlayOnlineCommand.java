package org.example.menu_commands;

public class PlayOnlineCommand implements MenuCommand {
    private final Runnable onSuccess;

    public PlayOnlineCommand(Runnable onSuccess) {
        this.onSuccess = onSuccess;
    }

    @Override
    public String getLabel() {
        return "Play Online";
    }

    @Override
    public void execute() {
        onSuccess.run();
    }
}
