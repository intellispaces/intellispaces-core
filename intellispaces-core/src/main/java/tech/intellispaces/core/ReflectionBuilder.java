package tech.intellispaces.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectionBuilder {
  private Rid pid;
  private String name;
  private ReflectionDomain domain;
  private final Map<Rid, Projection> cidToProjection = new HashMap<>();
  private final Map<String, Projection> channelNameToProjection = new HashMap<>();
  private final Map<String, Projection> targetDomainNameToProjection = new HashMap<>();
  private final List<ReflectionPoint> underlyingPoints = new ArrayList<>();

  public ReflectionBuilder pid(Rid pid) {
    this.pid = pid;
    return this;
  }

  public ReflectionBuilder name(String name) {
    this.name = name;
    return this;
  }

  public ReflectionBuilder domain(ReflectionDomain domain) {
    this.domain = domain;
    return this;
  }

  public ReflectionBuilder setProjectionThru(Rid cid, Projection projection) {
    cidToProjection.put(cid, projection);
    return this;
  }

  public ReflectionBuilder setProjectionThru(String channelName, Projection projection) {
    channelNameToProjection.put(channelName, projection);
    return this;
  }

  public ReflectionBuilder setProjectionTo(String domainName, Projection projection) {
    targetDomainNameToProjection.put(domainName, projection);
    return this;
  }

  public ReflectionBuilder setProjectionTo(String domainName, ReflectionPoint projectionTarget) {
    targetDomainNameToProjection.put(domainName, Projections.focused(projectionTarget));
    return this;
  }

  public ReflectionBuilder addUnderlyingPoint(ReflectionPoint addUnderlyingPoint) {
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
