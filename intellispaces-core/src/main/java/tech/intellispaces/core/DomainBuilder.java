package tech.intellispaces.core;

import java.util.HashMap;
import java.util.Map;

public class DomainBuilder {
  private Rid did;
  private String name;
  private final Map<Rid, Projection> projections = new HashMap<>();

  public DomainBuilder did(Rid did) {
    this.did = did;
    return this;
  }

  public DomainBuilder name(String name) {
    this.name = name;
    return this;
  }

  public DomainBuilder setProjection(Rid cid, Projection projection) {
    projections.put(cid, projection);
    return this;
  }

  public Domain get() {
    var domain = new DomainImpl(
        did,
        name,
        null,
        null,
        null,
        null
    );
    domain.setProjections(projections);
    return domain;
  }
}
