package oops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.Collector;

class Part {
  private String name;
  private String value;
  private boolean spare;

  public Part(String name, String value, boolean spare) {
    this.name = name;
    this.value = value;
    this.spare = spare;
  }

  public String getName() { return this.name; }
  public String getValue() { return this.value; }
  public boolean needSpare() { return this.spare; }
}

class Parts {
  private ArrayList<Part> parts;

  public Parts(ArrayList<Part> parts) {
    this.parts = parts;
  }

  public ArrayList<Part> getPartList() { return this.parts; }
  public void addPart(Part part) { this.parts.add(part); }
}

class Bicycle {
  private String size;
  private Parts parts;

  public Bicycle(String size, Parts parts) {
    this.size = size;
    this.parts = parts;
  }

  public String getSize() { return this.size; }
  public Parts getParts() { return this.parts; }
  public Parts getSpares() {
    Parts p = new Parts(new ArrayList<>());
    for(Part part : this.parts.getPartList()) {
      if(part.needSpare()) p.addPart(part);
    }
    return p;
  }
}

class PartsFactory {
  public static Parts build(Part... config) {
    return new Parts(new ArrayList(Arrays.asList(config)));
  }
}

public class FastFeet {
  public static void main(String[] args) {
    Bicycle roadBike = new Bicycle(
      "L",
      PartsFactory.build(
        new Part("chain", "10-speed", true),
        new Part("tire_size", "23", false),
        new Part("tape_color", "red", true)
      )
    );
    
    Bicycle mountainBike = new Bicycle(
      "M",
      PartsFactory.build(
        new Part("chain", "10-speed", true),
        new Part("tire_size", "2.1", true),
        new Part("front_shock", "Mountau", false),
        new Part("rear_shock", "Fox", true)
      )
    );

    Parts roadSpares = roadBike.getSpares();
    Parts mountainSpares = mountainBike.getSpares();

    for(Part part : roadSpares.getPartList()) {
      System.out.println(part.getName());
      System.out.println(part.getValue());
    }
    
    for(Part part : mountainSpares.getPartList()) {
      System.out.println(part.getName());
      System.out.println(part.getValue());
    }
  }
}