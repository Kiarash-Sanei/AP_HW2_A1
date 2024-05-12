package com;

import com.Model.User;
import com.View.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class AtomicBomber extends Game {
    private int width, height;
    private static MenuScreen menuScreen;
    private static AtomicBomber atomicBomber;
    private static Music music;

    @Override
    public void create() {
        atomicBomber = this;
        menuScreen = new LoginMenuScreen(this);
        setScreen(menuScreen);
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        music = Gdx.audio.newMusic(Gdx.files.internal("Musics/GeneralMusic.mp3"));
        music.setLooping(true);
        music.setVolume(0.5f);
        music.play();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.169f, 0.098f, 0.239f, 1);
        super.render();
    }

    public static void changeScreen(MenuScreen menuScreen) {
        setMusic(AtomicBomber.menuScreen, menuScreen);
        atomicBomber.setScreen(menuScreen);
    }

    public static AtomicBomber getAtomicBomber() {
        return atomicBomber;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private static void setMusic(MenuScreen oldMenuScreen, MenuScreen newMenuScreen) {
        if (!User.getCurrentUser().getSetting().getMute()) {
            if ((newMenuScreen.getClass() == AvatarMenuScreen.class ||
                    newMenuScreen.getClass() == LeaderboardMenuScreen.class ||
                    newMenuScreen.getClass() == LoginMenuScreen.class ||
                    newMenuScreen.getClass() == MainMenuScreen.class ||
                    newMenuScreen.getClass() == ProfileMenuScreen.class ||
                    newMenuScreen.getClass() == SettingScreen.class) &&
                    (oldMenuScreen.getClass() == GameMenuScreen.class)) {
                music.stop();
                music = Gdx.audio.newMusic(Gdx.files.internal("Musics/GeneralMusic.mp3"));
            } else if ((oldMenuScreen.getClass() == AvatarMenuScreen.class ||
                    oldMenuScreen.getClass() == LeaderboardMenuScreen.class ||
                    oldMenuScreen.getClass() == LoginMenuScreen.class ||
                    oldMenuScreen.getClass() == MainMenuScreen.class ||
                    oldMenuScreen.getClass() == ProfileMenuScreen.class ||
                    oldMenuScreen.getClass() == SettingScreen.class) &&
                    (newMenuScreen.getClass() == GameMenuScreen.class)) {
                music.stop();
                music = Gdx.audio.newMusic(Gdx.files.internal("Musics/GameMusic.mp3"));
            }
            music.setLooping(true);
            music.setVolume(0.5f);
            music.play();
        }
        else {
            music.stop();
        }
    }
}
