package dk.dtu.compute.course02324.mini_java.infrastructure;

import dk.dtu.compute.course02324.mini_java.semantics.ProgramVisitor;

public interface VisitAcceptor {

    public void accept(ProgramVisitor visitor);

}
