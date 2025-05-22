package tech.intellispaces.core;

/**
 * The intellispaces system.
 */
public interface System {

  /**
   * Creates by contract a reflection registered in the system.
   *
   * @param contract the contract.
   * @return created reflection.
   */
  Reflection create(ReflectionContract contract);
}
