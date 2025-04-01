package dk.dtu.compute.course02324.mini_java.model;

public class IntLiteral implements Literal {

    public final int literal;

    public IntLiteral(int literal) {
        this.literal = literal;
    }

    @Override
    public String toString() {
        return "" + literal;
    }

}
