package dk.dtu.compute.course02324.mini_java.model;

import org.jetbrains.annotations.NotNull;

public enum TypeKeyword {

    INT("int"),
    FLOAT("float");

    private String name;

    TypeKeyword(@NotNull String name) {
        this.name = name;
    }

    final public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
