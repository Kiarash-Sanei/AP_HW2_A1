package com.Model.GameObjects;

import com.Model.User;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Trench extends GameObject {
    public Trench(float x, float y) {
        super(x, y);
        if (User.getCurrentUser().getSetting().getBlackAndWhite())
            this.image = new Image(new Texture("GameObjects/B&W/Trench.png"));
        else
            this.image = new Image(new Texture("GameObjects/Colored/Trench.png"));
        image.setHeight(GameObjects.Trench.getHeight());
        image.setWidth(GameObjects.Trench.getWidth());
        image.setPosition(x, y);
    }

    public void draw(SpriteBatch batch) {
        image.draw(batch, 1);
    }
}
