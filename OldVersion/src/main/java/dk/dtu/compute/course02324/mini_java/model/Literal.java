package dk.dtu.compute.course02324.mini_java.model;

import dk.dtu.compute.course02324.mini_java.semantics.ProgramVisitor;

public interface Literal extends Expression {

    @Override
    default public void accept(ProgramVisitor visitor) {
        visitor.visit(this);
    }

}
