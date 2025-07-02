package tech.intellispaces.core;

import java.util.List;

/**
 * The intellispaces system.
 */
public interface System {

  /**
   * Returns a reflection in the context of the system.
   *
   * @param reflection the reflection prototype.
   * @return the created reflection.
   */
  TraversableReflection getReflection(Reflection reflection);

  /**
   * Returns a reflection in the context of the system.
   *
   * @param reflection the reflection prototype.
   * @param reflectionClass the reflection class.
   * @return the created reflection.
   * @param <T> the reflection type.
   */
  <T> T getReflection(Reflection reflection, Class<T> reflectionClass);

  /**
   * Maps source to specified domain.
   *
   * @param source the source reflection.
   * @param domain the target domain.
   * @return the target reflection.
   * @param <S> the source reflection type.
   * @param <T> the target reflection type.
   */
  <S, T> T mapSourceTo(S source, Domain domain);

  /**
   * Maps source through specified channel.
   *
   * @param source the source reflection.
   * @param domain the target domain.
   * @return the target reflection.
   */
  Reflection mapSourceTo(Reflection source, Domain domain);

  /**
   * Maps source through specified channel.
   *
   * @param source the source reflection.
   * @param targetDomain the target domain.
   * @param targetClass the target reflection class.
   * @return the target reflection.
   * @param <R> the target reflection type.
   */
  <R extends Reflection> R mapSourceTo(Reflection source, Domain targetDomain, Class<R> targetClass);

  /**
   * Creates by contract a reflection registered in the system.
   *
   * @param contract the contract.
   * @return created reflection.
   */
  Reflection create(ReflectionContract contract);

  /**
   * Searches for factories that create reflections of a given domain.
   *
   * @param domain the reflection domain.
   * @return the list of factories.
   */
  List<ReflectionFactory> findFactories(Domain domain);
}
