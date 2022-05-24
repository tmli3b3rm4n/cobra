package com.cobras.example.demo_cobras;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

import java.util.List;
import java.lang.Math;

public class MainController {
    @FXML
    TextArea scrambleInputField;

    /**
     * Returns random number with in range of min max
     * @param min The starting point of a range
     * @param max The end point of a range of numbers
     * @return
     */
    public int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    /**
     * Checks if input is an int or not. Returns boolean
     * @param input The string in question
     * @return boolean
     */
    protected boolean isInt(String input) {
        try {
            Integer.parseInt(input.replaceAll("[^a-zA-Z0-9]", ""));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Problem 1.  S
     */
    @FXML
    protected void problem1() {
        String str = scrambleInputField.getText();
        if (!isInt(str)) {
            scrambleInputField.setText("Input must be a of type int");
            return;
        }
        Integer target = Integer.parseInt(str);
        scrambleInputField.setText(getSum(target -1).toString());
    }

    /**
     * Returns the sum of all natural numbers <= n 
     * where n is mul
     * tiple of 3 or 5.
     * @param n largest Integer value in the target set.
     * @return The sum.
     */
    protected Integer getSum(Integer n) {
        if (n == 0) {return 0;}
        if(n % 3 == 0 ||n % 5 == 0) {
            return n + getSum(n-1);
        }
        return getSum(n-1);
    }

    /**
     * Handles the on submit request. From the app/
     */
    @FXML
    protected void problem2() {
        scrambleInputField.setText(this.scramble(scrambleInputField.getText()));
    }

    /**
     * Per request this takes in a string and returns a different string shuffled.  For numbers it will leave alone
     * and handles punctuation.
     * @param str
     * @return
     */
    protected String scramble(String str) {
        String[] a = str.split(" ");
        String specialChar = "";
        String res = "";
        // Marker for determining if punctuation is required.
        boolean hasPeriod = false;
        // Marker for determining if a capital letter is required.
        boolean capNext = true;

        for (String aa : a) {
            if (isInt(aa)) {
                res = res.concat(aa.concat(" "));
                continue;
            }

            int y;
            int i = 0;
            String[] b = aa.split("");
            List<Integer> list = new ArrayList<>();
            // For a larger
            while (i < b.length) {
                y = getRandomNumber(0, b.length);
                // This guarantees letters get shuffled.
                if(b.length >= 2 && i == 0) {y = getRandomNumber(1, b.length);}

                if (list.contains(y)) {continue;}

                i++;

                list.add(y);
                switch (b[y]) {
                    case ":" -> {
                        specialChar = ":"; hasPeriod = true;
                        continue;
                    }
                    case "," -> {
                        specialChar = ","; hasPeriod = true;
                        continue;
                    }
                    case "." -> {
                        specialChar = "."; hasPeriod = true;
                        continue;
                    }
                    case "?" -> {
                        specialChar = "?"; hasPeriod = true;
                        continue;
                    }
                    default -> {
                    }
                }

                b[y] = b[y].toLowerCase();

                // Determine:"Does this word need to start with capital letter?"
                if (capNext) {
                    b[y] = b[y].toUpperCase();
                    capNext = false;
                }

                res = res.concat(b[y]);
            }

            // If the word is last word in sentence the next word should have capital letter.
            if (hasPeriod) {
                res = res.concat(specialChar);
                hasPeriod = false;
                if (specialChar.equals(".") ||
                        specialChar.equals(":") ||
                        specialChar.equals("?")) {
                    capNext = true;
                }

            }
            res = res.concat(" ");
        }

        return res;
    }

    @FXML
    protected void onMaginButtonClick() {
        scrambleInputField.setText("Another point of interest is the break statement. Each break statement terminates the enclosing switch statement. Control flow continues with the first statement following the switch block. The break statements are necessary because without them, statements in switch blocks fall through: All statements after the matching case label are executed in sequence, regardless of the expression of subsequent case labels, until a break statement is encountered.");
    }
}