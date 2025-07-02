package tech.intellispaces.core;

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
      return reflectionName;
    }
    return reflectionName.substring(0, index);
  }
}
