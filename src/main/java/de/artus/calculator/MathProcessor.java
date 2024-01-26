package de.artus.calculator;

import de.artus.calculator.objects.BracketObject;
import de.artus.calculator.objects.MathObject;
import de.artus.calculator.objects.Number;
import de.artus.calculator.objects.operations.*;

import java.util.ArrayList;
import java.util.List;

public class MathProcessor {

    public static boolean listContainsObject(List<MathObject> objects, Class<? extends MathObject> objectClass) {
        for (MathObject object : objects) {
            if (objectClass.isInstance(object)) {
                return true;
            }
        }
        return false;
    }

    public static Number getResult(List<MathObject> objects) {
        List<MathObject> iteration = new ArrayList<>(objects);
        List<MathObject> newIteration = new ArrayList<>(objects);

        while (iteration.size() > 1) {
            iteration = new ArrayList<>(newIteration);
            newIteration = new ArrayList<>();
            boolean skipNext = false;
            for (int i = 0; i < iteration.size(); i++) {
                if (skipNext) {
                    skipNext = false;
                    continue;
                }
                MathObject object = iteration.get(i);
                if (!object.isNumber()) {
                    if (object instanceof MathOperation mathOperation) {
                        if (mathOperation instanceof Addition || mathOperation instanceof Subtraction) {
                            if (listContainsObject(iteration, Multiplication.class) || listContainsObject(iteration, Division.class)) {
                                newIteration.add(object);
                                continue;
                            }
                        }

                        if (i >= iteration.size() - 1) {
                            // error => "Misplaced math operation symbol! e.g. => 6+4-! Ignoring this symbol...!"
                            continue;
                        }
                        // TODO: what if 2*-5? => 2*(-5) should work
                        Number a = i == 0 && mathOperation.canBeNumberPrefix() ? new Number(0) : iteration.get(i - 1).getValue();
                        Number b = iteration.get(i + 1).getValue();
                        newIteration.remove(newIteration.size() - 1);
                        skipNext = true;
                        newIteration.add(new Number(mathOperation.getResult(a, b).getRealValue()));
                        continue;
                    } else if (object instanceof BracketObject bracket) {
                        newIteration.add(bracket.getValue());
                        continue;
                    }
                } else {
                    newIteration.add(object);
                }
            }
        }
        return iteration.get(0).getValue();
    }

}
