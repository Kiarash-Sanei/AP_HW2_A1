package com.Model.GameObjects;

import com.Control.GameMenu;
import com.Model.GameObjects.Bullets.MigBullet;
import com.Model.Setting;
import com.Model.User;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;

import static com.badlogic.gdx.Gdx.graphics;

public class Mig extends Attacker {
    private static final float acceleration = 100;
    private static final float period;
    private static final float radius;
    private static float timer;
    private Image imageIce;
    private final ArrayList<MigBullet> migBullets;

    static {
        switch (User.getCurrentUser().getSetting().getDifficulty()) {
            case easy:
                period = 5.5f;
                radius = 150;
                break;
            case medium:
                period = (float) (0.75 * 5.5);
                radius = 300;
                break;
            case hard:
                period = (float) (0.5 * 5.5);
                radius = 450;
                break;
            default:
                period = 0;
                radius = 0;
                break;
        }
        timer = period;
    }

    public static boolean canMake() {
        return timer >= period;
    }

    public Mig(float x, float y, Setting setting) {
        super(x, y);
        if (setting.getBlackAndWhite()) {
            this.image = new Image(new Texture("GameObjects/B&W/Mig.png"));
            this.imageIce = new Image(new Texture("GameObjects/B&W/Mig.png"));
        } else {
            this.image = new Image(new Texture("GameObjects/Colored/Mig.png"));
            this.imageIce = new Image(new Texture("GameObjects/Colored/Mig.png"));
            imageIce.setColor(Color.CYAN);
        }
        image.setHeight(GameObjects.Mig.getHeight());
        image.setWidth(GameObjects.Mig.getWidth());
        image.setPosition(x, y);
        imageIce.setHeight(GameObjects.Mig.getHeight());
        imageIce.setWidth(GameObjects.Mig.getWidth());
        accelerationX = acceleration;
        velocityX = 0;
        migBullets = new ArrayList<>();
        timer = 0;
    }

    public void update(float deltaTime, boolean iceMode) {
        if (!iceMode) {
            velocityX += accelerationX * deltaTime;
            x += velocityX * deltaTime;
            image.setPosition(x, y);
            wrapper();
        }
        for (MigBullet migBullet : migBullets)
            migBullet.update(deltaTime);
        migBullets.removeIf(migBullet -> !migBullet.getIsAlive());
        time += deltaTime;
    }

    public void wrapper() {
        if (graphics.getWidth() < x)
            isAlive = false;
    }

    public void draw(SpriteBatch batch, boolean iceMode) {
        if (iceMode) {
            imageIce.setPosition(image.getX(), image.getY());
            imageIce.draw(batch, 1);
        } else
            image.draw(batch, 1);
        for (MigBullet migBullet : migBullets)
            migBullet.draw(batch);
    }

    public static void passTime(float deltaTime) {
        timer += deltaTime;
    }

    public float getRadius() {
        return radius;
    }

    public ArrayList<MigBullet> getMigBullets() {
        return migBullets;
    }

    @Override
    public void attack(Plane plane) {
        if (GameMenu.migDetectPlane(this, plane) && time >= 5) {
            float bulletAngle = (float) Math.atan((plane.getY() - y) / (plane.getX() - x));
            migBullets.add(new MigBullet(x, y, bulletAngle));
            time = 0;
        }
    }
}
