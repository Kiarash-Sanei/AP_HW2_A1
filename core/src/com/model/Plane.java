package com.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static com.badlogic.gdx.Gdx.graphics;

public class Plane extends GameObject {
    private Setting setting;
    private static float speed = 200;

    public Plane(float x, float y, float width, float height, Setting setting) {
        super(x, y, width, height);
        this.setting = setting;
        this.image = new Image(new Texture("Plane.png"));
        image.setHeight(height);
        image.setWidth(width);
        image.setPosition(x, y);
        for (Keyboard key : Keyboard.values()) {
            Keyboard.status.put(key, false);
        }
    }

    public void goUp() {
        y += speed;
    }

    public void goDown() {
        y -= speed;
    }

    public void goRight() {
        x += speed;
    }

    public void goLeft() {
        x -= speed;
    }

    public void regularBomb() {

    }

    public void radioactiveBomb() {

    }

    public void clusterBomb() {

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
        if (Keyboard.status.get(Keyboard.UP)) {
            y += speed * deltaTime;
        } else if (Keyboard.status.get(Keyboard.DOWN)) {
            y -= speed * deltaTime;
        }
        if (Keyboard.status.get(Keyboard.RIGHT)) {
            x += speed * deltaTime;
        } else if (Keyboard.status.get(Keyboard.LEFT)) {
            x -= speed * deltaTime;
        }
        wrapper();
        image.setPosition(x, y);
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
    }
}
