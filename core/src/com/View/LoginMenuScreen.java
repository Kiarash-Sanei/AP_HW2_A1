package com.View;

import com.AtomicBomber;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.Control.LoginMenu;

import static com.badlogic.gdx.Gdx.graphics;

public class LoginMenuScreen extends MenuScreen {
    private final TextField username;
    private final TextField password;
    private final TextButton register;
    private final TextButton login;
    private final TextButton skip;
    private final TextButton exit;
    private final Table mainTable;
    private final Table table;
    private static Label message;

    public LoginMenuScreen(AtomicBomber atomicBomber) {
        super(atomicBomber);
        assetLoader();
        username = new TextField("", MenuScreen.username, "login");
        password = new TextField("", MenuScreen.password, "password");
        password.setPasswordMode(true);
        password.setPasswordCharacter('*');
        register = new TextButton("Register", MenuScreen.button);
        login = new TextButton("Login", MenuScreen.button);
        skip = new TextButton("Skip", MenuScreen.button);
        exit = new TextButton("Exit", MenuScreen.button);
        message = new Label(LoginMenuMessage.start.getString(), MenuScreen.text);
        mainTable = new Table();
        table = new Table();
        register.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                LoginMenu.register(username.getText(), password.getText());
                username.setText("");
                password.setText("");
            }
        });
        login.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                LoginMenu.login(username.getText(), password.getText());
            }
        });
        skip.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                LoginMenu.skip();
            }
        });
        exit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                LoginMenu.exit();
            }
        });
        mainTable.setBounds(0, 0, graphics.getWidth(), graphics.getHeight());
        table.add(username).width(200);
        table.add(password).width(200);
        mainTable.add(message);
        mainTable.row();
        mainTable.add(table);
        mainTable.row();
        mainTable.add(register);
        mainTable.row();
        mainTable.add(login);
        mainTable.row();
        mainTable.add(skip);
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
            assetManager.load("Username/B&W/UsernameTextField.json", Skin.class);
            assetManager.load("Password/B&W/PasswordTextField.json", Skin.class);
            assetManager.finishLoading();
            MenuScreen.text = assetManager.get("Text/B&W/Text.json");
            MenuScreen.button = assetManager.get("Button/B&W/Button.json");
            MenuScreen.username = assetManager.get("Username/B&W/UsernameTextField.json");
            MenuScreen.password = assetManager.get("Password/B&W/PasswordTextField.json");

        } else {
            assetManager.load("Text/Colored/Text.json", Skin.class);
            assetManager.load("Button/Colored/Button.json", Skin.class);
            assetManager.load("Username/Colored/UsernameTextField.json", Skin.class);
            assetManager.load("Password/Colored/PasswordTextField.json", Skin.class);
            assetManager.finishLoading();
            MenuScreen.text = assetManager.get("Text/Colored/Text.json");
            MenuScreen.button = assetManager.get("Button/Colored/Button.json");
            MenuScreen.username = assetManager.get("Username/Colored/UsernameTextField.json");
            MenuScreen.password = assetManager.get("Password/Colored/PasswordTextField.json");
        }
    }

    public static void setMessage(String message) {
        LoginMenuScreen.message.setText(message);
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
