package tech.intellispaces.core;

/**
 * The modifiable ontology repository.
 */
public interface ModifiableOntologyRepository extends OntologyRepository {

  /**
   * Adds reflection to repository.
   *
   * @param reflection the reflection.
   */
  void add(Reflection reflection);
}
