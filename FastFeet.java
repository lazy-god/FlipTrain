package oops;

abstract class Bicycle {
  private String size;
  private String tireSize;
  private String chain = "10-speed";

  public Bicycle(String size, String tireSize) {
    this.size = size;
    this.tireSize = tireSize;
  }

  public Bicycle(String size, String chain, String tireSize) {
    this.size = size;
    this.chain = chain;
    this.tireSize = tireSize;
  }

  // Accessor Methods
  public String getSize() { return size; }
  public String getChain() { return chain; }
  public String getTireSize() { return tireSize; }
}

class MountainBike extends Bicycle {
  private String frontShock;
  private String rearShock;

  public MountainBike(String size, String frontShock, String rearShock) {
    super(size, "2.1"); // default tire size -> 2.1
    this.frontShock = frontShock;
    this.rearShock = rearShock;
  }
  
  public MountainBike(String size, String tireSize, String frontShock, String rearShock) {
    super(size, tireSize); 
    this.frontShock = frontShock;
    this.rearShock = rearShock;
  }

  // Accessor Methods
  public String getFrontShock() { return frontShock; }
  public String getRearShock() { return rearShock; }
}

class RoadBike extends Bicycle {
  private String tapeColor;

  public RoadBike(String size, String tapeColor) {
    super(size, "23"); // default tire size -> 23
    this.tapeColor = tapeColor;
  }
  
  public RoadBike(String size, String tireSize, String tapeColor) {
    super(size, tireSize);
    this.tapeColor = tapeColor;
  }

  // Accessor Methods
  public String getTapeColor() { return tapeColor; }
}

public class FastFeet {
  public static void main(String[] args) {
    MountainBike mb = new MountainBike("M", "Manitou", "Fox");
    RoadBike rb = new RoadBike("L", "Red");

    System.out.println(mb.getFrontShock());
    System.out.println(mb.getRearShock());
    System.out.println(mb.getTireSize());
    System.out.println(mb.getChain());
    System.out.println(mb.getSize());
    
    System.out.println(rb.getTapeColor());
    System.out.println(rb.getTireSize());
    System.out.println(rb.getChain());
    System.out.println(rb.getSize());
  }
}