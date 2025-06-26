package tech.intellispaces.core;

public interface Reflections {

  static Reflection create(Domain domain, Rid rid) {
    return new ReflectionImpl(ReflectionTypes.Undefined, rid, null, domain);
  }

  static PrototypeReflectionBuilder build(Reflection prototype) {
    return new PrototypeReflectionBuilder(prototype);
  }
}
