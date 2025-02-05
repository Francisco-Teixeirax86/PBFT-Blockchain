package core.util;

import core.model.Transaction;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class CryptoUtils {

    public static String calculateHash(String previousHash, List<Transaction> transactions, long timestamp, int nonce){
        String data = previousHash + transactions.toString() + timestamp + nonce;

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
