package dk.dtu.compute.course02324.mini_java;

import dk.dtu.compute.course02324.mini_java.model.*;
import dk.dtu.compute.course02324.mini_java.semantics.*;

import static dk.dtu.compute.course02324.mini_java.utils.Shortcuts.*;
import static dk.dtu.compute.course02324.mini_java.model.Operator.*;

public class MiniJavaRun {

    public static void printTypeEvaluate(Statement statement) {
        System.out.println("Result by our program:");

        ProgramSerializerVisitor ps = new ProgramSerializerVisitor();
        VisitCoordinator vc = new VisitCoordinator(ps);
        vc.visit(statement);
        System.out.println(ps.result());

        ProgramTypeVisitor pv = new ProgramTypeVisitor();
        vc = new VisitCoordinator(pv);
        vc.visit(statement);

        if (!pv.problems.isEmpty()) {
            System.out.println("There were some problems in the statement:");
            for (String problem : pv.problems) {
                System.out.println(problem);
            }
        } else {
            System.out.println("Expression type checks correctly");
            for (Var var: pv.variables) {
                System.out.println(pv.typeMapping.get(var).getName() + " " + var.name + ";");
            }

            ProgramEvaluatorVisitor pev = new ProgramEvaluatorVisitor(pv);
            vc = new VisitCoordinator(pev);
            vc.visit(statement);

            for (Var var: pv.variables) {
                System.out.println(var.name + " = " + pev.values.get(var));
            }
        }
        System.out.println("------------------------------");
    }

    public static void main(String... args) {
        System.out.println("Result provided by Java");
        int i;
        int j = i = 2 + (i = 3) ;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println();

        Statement statement = Sequence(
                Declaration(INT, Var("i")),
                Declaration(
                        INT,
                        Var("j"),
                        Assignment(
                                Var("i"),
                                OperatorExpression(
                                        PLUS2,
                                        Literal(2),
                                        Assignment(
                                                Var("i"),
                                                Literal(3)
                                        )
                                )
                        )
                )
        );

        printTypeEvaluate(statement);

        System.out.println("Result provided by Java");
        float ii;
        float jj = ii = 2.75f - ( ii = 3.21f );
        System.out.println("i = " + ii);
        System.out.println("j = " + jj);
        System.out.println();


        // Note that from here we do not make (much) use of the Shorthands.
        // See what difference it makes.
        Statement statement2 =
                new Sequence(
                        new Declaration(FLOAT, new Var("i")),
                        new Declaration(
                                FLOAT,
                                new Var("j"),
                                new Assignment(
                                        new Var("i"),
                                        new OperatorExpression(
                                                Operator.MINUS2,
                                                new FloatLiteral(2.75f),
                                                new Assignment(
                                                        new Var("i"),
                                                        Literal(3.21f)
                                                )
                                        )
                                )
                        )
                );

        printTypeEvaluate(statement2);

        System.out.println("Result provided by Java");
        float iii;
        float jjj = iii = 2.75f + ( iii = 3.21f ) - 2.1f * iii;
        System.out.println("i = " + iii);
        System.out.println("j = " + jjj);
        System.out.println();

        Statement statement3 = new Sequence(
                new Declaration(FLOAT, new Var("i")),
                new Declaration(
                        FLOAT,
                        new Var("j"),
                        new Assignment(
                                new Var("i"),
                                new OperatorExpression(
                                        MINUS2,
                                        new OperatorExpression(Operator.PLUS2,
                                                new FloatLiteral(2.75f),
                                                new Assignment(
                                                        new Var("i"),
                                                        new FloatLiteral(3.21f)
                                                )
                                        ),
                                        new OperatorExpression(
                                                MULT,
                                                new FloatLiteral(2.1f),
                                                new Var("i")
                                        )
                                )
                        ))

        );

        printTypeEvaluate(statement3);

        System.out.println("Some incorrect programs");

        Statement statement4 =
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
                        )
                );

        printTypeEvaluate(statement4);

        Statement statement5 = new Sequence(
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
                                                new FloatLiteral(3)
                                        )))
                )
        );

        printTypeEvaluate(statement5);

        System.out.println("And now some syntactially wrong examples (crashing) when building statement!");

        Statement statement6 = new Sequence(
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
                                                new FloatLiteral(3)),
                                        new FloatLiteral(3.5f)
                                        ))
                )
        );
    }

}
