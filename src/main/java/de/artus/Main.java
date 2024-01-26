package de.artus;

import de.artus.calculator.MathProcessor;
import de.artus.calculator.objects.BracketObject;
import de.artus.calculator.objects.Number;
import de.artus.calculator.objects.PowerObject;
import de.artus.calculator.objects.operations.Addition;
import de.artus.calculator.objects.operations.Multiplication;
import de.artus.calculator.objects.operations.Subtraction;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Number result = MathProcessor.getResult(List.of(new Number(1), new Subtraction(), new Number(1), new Multiplication(), new Number(3), new Multiplication(), new BracketObject(List.of(new Number(-1), new Addition(), new Number(2)))));
        //Number result = MathProcessor.getResult(List.of(new PowerObject(new Number(4), new Number(2.5))));
        Number result = MathProcessor.getResult(List.of(new PowerObject(new BracketObject(List.of(new Number(2), new Addition(), new Number(5))), new Number(2))));
        System.out.println(result.getRealValue());
    }
}