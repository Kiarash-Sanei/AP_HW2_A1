package com.control;

import com.AtomicBomber;
import com.model.User;
import com.view.LoginMenuMassage;
import com.view.LoginMenuScreen;
import com.view.MainMenuScreen;

public class LoginMenu extends Menu {
    public static void register(String username, String password) {
        if (User.usernameExists(username))
            LoginMenuScreen.setMessage(LoginMenuMassage.duplicateUsername.getString());
        else if (!User.usernameValidation(username))
            LoginMenuScreen.setMessage(LoginMenuMassage.invalidUsername.getString());
        else if (!User.passwordSecurity(password))
            LoginMenuScreen.setMessage(LoginMenuMassage.insecurePassword.getString());
        else {
            new User(username, password);
            LoginMenuScreen.setMessage(LoginMenuMassage.userCreation.getString());
        }
    }

    public static void login(String username, String password) {
        if (!User.usernameExists(username)) {
            LoginMenuScreen.setMessage(LoginMenuMassage.usernameExistence.getString());
            return;
        }
        User user = User.userFinder(username);
        if (!user.passwordCheck(password))
            LoginMenuScreen.setMessage(LoginMenuMassage.wrongPassword.getString());
        else {
            User.setCurrentUser(user);
            AtomicBomber.changeScreen(new MainMenuScreen(AtomicBomber.getAtomicBomber()));
        }
    }

    public static void skip() {
        User.setCurrentUser(new User("_guest_", ""));
        AtomicBomber.changeScreen(new MainMenuScreen(AtomicBomber.getAtomicBomber()));
    }
}
