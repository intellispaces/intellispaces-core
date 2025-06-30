package tech.intellispaces.core;

abstract class AbstractDomain extends AbstractReflection implements Domain {

  @Override
  public ReflectionType reflectionType() {
    return ReflectionTypes.Domain;
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
