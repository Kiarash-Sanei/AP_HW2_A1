package com.Model.GameObjects;

import com.Model.GameObject;
import com.Model.User;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Bonus extends GameObject {
    private static final float height = 40;
    private static final float width = height * 535 / 548;

    public Bonus(float x, float y) {
        super(x, y);
        if (User.getCurrentUser().getSetting().getBlackAndWhite())
            this.image = new Image(new Texture("Bonus/B&W/Bonus.png"));
        else
            this.image = new Image(new Texture("Bonus/Colored/Bonus.png"));
        image.setHeight(height);
        image.setWidth(width);
        image.setPosition(x, y);
    }

    public void update(float deltaTime) {

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
