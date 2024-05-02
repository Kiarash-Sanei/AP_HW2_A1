package com.view;

import com.AtomicBomber;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.control.LoginMenu;
import com.control.MainMenu;
import com.model.User;

import static com.badlogic.gdx.Gdx.graphics;

public class MainMenuScreen extends MenuScreen {
    private Label username;
    private Image avatar;
    private TextButton newGame;
    private TextButton previousGame;
    private TextButton profileMenu;
    private TextButton leaderboardMenu;
    private TextButton settingMenu;
    private TextButton loginMenu;
    private TextButton exit;
    private Table mainTable;

    public MainMenuScreen(AtomicBomber atomicBomber) {
        super(atomicBomber);
        User user = User.getCurrentUser();
        AssetManager assetManager = new AssetManager();
        assetManager.load("Button/Button.json", Skin.class);
        assetManager.load(user.getAvatarPath(), Texture.class);
        assetManager.finishLoading();
        Skin buttonSkin = assetManager.get("Button/Button.json");
        username = new Label(user.getUsername(), buttonSkin);
        avatar = new Image(assetManager.get(user.getAvatarPath(), Texture.class));
        newGame = new TextButton("New Game", buttonSkin);
        previousGame = new TextButton("Previous Game", buttonSkin);
        profileMenu = new TextButton("Profile Menu", buttonSkin);
        leaderboardMenu = new TextButton("Leaderboard Menu", buttonSkin);
        settingMenu = new TextButton("Setting Menu", buttonSkin);
        loginMenu = new TextButton("Login Menu", buttonSkin);
        exit = new TextButton("Exit", buttonSkin);
        mainTable = new Table();
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
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }
}
