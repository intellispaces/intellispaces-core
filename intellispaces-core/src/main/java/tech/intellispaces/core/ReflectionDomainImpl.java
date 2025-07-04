package tech.intellispaces.core;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.exception.UnexpectedExceptions;
import tech.intellispaces.commons.type.Type;

class ReflectionDomainImpl extends AbstractReflectionDomain {
  private final Rid did;
  private final String name;
  private final Class<?> domainClass;
  private final Type<?> domainType;
  private final ReflectionDomain borrowedDomain;
  private final List<ReflectionDomain> parentDomains;

  ReflectionDomainImpl(
      Rid did,
      String name,
      Class<?> domainClass,
      Type<?> domainType,
      @Nullable ReflectionDomain borrowedDomain,
      List<ReflectionDomain> parentDomains
  ) {
    if (did == null && name == null && domainClass == null) {
      throw UnexpectedExceptions.withMessage("At least one of the following attributes must be defined: " +
          "rid, name, domainClass");
    }
    this.did = did;
    this.name = name;
    this.domainClass = domainClass;
    this.domainType = domainType;
    this.borrowedDomain = borrowedDomain;
    this.parentDomains = parentDomains;
  }

  @Override
  public Rid rid() {
    return did;
  }

  @Override
  public String reflectionName() {
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
  public @Nullable ReflectionDomain borrowedDomain() {
    return borrowedDomain;
  }

  @Override
  public List<ReflectionChannel> domainChannels() {
    return List.of();
  }

  @Override
  public List<ReflectionDomain> parentDomains() {
    return parentDomains;
  }
}
