package com.Control;

import com.AtomicBomber;
import com.Model.Wave;
import com.View.*;

public class MainMenu extends Menu {
    public static void newGame() {
        gameMenuScreen = new GameMenuScreen(AtomicBomber.getAtomicBomber(), Wave.first);
        AtomicBomber.changeScreen(gameMenuScreen);
    }

    public static void previousGame() {
        AtomicBomber.changeScreen(new OldGameMenuScreen(AtomicBomber.getAtomicBomber()));
    }
}
