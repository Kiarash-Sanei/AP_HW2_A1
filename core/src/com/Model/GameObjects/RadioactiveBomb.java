package com.Model.GameObjects;

import com.Control.GameMenu;
import com.Model.Effect.RadioactiveBombGif;
import com.Model.User;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static com.badlogic.gdx.Gdx.graphics;

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

    public void wrapper() {
        if (y < 0) {
            isAlive = false;
            GameMenu.addEffect(new RadioactiveBombGif(x + GameObjects.RadioactiveBomb.getWidth() / 2 - GameObjects.RadioactiveBombGif.getWidth() / 2,
                    y));
        }
        if (x < 0 ||
                graphics.getWidth() < x)
            isAlive = false;
    }

}
