package com.Model.GameObjects;

import com.Model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Trench extends GameObject {
    private static final Music music = Gdx.audio.newMusic(Gdx.files.internal("SoundEffect/Trench.mp3"));

    public Trench(float x, float y) {
        super(x, y);
        if (User.getCurrentUser().getSetting().getBlackAndWhite())
            this.image = new Image(new Texture("GameObjects/B&W/Trench.png"));
        else
            this.image = new Image(new Texture("GameObjects/Colored/Trench.png"));
        image.setHeight(GameObjects.Trench.getHeight());
        image.setWidth(GameObjects.Trench.getWidth());
        image.setPosition(x, y);
    }

    public void draw(SpriteBatch batch) {
        image.draw(batch, 1);
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
