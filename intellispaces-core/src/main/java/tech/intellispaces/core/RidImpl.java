package tech.intellispaces.core;

import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

class RidImpl implements Rid {
  private final byte[] bytes;
  private final String string;

  RidImpl(byte[] bytes) {
    this.bytes = bytes;
    this.string = Base64.getEncoder().encodeToString(bytes);
  }

  RidImpl(byte[] bytes, String string) {
    this.bytes = bytes;
    this.string = string;
  }

  @Override
  public byte[] asBytes() {
    return bytes;
  }

  @Override
  public String asString() {
    return string;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null || !Rid.class.isAssignableFrom(other.getClass())) {
      return false;
    }
    Rid rId = (Rid) other;
    return Objects.deepEquals(bytes, rId.asBytes());
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(bytes);
  }
}
