package tech.intellispaces.core;

import java.util.List;

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

  List<Point> underlyingPoints();
}
