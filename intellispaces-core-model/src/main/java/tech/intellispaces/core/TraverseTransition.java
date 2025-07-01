package tech.intellispaces.core;

import org.jetbrains.annotations.Nullable;

/**
 * The traverse transition.
 */
public interface TraverseTransition {

  boolean isToTransition();

  boolean isThruTransition();

  @Nullable TraverseTransitionThru asTraverseTransitionThru();

  @Nullable TraverseTransitionTo asTraverseTransitionTo();
}
