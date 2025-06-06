package tech.intellispaces.core;

/**
 * The focused reflection.
 */
public interface Reflection {

  /**
   * Returns the identifier of the reflection in the current system.
   * <p>
   * If the reflection is not registered in the current system, then undefined identifier is returned.
   */
  Rid rid();

  Domain domain();
}
