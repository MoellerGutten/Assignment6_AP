package dk.dtu.compute.course02324.mini_java.model;

import dk.dtu.compute.course02324.mini_java.semantics.ProgramVisitor;
import org.jetbrains.annotations.NotNull;

public class WhileLoop implements Statement {

    final public Expression expression;

    final public Statement statement;

    public WhileLoop(@NotNull Expression expression, @NotNull Statement statement) {
        this.expression = expression;
        this.statement = statement;
    }

    @Override
    public void accept(ProgramVisitor visitor) {
        visitor.visit(this);
    }

}
