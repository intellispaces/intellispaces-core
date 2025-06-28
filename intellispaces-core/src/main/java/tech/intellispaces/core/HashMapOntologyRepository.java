package tech.intellispaces.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.exception.NotImplementedExceptions;
import tech.intellispaces.commons.exception.UnexpectedExceptions;

public class HashMapOntologyRepository implements ModifiableOntologyRepository {
  private final Map<Rid, Reflection> ridToReflectionIndex = new HashMap<>();
  private final Map<String, Reflection> rnameToReflectionIndex = new HashMap<>();

  @Override
  public void add(Reflection reflection) {
    if (reflection.rid() != null) {
      ridToReflectionIndex.put(reflection.rid(), reflection);
    }
    if (reflection.rname() != null) {
      rnameToReflectionIndex.put(reflection.rname(), reflection);
    }
  }

  @Override
  public @Nullable Reflection findReflection(Rid rid) {
    return ridToReflectionIndex.get(rid);
  }

  @Override
  public @Nullable Reflection findReflection(String reflectionName) {
    return rnameToReflectionIndex.get(reflectionName);
  }

  @Override
  public @Nullable Space findSpace(String spaceName) {
    Reflection reflection = findReflection(spaceName);
    if (reflection == null) {
      return null;
    }
    if (reflection instanceof Space space) {
      return space;
    }
    throw UnexpectedExceptions.withMessage("The reflection type does not match the requested type");
  }

  @Override
  public @Nullable Domain findDomain(String domainName) {
    Reflection reflection = findReflection(domainName);
    if (reflection == null) {
      return null;
    }
    if (reflection instanceof Domain domain) {
      return domain;
    }
    throw UnexpectedExceptions.withMessage("The reflection type does not match the requested type");
  }

  @Override
  public List<Domain> findSubdomains(Rid did) {
    throw NotImplementedExceptions.withCode("g6I9jQ");
  }

  @Override
  public List<Domain> findSubdomains(String domainName) {
    throw NotImplementedExceptions.withCode("QSZRkg");
  }

  @Override
  public @Nullable Domain findBorrowedDomain(String domainName) {
    throw NotImplementedExceptions.withCode("yKMZxw");
  }

  @Override
  public @Nullable Channel findChannel(String channelName) {
    Reflection reflection = findReflection(channelName);
    if (reflection == null) {
      return null;
    }
    if (reflection instanceof Channel channel) {
      return channel;
    }
    throw UnexpectedExceptions.withMessage("The reflection type does not match the requested type");
  }

  @Override
  public @Nullable Channel findChannel(Domain sourceDomain, Domain targetDomain) {
    return null;
  }

  @Override
  public @Nullable Point findPoint(String pointName) {
    Reflection reflection = findReflection(pointName);
    if (reflection == null) {
      return null;
    }
    if (reflection instanceof Point point) {
      return point;
    }
    throw UnexpectedExceptions.withMessage("The reflection type does not match the requested type");
  }

  @Override
  public List<Channel> findProjectionChannels(String domainName) {
    return List.of();
  }

  @Override
  public List<Reflection> findRelatedReflections(String reflectionName) {
    return List.of();
  }
}
