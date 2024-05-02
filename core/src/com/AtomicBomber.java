package com;

import com.badlogic.gdx.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.view.LoginMenuScreen;
import com.view.MenuScreen;

public class AtomicBomber extends Game {
    private int width, height;
    private MenuScreen menuScreen;
    private static AtomicBomber atomicBomber;

    @Override
    public void create() {
        atomicBomber = this;
        menuScreen = new LoginMenuScreen(this);
        setScreen(menuScreen);
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 0.5f);
        super.render();
    }

    public static void changeScreen(MenuScreen menuScreen) {
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
}
