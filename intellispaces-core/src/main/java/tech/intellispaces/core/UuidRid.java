package tech.intellispaces.core;

import java.util.UUID;

import tech.intellispaces.commons.data.UuidFunctions;

class UuidRid implements Rid {
  private final UUID uuid;

  UuidRid(UUID uuid) {
    this.uuid = uuid;
  }

  @Override
  public byte[] raw() {
    return UuidFunctions.uuidToBytes(uuid);
  }

  @Override
  public String toString() {
    return uuid.toString();
  }
}
