package dk.dtu.compute.course02324.mini_java.semantics;

import dk.dtu.compute.course02324.mini_java.model.*;
import static dk.dtu.compute.course02324.mini_java.model.Operator.*;
import static dk.dtu.compute.course02324.mini_java.utils.Shortcuts.*;

import java.util.*;

import static java.util.Map.entry;

public class ProgramTypeVisitor extends ProgramVisitor {

    /**
     * This is a very simple map of operators to their possible types.
     * Note the typing of an operator is very simplistic for now; the
     * types of all operands and the result of te operation are the same.
     */
    final private Map<Operator,List<Type>> operatorTypes = Map.ofEntries(
            entry(PLUS2, List.of(INT, FLOAT)),
            entry(MINUS2, List.of(INT, FLOAT)),
            entry(MULT, List.of(INT, FLOAT)));

    final public Map<Expression, Type> typeMapping = new HashMap<>();

    final public Set<Var> variables = new HashSet<>();

    final public List<String> problems = new ArrayList<>();

    @Override
    public void visit(Sequence sequence) {
        // nothing to do for Sequence for type checkin
    }

    @Override
    public void visit(Declaration declaration) {
        Var variable = declaration.variable;
        if (variables.contains(variable)) {
            problems.add("Variable " + variable.name + " declared more than once.");
        } else {
            variables.add(variable);
            typeMapping.put(variable, declaration.type);
            if (declaration.expression != null) {
                Type expressionType = typeMapping.get(declaration.expression);
                if (expressionType == null) {
                    problems.add("Expression in declaration of " +
                            declaration.type + " " + declaration.variable.name +
                            " has no type.");
                } else if (!declaration.type.equals(expressionType)) {
                    problems.add("Expression in declaration of " +
                            declaration.type + " " + declaration.variable.name +
                            " hass wrong type: " + expressionType + ".");
                }
            }
        }
    }

    @Override
    public void visit(Assignment assignment) {
        if (variables.contains(assignment.variable)) {
            Type type = typeMapping.get(assignment.variable);
            Type expressionType = typeMapping.get(assignment.expression);
            if (expressionType == null) {
                problems.add("Expression in assignment to variable " +
                        assignment.variable.name + " has no type.");
            } else if (!type.equals(typeMapping.get(assignment.expression))) {
                problems.add("Type mismatch in assignment to variable " +
                        type + " " + assignment.variable.name + ": Expression is of type " +
                        expressionType + "."
                );
            } else {
                typeMapping.put(assignment, type);
            }
        } else {
            problems.add("Variable " + assignment.variable.name + " not defined.");
        }
    }

    @Override
    public void visit(Literal literal) {
        if (literal instanceof IntLiteral) {
            typeMapping.put(literal, INT);
        }  else if (literal instanceof FloatLiteral) {
            typeMapping.put(literal, FLOAT);
        }
    }

    @Override
    public void visit(Var var) {
        if (!variables.contains(var)) {
            problems.add("Variable not defined " + var);
        } else if (typeMapping.get(var) == null) {
            // this should actually not happen
            problems.add("Variable " + var.name + " does not have a type.");
        }
    }

    @Override
    public void visit(OperatorExpression operatorExpression) {
        Type operandType = null;
        for (Expression subexpression: operatorExpression.operands) {
            Type subexpressionType = typeMapping.get(subexpression);
            if (subexpressionType == null) {
                problems.add("Subexpression of " + operatorExpression.operator + " does not have a type.");
            }
            if (operandType == null) {
                operandType = subexpressionType;
            } else if (!operandType.equals(subexpressionType)) {
                problems.add("Subexpressions type mismatch in " + operatorExpression.operator + ".");
            }
        }
        if (operandType != null) {
            List<Type> opTypes = operatorTypes.get(operatorExpression.operator);
            if (opTypes != null && opTypes.contains(operandType)) {
                typeMapping.put(operatorExpression, operandType);
            } else {
                problems.add("Operator does not support the type of its operands. Operator is " + operatorExpression.operator + " and operand type is " + operandType);
            }
        } else {
            problems.add("Expressions does not have a type: Operator " + operatorExpression.operator);
        }
    }

}
