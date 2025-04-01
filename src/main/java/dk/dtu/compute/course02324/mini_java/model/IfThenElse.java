package dk.dtu.compute.course02324.mini_java.model;

import dk.dtu.compute.course02324.mini_java.semantics.ProgramVisitor;
import org.jetbrains.annotations.NotNull;

public class IfThenElse implements Statement {
    final public Expression expression;

    final public Statement ifStatement;
    final public Statement elseStatement;

    public IfThenElse(@NotNull Expression expression, @NotNull Statement ifStatement, @NotNull Statement elseStatement) {
        this.expression = expression;
        this.ifStatement = ifStatement;
        this.elseStatement = elseStatement;
    }

    @Override
    public void accept(ProgramVisitor visitor) {
        visitor.visit(this);
    }
}
