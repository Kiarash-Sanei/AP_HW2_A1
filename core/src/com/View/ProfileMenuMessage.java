package com.View;

public enum ProfileMenuMessage {
    usernameStart("Your username must just include english letter or digit.\n\n"),
    duplicateUsername("This username is already taken!\n\n"),
    invalidUsername("This username is invalid!\n" +
            "You have used other character rather than english letter or digit.\n" +
            "Your username must just include english letter or digit."),
    usernameIsTheSame("You should enter a username other than the one one that you already have.\n\n"),
    usernameChange("Username has been changed!\n\n"),
    passwordStart("Your password may include any character except whitespace.\n\n"),
    passwordIsTheSame("You should enter a password other than the one one that you already have.\n\n"),
    insecurePassword("This password is not secure enough!\n" +
            "Your password must be longer than 8 and at least include a lowercase, an uppercase, a digit, and another character.\n" +
            "Your password may include any character except whitespace."),
    passwordChanged("Password has been changed!\n\n"),
    youAreAGuest("You are a guest!\n\n");

    private final String string;

    ProfileMenuMessage(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
