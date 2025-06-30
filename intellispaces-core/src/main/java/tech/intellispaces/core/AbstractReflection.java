package tech.intellispaces.core;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractReflection implements Reflection {
  private final Map<Rid, Projection> cidToProjection = new HashMap<>();
  private final Map<String, Projection> channelNameToProjection = new HashMap<>();
  private final Map<String, Projection> targetDomainNameToProjection = new HashMap<>();

  @Override
  public Projection projectionThru(Rid cid) {
    return cidToProjection.get(cid);
  }

  @Override
  public Projection projectionThru(String channelName) {
    return channelNameToProjection.get(channelName);
  }

  @Override
  public Projection projectionTo(String domainName) {
    return targetDomainNameToProjection.get(domainName);
  }

  protected void setProjectionThru(Rid cid, Projection projection) {
    cidToProjection.put(cid, projection);
  }

  protected void setProjectionThru(String channelName, Projection projection) {
    channelNameToProjection.put(channelName, projection);
  }

  protected void setProjectionTo(String domainName, Projection projection) {
    targetDomainNameToProjection.put(domainName, projection);
  }
}
