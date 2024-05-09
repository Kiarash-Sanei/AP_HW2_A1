package com.View;

import com.AtomicBomber;
import com.Model.GameObjects.*;
import com.badlogic.gdx.assets.AssetManager;
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
    public final User user;
    public final Plane plane;
    public final ArrayList<Tank> tanks;
    public final ArrayList<Tree> trees;
    public final ArrayList<Trench> trenches;
    public final ArrayList<Truck> trucks;
    public final ArrayList<Mig> migs;
    public final ArrayList<Building> buildings;
    private final SpriteBatch batch;

    public GameMenuScreen(AtomicBomber atomicBomber) {
        super(atomicBomber);
        assetLoader();
        user = User.getCurrentUser();
        float height = 40;
        float width = height * 1236 / 350;
        plane = new Plane((float) graphics.getWidth() / 2 + width, (float) graphics.getHeight() / 2 + height, width, height, user.getSetting());
        height = 70;
        width = height * 1263 / 634;
        tanks = new ArrayList<>();
        tanks.add(new Tank(0, 0, width, height, user.getSetting()));
        height = 70;
        width = height * 573 / 640;
        trees = new ArrayList<>();
        Random random = new Random();
        int x = random.nextInt((int) (graphics.getWidth() - width));
        trees.add(new Tree(x, 0, width, height));
        height = 30;
        width = height * 1484 / 674;
        trenches = new ArrayList<>();
        x = random.nextInt((int) (graphics.getWidth() - width));
        trenches.add(new Trench(x, 0, width, height));
        height = 50;
        width = height * 983 / 352;
        trucks = new ArrayList<>();
        trucks.add(new Truck(0, 0, width, height));
        height = 40;
        width = height * 1225 / 275;
        migs = new ArrayList<>();
        x = random.nextInt((int) (height * 5), (int) (graphics.getHeight() - height));
        migs.add(new Mig(0, x, width, height, user.getSetting()));
        height = 150;
        width = height * 849 / 2187;
        buildings = new ArrayList<>();
        x = random.nextInt((int) (graphics.getWidth() - width));
        buildings.add(new Building(x, 0, width, height));
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
        batch.begin();
        plane.draw(batch);
        for (Tank tank : tanks)
            tank.draw(batch);
        for (Tree tree : trees)
            tree.draw(batch);
        for (Trench trench : trenches)
            trench.draw(batch);
        for (Truck truck : trucks)
            truck.draw(batch);
        for (Mig mig : migs)
            mig.draw(batch);
        for (Building building : buildings)
            building.draw(batch);
        batch.end();
        tanks.removeIf(tank -> !tank.isAlive());
        trees.removeIf(tree -> !tree.isAlive());
        trenches.removeIf(trench -> !trench.isAlive());
        trucks.removeIf(truck -> !truck.isAlive());
        migs.removeIf(mig -> !mig.isAlive());
    }
}
