package com.Model.Effect;

import com.Model.GameObjects.GameObjects;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class RegularBombGif extends EffectGif {
    public RegularBombGif(float x, float y) {
        super(x, y);
        this.periodTime = 0.08f;
        this.time = periodTime;
        this.frameCount = 10;
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
                    image = new Image(new Texture("Effects/B&W/RegularBomb/" + frame + ".png"));
                else
                    image = new Image(new Texture("Effects/Colored/RegularBomb/" + frame + ".png"));
            }
            if (frame != 0) {
                image.setHeight(GameObjects.RegularBombGif.getHeight());
                image.setWidth(GameObjects.RegularBombGif.getWidth());
                image.setPosition(x, y);
                image.draw(batch, 1);
            }
        }
    }
}
