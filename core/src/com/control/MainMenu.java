package com.control;

import com.AtomicBomber;
import com.view.*;

import static com.badlogic.gdx.Gdx.graphics;

public class MainMenu extends Menu {
    public static void newGame() {
        AtomicBomber.changeScreen(new GameMenuScreen(AtomicBomber.getAtomicBomber(), (float) graphics.getHeight() / 2, (float) graphics.getHeight() / 2));
    }

    public static void previousGame() {
        AtomicBomber.changeScreen(new GameMenuScreen(AtomicBomber.getAtomicBomber(), (float) graphics.getHeight() / 2, (float) graphics.getHeight() / 2));
    }
}
