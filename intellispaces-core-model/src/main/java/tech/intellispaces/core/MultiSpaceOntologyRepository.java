package tech.intellispaces.core;

import java.util.Collection;

public interface MultiSpaceOntologyRepository extends OntologyRepository {

  Collection<OntologyRepository> repositories();
}
