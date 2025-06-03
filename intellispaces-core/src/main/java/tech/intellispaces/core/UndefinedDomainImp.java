package tech.intellispaces.core;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.type.Type;

/**
 * The undefined domain reflection.
 */
class UndefinedDomainImp implements Domain {
  private final Rid rid = Rids.undefined();

  @Override
  public Rid rid() {
    return rid;
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
    return Domains.undefine();
  }

  @Override
  public @Nullable String foreignDomainName() {
    return null;
  }
}
