package battleships.menu_commands;

public class CreateNewGameCommand implements MenuCommand {
    private final Runnable onSuccess;

    public CreateNewGameCommand(Runnable onSuccess) {
        this.onSuccess = onSuccess;
    }

    @Override
    public String getLabel() {
        return "Create New Game";
    }

    @Override
    public void execute() {
        onSuccess.run();
    }
}
