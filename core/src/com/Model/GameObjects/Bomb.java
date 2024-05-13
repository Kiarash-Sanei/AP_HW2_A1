package com.Model.GameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Bomb extends GameObject {
    protected static final float ratio = 0.5f;

    public Bomb(Plane plane) {
        super(plane.getX(), plane.getY());
        accelerationX = plane.getAccelerationX() * ratio;
        velocityX = plane.getVelocityX() * ratio;
        if (g + plane.getAccelerationY() < 0)
            accelerationY = g + plane.getAccelerationY() * ratio;
        else
            accelerationY = 0;
        if (plane.getVelocityY() < 0)
            velocityY = plane.getVelocityY();
        else
            velocityY = 0;
    }

    public void update(float deltaTime) {
        velocityX += accelerationX * deltaTime;
        x += velocityX * deltaTime;
        velocityY += accelerationY * deltaTime;
        y += velocityY * deltaTime;
        image.setPosition(x, y);
        wrapper();
    }

    public abstract void wrapper();

    public void draw(SpriteBatch batch) {
        image.draw(batch, 1);
    }
}
