package com.View;

import com.AtomicBomber;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.Control.SettingMenu;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import static com.badlogic.gdx.Gdx.graphics;

public class SettingScreen extends MenuScreen {
    public SettingScreen(AtomicBomber atomicBomber) {
        super(atomicBomber);
        assetLoader();
        CheckBox mute = new CheckBox("Mute", MenuScreen.checkBox);
        if (isMute)
            mute.setChecked(true);
        CheckBox blackAndWhite = new CheckBox("Black And White", MenuScreen.checkBox);
        if (isBlackAndWhite)
            blackAndWhite.setChecked(true);
        Label up = new Label("Up: W/Up Arrow\t", MenuScreen.text);
        TextField upTextField = new TextField("", MenuScreen.textField);
        Label down = new Label("Down: S/Down Arrow\t", MenuScreen.text);
        TextField downTextField = new TextField("", MenuScreen.textField);
        Label right = new Label("Right: D/Right Arrow\t", MenuScreen.text);
        TextField rightTextField = new TextField("", MenuScreen.textField);
        Label left = new Label("Left: A/Left Arrow\t", MenuScreen.text);
        TextField leftTextField = new TextField("", MenuScreen.textField);
        Label regularBomb = new Label("Regular Bomb: Space\t", MenuScreen.text);
        TextField regularBombTextField = new TextField("", MenuScreen.textField);
        Label radioactiveBomb = new Label("Radioactive Bomb: R\t", MenuScreen.text);
        TextField radioactiveBombTextField = new TextField("", MenuScreen.textField);
        Label clusterBomb = new Label("Cluster Bomb: C\t", MenuScreen.text);
        TextField clusterBombTextField = new TextField("", MenuScreen.textField);
        Label iceMode = new Label("Ice Mode: Tab\t", MenuScreen.text);
        TextField iceModeTextField = new TextField("", MenuScreen.textField);
        TextButton mainMenu = new TextButton("Main Menu", MenuScreen.button);
        TextButton exit = new TextButton("Exit", MenuScreen.button);
        Table mainTable = new Table();
        Table upTable = new Table();
        Table downTable = new Table();
        Table rightTable = new Table();
        Table leftTable = new Table();
        Table regularBombTable = new Table();
        Table radioactiveBombTable = new Table();
        Table clusterBombTable = new Table();
        Table iceModeTable = new Table();
        mute.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SettingMenu.changeMute();
            }
        });
        blackAndWhite.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SettingMenu.changeColorMode();
            }
        });
        upTextField.addListener(new ClickListener() {
            @Override
            public boolean keyTyped(InputEvent event, char character) {
                SettingMenu.addUp(event);
                return true;
            }
        });
        downTextField.addListener(new ClickListener() {
            @Override
            public boolean keyTyped(InputEvent event, char character) {
                SettingMenu.addDown(event);
                return true;
            }
        });
        rightTextField.addListener(new ClickListener() {
            @Override
            public boolean keyTyped(InputEvent event, char character) {
                SettingMenu.addRight(event);
                return true;
            }
        });
        leftTextField.addListener(new ClickListener() {
            @Override
            public boolean keyTyped(InputEvent event, char character) {
                SettingMenu.addLeft(event);
                return true;
            }
        });
        regularBombTextField.addListener(new ClickListener() {
            @Override
            public boolean keyTyped(InputEvent event, char character) {
                SettingMenu.addRegularBomb(event);
                return true;
            }
        });
        radioactiveBombTextField.addListener(new ClickListener() {
            @Override
            public boolean keyTyped(InputEvent event, char character) {
                SettingMenu.addRadioactiveBomb(event);
                return true;
            }
        });
        clusterBombTextField.addListener(new ClickListener() {
            @Override
            public boolean keyTyped(InputEvent event, char character) {
                SettingMenu.addClusterBomb(event);
                return true;
            }
        });
        iceModeTextField.addListener(new ClickListener() {
            @Override
            public boolean keyTyped(InputEvent event, char character) {
                SettingMenu.addIceMode(event);
                return true;
            }
        });
        mainMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SettingMenu.mainMenu();
            }
        });
        exit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SettingMenu.exit();
            }
        });
        mainTable.setBounds(0, 0, graphics.getWidth(), graphics.getHeight());
        mainTable.add(mute);
        mainTable.row();
        mainTable.add(blackAndWhite);
        mainTable.row();
        upTable.add(up);
        upTable.add(upTextField);
        mainTable.add(upTable);
        mainTable.row();
        downTable.add(down);
        downTable.add(downTextField);
        mainTable.add(downTable);
        mainTable.row();
        rightTable.add(right);
        rightTable.add(rightTextField);
        mainTable.add(rightTable);
        mainTable.row();
        leftTable.add(left);
        leftTable.add(leftTextField);
        mainTable.add(leftTable);
        mainTable.row();
        regularBombTable.add(regularBomb);
        regularBombTable.add(regularBombTextField);
        mainTable.add(regularBombTable);
        mainTable.row();
        radioactiveBombTable.add(radioactiveBomb);
        radioactiveBombTable.add(radioactiveBombTextField);
        mainTable.add(radioactiveBombTable);
        mainTable.row();
        clusterBombTable.add(clusterBomb);
        clusterBombTable.add(clusterBombTextField);
        mainTable.add(clusterBombTable);
        mainTable.row();
        iceModeTable.add(iceMode);
        iceModeTable.add(iceModeTextField);
        mainTable.add(iceModeTable);
        mainTable.row();
        mainTable.add(mainMenu);
        mainTable.row();
        mainTable.add(exit);
        mainTable.row();
        stage.addActor(MenuScreen.background);
        stage.addActor(mainTable);
    }

    @Override
    public void assetLoader() {
        settingUpdater();
        AssetManager assetManager = new AssetManager();
        if (isBlackAndWhite) {
            assetManager.load("Text/B&W/Text.json", Skin.class);
            assetManager.load("Button/B&W/Button.json", Skin.class);
            assetManager.load("CheckBox/B&W/CheckBox.json", Skin.class);
            assetManager.load("TextField/B&W/TextField.json", Skin.class);
            assetManager.finishLoading();
            MenuScreen.text = assetManager.get("Text/B&W/Text.json");
            MenuScreen.button = assetManager.get("Button/B&W/Button.json");
            MenuScreen.checkBox = assetManager.get("CheckBox/B&W/CheckBox.json");
            MenuScreen.textField = assetManager.get("TextField/B&W/TextField.json");
            MenuScreen.background = new Image(new Texture("Background/B&W/Background.png"));
            MenuScreen.background.setHeight(graphics.getHeight());
            MenuScreen.background.setWidth(graphics.getWidth());
        } else {
            assetManager.load("Text/Colored/Text.json", Skin.class);
            assetManager.load("Button/Colored/Button.json", Skin.class);
            assetManager.load("CheckBox/Colored/CheckBox.json", Skin.class);
            assetManager.load("TextField/Colored/TextField.json", Skin.class);
            assetManager.finishLoading();
            MenuScreen.text = assetManager.get("Text/Colored/Text.json");
            MenuScreen.button = assetManager.get("Button/Colored/Button.json");
            MenuScreen.checkBox = assetManager.get("CheckBox/Colored/CheckBox.json");
            MenuScreen.textField = assetManager.get("TextField/Colored/TextField.json");
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
