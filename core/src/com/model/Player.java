package com.model;

import java.util.ArrayList;

public class Player {
    private static final ArrayList<Player> allPlayers = new ArrayList<>();
    private final User user;
    int tankSpeed;
    int migRange;
    int tankRange;
    int migPeriod;

    public Player(User user) {
        this.user = user;
        allPlayers.add(this);
    }
}