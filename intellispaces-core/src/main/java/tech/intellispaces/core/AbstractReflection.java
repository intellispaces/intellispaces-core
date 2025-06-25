package tech.intellispaces.core;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractReflection implements Reflection {
  private final Map<Rid, Projection> projections = new HashMap<>();

  @Override
  public Projection projectThru(Rid cid) {
    return projections.get(cid);
  }

  protected void setProjection(Rid cid, Projection projection) {
    projections.put(cid, projection);
  }

  protected void setProjections(Map<Rid, Projection> projections) {
    this.projections.putAll(projections);
  }
}
