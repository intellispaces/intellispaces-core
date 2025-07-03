package tech.intellispaces.core;

public class SpaceBuilder {
  private String name;

  public SpaceBuilder name(String name) {
    this.name = name;
    return this;
  }

  public ReflectionSpace get() {
    return new ReflectionSpaceImpl(null, name);
  }
}
