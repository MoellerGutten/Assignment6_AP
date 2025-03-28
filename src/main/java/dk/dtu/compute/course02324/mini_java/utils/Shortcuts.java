package dk.dtu.compute.course02324.mini_java.utils;

import dk.dtu.compute.course02324.mini_java.model.*;

public class Shortcuts {

    final public static Type INT = new PrimitiveType(TypeKeyword.INT);
    final public static Type FLOAT = new PrimitiveType(TypeKeyword.FLOAT);

    final public static Declaration Declaration(Type type, Var variable, Expression expression) {
        return new Declaration(type, variable, expression);
    }

    final public static Declaration Declaration(Type type, Var variable) {
        return new Declaration(type, variable);
    }

    final public static Var Var(String name) {
        return new Var(name);
    }

    final public static Assignment Assignment(Var variable, Expression expression) {
        return new Assignment(variable, expression);
    }

    final public static OperatorExpression OperatorExpression(Operator operator, Expression... expressions) {
        return new OperatorExpression(operator, expressions);
    }

    final public static Literal Literal(int i) {
        return new IntLiteral(i);
    }

    final public static Literal Literal(float x) {
        return new FloatLiteral(x);
    }

    final public static Sequence Sequence(Statement... statements) {
        return new Sequence(statements);
    }

}
