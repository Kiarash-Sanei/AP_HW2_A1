package com.Model.GameObjects;

public enum GameObjects {
    Bonus(40, (float) (40 * 535) / 548),
    Building(150, (float) (150 * 849) / 2187),
    ClusterBomb(20, (float) (20 * 1979) / 5524),
    Mig(40, (float) (40 * 1225) / 275),
    Plane(40, (float) (40 * 1236) / 350),
    RadioactiveBomb(20, (float) (20 * 694) / 1952),
    RegularBomb(20, (float) (20 * 958) / 3148),
    Tank(70, (float) (70 * 1263) / 634),
    Tree(70, (float) (70 * 573) / 640),
    Trench(30, (float) (30 * 1484) / 674),
    Truck(50, (float) (50 * 983) / 352),
    ClusterBombGif(90, 90),
    RadioactiveBombGif(60, 60),
    RegularBombGif(30, 30),
    TankBullet(2, (float) (2 * 1826) / 1202),
    MigBullet(2, (float) (2 * 877) / 131);
    private final float height;
    private final float width;

    GameObjects(float height, float width) {
        this.height = height;
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public static float getHeight(GameObject gameObject) {
        if (gameObject.getClass().equals(com.Model.GameObjects.Bonus.class))
            return Bonus.getHeight();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Building.class))
            return Building.getHeight();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Bombs.ClusterBomb.class))
            return ClusterBomb.getHeight();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Mig.class))
            return Mig.getHeight();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Plane.class))
            return Plane.getHeight();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Bombs.RadioactiveBomb.class))
            return RadioactiveBomb.getHeight();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Bombs.RegularBomb.class))
            return RegularBomb.getHeight();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Tank.class))
            return Tank.getHeight();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Tree.class))
            return Tree.getHeight();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Trench.class))
            return Trench.getHeight();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Truck.class))
            return Truck.getHeight();
        else if (gameObject.getClass().equals(com.Model.Effect.ClusterBombGif.class))
            return ClusterBombGif.getHeight();
        else if (gameObject.getClass().equals(com.Model.Effect.RadioactiveBombGif.class))
            return RegularBombGif.getHeight();
        else if (gameObject.getClass().equals(com.Model.Effect.RegularBombGif.class))
            return RegularBombGif.getHeight();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Bullets.TankBullet.class))
            return TankBullet.getHeight();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Bullets.MigBullet.class))
            return MigBullet.getHeight();
        return 0;
    }

    public static float getWidth(GameObject gameObject) {
        if (gameObject.getClass().equals(com.Model.GameObjects.Bonus.class))
            return Bonus.getWidth();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Building.class))
            return Building.getWidth();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Bombs.ClusterBomb.class))
            return ClusterBomb.getWidth();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Mig.class))
            return Mig.getWidth();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Plane.class))
            return Plane.getWidth();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Bombs.RadioactiveBomb.class))
            return RadioactiveBomb.getWidth();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Bombs.RegularBomb.class))
            return RegularBomb.getWidth();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Tank.class))
            return Tank.getWidth();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Tree.class))
            return Tree.getWidth();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Trench.class))
            return Trench.getWidth();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Truck.class))
            return Truck.getWidth();
        else if (gameObject.getClass().equals(com.Model.Effect.ClusterBombGif.class))
            return ClusterBombGif.getWidth();
        else if (gameObject.getClass().equals(com.Model.Effect.RadioactiveBombGif.class))
            return RegularBombGif.getWidth();
        else if (gameObject.getClass().equals(com.Model.Effect.RegularBombGif.class))
            return RegularBombGif.getWidth();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Bullets.TankBullet.class))
            return TankBullet.getWidth();
        else if (gameObject.getClass().equals(com.Model.GameObjects.Bullets.MigBullet.class))
            return MigBullet.getWidth();
        return 0;
    }
}
