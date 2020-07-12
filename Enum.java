package oops;

class DemoEnum {
  static final DemoEnum ADD;
  static final DemoEnum SUBTRACT;
  static final DemoEnum MULTIPLY;
  static final DemoEnum DIVIDE;

  static {
    ADD = new DemoEnum("+");
    SUBTRACT = new DemoEnum("-");
    MULTIPLY = new DemoEnum("*");
    DIVIDE = new DemoEnum("/");
  }

  private String abbrevation;

  private DemoEnum(String abbrevation) {
    this.abbrevation = abbrevation;
  }

  public String getAbbrevation() { return abbrevation; }
}

public class Enum {
  public static void main(String[] args) {
    System.out.println(DemoEnum.ADD.getAbbrevation());
  }
}