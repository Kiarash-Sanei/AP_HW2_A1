package com.Model;

import com.Model.GameObjects.ClusterBomb;
import com.Model.GameObjects.Mig;
import com.Model.GameObjects.RadioactiveBomb;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;

public abstract class GameObject {
    private static ArrayList<GameObject> gameObjects = new ArrayList<>();
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
//    public static void collision() {
//        for (GameObject gameObject : gameObjects) {
//            if (gameObject.getClass() != ClusterBomb.class &&
//            gameObject.getClass() != RadioactiveBomb.class &&
//            gameObject.getClass() != Mig.class &&) {}
//        }
//    }
}
