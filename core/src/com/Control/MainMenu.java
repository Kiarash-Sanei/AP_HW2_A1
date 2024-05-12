package com.Control;

import com.AtomicBomber;
import com.Model.Wave;
import com.View.*;

public class MainMenu extends Menu {
    public static void newGame() {
        AtomicBomber.changeScreen(new GameMenuScreen(AtomicBomber.getAtomicBomber(), Wave.first));
    }

    public static void previousGame() {
        AtomicBomber.changeScreen(new OldGameMenuScreen(AtomicBomber.getAtomicBomber()));
    }
}
