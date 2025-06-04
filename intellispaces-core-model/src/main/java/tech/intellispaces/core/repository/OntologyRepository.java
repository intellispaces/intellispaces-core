package tech.intellispaces.core.repository;

import tech.intellispaces.core.Channel;
import tech.intellispaces.core.Domain;

/**
 * The ontology repository.
 */
public interface OntologyRepository {

  Domain findDomain(String name);

  Channel findChannel(String name);

  Channel findChannel(Domain sourceDomain, Domain targetDomain);
}
