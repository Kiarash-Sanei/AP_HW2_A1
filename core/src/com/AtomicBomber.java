package com;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.View.LoginMenuScreen;
import com.View.MenuScreen;

public class AtomicBomber extends Game {
    private int width, height;
    private MenuScreen menuScreen;
    private static AtomicBomber atomicBomber;
    private SpriteBatch batch;

    @Override
    public void create() {
        atomicBomber = this;
        menuScreen = new LoginMenuScreen(this);
        batch = new SpriteBatch();
        setScreen(menuScreen);
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.169f, 0.098f, 0.239f, 1);
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
