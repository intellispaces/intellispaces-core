package tech.intellispaces.core;

import java.util.UUID;

import tech.intellispaces.commons.data.UuidFunctions;

public interface Rids {

  static Rid of(byte[] bytes) {
    return new RidImpl(bytes);
  }

  static Rid of(UUID uuid) {
    return new RidImpl(UuidFunctions.uuidToBytes(uuid), uuid.toString());
  }
}
