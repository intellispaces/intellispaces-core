package tech.intellispaces.core;

public interface Spaces {

  static SpaceBuilder build() {
    return new SpaceBuilder();
  }
}
