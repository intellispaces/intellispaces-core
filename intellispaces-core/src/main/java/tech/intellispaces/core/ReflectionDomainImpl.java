package tech.intellispaces.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.type.Type;

class ReflectionDomainImpl extends AbstractReflectionDomain {
  private final Rid did;
  private final String alias;
  private final Type<?> domainType;
  private final Class<?> domainClass;
  private final List<ReflectionDomain> primaryDomains;
  private final List<ReflectionDomain> foreignDomains;
  private final List<ReflectionChannel> contextChannels;
  private final Map<Rid, Projection> projectionByChannelIdIndex = new HashMap<>();
  private final Map<String, Projection> projectionByChannelAliasIndex = new HashMap<>();

  ReflectionDomainImpl(
      Rid did,
      String alias,
      Type<?> domainType,
      Class<?> domainClass,
      List<ReflectionDomain> primaryDomains,
      List<ReflectionDomain> foreignDomains,
      List<ReflectionChannel> contextChannels
  ) {
    this.did = did;
    this.alias = alias;
    this.domainType = domainType;
    this.domainClass = domainClass;
    this.primaryDomains = primaryDomains;
    this.foreignDomains = foreignDomains;
    this.contextChannels = contextChannels;
  }

  @Override
  public @Nullable Rid rid() {
    return did;
  }

  @Override
  public @Nullable String alias() {
    return alias;
  }

  @Override
  public @Nullable Class<?> domainClass() {
    return domainClass;
  }

  @Override
  public @Nullable Type<?> domainType() {
    return domainType;
  }

  @Override
  public List<ReflectionDomain> primaryDomains() {
    return Collections.unmodifiableList(primaryDomains);
  }

  @Override
  public List<ReflectionDomain> foreignDomains() {
    return Collections.unmodifiableList(foreignDomains);
  }

  @Override
  public List<ReflectionChannel> contextChannels() {
    return Collections.unmodifiableList(contextChannels);
  }
}
