package tech.intellispaces.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.exception.UnexpectedExceptions;

public class ReflectionChannelBlank extends AbstractReflection implements ReflectionChannelPoint, ReflectionBlank {
  private Rid cid;
  private String alias;
  private ReflectionDomain parentDomain;
  private ReflectionDomain sourceDomain;
  private ReflectionDomain targetDomain;
  private final Map<Rid, Projection> projectionByChannelIdIndex = new HashMap<>();
  private final Map<String, Projection> projectionByChannelAliasIndex = new HashMap<>();

  private ReflectionChannelPoint substrate = ReflectionChannelStub.INSTANCE;

  @Override
  public Rid rid() {
    return substrate.cid();
  }

  @Override
  public String alias() {
    return substrate.alias();
  }

  @Override
  public @Nullable String localAlias() {
    return substrate.localAlias();
  }

  @Override
  public ReflectionDomain sourceDomain() {
    return substrate.sourceDomain();
  }

  @Override
  public ReflectionDomain targetDomain() {
    return substrate.targetDomain();
  }

  @Override
  public ReflectionDomain domain() {
    return substrate.domain();
  }

  @Override
  public @Nullable String domainAlias() {
    return substrate.domainAlias();
  }

  @Override
  public List<ReflectionPoint> primaryPoints() {
    return substrate.primaryPoints();
  }

  @Override
  public boolean canBeRepresentedAsPoint() {
    return substrate.canBeRepresentedAsPoint();
  }

  @Override
  public boolean canBeRepresentedAsDomain() {
    return substrate.canBeRepresentedAsDomain();
  }

  @Override
  public boolean canBeRepresentedAsChannel() {
    return substrate.canBeRepresentedAsChannel();
  }

  @Override
  public boolean canBeRepresentedAsSpace() {
    return substrate.canBeRepresentedAsSpace();
  }

  @Override
  public ReflectionPoint asPoint() {
    return substrate.asPoint();
  }

  @Override
  public ReflectionDomain asDomain() {
    return substrate.asDomain();
  }

  @Override
  public ReflectionChannel asChannel() {
    return substrate.asChannel();
  }

  @Override
  public ReflectionSpace asSpace() {
    return substrate.asSpace();
  }

  @Override
  public Projection projectionThru(Rid cid) {
    return substrate.projectionThru(cid);
  }

  @Override
  public Projection projectionThru(String channelAlias) {
    return substrate.projectionThru(channelAlias);
  }

  @Override
  public Projection projectionTo(String domainAlias) {
    return substrate.projectionTo(domainAlias);
  }

  @Override
  public Projection projectionTo(ReflectionDomain domain) {
    return substrate.projectionTo(domain);
  }

  @Override
  public List<Reflection> relatedReflections() {
    return substrate.relatedReflections();
  }

  @Override
  public boolean isReleased() {
    return substrate != ReflectionChannelStub.INSTANCE;
  }

  public ReflectionChannelBlank projectionThru(Rid cid, Projection projection) {
    throwExceptionIfReleased();
    projectionByChannelIdIndex.put(cid, projection);
    return this;
  }

  public ReflectionChannelBlank projectionThru(String channelAlias, Projection projection) {
    throwExceptionIfReleased();
    projectionByChannelAliasIndex.put(channelAlias, projection);
    return this;
  }

  public ReflectionChannelBlank cid(Rid cid) {
    throwExceptionIfReleased();
    this.cid = cid;
    return this;
  }

  public ReflectionChannelBlank alias(String alias) {
    throwExceptionIfReleased();
    this.alias = alias;
    return this;
  }

  public ReflectionChannelBlank parentDomain(ReflectionDomain domain) {
    throwExceptionIfReleased();
    this.parentDomain = domain;
    return this;
  }

  public ReflectionChannelBlank sourceDomain(ReflectionDomain domain) {
    throwExceptionIfReleased();
    this.sourceDomain = domain;
    return this;
  }

  public ReflectionChannelBlank targetDomain(ReflectionDomain domain) {
    throwExceptionIfReleased();
    this.targetDomain = domain;
    return this;
  }

  public ReflectionChannel release() {
    throwExceptionIfReleased();
    substrate = new ReflectionChannelImpl(
        cid,
        alias,
        parentDomain,
        sourceDomain,
        targetDomain
    );
    return this;
  }

  private void throwExceptionIfReleased() {
    if (substrate != ReflectionChannelStub.INSTANCE) {
      throw UnexpectedExceptions.withMessage("Reflection blank is released and cannot be changed");
    }
  }
}
