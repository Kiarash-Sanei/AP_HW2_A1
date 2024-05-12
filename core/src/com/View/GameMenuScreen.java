package com.View;

import com.AtomicBomber;
import com.Control.GameMenu;
import com.Model.GameObjects.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.Model.*;

import java.util.ArrayList;
import java.util.Random;

import static com.badlogic.gdx.Gdx.graphics;

public class GameMenuScreen extends MenuScreen {
    private final Wave wave;
    private final User user;
    private final Plane plane;
    private final ArrayList<Building> buildings;
    private final ArrayList<Mig> migs;
    private final ArrayList<Tank> tanks;
    private final ArrayList<Tree> trees;
    private final ArrayList<Trench> trenches;
    private final ArrayList<Truck> trucks;
    private final ArrayList<Bonus> bonuses;
    private static boolean iceMode;
    private static boolean nextWave;//TODO: change Key handling.
    private final SpriteBatch batch;
    private final Label waveMessage;
    private float waveMessageTimer;


    public GameMenuScreen(AtomicBomber atomicBomber, Wave wave) {
        super(atomicBomber);
        assetLoader();
        switch (wave) {
            case first:
                this.waveMessage = new Label("WAVE 1", text);
                break;
            case second:
                this.waveMessage = new Label("WAVE 2", text);
                break;
            case third:
                this.waveMessage = new Label("WAVE 3", text);
                break;
            default:
                this.waveMessage = null;
        }
        waveMessageTimer = 0;
        waveMessage.setFontScale(5);
        Table waveTable = new Table();
        waveTable.setBounds(0, 0, graphics.getWidth(), graphics.getHeight());
        waveTable.add(waveMessage);
        this.wave = wave;
        iceMode = false;
        nextWave = false;
        int x;
        Random random = new Random();
        user = User.getCurrentUser();
        plane = new Plane((float) graphics.getWidth() / 2 - GameObjects.Plane.getWidth() / 2,
                (float) graphics.getHeight() / 2 - GameObjects.Plane.getHeight() / 2, user.getSetting());
        buildings = new ArrayList<>();
        for (int i = 0; i < wave.getBuilding(); i++) {
            x = random.nextInt((int) (graphics.getWidth() - GameObjects.Mig.getWidth()));
            buildings.add(new Building(x, 0));
        }
        migs = new ArrayList<>();
        for (int i = 0; i < wave.getMig(); i++) {
            x = random.nextInt((int) (GameObjects.Mig.getHeight() * 5), (int) (graphics.getHeight() - GameObjects.Mig.getHeight()));
            migs.add(new Mig(-GameObjects.Mig.getWidth(), x, user.getSetting()));
        }
        tanks = new ArrayList<>();
        for (int i = 0; i < wave.getTank(); i++)
            tanks.add(new Tank(0, 0, user.getSetting()));
        trees = new ArrayList<>();
        for (int i = 0; i < wave.getTree(); i++) {
            x = random.nextInt((int) (graphics.getWidth() - GameObjects.Tree.getWidth()));
            trees.add(new Tree(x, 0));
        }
        trenches = new ArrayList<>();
        for (int i = 0; i < wave.getTrench(); i++) {
            x = random.nextInt((int) (graphics.getWidth() - GameObjects.Trench.getWidth()));
            trenches.add(new Trench(x, 0));
        }
        trucks = new ArrayList<>();
        for (int i = 0; i < wave.getTruck(); i++)
            trucks.add(new Truck(0, 0));
        bonuses = new ArrayList<>();
        stage.addListener(new ClickListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                return plane.keyDown(keycode);
            }

            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                return plane.keyUp(keycode);
            }
        });
        batch = new SpriteBatch();
        stage.addActor(MenuScreen.background);
        stage.addActor(waveTable);
    }

    @Override
    public void assetLoader() {
        settingUpdater();
        AssetManager assetManager = new AssetManager();
        if (isBlackAndWhite) {
            assetManager.load("Text/B&W/Text.json", Skin.class);
            assetManager.finishLoading();
            MenuScreen.text = assetManager.get("Text/B&W/Text.json");
            MenuScreen.background = new Image(new Texture("Background/B&W/Sky.png"));
        } else {
            assetManager.load("Text/Colored/Text.json", Skin.class);
            assetManager.finishLoading();
            MenuScreen.text = assetManager.get("Text/Colored/Text.json");
            MenuScreen.background = new Image(new Texture("Background/Colored/Sky.png"));
        }
        MenuScreen.background.setHeight(graphics.getHeight());
        MenuScreen.background.setWidth(graphics.getWidth());
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        if (!buildings.isEmpty()) {
            ArrayList<Float> buildingBonuses = GameMenu.buildingCollision(buildings, plane);
            for (Float x : buildingBonuses)
                bonuses.add(new Bonus(x, Prize.radioactiveBomb));
        }
        if (!trenches.isEmpty()) {
            ArrayList<Float> trenchBonuses = GameMenu.trenchCollision(trenches, plane);
            for (Float x : trenchBonuses)
                bonuses.add(new Bonus(x, Prize.clusterBomb));
        }
        if (!tanks.isEmpty()) {
            GameMenu.tankCollision(tanks, plane);
            for (Tank tank : tanks)
                tank.update(delta, iceMode);
        }
        if (!trucks.isEmpty()) {
            GameMenu.truckCollision(trucks, plane);
            for (Truck truck : trucks)
                truck.update(delta, iceMode);
        }
        if (!trees.isEmpty())
            GameMenu.treeCollision(trees, plane);
        if (!migs.isEmpty()) {
            GameMenu.migCollision(migs, plane);
            for (Mig mig : migs)
                mig.update(delta);
        }
        if (!bonuses.isEmpty()) {
            GameMenu.bonusCollision(bonuses, plane);
            for (Bonus bonus : bonuses)
                bonus.update(delta);
        }
        plane.update(delta);
        super.render(delta);
        batch.begin();
        plane.draw(batch);
        if (!buildings.isEmpty())
            for (Building building : buildings)
                building.draw(batch);
        if (!migs.isEmpty())
            for (Mig mig : migs)
                mig.draw(batch);
        if (!tanks.isEmpty())
            for (Tank tank : tanks)
                tank.draw(batch, iceMode);
        if (!trees.isEmpty())
            for (Tree tree : trees)
                tree.draw(batch);
        if (!trenches.isEmpty())
            for (Trench trench : trenches)
                trench.draw(batch);
        if (!trucks.isEmpty())
            for (Truck truck : trucks)
                truck.draw(batch, iceMode);
        if (!bonuses.isEmpty())
            for (Bonus bonus : bonuses)
                bonus.draw(batch);
        batch.end();
        plane.removeIf();
        tanks.removeIf(tank -> !tank.getIsAlive());
        trees.removeIf(tree -> !tree.getIsAlive());
        trenches.removeIf(trench -> !trench.getIsAlive());
        trucks.removeIf(truck -> !truck.getIsAlive());
        migs.removeIf(mig -> !mig.getIsAlive());
        buildings.removeIf(building -> !building.getIsAlive());
        bonuses.removeIf(bonus -> !bonus.getIsAlive());
        waveMessageTimer += delta;
        if (waveMessageTimer > 5)
            waveMessage.setText("");
        if (this.waveOver()) {
            GameMenu.changeWave(wave);
        }
    }

    private boolean waveOver() {
        return (buildings.isEmpty() &&
                migs.isEmpty() &&
                tanks.isEmpty() &&
                trees.isEmpty() &&
                trenches.isEmpty() &&
                trucks.isEmpty()) || nextWave;
    }

    public static void setIceMode(boolean iceMode) {
        GameMenuScreen.iceMode = iceMode;
    }

    public static boolean getIceMode() {
        return GameMenuScreen.iceMode;
    }
    public static void nextWave() {
        GameMenuScreen.nextWave = true;
    }
}
