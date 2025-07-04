package tech.intellispaces.core;

import java.util.List;

public interface Reflections {

  static ReflectionReference create(Rid rid) {
    return new ReflectionReferenceImpl(rid, null);
  }

  static ReflectionReference create(String reflectionName) {
    return new ReflectionReferenceImpl(null, reflectionName);
  }

  static ReflectionReference create(Rid rid, String reflectionName) {
    return new ReflectionReferenceImpl(rid, reflectionName);
  }

  static ReflectionPoint create(Rid rid, ReflectionDomain domain) {
    return new ReflectionPointImpl(rid, null, domain, List.of());
  }

  static ReflectionBuilder build() {
    return new ReflectionBuilder();
  }

  static PrototypePointBuilder build(ReflectionPoint prototype) {
    return new PrototypePointBuilder(prototype);
  }
}
