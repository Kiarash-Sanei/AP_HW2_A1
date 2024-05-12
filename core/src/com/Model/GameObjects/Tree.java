package com.Model.GameObjects;

import com.Model.User;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Tree extends GameObject {
    public Tree(float x, float y) {
        super(x, y);
        if (User.getCurrentUser().getSetting().getBlackAndWhite())
            this.image = new Image(new Texture("GameObjects/B&W/Tree.png"));
        else
            this.image = new Image(new Texture("GameObjects/Colored/Tree.png"));
        image.setHeight(GameObjects.Tree.getHeight());
        image.setWidth(GameObjects.Tree.getWidth());
        image.setPosition(x, y);
    }

    public void draw(SpriteBatch batch) {
        image.draw(batch, 1);
    }
}
