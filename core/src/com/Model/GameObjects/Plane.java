package com.Model.GameObjects;

import com.Model.GameObject;
import com.Model.Keyboard;
import com.Model.Setting;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;

import static com.badlogic.gdx.Gdx.graphics;

public class Plane extends GameObject {
    private final Setting setting;
    private final float speed = 300;
    private final float minimumTime = 0.1f;
    private final ArrayList<RegularBomb> regularBombs;
    private float regularBombTime = minimumTime;
    private final ArrayList<ClusterBomb> clusterBombs;
    private float clusterBombTime = minimumTime;
    private int clusterBombCount = 0;
    private final ArrayList<RadioactiveBomb> radioactiveBombs;
    private float radioactiveBombTime = minimumTime;
    private int radioactiveBombCount = 0;
    private static final float height = 40;
    private static final float width = height * 1236 / 350;

    public Plane(float x, float y, Setting setting) {
        super(x ,y);
        this.setting = setting;
        if (setting.getBlackAndWhite())
            this.image = new Image(new Texture("GameObjects/B&W/Plane.png"));
        else
            this.image = new Image(new Texture("GameObjects/Colored/Plane.png"));
        image.setHeight(height);
        image.setWidth(width);
        image.setPosition(x, y);
        for (Keyboard key : Keyboard.values()) {
            Keyboard.status.put(key, false);
        }
        this.regularBombs = new ArrayList<>();
        this.clusterBombs = new ArrayList<>();
        this.radioactiveBombs = new ArrayList<>();
    }

    public void regularBomb() {
        if (regularBombs.size() < 3) {
            this.regularBombs.add(new RegularBomb(x, y));
        }
    }

    public void radioactiveBomb() {
        if (radioactiveBombCount > 0) {
            this.radioactiveBombCount -= 1;
            this.radioactiveBombs.add(new RadioactiveBomb(x, y));
        }
    }

    public void clusterBomb() {
        if (clusterBombCount > 0) {
            this.clusterBombCount -= 1;
            this.clusterBombs.add(new ClusterBomb(x, y));
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
            y += speed * deltaTime;
        else if (Keyboard.status.get(Keyboard.DOWN))
            y -= speed * deltaTime;
        if (Keyboard.status.get(Keyboard.RIGHT))
            x += speed * deltaTime;
        else if (Keyboard.status.get(Keyboard.LEFT))
            x -= speed * deltaTime;
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
        if (x < -width)
            x = graphics.getWidth();
        else if (x > graphics.getWidth())
            x = -width;
        if (y < height * 3)
            y = height * 3;
        else if (y > graphics.getHeight() - height)
            y = graphics.getHeight() - height;
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

    public void radioactiveBombChange() {
        this.radioactiveBombCount++;
    }

    public void clusterBombChange() {
        this.clusterBombCount++;
    }

    public static float getHeight() {
        return height;
    }

    public static float getWidth() {
        return width;
    }

    @Override
    public boolean isOn(GameObject gameObject) {
        return gameObject.getY() <= this.y + height &&
                gameObject.getY() >= this.y &&
                gameObject.getX() >= this.x &&
                gameObject.getX() <= this.x + width;
    }
}
