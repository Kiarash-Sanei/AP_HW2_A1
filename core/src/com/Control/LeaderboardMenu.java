package com.Control;

import com.Model.User;
import com.View.LeaderboardMenuScreen;

public class LeaderboardMenu extends Menu {
    public static void regularRanking() {
        User[] users = User.getRegularRanking();
        String[] usernames = new String[10];
        for (int i = 0; i < 10; i++) {
            if (users[i] == null)
                usernames[i] = "";
            else
                usernames[i] = users[i].getUsername();
        }
        LeaderboardMenuScreen.setRaking(usernames);
    }

    public static void waveRaking() {
        User[] users = User.getWaveRanking();
        String[] usernames = new String[10];
        for (int i = 0; i < 10; i++) {
            if (users[i] == null)
                usernames[i] = "";
            else
                usernames[i] = users[i].getUsername();
        }
        LeaderboardMenuScreen.setRaking(usernames);
    }

    public static void killRanking() {
        User[] users = User.getKillRanking();
        String[] usernames = new String[10];
        for (int i = 0; i < 10; i++) {
            if (users[i] == null)
                usernames[i] = "";
            else
                usernames[i] = users[i].getUsername();
        }
        LeaderboardMenuScreen.setRaking(usernames);
    }

    public static void accuracyRanking() {
        User[] users = User.getAccuracyRanking();
        String[] usernames = new String[10];
        for (int i = 0; i < 10; i++) {
            if (users[i] == null)
                usernames[i] = "";
            else
                usernames[i] = users[i].getUsername();
        }
        LeaderboardMenuScreen.setRaking(usernames);
    }
}
