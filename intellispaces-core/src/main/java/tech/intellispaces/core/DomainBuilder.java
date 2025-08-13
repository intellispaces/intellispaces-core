package tech.intellispaces.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainBuilder {
  private Rid did;
  private String alias;
  private ReflectionDomain baseDomain;
  private final List<ReflectionDomain> parentDomains = new ArrayList<>();
  private List<ReflectionDomain> foreignDomains = List.of();
  private final List<ReflectionChannel> contextChannels = new ArrayList<>();
  private final Map<Rid, Projection> projectionByChannelIdIndex = new HashMap<>();
  private final Map<String, Projection> projectionByChannelAliasIndex = new HashMap<>();

  public DomainBuilder did(Rid did) {
    this.did = did;
    return this;
  }

  public DomainBuilder alias(String alias) {
    this.alias = alias;
    return this;
  }

  public DomainBuilder baseDomain(ReflectionDomain domain) {
    this.baseDomain = domain;
    return this;
  }

  public DomainBuilder parentDomain(ReflectionDomain domain) {
    this.parentDomains.add(domain);
    return this;
  }

  public DomainBuilder parentDomains(List<ReflectionDomain> domains) {
    this.parentDomains.addAll(domains);
    return this;
  }

  public DomainBuilder foreignDomains(List<ReflectionDomain> domains) {
    this.foreignDomains = domains;
    return this;
  }

  public DomainBuilder contextChannel(ReflectionChannel channel) {
    this.contextChannels.add(channel);
    return this;
  }

  public DomainBuilder projectionThru(Rid cid, Projection projection) {
    projectionByChannelIdIndex.put(cid, projection);
    return this;
  }

  public DomainBuilder projectionThru(String channelAlias, Projection projection) {
    projectionByChannelAliasIndex.put(channelAlias, projection);
    return this;
  }

  public ReflectionDomain get() {
    var domain = new ReflectionDomainImpl(
        did,
        alias,
        baseDomain,
        null,
        null,
        Collections.unmodifiableList(parentDomains),
        Collections.unmodifiableList(foreignDomains),
        Collections.unmodifiableList(contextChannels)
    );
    projectionByChannelIdIndex.forEach(domain::setProjectionThru);
    projectionByChannelAliasIndex.forEach(domain::setProjectionThru);
    return domain;
  }
}
