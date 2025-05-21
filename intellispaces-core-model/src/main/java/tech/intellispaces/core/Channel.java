package tech.intellispaces.core;

/**
 * The space channel.
 */
public interface Channel {

  /**
   * The channel identifier.
   */
  byte[] id();

  /**
   * The full qualified name.
   */
  String name();

  /**
   * The channel context alias.
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
