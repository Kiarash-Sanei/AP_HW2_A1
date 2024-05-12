package com.Model.GameObjects;

import com.Model.Keyboard;
import com.Model.Setting;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;

import static com.badlogic.gdx.Gdx.graphics;

public class Plane extends GameObject {
    private static final float acceleration = 50;
    private static final float minimumTime = 0.1f;
    private final Setting setting;
    private final ArrayList<RegularBomb> regularBombs;
    private float regularBombTime = minimumTime;
    private final ArrayList<ClusterBomb> clusterBombs;
    private float clusterBombTime = minimumTime;
    private int clusterBombCount = 0;
    private final ArrayList<RadioactiveBomb> radioactiveBombs;
    private float radioactiveBombTime = minimumTime;
    private int radioactiveBombCount = 0;

    public Plane(float x, float y, Setting setting) {
        super(x, y);
        this.setting = setting;
        if (setting.getBlackAndWhite())
            image = new Image(new Texture("GameObjects/B&W/Plane.png"));
        else
            image = new Image(new Texture("GameObjects/Colored/Plane.png"));
        image.setHeight(GameObjects.Plane.getHeight());
        image.setWidth(GameObjects.Plane.getWidth());
        image.setPosition(x, y);
        for (Keyboard key : Keyboard.values()) {
            Keyboard.status.put(key, false);
        }
        regularBombs = new ArrayList<>();
        clusterBombs = new ArrayList<>();
        radioactiveBombs = new ArrayList<>();
        accelerationX = acceleration;
        velocityX = 0;
        accelerationY = acceleration;
        velocityY = 0;
    }

    public void regularBomb() {
        if (regularBombs.size() < 3) {
            this.regularBombs.add(new RegularBomb(this));
        }
    }

    public void radioactiveBomb() {
        if (radioactiveBombCount > 0) {
            this.radioactiveBombCount -= 1;
            this.radioactiveBombs.add(new RadioactiveBomb(this));
        }
    }

    public void clusterBomb() {
        if (clusterBombCount > 0) {
            this.clusterBombCount -= 1;
            this.clusterBombs.add(new ClusterBomb(this));
        }
    }

    public void iceMode() {

    }

    public Keyboard toKeyboard(int keyCode) {
        if (setting.getUp().contains(keyCode))
            return Keyboard.UP;
        if (setting.getDown().contains(keyCode))
            return Keyboard.DOWN;
        if (setting.getRight().contains(keyCode))
            return Keyboard.RIGHT;
        if (setting.getLeft().contains(keyCode))
            return Keyboard.LEFT;
        if (setting.getRegularBomb().contains(keyCode))
            return Keyboard.REGULAR_BOMB;
        if (setting.getRadioactiveBomb().contains(keyCode))
            return Keyboard.RADIOACTIVE_BOMB;
        if (setting.getClusterBomb().contains(keyCode))
            return Keyboard.CLUSTER_BOMB;
        if (setting.getIceMode().contains(keyCode))
            return Keyboard.ICE_MODE;
        return null;
    }

    public boolean keyDown(int keyCode) {
        Keyboard keyboardAction = toKeyboard(keyCode);
        if (keyboardAction != null) {
            Keyboard.status.put(keyboardAction, true);
            return true;
        }
        return false;
    }

    public boolean keyUp(int keyCode) {
        Keyboard keyboardAction = toKeyboard(keyCode);
        if (keyboardAction != null) {
            Keyboard.status.put(keyboardAction, false);
            return true;
        }
        return false;
    }

    public void update(float deltaTime) {
        if (Keyboard.status.get(Keyboard.UP))
            velocityY += accelerationY * deltaTime;
        else if (Keyboard.status.get(Keyboard.DOWN))
            velocityY -= accelerationY * deltaTime;
        else {
            if (velocityY < 0)
                velocityY += accelerationY * deltaTime;
            else if (accelerationY > 0)
                velocityY -= accelerationY * deltaTime;
        }
        if (Keyboard.status.get(Keyboard.RIGHT))
            velocityX += accelerationX * deltaTime;
        else if (Keyboard.status.get(Keyboard.LEFT))
            velocityX -= accelerationX * deltaTime;
        else {
            if (velocityX < 0)
                velocityX += accelerationX * deltaTime;
            else if (velocityX > 0)
                velocityX -= accelerationX * deltaTime;
        }
        x += velocityX * deltaTime;
        y += velocityY * deltaTime;
        if (Keyboard.status.get(Keyboard.REGULAR_BOMB)) {
            regularBombTime += deltaTime;
            if (regularBombTime > minimumTime) {
                this.regularBomb();
                regularBombTime = 0;
            }
        }
        if (Keyboard.status.get(Keyboard.CLUSTER_BOMB)) {
            clusterBombTime += deltaTime;
            if (clusterBombTime > minimumTime) {
                this.clusterBomb();
                clusterBombTime = 0;
            }
        }
        if (Keyboard.status.get(Keyboard.RADIOACTIVE_BOMB)) {
            radioactiveBombTime += deltaTime;
            if (radioactiveBombTime > minimumTime) {
                this.radioactiveBomb();
                radioactiveBombTime = 0;
            }
        }
        wrapper();
        image.setPosition(x, y);
        for (RegularBomb regularBomb : regularBombs)
            regularBomb.update(deltaTime);
        for (ClusterBomb clusterBomb : clusterBombs)
            clusterBomb.update(deltaTime);
        for (RadioactiveBomb radioactiveBomb : radioactiveBombs)
            radioactiveBomb.update(deltaTime);
    }

    public void wrapper() {
        if (x < -GameObjects.Plane.getWidth())
            x = graphics.getWidth();
        else if (x > graphics.getWidth())
            x = -GameObjects.Plane.getWidth();
        if (y < GameObjects.Plane.getHeight() * 5) {
            y = GameObjects.Plane.getHeight() * 5;
            velocityY = 0;
        } else if (y > graphics.getHeight() - GameObjects.Plane.getHeight()) {
            y = graphics.getHeight() - GameObjects.Plane.getHeight();
            velocityY = 0;
        }
    }

    public void draw(SpriteBatch batch) {
        image.draw(batch, 1);
        for (RegularBomb regularBomb : regularBombs)
            regularBomb.draw(batch);
        for (ClusterBomb clusterBomb : clusterBombs)
            clusterBomb.draw(batch);
        for (RadioactiveBomb radioactiveBomb : radioactiveBombs)
            radioactiveBomb.draw(batch);
    }

    public void setAlive(boolean life) {
        isAlive = life;
    }

    public void removeIf() {
        regularBombs.removeIf(regularBomb -> !regularBomb.getIsAlive());
        clusterBombs.removeIf(clusterBomb -> !clusterBomb.getIsAlive());
        radioactiveBombs.removeIf(radioactiveBomb -> !radioactiveBomb.getIsAlive());
    }

    public void radioactiveBombIncrease() {
        this.radioactiveBombCount++;
    }

    public void clusterBombIncrease() {
        this.clusterBombCount++;
    }
}
