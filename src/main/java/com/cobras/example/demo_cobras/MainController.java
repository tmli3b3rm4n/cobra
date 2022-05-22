package com.cobras.example.demo_cobras;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Math;

public class MainController {
    @FXML
    TextArea scrambleInputField;

    public int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    @FXML
    protected void onSubmitButtonClick() {
        String str = scrambleInputField.getText();
        String[] a = str.split(" ");
        String specialChar = "";
        String res = "";

        boolean hasPeriod = false;
        boolean capNext = false;
        boolean gen = true;

        for (String aa : a) {
            String[] b = aa.split("");
            int y;
            int i = 0;
            List<Integer> list = new ArrayList<>();
            while (i < b.length) {
                y = getRandomNumber(0, b.length);

                if (list.contains(y)) {
                    continue;
                }

                i++;

                list.add(y);
                switch (b[y]) {
                    case ":" -> {
                        specialChar = ":";
                        hasPeriod = true;
                        continue;
                    }
                    case "," -> {
                        specialChar = ",";
                        hasPeriod = true;
                        continue;
                    }
                    case "." -> {
                        specialChar = ".";
                        hasPeriod = true;
                        continue;
                    }
                    default -> {
                    }
                }

                if (capNext || gen) {
                    b[y] = b[y].toUpperCase();
                    capNext = false;
                    gen = false;
                } else {
                    b[y] = b[y].toLowerCase();
                }

                res = res.concat(b[y]);
            }
            if (hasPeriod) {
                res = res.concat(specialChar);
                hasPeriod = false;
                if (specialChar.equals(".") || specialChar.equals(":")){
                    capNext = true;
                }

            }
            res = res.concat(" ");
        }

        scrambleInputField.setText(res);
    }

    @FXML
    protected void onMaginButtonClick() {
        scrambleInputField.setText("Another point of interest is the break statement. Each break statement terminates the enclosing switch statement. Control flow continues with the first statement following the switch block. The break statements are necessary because without them, statements in switch blocks fall through: All statements after the matching case label are executed in sequence, regardless of the expression of subsequent case labels, until a break statement is encountered.");
    }

    @FXML
    protected void onClearButtonClick() {
        scrambleInputField.setText("");
    }

}