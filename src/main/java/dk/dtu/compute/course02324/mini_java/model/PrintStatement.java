package dk.dtu.compute.course02324.mini_java.model;

import dk.dtu.compute.course02324.mini_java.semantics.ProgramVisitor;
import org.jetbrains.annotations.NotNull;

public class PrintStatement implements Statement {

    final public String prefix;

    final public Expression expression;

    public PrintStatement(@NotNull String prefix, @NotNull Expression expression) {
        this.prefix = prefix;
        this.expression = expression;
    }

    @Override
    public void accept(ProgramVisitor visitor) {
        visitor.visit(this);
    }

}
