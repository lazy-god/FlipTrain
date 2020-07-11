package oops;

// Gear Class
class Gear {
  private int chainRings;
  private int cog;

  public Gear(int chainRings, int cog) {
    this.chainRings = chainRings;
    this.cog = cog;
  }

  public double calcRatio() {
    // check for division by zero
    if(cog != 0) return  Double.valueOf(chainRings) / cog;
    return 0.0;
  }

  // Accessor Methods
  public int getChainRings() { return chainRings; }
  public int getCog() { return cog; }
}

public class BicyclesGear {
  public static void main(String[] args) {
    Gear g1 = new Gear(52, 11);
    Gear g2 = new Gear(30, 0);

    System.out.println(g1.calcRatio());
    System.out.println(g2.calcRatio());
  }
}