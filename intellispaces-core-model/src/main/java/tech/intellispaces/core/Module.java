package tech.intellispaces.core;

import java.util.List;

/**
 * The module of intellispaces system.
 */
public interface Module {

  Module start();

  Module start(String[] args);

  Module stop();

  Module upload();

  System system();

  List<Unit> units();

  Unit mainUnit();
}
