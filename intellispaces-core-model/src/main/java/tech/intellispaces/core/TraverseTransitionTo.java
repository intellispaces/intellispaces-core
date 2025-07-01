package tech.intellispaces.core;

/**
 * The traverse transition "TO domain".
 */
public interface TraverseTransitionTo extends TraverseTransition {

  /**
   * The target domain.
   */
  Domain targetDomain();

  boolean isSuperDomain();
}
