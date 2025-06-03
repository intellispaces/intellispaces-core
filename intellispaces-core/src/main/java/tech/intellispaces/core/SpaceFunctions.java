package tech.intellispaces.core;

import tech.intellispaces.commons.exception.UnexpectedExceptions;

/**
 * Space related functions.
 */
public interface SpaceFunctions {

  /**
   * Extracts space name from domain name.
   *
   * @param domainName the domain name.
   * @return a space name.
   */
  static String spaceNameOfDomain(String domainName) {
    int index = domainName.indexOf('.');
    if (index <= 0) {
      throw UnexpectedExceptions.withMessage("Unable to extract a space name from domain name {0}", domainName);
    }
    return domainName.substring(0, index);
  }
}
