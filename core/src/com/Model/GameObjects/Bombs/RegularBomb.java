package com.Model.GameObjects.Bombs;

import com.Control.GameMenu;
import com.Model.Effect.RegularBombGif;
import com.Model.GameObjects.GameObjects;
import com.Model.GameObjects.Plane;
import com.Model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static com.badlogic.gdx.Gdx.graphics;

public class RegularBomb extends Bomb {
    private static final Music music = Gdx.audio.newMusic(Gdx.files.internal("SoundEffect/RegularBomb.mp3"));

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
            if (!User.getCurrentUser().getSetting().getMute()) {
                music.setLooping(false);
                music.play();
            }
        }
        if (x < 0 ||
                graphics.getWidth() < x)
            isAlive = false;
    }

    @Override
    public void kill() {
        isAlive = false;
        if (!User.getCurrentUser().getSetting().getMute()) {
            music.setLooping(false);
            music.play();
        }
    }
}
