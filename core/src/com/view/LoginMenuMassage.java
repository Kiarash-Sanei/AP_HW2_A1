package com.view;

public enum LoginMenuMassage {

    start("Welcome to the login menu!\n" +
            "You may sign in in this menu first.\n" +
            "Your username must just include english letter or digit.\n" +
            "Your password may include any character except whitespace.\n" +
            "If you don't want to create an account use skip button."),
    duplicateUsername("This username is already taken!\n" +
            "Suggestion:\n\n\n"),
    invalidUsername("This username is invalid!\n" +
            "You have used other character rather than english letter or digit.\n" +
            "Your username must just include english letter or digit.\n\n"),
    insecurePassword("This password is not secure enough!\n" +
            "Your password must be longer than 8 and at least include a lowercase, an uppercase, a digit, and another character.\n" +
            "Your password may include any character except whitespace.\n\n"),
    userCreation("User is created!\n" +
            "Login to start.\n\n\n"),
    usernameExistence("User doesn't exist!\n\n\n\n"),
    wrongPassword("Password and username doesn't match!\n\n\n\n"),
    directPlay("You have directly started a game.\n\n\n\n");
    private final String string;

    LoginMenuMassage(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
