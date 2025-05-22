package tech.intellispaces.core;

import tech.intellispaces.commons.properties.PropertiesSet;

/**
 * The contract for the creation of a reflection.
 */
public interface ReflectionContract {

  /**
   * The domain of object to be created.
   */
  Domain domain();

  /**
   * The contract type name.
   */
  String type();

  /**
   * The contract properties.
   */
  PropertiesSet properties();
}
