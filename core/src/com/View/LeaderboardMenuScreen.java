package com.View;

import com.AtomicBomber;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.Control.LeaderboardMenu;

import static com.badlogic.gdx.Gdx.graphics;

public class LeaderboardMenuScreen extends MenuScreen {
    private static Label[] usernames;

    public LeaderboardMenuScreen(AtomicBomber atomicBomber) {
        super(atomicBomber);
        assetLoader();
        TextButton regularRanking = new TextButton("Regular Ranking", MenuScreen.button);
        TextButton waveRanking = new TextButton("Wave Ranking", MenuScreen.button);
        TextButton killRanking = new TextButton("Kill Ranking", MenuScreen.button);
        TextButton accuracyRanking = new TextButton("Accuracy Ranking", MenuScreen.button);
        usernames = new Label[10];
        for (int i = 0; i < 10; i++)
            usernames[i] = new Label("", MenuScreen.text);
        if (!isBlackAndWhite) {
            usernames[0].setColor(Color.GOLD);
            usernames[1].setColor(Color.GRAY);
            usernames[2].setColor(Color.BROWN);//TODO: change this colors.
        }
        TextButton mainMenu = new TextButton("Main Menu", MenuScreen.button);
        TextButton exit = new TextButton("Exit", MenuScreen.button);
        Table mainTable = new Table();
        Table table = new Table();
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

    @Override
    public void assetLoader() {
        settingUpdater();
        AssetManager assetManager = new AssetManager();
        if (isBlackAndWhite) {
            assetManager.load("Text/B&W/Text.json", Skin.class);
            assetManager.load("Button/B&W/Button.json", Skin.class);
            assetManager.finishLoading();
            MenuScreen.text = assetManager.get("Text/B&W/Text.json");
            MenuScreen.button = assetManager.get("Button/B&W/Button.json");

        } else {
            assetManager.load("Text/Colored/Text.json", Skin.class);
            assetManager.load("Button/Colored/Button.json", Skin.class);
            assetManager.finishLoading();
            MenuScreen.text = assetManager.get("Text/Colored/Text.json");
            MenuScreen.button = assetManager.get("Button/Colored/Button.json");
        }
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
