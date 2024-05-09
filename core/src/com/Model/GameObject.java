package com.Model;

import com.Model.GameObjects.ClusterBomb;
import com.Model.GameObjects.Mig;
import com.Model.GameObjects.RadioactiveBomb;
import com.Model.GameObjects.RegularBomb;
import com.View.GameMenuScreen;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;

public abstract class GameObject {
    private static final ArrayList<GameObject> gameObjects = new ArrayList<>();
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected Image image;

    public GameObject(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        gameObjects.add(this);
    }

    public abstract void setAlive(boolean alive);

    public static void collision() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = gameObjects.get(i);
            if (gameObject.getClass() != ClusterBomb.class &&
                    gameObject.getClass() != RadioactiveBomb.class &&
                    gameObject.getClass() != RegularBomb.class &&
                    gameObject.getClass() != Mig.class) {
                for (int j = 0; j < gameObjects.size(); j++) {
                    GameObject gameObject1 = gameObjects.get(j);
                    if ((gameObject1.getClass() == ClusterBomb.class ||
                            gameObject1.getClass() == RadioactiveBomb.class ||
                            gameObject1.getClass() == RegularBomb.class) &&
                            gameObject1.y <= gameObject.y + gameObject.height &&
                            gameObject1.x > gameObject.x &&
                            gameObject1.x + gameObject1.width < gameObject.x + gameObject.width) {
                        gameObject.setAlive(false);
                        gameObject1.setAlive(false);
                        gameObjects.remove(gameObject);
                        gameObjects.remove(gameObject1);
                    }
                }
            }
        }
    }

}
