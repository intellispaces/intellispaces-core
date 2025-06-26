package tech.intellispaces.core;

import tech.intellispaces.commons.abstraction.Enumeration;

/**
 * Reflection types.
 */
public enum ReflectionTypes implements ReflectionType, Enumeration<ReflectionType> {

  /**
   * The point.
   */
  Point,

  /**
   * The domain.
   */
  Domain,

  /**
   * The channel.
   */
  Channel,

  /**
   * The space.
   */
  Space,

  /**
   * The undefined reflection type.
   */
  Undefined
}
