package tech.intellispaces.core;

import java.util.List;

import tech.intellispaces.commons.exception.UnexpectedExceptions;
import tech.intellispaces.commons.type.Type;

class ReflectionDomainImpl extends AbstractReflectionDomain {
  private final Rid did;
  private final String alias;
  private final Class<?> domainClass;
  private final Type<?> domainType;
  private final List<ReflectionDomain> parentDomains;
  private final List<ReflectionDomain> foreignDomains;
  private final List<ReflectionChannel> contextChannels;

  ReflectionDomainImpl(
      Rid did,
      String alias,
      ReflectionDomain baseDomain,
      Class<?> domainClass,
      Type<?> domainType,
      List<ReflectionDomain> parentDomains,
      List<ReflectionDomain> foreignDomains,
      List<ReflectionChannel> contextChannels
  ) {
    super(baseDomain);

    if (did == null && alias == null && domainClass == null) {
      throw UnexpectedExceptions.withMessage("At least one of the following attributes must be defined: " +
          "domain rid, alias or class");
    }
    this.did = did;
    this.alias = alias;
    this.domainClass = domainClass;
    this.domainType = domainType;
    this.parentDomains = parentDomains;
    this.foreignDomains = foreignDomains;
    this.contextChannels = contextChannels;
  }

  @Override
  public Rid rid() {
    return did;
  }

  @Override
  public String alias() {
    return alias;
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
  public List<ReflectionDomain> parentDomains() {
    return parentDomains;
  }

  @Override
  public List<ReflectionDomain> foreignDomains() {
    return foreignDomains;
  }

  @Override
  public List<ReflectionChannel> contextChannels() {
    return contextChannels;
  }
}
