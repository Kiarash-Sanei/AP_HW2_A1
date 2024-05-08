package com.View;

import com.AtomicBomber;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.Control.ProfileMenu;

import static com.badlogic.gdx.Gdx.graphics;

public class ProfileMenuScreen extends MenuScreen {
    private static Label usernameMessage;
    private final TextField username;
    private static Label passwordMessage;
    private final TextField password;

    public ProfileMenuScreen(AtomicBomber atomicBomber) {
        super(atomicBomber);
        assetLoader();
        usernameMessage = new Label(ProfileMenuMessage.usernameStart.getString(), MenuScreen.text);
        username = new TextField("", MenuScreen.username, "login");
        TextButton changeUsername = new TextButton("Change Username", MenuScreen.button);
        passwordMessage = new Label(ProfileMenuMessage.passwordStart.getString(), MenuScreen.text);
        password = new TextField("", MenuScreen.password, "password");
        password.setPasswordMode(true);
        password.setPasswordCharacter('*');
        TextButton changePassword = new TextButton("Change Password", MenuScreen.button);
        TextButton deleteAccount = new TextButton("Delete Account", MenuScreen.button);
        TextButton logout = new TextButton("Logout", MenuScreen.button);
        TextButton avatarMenu = new TextButton("Avatar Menu", MenuScreen.button);
        TextButton mainMenu = new TextButton("Main Menu", MenuScreen.button);
        TextButton exit = new TextButton("Exit", MenuScreen.button);
        Table mainTable = new Table();
        changeUsername.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ProfileMenu.changeUsername(username.getText());
            }
        });
        changePassword.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ProfileMenu.changePassword(password.getText());
            }
        });
        deleteAccount.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ProfileMenu.deleteAccount();
            }
        });
        logout.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ProfileMenu.logout();
            }
        });
        avatarMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ProfileMenu.avatarMenu();
            }
        });
        mainMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ProfileMenu.mainMenu();
            }
        });
        exit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ProfileMenu.exit();
            }
        });
        mainTable.setBounds(0, 0, graphics.getWidth(), graphics.getHeight());
        mainTable.add(usernameMessage);
        mainTable.row();
        mainTable.add(username);
        mainTable.row();
        mainTable.add(changeUsername);
        mainTable.row();
        mainTable.add(passwordMessage);
        mainTable.row();
        mainTable.add(password);
        mainTable.row();
        mainTable.add(changePassword);
        mainTable.row();
        mainTable.add(deleteAccount);
        mainTable.row();
        mainTable.add(logout);
        mainTable.row();
        mainTable.add(avatarMenu);
        mainTable.row();
        mainTable.add(mainMenu);
        mainTable.row();
        mainTable.add(exit);
        stage.addActor(mainTable);
    }

    public static void setUsernameMessage(String message) {
        usernameMessage.setText(message);
    }

    public static void setPasswordMessage(String message) {
        passwordMessage.setText(message);
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

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }
}
