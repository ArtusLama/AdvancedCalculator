package de.artus.calculator.objects.operations;

import de.artus.calculator.objects.Number;

import java.util.Objects;

public class Subtraction implements MathOperation {


    @Override
    public Number getResult(Number a, Number b) {
        return new Number(a.getRealValue() - b.getRealValue());
    }

    @Override
    public boolean canBeNumberPrefix() { return true; }


    @Override
    public Number getValue() { return null; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash("-");
    }
}
