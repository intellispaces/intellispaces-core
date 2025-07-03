package tech.intellispaces.core;

import java.util.List;

public interface Reflections {

  static Reflection create(Rid rid) {
    return new ReflectionImpl(rid, null);
  }

  static Reflection create(String reflectionName) {
    return new ReflectionImpl(null, reflectionName);
  }

  static ReflectionPoint create(Rid rid, ReflectionDomain domain) {
    return new ReflectionPointImpl(rid, null, domain, List.of());
  }

  static PointBuilder build() {
    return new PointBuilder();
  }

  static PrototypePointBuilder build(ReflectionPoint prototype) {
    return new PrototypePointBuilder(prototype);
  }
}
