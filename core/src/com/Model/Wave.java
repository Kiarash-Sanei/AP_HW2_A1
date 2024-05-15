package com.Model;

public enum Wave {
    first(4, 0, 0, 8, 3, 0),
    second(3, 0, 3, 6, 2, 3),
    third(2, 5, 3, 4, 1, 3);
    private final int building;
    private final int mig;
    private final int tank;
    private final int tree;
    private final int trench;
    private final int truck;

    Wave(int building, int mig, int tank, int tree, int trench, int truck) {
        this.building = building;
        this.mig = mig;
        this.tank = tank;
        this.tree = tree;
        this.trench = trench;
        this.truck = truck;
    }

    public int getBuilding() {
        return building;
    }

    public int getMig() {
        return mig;
    }

    public int getTank() {
        return tank;
    }

    public int getTree() {
        return tree;
    }

    public int getTrench() {
        return trench;
    }

    public int getTruck() {
        return truck;
    }

    public int value() {
        switch (this) {
            case first:
                return 1;
            case second:
                return 2;
            case third:
                return 3;
        }
        return 0;
    }
}

