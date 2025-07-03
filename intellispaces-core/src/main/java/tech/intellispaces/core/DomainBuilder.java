package tech.intellispaces.core;

import java.util.HashMap;
import java.util.Map;

public class DomainBuilder {
  private Rid did;
  private String name;
  private ReflectionDomain borrowedDomain;
  private final Map<Rid, Projection> cidToProjection = new HashMap<>();
  private final Map<String, Projection> channelNameToProjection = new HashMap<>();

  public DomainBuilder did(Rid did) {
    this.did = did;
    return this;
  }

  public DomainBuilder name(String name) {
    this.name = name;
    return this;
  }

  public DomainBuilder borrowedDomain(ReflectionDomain borrowedDomain) {
    this.borrowedDomain = borrowedDomain;
    return this;
  }

  public DomainBuilder setProjectionThru(Rid cid, Projection projection) {
    cidToProjection.put(cid, projection);
    return this;
  }

  public DomainBuilder setProjectionThru(String channelName, Projection projection) {
    channelNameToProjection.put(channelName, projection);
    return this;
  }

  public ReflectionDomain get() {
    var domain = new ReflectionDomainImpl(
        did,
        name,
        null,
        null,
        borrowedDomain
    );
    cidToProjection.forEach(domain::setProjectionThru);
    channelNameToProjection.forEach(domain::setProjectionThru);
    return domain;
  }
}
