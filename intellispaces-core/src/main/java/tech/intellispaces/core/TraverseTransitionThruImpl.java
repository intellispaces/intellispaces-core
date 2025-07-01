package tech.intellispaces.core;

import org.jetbrains.annotations.Nullable;

class TraverseTransitionThruImpl implements TraverseTransitionThru {
  private final Channel channel;

  TraverseTransitionThruImpl(Channel channel) {
    this.channel = channel;
  }

  @Override
  public Channel channel() {
    return channel;
  }

  @Override
  public boolean isToTransition() {
    return false;
  }

  @Override
  public boolean isThruTransition() {
    return true;
  }

  @Override
  public @Nullable TraverseTransitionThru asTraverseTransitionThru() {
    return this;
  }

  @Override
  public @Nullable TraverseTransitionTo asTraverseTransitionTo() {
    return null;
  }
}
