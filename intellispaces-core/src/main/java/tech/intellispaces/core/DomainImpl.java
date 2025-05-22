package tech.intellispaces.core;

import tech.intellispaces.commons.type.Type;

class DomainImpl implements Domain {
  private final Rid rid;
  private final String name;
  private final Class<?> domainClass;
  private final Type<?> domainType;
  private final Domain domain;

  DomainImpl(Rid rid, String name, Class<?> domainClass, Type<?> domainType, Domain domain) {
    this.rid = rid;
    this.name = name;
    this.domainClass = domainClass;
    this.domainType = domainType;
    this.domain = domain;
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
}
