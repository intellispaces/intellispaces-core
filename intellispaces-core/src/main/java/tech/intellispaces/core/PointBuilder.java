package tech.intellispaces.core;

import java.util.HashMap;
import java.util.Map;

public class PointBuilder {
  private Rid pid;
  private Domain domain;
  private final Map<Rid, Projection> projections = new HashMap<>();

  public PointBuilder pid(Rid pid) {
    this.pid = pid;
    return this;
  }

  public PointBuilder domain(Domain domain) {
    this.domain = domain;
    return this;
  }

  public PointBuilder setProjection(Rid cid, Projection projection) {
    projections.put(cid, projection);
    return this;
  }

  public Point get() {
    var point = new PointImpl(
        pid,
        domain
    );
    point.setProjections(projections);
    return point;
  }
}
