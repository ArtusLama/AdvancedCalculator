package de.artus.calculator.objects;

import de.artus.calculator.MathProcessor;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BracketObject implements MathObject {

    private List<MathObject> content;

    @Override
    public Number getValue() { return MathProcessor.getResult(content); }
}
