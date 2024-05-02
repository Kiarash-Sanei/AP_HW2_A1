package com.control;

import com.AtomicBomber;
import com.view.*;

public class MainMenu extends Menu {
    public static void newGame() {
        AtomicBomber.changeScreen(new GameMenuScreen(AtomicBomber.getAtomicBomber()));
    }

    public static void previousGame() {
        AtomicBomber.changeScreen(new GameMenuScreen(AtomicBomber.getAtomicBomber()));
    }
}
