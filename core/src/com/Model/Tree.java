package com.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Tree extends GameObject {
    private boolean isAlive = true;

    public Tree(float x, float y, float width, float height) {
        super(x, y, width, height);
        this.image = new Image(new Texture("Tree.png"));
        image.setHeight(height);
        image.setWidth(width);
        image.setPosition(x, y);
    }
    public void update(float deltaTime) {

    }
    public void draw(SpriteBatch batch) {
        image.draw(batch, 1);
    }

    public boolean isAlive() {
        return isAlive;
    }
}
