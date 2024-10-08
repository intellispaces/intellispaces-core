package intellispaces.framework.core.system.kernel;

import intellispaces.framework.core.system.ObjectHandleWrapper;

class ObjectRegistryImpl implements ObjectRegistry {

  @Override
  public void add(ObjectHandleWrapper handle) {
    KernelObjectHandle innerHandle = new ObjectHandleImpl();
    handle.$init(innerHandle);
  }
}
