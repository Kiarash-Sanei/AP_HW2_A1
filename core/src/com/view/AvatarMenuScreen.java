package com.view;

import com.AtomicBomber;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.control.AvatarMenu;

import static com.badlogic.gdx.Gdx.graphics;

public class AvatarMenuScreen extends MenuScreen {
    private static Label message;
    private Image[] defaultAvatars;
    private TextField preferredAvatarPath;
    private TextButton preferredAvatarButton;
    private TextButton profileMenu;
    private TextButton exit;
    private Table mainTable;
    private Table table;

    //TODO: drag and drop.
    public AvatarMenuScreen(AtomicBomber atomicBomber) {
        super(atomicBomber);
        AssetManager assetManager = new AssetManager();
        assetManager.load("Button/Button.json", Skin.class);
        assetManager.load("DefaultAvatars/1.png", Texture.class);
        assetManager.load("DefaultAvatars/2.png", Texture.class);
        assetManager.load("DefaultAvatars/3.png", Texture.class);
        assetManager.load("DefaultAvatars/4.png", Texture.class);
        assetManager.load("Username/UsernameTextField.json", Skin.class);
        assetManager.finishLoading();
        Skin messageSkin = assetManager.get("Button/Button.json");
        Skin buttonSkin = assetManager.get("Button/Button.json");
        Skin textFieldSkin = assetManager.get("Username/UsernameTextField.json");
        message = new Label(AvatarMenuMessage.start.getString(), messageSkin);
        defaultAvatars = new Image[4];
        for (int i = 0; i < defaultAvatars.length; i++) {
            String path = "DefaultAvatars/" + (i + 1) + ".png";
            defaultAvatars[i] = new Image(new Texture(path));
            defaultAvatars[0].addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    AvatarMenu.changeAvatar(path);
                }
            });
        }
        preferredAvatarPath = new TextField("", textFieldSkin);
        preferredAvatarButton = new TextButton("Apply", buttonSkin);
        profileMenu = new TextButton("Profile Menu", buttonSkin);
        exit = new TextButton("Exit", buttonSkin);
        mainTable = new Table();
        table = new Table();
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
        stage.addActor(mainTable);
    }

    public static void setMessage(String message) {
        AvatarMenuScreen.message.setText(message);
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
