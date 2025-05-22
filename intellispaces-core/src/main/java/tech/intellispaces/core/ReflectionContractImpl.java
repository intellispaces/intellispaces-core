package tech.intellispaces.core;

import tech.intellispaces.commons.properties.PropertiesSet;

class ReflectionContractImpl implements ReflectionContract {
  private final Domain domain;
  private final String type;
  private final PropertiesSet properties;

  ReflectionContractImpl(Domain domain, String type, PropertiesSet properties) {
    this.domain = domain;
    this.type = type;
    this.properties = properties;
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
