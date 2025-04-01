package dk.dtu.compute.course02324.mini_java.model;

import dk.dtu.compute.course02324.mini_java.semantics.ProgramVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public  class OperatorExpression implements Expression {

    public final Operator operator;

    public final List<Expression> operands;

    public OperatorExpression(@NotNull Operator operator, Expression... operands) {
        if (operator.arity != operands.length) {
            throw new IllegalArgumentException(
                    "The number of operands (" +
                            operands.length +
                            ") does not match the operators arity (" +
                            operator.arity + ")."
                    );
        }
        this.operator = operator;
        this.operands = List.of(operands);
    }

    @Override
    public void accept(ProgramVisitor visitor) {
        visitor.visit(this);
    }

}
