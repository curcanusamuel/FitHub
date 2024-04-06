package com.example.spring;

import java.sql.Date;
import java.time.LocalDate;

public class Cezar {

    private String password;
    private int n;

    public String computePassword(String password,String passLevel) {
        this.password=password;
        if (passLevel.equals("Medium")) {
            this.n = 4;
        } else if (passLevel.equals("Easy")) {
            this.n = 1;
        } else {
            this.n = Date.valueOf(LocalDate.now()).getDay();
        }
        StringBuilder newPassword = new StringBuilder();
        for (int i = 0; i < this.password.length(); i++) {
            char currentChar = this.password.charAt(i);
            char encryptedChar = (char) (currentChar + this.n);

            if (Character.isDigit(encryptedChar) || (encryptedChar >= 'a' && encryptedChar <= 'z')) {
                newPassword.append(encryptedChar);
            } else {
                char adjustedChar;
                if (Character.isDigit(encryptedChar)) {
                    adjustedChar = (char) ('0' + (encryptedChar - '0') % 10);
                } else {
                    adjustedChar = (char) ('a' + (encryptedChar - 'a') % 26);
                }
                newPassword.append(adjustedChar);
            }
        }
        return newPassword.toString();
    }


}
