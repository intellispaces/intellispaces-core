package tech.intellispaces.core;

import java.util.Objects;

import tech.intellispaces.commons.type.Type;
import tech.intellispaces.commons.type.Types;

/**
 * The domain provider.
 */
public class Domains {

  public static DomainBuilder build() {
    return new DomainBuilder();
  }

  /**
   * Creates a domain reflection.
   *
   * @param did the domain identifier.
   * @return created domain reflection.
   */
  public static Domain create(Rid did) {
    return new DomainImpl(did, null, null, null, undefined(), null);
  }

  /**
   * Creates a domain reflection.
   *
   * @param name the domain name.
   * @return created domain reflection.
   */
  public static Domain create(String name) {
    return new DomainImpl(null, name, null, null, undefined(), null);
  }

  /**
   * Creates a domain reflection.
   *
   * @param domainClass the domain class.
   * @return created domain reflection.
   */
  public static Domain create(Class<?> domainClass) {
    return new DomainImpl(
        null,
        domainClass.getCanonicalName(),
        domainClass,
        Types.get(domainClass),
        undefined(),
        null
    );
  }

  /**
   * Creates a domain reflection.
   *
   * @param name the domain name.
   * @param foreignDomainName the name of the foreign domain.
   * @return created domain reflection.
   */
  public static Domain create(String name, String foreignDomainName) {
    return new DomainImpl(null, name, null, null, undefined(), foreignDomainName);
  }

  public static Domain create(Rid rid, String name, Class<?> domainClass, Type<?> domainType) {
    return new DomainImpl(rid, name, domainClass, domainType, undefined(), null);
  }

  /**
   * Returns undefined domain reflection.
   */
  public static Domain undefined() {
    return UNDEFINED_DOMAIN;
  }

  public static boolean isEqualDomains(Domain domain1, Domain domain2) {
    Objects.requireNonNull(domain1);
    Objects.requireNonNull(domain2);
    if (domain1.rid() != null && domain2.rid() != null) {
      return Objects.equals(domain1.rid(), domain2.rid());
    }
    if (domain1.rname() != null && domain2.rname() != null) {
      return Objects.equals(domain1.rname(), domain2.rname());
    }
    if (domain1.domainClass() != null && domain2.domainClass() != null) {
      return Objects.equals(domain1.domainClass(), domain2.domainClass());
    }
    return false;
  }

  private static final Domain UNDEFINED_DOMAIN = new UndefinedDomainImp();

  private Domains() {}
}
