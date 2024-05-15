package com.Model.GameObjects;

import com.Model.GameObjects.Bombs.ClusterBomb;
import com.Model.GameObjects.Bombs.RadioactiveBomb;
import com.Model.GameObjects.Bombs.RegularBomb;
import com.Model.Keyboard;
import com.Model.Setting;
import com.Model.User;
import com.View.GameMenuScreen;
import com.View.OldGameMenuScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;

import static com.badlogic.gdx.Gdx.graphics;

public class Plane extends GameObject {
    private static final float acceleration = 50;
    private static final float minimumTime = 0.1f;
    private final ArrayList<RegularBomb> regularBombs;
    private float regularBombTime = minimumTime;
    private final ArrayList<ClusterBomb> clusterBombs;
    private float clusterBombTime = minimumTime;
    private float clusterBombIncreaseTime = minimumTime;
    private int clusterBombCount = 0;
    private final ArrayList<RadioactiveBomb> radioactiveBombs;
    private float radioactiveBombTime = minimumTime;
    private float radioactiveBombIncreaseTime = minimumTime;
    private int radioactiveBombCount = 0;
    private static final Music music = Gdx.audio.newMusic(Gdx.files.internal("SoundEffect/Plane.mp3"));

    public Plane(float x, float y, Setting setting) {
        super(x, y);
        if (setting.getBlackAndWhite())
            image = new Image(new Texture("GameObjects/B&W/Plane.png"));
        else
            image = new Image(new Texture("GameObjects/Colored/Plane.png"));
        image.setHeight(GameObjects.Plane.getHeight());
        image.setWidth(GameObjects.Plane.getWidth());
        image.setPosition(x, y);
        image.setOrigin(image.getWidth() / 2, image.getHeight() / 2);
        regularBombs = new ArrayList<>();
        clusterBombs = new ArrayList<>();
        radioactiveBombs = new ArrayList<>();
        accelerationX = acceleration;
        velocityX = 0;
        accelerationY = acceleration;
        velocityY = 0;
        angularVelocity = 50;
    }

    public void regularBomb() {
        if (regularBombs.size() < 3) {
            this.regularBombs.add(new RegularBomb(this));
            GameMenuScreen.shoot();
        }
    }

    public void radioactiveBomb() {
        if (radioactiveBombCount > 0 && radioactiveBombs.size() < 3) {
            this.radioactiveBombCount -= 1;
            this.radioactiveBombs.add(new RadioactiveBomb(this));
            GameMenuScreen.shoot();
        }
    }

    public void clusterBomb() {
        if (clusterBombCount > 0 && clusterBombs.size() < 3) {
            this.clusterBombCount -= 1;
            this.clusterBombs.add(new ClusterBomb(this));
            GameMenuScreen.shoot();
        }
    }

    public void iceMode(GameMenuScreen gameMenuScreen) {
        gameMenuScreen.setIceMode(!gameMenuScreen.getIceMode());
    }
    public void iceMode(OldGameMenuScreen gameMenuScreen) {
        gameMenuScreen.setIceMode(!gameMenuScreen.getIceMode());
    }

    public void update(float deltaTime, OldGameMenuScreen gameMenuScreen) {
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
        if (Math.abs(velocityX) <= 1 || Math.abs(velocityY) <= 1)
            angle = 0;
        else
            angle = (float) (Math.atan(velocityY / velocityX) * 30);
        if (Keyboard.status.get(Keyboard.CLOCK_WISE))
            angle -= angularVelocity * deltaTime;
        else if (Keyboard.status.get(Keyboard.COUNTER_CLOCK_WISE))
            angle += angularVelocity * deltaTime;
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
        if (Keyboard.status.get(Keyboard.ICE_MODE))
            this.iceMode(gameMenuScreen);
        x += velocityX * deltaTime;
        y += velocityY * deltaTime;
        wrapper();
        image.setPosition(x, y);
        image.setRotation(angle);
        for (RegularBomb regularBomb : regularBombs)
            regularBomb.update(deltaTime);
        for (ClusterBomb clusterBomb : clusterBombs)
            clusterBomb.update(deltaTime);
        for (RadioactiveBomb radioactiveBomb : radioactiveBombs)
            radioactiveBomb.update(deltaTime);
    }
    public void update(float deltaTime, GameMenuScreen gameMenuScreen) {
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
        if (Math.abs(velocityX) <= 1 || Math.abs(velocityY) <= 1)
            angle = 0;
        else
            angle = (float) (Math.atan(velocityY / velocityX) * 30);
        if (Keyboard.status.get(Keyboard.CLOCK_WISE))
            angle -= angularVelocity * deltaTime;
        else if (Keyboard.status.get(Keyboard.COUNTER_CLOCK_WISE))
            angle += angularVelocity * deltaTime;
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
        if (Keyboard.status.get(Keyboard.ICE_MODE))
            this.iceMode(gameMenuScreen);
        x += velocityX * deltaTime;
        y += velocityY * deltaTime;
        wrapper();
        image.setPosition(x, y);
        image.setRotation(angle);
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

    public void removeIf() {
        regularBombs.removeIf(regularBomb -> !regularBomb.getIsAlive());
        clusterBombs.removeIf(clusterBomb -> !clusterBomb.getIsAlive());
        radioactiveBombs.removeIf(radioactiveBomb -> !radioactiveBomb.getIsAlive());
    }

    public void radioactiveBombIncrease() {
        this.radioactiveBombCount++;
        GameMenuScreen.dataUpdate();
    }

    public void radioactiveBombIncrease(float deltaTime) {
        radioactiveBombIncreaseTime += deltaTime;
        if (radioactiveBombIncreaseTime > minimumTime) {
            this.radioactiveBombCount++;
            radioactiveBombIncreaseTime = 0;
            GameMenuScreen.dataUpdate();
        }
    }

    public void clusterBombIncrease() {
        this.clusterBombCount++;
        GameMenuScreen.dataUpdate();
    }

    public void clusterBombIncrease(float deltaTime) {
        clusterBombIncreaseTime += deltaTime;
        if (clusterBombIncreaseTime > minimumTime) {
            this.clusterBombCount++;
            clusterBombIncreaseTime = 0;
            GameMenuScreen.dataUpdate();
        }
    }

    public ArrayList<RegularBomb> getRegularBombs() {
        return this.regularBombs;
    }

    public ArrayList<ClusterBomb> getClusterBombs() {
        return this.clusterBombs;
    }

    public ArrayList<RadioactiveBomb> getRadioactiveBombs() {
        return this.radioactiveBombs;
    }
    public int getRadioactiveBombsCount() {
        return this.radioactiveBombCount;
    }

    public int getClusterBombsCount() {
        return this.clusterBombCount;
    }

    @Override
    public void kill() {
        isAlive = false;
        if (!User.getCurrentUser().getSetting().getMute()) {
            music.setLooping(false);
            music.play();
        }
    }
}
