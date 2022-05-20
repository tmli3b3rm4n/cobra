package com.cobras.example.demo_cobras;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.HashMap;
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
        String res = "";
        for (String aa : a) {
            int y;
            boolean hasPeriod = false;
            //boolean hasComma = false;
            String[] b = aa.split("");

            Map<Integer, String> map =  new HashMap<>();
            int i = 0;
            for (String bb : b) {
                boolean x = true;
                while (x) {
                    y = getRandomNumber(0, b.length);
                    if (bb.equals(".")) {
                        hasPeriod = true;
                    }

                    // Keep looping till a missing index is found.
                    // The cost for random.  I chose this way given the imput size would typically
                    // the size of a word.  I acknowledge this wouldn't work well with large imputs.
                    boolean result = map.containsKey(y);
                    if (result) {
                        continue;
                    }
                    map.put(y, b[y]);
                    x = false;
                    if (!hasPeriod) {
                        res = res.concat(b[y]);
                    }
                    i++;
                }
            }
            if (hasPeriod) {
                res = res.concat(".");
            }
            res = res.concat(" ");
            scrambleInputField.setText(res);
        }

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