package tech.intellispaces.core;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.exception.UnexpectedExceptions;

abstract class AbstractReflectionDomain extends AbstractReflection implements ReflectionDomain, ReflectionPoint {
  protected ReflectionDomain baseDomain;

  AbstractReflectionDomain(ReflectionDomain baseDomain) {
    this.baseDomain = baseDomain;
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
    return List.of();
  }

  @Override
  public boolean canBeRepresentedAsPoint() {
    return baseDomain != null;
  }

  @Override
  public boolean canBeRepresentedAsDomain() {
    return true;
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
    if (canBeRepresentedAsPoint()) {
      return this;
    }
    throw UnexpectedExceptions.withMessage("This reflection cannot be considered as a reflection point");
  }

  @Override
  public ReflectionDomain asDomain() {
    return this;
  }

  @Override
  public ReflectionChannel asChannel() {
    throw UnexpectedExceptions.withMessage("This reflection cannot be considered as a reflection channel");
  }

  @Override
  public ReflectionSpace asSpace() {
    throw UnexpectedExceptions.withMessage("This reflection cannot be considered as a reflection space");
  }

  @Override
  public String toString() {
    var sb = new StringBuilder();
    if (alias() != null) {
      sb.append(alias());
    } else if (domainClass() != null) {
      sb.append(domainClass().getCanonicalName());
    }
    if (rid() != null) {
      if (alias() != null || domainClass() != null) {
        sb.append(" ");
      }
      sb.append("[").append(rid()).append("]");
    }
    return sb.toString();
  }
}
