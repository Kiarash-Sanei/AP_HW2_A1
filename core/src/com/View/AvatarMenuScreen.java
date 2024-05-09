package com.View;

import com.AtomicBomber;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.Control.AvatarMenu;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import static com.badlogic.gdx.Gdx.graphics;

public class AvatarMenuScreen extends MenuScreen {
    private static Label message;
    private final TextField preferredAvatarPath;

    //TODO: drag and drop.
    public AvatarMenuScreen(AtomicBomber atomicBomber) {
        super(atomicBomber);
        assetLoader();
        message = new Label(AvatarMenuMessage.start.getString(), MenuScreen.text);
        Image[] defaultAvatars = new Image[4];
        for (int i = 0; i < defaultAvatars.length; i++) {
            String path = "DefaultAvatars/" + (i + 1) + ".png";
            defaultAvatars[i] = new Image(new Texture(path));
            if (isBlackAndWhite)
                defaultAvatars[i].setColor(1, 1, 1, 1);
            defaultAvatars[0].addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    AvatarMenu.changeAvatar(path);
                }
            });
        }
        preferredAvatarPath = new TextField("", MenuScreen.textField);
        TextButton preferredAvatarButton = new TextButton("Apply", MenuScreen.button);
        TextButton profileMenu = new TextButton("Profile Menu", MenuScreen.button);
        TextButton exit = new TextButton("Exit", MenuScreen.button);
        Table mainTable = new Table();
        Table table = new Table();
        preferredAvatarButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                AvatarMenu.changeAvatar(preferredAvatarPath.getText());
            }
        });
        profileMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                AvatarMenu.profileMenu();
            }
        });
        exit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                AvatarMenu.exit();
            }
        });
        mainTable.setBounds(0, 0, graphics.getWidth(), graphics.getHeight());
        mainTable.add(message);
        mainTable.row();
        for (Image defaultAvatar : defaultAvatars)
            table.add(defaultAvatar).width(100).height(100);
        mainTable.add(table);
        mainTable.row();
        mainTable.add(preferredAvatarPath);
        mainTable.row();
        mainTable.add(preferredAvatarButton);
        mainTable.row();
        mainTable.add(profileMenu);
        mainTable.row();
        mainTable.add(exit);
        mainTable.row();
        stage.addActor(MenuScreen.background);
        stage.addActor(mainTable);
    }

    public static void setMessage(String message) {
        AvatarMenuScreen.message.setText(message);
    }

    @Override
    public void assetLoader() {
        settingUpdater();
        AssetManager assetManager = new AssetManager();
        if (isBlackAndWhite) {
            assetManager.load("Text/B&W/Text.json", Skin.class);
            assetManager.load("DefaultAvatars/1.png", Texture.class);
            assetManager.load("DefaultAvatars/2.png", Texture.class);
            assetManager.load("DefaultAvatars/3.png", Texture.class);
            assetManager.load("DefaultAvatars/4.png", Texture.class);
            assetManager.load("TextField/B&W/TextField.json", Skin.class);
            assetManager.load("Button/B&W/Button.json", Skin.class);
            assetManager.finishLoading();
            MenuScreen.text = assetManager.get("Text/B&W/Text.json");
            MenuScreen.button = assetManager.get("Button/B&W/Button.json");
            MenuScreen.textField = assetManager.get("Username/B&W/UsernameTextField.json");
            MenuScreen.background = new Image(new Texture("Background/B&W/Background.png"));
            MenuScreen.background.setHeight(graphics.getHeight());
            MenuScreen.background.setWidth(graphics.getWidth());
        } else {
            assetManager.load("Text/Colored/Text.json", Skin.class);
            assetManager.load("DefaultAvatars/1.png", Texture.class);
            assetManager.load("DefaultAvatars/2.png", Texture.class);
            assetManager.load("DefaultAvatars/3.png", Texture.class);
            assetManager.load("DefaultAvatars/4.png", Texture.class);
            assetManager.load("TextField/Colored/TextField.json", Skin.class);
            assetManager.load("Button/Colored/Button.json", Skin.class);
            assetManager.finishLoading();
            MenuScreen.text = assetManager.get("Text/Colored/Text.json");
            MenuScreen.button = assetManager.get("Button/Colored/Button.json");
            MenuScreen.textField = assetManager.get("Username/Colored/UsernameTextField.json");
            MenuScreen.background = new Image(new Texture("Background/Colored/Background.png"));
            MenuScreen.background.setHeight(graphics.getHeight());
            MenuScreen.background.setWidth(graphics.getWidth());
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
