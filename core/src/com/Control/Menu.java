package com.Control;

import com.AtomicBomber;
import com.View.*;

public abstract class Menu {
    public static void exit() {
        System.exit(0);
    }

    public static void profileMenu() {
        AtomicBomber.changeScreen(new ProfileMenuScreen(AtomicBomber.getAtomicBomber()));
    }

    public static void leaderboardMenu() {
        AtomicBomber.changeScreen(new LeaderboardMenuScreen(AtomicBomber.getAtomicBomber()));
    }

    public static void settingMenu() {
        AtomicBomber.changeScreen(new SettingScreen(AtomicBomber.getAtomicBomber()));
    }

    public static void loginMenu() {
        AtomicBomber.changeScreen(new LoginMenuScreen(AtomicBomber.getAtomicBomber()));
    }

    public static void mainMenu() {
        AtomicBomber.changeScreen(new MainMenuScreen(AtomicBomber.getAtomicBomber()));
    }
    public static void avatarMenu() {
        AtomicBomber.changeScreen(new AvatarMenuScreen(AtomicBomber.getAtomicBomber()));
    }
}
