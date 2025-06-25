package tech.intellispaces.core;

abstract class AbstractDomain extends AbstractReflection implements Domain {

  @Override
  public String toString() {
    var sb = new StringBuilder();
    if (name() != null) {
      sb.append(name());
    } else if (domainClass() != null) {
      sb.append(domainClass().getCanonicalName());
    }
    if (rid() != null) {
      if (name() != null || domainClass() != null) {
        sb.append(" ");
      }
      sb.append("[").append(rid()).append("]");
    }
    return sb.toString();
  }
}
