package dk.dtu.compute.course02324.mini_java.model;

public class FloatLiteral implements Literal {

    public final float literal;

    public FloatLiteral(float literal) {
        this.literal = literal;
    }

    @Override
    public String toString() {
        return "" + literal;
    }
    
}
