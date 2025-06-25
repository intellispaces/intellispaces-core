package tech.intellispaces.core;

/**
 * The object reflection.
 */
public interface Reflection {

  /**
   * Returns the identifier of the reflection in the current system.
   * <p>
   * If the reflection is not registered in the current system, then undefined identifier is returned.
   */
  Rid rid();

  /**
   * Returns reflection domain.
   */
  Domain domain();

  /**
   * Returns projection of this reflection through identified channel.
   *
   * @param cid the channel identifier.
   * @return the projection.
   */
  Projection projectThru(Rid cid);
}
