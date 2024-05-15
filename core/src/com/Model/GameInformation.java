package com.Model;

import com.Model.GameObjects.*;

import java.util.ArrayList;

public class GameInformation {
    public final Wave wave;
    public final ArrayList<Building> buildings;
    public final ArrayList<Mig> migs;
    public final ArrayList<Tank> tanks;
    public final ArrayList<Tree> trees;
    public final ArrayList<Trench> trenches;
    public final ArrayList<Truck> trucks;

    public GameInformation(Wave wave,
                           ArrayList<Building> buildings,
                           ArrayList<Mig> migs,
                           ArrayList<Tank> tanks,
                           ArrayList<Tree> trees,
                           ArrayList<Trench> trenches,
                           ArrayList<Truck> trucks) {
        this.wave = wave;
        this.buildings = buildings;
        this.migs = migs;
        this.tanks = tanks;
        this.trees = trees;
        this.trenches = trenches;
        this.trucks = trucks;
    }
}