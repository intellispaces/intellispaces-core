package tech.intellispaces.core;

import tech.intellispaces.commons.type.Type;
import tech.intellispaces.commons.type.Types;

/**
 * The domain provider.
 */
public class Domains {

  /**
   * Creates a domain reflection.
   *
   * @param did the domain identifier.
   * @return created domain reflection.
   */
  public static Domain create(Rid did) {
    return new DomainImpl(did, null, null, null, undefine());
  }

  /**
   * Creates a domain reflection.
   *
   * @param name the domain name.
   * @return created domain reflection.
   */
  public static Domain create(String name) {
    return new DomainImpl(null, name, null, null, undefine());
  }

  /**
   * Creates a domain reflection.
   *
   * @param domainClass the domain class.
   * @return created domain reflection.
   */
  public static Domain create(Class<?> domainClass) {
    return new DomainImpl(null, domainClass.getCanonicalName(), domainClass, Types.get(domainClass), undefine());
  }

  public static Domain create(Rid rid, String name, Class<?> domainClass, Type<?> domainType) {
    return new DomainImpl(rid, name, domainClass, domainType, undefine());
  }

  /**
   * Returns undefined domain reflection.
   */
  public static Domain undefine() {
    return UNDEFINED_DOMAIN;
  }

  private static final Domain UNDEFINED_DOMAIN = new UndefinedDomainImp();

  private Domains() {}
}
