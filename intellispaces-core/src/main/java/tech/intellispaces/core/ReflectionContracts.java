package tech.intellispaces.core;

import tech.intellispaces.commons.properties.PropertiesSet;
import tech.intellispaces.commons.properties.PropertiesSets;

/**
 * The reflection contract provider.
 */
public interface ReflectionContracts {

  /**
   * Creates new contract.
   *
   * @param domain the domain of object to be created.
   * @param type the contract type name.
   * @return created contract.
   */
  static ReflectionContract create(ReflectionDomain domain, String type) {
    return new ReflectionContractImpl(domain, type, PropertiesSets.empty());
  }

  /**
   * Creates new contract.
   *
   * @param domain the domain of object to be created.
   * @param type the contract type name.
   * @param properties contract properties.
   * @return created contract.
   */
  static ReflectionContract create(ReflectionDomain domain, String type, PropertiesSet properties) {
    return new ReflectionContractImpl(domain, type, properties);
  }

  /**
   * Creates new contract.
   *
   * @param did the domain identifier of object to be created.
   * @param type the contract type name.
   * @param properties contract properties.
   * @return created contract.
   */
  static ReflectionContract create(Rid did, String type, PropertiesSet properties) {
    return new ReflectionContractImpl(Domains.create(did), type, properties);
  }
}
