package tech.intellispaces.core;

/**
 * The space channel.
 */
public interface Channel {

  /**
   * The channel identifier.
   */
  String cid();

  /**
   * The full qualified name.
   */
  String name();

  /**
   * The channel context alias.
   */
  String alias();
}
