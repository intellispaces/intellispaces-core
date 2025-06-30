package tech.intellispaces.core;

import java.util.HashMap;
import java.util.Map;

public class PointBuilder {
  private Rid pid;
  private String name;
  private Domain domain;
  private final Map<Rid, Projection> cidToProjection = new HashMap<>();
  private final Map<String, Projection> channelNameToProjection = new HashMap<>();
  private final Map<String, Projection> targetDomainNameToProjection = new HashMap<>();

  public PointBuilder pid(Rid pid) {
    this.pid = pid;
    return this;
  }

  public PointBuilder name(String name) {
    this.name = name;
    return this;
  }

  public PointBuilder domain(Domain domain) {
    this.domain = domain;
    return this;
  }

  public PointBuilder setProjectionThru(Rid cid, Projection projection) {
    cidToProjection.put(cid, projection);
    return this;
  }

  public PointBuilder setProjectionThru(String channelName, Projection projection) {
    channelNameToProjection.put(channelName, projection);
    return this;
  }

  public PointBuilder setProjectionTo(String domainName, Projection projection) {
    targetDomainNameToProjection.put(domainName, projection);
    return this;
  }

  public Point get() {
    var point = new PointImpl(
        pid,
        name,
        domain
    );
    cidToProjection.forEach(point::setProjectionThru);
    channelNameToProjection.forEach(point::setProjectionThru);
    targetDomainNameToProjection.forEach(point::setProjectionTo);
    return point;
  }
}
