package tech.intellispaces.core;

import tech.intellispaces.commons.type.Type;

class UndefinedDomainImp implements Domain {
  private final Rid did = Rids.of(new byte[] {});

  @Override
  public Rid rid() {
    return did;
  }

  @Override
  public String name() {
    return "";
  }

  @Override
  public Class<?> domainClass() {
    return null;
  }

  @Override
  public Type<?> domainType() {
    return null;
  }

  @Override
  public Domain domain() {
    return Domains.undefinedDomain();
  }
}
