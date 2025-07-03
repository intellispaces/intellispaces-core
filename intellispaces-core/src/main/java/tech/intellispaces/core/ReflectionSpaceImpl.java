package tech.intellispaces.core;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.exception.UnexpectedExceptions;

class ReflectionSpaceImpl extends AbstractReflection implements ReflectionSpace, ReflectionPoint {
  private final Rid sid;
  private final String name;
  @Nullable private final ReflectionDomain domain;

  ReflectionSpaceImpl(Rid sid, String name) {
    this(sid, name, null);
  }

  ReflectionSpaceImpl(Rid sid, String name, @Nullable ReflectionDomain domain) {
    this.sid = sid;
    this.name = name;
    this.domain = domain;
  }

  @Override
  public Rid rid() {
    return sid;
  }

  @Override
  public String reflectionName() {
    return name;
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
    return false;
  }

  @Override
  public boolean canBeRepresentedAsSpace() {
    return true;
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
    throw UnexpectedExceptions.withMessage("This reflection cannot be considered as a reflection channel");
  }

  @Override
  public ReflectionSpace asSpace() {
    return this;
  }
}
