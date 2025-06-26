package tech.intellispaces.core;

public class PrototypeReflectionBuilder {
  private final Reflection prototype;
  private Rid rid;

  public PrototypeReflectionBuilder(Reflection prototype) {
    this.prototype = prototype;
  }

  public PrototypeReflectionBuilder rid(Rid rid) {
    this.rid = rid;
    return this;
  }

  public Reflection get() {
    return new ReflectionImpl(
        prototype.rtype(),
        rid != null ? rid : prototype.rid(),
        prototype.rname(),
        prototype.domain()
    );
  }
}
