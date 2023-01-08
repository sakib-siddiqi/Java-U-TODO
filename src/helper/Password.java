/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.lang.System.Logger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 *
 * @author user
 */
public class Password {

    public MessageDigest digest;
    public String hash;

    public Password(String password) {
        try {
            digest = MessageDigest.getInstance("SHA-256");
            hash = (digest.digest(password.getBytes(StandardCharsets.UTF_8))).toString();

        } catch (NoSuchAlgorithmException ex) {
            System.out.println("\t 🪲 --->" + ex.getMessage());
        }
    }

    public boolean isMatched(String password) {
        return hash == password;
    }
}
