package com.View;

import com.AtomicBomber;
import com.Model.Keyboard;
import com.Model.User;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import static com.badlogic.gdx.Gdx.graphics;

public class PauseMenuScreen extends MenuScreen {
    public GameMenuScreen gameMenuScreen;

    public PauseMenuScreen(AtomicBomber atomicBomber, GameMenuScreen gameMenuScreen) {
        super(atomicBomber);
        this.gameMenuScreen = gameMenuScreen;
        Table table = new Table();
        table.setBounds(0, 0, graphics.getWidth(), graphics.getHeight());
        table.add(new Label("Kill Count : " + GameMenuScreen.getKillCount(), text));
        table.row();
        table.add(new Label("Accuracy : " + GameMenuScreen.getAccuracy(), text));
        stage.addListener(new ClickListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                return Keyboard.keyDown(keycode, User.getCurrentUser().getSetting());
            }

            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                return Keyboard.keyUp(keycode, User.getCurrentUser().getSetting());
            }
        });
        stage.addActor(MenuScreen.background);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (Keyboard.status.get(Keyboard.REVIVE))
            AtomicBomber.changeScreen(gameMenuScreen);
    }

    @Override
    public void assetLoader() {
        settingUpdater();
        AssetManager assetManager = new AssetManager();
        if (isBlackAndWhite) {
            assetManager.load("Text/B&W/Text.json", Skin.class);
            assetManager.finishLoading();
            MenuScreen.text = assetManager.get("Text/B&W/Text.json");
            MenuScreen.background = new Image(new Texture("Background/B&W/Background.png"));
        } else {
            assetManager.load("Text/Colored/Text.json", Skin.class);
            assetManager.finishLoading();
            MenuScreen.text = assetManager.get("Text/Colored/Text.json");
            MenuScreen.background = new Image(new Texture("Background/Colored/Background.png"));
        }
        MenuScreen.background.setHeight(graphics.getHeight());
        MenuScreen.background.setWidth(graphics.getWidth());
    }
}
