package com.view;

import com.AtomicBomber;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.control.LeaderboardMenu;

import static com.badlogic.gdx.Gdx.graphics;

public class LeaderboardMenuScreen extends MenuScreen {
    private TextButton regularRanking;
    private TextButton waveRanking;
    private TextButton killRanking;
    private TextButton accuracyRanking;
    private static Label[] usernames;
    private TextButton mainMenu;
    private TextButton exit;
    private Table mainTable;
    private Table table;

    public LeaderboardMenuScreen(AtomicBomber atomicBomber) {
        super(atomicBomber);
        AssetManager assetManager = new AssetManager();
        assetManager.load("Button/Button.json", Skin.class);
        assetManager.load("Username/UsernameTextField.json", Skin.class);
        assetManager.finishLoading();
        Skin buttonSkin = assetManager.get("Button/Button.json");
        regularRanking = new TextButton("Regular Ranking", buttonSkin);
        waveRanking = new TextButton("Wave Ranking", buttonSkin);
        killRanking = new TextButton("Kill Ranking", buttonSkin);
        accuracyRanking = new TextButton("Accuracy Ranking", buttonSkin);
        usernames = new Label[10];
        for (int i = 0; i < 10; i++)
            usernames[i] = new Label("", buttonSkin);
        mainMenu = new TextButton("Main Menu", buttonSkin);
        exit = new TextButton("Exit", buttonSkin);
        mainTable = new Table();
        table = new Table();
        regularRanking.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                LeaderboardMenu.regularRanking();
            }
        });
        waveRanking.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                LeaderboardMenu.waveRaking();
            }
        });
        killRanking.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                LeaderboardMenu.killRanking();
            }
        });
        accuracyRanking.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                LeaderboardMenu.accuracyRanking();
            }
        });
        mainMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                LeaderboardMenu.mainMenu();
            }
        });
        exit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                LeaderboardMenu.exit();
            }
        });
        mainTable.setBounds(0, 0, graphics.getWidth(), graphics.getHeight());
        table.add(regularRanking);
        table.add(waveRanking);
        table.add(killRanking);
        table.add(accuracyRanking);
        mainTable.add(table);
        mainTable.row();
        for (int i = 0; i < 10; i++) {
            mainTable.add(usernames[i]);
            mainTable.row();
        }
        mainTable.add(mainMenu);
        mainTable.row();
        mainTable.add(exit);
        stage.addActor(mainTable);
    }

    public static void setRaking(String[] usernames) {
        for (int i = 0; i < 10; i++)
            LeaderboardMenuScreen.usernames[i].setText(usernames[i]);
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
