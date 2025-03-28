package dk.dtu.compute.course02324.mini_java.model;

import org.jetbrains.annotations.NotNull;
import java.util.Objects;

public class PrimitiveType implements Type {

    public final TypeKeyword primitiveType;

    public PrimitiveType(@NotNull TypeKeyword primitive) {
        this.primitiveType = primitive;
    }

    @Override
    public String getName() {
        return primitiveType.getName();
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimitiveType that = (PrimitiveType) o;
        return primitiveType == that.primitiveType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(primitiveType);
    }

}
