package com.Model.Effect;

import com.Model.GameObjects.GameObjects;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class ClusterBombGif extends EffectGif {
    public ClusterBombGif(float x, float y) {
        super(x, y);
        this.periodTime = 0.05f;
        this.time = periodTime;
        this.frameCount = 26;
    }

    public void update(float delta) {
        this.time += delta;
        if (this.time >= this.periodTime) {
            frame++;
            time = 0;
            loadImage = true;
        }
    }

    public void render(SpriteBatch batch, float delta) {
        if (frame > frameCount)
            isAlive = false;
        else {
            if (loadImage) {
                if (isBlackAndWhite)
                    image = new Image(new Texture("Effects/B&W/ClusterBomb/" + frame + ".png"));
                else
                    image = new Image(new Texture("Effects/Colored/ClusterBomb/" + frame + ".png"));
            }
            if (frame != 0) {
                image.setHeight(GameObjects.ClusterBombGif.getHeight());
                image.setWidth(GameObjects.ClusterBombGif.getWidth());
                image.setPosition(x, y);
                image.draw(batch, 1);
            }
        }
    }
}
