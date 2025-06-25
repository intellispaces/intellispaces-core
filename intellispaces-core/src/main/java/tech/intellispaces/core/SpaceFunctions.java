package tech.intellispaces.core;

import tech.intellispaces.commons.exception.UnexpectedExceptions;

/**
 * Space related functions.
 */
public interface SpaceFunctions {

  /**
   * Returns space name from the qualified reflection name.
   *
   * @param reflectionName the qualified reflection name.
   * @return the space name.
   */
  static String getSpaceName(String reflectionName) {
    int index = reflectionName.indexOf('.');
    if (index <= 0) {
      throw UnexpectedExceptions.withMessage("Unable to extract a space name from qualified reflection name '{0}'",
          reflectionName);
    }
    return reflectionName.substring(0, index);
  }
}
