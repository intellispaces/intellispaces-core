package tech.intellispaces.core;

public interface Channels {

  static Channel create(Rid rid, String name) {
    return new ChannelImpl(rid, name, null, null, null);
  }

  static ChannelBuilder build() {
    return new ChannelBuilder();
  }
}
