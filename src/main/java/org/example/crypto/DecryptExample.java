package org.example.crypto;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DecryptExample {
    public static void main(String[] args) throws Exception {

        String base64Key = "8RjoRTxmRJLHad7s04BwCw==";
        String token = "nDG7OCQDsebJbejzQhwEQ+JuR0TxEYAUosxEfkKXV0EhRhQwmmt6";

        byte[] all = Base64.getDecoder().decode(token);

        final int IV_LEN = 12;
        if (all.length <= IV_LEN) throw new IllegalAccessException("Token too short");
        byte[] iv = new byte[IV_LEN];
        byte[] ct = new byte[all.length - IV_LEN];
        System.arraycopy(all, 0, iv, 0, IV_LEN);
        System.arraycopy(all, IV_LEN, ct, 0, ct.length);

        SecretKey key = new SecretKeySpec(Base64.getDecoder().decode(base64Key), "AES");

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(128,iv);
        cipher.init(Cipher.DECRYPT_MODE, key, spec);

        byte[] plain = cipher.doFinal(ct);
        String message = new String(plain, StandardCharsets.UTF_8);
        System.out.println("Decrypted: " + message);
    }
}
