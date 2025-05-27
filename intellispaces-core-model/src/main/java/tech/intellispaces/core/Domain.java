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
   * The domain class related to this reflection.
   */
  Class<?> domainClass();

  /**
   * The domain type related to this reflection.
   */
  Type<?> domainType();
}
