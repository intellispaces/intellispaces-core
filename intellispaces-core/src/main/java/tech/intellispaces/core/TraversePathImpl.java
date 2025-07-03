package tech.intellispaces.core;

import java.util.List;

class TraversePathImpl implements TraversePath {
  private final ReflectionDomain sourceDomain;
  private final List<TraverseTransition> transitions;

  TraversePathImpl(ReflectionDomain sourceDomain, List<TraverseTransition> transitions) {
    this.sourceDomain = sourceDomain;
    this.transitions = transitions;
  }

  @Override
  public ReflectionDomain sourceDomain() {
    return sourceDomain;
  }

  @Override
  public List<TraverseTransition> transitions() {
    return transitions;
  }
}
