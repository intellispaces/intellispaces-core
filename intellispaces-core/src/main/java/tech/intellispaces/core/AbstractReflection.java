package tech.intellispaces.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractReflection implements Reflection {
  private final Map<Rid, Projection> cidToProjection = new HashMap<>();
  private final Map<String, Projection> projectionByChannelAliasIndex = new HashMap<>();
  private final Map<String, Projection> projectionByTargetDomainAliasIndex = new HashMap<>();

  @Override
  public Projection projectionThru(Rid cid) {
    return cidToProjection.getOrDefault(cid, Projections.unknown());
  }

  @Override
  public Projection projectionThru(String channelAlias) {
    return projectionByChannelAliasIndex.getOrDefault(channelAlias, Projections.unknown());
  }

  @Override
  public Projection projectionTo(String domainAlias) {
    return projectionByTargetDomainAliasIndex.getOrDefault(domainAlias, Projections.unknown());
  }

  @Override
  public Projection projectionTo(ReflectionDomain domain) {
    if (domain.alias() != null) {
      return projectionTo(domain.alias());
    }
    return Projections.unknown();
  }

  @Override
  public List<Reflection> relatedReflections() {
    return List.of();
  }

  protected void setProjectionThru(Rid cid, Projection projection) {
    cidToProjection.put(cid, projection);
  }

  protected void setProjectionThru(String channelName, Projection projection) {
    projectionByChannelAliasIndex.put(channelName, projection);
  }

  protected void setProjectionTo(String domainName, Projection projection) {
    projectionByTargetDomainAliasIndex.put(domainName, projection);
  }
}
