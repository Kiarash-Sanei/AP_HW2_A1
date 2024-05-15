package com.Control;

import com.AtomicBomber;
import com.Model.GameInformation;
import com.Model.User;
import com.View.GameMenuScreen;
import com.View.OldGameMenuScreen;

public class PauseMenu extends Menu {
    public static void save(GameMenuScreen gameMenuScreen) {
        User.getCurrentUser().setGameInformation(new GameInformation(gameMenuScreen.wave,
                gameMenuScreen.buildings,
                gameMenuScreen.migs,
                gameMenuScreen.tanks,
                gameMenuScreen.trees,
                gameMenuScreen.trenches,
                gameMenuScreen.trucks));
    }

    public static void save(OldGameMenuScreen gameMenuScreen) {
        User.getCurrentUser().setGameInformation(new GameInformation(gameMenuScreen.wave,
                gameMenuScreen.buildings,
                gameMenuScreen.migs,
                gameMenuScreen.tanks,
                gameMenuScreen.trees,
                gameMenuScreen.trenches,
                gameMenuScreen.trucks));
    }

    public static void pause() {
        User.getCurrentUser().getSetting().setMute(true);
        AtomicBomber.checkMute();
    }

    public static void resume(GameMenuScreen gameMenuScreen) {
        save(gameMenuScreen);
        AtomicBomber.changeScreen(new OldGameMenuScreen(AtomicBomber.getAtomicBomber()));
    }

    public static void resume(OldGameMenuScreen oldGameMenuScreen) {
        save(oldGameMenuScreen);
        AtomicBomber.changeScreen(new OldGameMenuScreen(AtomicBomber.getAtomicBomber()));
    }

    public static void changeMusic(int which) {
        switch (which) {
            case 1:
                AtomicBomber.setMusic("Musics/GameMusic1.mp3");
                break;
            case 2:
                AtomicBomber.setMusic("Musics/GameMusic2.mp3");
                break;
            case 3:
                AtomicBomber.setMusic("Musics/GameMusic3.mp3");
                break;
        }
    }
}
