package com.Control;

import com.AtomicBomber;
import com.Model.User;
import com.Model.Wave;
import com.View.*;

import java.util.Objects;

public class MainMenu extends Menu {
    public static void newGame() {
        gameMenuScreen = new GameMenuScreen(AtomicBomber.getAtomicBomber(), Wave.first);
        AtomicBomber.changeScreen(gameMenuScreen);
    }

    public static void previousGame() {
        if (!Objects.equals(User.getCurrentUser().getUsername(), "_guest_"))
            AtomicBomber.changeScreen(new OldGameMenuScreen(AtomicBomber.getAtomicBomber()));
    }
}
