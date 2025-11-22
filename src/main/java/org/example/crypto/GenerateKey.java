package org.example.crypto;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class GenerateKey {

    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();

        String base64Key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        System.out.println("Generated AES-256 Key: " + base64Key);
    }

    //Generated AES-256 Key: UExksGAMpm9Hqa4ZChlwfcEi4wCVziuy+cFm6etOe/4= ;
    //Answer : 8NEriRxIv+5yx1WOXKlthLbWQlRcrTXyHg5G5ycUNRoL4BUIQsNU ;

    //Generated AES-192 Key: O9hfrTowwBJiBLeJjgsEk5I7MQn565Lt ;
    //Answer : CvHN3EDOvbn9BOLPvoXu1Xe8UTzIsvy/AEQ4NotT7pZEfqA6ubPu ;

    //Generated AES-128 Key: 8RjoRTxmRJLHad7s04BwCw== ;
    //Answer: nDG7OCQDsebJbejzQhwEQ+JuR0TxEYAUosxEfkKXV0EhRhQwmmt6 ;
}
