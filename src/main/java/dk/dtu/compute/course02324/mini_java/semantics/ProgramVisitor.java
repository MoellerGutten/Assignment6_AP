package dk.dtu.compute.course02324.mini_java.semantics;

import dk.dtu.compute.course02324.mini_java.model.*;

public abstract class ProgramVisitor {

    abstract public void visit(Sequence sequence);

    abstract public void visit(Declaration declaration);

    abstract public void visit(Assignment assignment);

    abstract public void visit(Literal literal);

    abstract public void visit(Var var);

    abstract public void visit(OperatorExpression operatorExpression);

}
