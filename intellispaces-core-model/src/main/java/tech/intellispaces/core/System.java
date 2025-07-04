package tech.intellispaces.core;

import org.jetbrains.annotations.Nullable;

/**
 * The intellispaces system.
 */
public interface System {

  /**
   * Returns a reflection in the context of the system.
   *
   * @param reference the reflection reference.
   * @return the reflection in the context of the system or <code>null</code> if reflection is not found in system.
   */
  @Nullable TraversableReflection getReflection(ReflectionReference reference);

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
  TraversableReflectionPoint mapSourceTo(Reflection source, ReflectionDomain domain);

  /**
   * Maps source through specified channel.
   *
   * @param source the source reflection.
   * @param targetDomain the target domain.
   * @param targetClass the target reflection class.
   * @return the target reflection.
   * @param <R> the target reflection type.
   */
  <R extends Reflection> R mapSourceTo(Reflection source, ReflectionDomain targetDomain, Class<R> targetClass);
}
