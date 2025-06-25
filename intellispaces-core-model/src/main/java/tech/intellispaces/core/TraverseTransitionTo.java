package tech.intellispaces.core;

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
