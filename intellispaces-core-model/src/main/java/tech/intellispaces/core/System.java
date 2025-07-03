package tech.intellispaces.core;

/**
 * The intellispaces system.
 */
public interface System {

  /**
   * Returns a reflection in the context of the system.
   *
   * @param reflection the origin reflection.
   * @return the reflection in the context of the system.
   */
  TraversableReflection getReflection(Reflection reflection);

  /**
   * Returns a point reflection in the context of the system.
   *
   * @param point the origin reflection.
   * @return the reflection in the context of the system.
   */
  TraversableReflectionPoint getReflection(ReflectionPoint point);

  /**
   * Returns a space reflection in the context of the system.
   *
   * @param space the origin reflection.
   * @return the reflection in the context of the system.
   */
  TraversableReflectionSpace getReflection(ReflectionSpace space);

  /**
   * Returns a domain reflection in the context of the system.
   *
   * @param domain the origin reflection.
   * @return the reflection in the context of the system.
   */
  TraversableReflectionDomain getReflection(ReflectionDomain domain);

  /**
   * Returns a channel reflection in the context of the system.
   *
   * @param channel the origin reflection.
   * @return the reflection in the context of the system.
   */
  TraversableReflectionChannel getReflection(ReflectionChannel channel);

  /**
   * Creates reflection by contract and registered it in the system.
   *
   * @param contract the contract.
   * @return created reflection.
   */
  TraversableReflectionPoint createReflection(ReflectionContract contract);

  /**
   * Maps source to specified domain.
   *
   * @param source the source reflection.
   * @param domain the target domain.
   * @return the target reflection.
   * @param <S> the source reflection type.
   * @param <T> the target reflection type.
   */
  <S, T> T mapSourceTo(S source, ReflectionDomain domain);

  /**
   * Maps source through specified channel.
   *
   * @param source the source reflection.
   * @param domain the target domain.
   * @return the target reflection.
   */
  TraversableReflectionPoint mapSourceTo(ReflectionPoint source, ReflectionDomain domain);

  /**
   * Maps source through specified channel.
   *
   * @param source the source reflection.
   * @param targetDomain the target domain.
   * @param targetClass the target reflection class.
   * @return the target reflection.
   * @param <R> the target reflection type.
   */
  <R extends Reflection> R mapSourceTo(ReflectionPoint source, ReflectionDomain targetDomain, Class<R> targetClass);
}
