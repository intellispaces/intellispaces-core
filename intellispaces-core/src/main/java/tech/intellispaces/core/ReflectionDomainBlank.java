package tech.intellispaces.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.exception.UnexpectedExceptions;
import tech.intellispaces.commons.type.Type;

public class ReflectionDomainBlank extends AbstractReflectionDomain implements ReflectionBlank {
  private Rid did;
  private String alias;
  private Type<?> domainType;
  private Class<?> domainClass;
  private final List<ReflectionDomain> primaryDomains = new ArrayList<>();
  private List<ReflectionDomain> foreignDomains = List.of();
  private final List<ReflectionChannel> contextChannels = new ArrayList<>();
  private final Map<Rid, Projection> projectionByChannelIdIndex = new HashMap<>();
  private final Map<String, Projection> projectionByChannelAliasIndex = new HashMap<>();

  private ReflectionDomainPoint substrate = ReflectionDomainStub.INSTANCE;

  @Override
  public @Nullable Rid rid() {
    return substrate.rid();
  }

  @Override
  public @Nullable String alias() {
    return substrate.alias();
  }

  @Override
  public @Nullable Class<?> domainClass() {
    return substrate.domainClass();
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

  @Override
  public boolean isReleased() {
    return substrate != ReflectionDomainStub.INSTANCE;
  }

  public ReflectionDomainBlank did(Rid did) {
    throwExceptionIfReleased();
    this.did = did;
    return this;
  }

  public ReflectionDomainBlank alias(String alias) {
    throwExceptionIfReleased();
    this.alias = alias;
    return this;
  }

  public ReflectionDomainBlank domainType(Type<?> domainType) {
    throwExceptionIfReleased();
    this.domainType = domainType;
    return this;
  }

  public ReflectionDomainBlank domainClass(Class<?> domainClass) {
    throwExceptionIfReleased();
    this.domainClass = domainClass;
    return this;
  }

  public ReflectionDomainBlank baseDomain(ReflectionDomain domain) {
    throwExceptionIfReleased();
    this.parentDomain = domain;
    return this;
  }

  public ReflectionDomainBlank parentDomain(ReflectionDomain domain) {
    throwExceptionIfReleased();
    this.primaryDomains.add(domain);
    return this;
  }

  public ReflectionDomainBlank parentDomains(List<ReflectionDomain> domains) {
    throwExceptionIfReleased();
    this.primaryDomains.addAll(domains);
    return this;
  }

  public ReflectionDomainBlank foreignDomains(List<ReflectionDomain> domains) {
    throwExceptionIfReleased();
    this.foreignDomains = domains;
    return this;
  }

  public ReflectionDomainBlank contextChannel(ReflectionChannel channel) {
    throwExceptionIfReleased();
    this.contextChannels.add(channel);
    return this;
  }

  public ReflectionDomainBlank contextChannels(List<ReflectionChannel> channels) {
    throwExceptionIfReleased();
    this.contextChannels.addAll(channels);
    return this;
  }

  public ReflectionDomainBlank projectionThru(Rid cid, Projection projection) {
    throwExceptionIfReleased();
    projectionByChannelIdIndex.put(cid, projection);
    return this;
  }

  public ReflectionDomainBlank projectionThru(String channelAlias, Projection projection) {
    throwExceptionIfReleased();
    projectionByChannelAliasIndex.put(channelAlias, projection);
    return this;
  }

  public ReflectionDomain release() {
    this.substrate = new ReflectionDomainImpl(
        did,
        alias,
        domainType,
        domainClass,
        primaryDomains,
        foreignDomains,
        contextChannels
    );
    return this;
  }

  private void throwExceptionIfReleased() {
    if (substrate != ReflectionDomainStub.INSTANCE) {
      throw UnexpectedExceptions.withMessage("Reflection blank is released and cannot be changed");
    }
  }
}
