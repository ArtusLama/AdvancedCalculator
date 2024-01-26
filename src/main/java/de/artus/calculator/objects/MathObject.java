package de.artus.calculator.objects;

public interface MathObject {

    Number getValue();

    default boolean isNumber() {
        return false;
    }
}
