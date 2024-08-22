package tech.intellispaces.core.system;


import tech.intellispaces.core.system.shadow.ShadowModule;
import tech.intellispaces.core.system.shadow.ShadowModules;

public interface ModuleProjections {

  static <T> void addContextProjection(String name, Class<T> type, T target) {
    ShadowModule module = ShadowModules.currentSilently();
    if (module == null) {
      return;
    }
    module.projectionRegistry().addContextProjection(name, type, target);
  }

  static void removeContextProjection(String name) {
    ShadowModule module = ShadowModules.currentSilently();
    if (module == null) {
      return;
    }
    module.projectionRegistry().removeContextProjection(name);
  }
}