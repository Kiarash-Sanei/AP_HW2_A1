package com.view;

import com.AtomicBomber;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;

import static com.badlogic.gdx.Gdx.graphics;
import static com.badlogic.gdx.Gdx.input;

public abstract class MenuScreen implements Screen {
    protected AtomicBomber atomicBomber;
    protected Stage stage;

    public MenuScreen(AtomicBomber atomicBomber) {
        this.atomicBomber = atomicBomber;
        this.stage = new Stage();
        input.setInputProcessor(stage);
        stage.setViewport(new FillViewport(graphics.getWidth(), graphics.getHeight()));
    }
    protected MenuScreen getScreen() {
        return (MenuScreen) atomicBomber.getScreen();
    }

    protected void setScreen(MenuScreen MenuScreen) {
        atomicBomber.setScreen(MenuScreen);
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
