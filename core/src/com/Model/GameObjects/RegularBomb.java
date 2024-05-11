package com.Model.GameObjects;

import com.Model.User;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class RegularBomb extends Bomb {
    public RegularBomb(Plane plane) {
        super(plane);
        if (User.getCurrentUser().getSetting().getBlackAndWhite())
            this.image = new Image(new Texture("GameObjects/B&W/RegularBomb.png"));
        else
            this.image = new Image(new Texture("GameObjects/Colored/RegularBomb.png"));
        image.setHeight(GameObjects.RegularBomb.getHeight());
        image.setWidth(GameObjects.RegularBomb.getWidth());
    }
}
