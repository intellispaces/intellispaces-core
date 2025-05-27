package tech.intellispaces.core;

class RegisteredReflection implements Reflection {
  private final Reflection originReflection;
  private final Rid rid;

  RegisteredReflection(Reflection originReflection, Rid rid) {
    this.originReflection = originReflection;
    this.rid = rid;
  }

  @Override
  public Rid rid() {
    return rid;
  }

  @Override
  public Domain domain() {
    return originReflection.domain();
  }
}
