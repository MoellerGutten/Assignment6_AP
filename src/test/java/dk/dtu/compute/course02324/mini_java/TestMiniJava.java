package dk.dtu.compute.course02324.mini_java;

import dk.dtu.compute.course02324.mini_java.model.*;
import dk.dtu.compute.course02324.mini_java.semantics.ProgramEvaluatorVisitor;
import dk.dtu.compute.course02324.mini_java.semantics.ProgramSerializerVisitor;
import dk.dtu.compute.course02324.mini_java.semantics.ProgramTypeVisitor;
import dk.dtu.compute.course02324.mini_java.semantics.VisitCoordinator;

import static dk.dtu.compute.course02324.mini_java.utils.Shortcuts.*;
import static dk.dtu.compute.course02324.mini_java.model.Operator.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * These are some basic tests of the MiniJava for computing the types and
 * evaluating expressions.
 */
public class TestMiniJava{


    // private ProgramSerializerVisitor psv;
    // private VisitCoordinator svc;

    private ProgramTypeVisitor ptv;
    private VisitCoordinator tvc;

    private ProgramEvaluatorVisitor pev;
    private VisitCoordinator evc;



    /**
     *  Sets
     */
    @BeforeEach
    public void setUp() {
        // psv = new ProgramSerializerVisitor();
        // svc = new VisitCoordinator(psv);

        ptv = new ProgramTypeVisitor();
        tvc = new VisitCoordinator(ptv);

        pev = new ProgramEvaluatorVisitor(ptv);
        evc = new VisitCoordinator(pev);
    }

    @Test
    public void testCorrectProgramWithInts() {
        int i;
        int j = i = 2 + (i = 3) ;

        Statement statement = new Sequence(
                new Declaration(INT, new Var("i")),
                new Declaration(
                        INT,
                        new Var("j"),
                        new Assignment(
                                new Var("i"),
                                new OperatorExpression(
                                        PLUS2,
                                        new IntLiteral(2),
                                        new Assignment(
                                                new Var("i"),
                                                new IntLiteral(3)
                                        )))
                )
        );

        tvc.visit(statement);
        if (!ptv.problems.isEmpty()) {
            fail("The type visitor did detect typing problmes, which should not be there!");
        }

        evc.visit(statement);

        Set<String> variables = new HashSet<>(List.of("i", "j"));
        for (Var var: ptv.variables) {
            variables.remove(var.name);

            if (var.name.equals("i")) {
                assertEquals(i, pev.values.get(var), "Value of variable i should be " + i + ".");
            } else if (var.name.equals("j")) {
                assertEquals(j, pev.values.get(var), "Value of variable j should be " + j + ".");
            } else {
                fail("A non-existing variable " + var.name + " occurred in evaluation of program.");
            }
        }
        assertEquals(0, variables.size(), "Some variables have not been evaluated");
    }

    @Test
    public void testCorrectlyTypedProgramWithFloats() {
        System.out.println("Result provided by Java");
        float i;
        float j = i = 2.75f - ( i = 3.21f );

        Statement statement =
                new Sequence(
                        new Declaration(FLOAT, new Var("i")),
                        new Declaration(
                                FLOAT,
                                new Var("j"),
                                new Assignment(
                                        new Var("i"),
                                        new OperatorExpression(
                                                MINUS2,
                                                new FloatLiteral(2.75f),
                                                new Assignment(
                                                        new Var("i"),
                                                        new FloatLiteral(3.21f)
                                                )
                                        )
                                )
                        )
                );

        tvc.visit(statement);
        if (!ptv.problems.isEmpty()) {
            fail("The type visitor did detect typing problmes, which should not be there!");
        }
        evc.visit(statement);

        Set<String> variables = new HashSet<>(List.of("i", "j"));
        for (Var var: ptv.variables) {
            variables.remove(var.name);

            if (var.name.equals("i")) {
                assertEquals(i, pev.values.get(var), "Value of variable i should be " + i + ".");
            } else if (var.name.equals("j")) {
                assertEquals(j, pev.values.get(var), "Value of variable j should be " + j + ".");
            } else {
                fail("A non-existing variable " + var.name + " occurred in evaluation of program.");
            }
        }
        assertEquals(0, variables.size(), "Some variables have not been evaluated");

    }

    @Test
    public void testWronglyTypedProgram() {
        int i;
        int j = i = 2 + (i = 3) ;

        Statement statement =
                new Sequence(
                        new Declaration(FLOAT, new Var("i")),
                        new Declaration(INT, new Var("j")),
                        new Declaration(
                                FLOAT,
                                new Var("j"),
                                new Assignment(
                                        new Var("i"),
                                        new OperatorExpression(
                                                MINUS2,
                                                new FloatLiteral(2.75f),
                                                new Assignment(
                                                        new Var("i"),
                                                        new FloatLiteral(3.21f)
                                                )
                                        )
                                )
                        ),
                        Assignment(Var("i"), Var("k")),
                        Assignment(Var("k"), Literal(3))
                );

        tvc.visit(statement);

        if (ptv.problems.isEmpty()) {
            fail("No type problems detected in a mistyped statement!");
        }
    }



}
