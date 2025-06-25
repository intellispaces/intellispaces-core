package tech.intellispaces.core;

public class PrototypePointBuilder {
  private final Point prototype;
  private Rid pid;

  public PrototypePointBuilder(Point prototype) {
    this.prototype = prototype;
  }

  public PrototypePointBuilder pid(Rid pid) {
    this.pid = pid;
    return this;
  }

  public Point get() {
    return new PointImpl(
        pid != null ? pid : prototype.pid(),
        prototype.domain()
    );
  }
}
