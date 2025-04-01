/**
 * Module for assignment3 of the course 02324 in spring 2025.
 *
 * @author Ekkart Kindler, ekki@dtu.dk
 */
module dk.dtu.compute.course02324.mini_java {

    requires org.jetbrains.annotations;
    requires javafx.controls;

    exports dk.dtu.compute.course02324.mini_java;
    exports dk.dtu.compute.course02324.mini_java.model;
    exports dk.dtu.compute.course02324.mini_java.infrastructure;
    exports dk.dtu.compute.course02324.mini_java.semantics;
    exports dk.dtu.compute.course02324.mini_java.utils;

}