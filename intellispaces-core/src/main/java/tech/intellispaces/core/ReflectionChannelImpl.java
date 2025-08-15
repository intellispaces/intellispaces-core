package tech.intellispaces.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.exception.UnexpectedExceptions;

class ReflectionChannelImpl extends AbstractReflection implements ReflectionChannelPoint {
  private final Rid cid;
  private final String alias;
  private final ReflectionDomain parentDomain;
  private final ReflectionDomain sourceDomain;
  private final ReflectionDomain targetDomain;
  private final Map<Rid, Projection> projectionByChannelIdIndex = new HashMap<>();
  private final Map<String, Projection> projectionByChannelAliasIndex = new HashMap<>();

  ReflectionChannelImpl(
      Rid cid,
      String alias,
      ReflectionDomain parentDomain,
      ReflectionDomain sourceDomain,
      ReflectionDomain targetDomain
  ) {
    this.cid = cid;
    this.alias = alias;
    this.parentDomain = parentDomain;
    this.sourceDomain = sourceDomain;
    this.targetDomain = targetDomain;
  }

  @Override
  public Rid rid() {
    return cid;
  }

  @Override
  public String alias() {
    return alias;
  }

  @Override
  public @Nullable String localAlias() {
    return null;
  }

  @Override
  public ReflectionDomain sourceDomain() {
    return sourceDomain;
  }

  @Override
  public ReflectionDomain targetDomain() {
    return targetDomain;
  }

  @Override
  public ReflectionDomain domain() {
    return parentDomain;
  }

  @Override
  public @Nullable String domainAlias() {
    if (parentDomain != null) {
      return parentDomain.alias();
    }
    return null;
  }

  @Override
  public List<ReflectionPoint> primaryPoints() {
    return List.of();
  }

  @Override
  public boolean canBeRepresentedAsPoint() {
    return parentDomain != null;
  }

  @Override
  public boolean canBeRepresentedAsDomain() {
    return false;
  }

  @Override
  public boolean canBeRepresentedAsChannel() {
    return true;
  }

  @Override
  public boolean canBeRepresentedAsSpace() {
    return false;
  }

  @Override
  public ReflectionPoint asPoint() {
    if (canBeRepresentedAsPoint()) {
      return this;
    }
    throw UnexpectedExceptions.withMessage("This reflection cannot be considered as a reflection point");
  }

  @Override
  public ReflectionDomain asDomain() {
    throw UnexpectedExceptions.withMessage("This reflection cannot be considered as a reflection domain");
  }

  @Override
  public ReflectionChannel asChannel() {
    return this;
  }

  @Override
  public ReflectionSpace asSpace() {
    throw UnexpectedExceptions.withMessage("This reflection cannot be considered as a reflection space");
  }

  @Override
  public Projection projectionThru(Rid cid) {
    return null;
  }

  @Override
  public Projection projectionThru(String channelAlias) {
    return null;
  }

  @Override
  public Projection projectionTo(String domainAlias) {
    return null;
  }

  @Override
  public Projection projectionTo(ReflectionDomain domain) {
    return null;
  }

  @Override
  public List<Reflection> relatedReflections() {
    return List.of();
  }
}
