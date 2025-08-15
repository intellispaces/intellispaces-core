package tech.intellispaces.core;

public interface Channels {

  static ReflectionChannelBlank blank() {
    return new ReflectionChannelBlank();
  }

  static ReflectionChannel get(Rid cid) {
    return new ReflectionChannelImpl(cid, null, null, null, null);
  }

  static ReflectionChannel get(Rid cid, ReflectionDomain sourceDomain, ReflectionDomain targetDomain) {
    return new ReflectionChannelImpl(cid, null, null, sourceDomain, targetDomain);
  }
}
