package com.Model.GameObjects;

import com.Model.GameObject;
import com.Model.User;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class ClusterBomb extends GameObject {
    private static final float speed = 100;
    private static final float height = 20;
    private static final float width = height * 1979 / 5524;

    public ClusterBomb(float x, float y) {
        super(x, y);
        if (User.getCurrentUser().getSetting().getBlackAndWhite())
            this.image = new Image(new Texture("GameObjects/B&W/ClusterBomb.png"));
        else
            this.image = new Image(new Texture("GameObjects/Colored/ClusterBomb.png"));
        image.setHeight(height);
        image.setWidth(width);
    }

    public void update(float deltaTime) {
        y -= speed * deltaTime;
        wrapper();
        image.setPosition(x, y);
    }

    public void wrapper() {
        if (y < 0)
            isAlive = false;
    }

    public void draw(SpriteBatch batch) {
        image.draw(batch, 1);
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
