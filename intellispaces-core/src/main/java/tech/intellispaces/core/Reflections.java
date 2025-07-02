package tech.intellispaces.core;

public interface Reflections {

  static Reflection create(String reflectionName) {
    return new ReflectionImpl(ReflectionTypes.Unspecified, null, reflectionName, null);
  }

  static Reflection create(Rid rid, Domain domain) {
    return new ReflectionImpl(ReflectionTypes.Unspecified, rid, null, domain);
  }

  static PrototypeReflectionBuilder build(Reflection prototype) {
    return new PrototypeReflectionBuilder(prototype);
  }
}
