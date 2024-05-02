package com.view;

import com.AtomicBomber;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.control.LoginMenu;

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
    private Image BackGround;
    private static Label message;

    public LoginMenuScreen(AtomicBomber atomicBomber) {
        super(atomicBomber);
        AssetManager assetManager = new AssetManager();
        assetManager.load("Username/UsernameTextField.json", Skin.class);
        assetManager.load("Password/PasswordTextField.json", Skin.class);
        assetManager.load("Button/Button.json", Skin.class);
        assetManager.finishLoading();
        Skin usernameSkin = assetManager.get("Username/UsernameTextField.json");
        Skin passwordSkin = assetManager.get("Password/PasswordTextField.json");
        Skin buttonSkin = assetManager.get("Button/Button.json");
//        BackGround = new Image(new Texture("LoginMenuBackground.jpg"));
//        BackGround.setWidth(graphics.getWidth());
//        BackGround.setHeight(graphics.getHeight());
//        stage.addActor(BackGround);
        username = new TextField("", usernameSkin, "login");
        password = new TextField("", passwordSkin, "password");
        password.setPasswordMode(true);
        password.setPasswordCharacter('*');
        register = new TextButton("Register", buttonSkin);
        login = new TextButton("Login", buttonSkin);
        skip = new TextButton("Skip", buttonSkin);
        exit = new TextButton("Exit", buttonSkin);
        message = new Label(LoginMenuMassage.start.getString(), usernameSkin);
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
