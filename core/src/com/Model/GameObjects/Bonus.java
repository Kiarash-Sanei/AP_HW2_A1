package com.Model.GameObjects;

import com.Model.Prize;
import com.Model.User;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Bonus extends GameObject {
    private Prize prize;

    public Bonus(float x, Prize prize) {
        super(x, 0);
        if (User.getCurrentUser().getSetting().getBlackAndWhite())
            image = new Image(new Texture("Bonus/B&W/Bonus.png"));
        else
            image = new Image(new Texture("Bonus/Colored/Bonus.png"));
        image.setHeight(GameObjects.Bonus.getHeight());
        image.setWidth(GameObjects.Bonus.getWidth());
        image.setPosition(x, y);
        this.prize = prize;
        velocityY = 50;
    }

    public void update(float deltaTime) {
        y += velocityY * deltaTime;
        image.setPosition(x, y);
    }

    public void draw(SpriteBatch batch) {
        image.draw(batch, 1);
    }

    public Prize getPrize() {
        return prize;
    }
}
