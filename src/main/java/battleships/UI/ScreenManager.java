package battleships.UI;

import java.util.ArrayDeque;
import java.util.Deque;

public class ScreenManager {
    private final Deque<IScreen> stack;

    public ScreenManager() {
        stack = new ArrayDeque<>();
    }

    public void push(IScreen menu) {
        System.out.print("\033[H\033[2J");
        stack.push(menu);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            // === clearing the terminal ===
            System.out.print("\033[H\033[2J");
            System.out.flush();
            // === does it even work ===
            stack.pop();
        }
    }

    public void run() {
        while (!stack.isEmpty()) {
            stack.peek().run(this);
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void clearAll() {
        stack.clear();
    }
}
