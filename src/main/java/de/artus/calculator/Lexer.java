package de.artus.calculator;

import de.artus.calculator.objects.MathObject;
import de.artus.calculator.objects.Number;
import de.artus.calculator.objects.operations.Addition;
import de.artus.calculator.objects.operations.Division;
import de.artus.calculator.objects.operations.Multiplication;
import de.artus.calculator.objects.operations.Subtraction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lexer {


    public static List<MathObject> getTokensFromString(String input) {
        List<MathObject> tokens = new ArrayList<>();


        for (int i = 0; i < input.length(); i++) {
            Character character = Character.valueOf(input.charAt(i));
            System.out.println("Char: " + character);
            switch (character) {
                case '+' -> tokens.add(new Addition());
                case '-' -> tokens.add(new Subtraction());
                case '*' -> tokens.add(new Multiplication());
                case '/' -> tokens.add(new Division());
                case Character o when Character.isDigit(o) -> {
                    StringBuilder currNum = new StringBuilder();
                    System.out.println("Scanning num i=" + i);
                    int j;
                    for (j = i; j < input.length(); j++) {
                        System.out.println("J=" + j);
                        char char_ = input.charAt(j);
                        if (!Character.isDigit(char_)) break;
                        currNum.append(char_);
                    }
                    i = j - 1;
                    System.out.println(currNum);
                    tokens.add(new Number(Double.parseDouble(currNum.toString())));
                }
                default -> {}
            }

        }

        return tokens;
    }


}
