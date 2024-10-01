package behavioural.interprator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

interface Expression {
    int interpret(Context context);
}

class Context {
    private Map<String, Integer> variables = new HashMap<>();

    public void assign(String variable, int value) {
        variables.put(variable, value);
    }

    public int getValue(String variable) {
        return variables.get(variable);
    }
}

class VariableExpression implements Expression {
    private String variableName;

    public VariableExpression(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public int interpret(Context context) {
        return context.getValue(variableName);
    }
}

class OperationExpression implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;
    private String operator;

    public OperationExpression(Expression leftExpression, Expression rightExpression, String operator) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }

    @Override
    public int interpret(Context context) {
        switch (operator) {
            case "+":
                return leftExpression.interpret(context) + rightExpression.interpret(context);
            case "-":
                return leftExpression.interpret(context) - rightExpression.interpret(context);
            case "*":
                return leftExpression.interpret(context) * rightExpression.interpret(context);
            default:
                throw new UnsupportedOperationException("Operator not supported: " + operator);
        }
    }
}

public class InterpretorDesignExample {
    public static void main(String[] args) {
        // Context for variables
        Context context = new Context();
        context.assign("x", 5);
        context.assign("y", 10);
        context.assign("z", 3);

        // Creating expressions
        Expression x = new VariableExpression("x");
        Expression y = new VariableExpression("y");
        Expression z = new VariableExpression("z");

        // Constructing the expression: (x + y) * z
        Expression addition = new OperationExpression(x, y, "+");
        Expression multiplication = new OperationExpression(addition, z, "*");

        // Evaluating the expression with the context
        int result = multiplication.interpret(context);

        // Output the result
        System.out.println("Result: " + result);  // Output: 45
    }
}
