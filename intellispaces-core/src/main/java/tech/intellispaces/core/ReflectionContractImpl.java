package tech.intellispaces.core;

import tech.intellispaces.commons.properties.PropertiesSet;

class ReflectionContractImpl implements ReflectionContract {
  private final ReflectionDomain domain;
  private final String type;
  private final PropertiesSet properties;

  ReflectionContractImpl(ReflectionDomain domain, String type, PropertiesSet properties) {
    this.domain = domain;
    this.type = type;
    this.properties = properties;
  }

  @Override
  public ReflectionDomain domain() {
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
