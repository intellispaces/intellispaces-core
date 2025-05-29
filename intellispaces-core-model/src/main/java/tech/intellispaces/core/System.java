package tech.intellispaces.core;

/**
 * The intellispaces system.
 */
public interface System {

  <S, T> T mapSourceTo(S source, Domain domain);

  Reflection mapSourceTo(Reflection source, Domain domain);

  <R extends Reflection> R mapSourceTo(Reflection source, Domain targetDomain, Class<R> targetClass);

  /**
   * Creates by contract a reflection registered in the system.
   *
   * @param contract the contract.
   * @return created reflection.
   */
  Reflection create(ReflectionContract contract);
}
