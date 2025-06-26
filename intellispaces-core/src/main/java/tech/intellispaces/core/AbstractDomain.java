package tech.intellispaces.core;

abstract class AbstractDomain extends AbstractReflection implements Domain {

  @Override
  public ReflectionType rtype() {
    return ReflectionTypes.Domain;
  }

  @Override
  public String toString() {
    var sb = new StringBuilder();
    if (rname() != null) {
      sb.append(rname());
    } else if (domainClass() != null) {
      sb.append(domainClass().getCanonicalName());
    }
    if (rid() != null) {
      if (rname() != null || domainClass() != null) {
        sb.append(" ");
      }
      sb.append("[").append(rid()).append("]");
    }
    return sb.toString();
  }
}
