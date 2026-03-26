package battleships.menu_commands;

public class GoBackCommand implements MenuCommand {
    private final Runnable onSuccess;

    public GoBackCommand(Runnable onSuccess) {
        this.onSuccess = onSuccess;
    }

    @Override
    public String getLabel() {
        return "Go Back";
    }

    @Override
    public void execute() {
        onSuccess.run();
    }
}
