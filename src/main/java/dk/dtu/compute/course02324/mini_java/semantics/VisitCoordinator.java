package dk.dtu.compute.course02324.mini_java.semantics;

import dk.dtu.compute.course02324.mini_java.model.*;

public class VisitCoordinator {

    private ProgramVisitor visitor;

    public VisitCoordinator(ProgramVisitor visitor) {
        this.visitor = visitor;
    }

    public void visit(Statement statement) {
        if (statement instanceof Sequence) {
            visit((Sequence) statement);
        } else if (statement instanceof Declaration) {
            visit((Declaration) statement);
        } else if (statement instanceof Assignment) {
            visit((Assignment)  statement);
        } else {
            assert false;
        }
    }

    private void visit(Sequence sequence) {
        for (Statement substatement: sequence.statements) {
            visit(substatement);
        }
        sequence.accept(visitor);
    }

    private void visit(Declaration declaration) {
        if (declaration.expression != null) {
            visit(declaration.expression);
        }
        declaration.accept(visitor);
    }

    private void visit(Assignment assignment) {
        visit(assignment.expression);
        assignment.accept(visitor);
    }

    private void visit(Expression expression) {
        if (expression instanceof Literal) {
            visit((Literal) expression);
        } else if (expression instanceof Assignment) {
            visit((Assignment) expression);
        } else if (expression instanceof Var) {
            visit((Var) expression);
        } else if (expression instanceof OperatorExpression) {
            visit((OperatorExpression) expression);
        } else {
            assert false; // this should not happen
        }
    }

    private void visit(OperatorExpression operatorExpression) {
        for (Expression subexpression: operatorExpression.operands) {
            visit(subexpression);
        }
        operatorExpression.accept(visitor);
    }

    private void visit(Literal literal) {
        literal.accept(visitor);
    }

    private void visit(Var var) {
        var.accept(visitor);
    }

}
