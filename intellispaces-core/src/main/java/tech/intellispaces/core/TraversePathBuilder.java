package tech.intellispaces.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TraversePathBuilder {
  private ReflectionDomain sourceDomain;
  private final List<TraverseTransition> transitions = new ArrayList<>();

  public TraversePathBuilder sourceDomain(ReflectionDomain sourceDomain) {
    this.sourceDomain = sourceDomain;
    return this;
  }

  public TraversePathBuilder addTransitionThru(Rid cid) {
    transitions.add(new TraverseTransitionThruImpl(Channels.blank().cid(cid).release()));
    return this;
  }

  public TraversePath get() {
    return new TraversePathImpl(sourceDomain, Collections.unmodifiableList(transitions));
  }
}
