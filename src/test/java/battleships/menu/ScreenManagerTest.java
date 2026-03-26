package battleships.menu;

import battleships.UI.ScreenManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ScreenManagerTest {
    private ScreenManager manager;
    private IMenu menu;

    @BeforeEach
    void setUp() {
        manager = new ScreenManager();
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