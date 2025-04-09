package tech.intellispaces.core;

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
}
