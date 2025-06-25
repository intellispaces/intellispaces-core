package tech.intellispaces.core;

public class SpaceBuilder {
  private String name;

  public SpaceBuilder name(String name) {
    this.name = name;
    return this;
  }

  public Space get() {
    return new SpaceImpl(
        null,
        name,
        null
    );
  }
}
