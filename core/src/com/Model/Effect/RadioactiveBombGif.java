package com.Model.Effect;

import com.Model.GameObjects.GameObjects;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class RadioactiveBombGif extends EffectGif {
    public RadioactiveBombGif(float x, float y) {
        super(x, y);
        this.periodTime = 0.1f;
        this.time = periodTime;
        this.frameCount = 17;
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
                    image = new Image(new Texture("Effects/B&W/RadioactiveBomb/" + frame + ".png"));
                else
                    image = new Image(new Texture("Effects/Colored/RadioactiveBomb/" + frame + ".png"));
            }
            if (frame != 0) {
                image.setHeight(GameObjects.RadioactiveBombGif.getHeight());
                image.setWidth(GameObjects.RadioactiveBombGif.getWidth());
                image.setPosition(x, y);
                image.draw(batch, 1);
            }
        }
    }
}
