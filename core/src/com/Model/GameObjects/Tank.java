package com.Model.GameObjects;

import com.Control.GameMenu;
import com.Model.GameObjects.Bullets.TankBullet;
import com.Model.Setting;
import com.Model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;

import static com.badlogic.gdx.Gdx.graphics;

public class Tank extends Attacker {
    private final float radius;
    private Image imageIce;
    private ArrayList<TankBullet> tankBullets;
    private static final Music music = Gdx.audio.newMusic(Gdx.files.internal("SoundEffect/Tank.mp3"));

    public Tank(float x, float y, Setting setting) {
        super(x, y);
        switch (setting.getDifficulty()) {
            case easy:
                velocityX = 10;
                radius = 200;
                break;
            case medium:
                velocityX = 20;
                radius = 400;
                break;
            case hard:
                velocityX = 30;
                radius = 600;
                break;
            default:
                velocityX = 0;
                radius = 0;
                break;
        }
        if (setting.getBlackAndWhite()) {
            this.image = new Image(new Texture("GameObjects/B&W/Tank.png"));
            this.imageIce = new Image(new Texture("GameObjects/B&W/Tank.png"));
        } else {
            this.image = new Image(new Texture("GameObjects/Colored/Tank.png"));
            this.imageIce = new Image(new Texture("GameObjects/Colored/Tank.png"));
            imageIce.setColor(Color.CYAN);
        }
        image.setHeight(GameObjects.Tank.getHeight());
        image.setWidth(GameObjects.Tank.getWidth());
        image.setPosition(x, y);
        imageIce.setHeight(GameObjects.Tank.getHeight());
        imageIce.setWidth(GameObjects.Tank.getWidth());
        tankBullets = new ArrayList<>();
    }

    public void update(float deltaTime, boolean iceMode) {
        if (!iceMode) {
            x += velocityX * deltaTime;
            image.setPosition(x, y);
            wrapper();
        }
        for (TankBullet bullet : tankBullets)
            bullet.update(deltaTime);
        tankBullets.removeIf(tankBullet -> !tankBullet.getIsAlive());
        time += deltaTime;
    }

    public void wrapper() {
        if (x > graphics.getWidth() - GameObjects.Tank.getWidth() || x < 0)
            velocityX = -velocityX;
    }

    public void draw(SpriteBatch batch, boolean iceMode) {
        if (iceMode) {
            imageIce.setPosition(image.getX(), image.getY());
            imageIce.draw(batch, 1);
        } else
            image.draw(batch, 1);
        for (TankBullet bullet : tankBullets)
            bullet.draw(batch);
    }

    public float getRadius() {
        return radius;
    }

    public ArrayList<TankBullet> getTankBullets() {
        return tankBullets;
    }

    @Override
    public void attack(Plane plane) {
        if (GameMenu.tankDetectPlane(this, plane) && time >= 5) {
            float bulletAngle = (float) Math.atan((plane.getY() - y) / (plane.getX() - x));
            tankBullets.add(new TankBullet(x, y, bulletAngle));
            time = 0;
        }
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
