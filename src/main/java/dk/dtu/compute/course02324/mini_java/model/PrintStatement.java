package dk.dtu.compute.course02324.mini_java.model;

import dk.dtu.compute.course02324.mini_java.semantics.ProgramVisitor;

public class PrintStatement implements SimpleStatement {

    public final String string;

    public final Expression expression;

    public PrintStatement(String string, Expression expression) {
        this.string = string;
        this.expression = expression;
    }

    @Override
    public void accept(ProgramVisitor visitor) {
        visitor.visit(this);
    }
}
