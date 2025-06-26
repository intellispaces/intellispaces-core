package tech.intellispaces.core;

import java.util.HashMap;
import java.util.Map;

public class DomainBuilder {
  private Rid did;
  private String name;
  private String foreignDomainName;
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

  public DomainBuilder foreignDomainName(String foreignDomainName) {
    this.foreignDomainName = foreignDomainName;
    return this;
  }

  public DomainBuilder setProjection(Rid cid, Projection projection) {
    cidToProjection.put(cid, projection);
    return this;
  }

  public DomainBuilder setProjection(String channelName, Projection projection) {
    channelNameToProjection.put(channelName, projection);
    return this;
  }

  public Domain get() {
    var domain = new DomainImpl(
        did,
        name,
        null,
        null,
        null,
        foreignDomainName
    );
    cidToProjection.forEach(domain::setProjection);
    channelNameToProjection.forEach(domain::setProjection);
    return domain;
  }
}
