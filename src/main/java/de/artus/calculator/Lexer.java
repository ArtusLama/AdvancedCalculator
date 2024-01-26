package de.artus.calculator;

import de.artus.calculator.objects.BracketObject;
import de.artus.calculator.objects.MathObject;
import de.artus.calculator.objects.Number;
import de.artus.calculator.objects.operations.Addition;
import de.artus.calculator.objects.operations.Division;
import de.artus.calculator.objects.operations.Multiplication;
import de.artus.calculator.objects.operations.Subtraction;

import java.util.ArrayList;
import java.util.List;

public class Lexer {


    public static List<MathObject> getTokensFromString(String input) {
        List<MathObject> tokens = new ArrayList<>();


        for (int i = 0; i < input.length(); i++) {
            Character character = Character.valueOf(input.charAt(i));
            switch (character) {
                case '+' -> tokens.add(new Addition());
                case '-' -> tokens.add(new Subtraction());
                case '*' -> tokens.add(new Multiplication());
                case '/' -> tokens.add(new Division());
                case '(' -> {
                    StringBuilder bracketContent = new StringBuilder();
                    int j;
                    for (j = i + 1; j < input.length(); j++) {
                        char char_ = input.charAt(j);
                        if (char_ == ')') break;
                        bracketContent.append(char_);
                    }
                    i = j;
                    tokens.add(new BracketObject(getTokensFromString(bracketContent.toString())));
                }
                case Character o when Character.isDigit(o) -> {
                    StringBuilder currNum = new StringBuilder();

                    int j;
                    for (j = i; j < input.length(); j++) {
                        char char_ = input.charAt(j);
                        if (!Character.isDigit(char_)) break;
                        currNum.append(char_);
                    }
                    i = j - 1;
                    tokens.add(new Number(Double.parseDouble(currNum.toString())));
                }
                default -> {}
            }

        }

        return tokens;
    }


}
