package com.view;

import com.AtomicBomber;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.model.Plane;
import com.model.User;

public class GameMenuScreen extends MenuScreen {
    public Plane plane;
    private SpriteBatch batch;

    public GameMenuScreen(AtomicBomber atomicBomber, float x, float y) {
        super(atomicBomber);
        batch = new SpriteBatch();
        float height = 60;
        float width = height * 1236 / 350;
        plane = new Plane(x + width, y + height, width, height, User.getCurrentUser().getSetting());
        stage.addListener(new ClickListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                return plane.keyDown(keycode);
            }

            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                return plane.keyUp(keycode);
            }
        });
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.196f, 0.663f, 0.769f, 1);
        super.render(delta);
        plane.update(delta);
        batch.begin();
        plane.draw(batch);
        batch.end();
    }
}
