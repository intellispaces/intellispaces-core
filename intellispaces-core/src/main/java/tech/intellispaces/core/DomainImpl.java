package tech.intellispaces.core;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.type.Type;

class DomainImpl implements Domain {
  private final Rid rid;
  private final String name;
  private final Class<?> domainClass;
  private final Type<?> domainType;
  private final Domain domain;
  private final String foreignDomainName;

  DomainImpl(
      Rid rid,
      String name,
      Class<?> domainClass,
      Type<?> domainType,
      Domain domain,
      String foreignDomainName
  ) {
    this.rid = rid;
    this.name = name;
    this.domainClass = domainClass;
    this.domainType = domainType;
    this.domain = domain;
    this.foreignDomainName = foreignDomainName;
  }

  @Override
  public Rid rid() {
    return rid;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public Class<?> domainClass() {
    return domainClass;
  }

  @Override
  public Type<?> domainType() {
    return domainType;
  }

  @Override
  public Domain domain() {
    return domain;
  }

  @Override
  public @Nullable String foreignDomainName() {
    return foreignDomainName;
  }

  @Override
  public String toString() {
    var sb = new StringBuilder();
    if (name != null) {
      sb.append(name);
    } else if (domainClass != null) {
      sb.append(domainClass.getCanonicalName());
    }
    if (rid != null) {
      if (name != null || domainClass != null) {
        sb.append(" ");
      }
      sb.append("[").append(rid).append("]");
    }
    return sb.toString();
  }
}
