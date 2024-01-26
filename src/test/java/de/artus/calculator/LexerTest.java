package de.artus.calculator;


import de.artus.calculator.objects.BracketObject;
import de.artus.calculator.objects.MathObject;
import de.artus.calculator.objects.Number;
import de.artus.calculator.objects.operations.Addition;
import de.artus.calculator.objects.operations.Division;
import de.artus.calculator.objects.operations.Multiplication;
import de.artus.calculator.objects.operations.Subtraction;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LexerTest {

    @Test
    public void testGetTokensFromString() {
        String mathInput = "-2+4*5/10+3333+400";
        List<MathObject> tokens = Lexer.getTokensFromString(mathInput);
        Assert.assertEquals(tokens, List.of(new Subtraction(), new Number(2), new Addition(), new Number(4),
                new Multiplication(), new Number(5), new Division(), new Number(10), new Addition(),
                new Number(3333), new Addition(), new Number(400)));
    }

    @Test
    public void testBigNums() {
        String mathInput = "500500";
        List<MathObject> tokens = Lexer.getTokensFromString(mathInput);
        Assert.assertEquals(new Number(500500), tokens.get(0).getValue());

    }

    @Test
    public void testSimple() {
        String mathInput = "100+100";
        List<MathObject> tokens = Lexer.getTokensFromString(mathInput);
        Assert.assertEquals(new ArrayList<>(List.of(new Number(100), new Addition(), new Number(100))), tokens);
    }

    @Test
    public void bracketTest() {
        String mathInput = "2*(5+5)";
        List<MathObject> tokens = Lexer.getTokensFromString(mathInput);
        Assert.assertEquals(new ArrayList<>(List.of(new Number(2), new Multiplication(), new BracketObject(List.of(new Number(5), new Addition(), new Number(5))))), tokens);
    }
}