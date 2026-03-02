package org.example.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MenuManagerTest {
    private MenuManager manager;
    private IMenu menu;

    @BeforeEach
    void setUp() {
        manager = new MenuManager();
        menu = new Menu(new Scanner(new ByteArrayInputStream("".getBytes())));
    }

    @Test
    void pushingMenuMakesItActive() {
        manager.push(menu);
        assertFalse(manager.isEmpty());
    }

    @Test
    void poppingEmptiesStack() {
        manager.pop();
        assertTrue(manager.isEmpty());
    }

    @Test
    void clearAllEmptiesStack() {;
        manager.push(menu);
        manager.clearAll();
        assertTrue(manager.isEmpty());
    }
}