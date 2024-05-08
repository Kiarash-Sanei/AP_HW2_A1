package com.Control;

import com.AtomicBomber;
import com.View.*;

public class MainMenu extends Menu {
    public static void newGame() {
        AtomicBomber.changeScreen(new GameMenuScreen(AtomicBomber.getAtomicBomber()));
    }

    public static void previousGame() {
        AtomicBomber.changeScreen(new OldGameMenuScreen(AtomicBomber.getAtomicBomber()));
    }
}
