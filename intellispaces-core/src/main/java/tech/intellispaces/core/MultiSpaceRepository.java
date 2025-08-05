package tech.intellispaces.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jetbrains.annotations.Nullable;

import tech.intellispaces.commons.exception.NotImplementedExceptions;

/**
 * The multi space ontology repository.
 */
public class MultiSpaceRepository implements OntologyRepository {
  private final Map<String, List<OntologyRepository>> repositories = new HashMap<>();

  public void addRepository(OntologyRepository repository) {
    for (String spaceName : repository.spaces()) {
      repositories.computeIfAbsent(spaceName, k -> new ArrayList<>()).add(repository);
    }
  }

  @Override
  public Collection<String> spaces() {
    return repositories.keySet();
  }

  @Override
  public boolean add(Reflection reflection) {
    for (OntologyRepository repository : selectRepositories(reflection.reflectionName())) {
      if (repository.add(reflection)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public @Nullable Reflection findReflection(String alias) {
    for (OntologyRepository repository : selectRepositories(alias)) {
      Reflection reflection = repository.findReflection(alias);
      if (reflection != null) {
        return reflection;
      }
    }
    return null;
  }

  @Override
  public @Nullable ReflectionPoint findReflection(Rid pid, String domainAlias) {
    for (OntologyRepository repository : selectRepositories(domainAlias)) {
      ReflectionPoint reflection = repository.findReflection(pid, domainAlias);
      if (reflection != null) {
        return reflection;
      }
    }
    return null;
  }

  @Override
  public @Nullable ReflectionPoint findReflection(Rid pid, Rid did) {
    for (List<OntologyRepository> repositories : repositories.values()) {
      for (OntologyRepository repository : repositories) {
        ReflectionPoint reflection = repository.findReflection(pid, did);
        if (reflection != null) {
          return reflection;
        }
      }
    }
    return null;
  }

  @Override
  public @Nullable ReflectionSpace findSpace(String spaceName) {
    for (OntologyRepository repository : selectRepositories(spaceName)) {
      ReflectionSpace reflection = repository.findSpace(spaceName);
      if (reflection != null) {
        return reflection;
      }
    }
    return null;
  }

  @Override
  public @Nullable ReflectionDomain findDomain(String domainName) {
    for (OntologyRepository repository : selectRepositories(domainName)) {
      ReflectionDomain reflection = repository.findDomain(domainName);
      if (reflection != null) {
        return reflection;
      }
    }
    return null;
  }

  @Override
  public Projection findProjection(Rid rid, Rid did, Rid cid) {
    Projection resultProjection = null;
    List<Projection> projections = null;
    for (List<OntologyRepository> repositories : repositories.values()) {
      for (OntologyRepository repository : repositories) {
        Projection projection = repository.findProjection(rid, did, cid);
        if (!projection.isUnknown()) {
          if (resultProjection == null) {
            resultProjection = projection;
          } else {
            if (projections == null) {
              projections = new ArrayList<>();
              projections.add(resultProjection);
              resultProjection = null;
            }
            projections.add(projection);
          }
        }
      }
    }
    if (projections != null) {
      throw NotImplementedExceptions.withCode("KBgxgA");
    }
    return resultProjection != null ? resultProjection : Projections.unknown();
  }

  @Override
  public List<ReflectionDomain> findSubdomains(Rid did) {
    for (List<OntologyRepository> repositories : repositories.values()) {
      for (OntologyRepository repository : repositories) {
        List<ReflectionDomain> subdomains = repository.findSubdomains(did);
        if (subdomains != null) {
          return subdomains;
        }
      }
    }
    return null;
  }

  @Override
  public List<ReflectionDomain> findSubdomains(String domainName) {
    for (OntologyRepository repository : selectRepositories(domainName)) {
      List<ReflectionDomain> subdomains = repository.findSubdomains(domainName);
      if (subdomains != null) {
        return subdomains;
      }
    }
    return null;
  }

  @Override
  public @Nullable ReflectionDomain findBorrowedDomain(String domainAlias) {
    for (OntologyRepository repository : selectRepositories(domainAlias)) {
      ReflectionDomain reflection = repository.findBorrowedDomain(domainAlias);
      if (reflection != null) {
        return reflection;
      }
    }
    return null;
  }

  @Override
  public @Nullable ReflectionChannel findChannel(String channelAlias) {
    for (OntologyRepository repository : selectRepositories(channelAlias)) {
      ReflectionChannel reflection = repository.findChannel(channelAlias);
      if (reflection != null) {
        return reflection;
      }
    }
    return null;
  }

  @Override
  public @Nullable ReflectionChannel findChannel(ReflectionDomain sourceDomain, ReflectionDomain targetDomain) {
    for (List<OntologyRepository> repositories : repositories.values()) {
      for (OntologyRepository repository : repositories) {
        ReflectionChannel channel = repository.findChannel(sourceDomain, targetDomain);
        if (channel != null) {
          return channel;
        }
      }
    }
    return null;
  }

  @Override
  public List<ReflectionChannel> findDomainContextChannels(String domainAlias) {
    for (OntologyRepository repository : selectRepositories(domainAlias)) {
      List<ReflectionChannel> channels = repository.findDomainContextChannels(domainAlias);
      if (channels != null) {
        return channels;
      }
    }
    return List.of();
  }

  @Override
  public List<Reflection> findRelatedReflections(String reflectionAlias) {
    for (OntologyRepository repository : selectRepositories(reflectionAlias)) {
      List<Reflection> relatedReflections = repository.findRelatedReflections(reflectionAlias);
      if (relatedReflections != null) {
        return relatedReflections;
      }
    }
    return List.of();
  }

  @Override
  public List<Reflection> findRelatedReflections(Rid pid, Rid did) {
    for (List<OntologyRepository> repositories : repositories.values()) {
      for (OntologyRepository repository : repositories) {
        List<Reflection> relatedReflections = repository.findRelatedReflections(pid, did);
        if (!relatedReflections.isEmpty()) {
          return relatedReflections;
        }
      }
    }
    return List.of();
  }

  private List<OntologyRepository> selectRepositories(String reflectionName) {
    if (reflectionName == null) {
      return repositories.values().stream()
          .flatMap(Collection::stream)
          .toList();
    }
    String space = SpaceFunctions.getSpaceName(reflectionName);
    return repositories.getOrDefault(space, List.of());
  }
}
