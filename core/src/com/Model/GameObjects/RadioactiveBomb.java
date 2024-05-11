package com.Model.GameObjects;

import com.Model.User;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class RadioactiveBomb extends Bomb {
    public RadioactiveBomb(Plane plane) {
        super(plane);
        if (User.getCurrentUser().getSetting().getBlackAndWhite())
            image = new Image(new Texture("GameObjects/B&W/RadioactiveBomb.png"));
        else
            image = new Image(new Texture("GameObjects/Colored/RadioactiveBomb.png"));
        image.setHeight(GameObjects.RadioactiveBomb.getHeight());
        image.setWidth(GameObjects.RadioactiveBomb.getWidth());
    }
}
