Submission 3

# Assignment 6a

We added functionality for the - ‘Minus 2’, + ‘Mul’ allowing us to minus with floats and ints and to multiply with ints and floats.

We added unary operands ‘Minus 1’ and ‘Plus 1’ for both ints and floats to be able to calculate with negative numbers.

We added binary operands for % ‘Div’ and % ‘Mod’. allowing us to divide with ints and floats and to take Modulo with ints.

We created a PrintStatement Class in order to easily make print statements which evaluate our MiniJava expressions. The class had two variables, a String which is the text to print, and an expression which is the given calculation it has to print (in evaluated form).

Since we are using the Visitor pattern, we made an accept function in the class in order to implement double dispatch, so our visitors can use the appropriate method for type checking, serializing or executing for the Printstatement type.

Lastly we implemented the Visit(Printstatement printstatement) in the ProgramTypeVisitor in order to accept it, we implemented it in the ProgramExecuteVisitor in order to accept and print the calculation and also in the ProgramSerializeVisitor to show it when running it in MiniJavaRun. 

# 

# Assignment 6b

**Implementation to Class ProgramType visitor**

We start by calling accept to update the current type in typeMapping. We can now get the type from the hashmap ‘TypeMapping’ by using *.get*. We will either receive a float or an int.

We then make a simple if statement, that adds a problem if the type is not equal to INT.

If a problem is added, then MiniJavaRun ensures that this particular expression is skipped

**Implementation to Class ProgramExecutorVisitor**

The programExecutor visitor assumes the program is now correctly type checked, and this visitor has access to the types with an instance of the typechecker. 

In the method *visit(WhileLoop whileloop)* we implemented the whileloop functionality by first ensuring the ‘values’ HashMap have the current value of the WhileLoop class’s ‘expression’ using *whileLoop.expression.accept(this)*. After that we can now retrieve the current expression value from the HashMap ‘values’ with *values.get(whileloop.expression).* 

The functionality is implemented with a proper while loop (instead of using recursion to *visit(whileloop)*), the while loop runs while the expression value is not negative. Inside the loop we evaluate the statement by calling *whileloop.statement.accept(this)*, and we then make sure we once again have the current value of the expression like before with whileloop.*expression.accept(this)* and *values.get(whileloop.expression)*, so next comparison in the while loop uses the current value.

# Extras (Conditionals) 

Much like 6b, the if-else-statement evaluates an expression which must be greater or equals to zero. Depending on the outcome of that expression, either an “if” statement or an “else” statement is run. To implement the conditional, we need to add it to the abstract syntax of Mini Java. First we implemented a new class, called IfThenElse, that consists of the aforementioned expression and two statements, along with the accept() method that needs to be there since we are implementing the statement interface. The new class is added like others to Programvisitor and shortcuts. The type checking for IfThenElse is almost the same as the WhileLoop, just having two accept() calls for the two statements. The serializer adds indents to mimic a normal if statement from java, which looks like this: 

if (i >= 0 ) {

 sum = sum + 5;

} else {

 sum = sum + 10;

};

The execution of the conditional is implemented by using a normal java if else statement, checking that the expression is greater or equal to 0, and based on this executing either the first or second statement given. 

IfThenElse is tested in three different tests, firstly checking that the if part is executed correctly, then the else part and finally that the type check only accepts INTs as expected.