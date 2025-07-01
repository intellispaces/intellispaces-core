package tech.intellispaces.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TraversePathBuilder {
  private Domain sourceDomain;
  private final List<TraverseTransition> transitions = new ArrayList<>();

  public TraversePathBuilder sourceDomain(Domain sourceDomain) {
    this.sourceDomain = sourceDomain;
    return this;
  }

  public TraversePathBuilder addTransitionThru(Rid cid) {
    transitions.add(new TraverseTransitionThruImpl(Channels.build().cid(cid).get()));
    return this;
  }

  public TraversePath get() {
    return new TraversePathImpl(sourceDomain, Collections.unmodifiableList(transitions));
  }
}
