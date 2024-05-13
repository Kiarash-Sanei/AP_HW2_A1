package com.Model.GameObjects;

import com.Control.GameMenu;
import com.Model.Effect.RegularBombGif;
import com.Model.User;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static com.badlogic.gdx.Gdx.graphics;

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

    public void wrapper() {
        if (y < 0) {
            isAlive = false;
            GameMenu.addEffect(new RegularBombGif(x + GameObjects.RegularBomb.getWidth() / 2 - GameObjects.RegularBombGif.getWidth() / 2,
                    y));
        }
        if (x < 0 ||
                graphics.getWidth() < x)
            isAlive = false;
    }

}
