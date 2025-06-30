package tech.intellispaces.core;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.type.Type;

/**
 * The undefined domain reflection.
 */
class UndefinedDomainImp extends AbstractDomain {
  private final Rid rid = Rids.undefined();

  @Override
  public Rid rid() {
    return rid;
  }

  @Override
  public String reflectionName() {
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
    return Domains.undefined();
  }

  @Override
  public @Nullable Domain borrowedDomain() {
    return null;
  }
}
