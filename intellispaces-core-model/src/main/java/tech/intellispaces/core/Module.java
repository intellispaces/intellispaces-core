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

  /**
   * Returns list of guides that are currently registered in the module.
   */
  List<Guide> guides();

  /**
   * Returns the list of guides of the required type that are currently registered in the module.
   *
   * @param guideClass the requested guide class.
   * @return the list of found guides.
   * @param <G> the requested guide type.
   */
  <G> List<G> guide(Class<G> guideClass);
}
