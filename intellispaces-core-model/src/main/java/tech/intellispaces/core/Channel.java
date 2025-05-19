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

  Domain sourceDomain();

  Domain targetDomain();
}
