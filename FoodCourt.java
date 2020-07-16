package learnjava;

import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;

class Human {
  private static int lastId;
  private String name;
  private String choice;
  private boolean hasCutlery;
  private boolean onFast;
  private int id;

  public Human(String name, String choice, boolean fast) {
    this.name = name;
    this.choice = choice;
    this.onFast = fast;
    ++lastId;
    id = lastId;
    hasCutlery = false;
  }

  public void setCutlery(boolean value) { this.hasCutlery = value; } 

  public String getName() { return this.name; }
  public String getChoice() { return this.choice; }
  public int getId() { return this.id; }
  public boolean onFast() { return this.onFast; }
  public boolean hasCutlery() { return this.hasCutlery; }

  public String toString() {
    return "[id: " + this.id + ", name: " + this.name + ", choice: " + this.choice + ", fast: " + this.onFast + ", hasCutlery: " + this.hasCutlery + "]";
  }
}

public class FoodCourt {
  public static Stream<Human> getCutlery(Stream<Human> stream) {
    return stream.map(h -> {
      h.setCutlery(true);
      return h;
    });
  }

  public static Stream<Human> filterByFast(Stream<Human> stream) {
    return stream.filter(h -> h.onFast() == false);
  }

  public static Map<String, List<Human>> groupByChoice(Stream<Human> stream) {
    return stream.collect(Collectors.groupingBy(Human::getChoice));
  }

  public static void main(String[] args) {
    Human[] humans = {
      new Human("A", "Veg", true),
      new Human("B", "Non Veg", false),
      new Human("C", "Veg", false),
      new Human("D", "Non Veg", false),
      new Human("E", "Non Veg", true),
      new Human("F", "Veg", false),
      new Human("G", "Veg", false),
      new Human("H", "Non Veg", true),
      new Human("I", "Veg", true),
      new Human("J", "Non Veg", false),
    };

    Stream<Human> humanStream = Stream.of(humans);

    // First: Filtering on basis of fast
    humanStream = filterByFast(humanStream);
    
    // Second: To the cutlery counter
    humanStream = getCutlery(humanStream);

    // Third: Grouping on basis of Veg/Non-Veg
    Map<String, List<Human>> humanByChoice = groupByChoice(humanStream);
    System.out.println(humanByChoice);

  }
}