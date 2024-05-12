package com.Control;

import com.Model.GameObjects.*;
import com.Model.Prize;

import java.util.ArrayList;
import java.util.HashMap;

public class GameMenu extends Menu {
    public static ArrayList<Float> buildingCollision(ArrayList<Building> buildings, Plane plane) {
        ArrayList<Float> result = new ArrayList<>();
        for (Building building : buildings) {
            for (RegularBomb regularBomb : plane.getRegularBombs()) {
                if (building.isOn(regularBomb)) {
                    building.kill();
                    regularBomb.kill();
                    result.add(building.getX() + GameObjects.Building.getWidth() / 2 - GameObjects.Bonus.getWidth() / 2);
                }
            }
            for (ClusterBomb clusterBomb : plane.getClusterBombs()) {
                if (building.isOn(clusterBomb)) {
                    building.kill();
                    clusterBomb.kill();
                    result.add(building.getX() + GameObjects.Building.getWidth() / 2 - GameObjects.Bonus.getWidth() / 2);
                }
            }
            for (RadioactiveBomb radioactiveBomb : plane.getRadioactiveBombs()) {
                if (building.isOn(radioactiveBomb)) {
                    building.kill();
                    radioactiveBomb.kill();
                    result.add(building.getX() + GameObjects.Building.getWidth() / 2 - GameObjects.Bonus.getWidth() / 2);
                }
            }
        }
        return result;
    }

    public static ArrayList<Float> trenchCollision(ArrayList<Trench> trenches, Plane plane) {
        ArrayList<Float> result = new ArrayList<>();
        for (Trench trench : trenches) {
            for (RegularBomb regularBomb : plane.getRegularBombs()) {
                if (trench.isOn(regularBomb)) {
                    trench.kill();
                    regularBomb.kill();
                    result.add(trench.getX() + GameObjects.Trench.getWidth() / 2 - GameObjects.Bonus.getWidth() / 2);
                }
            }
            for (ClusterBomb clusterBomb : plane.getClusterBombs()) {
                if (trench.isOn(clusterBomb)) {
                    trench.kill();
                    clusterBomb.kill();
                    result.add(trench.getX() + GameObjects.Trench.getWidth() / 2 - GameObjects.Bonus.getWidth() / 2);
                }
            }
            for (RadioactiveBomb radioactiveBomb : plane.getRadioactiveBombs()) {
                if (trench.isOn(radioactiveBomb)) {
                    trench.kill();
                    radioactiveBomb.kill();
                    result.add(trench.getX() + GameObjects.Trench.getWidth() / 2 - GameObjects.Bonus.getWidth() / 2);
                }
            }
        }
        return result;
    }

    public static void tankCollision(ArrayList<Tank> tanks, Plane plane) {
        for (Tank tank : tanks) {
            for (RegularBomb regularBomb : plane.getRegularBombs()) {
                if (tank.isOn(regularBomb)) {
                    tank.kill();
                    regularBomb.kill();
                }
            }
            for (ClusterBomb clusterBomb : plane.getClusterBombs()) {
                if (tank.isOn(clusterBomb)) {
                    tank.kill();
                    clusterBomb.kill();
                }
            }
            for (RadioactiveBomb radioactiveBomb : plane.getRadioactiveBombs()) {
                if (tank.isOn(radioactiveBomb)) {
                    tank.kill();
                    radioactiveBomb.kill();
                }
            }
        }
    }

    public static void truckCollision(ArrayList<Truck> trucks, Plane plane) {
        for (Truck truck : trucks) {
            for (RegularBomb regularBomb : plane.getRegularBombs()) {
                if (truck.isOn(regularBomb)) {
                    truck.kill();
                    regularBomb.kill();
                }
            }
            for (ClusterBomb clusterBomb : plane.getClusterBombs()) {
                if (truck.isOn(clusterBomb)) {
                    truck.kill();
                    clusterBomb.kill();
                }
            }
            for (RadioactiveBomb radioactiveBomb : plane.getRadioactiveBombs()) {
                if (truck.isOn(radioactiveBomb)) {
                    truck.kill();
                    radioactiveBomb.kill();
                }
            }
        }
    }

    public static void treeCollision(ArrayList<Tree> trees, Plane plane) {
        for (Tree tree : trees) {
            for (RegularBomb regularBomb : plane.getRegularBombs()) {
                if (tree.isOn(regularBomb)) {
                    tree.kill();
                    regularBomb.kill();
                }
            }
            for (ClusterBomb clusterBomb : plane.getClusterBombs()) {
                if (tree.isOn(clusterBomb)) {
                    tree.kill();
                    clusterBomb.kill();
                }
            }
            for (RadioactiveBomb radioactiveBomb : plane.getRadioactiveBombs()) {
                if (tree.isOn(radioactiveBomb)) {
                    tree.kill();
                    radioactiveBomb.kill();
                }
            }
        }
    }

    public static void migCollision(ArrayList<Mig> migs, Plane plane) {
        for (Mig mig : migs) {
            for (RegularBomb regularBomb : plane.getRegularBombs()) {
                if (mig.isOn(regularBomb)) {
                    mig.kill();
                    regularBomb.kill();
                }
            }
            for (ClusterBomb clusterBomb : plane.getClusterBombs()) {
                if (mig.isOn(clusterBomb)) {
                    mig.kill();
                    clusterBomb.kill();
                }
            }
            for (RadioactiveBomb radioactiveBomb : plane.getRadioactiveBombs()) {
                if (mig.isOn(radioactiveBomb)) {
                    mig.kill();
                    radioactiveBomb.kill();
                }
            }
        }
    }

    public static void bonusCollision(ArrayList<Bonus> bonuses, Plane plane) {
        for (Bonus bonus : bonuses) {
            if (bonus.isOn(plane)) {
                bonus.kill();
                if (bonus.getPrize() == Prize.clusterBomb)
                    plane.clusterBombIncrease();
                else if (bonus.getPrize() == Prize.radioactiveBomb)
                    plane.radioactiveBombIncrease();
            }
        }
    }
}
