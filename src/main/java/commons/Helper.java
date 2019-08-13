/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commons;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Alex Christian
 */
public class Helper {

    public static String generateRandomNumber() {
        return new Long((long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L).toString();
    }

    public static String generateVerificationCode() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public static String encryptPassword(String plainText) {
        try {
            Key aesKey = new SecretKeySpec(Common.AES_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(plainText.getBytes());
            return new String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String decryptPassword(String cipherText) {
        try {
            Key aesKey = new SecretKeySpec(Common.AES_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            byte[] decrypted = cipher.doFinal(cipherText.getBytes());
            return new String(cipher.doFinal(decrypted));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void sendVerificationEmail(String to, String vercode) {
        String from = (Common.EMAIL_FROM);
        System.out.println(from);
        final String username = (Common.EMAIL_USERNAME);
        final String password = (Common.EMAIL_PASSWORD);
        String host = "smtp.gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("Welcome to Travel Management System By Team Object");
            message.setText("Your Verification code is : " + vercode);
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

}
