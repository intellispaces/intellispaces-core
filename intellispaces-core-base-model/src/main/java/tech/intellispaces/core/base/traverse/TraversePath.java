package tech.intellispaces.core.base.traverse;

import tech.intellispaces.core.base.Domain;

import java.util.List;

/**
 * The traverse path.
 */
public interface TraversePath {

  Domain sourceDomain();

  List<TraverseTransition> transitions();
}
