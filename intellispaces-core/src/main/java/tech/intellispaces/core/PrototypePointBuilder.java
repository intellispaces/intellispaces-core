package tech.intellispaces.core;

public class PrototypePointBuilder {
  private final ReflectionPoint prototype;
  private Rid rid;

  public PrototypePointBuilder(ReflectionPoint prototype) {
    this.prototype = prototype;
  }

  public PrototypePointBuilder rid(Rid rid) {
    this.rid = rid;
    return this;
  }

  public ReflectionPoint get() {
    return new ReflectionPointImpl(
        rid != null ? rid : prototype.rid(),
        prototype.alias(),
        prototype.domain(),
        prototype.parentPoints()
    );
  }
}
