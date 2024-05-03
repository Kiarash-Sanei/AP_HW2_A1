package com.control;

import com.model.User;
import com.view.LoginMenuMessage;
import com.view.ProfileMenuScreen;
import com.view.ProfileMenuMessage;

import java.util.Objects;

public class ProfileMenu extends Menu {
    public static void changeUsername(String username) {
        User user = User.getCurrentUser();

        if (Objects.equals(user.getUsername(), "_guest_"))
            ProfileMenuScreen.setUsernameMessage(ProfileMenuMessage.youAreAGuest.getString());
        else if (Objects.equals(user.getUsername(),username))
            ProfileMenuScreen.setUsernameMessage(ProfileMenuMessage.usernameIsTheSame.getString());
        else if (User.usernameExists(username))
            ProfileMenuScreen.setUsernameMessage(ProfileMenuMessage.duplicateUsername.getString());
        else if (!User.usernameValidation(username))
            ProfileMenuScreen.setUsernameMessage(ProfileMenuMessage.invalidUsername.getString());
        else {
            user.setUsername(username);
            ProfileMenuScreen.setUsernameMessage(ProfileMenuMessage.usernameChange.getString());
        }
    }
    public static void changePassword(String password) {
        User user = User.getCurrentUser();
        if (Objects.equals(user.getUsername(), "_guest_"))
            ProfileMenuScreen.setPasswordMessage(ProfileMenuMessage.youAreAGuest.getString());
        else if (!User.passwordSecurity(password))
            ProfileMenuScreen.setPasswordMessage(ProfileMenuMessage.insecurePassword.getString());
        else {
            user.setPassword(password);
            ProfileMenuScreen.setPasswordMessage(ProfileMenuMessage.passwordChanged.getString());
        }
    }
    public static void deleteAccount() {
        User.getCurrentUser().deleteUser();
        User.setCurrentUser(null);
        Menu.loginMenu();
    }
    public static void logout() {
        User.setCurrentUser(null);
        Menu.loginMenu();
    }

}
