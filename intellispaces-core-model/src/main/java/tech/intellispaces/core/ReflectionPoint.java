package tech.intellispaces.core;

import java.util.List;

/**
 * The reflection considered as a point of semantic domain.
 */
public interface ReflectionPoint extends Reflection {

  /**
   * The point domain.
   */
  ReflectionDomain domain();

  List<ReflectionPoint> underlyingPoints();
}
