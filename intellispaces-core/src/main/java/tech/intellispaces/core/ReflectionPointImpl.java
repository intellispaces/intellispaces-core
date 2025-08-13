package tech.intellispaces.core;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.exception.NotImplementedExceptions;

class ReflectionPointImpl extends AbstractReflection implements ReflectionPoint {
  private final Rid rid;
  private final String name;
  private final ReflectionDomain baseDomain;
  private final List<ReflectionPoint> parentPoints;

  ReflectionPointImpl(
      Rid rid,
      String name,
      ReflectionDomain baseDomain,
      List<ReflectionPoint> parentPoints
  ) {
    this.rid = rid;
    this.name = name;
    this.baseDomain = baseDomain;
    this.parentPoints = parentPoints;
  }

  @Override
  public @Nullable Rid rid() {
    return rid;
  }

  @Override
  public @Nullable String alias() {
    return name;
  }

  @Override
  public ReflectionDomain domain() {
    return baseDomain;
  }

  @Override
  public @Nullable String domainAlias() {
    if (baseDomain != null) {
      return baseDomain.alias();
    }
    return null;
  }

  @Override
  public List<ReflectionPoint> parentPoints() {
    return parentPoints;
  }

  @Override
  public boolean canBeRepresentedAsPoint() {
    return true;
  }

  @Override
  public boolean canBeRepresentedAsDomain() {
    throw NotImplementedExceptions.withCode("B23NUNeD");
  }

  @Override
  public boolean canBeRepresentedAsChannel() {
    throw NotImplementedExceptions.withCode("RbOJPuQt");
  }

  @Override
  public boolean canBeRepresentedAsSpace() {
    throw NotImplementedExceptions.withCode("vIC54JUd");
  }

  @Override
  public ReflectionPoint asPoint() {
    return this;
  }

  @Override
  public ReflectionDomain asDomain() {
    throw NotImplementedExceptions.withCode("yOIjGgoD");
  }

  @Override
  public ReflectionChannel asChannel() {
    throw NotImplementedExceptions.withCode("G7gpMs4L");
  }

  @Override
  public ReflectionSpace asSpace() {
    throw NotImplementedExceptions.withCode("SPjliV5V");
  }
}
