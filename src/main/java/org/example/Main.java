package org.example;

import org.example.crypto.DecryptExample;
import org.example.crypto.EncryptExample;
import org.example.utils.ConsoleColors;
import org.example.utils.NumberUtils;
import org.example.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        System.out.println(ConsoleColors.GREEN + "Program has started!" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED + "ERROR: Invalid configuration detected!" + ConsoleColors.RESET);

        // --- VALIDATION: LIST ---
        Utils.printSection("VALIDATION: LIST", ConsoleColors.GREEN);
        demoValidateList();

        // --- VALIDATION: SINGLE VALUES ---
        Utils.printSection("VALIDATION: SINGLE VALUES", ConsoleColors.CYAN);
        demoValidateSingle();

        // --- PARSE NUMBERS (String -> int) ---
        Utils.printSection("PARSE NUMBERS (String -> int)", ConsoleColors.BLUE);
        demoParseNumbers();

        // --- STREAM BASICS ---
        Utils.printSection("STREAM BASICS", ConsoleColors.PURPLE);
        demoStreams();

        // --- NAMES / LOGGING ---
        Utils.printSection("NAMES / LOGGING", ConsoleColors.YELLOW);
        demoNamesAndLogging();

        // --- Encrypt Result ---
        Utils.printSection("Encrypt/Decrypt" , ConsoleColors.MAGENTA);

        Utils.log("Program finished");
    }

    public static void demoValidateList() {
        List<Integer> mixedNumbers = new ArrayList<>(Arrays.asList(2, -3, 5, 7, -9, -11, 23, 43, -56));

        try {
            NumberUtils.validatePositive(mixedNumbers);
            System.out.println("All numbers are positive!");
        } catch (InvalidNumberException e) {
            System.out.println("Error: " + e.getMessage()
                    + (e.getInvalidValue() != null ? "Value: " + e.getInvalidValue() : ""));
        }
    }

    public static void demoValidateSingle() {
        try {
            NumberUtils.validatePositive(5);
            NumberUtils.validatePositive(-3);
        } catch (InvalidNumberException e) {
            System.out.println("Error: " + e.getMessage() + " Value: " + e.getInvalidValue());
        }
    }

    public static void demoParseNumbers() {
        List<String> inputStrings = List.of("10", "20", "ABC", "30");
        try {
            List<Integer> numbers4 = NumberUtils.parseNumbers(inputStrings);
            System.out.println("Parsed numbers : " + numbers4);
        } catch (InvalidNumberException e) {
            System.out.println("Wrong movement : One part isn't number! Default: " + e.getMessage());
        }

        System.out.println("Program continue");
    }

    private static void demoStreams() {
        List<Integer> a = List.of(1, 2, 3);
        List<Integer> b = new ArrayList<>(Arrays.asList(4, 5, 6));

        List<Integer> range = IntStream.rangeClosed(7, 10)
                .boxed()
                .toList();

        List<Integer> combined = Stream.concat(a.stream(), b.stream())
                .toList();

        System.out.println("A: " + a);
        System.out.println("B: " + b);
        System.out.println("Combined: " + combined);
        System.out.println("Range 7..10:" + range);
    }

    private static void demoNamesAndLogging() {

        String[] names = {"Anna", "Oszkár", "Zino"};
        String name1 = "márk";
        String name2 = "GP";

        Utils.log("App started with " + names.length + " names");


        for (String n : names) {
            System.out.println(Utils.capitalize(n));
        }
        System.out.println(Utils.capitalize(name1));
        System.out.println(Utils.capitalize(name2));
    }

    public static void demoEncryptDecrypt() {
        String plaintext = "This is a secret message";
        String password  = "VeryStrongPassword123";

        Utils.log("Plaintext : " + plaintext);
        Utils.log("Password  : " + password);

        String key = "8RjoRTxmRJLH...";
        String text = "Hello Hydra!";

        String encrypted = EncryptExample.encrypt(text, key);
        String decrypted = DecryptExample.decrypt(encrypted, key);

        Utils.printSection("Encrypt/Decrypt", ConsoleColors.MAGENTA);
        Utils.log("Encrypted: " + encrypted);
        Utils.log("Decrypted: " + decrypted);

    }
}
