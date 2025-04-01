package dk.dtu.compute.course02324.mini_java.model;

import dk.dtu.compute.course02324.mini_java.semantics.ProgramVisitor;
import org.jetbrains.annotations.NotNull;

public class ConditionalStatement implements Statement {

    final public Expression expression;

    final public Statement ifStatement;

    final public Statement elseStatement;

    public ConditionalStatement(@NotNull Expression expression, @NotNull Statement statementIf, @NotNull Statement statementElse) {
        this.expression = expression;
        this.ifStatement = statementIf;
        this.elseStatement = statementElse;
    }

    @Override
    public void accept(ProgramVisitor visitor) {
        visitor.visit(this);
    }
}
