package tech.intellispaces.core;

/**
 * The reflection considered as a channel in semantic space.
 */
public interface ReflectionChannel extends Reflection {

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
  ReflectionDomain sourceDomain();

  /**
   * The channel target domain.
   */
  ReflectionDomain targetDomain();
}
