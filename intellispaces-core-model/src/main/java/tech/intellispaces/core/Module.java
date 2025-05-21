package tech.intellispaces.core;

import java.util.List;

/**
 * The module of intellispaces system.
 */
public interface Module {

  void start();

  void start(String[] args);

  void stop();

  void upload();

  System system();

  List<Unit> units();

  Unit mainUnit();
}
