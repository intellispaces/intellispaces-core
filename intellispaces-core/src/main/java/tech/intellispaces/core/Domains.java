package tech.intellispaces.core;

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
    return new DomainImpl(did, null, null, null, undefinedDomain());
  }

  /**
   * Creates a domain reflection.
   *
   * @param name the domain name.
   * @return created domain reflection.
   */
  public static Domain create(String name) {
    return new DomainImpl(null, name, null, null, undefinedDomain());
  }

  /**
   * Returns undefined domain reflection.
   */
  public static Domain undefinedDomain() {
    return UNDEFINED_DOMAIN;
  }

  private static final Domain UNDEFINED_DOMAIN = new UndefinedDomainImp();

  private Domains() {}
}
