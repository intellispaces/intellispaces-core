package tech.intellispaces.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainBuilder {
  private Rid did;
  private String name;
  private ReflectionDomain ownDomain;
  private ReflectionDomain borrowedDomain;
  private final Map<Rid, Projection> cidToProjection = new HashMap<>();
  private final Map<String, Projection> channelNameToProjection = new HashMap<>();
  private final List<ReflectionDomain> parentDomains = new ArrayList<>();

  public DomainBuilder did(Rid did) {
    this.did = did;
    return this;
  }

  public DomainBuilder name(String name) {
    this.name = name;
    return this;
  }

  public DomainBuilder ownDomain(ReflectionDomain domain) {
    this.ownDomain = domain;
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

  public DomainBuilder addParentDomains(List<ReflectionDomain> parentDomains) {
    this.parentDomains.addAll(parentDomains);
    return this;
  }

  public ReflectionDomain get() {
    var domain = new ReflectionDomainImpl(
        did,
        name,
        ownDomain,
        null,
        null,
        borrowedDomain,
        Collections.unmodifiableList(parentDomains)
    );
    cidToProjection.forEach(domain::setProjectionThru);
    channelNameToProjection.forEach(domain::setProjectionThru);
    return domain;
  }
}
