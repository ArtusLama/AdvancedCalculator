package de.artus.calculator.objects;

import de.artus.calculator.MathProcessor;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class BracketObject implements MathObject {

    private List<MathObject> content;

    @Override
    public Number getValue() { return MathProcessor.getResult(content); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BracketObject that = (BracketObject) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
