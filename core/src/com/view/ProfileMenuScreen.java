package com.view;

import com.AtomicBomber;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.control.ProfileMenu;

import static com.badlogic.gdx.Gdx.graphics;

public class ProfileMenuScreen extends MenuScreen {
    private static Label usernameMessage;
    private TextField username;
    private TextButton changeUsername;
    private static Label passwordMessage;
    private TextField password;
    private TextButton changePassword;
    private TextButton deleteAccount;
    private TextButton logout;
    private TextButton avatarMenu;
    private TextButton mainMenu;
    private TextButton exit;
    private Table mainTable;

    public ProfileMenuScreen(AtomicBomber atomicBomber) {
        super(atomicBomber);
        AssetManager assetManager = new AssetManager();
        assetManager.load("Button/Button.json", Skin.class);
        assetManager.load("Username/UsernameTextField.json", Skin.class);
        assetManager.load("Password/PasswordTextField.json", Skin.class);
        assetManager.finishLoading();
        Skin messageSkin = assetManager.get("Button/Button.json");
        Skin usernameSkin = assetManager.get("Username/UsernameTextField.json");
        Skin buttonSkin = assetManager.get("Button/Button.json");
        Skin passwordSkin = assetManager.get("Password/PasswordTextField.json");
        usernameMessage = new Label(ProfileMenuMessage.usernameStart.getString(), messageSkin);
        username = new TextField("", usernameSkin,"login");
        changeUsername = new TextButton("Change Username", buttonSkin);
        passwordMessage = new Label(ProfileMenuMessage.passwordStart.getString(), messageSkin);
        password = new TextField("", passwordSkin,"password");
        password.setPasswordMode(true);
        password.setPasswordCharacter('*');
        changePassword = new TextButton("Change Password", buttonSkin);
        deleteAccount = new TextButton("Delete Account", buttonSkin);
        logout = new TextButton("Logout", buttonSkin);
        avatarMenu = new TextButton("Avatar Menu", buttonSkin);
        mainMenu = new TextButton("Main Menu", buttonSkin);
        exit = new TextButton("Exit", buttonSkin);
        mainTable = new Table();
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
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }
}
