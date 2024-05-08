package com.View;

import com.AtomicBomber;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.Control.MainMenu;
import com.Model.User;

import static com.badlogic.gdx.Gdx.graphics;

public class MainMenuScreen extends MenuScreen {

    public MainMenuScreen(AtomicBomber atomicBomber) {
        super(atomicBomber);
        assetLoader();
        User user = User.getCurrentUser();
        Label username = new Label(user.getUsername(), MenuScreen.text);
        Image avatar = new Image(new Texture(user.getAvatarPath()));
        TextButton newGame = new TextButton("New Game", MenuScreen.button);
        TextButton previousGame = new TextButton("Previous Game", MenuScreen.button);
        TextButton profileMenu = new TextButton("Profile Menu", MenuScreen.button);
        TextButton leaderboardMenu = new TextButton("Leaderboard Menu", MenuScreen.button);
        TextButton settingMenu = new TextButton("Setting Menu", MenuScreen.button);
        TextButton loginMenu = new TextButton("Login Menu", MenuScreen.button);
        TextButton exit = new TextButton("Exit", MenuScreen.button);
        Table mainTable = new Table();
        newGame.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MainMenu.newGame();
            }
        });
        previousGame.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MainMenu.previousGame();
            }
        });
        profileMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MainMenu.profileMenu();
            }
        });
        leaderboardMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MainMenu.leaderboardMenu();
            }
        });
        settingMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MainMenu.settingMenu();
            }
        });
        loginMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MainMenu.loginMenu();
            }
        });
        exit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MainMenu.exit();
            }
        });
        mainTable.setBounds(0, 0, graphics.getWidth(), graphics.getHeight());
        mainTable.add(username).center();
        mainTable.row();
        mainTable.add(avatar).width(50).height(50);
        mainTable.row();
        mainTable.add(newGame);
        mainTable.row();
        mainTable.add(previousGame);
        mainTable.row();
        mainTable.add(profileMenu);
        mainTable.row();
        mainTable.add(leaderboardMenu);
        mainTable.row();
        mainTable.add(settingMenu);
        mainTable.row();
        mainTable.add(loginMenu);
        mainTable.row();
        mainTable.add(exit);
        stage.addActor(mainTable);
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

        } else {
            assetManager.load("Text/Colored/Text.json", Skin.class);
            assetManager.load("Button/Colored/Button.json", Skin.class);
            assetManager.finishLoading();
            MenuScreen.text = assetManager.get("Text/Colored/Text.json");
            MenuScreen.button = assetManager.get("Button/Colored/Button.json");
        }
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }
}
