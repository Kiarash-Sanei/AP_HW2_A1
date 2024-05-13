package com.Model.GameObjects;

import com.Control.GameMenu;
import com.Model.Effect.ClusterBombGif;
import com.Model.User;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static com.badlogic.gdx.Gdx.graphics;

public class ClusterBomb extends Bomb {
    public ClusterBomb(Plane plane) {
        super(plane);
        if (User.getCurrentUser().getSetting().getBlackAndWhite())
            image = new Image(new Texture("GameObjects/B&W/ClusterBomb.png"));
        else
            image = new Image(new Texture("GameObjects/Colored/ClusterBomb.png"));
        image.setHeight(GameObjects.ClusterBomb.getHeight());
        image.setWidth(GameObjects.ClusterBomb.getWidth());
    }

    public void wrapper() {
        if (y < 0) {
            isAlive = false;
            GameMenu.addEffect(new ClusterBombGif(x + GameObjects.ClusterBomb.getWidth() / 2 - GameObjects.ClusterBombGif.getWidth() / 2,
                    y));
        }
        if (x < 0 ||
                graphics.getWidth() < x)
            isAlive = false;
    }

}
