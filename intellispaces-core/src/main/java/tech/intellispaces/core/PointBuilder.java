package tech.intellispaces.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointBuilder {
  private Rid pid;
  private String name;
  private ReflectionDomain domain;
  private final Map<Rid, Projection> cidToProjection = new HashMap<>();
  private final Map<String, Projection> channelNameToProjection = new HashMap<>();
  private final Map<String, Projection> targetDomainNameToProjection = new HashMap<>();
  private final List<ReflectionPoint> underlyingPoints = new ArrayList<>();

  public PointBuilder pid(Rid pid) {
    this.pid = pid;
    return this;
  }

  public PointBuilder name(String name) {
    this.name = name;
    return this;
  }

  public PointBuilder domain(ReflectionDomain domain) {
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

  public PointBuilder setProjectionTo(String domainName, ReflectionPoint projectionTarget) {
    targetDomainNameToProjection.put(domainName, Projections.focused(projectionTarget));
    return this;
  }

  public PointBuilder addUnderlyingPoint(ReflectionPoint addUnderlyingPoint) {
    underlyingPoints.add(addUnderlyingPoint);
    return this;
  }

  public ReflectionPoint get() {
    var point = new ReflectionPointImpl(
        pid,
        name,
        domain,
        Collections.unmodifiableList(underlyingPoints)
    );
    cidToProjection.forEach(point::setProjectionThru);
    channelNameToProjection.forEach(point::setProjectionThru);
    targetDomainNameToProjection.forEach(point::setProjectionTo);
    return point;
  }
}
