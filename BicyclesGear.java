package oops;

import java.lang.Math;

interface Diameter {
  double calcDiameter();
}

// class Wheel
class Wheel implements Diameter {
  private double rimDiameter;
  private double tireWidth;

  public Wheel(double rimDiameter, double tireWidth) {
    this.rimDiameter = rimDiameter;
    this.tireWidth = tireWidth;
  }

  public double calcDiameter() {
    return rimDiameter + (tireWidth * 2);
  }

  public double calcWheelCircumference() {
    return Math.PI * calcDiameter();
  }
}

// Gear Class
class Gear {
  private int chainRings;
  private int cog;
  private Diameter circle;

  public Gear(int chainRings, int cog, Diameter circle) {
    this.chainRings = chainRings;
    this.cog = cog;
    this.circle = circle;
  }

  public double calcRatio() {
    // check for division by zero
    if(cog != 0) return  Double.valueOf(chainRings) / cog;
    return 0.0;
  }

  public double gearInches() {
    return calcRatio() * circle.calcDiameter();
  }

  // Accessor Methods
  public int getChainRings() { return chainRings; }
  public int getCog() { return cog; }
}

public class BicyclesGear {
  public static void main(String[] args) {
    Wheel w1 = new Wheel(10.4, 2.2);
    System.out.println(w1.calcDiameter());

    Gear g1 = new Gear(52, 11, w1);
    System.out.println(g1.gearInches());

  }
}