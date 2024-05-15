package com.Control;

import com.AtomicBomber;
import com.Model.Effect.EffectGif;
import com.Model.GameObjects.*;
import com.Model.GameObjects.Bombs.ClusterBomb;
import com.Model.GameObjects.Bombs.RadioactiveBomb;
import com.Model.GameObjects.Bombs.RegularBomb;
import com.Model.GameObjects.Bullets.MigBullet;
import com.Model.GameObjects.Bullets.TankBullet;
import com.Model.Prize;
import com.Model.Wave;
import com.View.GameMenuScreen;
import com.View.GameOverMenuScreen;
import com.View.OldGameMenuScreen;

import java.util.ArrayList;

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

    public static void addEffect(EffectGif effectGif) {
        gameMenuScreen.addEffect(effectGif);
    }

    public static void changeWave(Wave wave) {
        if (wave == Wave.first)
            AtomicBomber.changeScreen(new GameMenuScreen(AtomicBomber.getAtomicBomber(), Wave.second));
        else if (wave == Wave.second)
            AtomicBomber.changeScreen(new GameMenuScreen(AtomicBomber.getAtomicBomber(), Wave.third));
    }

    public static void gameOver(GameMenuScreen gameMenuScreen) {
        AtomicBomber.changeScreen(new GameOverMenuScreen(AtomicBomber.getAtomicBomber(), GameMenuScreen.getKillCount(), gameMenuScreen.wave.value(), GameMenuScreen.getAccuracy()));
    }

    public static void gameOver(OldGameMenuScreen gameMenuScreen) {
        AtomicBomber.changeScreen(new GameOverMenuScreen(AtomicBomber.getAtomicBomber(), GameMenuScreen.getKillCount(), gameMenuScreen.wave.value(), GameMenuScreen.getAccuracy()));
    }

    public static boolean migDetectPlane(Mig mig, Plane plane) {
        return plane.getY() <= mig.getY() + mig.getRadius() &&
                plane.getX() <= mig.getX() + mig.getRadius();
    }

    public static boolean tankDetectPlane(Tank tank, Plane plane) {
        return plane.getY() <= tank.getY() + tank.getRadius() &&
                plane.getX() >= tank.getX() &&
                plane.getX() <= tank.getX() + GameObjects.Tank.getWidth();
    }

    public static void bulletCollide(ArrayList<Mig> migs, ArrayList<Tank> tanks, Plane plane, GameMenuScreen gameMenuScreen) {
        for (Mig mig : migs)
            for (MigBullet bullet : mig.getMigBullets())
                if (plane.isOn(bullet)) {
                    plane.kill();
                    bullet.kill();
                    PauseMenu.save(gameMenuScreen);
                    gameOver(gameMenuScreen);
                }
        for (Tank tank : tanks)
            for (TankBullet bullet : tank.getTankBullets())
                if (plane.isOn(bullet)) {
                    plane.kill();
                    bullet.kill();
                    PauseMenu.save(gameMenuScreen);
                    gameOver(gameMenuScreen);
                }
    }

    public static void bulletCollide(ArrayList<Mig> migs, ArrayList<Tank> tanks, Plane plane, OldGameMenuScreen gameMenuScreen) {
        for (Mig mig : migs)
            for (MigBullet bullet : mig.getMigBullets())
                if (plane.isOn(bullet)) {
                    plane.kill();
                    bullet.kill();
                    PauseMenu.save(gameMenuScreen);
                    gameOver(gameMenuScreen);
                }
        for (Tank tank : tanks)
            for (TankBullet bullet : tank.getTankBullets())
                if (plane.isOn(bullet)) {
                    plane.kill();
                    bullet.kill();
                    PauseMenu.save(gameMenuScreen);
                    gameOver(gameMenuScreen);
                }
    }

    public static void revive(GameMenuScreen gameMenuScreen) {
        AtomicBomber.changeScreen(gameMenuScreen);
    }
}
