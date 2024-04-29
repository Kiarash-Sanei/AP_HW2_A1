package com.view;

import com.MyGame;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class MenuScreen implements Screen {
    protected final MyGame game;
    protected final Stage stage;

    public MenuScreen(MyGame game) {
        this.game = game;
        stage = new Stage();
    }

    protected MenuScreen getScreen() {
        return (MenuScreen) game.getScreen();
    }

    protected void setScreen(MenuScreen screen) {
        game.setScreen(screen);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float deltaTime) {
        stage.act(deltaTime);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
