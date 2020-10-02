// This is a calculator example in java

package oops;

interface Operations {
  double op(double x, double y);
}

interface Def {
  String defination();
}

enum Operation {
  ADD("+") {
    public double eval(double arg1, double arg2) { return arg1 + arg2; }
  },
  SUBTRACT("-") {
    public double eval(double arg1, double arg2) { return arg1 - arg2; }
  },
  MULTIPLY("*") {
    public double eval(double arg1, double arg2) { return arg1 * arg2; }
  },
  DIVIDE("/") {
    public double eval(double arg1, double arg2) { return arg1 / arg2; }
  };

  private String symbol;
  Operation(String symbol) { this.symbol = symbol; }
  public String getSymbol() { return symbol; }    
  public abstract double eval(double arg1, double arg2);
}

class Defination {
  public String def() { return "What the hell is happenning?"; }
  public double sum(double x, double y) { return x + y; }
  public double sum(double x, double y, double z) { return x + y + z; }
  public double sub(double x, double y) { return x - y; }
  public double mul(double x, double y) { return x * y; }
  public double div(double x, double y) { return x / y; }
}

// Interface Way (OLD)
class Summation implements Operations {
  public double op(double x, double y) { return x + y; }
}
class Subtract implements Operations {
  public double op(double x, double y) { return x - y; }
}
class Multiply implements Operations {
  public double op(double x, double y) { return x * y; }
}
class Division implements Operations {
  public double op(double x, double y) { return x / y; }
}

class Calculate {
  // Interface Way (OLD)
  private Operations operation = null;
  public void setOperation(Operations operation) { this.operation = operation; }
  public double op(double x, double y) { return operation.op(x, y); }

  // Lambda Way & Method Reference (NEW)
  public double calc(double x, double y, Operations o) { return o.op(x, y); };
  public String def(Def d) { return d.defination(); };
  public double calculate(Operation op, double x, double y) { return op.eval(x, y); }
}

public class Calculator {
  public static void playWithCalculator() {
    double x = 10.0, y = 20.0;
    Calculate cal = new Calculate();
    // Interface Way (OLD)
    cal.setOperation(new Summation());
    System.out.println(cal.op(x, y));
    cal.setOperation(new Subtract());
    System.out.println(cal.op(x, y));
    cal.setOperation(new Multiply());
    System.out.println(cal.op(x, y));
    cal.setOperation(new Division());
    System.out.println(cal.op(x, y));

    // Lambda Way & Method Reference (NEW)
    System.out.println(cal.calc(x, y, (a, b) -> a + b));
    System.out.println(cal.calc(x, y, (a, b) -> a - b));
    System.out.println(cal.calc(x, y, (a, b) -> a * b));
    System.out.println(cal.calc(x, y, (a, b) -> a / b));
    
    System.out.println(cal.calculate(Operation.ADD, x, y));
    System.out.println(cal.calculate(Operation.SUBTRACT, x, y));
    System.out.println(cal.calculate(Operation.MULTIPLY, x, y));
    System.out.println(cal.calculate(Operation.DIVIDE, x, y));

    System.out.println(cal.calc(x, y, new Defination()::sum));
    System.out.println(cal.calc(x, y, new Defination()::sub));
    System.out.println(cal.calc(x, y, new Defination()::mul));
    System.out.println(cal.calc(x, y, new Defination()::div));
  }

  public static void main(String[] args) {
    System.out.println("Calculate: ");
    playWithCalculator();
  }
}
