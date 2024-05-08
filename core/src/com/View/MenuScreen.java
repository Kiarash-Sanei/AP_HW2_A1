package com.View;

import com.AtomicBomber;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.Model.User;

import static com.badlogic.gdx.Gdx.graphics;
import static com.badlogic.gdx.Gdx.input;

public abstract class MenuScreen implements Screen {
    protected AtomicBomber atomicBomber;
    protected Stage stage;
    protected static boolean isBlackAndWhite;
    protected static boolean isMute;
    protected static Skin text;
    protected static Skin button;
    protected static Skin textField;
    protected static Skin username;
    protected static Skin password;
    protected static Skin checkBox;

    public MenuScreen(AtomicBomber atomicBomber) {
        this.atomicBomber = atomicBomber;
        this.stage = new Stage();
        input.setInputProcessor(stage);
        stage.setViewport(new FillViewport(graphics.getWidth(), graphics.getHeight()));
    }

    public abstract void assetLoader();

    public void settingUpdater() {
        User user = User.getCurrentUser();
        if (user == null) {
            isBlackAndWhite = false;
            isMute = false;
        } else {
            isBlackAndWhite = user.getSetting().getBlackAndWhite();
            isMute = user.getSetting().getMute();
        }
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
