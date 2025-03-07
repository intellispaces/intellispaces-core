package tech.intellispaces.core.traverse;

import tech.intellispaces.core.Domain;

import java.util.List;

/**
 * The traverse path.
 */
public interface TraversePath {

  Domain sourceDomain();

  List<TraverseTransition> transitions();
}
