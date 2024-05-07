package com.view;

import com.AtomicBomber;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.control.SettingMenu;

import static com.badlogic.gdx.Gdx.graphics;

public class SettingScreen extends MenuScreen {
    private CheckBox mute;
    private CheckBox blackAndWhite;
    private Label up;
    private TextField upTextField;
    private Label down;
    private TextField downTextField;
    private Label right;
    private TextField rightTextField;
    private Label left;
    private TextField leftTextField;
    private Label regularBomb;
    private TextField regularBombTextField;
    private Label radioactiveBomb;
    private TextField radioactiveBombTextField;
    private Label clusterBomb;
    private TextField clusterBombTextField;
    private Label iceMode;
    private TextField iceModeTextField;
    private TextButton apply;
    private TextButton mainMenu;
    private TextButton exit;
    private Table mainTable;
    private Table upTable;
    private Table downTable;
    private Table rightTable;
    private Table leftTable;
    private Table regularBombTable;
    private Table radioactiveBombTable;
    private Table clusterBombTable;
    private Table iceModeTable;

    public SettingScreen(AtomicBomber atomicBomber) {
        super(atomicBomber);
        AssetManager assetManager = new AssetManager();
        assetManager.load("Button/Button.json", Skin.class);
        assetManager.load("Username/UsernameTextField.json", Skin.class);
        assetManager.finishLoading();
        Skin checkboxSkin = assetManager.get("Button/Button.json");
        Skin labelSkin = assetManager.get("Username/UsernameTextField.json");
        Skin textFieldSkin = assetManager.get("Username/UsernameTextField.json");
        Skin buttonSkin = assetManager.get("Button/Button.json");
        mute = new CheckBox("Mute", checkboxSkin);
        blackAndWhite = new CheckBox("Black And White", checkboxSkin);
        up = new Label("Up: W/Up Arrow\t", labelSkin);
        upTextField = new TextField("", textFieldSkin);
        down = new Label("Down: S/Down Arrow\t", labelSkin);
        downTextField = new TextField("", textFieldSkin);
        right = new Label("Right: D/Right Arrow\t", labelSkin);
        rightTextField = new TextField("", textFieldSkin);
        left = new Label("Left: A/Left Arrow\t", labelSkin);
        leftTextField = new TextField("", textFieldSkin);
        regularBomb = new Label("Regular Bomb: Space\t", labelSkin);
        regularBombTextField = new TextField("", textFieldSkin);
        radioactiveBomb = new Label("Radioactive Bomb: R\t", labelSkin);
        radioactiveBombTextField = new TextField("", textFieldSkin);
        clusterBomb = new Label("Cluster Bomb: C\t", labelSkin);
        clusterBombTextField = new TextField("", textFieldSkin);
        iceMode = new Label("Ice Mode: Tab\t", labelSkin);
        iceModeTextField = new TextField("", textFieldSkin);
        apply = new TextButton("Apply", buttonSkin);
        mainMenu = new TextButton("Main Menu", buttonSkin);
        exit = new TextButton("Exit", buttonSkin);
        mainTable = new Table();
        upTable = new Table();
        downTable = new Table();
        rightTable = new Table();
        leftTable = new Table();
        regularBombTable = new Table();
        radioactiveBombTable = new Table();
        clusterBombTable = new Table();
        iceModeTable = new Table();
        mute.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
        blackAndWhite.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
        upTextField.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
        downTextField.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
        rightTextField.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
        leftTextField.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
        regularBombTextField.addListener(new ClickListener() {
            @Override
            public boolean keyTyped(InputEvent event, char character) {
                return true;
            }
        });
        radioactiveBombTextField.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
        clusterBombTextField.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
        iceModeTextField.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
        apply.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

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
        mainTable.add(apply);
        mainTable.row();
        mainTable.add(mainMenu);
        mainTable.row();
        mainTable.add(exit);
        mainTable.row();
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
