package tech.intellispaces.core;

import java.util.List;

import org.jetbrains.annotations.Nullable;

/**
 * The reflection considered as a point of semantic domain.
 */
public interface ReflectionPoint extends Reflection {

  /**
   * The point domain.
   */
  ReflectionDomain domain();

  /**
   * The domain name.
   */
  @Nullable String domainName();

  List<ReflectionPoint> underlyingPoints();
}
