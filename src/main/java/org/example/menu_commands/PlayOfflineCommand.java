package org.example.menu_commands;

public class PlayOfflineCommand implements MenuCommand {
    private final Runnable onSuccess;

    public PlayOfflineCommand(Runnable onSuccess) {
        this.onSuccess = onSuccess;
    }

    @Override
    public String getLabel() {
        return "Play Offline";
    }

    @Override
    public void execute() {
        onSuccess.run();
    }
}
