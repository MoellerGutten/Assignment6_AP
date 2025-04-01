package dk.dtu.compute.course02324.mini_java.model;

import dk.dtu.compute.course02324.mini_java.semantics.ProgramVisitor;

import org.jetbrains.annotations.NotNull;
import java.util.Objects;

public class Var implements Expression {

    public final String name;

    public Var(@NotNull String name) {
        this.name = name;
    }


    @Override
    public void accept(ProgramVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Var var = (Var) o;
        return Objects.equals(name, var.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
