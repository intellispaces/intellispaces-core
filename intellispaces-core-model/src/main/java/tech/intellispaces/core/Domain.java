package tech.intellispaces.core;

import tech.intellispaces.commons.type.Type;

/**
 * The space domain.
 */
public interface Domain {

  /**
   * The domain identifier.
   */
  byte[] id();

  /**
   * The full qualified name.
   */
  String name();

  Class<?> domainClass();

  Type<?> domainType();
}
