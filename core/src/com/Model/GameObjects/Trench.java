package com.Model.GameObjects;

import com.Model.GameObject;
import com.Model.User;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Trench extends GameObject {
    private static final float height = 30;
    private static final float width = height * 1484 / 674;

    public Trench(float x, float y) {
        super(x, y);
        if (User.getCurrentUser().getSetting().getBlackAndWhite())
            this.image = new Image(new Texture("GameObjects/B&W/Trench.png"));
        else
            this.image = new Image(new Texture("GameObjects/Colored/Trench.png"));
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
