package com.gabriel.martins.apinaescola.model.utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecurityGeneric {
    
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    
    protected static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
    
    public static String getSecurePassword(String password) {

        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    
    private static byte[] digest(byte[] input) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }
    
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
    public static String getHashUser(String document){
        byte[] md5InBytes = digest(document.getBytes(UTF_8));
        return bytesToHex(md5InBytes);
    }
    
    public static String generateSecurityKey(){
        int maxCharacters = 8;
        String[] characters = { "a", "1", "b", "2", "4", "5", "6", "7", "8",
                "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
                "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y", "Z","!","#","$","%" };

        StringBuilder securityKey = new StringBuilder();

        for (int i = 0; i < maxCharacters; i++) {
            int posicao = (int) (Math.random() * characters.length);
            securityKey.append(characters[posicao]);
        }

        return securityKey.toString();
    }
    
    public static String gerarSenhaAleatoria(){
        int maxCharacters = 8;
        String[] characters = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
       
        StringBuilder senhaAleatoria = new StringBuilder();

        for (int i = 0; i < maxCharacters; i++) {
            int posicao = (int) (Math.random() * characters.length);
            senhaAleatoria.append(characters[posicao]);
        }
        
        return senhaAleatoria.toString();
    }
}
