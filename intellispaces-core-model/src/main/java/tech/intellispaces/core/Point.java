package tech.intellispaces.core;

/**
 * The semantic space point.
 */
public interface Point extends Reflection {

  /**
   * The point identifier.
   */
  default Rid pid() {
    return rid();
  }
}
