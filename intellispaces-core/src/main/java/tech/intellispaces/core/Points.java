package tech.intellispaces.core;

public interface Points {

  static PointBuilder build() {
    return new PointBuilder();
  }

  static PrototypePointBuilder build(Point prototype) {
    return new PrototypePointBuilder(prototype);
  }
}
