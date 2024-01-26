package de.artus.calculator.objects;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PowerObject implements MathObject {

    private MathObject base;
    private MathObject exponent;


    @Override
    public Number getValue() {
        return new Number(Math.pow(base.getValue().getRealValue(), exponent.getValue().getRealValue()));
    }
}
