package org.example.menu;

import java.util.ArrayDeque;
import java.util.ArrayList;
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
            stack.pop();
        }
    }

    public void run() {
        while (!stack.isEmpty()) {
            stack.peek().renderMenu(this);
        }
    }

    public void clearAll() {
        stack.clear();
    }
}
