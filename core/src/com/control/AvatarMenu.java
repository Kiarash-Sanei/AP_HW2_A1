package com.control;

import com.model.User;
import com.view.AvatarMenuMessage;
import com.view.AvatarMenuScreen;

import java.io.File;
import java.util.Objects;

public class AvatarMenu extends Menu {
    public static void changeAvatar(String path) {
        File file = new File(path);
        User user = User.getCurrentUser();
        if (!file.exists() || !file.isFile())
            AvatarMenuScreen.setMessage(AvatarMenuMessage.fileExistence.getString());
        else if (Objects.equals(user.getUsername(), "_guest_"))
            AvatarMenuScreen.setMessage(AvatarMenuMessage.youAreAGuest.getString());
        else {
            user.setAvatarPath(path);
            AvatarMenuScreen.setMessage(AvatarMenuMessage.avatarChanged.getString());
        }
    }
}
