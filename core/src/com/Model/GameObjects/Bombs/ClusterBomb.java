package com.Model.GameObjects.Bombs;

import com.Control.GameMenu;
import com.Model.Effect.ClusterBombGif;
import com.Model.GameObjects.GameObjects;
import com.Model.GameObjects.Plane;
import com.Model.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static com.badlogic.gdx.Gdx.graphics;

public class ClusterBomb extends Bomb {
    private static final Music music = Gdx.audio.newMusic(Gdx.files.internal("SoundEffect/ClusterBomb.mp3"));

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
