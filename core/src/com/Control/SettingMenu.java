package com.Control;

import com.Model.Difficulty;
import com.Model.Setting;
import com.Model.User;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class SettingMenu extends Menu {
    private static Setting setting = User.getCurrentUser().getSetting();

    public static void changeMute() {
        setting.setMute(!setting.getMute());
    }

    public static void changeColorMode() {
        setting.setBlackAndWhite(!setting.getBlackAndWhite());
        settingMenu();
    }

    public static void changeDifficulty(Difficulty difficulty) {
        setting.setDifficulty(difficulty);
        settingMenu();
    }

    public static void addUp(InputEvent event) {
        setting.setUp(event.getButton());
    }

    public static void addDown(InputEvent event) {
        setting.setDown(event.getButton());
    }

    public static void addRight(InputEvent event) {
        setting.setRight(event.getButton());
    }

    public static void addLeft(InputEvent event) {
        setting.setLeft(event.getButton());
    }

    public static void addRegularBomb(InputEvent event) {
        setting.setRegularBomb(event.getButton());
    }

    public static void addRadioactiveBomb(InputEvent event) {
        setting.setRadioactiveBomb(event.getButton());
    }

    public static void addClusterBomb(InputEvent event) {
        setting.setClusterBomb(event.getButton());
    }

    public static void addIceMode(InputEvent event) {
        setting.setIceMode(event.getButton());
    }
}
