package tech.intellispaces.core.traverse;

import tech.intellispaces.core.Domain;

/**
 * The traverse transition "TO domain".
 */
public interface TraverseTransitionTo extends TraverseTransition {

  /**
   * The destination domain.
   */
  Domain domain();

  boolean isSuperDomain();
}
