package com.Model.GameObjects.Bullets;

import com.Model.GameObjects.GameObjects;
import com.Model.User;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MigBullet extends Bullet {
    public MigBullet(float x, float y, float angle) {
        super(x, y, angle);
        if (User.getCurrentUser().getSetting().getBlackAndWhite())
            image = new Image(new Texture("GameObjects/B&W/MigBullet.png"));
        else
            image = new Image(new Texture("GameObjects/Colored/MigBullet.png"));
        image.setHeight(GameObjects.MigBullet.getHeight());
        image.setWidth(GameObjects.MigBullet.getWidth());
        image.setOrigin(image.getWidth() / 2, image.getHeight() / 2);
        image.setRotation((float) (angle * Math.PI) * 30);
        image.setPosition(x, y);
    }
}
