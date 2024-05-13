package com.Model.GameObjects.Bullets;

import com.Model.GameObjects.GameObject;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.badlogic.gdx.Gdx.graphics;

public abstract class Bullet extends GameObject {
    protected static final float speed = 400;

    public Bullet(float x, float y, float angle) {
        super(x, y);
        this.angle = angle;
        this.velocityX = (float) (speed * Math.cos(angle));
        this.velocityY = (float) (speed * Math.sin(angle));
    }

    public void update(float delta) {
        x += velocityX * delta;
        y += velocityY * delta;
        image.setPosition(x, y);
        wrapper();
    }

    public void draw(SpriteBatch batch) {
        image.draw(batch, 1);
    }

    private void wrapper() {
        if (x < 0 || y < 0 || x > graphics.getWidth() || y > graphics.getHeight())
            isAlive = false;
    }
}
