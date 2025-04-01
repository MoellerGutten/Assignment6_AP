package dk.dtu.compute.course02324.mini_java.utils;

import dk.dtu.compute.course02324.mini_java.model.*;
import org.jetbrains.annotations.NotNull;

/**
 * This class allows writing abstract syntax trees of Mini Java in a
 * slightly more compact, elegant and readable way. It allows omitting a
 * lot of new-statements. These shortcuts can be used in other classes
 * by importing this class statically, which is called a "static import":
 *
 * <blockquote><code>
 *   import static dk.dtu.compute.course02324.mini_java.utils.Shortcuts.*;
 * </code></blockquote>
 *
 * In this Mini Java project, these shortcuts are used extensively in the
 * {@link dk.dtu.compute.course02324.mini_java.MiniJavaRun#main main} method
 * of {@link dk.dtu.compute.course02324.mini_java.MiniJavaRun MiniJavaRun}
 * when defining the Mini Java programs in abstract syntax. And there, you
 * can also compare the difference of using the shortcuts and not using
 * them; some examples still use the raw notation with explicit
 * new-statements.<p>
 *
 * <q>"Static imports can make your program <i>more</i> readable, by
 * removing the boilerplate of repetition of class names"</q>
 * [<a href="https://docs.oracle.com/javase/1.5.0/docs/guide/language/static-import.html">Java SE Documentation</a>].
 * But, they should be used sparingly because they can also <q>"make your program
 * unreadable and unmaintainable, polluting its namespace with all the
 * static members you import"</q>
 * [<a href="https://docs.oracle.com/javase/1.5.0/docs/guide/language/static-import.html">Java SE Documentation</a>],
 * in particular when importing all members of a class (i.e. when using .*
 * in the end) in a static import.
 *
 * @see <a href="https://docs.oracle.com/javase/1.5.0/docs/guide/language/static-import.html"
 *      >Java SE Documentation (Java 5): Static Import</a>
 * @see <a href="https://docs.oracle.com/javase/7/docs/technotes/guides/language/static-import.html"
 *      >Java SE Documentation (Java 7): Static Import</a>
 */
public class Shortcuts {

    final public static Type INT = new PrimitiveType(TypeKeyword.INT);

    final public static Type FLOAT = new PrimitiveType(TypeKeyword.FLOAT);

    final public static Declaration Declaration(@NotNull Type type, @NotNull Var variable, @NotNull Expression expression) {
        return new Declaration(type, variable, expression);
    }

    final public static Declaration Declaration(@NotNull Type type, @NotNull Var variable) {
        return new Declaration(type, variable);
    }

    final public static PrintStatement PrintStatement(@NotNull String prefix, @NotNull Expression expression) {
        return new PrintStatement(prefix, expression);
    }

    final public static Assignment Assignment(@NotNull Var variable, @NotNull Expression expression) {
        return new Assignment(variable, expression);
    }

    final public static OperatorExpression OperatorExpression(@NotNull Operator operator, Expression... expressions) {
        return new OperatorExpression(operator, expressions);
    }

    final public static Var Var(@NotNull String name) {
        return new Var(name);
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

    final public static WhileLoop WhileLoop(@NotNull Expression expression, @NotNull Statement statement) {
        return new WhileLoop(expression, statement);
    }

}
