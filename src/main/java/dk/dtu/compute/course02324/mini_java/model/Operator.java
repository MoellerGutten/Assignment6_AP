package dk.dtu.compute.course02324.mini_java.model;

import org.jetbrains.annotations.NotNull;

public enum Operator {

    PLUS1("+", 1,14, Associativity.RtL),
    PLUS2("+", 2,11, Associativity.LtR),
    MINUS1("-", 1, 14, Associativity.RtL),
    MINUS2("-", 2, 11, Associativity.LtR),
    MULT("*", 2, 12, Associativity.LtR),
    DIV("/", 2, 12, Associativity.LtR),
    MOD("%", 2, 12, Associativity.LtR);;

    private String name;

    public final int arity;

    /**
     * The precedence of each operator. In lack of an official Java
     * precedence, we chose the precedences (and associativities) as
     * provided in
     * <a href="https://introcs.cs.princeton.edu/java/11precedence/"
     * >Appendix A: Operator Precedence in Java</a> of R. Sedgewick's
     * and  K. Wayne's book
     * <a href="https://introcs.cs.princeton.edu/java/home/"
     * >Introduction to Java</a>, Computer Science an Interdisciplinary
     * Approach.<p>
     *
     * Since we are working with abstract syntax trees and do not do any
     * parsing, this information not too important for this project. But,
     * we use it for converting abstract syntax tree to text in a slightly
     * more readable way (by avoiding unnecessary parentheses).
     */
    public final int precedence;

    public final Associativity associativity;

    Operator(@NotNull String name, int arity, int precedence, Associativity associativity) {
        this.name = name;
        this.arity = arity;
        this.precedence = precedence;
        this.associativity = associativity;
    }

    final public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
