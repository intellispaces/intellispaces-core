package tech.intellispaces.core;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.exception.UnexpectedExceptions;

class ReflectionImpl implements Reflection {
  private Rid rid;
  private String reflectionName;

  public ReflectionImpl(@Nullable Rid rid, @Nullable String reflectionName) {
    this.rid = rid;
    this.reflectionName = reflectionName;
  }

  @Override
  public @Nullable Rid rid() {
    return rid;
  }

  @Override
  public @Nullable String alias() {
    return reflectionName;
  }

  @Override
  public Projection projectionThru(Rid cid) {
    return Projections.unknown();
  }

  @Override
  public Projection projectionThru(String channelAlias) {
    return Projections.unknown();
  }

  @Override
  public Projection projectionTo(String domainAlias) {
    return Projections.unknown();
  }

  @Override
  public Projection projectionTo(ReflectionDomain domain) {
    return Projections.unknown();
  }

  @Override
  public List<Reflection> relatedReflections() {
    return List.of();
  }

  @Override
  public boolean canBeRepresentedAsPoint() {
    return false;
  }

  @Override
  public boolean canBeRepresentedAsDomain() {
    return false;
  }

  @Override
  public boolean canBeRepresentedAsChannel() {
    return false;
  }

  @Override
  public boolean canBeRepresentedAsSpace() {
    return false;
  }

  @Override
  public ReflectionPoint asPoint() {
    throw UnexpectedExceptions.withMessage("This reflection cannot be considered as a reflection point");
  }

  @Override
  public ReflectionDomain asDomain() {
    throw UnexpectedExceptions.withMessage("This reflection cannot be considered as a reflection domain");
  }

  @Override
  public ReflectionChannel asChannel() {
    throw UnexpectedExceptions.withMessage("This reflection cannot be considered as a reflection channel");
  }

  @Override
  public ReflectionSpace asSpace() {
    throw UnexpectedExceptions.withMessage("This reflection cannot be considered as a reflection space");
  }
}
