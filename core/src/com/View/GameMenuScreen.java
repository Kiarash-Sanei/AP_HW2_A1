package com.View;

import com.AtomicBomber;
import com.Control.GameMenu;
import com.Model.GameObjects.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
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
    private final SpriteBatch batch;

    public GameMenuScreen(AtomicBomber atomicBomber, Wave wave) {
        super(atomicBomber);
        this.wave = wave;
        assetLoader();
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
    }

    @Override
    public void assetLoader() {
        settingUpdater();
        if (isBlackAndWhite)
            MenuScreen.background = new Image(new Texture("Background/B&W/Sky.png"));
        else
            MenuScreen.background = new Image(new Texture("Background/Colored/Sky.png"));
        MenuScreen.background.setHeight(graphics.getHeight());
        MenuScreen.background.setWidth(graphics.getWidth());
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        GameObject[] collied = GameMenu.collision();
        if (collied != null) {
            if (collied[0].getClass() == Building.class) {
                bonuses.add(new Bonus(collied[0].getX() + GameObjects.getWidth(collied[0]) / 2 - GameObjects.Bonus.getWidth() / 2,
                        collied[0].getY() + GameObjects.Building.getHeight() + 100));
            }
            if (collied[0].getClass() == Trench.class) {
                bonuses.add(new Bonus(collied[0].getX() + GameObjects.getWidth(collied[0]) / 2 - GameObjects.Bonus.getWidth() / 2,
                        collied[0].getY() + GameObjects.Trench.getHeight() + 220));
            }
        }
        ScreenUtils.clear(1, 1, 1, 1);
        super.render(delta);
        plane.update(delta);
        for (Tank tank : tanks)
            tank.update(delta);
        for (Tree tree : trees)
            tree.update(delta);
        for (Trench trench : trenches)
            trench.update(delta);
        for (Truck truck : trucks)
            truck.update(delta);
        for (Mig mig : migs)
            mig.update(delta);
        for (Building building : buildings)
            building.update(delta);
        for (Bonus bonus : bonuses)
            bonus.update(delta);
        batch.begin();
        plane.draw(batch);
        for (Building building : buildings)
            building.draw(batch);
        for (Mig mig : migs)
            mig.draw(batch);
        for (Tank tank : tanks)
            tank.draw(batch);
        for (Tree tree : trees)
            tree.draw(batch);
        for (Trench trench : trenches)
            trench.draw(batch);
        for (Truck truck : trucks)
            truck.draw(batch);
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
    }
}
