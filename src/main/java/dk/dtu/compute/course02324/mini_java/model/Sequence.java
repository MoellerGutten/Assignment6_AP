package dk.dtu.compute.course02324.mini_java.model;

import dk.dtu.compute.course02324.mini_java.semantics.ProgramVisitor;

import java.util.List;

public class Sequence implements Statement {

    public final List<Statement> statements;

    public Sequence(Statement... statements) {
        this.statements = List.of(statements);
    }

    @Override
    public void accept(ProgramVisitor visitor) {
        visitor.visit(this);
    }

}
