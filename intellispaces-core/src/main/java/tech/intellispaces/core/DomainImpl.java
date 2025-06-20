package tech.intellispaces.core;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.exception.UnexpectedExceptions;
import tech.intellispaces.commons.type.Type;

class DomainImpl extends AbstractDomain {
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
    if (rid == null && name == null && domainClass == null) {
      throw UnexpectedExceptions.withMessage("At least one of the following attributes must be defined: " +
          "rid, name, domainClass");
    }
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
}
