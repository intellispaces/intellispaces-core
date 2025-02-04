package tech.intellispaces.core.base.traverse;

import tech.intellispaces.core.base.Domain;

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
