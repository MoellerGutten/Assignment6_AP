package dk.dtu.compute.course02324.mini_java.semantics;

import dk.dtu.compute.course02324.mini_java.model.*;

public abstract class ProgramVisitor {

    abstract public void visit(Sequence sequence);

    abstract public void visit(Declaration declaration);

    /**
     * Method requirement for type PrintStatement in visit method
     *
     * @param printStatement
     */
    abstract public void visit(PrintStatement printStatement);

    /**
     * Method requirement for type WhileLoop in visit method
     *
     * @param whileLoop
     */
    abstract public void visit(WhileLoop whileLoop);

    /**
     * Method requirement for type IfThenElse in visit method
     *
     * @param ifThenElse
     */
    abstract public void visit(IfThenElse ifThenElse);

    abstract public void visit(Assignment assignment);

    abstract public void visit(Literal literal);

    abstract public void visit(Var var);

    abstract public void visit(OperatorExpression operatorExpression);

}
