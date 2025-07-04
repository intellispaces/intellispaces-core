package tech.intellispaces.core;

import java.util.List;

import tech.intellispaces.commons.exception.UnexpectedExceptions;

class ReflectionChannelImpl extends AbstractReflection implements ReflectionChannel, ReflectionPoint {
  private final Rid rid;
  private final String name;
  private final String alias;
  private final ReflectionDomain sourceDomain;
  private final ReflectionDomain targetDomain;
  private final ReflectionDomain domain;

  ReflectionChannelImpl(
      Rid rid,
      String name,
      String alias,
      ReflectionDomain sourceDomain,
      ReflectionDomain targetDomain,
      ReflectionDomain domain
  ) {
    this.rid = rid;
    this.name = name;
    this.alias = alias;
    this.sourceDomain = sourceDomain;
    this.targetDomain = targetDomain;
    this.domain = domain;
  }

  @Override
  public Rid rid() {
    return rid;
  }

  @Override
  public String reflectionName() {
    return name;
  }

  @Override
  public String alias() {
    return alias;
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
    return domain;
  }

  @Override
  public List<ReflectionPoint> underlyingPoints() {
    return List.of();
  }

  @Override
  public boolean canBeRepresentedAsPoint() {
    return domain != null;
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
}
