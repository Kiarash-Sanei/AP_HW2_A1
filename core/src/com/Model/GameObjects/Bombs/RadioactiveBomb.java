package com.Model.GameObjects.Bombs;

import com.Control.GameMenu;
import com.Model.Effect.RadioactiveBombGif;
import com.Model.GameObjects.GameObjects;
import com.Model.GameObjects.Plane;
import com.Model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static com.badlogic.gdx.Gdx.graphics;

public class RadioactiveBomb extends Bomb {
    private static final Music music = Gdx.audio.newMusic(Gdx.files.internal("SoundEffect/RadioactiveBomb.mp3"));

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
