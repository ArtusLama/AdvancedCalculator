package de.artus.calculator.objects;


import lombok.AllArgsConstructor;

import java.util.Objects;


@AllArgsConstructor
public class Number implements MathObject {


    private double value;

    public double getRealValue() {
        return value;
    }

    @Override
    public Number getValue() {
        return this;
    }

    @Override
    public boolean isNumber() { return true; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return Double.compare(number.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
