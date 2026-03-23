package org.example.menu;

import java.util.ArrayDeque;
import java.util.Deque;

public class MenuManager {
    private final Deque<IMenu> stack;

    public MenuManager() {
        stack = new ArrayDeque<>();
    }

    public void push(IMenu menu) {
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
            stack.peek().renderMenu(this);
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void clearAll() {
        stack.clear();
    }
}
