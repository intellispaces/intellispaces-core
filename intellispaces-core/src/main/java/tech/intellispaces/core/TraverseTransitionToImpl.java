package tech.intellispaces.core;

import org.jetbrains.annotations.Nullable;

class TraverseTransitionToImpl implements TraverseTransitionTo {
  private final ReflectionDomain targetDomain;

  TraverseTransitionToImpl(ReflectionDomain targetDomain) {
    this.targetDomain = targetDomain;
  }

  @Override
  public ReflectionDomain targetDomain() {
    return targetDomain;
  }

  @Override
  public boolean isSuperDomain() {
    return false;
  }

  @Override
  public boolean isToTransition() {
    return true;
  }

  @Override
  public boolean isThruTransition() {
    return false;
  }

  @Override
  public @Nullable TraverseTransitionThru asTraverseTransitionThru() {
    return null;
  }

  @Override
  public @Nullable TraverseTransitionTo asTraverseTransitionTo() {
    return this;
  }
}
