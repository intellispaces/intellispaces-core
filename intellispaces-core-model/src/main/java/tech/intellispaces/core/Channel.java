package tech.intellispaces.core;

/**
 * The semantic space channel.
 */
public interface Channel extends Reflection {

  /**
   * The channel identifier.
   */
  default Rid cid() {
    return rid();
  }

  /**
   * The channel alias in the context of the source domain.
   */
  String alias();

  /**
   * The channel source domain.
   */
  Domain sourceDomain();

  /**
   * The channel target domain.
   */
  Domain targetDomain();
}
