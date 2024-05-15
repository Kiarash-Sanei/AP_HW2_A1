package com.View;

import com.AtomicBomber;
import com.Control.LoginMenu;
import com.Control.Menu;
import com.Model.Keyboard;
import com.Model.User;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import static com.badlogic.gdx.Gdx.graphics;

public class GameOverMenuScreen extends MenuScreen {

    public GameOverMenuScreen(AtomicBomber atomicBomber, int killCount, int wave, float accuracy) {
        super(atomicBomber);
        assetLoader();
        Table table = new Table();
        TextButton exit = new TextButton("Exit", button);
        table.setBounds(0, 0, graphics.getWidth(), graphics.getHeight());
        table.add(new Label("Kill Count : " + GameMenuScreen.getKillCount(), text));
        table.row();
        table.add(new Label("Accuracy : " + GameMenuScreen.getAccuracy(), text));
        table.row();
        table.add(exit);
        exit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                User user = User.getCurrentUser();
                user.setScore(killCount);
                user.setLastWave(wave);
                user.setSuccessfulShootCount(killCount);
                user.setShootCount((int) (killCount / accuracy));
                Menu.exit();
            }
        });
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
        stage.act(delta);
        stage.draw();
        if (Keyboard.status.get(Keyboard.REVIVE)) {
            AtomicBomber.changeScreen(new OldGameMenuScreen(atomicBomber));
        }
    }

    @Override
    public void assetLoader() {
        settingUpdater();
        AssetManager assetManager = new AssetManager();
        if (isBlackAndWhite) {
            assetManager.load("Text/B&W/Text.json", Skin.class);
            assetManager.load("Button/B&W/Button.json", Skin.class);
            assetManager.finishLoading();
            MenuScreen.text = assetManager.get("Text/B&W/Text.json");
            MenuScreen.button = assetManager.get("Button/B&W/Button.json");
            MenuScreen.background = new Image(new Texture("Background/B&W/Background.png"));
        } else {
            assetManager.load("Text/Colored/Text.json", Skin.class);
            assetManager.load("Button/Colored/Button.json", Skin.class);
            assetManager.finishLoading();
            MenuScreen.text = assetManager.get("Text/Colored/Text.json");
            MenuScreen.button = assetManager.get("Button/Colored/Button.json");
            MenuScreen.background = new Image(new Texture("Background/Colored/Background.png"));
        }
        MenuScreen.background.setHeight(graphics.getHeight());
        MenuScreen.background.setWidth(graphics.getWidth());
    }
}
