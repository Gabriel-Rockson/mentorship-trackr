package com.amalitech.mentorshiptrackr.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public abstract class PasswordGenerator {
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[{]};:'\",<.>/?";

    private static final String ALL_CHARACTERS = LOWER_CASE + UPPER_CASE + NUMBERS + SPECIAL_CHARACTERS;
    private static final SecureRandom random = new SecureRandom();

    private PasswordGenerator() {
    }

    public static String generatePassword(int length) throws IllegalArgumentException {
        if (length < 8) {
            throw new IllegalArgumentException("Password length must be at least 8 characters");
        }

        StringBuilder password = new StringBuilder(length);

        // Generate at least one character from each character type
        password.append(getRandomCharacter(LOWER_CASE));
        password.append(getRandomCharacter(UPPER_CASE));
        password.append(getRandomCharacter(NUMBERS));
        password.append(getRandomCharacter(SPECIAL_CHARACTERS));

        // Generate remaining characters randomly from all character types
        for (int i = 4; i < length; i++) {
            password.append(getRandomCharacter(ALL_CHARACTERS));
        }

        // Shuffle the generated password
        char[] passwordArray = password.toString().toCharArray();
        for (int i = passwordArray.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = passwordArray[index];
            passwordArray[index] = passwordArray[i];
            passwordArray[i] = temp;
        }

        return new String(passwordArray);
    }

    private static char getRandomCharacter(String characters) {
        int index = random.nextInt(characters.length());
        return characters.charAt(index);
    }
}