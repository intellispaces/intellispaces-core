package tech.intellispaces.core.base.repository;

import tech.intellispaces.core.base.Channel;
import tech.intellispaces.core.base.Domain;

public interface SpaceRepository {

  Domain findDomain(String name);

  Channel findChannel(String name);
}
