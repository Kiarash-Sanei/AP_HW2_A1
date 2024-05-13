package com.Model.Effect;

import com.Model.GameObjects.GameObject;
import com.Model.User;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class EffectGif extends GameObject {
    protected float periodTime;
    protected int frameCount;
    protected int frame;
    protected float time;
    protected boolean isBlackAndWhite;
    protected boolean loadImage;

    public EffectGif(float x, float y) {
        super(x, y);
        this.frame = 0;
        this.isBlackAndWhite = User.getCurrentUser().getSetting().getBlackAndWhite();
        this.loadImage = false;
    }

    public abstract void update(float delta);

    public abstract void render(SpriteBatch batch, float delta);
}
