package tech.intellispaces.core;

import java.util.List;

class TraversePathImpl implements TraversePath {
  private final Domain sourceDomain;
  private final List<TraverseTransition> transitions;

  TraversePathImpl(Domain sourceDomain, List<TraverseTransition> transitions) {
    this.sourceDomain = sourceDomain;
    this.transitions = transitions;
  }

  @Override
  public Domain sourceDomain() {
    return sourceDomain;
  }

  @Override
  public List<TraverseTransition> transitions() {
    return transitions;
  }
}
