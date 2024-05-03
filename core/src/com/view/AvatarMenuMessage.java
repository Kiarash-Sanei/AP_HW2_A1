package com.view;

public enum AvatarMenuMessage {
    start("Click on an avatar or type the absolute path of a picture to set it as your avatar.\n"),
    fileExistence("The path is invalid.\n"),
    youAreAGuest("You are a guest!\n"),
    avatarChanged("Avatar changed!\n");
    private final String string;
    AvatarMenuMessage(String string) {
        this.string = string;
    }
    public String getString() {
        return string;
    }
}
