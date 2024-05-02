package com.model;

import java.io.*;
import java.util.*;

public class User implements Serializable {
    private final static ArrayList<User> allUsers = new ArrayList<>();
    private static User currentUser;
    private String username;
    private String password;
    private ArrayList<GameInformation> games;
    private String avatarPath;
    private int score;
    private int lastWave;
    private int difficulty;
    private int shootCount;
    private int successfulShootCount;

    static {
        File directory = new File("/home/kiarash-sanei/Dev/Advanced.Programming/HW2/Information/");
        for (File userFile : Objects.requireNonNull(directory.listFiles(File::isFile))) {
            FileInputStream fis;
            try {
                fis = new FileInputStream("/home/kiarash-sanei/Dev/Advanced.Programming/HW2/Information/" + userFile.getName());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            ObjectInputStream ois;
            try {
                ois = new ObjectInputStream(fis);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            User user;
            try {
                user = (User) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            allUsers.add(user);
        }
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.games = new ArrayList<>();
        Random random = new Random();
        this.avatarPath = "DefaultAvatars/" + (random.nextInt(4) + 1) + ".png";
        this.score = 0;
        this.lastWave = 0;
        this.difficulty = 0;
        this.shootCount = 0;
        this.successfulShootCount = 0;
        if (!Objects.equals(username, "_guest_")) {
            this.save();
            allUsers.add(this);
        } else {
            boolean haveGuest = false;
            for (User user : allUsers)
                if (Objects.equals(user.username, "_guest_")) {
                    haveGuest = true;
                    break;
                }
            if (!haveGuest)
                allUsers.add(this);
        }
    }

    public static boolean usernameExists(String username) {
        for (User user : allUsers)
            if (Objects.equals(user.username, username))
                return true;
        return false;
    }

    public static boolean usernameValidation(String username) {
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (!(('a' <= c && c <= 'z') ||
                    ('A' <= c && c <= 'Z') ||
                    ('0' <= c && c <= '9')))
                return false;
        }
        return true;
    }

    public static boolean passwordSecurity(String password) {
        if (password.length() <= 8)
            return false;
        else {
            boolean haveLowercase = false;
            boolean haveUppercase = false;
            boolean haveDigit = false;
            boolean haveOther = false;
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if ('a' <= c && c <= 'z')
                    haveLowercase = true;
                else if ('A' <= c && c <= 'Z')
                    haveUppercase = true;
                else if ('0' <= c && c <= '9')
                    haveDigit = true;
                else
                    haveOther = true;
            }
            return haveLowercase &&
                    haveUppercase &&
                    haveDigit &&
                    haveOther;
        }
    }

    public static User userFinder(String username) {
        for (User user : allUsers)
            if (Objects.equals(user.username, username))
                return user;
        return null;
    }

    public boolean passwordCheck(String password) {
        return Objects.equals(this.password, password);
    }

    public static void setCurrentUser(User currentUser) {
        User.currentUser = currentUser;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public void save() {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream("/home/kiarash-sanei/Dev/Advanced.Programming/HW2/Information/" + this.username + ".json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            oos.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUsername() {
        return username;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public int getScore() {
        return score;
    }

    public static User[] getRegularRanking() {
        User[] result = new User[10];
        Collections.sort(allUsers, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.score - o2.score;
            }
        });
        for (int i = 0; i < 10 && i < allUsers.size(); i++)
            result[i] = allUsers.get(i);
        return result;
    }

    public static User[] getWaveRanking() {
        User[] result = new User[10];
        Collections.sort(allUsers, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.score == o2.score)
                    return o1.lastWave - o2.lastWave;
                else
                    return o1.score - o2.score;
            }
        });
        for (int i = 0; i < 10 && i < allUsers.size(); i++)
            result[i] = allUsers.get(i);
        return result;
    }

    public static User[] getKillRanking() {
        User[] result = new User[10];
        Collections.sort(allUsers, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.difficulty * o1.score - o2.difficulty * o2.score;
            }
        });
        for (int i = 0; i < 10 && i < allUsers.size(); i++)
            result[i] = allUsers.get(i);
        return result;
    }

    public static User[] getAccuracyRanking() {
        User[] result = new User[10];
        Collections.sort(allUsers, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.successfulShootCount / o1.shootCount - o2.successfulShootCount / o2.shootCount;
            }
        });
        for (int i = 0; i < 10 && i < allUsers.size(); i++)
            result[i] = allUsers.get(i);
        return result;
    }
}
