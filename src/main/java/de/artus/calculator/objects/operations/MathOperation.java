package de.artus.calculator.objects.operations;

import de.artus.calculator.objects.MathObject;
import de.artus.calculator.objects.Number;

public interface MathOperation extends MathObject {

    Number getResult(Number a, Number b);

    boolean canBeNumberPrefix();

}
