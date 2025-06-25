package tech.intellispaces.core;

import java.util.List;

/**
 * The traverse path.
 */
public interface TraversePath {

  Domain sourceDomain();

  List<TraverseTransition> transitions();
}
