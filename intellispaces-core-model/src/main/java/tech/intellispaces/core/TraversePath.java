package tech.intellispaces.core;

import java.util.List;

/**
 * The traverse path.
 */
public interface TraversePath {

  ReflectionDomain sourceDomain();

  List<TraverseTransition> transitions();
}
