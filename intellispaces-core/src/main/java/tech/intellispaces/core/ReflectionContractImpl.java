package tech.intellispaces.core;

import tech.intellispaces.commons.properties.PropertiesSet;

class ReflectionContractImpl implements ReflectionContract {
  private final Rid rid;
  private final Domain domain;
  private final String type;
  private final PropertiesSet properties;

  ReflectionContractImpl(Rid rid, Domain domain, String type, PropertiesSet properties) {
    this.rid = rid;
    this.domain = domain;
    this.type = type;
    this.properties = properties;
  }

  @Override
  public Rid rid() {
    return rid;
  }

  @Override
  public Domain domain() {
    return domain;
  }

  @Override
  public String type() {
    return type;
  }

  @Override
  public PropertiesSet properties() {
    return properties;
  }
}
