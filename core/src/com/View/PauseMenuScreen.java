package com.View;

import com.AtomicBomber;
import com.Control.PauseMenu;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import static com.badlogic.gdx.Gdx.graphics;

public class PauseMenuScreen extends MenuScreen {
    public PauseMenuScreen(AtomicBomber atomicBomber, GameMenuScreen gameMenuScreen) {
        super(atomicBomber);
        assetLoader();
        TextButton save = new TextButton("Save & Exit To Main Menu", button);
        TextButton exit = new TextButton("Exit To Main Menu", button);
        TextButton exitAll = new TextButton("Exit", button);
        TextButton pause = new TextButton("Pause Music", button);
        TextButton resume = new TextButton("Resume Game", button);
        Label guide = new Label("Up : Up Key & W\n" +
                "Down : Down Key & S\n" +
                "Right : Right Key & A\n" +
                "Left : Left Key & D\n" +
                "Clockwise : Numpad 8 & 6\n" +
                "Counterclockwise : Numpad 2 & 4\n" +
                "RegularBomb : Space\n" +
                "RadioactiveBomb : R\n" +
                "ClusterBomb : C\n" +
                "IceMode : Tab", text);
        guide.setAlignment(1, 1);
        TextButton music1 = new TextButton("Music1", button);
        TextButton music2 = new TextButton("Music2", button);
        TextButton music3 = new TextButton("Music3", button);
        Table table = new Table();
        table.add(music1);
        table.add(music2);
        table.add(music3);
        Table mainTable = new Table();
        mainTable.setBounds(0, 0, graphics.getWidth(), graphics.getHeight());
        mainTable.add(save);
        mainTable.row();
        mainTable.add(exit);
        mainTable.row();
        mainTable.add(exitAll);
        mainTable.row();
        mainTable.add(pause);
        mainTable.row();
        mainTable.add(resume);
        mainTable.row();
        mainTable.add(guide);
        mainTable.row();
        mainTable.add(table);
        save.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PauseMenu.save(gameMenuScreen);
                PauseMenu.mainMenu();
            }
        });
        exit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PauseMenu.mainMenu();
            }
        });
        exitAll.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PauseMenu.exit();
            }
        });
        pause.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PauseMenu.pause();
            }
        });
        resume.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PauseMenu.resume(gameMenuScreen);
            }
        });
        music1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PauseMenu.changeMusic(1);
            }
        });
        music2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PauseMenu.changeMusic(2);
            }
        });
        music3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PauseMenu.changeMusic(3);
            }
        });
        stage.addActor(MenuScreen.background);
        stage.addActor(mainTable);
    }

    public PauseMenuScreen(AtomicBomber atomicBomber, OldGameMenuScreen gameMenuScreen) {
        super(atomicBomber);
        assetLoader();
        TextButton save = new TextButton("Save & Exit To Main Menu", button);
        TextButton exit = new TextButton("Exit To Main Menu", button);
        TextButton exitAll = new TextButton("Exit", button);
        TextButton pause = new TextButton("Pause Music", button);
        TextButton resume = new TextButton("Resume Game", button);
        Label guide = new Label("Up : Up Key & W\n" +
                "Down : Down Key & S\n" +
                "Right : Right Key & A\n" +
                "Left : Left Key & D\n" +
                "Clockwise : Numpad 8 & 6\n" +
                "Counterclockwise : Numpad 2 & 4\n" +
                "RegularBomb : Space\n" +
                "RadioactiveBomb : R\n" +
                "ClusterBomb : C\n" +
                "IceMode : Tab", text);
        guide.setAlignment(1, 1);
        TextButton music1 = new TextButton("Music1", button);
        TextButton music2 = new TextButton("Music2", button);
        TextButton music3 = new TextButton("Music3", button);
        Table table = new Table();
        table.add(music1);
        table.add(music2);
        table.add(music3);
        Table mainTable = new Table();
        mainTable.setBounds(0, 0, graphics.getWidth(), graphics.getHeight());
        mainTable.add(save);
        mainTable.row();
        mainTable.add(exit);
        mainTable.row();
        mainTable.add(exitAll);
        mainTable.row();
        mainTable.add(pause);
        mainTable.row();
        mainTable.add(resume);
        mainTable.row();
        mainTable.add(guide);
        mainTable.row();
        mainTable.add(table);
        save.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PauseMenu.save(gameMenuScreen);
                PauseMenu.mainMenu();
            }
        });
        exit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PauseMenu.mainMenu();
            }
        });
        exitAll.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PauseMenu.exit();
            }
        });
        pause.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PauseMenu.pause();
            }
        });
        resume.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PauseMenu.resume(gameMenuScreen);
            }
        });
        music1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PauseMenu.changeMusic(1);
            }
        });
        music2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PauseMenu.changeMusic(2);
            }
        });
        music3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PauseMenu.changeMusic(3);
            }
        });
        stage.addActor(MenuScreen.background);
        stage.addActor(mainTable);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
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
            MenuScreen.background = new Image(new Texture("Background/B&W/Background.png"));
        } else {
            assetManager.load("Text/Colored/Text.json", Skin.class);
            assetManager.load("Button/Colored/Button.json", Skin.class);
            assetManager.finishLoading();
            MenuScreen.text = assetManager.get("Text/Colored/Text.json");
            MenuScreen.button = assetManager.get("Button/Colored/Button.json");
            MenuScreen.background = new Image(new Texture("Background/Colored/Background.png"));
        }
        MenuScreen.background.setHeight(graphics.getHeight());
        MenuScreen.background.setWidth(graphics.getWidth());
    }
}
