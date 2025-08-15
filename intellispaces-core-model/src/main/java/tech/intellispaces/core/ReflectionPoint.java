package tech.intellispaces.core;

import java.util.List;

import org.jetbrains.annotations.Nullable;

/**
 * The reflection considered as a point of semantic domain.
 */
public interface ReflectionPoint extends Reflection {

  /**
   * The parent domain.
   */
  ReflectionDomain domain();

  /**
   * The parent domain alias.
   */
  @Nullable String domainAlias();

  List<ReflectionPoint> primaryPoints();
}
