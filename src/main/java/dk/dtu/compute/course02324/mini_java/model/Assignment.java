package dk.dtu.compute.course02324.mini_java.model;

import dk.dtu.compute.course02324.mini_java.semantics.ProgramVisitor;
import org.jetbrains.annotations.NotNull;


public class Assignment implements SimpleStatement, Expression {

    public final Var variable;

    public final Expression expression;

    public Assignment(Var variable, @NotNull Expression expression) {
        this.variable = variable;
        this.expression = expression;
    }

    @Override
    public void accept(ProgramVisitor visitor) {
        visitor.visit(this);
    }

}
