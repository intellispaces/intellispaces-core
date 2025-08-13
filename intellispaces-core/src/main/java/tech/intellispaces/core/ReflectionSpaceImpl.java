package tech.intellispaces.core;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.exception.UnexpectedExceptions;

class ReflectionSpaceImpl extends AbstractReflection implements ReflectionSpace, ReflectionPoint {
  private final Rid sid;
  private final String alais;
  @Nullable private final ReflectionDomain domain;

  ReflectionSpaceImpl(Rid sid, String alais) {
    this(sid, alais, null);
  }

  ReflectionSpaceImpl(Rid sid, String alais, @Nullable ReflectionDomain domain) {
    this.sid = sid;
    this.alais = alais;
    this.domain = domain;
  }

  @Override
  public Rid rid() {
    return sid;
  }

  @Override
  public String alias() {
    return alais;
  }

  @Override
  public ReflectionDomain domain() {
    return domain;
  }

  @Override
  public @Nullable String domainAlias() {
    if (domain != null) {
      return domain.alias();
    }
    return null;
  }

  @Override
  public List<ReflectionPoint> parentPoints() {
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
