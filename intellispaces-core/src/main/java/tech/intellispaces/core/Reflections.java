package tech.intellispaces.core;

public interface Reflections {

  static Reflection create(Rid rid, Domain domain) {
    return new ReflectionImpl(rid, domain);
  }

  static Reflection registered(Reflection reflection, Rid rid) {
    return new RegisteredReflection(reflection, rid);
  }
}
