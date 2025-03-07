package tech.intellispaces.core.repository;

import tech.intellispaces.core.Channel;
import tech.intellispaces.core.Domain;

public interface SpaceRepository {

  Domain findDomain(String name);

  Channel findChannel(String name);
}
