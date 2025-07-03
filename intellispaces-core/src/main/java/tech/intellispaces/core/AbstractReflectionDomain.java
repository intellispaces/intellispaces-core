package tech.intellispaces.core;

import java.util.List;

import tech.intellispaces.commons.exception.UnexpectedExceptions;

abstract class AbstractReflectionDomain extends AbstractReflection implements ReflectionDomain, ReflectionPoint {
  protected ReflectionDomain domain;

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
    if (reflectionName() != null) {
      sb.append(reflectionName());
    } else if (domainClass() != null) {
      sb.append(domainClass().getCanonicalName());
    }
    if (rid() != null) {
      if (reflectionName() != null || domainClass() != null) {
        sb.append(" ");
      }
      sb.append("[").append(rid()).append("]");
    }
    return sb.toString();
  }
}
