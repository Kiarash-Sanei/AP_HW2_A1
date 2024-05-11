package com.Control;

import com.Model.GameObjects.GameObject;
import com.Model.GameObjects.*;

import java.util.ArrayList;

public class GameMenu extends Menu {
    private static final ArrayList<GameObject> gameObjects = GameObject.getGameObjects();

    public static GameObject[] collision() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = gameObjects.get(i);
            if (gameObject.getClass() != ClusterBomb.class &&
                    gameObject.getClass() != RadioactiveBomb.class &&
                    gameObject.getClass() != RegularBomb.class) {
                for (int j = 0; j < gameObjects.size(); j++) {
                    GameObject gameObject1 = gameObjects.get(j);
                    if ((gameObject1.getClass() == ClusterBomb.class ||
                            gameObject1.getClass() == RadioactiveBomb.class ||
                            gameObject1.getClass() == RegularBomb.class) &&
                            gameObject.isOn(gameObject1)) {
                        gameObject.kill();
                        gameObject1.kill();
                        gameObjects.remove(gameObject);
                        gameObjects.remove(gameObject1);
                        return new GameObject[]{gameObject, gameObject1};
                    }
                }
            }
            if (gameObject.getClass() == Bonus.class) {
                for (int j = 0; j < gameObjects.size(); j++) {
                    GameObject gameObject1 = gameObjects.get(j);
                    if (gameObject1.getClass() == Plane.class &&
                            gameObject.isOn(gameObject1)) {
                        gameObject.kill();
                        gameObjects.remove(gameObject);
                        ((Plane) gameObject1).clusterBombIncrease();
                        return null;
                    }
                }
            }
        }
        return null;
    }
}
