package battleships.menu;

import java.util.Scanner;

public class FunctionNotAvailableMenu extends IMenu {
    private final static String label = "The function is not available yet";

    public FunctionNotAvailableMenu(Scanner scanner) {
        super(scanner, label);
    }
}
