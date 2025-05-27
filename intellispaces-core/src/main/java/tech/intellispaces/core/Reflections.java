package tech.intellispaces.core;

public interface Reflections {

  static Reflection registered(Reflection reflection, Rid rid) {
    return new RegisteredReflection(reflection, rid);
  }
}
