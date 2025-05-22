package tech.intellispaces.core;

import tech.intellispaces.commons.type.Type;

/**
 * The space domain.
 */
public interface Domain extends Reflection {

  /**
   * The domain identifier.
   */
  Rid rid();

  /**
   * The full qualified name.
   */
  String name();

  /**
   * The domain class.
   */
  Class<?> domainClass();

  /**
   * The domain type.
   */
  Type<?> domainType();
}
