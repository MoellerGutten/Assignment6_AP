package dk.dtu.compute.course02324.mini_java.model;

import dk.dtu.compute.course02324.mini_java.semantics.ProgramVisitor;

public class Declaration implements Statement {

    public final Type type;

    public final Var variable;

    public final Expression expression;

    public Declaration(Type type, Var variable, Expression expression) {
        this.type = type;
        this.variable = variable;
        this.expression = expression;
    }

    public Declaration(Type type, Var variable) {
        this(type, variable, null);
    }

    @Override
    public void accept(ProgramVisitor visitor) {
        visitor.visit(this);
    }

}
