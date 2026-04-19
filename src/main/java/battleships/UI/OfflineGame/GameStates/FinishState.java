package battleships.UI.OfflineGame.GameStates;

public class FinishState implements IState {
    @Override
    public void render() {
        System.out.println("We finished");
    }

    @Override
    public IState takeInput() {
        return null;
    }
}
