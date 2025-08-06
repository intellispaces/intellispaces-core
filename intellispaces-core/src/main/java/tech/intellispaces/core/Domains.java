package tech.intellispaces.core;

import java.util.List;
import java.util.Objects;

import tech.intellispaces.commons.type.Type;

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
  public static ReflectionDomain create(Rid did) {
    return new ReflectionDomainImpl(did, null, null, null, null, List.of(), List.of());
  }

  /**
   * Creates a domain reflection.
   *
   * @param domainName the domain name.
   * @return created domain reflection.
   */
  public static ReflectionDomain create(String domainName) {
    return new ReflectionDomainImpl(null, domainName, null, null, null, List.of(), List.of());
  }

  public static ReflectionDomain create(Rid rid, String domainName, Class<?> domainClass, Type<?> domainType) {
    return new ReflectionDomainImpl(rid, domainName, null, domainClass, domainType, List.of(), List.of());
  }

  public static boolean isEqualDomains(ReflectionDomain domain1, ReflectionDomain domain2) {
    Objects.requireNonNull(domain1);
    Objects.requireNonNull(domain2);
    if (domain1.rid() != null && domain2.rid() != null) {
      return Objects.equals(domain1.rid(), domain2.rid());
    }
    if (domain1.reflectionName() != null && domain2.reflectionName() != null) {
      return Objects.equals(domain1.reflectionName(), domain2.reflectionName());
    }
    if (domain1.domainClass() != null && domain2.domainClass() != null) {
      return Objects.equals(domain1.domainClass(), domain2.domainClass());
    }
    return false;
  }

  private Domains() {}
}
